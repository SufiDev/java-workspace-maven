package com.sufi;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.sufi.pacienteWindow.ClinicaWindow;

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
					ClinicaWindow frame = new ClinicaWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
