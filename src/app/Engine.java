/******************************************************************************
Program: Engine Class (Palindrome Checker)

Description: This is the engine for this app. This class contains all of the
utility functionality for this app, including the methods to check the
palindrome and generate a linked list from a string.

Author: Pranav Rao

Date: March 11, 2022
*******************************************************************************/

package app; // this package is part of the app class

// import linked list classes  from linkedList package
import linkedList.LinkedList;
import linkedList.Node;

public class Engine {
  /**
   * This function checks if the given linked list contains nodes that form a
   * palindrome
   *
   * @param list - the list to check
   * @return false if the list does not contain a palindrome, true otherwise
   */
  public static boolean checkPalindrome(LinkedList list) {
    // get the head and the tail to being traversing through the list from
    // either end
    Node head = list.getHead(), tail = list.getTail();

    // if the list is empty, the head does not exist
    if (head == null)
      return false;

    // if there's only one element in the linked list, the head and the tail are
    // the same
    if (head == tail)
      return true;

    /*
     * The idea for the algorithm is to start at either end of the list, and
     * calculate the max number of characters in either direction we will have
     * to check to ensure this is a palindrome. This number is length of the
     * palindrome / 2, no matter if the palindrome is even digits or odd. We
     * will keep a current number of checks, and continue checking inwards until
     * when we are about to exceed the max amount of checks. If we successfully
     * make it to the middle, the list is a palindrome. If not, and we find two
     * characters that are the same amount of characters away from either end of
     * the list but are not the same, the list is not a palindrome and we return
     * false.
     */

    // calculate the max checks and intitialize the current checks at 0
    int maxChecks = list.getLength() / 2, currentChecks = 0;

    // while we have not execeeded the max number of checks
    while (currentChecks <= maxChecks) {
      // if the two characters the same distance from either end of the
      // palindrome are not the same, return false
      if (!(head.getData() == tail.getData()))
        return false;

      head = head.getNext(); // the pointer that was initially head needs to
                             // move to the next node
      tail = tail.getPrev(); // the pointer that was initially head needs to
                             // move to the previous node

      currentChecks++; // add one to the current checks
    }

    return true; // if we reach the middle of the list without any problems, the
                 // list contains a palindrome
  }

  /**
   * This method checks if the character given is a special character
   * (anything that's not a lowercase, capital, or a number)
   *
   * @param s - the string to check (will be a character in this case)
   * @return true if the string is special, else false
   */
  private static boolean isSpecialCharacter(String s) {
    return (s == null) ? false
                       : s.matches("[^A-Za-z0-9]"); // use regex to check the
                                                    // condition described above
  }

  /**
   * This function takes a string and generates a linked list from it, with each
   * character in their own node.
   *
   * @param text - the string from which to generate the list
   * @return - the new linked list
   */
  public static LinkedList generateLinkedList(String text) {
    LinkedList list =
        new LinkedList(); // create a new blank linked list to populate
    String lowerText = text.toLowerCase(); // make the text lowercase to prevent
                                           // errors due to capitalization

    // traverse indexes of the string starting from the end and going to the
    // beginning (backwards). This is because the linked list add function adds
    // to the head, not to the tail (see linkedList/LinkedList class)
    for (int index = text.length() - 1; index >= 0; index--) {
      // if the character at the current index is NOT a specical character
      if (!isSpecialCharacter(String.valueOf(text.charAt(index)))) {
        Node letterNode = new Node(lowerText.charAt(
            index)); // create a node with the character as the data
        list.addToHead(letterNode); // add the newly created node to the head of
                                    // hte linked list
      }
    }

    return list; // return the newly formed list
  }
}
