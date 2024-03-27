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
public class Flota {

    Barco[] barcos;
    

    public Flota(Barco[] barcos) {
        this.barcos = barcos;
    }

    public void mantenimientoGeneral() {
        for (Barco barco : barcos) {
            barco.realizarMantenimiento();
        }
    }

  public double calculoManteniemiento(){
        int total = 0;
        for (Barco barco : barcos) {
            if (barco instanceof BarcoDePesca barcoPesca) {
                total += barcoPesca.horasMantenimiento*4;
            }
            if (barco instanceof BarcoDePesca barcoGuerra) {
                total += barcoGuerra.horasMantenimiento*6;
            }
        }
        return total;
    }

    public void mostrarBarcos() {
        for (int i = 0; i < barcos.length; i++) {
            System.out.println(i + ") " + barcos[i]);
        }
    }

    public void mostrarBarcosDeGuerra() {
        for (Barco barco : barcos) {
            if (barco instanceof BarcoDeGuerra) {
                System.out.println(barco);
            }
        }
    }

    public void mostrarBarcosDePesca() {
        for (Barco barco : barcos) {
            if (barco instanceof BarcoDePesca) {
                System.out.println(barco);
            }
        }
    }

     private int buscarBarco(String matricula) {
    for (int i = 0; i < barcos.length; i++) {
        if (barcos[i].equals(new BarcoDePesca("comprobador", matricula, 0, 0, 0, 0.0, 0.0))) {
            return i;
        }
    }
    return -1;
}

    public void mostrarInfoBarco(String matricula) {
        int indice = buscarBarco(matricula);
        if (indice != -1) {
            System.out.println(barcos[indice]);
        } else {
            System.out.println("No se encontró el Barco con matrícula: " + matricula);
        }
    }

    public void eliminarBarco(String matricula) {
        int indice = buscarBarco(matricula);
        if (indice != -1) {
            Barco[] nuevaFlota = new Barco[barcos.length - 1];
            int contador = 0;
            for (int i = 0; i < barcos.length; i++) {
                if (i != indice) {
                    nuevaFlota[contador++] = barcos[i];
                }
            }
            barcos = nuevaFlota;
        }
    }

    public void anyadirBarco(Barco barco) {
        if (!existeBarco(barco)) {
            Barco[] nuevaFlota = new Barco[barcos.length + 1];
            for (int i = 0; i < barcos.length; i++) {
                nuevaFlota[i] = barcos[i];
            }
            nuevaFlota[barcos.length] = barco;
            barcos = nuevaFlota;
        }
    }
    
    private boolean existeBarco(Barco barco) {
        for (Barco b : barcos) {
            if (b.equals(barco)) {
                return true;
            }
        }
        return false;
    }
   
    @Override
    public String toString() {
        return "Barcos en la Flota: " + Arrays.toString(barcos);
    }
    
     public Barco[] mostrarSoloBarcosDeGuerra() {
        // Contar cuántos barcos de guerra hay
        int count = 0;
        for (Barco barco : barcos) {
            if (barco instanceof BarcoDeGuerra) {
                count++;
            }
        }

        // Crear un nuevo array para almacenar los barcos de guerra
        Barco[] barcosDeGuerra = new Barco[count];

        // Llenar el array con los barcos de guerra encontrados
        int index = 0;
        for (Barco barco : barcos) {
            if (barco instanceof BarcoDeGuerra) {
                barcosDeGuerra[index] = barco;
                index++;
            }
        }

        return barcosDeGuerra;
    }
     public Barco[] mostrarSoloBarcosDePesca() {
        int count = 0;
        for (Barco barco : barcos) {
            if (barco instanceof BarcoDePesca) {
                count++;
            }
        }

        Barco[] barcosDePesca = new Barco[count];

        int index = 0;
        for (Barco barco : barcos) {
            if (barco instanceof BarcoDePesca) {
                barcosDePesca[index] = barco;
                index++;
            }
        }

        return barcosDePesca;
    }
    
}
