/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testbarcos;

/**
 *
 * @author jeanm
 */
public class Red {
    
    private TamañoRed tamaño;
    private MaterialRed material;
    private TipoPesca tipoDePesca;
    
    public Red(TamañoRed tamaño, MaterialRed material, TipoPesca tipoDePesca){
        this.tamaño = tamaño;
        this.material = material;
        this.tipoDePesca = tipoDePesca;
    }
    @Override
    public String toString() {
        return "Red de tamaño " + this.tamaño + " hecha por " + this.material + " para pesca " + this.tipoDePesca;
    }
    public boolean isIgual(Red red){
        return(this.tamaño.equals(red.tamaño) && this.material.equals(red.material) && this.tipoDePesca.equals(red.tipoDePesca));
    }
}