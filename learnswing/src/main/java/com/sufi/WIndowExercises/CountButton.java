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

public class CountButton extends JFrame{
    // Attributes
    private JPanel contentPane;
    private JTextField txtCount;
    private Font font;
    private int count;
    private final int HEIGHT = 150;
    private final int WIDTH = 350;

    // Constructor
    public CountButton() {
        setTitle("Click to count!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null); // NOTE: this is the center of the screen

        font = new Font("Tahoma", Font.PLAIN, 24);
        count = 0;

        contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout());
        setContentPane(contentPane);

        JLabel lblCount = new JLabel("Click to count!");
        lblCount.setFont(font);
        contentPane.add(lblCount);

        txtCount = new JTextField();
        txtCount.setFont(font);
        txtCount.setColumns(10);
        txtCount.setText("0");
        txtCount.setEditable(false);
        contentPane.add(txtCount);

        JButton btnCount = new JButton("Next");
        btnCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countPressed();
			}
		});
        btnCount.setFont(font);
        contentPane.add(btnCount);
    }

    // Methods
    protected void countPressed() {
        count++;
        txtCount.setText(String.valueOf(count));
    }
}
