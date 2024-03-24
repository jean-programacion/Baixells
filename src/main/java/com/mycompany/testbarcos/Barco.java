/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testbarcos;

/**
 *
 * @author jeanm
 */
public class Barco {

    private String nombre;
    private String matricula;
    private int añoConstruccion;
    private Data fechaAdquirido;
    protected int horasMantenimiento;

    public Barco(String nombre, String matricula, int añoConstruccion) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.añoConstruccion = añoConstruccion;
        this.fechaAdquirido = new Data(); // Utiliza la clase Data para obtener la fecha actual
        this.horasMantenimiento = 0; // Inicializa las horas de mantenimiento son 0
    }

    // Método toString
    @Override
    public String toString() {
        return "\nTipo de barco: " + this.getClass().getSimpleName() + "\n"
                + "Nombre: " + nombre + "\n"
                + "Matrícula: " + matricula + "\n"
                + "Año de construccion: " + añoConstruccion + "\n"
                + "Horas de mantenimiento: "  + horasMantenimiento;
    }

    public void realizarMantenimiento() {
        // Aumentar las horas de mantenimiento en 100 cada vez que se llama a este método
        this.horasMantenimiento += 100;
    }
}
