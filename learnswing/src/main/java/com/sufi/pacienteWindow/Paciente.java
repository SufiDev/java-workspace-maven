package com.sufi.pacienteWindow;

public class Paciente {
    // Attributes
    private String name;
    private String id;

    // Constructors
    public Paciente(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    // Methods
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Paciente [name=" + name + ", id=" + id + "]\n";
    }
}
