import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Surface extends JFrame {
    public JButton button_plus;
    public JButton button_minus;
    public JButton button_multiply;
    public JButton button_divide;
    public JButton button_clear;
    public JTextField input_1;
    public JTextField input_2;
    public JTextArea log;

    public Surface(){
        setSize(310, 400);
        setTitle("Taschenrechner");
        getContentPane().setLayout(new FlowLayout());

        button_plus = new JButton();
        button_minus = new JButton();
        button_multiply = new JButton();
        button_divide = new JButton();
        button_clear = new JButton();
        input_1 = new JTextField();
        input_2 = new JTextField();
        log = new JTextArea();

        button_plus.setText("+");
        button_minus.setText("-");
        button_multiply.setText("*");
        button_divide.setText("/");
        button_clear.setText("clr");
        input_1.setPreferredSize(new Dimension(150, 25));
        input_2.setPreferredSize(new Dimension(150, 25));
        log.setPreferredSize(new Dimension(300, 300));
        log.setEditable(false);

        button_plus.addActionListener(new ActionPlus());
        button_minus.addActionListener(new ActionMinus());
        button_multiply.addActionListener(new ActionMultiply());
        button_divide.addActionListener(new ActionDivide());
        button_clear.addActionListener(new ActionClear());

        add(button_plus);
        add(button_minus);
        add(button_multiply);
        add(button_divide);
        add(button_clear);
        add(input_1);
        add(input_2);
        add(log);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}