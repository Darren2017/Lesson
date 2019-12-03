import java.awt.Image;
import javax.swing.*;

public  class JMenuDemo{
    public static void main(String[] args){
        JMenuDemo gui = new JMenuDemo();
        gui.go();
    }

public void go(){
    JFrame frame = new JFrame("菜单栏");
    JMenuBar mbar = new JMenuBar();
    frame.setJMenuBar(mbar);
    JMenu menu1 = new JMenu("文件(F)");
    JMenu menu2 = new JMenu("编辑(E)");
    JMenu menu3 = new JMenu("帮助(H)");
    mbar.add(menu1);
    mbar.add(menu2);
    mbar.add(menu3);
    JMenuItem F1 = new JMenuItem("打开");
    JMenuItem F2 = new JMenuItem("保存");
    JMenuItem F3 = new JMenuItem("退出");
    ImageIcon a = new ImageIcon("pic1.png");
    a.setImage(a.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
    F1.setIcon(a);
    ImageIcon b = new ImageIcon("pic2.png");
    a.setImage(b.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
    F2.setIcon(b);
    menu1.add(F1);
    menu1.add(F2);
    menu1.addSeparator();
    menu1.add(F3);
    JMenuItem E1 = new JMenuItem("剪切");
    JMenuItem E2 = new JMenuItem("复制");
    JMenuItem E3 = new JMenuItem("粘贴");
    menu2.add(E1);
    menu2.add(E2);
    menu2.addSeparator();
    menu2.add(E3);
    JMenu menu4 = new JMenu("帮助主题");
    JMenuItem H1 = new JMenuItem("关于记事本");
    JMenuItem H2 = new JMenuItem("关于计算器");
    menu4.add(H1);
    menu4.addSeparator();
    menu4.add(H2);
    menu3.add(menu4);
    JTextArea text = new JTextArea();
    frame.getContentPane().add(text);
    frame.setSize(400,300);
    frame.setVisible(true);
}
}