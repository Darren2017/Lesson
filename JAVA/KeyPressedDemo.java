import java.awt.*;
import java.awt.event.*;

public class KeyPressedDemo {
  Label label;

  public KeyPressedDemo() {
    Frame frame = new Frame();
    TextField textField1 = new TextField();
    TextField textField2 = new TextField();
    TextField textField3 = new TextField();
    frame.add(textField1, BorderLayout.NORTH);
    frame.add(textField2, BorderLayout.CENTER);
    frame.add(textField3, BorderLayout.SOUTH);
    label = new Label();
    frame.add(label, BorderLayout.CENTER);
    frame.setSize(450, 400);
    frame.setVisible(true);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
    textField1.addKeyListener(new KeyAdapter() {
      /**
       * When you type the character "a" into the text field you will see
       * an information dialog box
       */
      public void keyTyped(KeyEvent ke) {
        char keyChar = ke.getKeyChar();
        if (keyChar == 'a') {
          System.out.println("You typed 'a'");
        }
      }

      /**
       * When you type the character "b" into the text field you will see
       * an information dialog box
       */
      public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        if (keyCode == 66) {
          System.out.println("You Typed b");
        }
      }

      /**
       * When you type the character "c" into the text field you will see
       * an information dialog box
       */
      public void keyReleased(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        if (keyCode == 67) {
          System.out.println("You Typed c");
        }
      }
    });
    textField2.addKeyListener(new KeyAdapter() {
      /**
       * When you type the character "a" into the text field you will see
       * an information dialog box
       */
      public void keyTyped(KeyEvent ke) {
        char keyChar = ke.getKeyChar();
        if (keyChar == 'a') {
          System.out.println("You typed 'a'");
        }
      }

      /**
       * When you type the character "b" into the text field you will see
       * an information dialog box
       */
      public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        if (keyCode == 66) {
          System.out.println("You Typed b");
        }
      }

      /**
       * When you type the character "c" into the text field you will see
       * an information dialog box
       */
      public void keyReleased(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        if (keyCode == 67) {
          System.out.println("You Typed c");
        }
      }
    });
    textField3.addKeyListener(new KeyAdapter() {
      /**
       * When you type the character "a" into the text field you will see
       * an information dialog box
       */
      public void keyTyped(KeyEvent ke) {
        char keyChar = ke.getKeyChar();
        if (keyChar == 'a') {
          System.out.println("You typed 'a'");
        }
      }

      /**
       * When you type the character "b" into the text field you will see
       * an information dialog box
       */
      public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        if (keyCode == 66) {
          System.out.println("You Typed b");
        }
      }

      /**
       * When you type the character "c" into the text field you will see
       * an information dialog box
       */
      public void keyReleased(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        if (keyCode == 67) {
          System.out.println("You Typed c");
        }
      }
    });
  }

  public static void main(String[] args) {
    new KeyPressedDemo();
  }
}