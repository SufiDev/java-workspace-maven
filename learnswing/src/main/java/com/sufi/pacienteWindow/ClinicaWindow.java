package com.sufi.pacienteWindow;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
// import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClinicaWindow extends JFrame {

	private JPanel contentPane;
    private ListaDeEspera listaDeEspera;
    private JLabel lblNumPacientes = new JLabel("0");

    public JLabel getLblNumPacientes() {
        return lblNumPacientes;
    }

	/**
	 * Create the frame.
	 */
	public ClinicaWindow() {
        cargarListaDeEspera();

		setTitle("Clinica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddPatient = new JButton("Nuevo Paciente");
		btnAddPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                addPressed();
			}
		});
		btnAddPatient.setBounds(38, 87, 147, 70);
		contentPane.add(btnAddPatient);
		
		JButton btnNextPatient = new JButton("Siguiente");
		btnNextPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                nextPressed();
			}
		});
		btnNextPatient.setBounds(251, 87, 147, 70);
		contentPane.add(btnNextPatient);

        JLabel lblPacientesRestantes = new JLabel("Pacientes esperando:");
		lblPacientesRestantes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPacientesRestantes.setBounds(38, 201, 203, 34);
		contentPane.add(lblPacientesRestantes);
		
		lblNumPacientes.setText(String.valueOf(listaDeEspera.getPacientes().size()));
		lblNumPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumPacientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumPacientes.setBounds(237, 204, 31, 28);
		contentPane.add(lblNumPacientes);
	}

    public ListaDeEspera getListaDeEspera() {
        return listaDeEspera;
    }

    private void cargarListaDeEspera() {
        // Could be loaded from a file, database, etc.
        listaDeEspera = new ListaDeEspera();
        listaDeEspera.addPaciente(new Paciente("Juan", "123456"));
        listaDeEspera.addPaciente(new Paciente("Pedro", "123457"));
    }

    protected void nextPressed() {
		// Open TurnoDialog
		try {
			TurnoDialog dialog = new TurnoDialog(this, true);
			dialog.setLocationRelativeTo(this);
			dialog.setVisible(true);
		} catch (Exception e) {
			// JOptionPane.showMessageDialog(this, "No hay pacientes en la lista de espera");
		}
    }

    protected void addPressed() {
		// Open AddPatientDialog
        AddPatientDialog dialog = new AddPatientDialog(this, true);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
}