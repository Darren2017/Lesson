import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Btu extends JButton {
    Btu(String Bname, ImageIcon IconName) {
        super(Bname, IconName);
        this.setPreferredSize(new Dimension(150, 50));
    }
}

class Experiment7 {
    public Experiment7() {
    }

    public static void main(String[] args) {
        new BtnIcon();
    }
}

class BtnIcon extends JFrame implements ActionListener {
    Btu jbtnn = new Btu("按钮1", (ImageIcon)null);
    Btu jbtn = new Btu("按钮2", new ImageIcon("/Users/darren/Desktop/win.jpg"));

    BtnIcon() {
        this.setSize(1000, 200);
        this.setVisible(true);
        this.setTitle("测试类按钮");
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        this.add(this.jbtnn);
        this.add(this.jbtn);
        this.validate();
        this.jbtnn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Message mes = new Message();
    }
}

class Message extends JFrame {
    JButton jbtnn = new JButton("确定");

    Message() {
        super("消息");
        Dimension preferredSize = new Dimension(10,10);
        this.setPreferredSize(preferredSize);
        this.setSize(1000, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        this.add(this.jbtnn);
        JLabel label = new JLabel("你按了按钮1",JLabel.CENTER);
        label.setSize(100,350);
        this.getContentPane().add(label);
        this.validate();
    }
}