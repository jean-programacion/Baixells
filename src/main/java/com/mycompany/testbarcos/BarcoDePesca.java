/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testbarcos;

import java.util.Arrays;

/**
 *
 * @author jeanm
 */
public class BarcoDePesca extends Barco {

    private double capacidadCarga;
    private Red[] listaRedesDisponibles = new Red[0];
    private double porcentajeCapturasExitosas;

    public BarcoDePesca(String nombre, String matricula, int añoConstruccion, int tripulantesMaximos, int tripulantesActuales, double capacidadCarga, double porcentajeCapturasExitosas) {
        super(nombre, matricula, añoConstruccion);
        this.capacidadCarga = capacidadCarga;
        this.porcentajeCapturasExitosas = porcentajeCapturasExitosas;
    }

    @Override
    public String toString() {

        return super.toString() + "\n"
                + "Capacidad de carga: " + capacidadCarga + "metros cúbicos\n"
                + "Porcentaje de capturas exitosas: " + porcentajeCapturasExitosas + "%\n"
                + "Redes disponibles: " + Arrays.toString(listaRedesDisponibles);
    }

    // Método para realizar mantenimiento (se invierten el doble de las horas)
    @Override
    public void realizarMantenimiento() {
        super.realizarMantenimiento();
        super.realizarMantenimiento();
    }

    // Método para dar de alta una nueva red de pesca
    public void anyadirNuevaRed(Red nuevRed) {
        // Crear un nuevo array con el tamaño incrementado en 1
        Red[] nuevo = new Red[listaRedesDisponibles.length + 1];
        // Copiar los elementos existentes al nuevo array
        System.arraycopy(listaRedesDisponibles, 0, nuevo, 0, listaRedesDisponibles.length);
        // Agregar la nueva red al final del nuevo array
        nuevo[nuevo.length - 1] = nuevRed;
        // Asignar el nuevo array a listaRedesDisponibles
        listaRedesDisponibles = nuevo;

    }

    // Método para dar de baja una red
    public void eliminarRed(Red red) {
        for (int i = 0; i < listaRedesDisponibles.length; i++) {
            if (listaRedesDisponibles[i] != null && listaRedesDisponibles[i].isIgual(red)) {
                listaRedesDisponibles[i] = null; // Establece la red encontrada a null
                break; // Detén la iteración una vez que la red ha sido eliminada
            }
        }
    }
}
