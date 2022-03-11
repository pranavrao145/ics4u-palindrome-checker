package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import linkedList.LinkedList;

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
    textArea_output.setEditable(false);
    textArea_output.setBounds(10, 11, 422, 173);

    scrollPane_output = new JScrollPane(textArea_output);
    scrollPane_output.setBounds(10, 12, 424, 172);
    frame.getContentPane().add(scrollPane_output);

    frame.setVisible(true);
  }

  private void attachListeners() {
    btn_check.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String text = textField_input.getText();

        if (text.equals("")) {
          textArea_output.append("No text to check!\n");
        } else {
          LinkedList list = Engine.generateLinkedList(text);

          if (Engine.checkPalindrome(list)) {
            textArea_output.append(text + " is a palindrome.\n");
          } else {
            textArea_output.append(text + " is not a palindrome.\n");
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
}
