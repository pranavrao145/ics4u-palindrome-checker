/******************************************************************************
Program: GUI (Palindrome Checker)

Description: This is GUI for this app. This class contains all of the
methods to run the GUI of the app, such as to draw and update the GUI,
as well as to attach listeners.

Author: Pranav Rao

Date: March 11, 2022
*******************************************************************************/

package app; // this package is part of the app package

// import all necessary swing components
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// import linked list classe  from linkedList package
import linkedList.LinkedList;

public class GUI {
  // the following set of fields represent the various GUI components used in
  // this App. To simplify the identification of components, all components are
  // named using this convention: componentType_componentName
  // For example, a button to check would be called btn_check

  private JFrame frame;
  private JTextField textField_input;
  private JButton btn_reset, btn_check;
  private JTextArea textArea_output;
  private JScrollPane scrollPane_output;

  /**
   * This is a constructor for the GUI. When the GUI is made in the App class,
   * this method will be called.
   */
  public GUI() {
    setupGUI();        // sets up and draws the GUI
    attachListeners(); // attaches the listeners to various GUI components

    frame.setVisible(true); // sets the frame to visible so the user can see it
  }

  /**
   * This method draws the GUI itself (i.e. it initializes the components
   * above).
   */
  private void setupGUI() {
    frame = new JFrame();
    frame.setResizable(false);
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(
        JFrame.EXIT_ON_CLOSE); // exit program when GUI is closed
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
  }

  /**
   * This method attaches the appropriate listeners to all components defined
   * above
   */
  private void attachListeners() {
    // add an action listener to the check button to update the textarea with if
    // the string given is a palindrome or not
    btn_check.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String text =
            textField_input.getText(); // get the text from the text field

        if (text.equals("")) { // if the text is nothing (no text was entered)
          textArea_output.append(
              "No text to check!\n"); // inform the user of the empty text field
                                      // in the textarea and do nothing else
        } else { // if there is text entered in the textarea
          LinkedList list = Engine.generateLinkedList(
              text); // generate a linked list from the text given

          // if the nodes of the linked list contain a palindrom
          if (Engine.checkPalindrome(list)) {
            textArea_output.append(
                text +
                " is a palindrome.\n"); // inform the user that the string is a
                                        // palindrome via the textarea
          } else {
            textArea_output.append(
                text +
                " is not a palindrome.\n"); // inform the user that the string
                                            // is a palindrome via the textarea
          }
        }
      }
    });

    // add an action listener to the reset button to clear the textarea and the
    // input text field
    btn_reset.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        textField_input.setText(""); // clear the text field
        textArea_output.setText(""); // clear the textarea
      }
    });
  }
}
