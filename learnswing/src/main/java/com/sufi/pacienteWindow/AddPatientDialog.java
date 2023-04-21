package com.sufi.pacienteWindow;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPatientDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textFieldNombre;
    private JTextField textFieldID;

    /**
     * Create the dialog.
     */
    public AddPatientDialog(JFrame parent, boolean modal) {
        super(parent, true);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            textFieldNombre = new JTextField();
            textFieldNombre.setBounds(42, 63, 279, 39);
            contentPanel.add(textFieldNombre);
            textFieldNombre.setColumns(10);
        }
        {
            textFieldID = new JTextField();
            textFieldID.setBounds(42, 162, 279, 39);
            contentPanel.add(textFieldID);
            textFieldID.setColumns(10);
        }

        JLabel lblNombre = new JLabel("Nombre del paciente");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNombre.setBounds(42, 22, 184, 30);
        contentPanel.add(lblNombre);

        JLabel lblNewLabel_1 = new JLabel("Dni del paciente");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(42, 121, 184, 30);
        contentPanel.add(lblNewLabel_1);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        okPressed();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancelar");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cancelPressed();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    protected void okPressed() {
        // Check if the fields are empty
        // If not, add the patient to the list
        // If yes, show a default message dialog
        // Also update the lblNumPacientes with the new number of patients
        if (this.textFieldNombre.getText().isEmpty() || this.textFieldID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Paciente paciente = new Paciente(this.textFieldNombre.getText(), this.textFieldID.getText());
            ((ClinicaWindow) this.getParent()).getListaDeEspera().addPaciente(paciente);
            ((ClinicaWindow) this.getParent()).getLblNumPacientes().setText(
                    String.valueOf(
                            ((ClinicaWindow) this.getParent()).getListaDeEspera().getPacientes().size()));
            this.dispose();
        }
    }

    protected void cancelPressed() {
        this.dispose();
    }
}