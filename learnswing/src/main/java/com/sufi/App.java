package com.sufi;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.sufi.WIndowExercises.CountFactorial;

/**
 * Hello world!
 *
 */
public class App 
{
    

    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					CountFactorial frame = new CountFactorial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
