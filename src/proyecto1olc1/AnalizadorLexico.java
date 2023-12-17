
package proyecto1olc1;
import Analizadores.Parser;
import Analizadores.Scanner;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;

public class AnalizadorLexico {
    
       static String reemplazarComentarios(String texto){
        String comentario;
        while(texto.contains("//")){
            int apuntador = texto.indexOf("//");
            comentario = texto.substring(apuntador); //comentario empieza por la nuev linea
            comentario = comentario.split("\n")[0]; // comentario acaba en el cambio de linea
            texto = texto.replace(comentario, " ");
            System.out.println("Comentario ignorado: '"+comentario+ "'");
        }
        
        while (texto.contains("/*") && texto.contains("*/")){
            comentario = texto.substring(texto.indexOf("/*"),texto.indexOf("*/")+2); //el comentario empieza con la cadena */ y termina con */
            
            int cantidadSaltos = comentario.split("\n").length;
            String saltos =" ";
            for (int j=1; j< cantidadSaltos; j++){  // por cada salto de linea
                saltos += "\n";
            }
            texto = texto.replace(comentario, saltos); // se reemplaza el comentario por unicamente los saltos de linea que tiene
            System.out.println("Comentario ignorado: "+comentario);
        }
        
        return texto;
    }
       
    static String inicioHTML = "<html>" +
        "\n<meta charset=\"utf-8\">" +
        "\n<table border=\"1\">";
    
    static String finalHTML ="\n</table>"+"\n</html>";
    
    static String[] erroresLexicos(String texto){
        String consola ="";
        
        String[] lineas = texto.split("\n");
        String html = inicioHTML;
        html +="\n\t<tr style=\"background-color: skyblue\">";
        html +="\n\t<td>Lexema</td>\n" +
        "\t\t<td>Descripción</td>\n" +
        "\t\t<td>Línea</td>\n" +
        "\t\t<td>Columna</td>";
        html +="</tr>";
        
        for (int j=0; j< lineas.length; j++){    
            for(int i=0; i< lineas[j].length(); i++){
                if (!Character.isDigit(lineas[j].charAt(i)) && !Character.isAlphabetic(lineas[j].charAt(i)) 
                    && ( 32 > lineas[j].charAt(i) ||  126 < lineas[j].charAt(i)) ){
                    html +="\n\t<tr>";
                    html +="\n\t\t<td>"+lineas[j].charAt(i)+"</td>\n" +
                    "\t\t<td>Error Léxico</td>\n" +
                    "\t\t<td>"+j+"</td>\n" +
                    "\t\t<td>"+i+"</td>";
                    html +="</tr>";
                    
                    System.out.println("Error: "+lineas[j].charAt(i)+ "en la fila "+(j) +" y columna "+i);
                    consola+="Error: \""+lineas[j].charAt(i)+ "\" en la fila "+(j) +" y columna "+i+"\n";
                }
            }
        }
        html +=finalHTML;
        return new String[] {html, consola};
    }    
    /*
    */
    
    static String ReporteLexemas(String texto){
        String html = inicioHTML;
        
        html +="\n\t<tr style=\"background-color: hotpink\">";
        html +="\n\t<td>Lexema</td>\n" +
        "\t\t<td>Token</td>\n" +
        "\t\t<td>Línea</td>\n" +
        "\t\t<td>Columna</td>";
        html +="</tr>";
        
        texto= reemplazarComentarios(texto);
        Scanner lexico  = new Scanner(new BufferedReader( new StringReader(texto)));
        Parser sintactico =new Parser(lexico);
        //System.out.println("Salidas --- "+sintactico.salidas+"---");
        String result = "";
        try {   
            //Se ejecuta el lexico y sintactico.
            
            sintactico.parse();
            
            for (int i = 0; i < sintactico.salidas.size(); i++) {
                result += sintactico.salidas.get(i) + '\n';
            }
        }catch (Exception ex) {
            //Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error fatal en compilación de entrada.");
        }
            System.out.println("Resultado << "+result+" >>");
            for (int i = 0; i < lexico.lexemas.size(); i++) {
                /*System.out.println("Lexema: "+lexico.lexemas.get(i).lexema+
                        " | Token: "+lexico.lexemas.get(i).token+
                        " | Fila: "+lexico.lexemas.get(i).fila+
                        " | Columna: "+lexico.lexemas.get(i).columna);*/
                html +="\n\t<tr>";
                html +="\n\t\t<td>"+lexico.lexemas.get(i).lexema+"</td>\n" +
                "\t\t<td>"+lexico.lexemas.get(i).token+"</td>\n" +
                "\t\t<td>"+lexico.lexemas.get(i).fila+"</td>\n" +
                "\t\t<td>"+lexico.lexemas.get(i).columna+"</td>";
                html +="</tr>";
            }

        
        html +=finalHTML;
        return html;
    }  
    static String Traducir(String texto){
        String result = "";
        
        texto= reemplazarComentarios(texto);
        Scanner lexico  = new Scanner(new BufferedReader( new StringReader(texto)));
        Parser sintactico =new Parser(lexico);
        
        try {   
            //Se ejecuta el lexico y sintactico.
            
            sintactico.parse();
            
            for (int i = 0; i < sintactico.salidas.size(); i++) {
                result += sintactico.salidas.get(i) + '\n';
            }
        }catch (Exception ex) {
            //Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error fatal en compilación de entrada.");
        }
        
        return agregarTab(result);
    }
    static    String agregarTab(String texto){
        String salida="";
        String [] lineas=texto.split("\n");
        int cTabs =0;
        
        for (String linea : lineas) {
            salida += "\n"+tabulaciones(cTabs) + linea;
            if (linea.contains(":{")) {
                cTabs++;
            } else if (linea.contains("}") && !(linea.contains("{"))) {
                cTabs--;
            }
            salida = salida.replaceAll(";", "");
            salida = salida.replace(":{", ":");            
            //salida = salida.replace("\n}", "\n");            
            salida = salida.replace("\t}", "\t");
        }
        
        return salida;
    }
    
    
    static String tabulaciones(int cantidad){
            String tabulaciones="";
            for(int c=0; c<cantidad;c++){
                tabulaciones+="\t";
            }
            return tabulaciones;
        }    
}
