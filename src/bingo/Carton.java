/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.ArrayList;


public class Carton {
    private ArrayList<Integer> Casillas;
    static final int tamaño= 9;

    public Carton(ArrayList<Integer> casillas) {
        this.Casillas=casillas;
    }

    public ArrayList<Integer> getCasillas() {
        return this.Casillas;
    }

    public static int getTamaño() {
        return tamaño;
    }
    
    
}
