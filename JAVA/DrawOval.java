import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public  class  DrawOval extends JFrame implements ActionListener{
    JButton bnt1 =new JButton("画圆");
    JLabel jl1 = new JLabel("输入圆的位置坐标"), jl2 = new JLabel("输入圆的半径");
    JTextField jtf1 = new JTextField(4), jtf2 = new JTextField(4), jtf3 = new JTextField(4);

    DrawOval(){
        super("绘制圆形应用程序");
        setSize(700,420);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(jl1);
        add(jtf1);
        add(jtf2);
        add(jl2);
        add(jtf3);
        add(bnt1);
        validate();
        bnt1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        JButton bt=(JButton)e.getSource();
        Graphics g=getGraphics();
        g.drawOval (Integer.parseInt(jtf1.getText()), Integer.parseInt(jtf2.getText()), Integer.parseInt(jtf3.getText()), Integer.parseInt(jtf3.getText())); 
    }

    public static void main(String args[]){
        new DrawOval();
    }

}
