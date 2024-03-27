/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.testbarcos;

/**
 *
 * @author jeanm
 */
public class TestBarcos {

    public static void main(String[] args) {
        System.out.println("---- Se crean tres barcos, uno de cada tipo. En el barco de guerra, comprueba que funciona tanto la eliminación de armas repetidas, \n como la creación de un barco de guerra con más tripulantes actuales que máximo. También deberás comprobar que el barco pesquero no tiene ninguna red dada de alta ----");

        Barco barco1 = new Barco("Navio promedio XD", "928ush", 2000) {};
        System.out.println(barco1);

        String[] armas = {"Torpedo", "Cañon", "ametralladora"};
        BarcoDeGuerra barco2 = new BarcoDeGuerra("xX El DestructorOceanico Xx", "9sj02ih", 2000, armas, 52, 80);
        System.out.println(barco2);

        Red redes = new Red(TamañoRed.mediano, MaterialRed.poliéster, TipoPesca.spinning);
        BarcoDePesca barco3 = new BarcoDePesca("xX El PescaTruchas3000 Xx", "j829sgq", 1998, 19, 60, 100, 40);
        System.out.println(barco3);

        System.out.println("\n---- Incrementa las horas de mantenimiento de los tres barcos, y del pesquero una vez más ----");

        // Incrementando las horas de mantenimiento de los tres barcos
        barco1.realizarMantenimiento();
        barco2.realizarMantenimiento();
        barco3.realizarMantenimiento();

        System.out.println(barco1);
        System.out.println(barco2);
        System.out.println(barco3);
        // Incrementando las horas de mantenimiento del pesquero una vez más

        System.out.println("\n---- Añade 2 redes diferentes al barco pesquero y un armamento compuesto por 2 armas iguales al barco de guerra, pero diferente a la que ya tiene registrada ----");
        barco2.anyadirArmamento(armas);
        System.out.println(barco2);

        barco3.anyadirNuevaRed(redes);
        barco3.anyadirNuevaRed(redes);
        System.out.println(barco3);

        System.out.println("\n---- Barco de pesca después de eliminar su primera red ----");
        barco3.eliminarRed(redes);

        System.out.println(barco3);
        
        System.out.println("\n-- Prueba también que la gestión del número de tripulantes de los barcos de guerra funciona, siguiendo la misma metodología ---");
        barco2.aumentarTripulantes(0);
        System.out.println(barco2);
    }
}
