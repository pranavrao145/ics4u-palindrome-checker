/******************************************************************************
Program: App Class (Palindrome Checker)

Description: This is the driver code for this palindrome checker.
This class' main method will start the entire program.

Author: Pranav Rao

Date: March 11, 2022

LOCATIONS OF FULFILLED REQUIREMENTS:
*******************************************************************************/

package app; // this package is part of the app class

import java.awt.EventQueue;

public class App {
  /**
   * This method is the driver code for the entire program. It creates a new GUI
   * and runs the app.
   *
   * @param args - command line arguments for this program
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          new GUI();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
