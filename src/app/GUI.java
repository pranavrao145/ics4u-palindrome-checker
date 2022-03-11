package app;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {

  private JFrame frame;
  private JTextField textField_input;
  private JButton btn_reset;
  private JScrollPane scrollPane_output;
  private JTextArea textArea_output;

  /**
   * Create the application.
   */
  public GUI() { initialize(); }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setResizable(false);
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    btn_reset = new JButton("Reset");
    btn_reset.setBounds(10, 231, 210, 27);
    frame.getContentPane().add(btn_reset);

    JButton btn_check = new JButton("Check");
    btn_check.setBounds(224, 231, 210, 27);
    frame.getContentPane().add(btn_check);

    textField_input = new JTextField();
    textField_input.setBounds(10, 196, 424, 27);
    frame.getContentPane().add(textField_input);
    textField_input.setColumns(10);

    textArea_output = new JTextArea();
    textArea_output.setBounds(10, 12, 424, 172);
    textArea_output.setEditable(false);

    scrollPane_output = new JScrollPane(textArea_output);
    frame.getContentPane().add(scrollPane_output);
  }

  public JFrame getFrame() { return frame; }
}
