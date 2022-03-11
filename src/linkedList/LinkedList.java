/******************************************************************************
Program: Linked List class (Palindrome Checker)

Description: This is a linked list class. It represents a linked list, and
stores the head node in the list as well as the current length of the list (for
convenience). Author: Pranav Rao

Date: March 11, 2022
*******************************************************************************/

package linkedList; // this package is part of the linkedList class

public class LinkedList {
  private Node head;  // create a head attribute which stores the head of the
                      // linked list
  private int length; // create an attribute to store the current length of the
                      // linked list

  /**
   * Constructor method - this method is called when an object of this class
   * is made. This constructor takes no parameters.
   */
  public LinkedList() {
    length = 0; // initialize the length of the new list to 0
  }

  /**
   * This method is used to add a given node to the head of the list.
   *
   * @param node - the node to add to the list
   */
  public void addToHead(final Node node) {
    if (this.head ==
        null) {         // if the current head is null (if the list is empty)
      this.head = node; // make this node the new head node of the list
    } else { // if there is already a head in the list (there are already nodes
             // in the list)
      node.setNext(this.head); // make the next reference of this node the
                               // current head node
      this.head.setPrev(
          node); // set the previous reference of the head node to this node

      this.head = node; // make this node the new head node
    }

    length++; // add one to the length of the list
  }

  /**
   * This method is used to return the tail of the linked list (the last node,
   * where the next reference of the node is null)
   *
   * @return the tail node in the list
   */
  public Node getTail() {
    Node tmp = this.head; // create a temporary variable and store the current
                          // head of the list

    // while the node after the node stored in the tmp variable still exists
    while (tmp.getNext() != null) {
      tmp = tmp.getNext(); // move the tmp variable to the next node in the list
    }

    // at this point, tmp is the last node in the list (where the next node is
    // null); so, returning tmp gives the tail node of this linked list
    return tmp;
  }

  // getters and setters

  public Node getHead() { return head; }

  public void setHead(final Node head) { this.head = head; }

  public int getLength() { return length; }

  public void setLength(final int length) { this.length = length; }
}
