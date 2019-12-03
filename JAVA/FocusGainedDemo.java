import java.awt.*;
import java.awt.event.*;

public class FocusGainedDemo {
  Label label;

  public FocusGainedDemo() {
    Frame frame = new Frame();
    Button Okay = new Button("Okay");
    Button Cancel = new Button("Cancel");
    Okay.addFocusListener(new MyFocusListener());
    Cancel.addFocusListener(new MyFocusListener());
    frame.add(Okay, BorderLayout.NORTH);
    frame.add(Cancel, BorderLayout.SOUTH);
    label = new Label();
    frame.add(label, BorderLayout.CENTER);
    frame.setSize(450, 400);
    frame.setVisible(true);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  }

  public class MyFocusListener implements FocusListener {
    public void focusGained(FocusEvent fe) {
      Button button = (Button) fe.getSource();
      label.setText(button.getLabel());
    }

    @Override
    public void focusLost(FocusEvent arg0) {
      System.out.println("focusLost");
    }
  }

  public static void main(String[] args) {
    new FocusGainedDemo();
  }
}