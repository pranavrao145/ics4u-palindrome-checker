package linkedList;

public class Node {
  private char data;
  private Node prev, next;

  public Node(char data) { this.data = data; }

  public int getData() { return data; }

  public void setData(char data) { this.data = data; }

  public Node getPrev() { return prev; }

  public void setPrev(Node prev) { this.prev = prev; }

  public Node getNext() { return next; }

  public void setNext(Node next) { this.next = next; }
}
