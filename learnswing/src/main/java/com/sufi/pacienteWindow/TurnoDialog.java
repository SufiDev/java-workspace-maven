package com.sufi.pacienteWindow;

import javax.swing.JDialog;
import javax.swing.JFrame;
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
	public TurnoDialog(JFrame parent, boolean modal) {
		super(parent, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
        setTitle("Turno de paciente");
		
		JLabel lblTurno = new JLabel("Turno de:");
		lblTurno.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTurno.setBounds(54, 34, 231, 55);
		getContentPane().add(lblTurno);
		
		txtPacienteName = new JTextField();
		txtPacienteName.setHorizontalAlignment(SwingConstants.CENTER);
		txtPacienteName.setFont(new Font("Tahoma", Font.PLAIN, 21));
		// Shows Paciente's name in the text field
		txtPacienteName.setText(((ClinicaWindow) this.getParent()).getListaDeEspera().getPacientes().get(0).getName());
		txtPacienteName.setEditable(false);
		txtPacienteName.setBounds(54, 125, 326, 55);
		getContentPane().add(txtPacienteName);
		txtPacienteName.setColumns(10);
		
		JButton btnAceptar = new JButton("Vale");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptarPressed();
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAceptar.setBounds(157, 206, 128, 44);
		getContentPane().add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelarPressed();
            }
        });
        btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnCancelar.setBounds(291, 206, 128, 44); // 6 pixels of margin to the right
        getContentPane().add(btnCancelar);
        
	}

	protected void cancelarPressed() {
		this.dispose();
	}

	protected void aceptarPressed() {
		// Remove oldest Paciente object from ClienteWindow's ListaDeEspera
		((ClinicaWindow) this.getParent()).getListaDeEspera().getPacientes().remove(0);
		// Change label on main window
		((ClinicaWindow) this.getParent()).getLblNumPacientes().setText(
                    String.valueOf(
                            ((ClinicaWindow) this.getParent()).getListaDeEspera().getPacientes().size()));

		this.dispose();
	}

}
