/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1olc1;
import java.util.ArrayList;
/**
 *
 * @author Faxx
 */
public class Proyecto1OLC1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Interfaz1().setVisible(true);
        //System.out.println("Este es el codigo de menos: " + (int)'-');
        String t = "{\n" +
"// CONJUNTOS\n" +
"CONJ: letra -> a~z;\n" +
"CONJ: digito -> 0-9;\n" +
"\n" +
"//expresiones\n" +
"exp -> . (digito). *\".\" + (digito);\n" +
"RegEx3 -> . (digito) * | *_* | (letra) (digito);\n" +
"}";
        String e = "{\n" +
"// CONJUNTOS\n" +
"CONJ: letra -> a~z;\n" +
"id -> ... a b b*|a b;\n" +
"\n" +
"}";
    
        System.out.println("----------New try----------------");
        //String htmlE = AnalizadorLexico.erroresLexicos(t)[0];
                  
        //ArrayList lista = rangeToArraylist("*~/");

    }

}
