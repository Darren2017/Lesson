import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Experiment7_4 {

    public static void main(String[] args) {
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel label2 = new JLabel("你选择了: 扬州");
        String[] listData = new String[]{"上海", "扬州", "潍坊", "武汉"};
        final JComboBox<String> comboBox = new JComboBox<String>(listData);

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    label2.setText("你选择了：" + comboBox.getSelectedItem());
                }
            }
        });

        comboBox.setSelectedIndex(1);

        panel.add(comboBox);
        panel.add(label2);

        jf.setContentPane(panel);
        jf.setVisible(true);
    }

}