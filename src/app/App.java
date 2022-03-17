/******************************************************************************
Program: App Class (Palindrome Checker)

Description: This is the driver code for this palindrome checker.
This class' main method will start the entire program.

Author: Pranav Rao

Date: March 11, 2022

LOCATIONS OF FULFILLED REQUIREMENTS:
- Check button (listener and logic): app/GUI.java:96
- Reset button (listener and logic): app/GUI.java:131
- Quit button (listener and logic): app/GUI.java:139
- User friendliness (error handling and messages): app/GUI.java:103
- Doubly linked list: linkedList/LinkedList.java
- Works on a word, numbers: test "rac3car"
- Works on a sentence with punctuation, caps, spacing: test "Was it a rat I
saw?"
*******************************************************************************/

package app; // this package is part of the app package

import java.awt.EventQueue;

public class App {
  /**
   * This method is the driver code for the entire program. It creates a new GUI
   * and runs the app.
   *
   * @param args - command line arguments for this program
   */
  public static void main(final String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          new GUI();
        } catch (final Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
