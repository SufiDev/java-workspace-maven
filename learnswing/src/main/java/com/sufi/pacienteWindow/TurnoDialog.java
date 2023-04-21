package com.sufi.pacienteWindow;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TurnoDialog extends JDialog {
	private JTextField txtPacienteName;

	/**
	 * Create the dialog.
	 */
	public TurnoDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblTurno = new JLabel("Turno de:");
		lblTurno.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTurno.setBounds(54, 34, 231, 55);
		getContentPane().add(lblTurno);
		
		txtPacienteName = new JTextField();
		txtPacienteName.setHorizontalAlignment(SwingConstants.CENTER);
		txtPacienteName.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtPacienteName.setText("PACIENTE AQUI");
		txtPacienteName.setEditable(false);
		txtPacienteName.setBounds(54, 125, 326, 55);
		getContentPane().add(txtPacienteName);
		txtPacienteName.setColumns(10);
		
		JButton btnAceptar = new JButton("Vale");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAceptar.setBounds(157, 206, 128, 44);
		getContentPane().add(btnAceptar);

	}

}
