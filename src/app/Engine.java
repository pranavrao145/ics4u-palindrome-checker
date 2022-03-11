/******************************************************************************
Program: Engine Class (Palindrome Checker)

Description: This is the engine for this app. This class contains all of the
utility methodality for this app, including the methods to check the
palindrome and generate a linked list from a string.

Author: Pranav Rao

Date: March 11, 2022
*******************************************************************************/

package app; // this package is part of the app package

// import linked list classes  from linkedList package
import linkedList.LinkedList;
import linkedList.Node;

public class Engine {
  /**
   * This method checks if the given linked list contains nodes that form a
   * palindrome
   *
   * @param list - the list to check
   * @return false if the list does not contain a palindrome, true otherwise
   */
  public static boolean checkPalindrome(final LinkedList list) {
    // get the head and the tail to being traversing through the list from
    // either end
    Node head = list.getHead(), tail = list.getTail();

    // if the head is null (nothing in the list), return true because an empty
    // set of characters is technically a palindrome
    if (head == null)
      return true;

    /* The idea for the algorithm is to start at the head and the tail, and keep
     * moving them further towards the center of the list until they equal each
     * other. Along the way, we will check if each pair of nodes (which are the
     * same distance from either end of the word) are the same.
     */

    // while the head does not equal the tail
    while (head != tail) {
      if (head.getData() !=
          tail.getData()) // if the pair of nodes do not hold the same value
        return false; // return false to signify this list does not contain a
                      // palindrome

      head = head.getNext(); // move the head variable to the next node
      tail = tail.getPrev(); // move the tail variable to the previous node
    }

    return true; // if we manage to traverse the entire list, return true to
                 // signify that this list does contain a palindrome
  }

  /**
   * This method takes a string and generates a linked list from it, with each
   * character in their own node.
   *
   * @param text - the string from which to generate the list
   * @return - the new linked list
   */
  public static LinkedList generateLinkedList(final String text) {
    final LinkedList list =
        new LinkedList(); // create a new blank linked list to populate
    final String fixedText =
        text.replaceAll("[^A-Za-z0-9_-]", "")
            .toLowerCase(); // get rid of all special characters and spaces in
                            // the string and store it in a new fixedText
                            // variable

    // for each character in the fixed text, add the character to the linked
    // list (in a backwards order, due to the fact that the list only adds to
    // the head and not the tail)
    for (int index = fixedText.length() - 1; index >= 0; index--) {
      list.addToHead(new Node(fixedText.charAt(index)));
    }

    return list; // return the newly formed list
  }
}
