import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Exam extends JFrame implements ActionListener{
    JButton j1 = new JButton("计算圆的面积");
    Label l1 = new Label("请输入圆的半径");
    Label l2 = new Label("圆的面积为：");
    JTextField t1 = new JTextField(4);

    Exam(){
        super("计算圆面积");
        setSize(300,150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(l1);
        add(t1);
        add(j1);
        add(l2);
        validate();
        j1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent arg0) {
        double a = (3.14 * Double.parseDouble(t1.getText()) * Double.parseDouble(t1.getText()));
        l2.setText("圆的面积为：" + Double.toString(a));
    }

    public static void main(String[] args){
        new Exam();
    }
}