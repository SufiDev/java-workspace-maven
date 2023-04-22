package com.sufi.WIndowExercises;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CountFactorial extends JFrame {
    // Attributes
    private JPanel contentPane;
    private Font font;
    private int count;
    private JTextField txtCount;
    private JTextField txtFactorial;
    private final int HEIGHT = 150;
    private final int WIDTH = 720;

    // Constructor
    public CountFactorial() {
        setTitle("Count Factorial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);

        font = new Font("Tahoma", Font.PLAIN, 20);
        count = 1;
        
        contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout());
        setContentPane(contentPane);

        JLabel lblInteger = new JLabel("value of n");
        lblInteger.setFont(font);
        contentPane.add(lblInteger);

        txtCount = new JTextField();
        txtCount.setFont(font);
        txtCount.setColumns(10);
        txtCount.setText("1");
        txtCount.setEditable(false);
        contentPane.add(txtCount);

        JLabel lblFactorial = new JLabel("Factorial of n");
        lblFactorial.setFont(font);
        contentPane.add(lblFactorial);

        txtFactorial = new JTextField();
        txtFactorial.setFont(font);
        txtFactorial.setColumns(10);
        txtFactorial.setText("1");
        txtFactorial.setEditable(false);
        contentPane.add(txtFactorial);

        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextPressed();
			}
		});
        btnNext.setFont(font);
        contentPane.add(btnNext);
    }

    // Methods
    protected void nextPressed() {
        count++;
        int total = 1;
        txtCount.setText(String.valueOf(count));
        for (int i = count; i > 0; i--) {
            total *= i;
        }
        txtFactorial.setText(String.valueOf(total));
    }
}
