import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Experiment7_5 extends JFrame { 
    private JPanel pnShowColor; 
 
    public Experiment7_5() { 
        JPanel pnBasic = new JPanel(); 
        pnBasic.setLayout(new BorderLayout()); 
        JButton btnSelectColor = new JButton("打开颜色对话框"); 
        pnBasic.add(btnSelectColor, BorderLayout.NORTH); 
        pnShowColor = new JPanel(); 
        pnBasic.add(pnShowColor, BorderLayout.CENTER); 
        btnSelectColor.addActionListener(new ActionListener() { 
 
            @Override 
            public void actionPerformed(ActionEvent e) { 
                Color color = JColorChooser.showDialog(Experiment7_5.this, "调色板", Color.WHITE); 
                pnShowColor.setBackground(color);
            }
        }); 
        setContentPane(pnBasic); 
        setTitle("带颜色对话框的窗口"); 
        setBounds(200, 200, 400, 300); 
        setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    } 
 
    public static void main(String[] args) { 
        new Experiment7_5(); 
    } 
} 