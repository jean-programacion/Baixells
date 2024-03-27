/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.testbarcos;

/**
 *
 * @author jeanm
 */
public class TestFlota {

    public static void main(String[] args) {
        // Crear una flota vacía
        System.out.println("------ Todos Los Barcos --------");
        String[] armas1 = {"Lanza cohetes", "Detector misiles", "Bombardero"};
        String[] armas2 = {"Bombardero", "Lanza cohetes", "Detector misiles"};
        String[] armas3 = {"Lanza cohetes", "Detector misiles", "Machete"};
        String[] armas4 = {"Lanza granadas", "Detector misiles"};
        String[] armas5 = {"Bombardero", "Detector misiles"};

        Barco[] barcos = {
            (new BarcoDeGuerra("Missiling", "AAAA", 2012, armas1, 0, 0)),
            (new BarcoDeGuerra("Naviero feroz", "BBBB", 2013, armas2, 0, 0)),
            (new BarcoDeGuerra("Tiatomic", "CCCC", 2014, armas3, 0, 0)),
            (new BarcoDeGuerra("Hunter", "DDDD", 2015, armas4, 0, 0)),
            (new BarcoDeGuerra("Terrorific", "EEEE", 2016, armas5, 0, 0)),
            // Crear y añadir barcos de pesca
            (new BarcoDePesca("Sardina Express", "SE-123", 2005, 0, 0, 0, 80)),
            (new BarcoDePesca("Pez Payaso", "PP-456", 2010, 0, 0, 0, 70)),
            (new BarcoDePesca("Calamar Cautivador", "CC-789", 2018, 0, 0, 0, 85)),
            (new BarcoDePesca("Bacalao Bromista", "BB-101", 2008, 0, 0, 0, 75)),
            (new BarcoDePesca("Atún Travieso", "AT-234", 2015, 0, 0, 0, 65)),};
        Flota flota = new Flota(barcos);
        // Mostrar todos los barcos
        mostrarBarcos(flota.barcos);

        System.out.println("---------------------------------");

        System.out.println("\n------ Coste de mantenimiento actual --------");
        System.out.println("El coste total en mantenimientos es " + flota.calculoManteniemiento() + " €");
        System.out.println("---------------------------------");

        flota.mantenimientoGeneral();
        System.out.println("\n------ Mantenimiento generalizado --------");
        System.out.println("El coste total en mantenimientos es " + flota.calculoManteniemiento() + " €");
        System.out.println("---------------------------------");

        System.out.println("\n------ Todos los barcos de guerra --------");
        Barco[] barcosDeGuerra = flota.mostrarSoloBarcosDeGuerra();
        for (int i = 0; i < barcosDeGuerra.length; i++) {
            System.out.println(i + ") " + barcosDeGuerra[i]);
        }
         System.out.println("---------------------------------");
         
          System.out.println("\n------ Todos los barcos de pesca --------");
        Barco[] barcosDePesca = flota.mostrarSoloBarcosDePesca();
        for (int i = 0; i < barcosDePesca.length; i++) {
            System.out.println(i + ") " + barcosDePesca[i]);
        }
         System.out.println("---------------------------------");
         
         System.out.println("\n------ Eliminar barco con matrícula PP-456 y mostrar todos los barcos --------");
         flota.eliminarBarco("PP-456");

        // Mostrar todos los barcos
        mostrarBarcos(flota.barcos);
    }

    public static void mostrarBarcos(Barco[] barcos) {
        for (int i = 0; i < barcos.length; i++) {
            System.out.println(i + ") " + barcos[i]);
            if (i < barcos.length - 1) {
                System.out.println(); // Agregar un espacio entre cada barco
            }
        }
    }

}
