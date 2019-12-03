import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Experiment8_2 implements ActionListener{
    GridBagLayout gridBag = new GridBagLayout();    // 布局管理器
    GridBagConstraints c = null;
    JFrame jframe = new JFrame("个人信息调查");
    JPanel panel = new JPanel(gridBag);
    ButtonGroup group = new ButtonGroup();
    JLabel label1 = new JLabel("年龄段：");
    JLabel label2 = new JLabel("兴趣爱好：");
    JLabel label3 = new JLabel("调查的结果：");
    JRadioButton j1 = new JRadioButton("5-15周岁");
    JRadioButton j2 = new JRadioButton("16-25周岁");
    JRadioButton j3 = new JRadioButton("26-35周岁");
    JRadioButton j4 = new JRadioButton("36-45周岁");
    JRadioButton j5 = new JRadioButton("46-55周岁");
    JButton j6 = new JButton("提交");
    JButton j7 = new JButton("清空");
    JCheckBox Checkbox1 = new JCheckBox("上网聊天/交友");
    JCheckBox Checkbox2 = new JCheckBox("体育/户外/健身");
    JCheckBox Checkbox3 = new JCheckBox("汽车/购物");
    JCheckBox Checkbox4 = new JCheckBox("旅游/度假");
    JCheckBox Checkbox5 = new JCheckBox("时尚服装/化妆品");
    String age, intrest, res;


    public Experiment8_2() {
        jframe.setSize(800, 250);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        group.add(j1);
        group.add(j2);
        group.add(j3);
        group.add(j4);
        group.add(j5);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        gridBag.addLayoutComponent(label1, c);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        gridBag.addLayoutComponent(j1, c);
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 1;
        gridBag.addLayoutComponent(j2, c);
        c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 1;
        gridBag.addLayoutComponent(j3, c);
        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 1;
        gridBag.addLayoutComponent(j4, c);
        c = new GridBagConstraints();
        c.gridx = 5;
        c.gridy = 1;
        gridBag.addLayoutComponent(j5, c);
        panel.add(j1); 
        panel.add(j2);
        panel.add(j3);
        panel.add(j4);
        panel.add(j5);

        j1.addActionListener(this);
        j2.addActionListener(this);
        j3.addActionListener(this);
        j4.addActionListener(this);
        j5.addActionListener(this);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        gridBag.addLayoutComponent(label2, c);

        c = new GridBagConstraints();
        c.gridx = 5;
        c.gridy = 3;
        gridBag.addLayoutComponent(Checkbox1, c);
        panel.add(Checkbox1);
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 3;
        gridBag.addLayoutComponent(Checkbox2, c);
        panel.add(Checkbox2);
        
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 3;
        gridBag.addLayoutComponent(Checkbox3, c);
        panel.add(Checkbox3);
        
        c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 3;
        gridBag.addLayoutComponent(Checkbox4, c);
        panel.add(Checkbox4);
        
        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 3;
        gridBag.addLayoutComponent(Checkbox5, c);
        panel.add(Checkbox5);

        Checkbox1.addActionListener(actionListener);
        Checkbox2.addActionListener(actionListener);
        Checkbox3.addActionListener(actionListener);
        Checkbox4.addActionListener(actionListener);
        Checkbox5.addActionListener(actionListener);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(label3, c);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);

        c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 5;
        gridBag.addLayoutComponent(j6, c);
        panel.add(j6);

        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 5;
        gridBag.addLayoutComponent(j7, c);
        panel.add(j7);

        panel.add(j6);
        panel.add(j7);
        j7.addActionListener(this);

        jframe.setContentPane(panel);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }

    public static void main(String[] args) {
        new Experiment8_2();
    }

    ActionListener actionListener = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            intrest = "";
            if(Checkbox1.isSelected()){ 
                intrest += "上网聊天/交友";
                res = "你是一个" + age + "的人，你比较喜欢" + intrest;
                label3.setText("调查的结果：" + res);
            }
            if(Checkbox2.isSelected()){
                intrest += "体育/户外/健身";
                res = "你是一个" + age + "的人，你比较喜欢" + intrest;
                label3.setText("调查的结果：" + res);
            }
            if(Checkbox3.isSelected()){
                intrest += "汽车/购物";
                res = "你是一个" + age + "的人，你比较喜欢" + intrest;
                label3.setText("调查的结果：" + res);
            }
            if(Checkbox4.isSelected()){
                intrest += "旅游/度假";
                res = "你是一个" + age + "的人，你比较喜欢" + intrest; 
                label3.setText("调查的结果：" + res);
            }
            if(Checkbox5.isSelected()){ 
                intrest += "时尚服装/化妆品";
                res = "你是一个" + age + "的人，你比较喜欢" + intrest;
                label3.setText("调查的结果：" + res);
            }            
        }
    };
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==j1) {
            age = "5-15岁";
            res = "你是一个" + age + "的人，你比较喜欢" + intrest;
            label3.setText("调查的结果：" + res);
            System.out.print(intrest);
        }
        if(e.getSource()==j2) {
            age = "16-25岁";
            res = "你是一个" + age + "的人，你比较喜欢" + intrest;
            label3.setText("调查的结果：" + res);
        }
        if(e.getSource()==j3) {
            age = "26-35岁";
            res = "你是一个" + age + "的人，你比较喜欢" + intrest;
            label3.setText("调查的结果：" + res);
        }
        if(e.getSource()==j4) {
            age = "36-45岁";
            res = "你是一个" + age + "的人，你比较喜欢" + intrest;
            label3.setText("调查的结果：" + res);
        }
        if(e.getSource()==j5) {
            age = "46-55岁";
            res = "你是一个" + age + "的人，你比较喜欢" + intrest;
            label3.setText("调查的结果：" + res);
        }
        if(e.getSource()==j6) {
            age = "46-55岁";
            res = "你是一个" + age + "的人，你比较喜欢" + intrest;
            label3.setText("调查的结果：" + res);
        }
        if(e.getSource()==j7) {
            label3.setText("调查的结果：");
            Checkbox1.setSelected(false);
            Checkbox2.setSelected(false);
            Checkbox3.setSelected(false);
            Checkbox4.setSelected(false);
            Checkbox5.setSelected(false);
            group.clearSelection();
            age = "";
            intrest = "";
	    }
    }
}