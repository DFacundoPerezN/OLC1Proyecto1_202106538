/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Faxx
 */
public class Automata {
    public List<String> lexemas = new ArrayList<>();
    public ArrayList<Transition> transiciones = new ArrayList<>();
    
    public List<String> CerraduraInicial  = new ArrayList<>();
    
    public int contador;
    public ArrayList<EstadoAFD> subconjuntos = new ArrayList<>();
    
    public String estadoAceptacionAFN;
    
    public List<String> cerraduraActual;
    
    public Automata(ArrayList<Transition> transiciones,List<String> lexemas, String estadoAceptacion){
        this.transiciones=transiciones;        
        this.lexemas=lexemas;        
        this.estadoAceptacionAFN = estadoAceptacion;
        this.contador=0;
    }
    
    public boolean existeSubconjunto(List<String> subconjunto){
        for (EstadoAFD subC: this.subconjuntos) {
            //System.out.print("comparando: "+subconjunto.toString()+ " "+subC.estadosAFN.toString());
            if(subconjunto.toString().equals(subC.estadosAFN.toString()) ){
                return true;
            }
        }
        return false;
    }   
    
    public void ImprimirEstadosAFD(){
        for(EstadoAFD estado : this.subconjuntos){
            System.out.print(estado.name+" "+estado.stringEstados());
        }
        System.out.println("");
    }
    
    public EstadoAFD estadoAFDporLista(List subconjunto){
        for(EstadoAFD estado: subconjuntos){
            if(estado.estadosAFN.toString().equals(subconjunto.toString())){
                return estado;
            }
        }
        System.out.println("Error no se encontró el estado AFD");
        return null;
    }
    
    /*public boolean todosCerrados(){
        for (EstadoAFD subC: this.subconjuntos) {
                if(subC.cerrado == false){
                    return false;
                }
            }
        return true;
    }*/
    
    public List agregarString(List<String> Lista, String lex){
        for(String entrada: Lista){
            if(entrada.equals(lex)){
                return Lista;
            }
        }
        Lista.add(lex);
        return Lista;
    }
    
    public List agregarTodos(List<String> Lista, List<String> entradas){
        for(String entrada: entradas){
            Lista = agregarString(Lista, entrada);
        }
        //Lista.add(lex);
        return Lista;
    }
    
    
    public void formarCerraduraInicial(){
        this.CerraduraInicial.add("0");
        System.out.println("*Cantidad transiciones: "+ this.transiciones.size());
        for (int i=0; i<this.transiciones.size(); i++){
            this.transiciones.get(i).Imprimir();
            if ("0".equals(this.transiciones.get(i).estadoInicial) && "ε".equals(this.transiciones.get(i).entrada)){
                //this.CerraduraInicial.add(this.transiciones.get(i).estadoFinal);
                this.CerraduraInicial = agregarString(this.CerraduraInicial, this.transiciones.get(i).estadoFinal);
                //Buscar transiciones que tengan de estadoInicial este estadoFinal y de entrada un Epsilon
                //this.CerraduraInicial.addAll(estadosAlcanzables("ε", this.transiciones.get(i).estadoFinal) );
                this.CerraduraInicial = agregarTodos(this.CerraduraInicial, estadosAlcanzables("ε", this.transiciones.get(i).estadoFinal));
            }
        }        
        subconjuntos.add(new EstadoAFD(this.CerraduraInicial,"q"+contador));
        
        System.out.print("cerr(0)="+ CerraduraInicial.toString() +"\n");
        contador++;
    }
    
    public List estadosAlcanzables(String entrada, String estadoInicial){
        List listStates = new ArrayList();
        
        for (int i=0; i<this.transiciones.size(); i++){
            Transition transicion = this.transiciones.get(i);
            //System.out.println("Comparando: "+transicion.estadoInicial+" ,lex: "+transicion.entrada+ "  con: "+estadoInicial+" ,lex: "+entrada);
            
            if (transicion.estadoInicial.equals(estadoInicial) 
                && transicion.entrada.equals(entrada)){
                //System.out.print(estadoInicial+" pasa a "+ transicion.estadoFinal+ " con  "+ entrada);
                //listStates.add(transicion.estadoFinal);
                listStates = agregarString(listStates, transicion.estadoFinal);
                this.cerraduraActual = agregarString(listStates, transicion.estadoFinal);
                //System.out.println ("  <- fue guardado");
                //listStates.addAll(estadosAlcanzables("ε", transicion.estadoFinal) );
                System.out.println("Buscando estados cerradura de: "+ transicion.estadoFinal);
                //System.out.println("Is "+ transicion.estadoFinal +" in " + this.cerraduraActual.toString() +"?");
                if(this.cerraduraActual.contains(transicion.estadoFinal)){
                    System.out.println("La cerradura ya tiene "+transicion.estadoFinal);
                }
                else{
                listStates = agregarTodos(listStates, estadosAlcanzables("ε", transicion.estadoFinal));                    
                }
                
            }
        }        
        System.out.println("cerr("+estadoInicial+") = "+ listStates.toString());
        return listStates; //devuelve una lista de estados en forma de String
    }
        
