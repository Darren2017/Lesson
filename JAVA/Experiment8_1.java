import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Experiment8_1 {
    public Experiment8_1() {
        GridBagLayout gridBag = new GridBagLayout();    // 布局管理器
        GridBagConstraints c = null;
        JFrame jframe = new JFrame("选项事件");
        JPanel panel = new JPanel(gridBag);
        JLabel label2 = new JLabel("组件事件：第一项被选中");
        JRadioButton j1 = new JRadioButton("radioButton1");
        JRadioButton j2 = new JRadioButton("radioButton2");
        JRadioButton j3 = new JRadioButton("radioButton3");
        ButtonGroup group = new ButtonGroup();
        String[] listData = new String[]{"第一项", "第二项", "第三项", "第四项"};
        final JComboBox<String> comboBox = new JComboBox<String>(listData);

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    label2.setText("组件事件：" + comboBox.getSelectedItem() + " 被选中");
                }
            }
        });

        comboBox.setSelectedIndex(0);
        jframe.setSize(800, 250);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        group.add(j1);
        group.add(j2);
        group.add(j3);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        gridBag.addLayoutComponent(j1, c);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        gridBag.addLayoutComponent(j2, c);
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 0;
        gridBag.addLayoutComponent(j3, c);
        panel.add(j1); 
        panel.add(j2);
        panel.add(j3);
        JCheckBox boldCheckbox = new JCheckBox("checkBox1");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        gridBag.addLayoutComponent(boldCheckbox, c);
        panel.add(boldCheckbox);
        
        JCheckBox italicCheckbox = new JCheckBox("checkBox2");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        gridBag.addLayoutComponent(italicCheckbox, c);
        panel.add(italicCheckbox);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        gridBag.addLayoutComponent(comboBox, c);
        panel.add(comboBox);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 3;
        gridBag.addLayoutComponent(label2, c);
        panel.add(label2);
        jframe.setContentPane(panel);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }

    public static void main(String[] args) {
        new Experiment8_1();
    }
}