package app;

import linkedList.LinkedList;
import linkedList.Node;

public class Engine {
  public static boolean checkPalindrome(LinkedList list) {
    Node head = list.getHead(), tail = list.getTail();

    // if the list is empty
    if (head == null)
      return false;

    // if there's only one element in the linked list
    if (head == tail)
      return true;

    int maxChecks = list.getLength() / 2, currentChecks = 0;

    while (currentChecks <= maxChecks) {
      if (!(head.getData() == tail.getData()))
        return false;

      head = head.getNext();
      tail = tail.getPrev();

      currentChecks++;
    }

    return true;
  }

  private static boolean isSpecialCharacter(String s) {
    return (s == null) ? false : s.matches("[^A-Za-z0-9]");
  }

  public static LinkedList generateLinkedList(String text) {
    LinkedList list = new LinkedList();
    String lowerText = text.toLowerCase();

    for (int index = text.length() - 1; index >= 0; index--) {
      if (!isSpecialCharacter(String.valueOf(text.charAt(index)))) {
        Node letterNode = new Node(lowerText.charAt(index));
        list.addToHead(letterNode);
      }
    }

    return list;
  }
}
