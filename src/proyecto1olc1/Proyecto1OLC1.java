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
        //String htmlE = AnalizadorLexico.erroresLexicos(t);
        //String htmlL = AnalizadorLexico.ReporteLexemas(t);
                  
        //ArrayList lista = rangeToArraylist("*~/");

    }
    public static ArrayList rangeToArraylist(String range){
        char start = range.charAt(0);
        char end = range.charAt(2);
        int first = (int)start;
        int last = (int)end;
        
        ArrayList array = new ArrayList();
        
        for(int i=first; i<=last ;i++){
            array.add(Character.toString(i));
        }
        return array;        
    }
}
