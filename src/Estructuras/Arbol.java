/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;
import java.util.List;
//import Estructuras.Transition;

/**
 ** @author Faxx
 */

interface GlobalVals{
    int contador=0;
}

public class Arbol implements GlobalVals {
    public String dato;
    public ArrayList<Arbol> hijos;
    public ArrayList<Transition> transiciones = new ArrayList<>();
    
    public String estadoAceptacion;
    
    public Arbol(String dato){
        this.dato = dato;
        this.hijos = new ArrayList();
    }
    
    public void addHijo(Arbol hijo){
        //System.out.println("Nuevo hijo de "+ this.dato+": "+ hijo.dato);
        this.hijos.add(hijo);
    }
    
    public int aumentoContador(){
        return switch (this.dato) {
            case "." -> hijos.get(0).aumentoContador() + hijos.get(1).aumentoContador();
            case "|" -> hijos.get(0).aumentoContador() + hijos.get(1).aumentoContador()+3;
            case "*" -> hijos.get(0).aumentoContador()+2;
            case "+" -> hijos.get(0).aumentoContador()+2;
            case "?" -> hijos.get(0).aumentoContador()+2;
            default -> 1;//nodos hoja
        };
    }
    
    public String graphvizThompson(int contador){
        String salida="";

        int aumento;
        int aumento2;
        switch(this.dato){
            case ".": 
                salida+=hijos.get(0).graphvizThompson(contador);
                contador=contador+hijos.get(0).aumentoContador();
                salida+=hijos.get(1).graphvizThompson(contador);
                

            break;
            
            case "|": 
                salida+=Integer.toString(contador)+" -> "+Integer.toString(contador+1)+"[label=\"ε\"];\n";
                salida+=hijos.get(0).graphvizThompson(contador+1);
                aumento = hijos.get(0).aumentoContador();
                
                salida+= Integer.toString(contador)+" -> "+ Integer.toString(contador+aumento+2)+"[label=\"ε\"];\n";
                
                salida+=hijos.get(1).graphvizThompson(contador+aumento+2);                 
                aumento2 = hijos.get(1).aumentoContador();
                
                salida+=Integer.toString(contador+aumento+1)+" -> "+Integer.toString(contador+aumento+aumento2+3)+"[label=\"ε\"];\n";
                salida+=Integer.toString(contador+aumento+aumento2+2)+" -> "+Integer.toString(contador+aumento+aumento2+3)+"[label=\"ε\"];\n";
                
            break;
            
            case "*": 
                salida+=Integer.toString(contador)+" -> "+Integer.toString(contador+1)+"[label=\"ε\"];\n";
                
                salida+=hijos.get(0).graphvizThompson(contador+1);
                aumento = hijos.get(0).aumentoContador();
                

                salida+=Integer.toString(contador+aumento+1)+" -> "+Integer.toString(contador+1)+"[label=\"ε\"];\n";
                salida+=Integer.toString(contador+aumento+1)+" -> "+Integer.toString(contador+aumento+2)+"[label=\"ε\"];\n";

                salida+=Integer.toString(contador)+" -> "+Integer.toString(contador+aumento+2)+"[label=\"ε\"];\n";                
            break;
            
            case "+": 
                salida+=Integer.toString(contador)+" -> "+Integer.toString(contador+1)+"[label=\"ε\"];\n";
                
                salida+=hijos.get(0).graphvizThompson(contador+1);
                aumento = hijos.get(0).aumentoContador();
                

                salida+=Integer.toString(contador+aumento+1)+" -> "+Integer.toString(contador+1)+"[label=\"ε\"];\n";
                salida+=Integer.toString(contador+aumento+1)+" -> "+Integer.toString(contador+aumento+2)+"[label=\"ε\"];\n";
            break;
            
            case "?": 
                salida+=Integer.toString(contador)+" -> "+Integer.toString(contador+1)+"[label=\"ε\"];\n";
                
                salida+=hijos.get(0).graphvizThompson(contador+1);
                aumento = hijos.get(0).aumentoContador();
                
                salida+=Integer.toString(contador+aumento+1)+" -> "+Integer.toString(contador+aumento+2)+"[label=\"ε\"];\n";               
                salida+=Integer.toString(contador)+" -> "+Integer.toString(contador+aumento+2)+"[label=\"ε\"];\n";                
            break;
            
            default:                 
                //contador=contador+hijos.get(0).aumentoContador();
                salida+=Integer.toString(contador)+" -> "+Integer.toString(contador+1)+"[label=\""+this.dato+"\"];\n";
            break;
        }
        
        return salida;
    }
    
    public void crearTransitions(String graphvizThompson){
        
        String[] textos = graphvizThompson.split(";\n");
        
        Transition t;
        for (String texto : textos) {
            //System.out.println(texto);
            t = Transition.formarTransition(texto);
            //t.Imprimir();
            this.transiciones.add(t);
        }
        this.estadoAceptacion = getEstadoAceptacion();
    }
    
    public List Lexemas(){
         List lexemas = new ArrayList();
         
        for (int i=0; i<this.transiciones.size(); i++){
            Transition transicion = this.transiciones.get(i);
            if (existeLexema(transicion.entrada, lexemas) == false){
                lexemas.add(transicion.entrada);
            }
        }
        lexemas.remove("ε");
        return lexemas;
    }
    
    public boolean existeLexema(String lexema, List<String> lexemas){
        //System.out.println("Buscando lexema: "+ lexema);
        for (int j=0; j<lexemas.size(); j++){  
            
            if(lexema.equals(lexemas.get(j))){
                //System.out.println("Si existe el lexema: "+ lexema);
                return true;
            }else{
                //System.out.println(lexema+ ", no es  igual a ,"+ lexemas.get(j));
            }
        } 
        //System.out.println("No existie el lexema: "+lexema);
        return false;
    }
    
    public String getEstadoAceptacion(){
        ArrayList<Transition> transitions = this.transiciones;
        return transitions.get(transitions.size()-1).estadoFinal;
    }
    
    public String graphvizEstadoAceptacion(){
        return getEstadoAceptacion()+"[shape=\"doublecircle\"];\n";
    }
    
}
