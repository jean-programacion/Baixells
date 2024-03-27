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
public class BarcoDeGuerra extends Barco {

    private String[] armamento;
    private int tripulantesMaximos;
    private int tripulantesActuales;

    public BarcoDeGuerra(String nombre, String matricula, int añoConstruccion, String[] armas, int tripulantesMaximos, int tripulantesActuales) {
        super(nombre, matricula, añoConstruccion);
        this.armamento = armas;
        this.tripulantesMaximos = tripulantesMaximos;
        this.tripulantesActuales = Math.min(tripulantesActuales, tripulantesMaximos);
    }

    @Override
    public String toString() {

        return super.toString() + "\n"
                + "Armamento: " + Arrays.toString(armamento) + "\n"
                + "Tripulantes actuales: " + tripulantesActuales;
    }
    // Método para aumentar el número de tripulantes actuales

    public void aumentarTripulantes(int cantidad) {
        tripulantesActuales += cantidad;
        // Si el número actual supera al máximo, se ajusta al máximo
        tripulantesActuales = Math.min(tripulantesActuales, tripulantesMaximos);
    }
    // Método para aumentar el máximo de tripulantes del barco

    public void aumentarMaximosDeTripulantes(int cantidad) {
        tripulantesMaximos += cantidad;
    }
    // Método para añadir armamento

    public void anyadirArmamento(String[] nuevoArmamento) {
        // Crear un nuevo array con el tamaño combinado de los arrays existentes y el nuevo
        String[] nuevo = new String[armamento.length + nuevoArmamento.length];

        System.arraycopy(armamento, 0, nuevo, 0, armamento.length);

        System.arraycopy(nuevoArmamento, 0, nuevo, armamento.length, nuevoArmamento.length);

        armamento = nuevo;
    }
    // Método para realizar mantenimiento (se invierten 300 horas)

    @Override
    public void realizarMantenimiento() {
        this.horasMantenimiento += 300;
    }

    private static String[] noDuplica(String[] array) {
        String[] re = new String[1];
        re[0] = array[0];
        for (String array1 : array) {
            boolean no = false;
            for (String re1 : re) {
                if (re.equals(array1)) {
                    no = true;
                    break;
                }
            }
            if (!no) {
                re = anyadirFila(re);
                re[re.length - 1] = array1;
            }
        }
        return re;
    }

    private static String[] anyadirFila(String[] array) {
        String[] resultado;
        resultado = new String[array.length + 1];
        System.arraycopy(array, 0, resultado, 0, array.length);
        return resultado;
    }
}
