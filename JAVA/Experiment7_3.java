import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Experiment7_3 extends JFrame{
    private static final long serialVersionUID = 1L;
    int DEFAULT_WIDTH = 600;
    int DEFAULT_HEIGHT = 400;
    private JLabel label;
    private JCheckBox boldCheckbox;
    private JCheckBox italicCheckbox;
    public Experiment7_3(){
        this.getContentPane().setBackground(Color.YELLOW);
        setTitle("复选框");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        label = new JLabel("请注意观察宋体的变化",JLabel.CENTER);
        label.setFont(new Font("宋体",Font.PLAIN, 32));
        add(label, BorderLayout.CENTER);
        ActionListener actionListener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int mode = 0;
                if(boldCheckbox.isSelected()) mode += Font.BOLD;
                if(italicCheckbox.isSelected()) mode += Font.ITALIC;                
                label.setFont(new Font("宋体", mode, 32));
            }
        };
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        boldCheckbox = new JCheckBox("粗体");
        boldCheckbox.addActionListener(actionListener);
        buttonPanel.add(boldCheckbox);
        italicCheckbox = new JCheckBox("斜体");
        italicCheckbox.addActionListener(actionListener);
        buttonPanel.add(italicCheckbox);
    }    
    public static void main(String[] args) {
        Experiment7_3 frame = new Experiment7_3();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}