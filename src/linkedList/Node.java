/******************************************************************************
Program: Node class (Palindrome Checker)

Description: This is a node class. It represents one node of the linked list and
it contains some data, as well as a pointer to the next node and the previous
node in the list.

Author: Pranav Rao

Date: March 11, 2022
*******************************************************************************/

package linkedList; // this package is part of the linkedList class

public class Node {
  private char
      data; // create a data attribute which will store a single character
  private Node prev, next; // create two attributes which will store references
                           // to the previous node and a next node in the list

  /**
   * Constructor method - this method is called when an object of this class
   * is made. This constructor takes a parameter for each of the
   * available attributes.
   *
   * @param data - the data with which to make the new Node
   */
  public Node(final char data) { this.data = data; }

  // getters and setters
  public int getData() { return data; }

  public void setData(final char data) { this.data = data; }

  public Node getPrev() { return prev; }

  public void setPrev(final Node prev) { this.prev = prev; }

  public Node getNext() { return next; }

  public void setNext(final Node next) { this.next = next; }
}
