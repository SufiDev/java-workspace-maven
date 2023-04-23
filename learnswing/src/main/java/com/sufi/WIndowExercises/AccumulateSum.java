package com.sufi.WIndowExercises;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* 2,2 grid
 * Label, textField
 * label, textField (non editable)
 */
public class AccumulateSum extends JFrame {
    // Attributes
    private Font font;
    private int sum;
    private JPanel contentPane;
    private JTextField tfInput;
    private JTextField tfSum;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 200;

    // Constructor
    public AccumulateSum() {
        setTitle("I'll accumulate your inputs");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        font = new Font("Tahoma", Font.PLAIN, 22);
        sum = 0;

        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(2, 2));
        setContentPane(contentPane);

        JLabel lblInt = new JLabel("Enter an integer");
        lblInt.setFont(font);
        contentPane.add(lblInt);
        
        tfInput = new JTextField();
        tfInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleInput();
            }
        });
        tfInput.setFont(font);
        contentPane.add(tfInput);
        
        JLabel lblSum = new JLabel("Accumulated sum");
        lblSum.setFont(font);
        contentPane.add(lblSum);

        tfSum = new JTextField("0");
        tfSum.setFont(font);
        tfSum.setEditable(false);
        contentPane.add(tfSum);
    }

    // Methods
    protected void handleInput() {
        try {
            sum += Integer.parseInt(tfInput.getText());
            tfSum.setText(String.valueOf(sum));
            tfInput.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid integer");
            this.dispose();
            return;
        }
    }
}
