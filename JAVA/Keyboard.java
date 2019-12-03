import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
class EX extends JFrame implements ActionListener, FocusListener{

    JTextField txt1=new  JTextField(6);
    JTextField txt2=new  JTextField(6);
    JTextField txt3=new  JTextField(6);
    Container container=getContentPane();
    JLabel lb=new JLabel(" 序列号: ");
    JButton bn=new JButton(" 确定");

    EX(){ 
        setSize(350,150);
        setVisible(true);
        setTitle(" 输入序列号");
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        setLayout(new FlowLayout());
        add(txt1);
        add(txt2);
        add(txt3);
        add(bn);
        add(lb);
        container.add(lb);
        validate();
        bn.addActionListener(this);
    }

    public void focusGained(FocusEvent e){
        JTextField text=(JTextField)(e.getSource());
        text.setText(null);
    }

    @Override
    public void focusLost(FocusEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        lb.setText("序列号：" + txt1.getText() + txt2.getText() + txt3.getText());
        
    }

}

public class Keyboard{
    public static void main(String[] args) {
        new EX();
    }
}
