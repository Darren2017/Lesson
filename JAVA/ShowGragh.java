import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShowGragh implements ActionListener{
    JFrame frame = new JFrame("图片浏览器");
    private JMenuItem fileOpen = new JMenuItem("open");
    private JMenuItem fileExit = new JMenuItem("close");
    private JLabel l1 = new JLabel();

    public void go(){
        JMenu file = new JMenu("File");
        file.add(fileOpen);
        fileOpen.setEnabled(true);
        file.addSeparator();
        fileExit.setEnabled(true);
        JMenuBar bar = new JMenuBar();
        bar.add(file);

        frame.setJMenuBar(bar);
        fileExit.addActionListener(this);
        fileOpen.addActionListener(this);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(l1);
    }

        public static  void main(String[] args){
            ShowGragh demo1 = new ShowGragh();
            demo1.go();
        }
        
        public void actionPerformed(ActionEvent e){
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(null);
            String str = file.getSelectedFile().toString();
            ImageIcon icon = new ImageIcon(str);
            l1.setIcon(icon);
        }
    }
