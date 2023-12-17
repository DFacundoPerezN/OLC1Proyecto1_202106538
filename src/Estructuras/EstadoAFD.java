/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Faxx
 */

public class EstadoAFD {
    public List<String> estadosAFN = new ArrayList<>();
    public String name;
    public boolean aceptacion;
    
    public EstadoAFD(List estadosAFN, String name){
        this.estadosAFN = estadosAFN;
        this.name = name;
        this.aceptacion = false;
        System.out.println(this.name + " = "+this.estadosAFN.toString() );
    }
    
    public String stringEstados(){
        String salida ="{";
        for(String estadoAFN : estadosAFN){
            salida += estadoAFN +", ";
        }
        salida +="}";
        return salida;
    }
    
    public boolean confirmarAceptacion(String estadoAceptacionAFN){
        for(String estado: estadosAFN){
            if(estado.equals(estadoAceptacionAFN)){
                this.aceptacion = true;
                return true;
            }
        }
        return false;
    }
}