    public List movimientoEstadoEntrada(EstadoAFD estadoAFD, String lexema){
        List movimientos = new ArrayList();
        for (String estadoInicial : estadoAFD.estadosAFN) {
            for (Transition transition: this.transiciones) {
            //System.out.println("Comparando: "+transition.estadoInicial+" ,lex: "+transition.entrada+ "  con: "+estadoInicial+" ,lex: "+lexema);
                
                if(estadoInicial.equals(transition.estadoInicial) && transition.entrada.equals(lexema)){
                    System.out.println("Movimiento: "+transition.estadoInicial+" ,lex: "+transition.entrada+ "  con: "+estadoInicial+" ,lex: "+lexema);
                    //movimientos.add(transition.estadoFinal);
                    movimientos = agregarString(movimientos, transition.estadoFinal);
                }else{                
                }
            }
        }        
        System.out.println("Mov["+estadoAFD.name+","+lexema+"] = "+ movimientos.toString());
        return movimientos;
    }
    
    public List cerradura(List<String> movimientos){
        List cerradura = movimientos;
        //System.out.println("cantidad de movimeintos dentro de esta cerradura: "+movimientos.size());        
        this.cerraduraActual = cerradura;
        String estadoInicial;
        for (int i=0; i<movimientos.size(); i++){  
            estadoInicial = movimientos.get(i);
            
            System.out.println("Buscando cerradura del estado: "+ estadoInicial);
            //cerradura.addAll(estadosAlcanzables("ε",estadoInicial));
            cerradura = agregarTodos(cerradura, estadosAlcanzables("ε",estadoInicial));                    
            this.cerraduraActual = cerradura;
            
            System.out.println("cerr("+movimientos.toString()+") = "+ cerradura.toString());
        }       
        System.out.println("++cerr("+movimientos.toString()+") = "+ cerradura.toString()+"\n");
        
        return cerradura;        
    }
    
    public String metodoSubconjuntos(){
        String salida ="";
        
        formarCerraduraInicial();
        EstadoAFD subconjunto;
        
        List<String> movimientos;
        List<String> cerradura;
        
        EstadoAFD estadoAFD;
        System.out.println("------Produciendo AFD----------");
        
        int indexSubconjunto=0;
        int sizeSubconjuntos = 1;
        
        while(indexSubconjunto < sizeSubconjuntos){
            subconjunto = subconjuntos.get(indexSubconjunto);
            //System.out.println("Si existe estadoAFD en subconjuntos");
            
            for(String lexema: lexemas){
                movimientos = movimientoEstadoEntrada(subconjunto ,lexema);
                
                if(!movimientos.isEmpty()){
                    this.CerraduraInicial.clear();
                    cerradura = cerradura(movimientos);
                    
                    if(!existeSubconjunto(cerradura)){ //Si no existia el estadoAFD representa a la cerradura
                        subconjuntos.add(new EstadoAFD(cerradura,"q"+contador)); //Lo crea con
                        contador++;
                        sizeSubconjuntos ++;
                        //ImprimirEstadosAFD();
                    }
                    //else{System.out.println("Ya existe el subconjutno: "+ cerradura.toString());                    }
                    estadoAFD = estadoAFDporLista(cerradura);
                    salida+=subconjunto.name + " -> " + estadoAFD.name +"[label=\""+lexema+"\"];\n";
                    //System.out.println(subconjunto.name + " -> " + estadoAFD.name +"[label=\""+lexema+"\"];\n");
                    
                }else{
                    System.out.println("la cerradura "+subconjunto.name +" no tiene movimeintos con "+ lexema);
                }
            }                
            indexSubconjunto++;

            
        }
        salida+=graphvizAceptaciones();
        //System.out.println(salida);
        return salida;
        
    }
    public String graphvizAceptaciones(){
        String salida ="";
        for(EstadoAFD estadoAFD: this.subconjuntos ){
            if(estadoAFD.confirmarAceptacion(this.estadoAceptacionAFN)){
                salida+=estadoAFD.name+"[shape=\"doublecircle\"]\n";
            }
        }
        return salida;
    }
}
