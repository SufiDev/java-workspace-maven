package com.sufi.pacienteWindow;

import java.util.ArrayList;

public class ListaDeEspera {
    // Attributes
    private ArrayList<Paciente> pacientes;

    // Constructors
    public ListaDeEspera() {
        pacientes = new ArrayList<Paciente>();
    }

    // Methods
    public void addPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void atenderPaciente() {
        // Remove the first patient
        pacientes.remove(0);
    }

    @Override
    public String toString() {
        return "Clinica [pacientes=" + pacientes + "]";
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
}
