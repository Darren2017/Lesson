import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Experiment7_2 {
    public Experiment7_2() {
    }
    public static void main(String[] args) {
        new BtnIcon();
    }
}

class BtnIcon extends JFrame implements ActionListener {
    JRadioButton j1 = new JRadioButton("红色", (ImageIcon)null);
    JRadioButton j2 = new JRadioButton("绿色", (ImageIcon)null);
    JRadioButton j3 = new JRadioButton("蓝色", (ImageIcon)null);
    ButtonGroup group = new ButtonGroup();
    BtnIcon() {
        this.setSize(1000, 200);
        this.setVisible(true);
        this.setTitle("单选框");
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        group.add(j1);
        group.add(j2);
        group.add(j3);
        this.add(this.j1);
        this.add(this.j2);
        this.add(this.j3);
        this.validate();
        this.j1.addActionListener(this);
        this.j2.addActionListener(this);
        this.j3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==j1) {
            this.getContentPane().setBackground(Color.RED);
        }
        if(e.getSource()==j2) {
            this.getContentPane().setBackground(Color.GREEN);
        }
        if(e.getSource()==j3) {
            this.getContentPane().setBackground(Color.BLUE);
	    }
    }
}
