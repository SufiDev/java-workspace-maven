package com.sufi.agendaWindow;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * Window
 * Two buttons, new contact and delete contact
 */
public class AgendaWindow extends JFrame {
    // Attributes
    private JPanel contentPane;
    private Agenda agenda;
    private final int WIDTH = 500;
    private final int HEIGHT = 600;
    private JTable table;
    
    // Constructor
    public AgendaWindow() {
        setTitle("Agenda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(WIDTH, HEIGHT);

        cargarAgenda();

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(88, 35, 302, 374);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportBorder(new LineBorder(Color.RED));

        JButton btnAdd = new JButton("Añadir contacto");
		btnAdd.setBounds(88, 462, 118, 44);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Borrar contacto");
		btnDelete.setBounds(272, 462, 118, 44);
		contentPane.add(btnDelete);
		
		table = new JTable();
		cargarTabla();
        scrollPane.getViewport().add(table);
		contentPane.add(scrollPane);
    }

    // Methods
    private void cargarAgenda() {
        agenda = new Agenda();
        
        // Just for learning purposes, don't do this in real life
        this.agenda.add(new Contacto("Juan", 65421233));
        this.agenda.add(new Contacto("Pedro", 65421233));
        this.agenda.add(new Contacto("Maria", 65421233));
    }

    private void cargarTabla() {
        ArrayList<Contacto> contactos = this.agenda.getContactos();
        Object[][] data = new Object[contactos.size()][2];
        // Fill data with contactos
        for (int i = 0; i < data.length; i++) {
            data[i][0] = contactos.get(i).getNombre();
            data[i][1] = contactos.get(i).getTelefono();
        }

        table.setModel(new DefaultTableModel(
			data,
			new String[] {
				"Nombre", "Telefono"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Long.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(105);
		table.getColumnModel().getColumn(1).setPreferredWidth(88);
		table.setBounds(120, 40, 173, 113);
    }

    // Getters
    public Agenda getAgenda() {
        return agenda;
    }
    
    public int getWIDTH() {
        return WIDTH;
    }
    
    public int getHEIGHT() {
        return HEIGHT;
    }
}
