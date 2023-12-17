/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author Faxx
 */
public class Transition {
    public String estadoInicial;
    public String entrada;
    public String estadoFinal;
    
    public Transition(String estadoInicial, String entrada, String estadoFinal){
        this.estadoInicial = estadoInicial;
        this.entrada = entrada;
        this.estadoFinal = estadoFinal;
    }
    
    public void Imprimir(){
        System.out.println("##Estado inicial: "+ this.estadoInicial+ "  Lex: "+this.entrada+"  Estado Final: "+ this.estadoFinal);
    }
    
public static Transition formarTransition(String texto){
    String[] partes;
    partes = texto.split(" -> ");
    
    String estadoInicial = partes[0];    
    //System.out.println("Estado inicial: "+ estadoInicial);

    partes = partes[1].split("label");
    
    String estadoFinal = partes[0].replace("[","");
    //System.out.println("Estado final: "+ estadoFinal);
    
    String entrada = partes[1].replaceAll("=\"","");
    entrada = entrada.replaceAll("\"]","");
    //System.out.println("Lex: "+ entrada);
    try{
        return new Transition(estadoInicial, entrada, estadoFinal);
    }catch(Exception ex){
        System.out.println("Error aL Crear transicion");
        return new Transition("-", "-", "-");
    }
    
    
}
}

