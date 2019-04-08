
package bingo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bingo {
    private ArrayList<Integer> Bombo;
    private ArrayList<Integer> bolas_extraidas;
    private ArrayList<Carton> Cartones;
    private ArrayList<Carton> CartonesGanadores;
    private boolean finalizado;
    private final int  TamañoBombo=30;

    public Bingo() {
        this.finalizado=false;
        this.bolas_extraidas=new ArrayList<>();
        this.CartonesGanadores=new ArrayList<Carton>();
        this.Bombo=this.getNewListNum(this.TamañoBombo);
        this.Cartones=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            this.Cartones.add(this.getNewListCartones());
        }
    }
    public static void main(String[] args) {
        Bingo b=new Bingo();
        b.Jugar();
    }
    private ArrayList<Integer> getNewListNum(int max) {
        ArrayList<Integer> aux=new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            aux.add(i);
        }
        java.util.Collections.shuffle(aux);
        return aux;
    }

    private Carton getNewListCartones() {
        ArrayList<Integer> aux=this.getNewListNum(30);
        java.util.Collections.shuffle(aux);
        ArrayList<Integer>aux2=new ArrayList<>();
        for (int i = 0; i < Carton.getTamaño(); i++) {
            aux2.add(aux.get(i));
        }
        return new Carton(aux2);
    }

    private void Jugar() {
        int bola=0;
        while(false==this.finalizado){
            bola=this.extraerBola();
            System.out.println(  "Bola sacada:" +bola);
            if(this.finalizado==false)
                this.verCartones();
        }
    }
    private Integer extraerBola(){
        Integer bola= this.Bombo.remove(0);
        if(bola!=0){
            this.bolas_extraidas.add(bola);
            boolean vecto[]={false,false,false};
            for (int i = 0; i< 3; i++) {
                vecto[i]=this.comprobarCarton(i);
            }
            boolean sw=false;
            for (int i = 0; i <3; i++) {
                if(vecto[i]==true){
                    this.finalizado=true;
                    this.CartonesGanadores.add(this.Cartones.get(i));
                    sw=true;       
                }
                if(sw)
                    this.verGanadores();
            }
        }else{
            finalizado=true;
            System.out.println("Error");
        }
        return bola;
    }

    private boolean comprobarCarton(int i) {
        boolean validar=false;
        for (int j = 0; j < Carton.getTamaño(); j++) {
            for (int k = 0; k <  this.bolas_extraidas.size(); k++) {
                if(0==this.Cartones.get(i).getCasillas().get(j).compareTo(this.bolas_extraidas.get(k))){
                    validar=true;
                }     
            }
            if(validar)
                validar=false;
            else
                return false;
        }
        return true;   
    }
    private void verGanadores() {
        for (int i = 0; i < this.CartonesGanadores.size(); i++) {
            System.out.println("El carton "+(i+1)+" "+this.CartonesGanadores.get(i).getCasillas().toString()+" Ha ganado ");
        }
    }
    private void verCartones() {
        for (int i = 0; i < 3; i++) {
            System.out.println( "carton "+(i+1)+" "+this.Cartones.get(i).getCasillas().toString());
        }
    }
   
    
}
