package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import linkedList.LinkedList;
import linkedList.Node;

public class GUI {

  private JFrame frame;
  private JTextField textField_input;
  private JButton btn_reset;
  private JButton btn_check;
  private JTextArea textArea_output;
  private JScrollPane scrollPane_output;

  public GUI() {
    initialize();
    attachListeners();
  }

  private void initialize() {
    frame = new JFrame();
    frame.setResizable(false);
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    btn_reset = new JButton("Reset");
    btn_reset.setBounds(10, 231, 210, 27);
    frame.getContentPane().add(btn_reset);

    btn_check = new JButton("Check");
    btn_check.setBounds(224, 231, 210, 27);
    frame.getContentPane().add(btn_check);

    textField_input = new JTextField();
    textField_input.setBounds(10, 196, 424, 27);
    frame.getContentPane().add(textField_input);
    textField_input.setColumns(10);

    textArea_output = new JTextArea();
    textArea_output.setBounds(10, 11, 422, 173);

    scrollPane_output = new JScrollPane(textArea_output);
    scrollPane_output.setBounds(10, 12, 424, 172);
    frame.getContentPane().add(scrollPane_output);
  }

  private void attachListeners() {
    btn_check.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String text = textField_input.getText();

        if (text.equals("")) {
          textArea_output.append("No text to check!\n");
        } else {
          LinkedList list = generateLinkedList(text);

          if (checkPalindrome(list)) {
            textArea_output.append(text + " is a palindrome.");
          } else {
            textArea_output.append(text + " is not a palindrome.");
          }
        }
      }
    });

    btn_reset.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        textField_input.setText("");
        textArea_output.setText("");
      }
    });
  }

  private boolean checkPalindrome(LinkedList list) {
    Node head = list.getHead(), tail = list.getTail();

    // if the list is empty
    if (head == null)
      return false;

    // if there's only one element in the linked list
    if (head.equals(tail))
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

  private LinkedList generateLinkedList(String text) {
    LinkedList list = new LinkedList();

    for (int index = text.length() - 1; index >= 0; index--) {
      Node letterNode = new Node(text.charAt(index));
      list.addToHead(letterNode);
    }

    return list;
  }

  public JFrame getFrame() { return frame; }
}
