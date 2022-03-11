package linkedList;

public class LinkedList {
  private Node head;
  private int length;

  public LinkedList() { length = 0; }

  public void addToHead(Node node) {
    if (this.head == null) {
      this.head = node;
    } else {
      node.setNext(this.head);
      this.head.setPrev(node);

      this.head = node;
    }

    length++;
  }

  public Node getTail() {
    Node tmp = this.head;

    while (tmp.getNext() != null) {
      tmp = tmp.getNext();
    }

    return tmp;
  }

  public Node getHead() { return head; }

  public void setHead(Node head) { this.head = head; }

  public int getLength() { return length; }

  public void setLength(int length) { this.length = length; }
}
