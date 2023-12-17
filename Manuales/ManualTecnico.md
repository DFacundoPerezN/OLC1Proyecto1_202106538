# Manual Técnico 
Para la realización del proyecto de Estructura de Datos de Diciembre se utilizaron las TDAs de pilas, colas, listas simples, listas doblemente enlazadas, listas circulares y matrices; en el lenguaje de Java.

## Main
En la clase Main solo se tiene una funcion para llamar a la InterfazInicial
```Java
    public static void main(String[] args) {
        new InterfazInicial().setVisible(true);
}
```

## Abrir Archivo
<details>
<summary> Descripcion </summary>

Funcion que se le asingo al boton "Abrir" para desplegar la ruta del archivo en la barra de texto y la informacion de este en el area de texto.
```Java
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
                                                
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File F =chooser.getSelectedFile();
        String filename=F.getAbsolutePath();
        ubicacionArchivo = filename; 
        jTextField1.setText(filename);           
    
        
        File file = new File(filename);
        try {
            Scanner sex = new Scanner(file);
            String info ="";
            while(sex.hasNextLine()){
                info = info + sex.nextLine()+"\n";
            jTextArea1.setText(info);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
```

</details>

## Guardar Archivo

<details>
<summary> Descripcion </summary>

Con esta funcion se toman los parametros para guardar el archivo
```Java
public class GuardarArchivo {
    static void writeToFile(String fileName, String text){
        try{
            FileWriter file = new FileWriter(fileName);
            BufferedWriter buffer = new BufferedWriter(file);
            
            buffer.append(text);
            
            buffer.close();
        }
        catch(Exception e){
            System.out.println("No se pudo guardar el archivo");
        }
    }
}

```
</details>

## Reemplazar/Ignorrar Comentarios
<details>
<summary> Descripcion </summary>

Con esta funcion se ingoran los comentarios presentes para evitar errores.
```Java
    
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

```
</details>

## Errores Lexicos 
<details> 
<summary> Descripcion</summary>
Recorre el texto ingresado y lee caracter por caracter buscando uno inválido el cual agrega una linea a la tabla en HTML y preparando un texto para sacar por consola.

```Java
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
```
</details>

## Reporte de Lexemas 
<details>
<summary> Descripcion </summary>
Con las herramientas de JFlex y Jcup realiza un analizis lexico el cual devuelve una lista en la que se convierte una tabla de símbolos en HTML.
```Java

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
```

```

</details>


## Creacion del AFN con Thompson 
<details>
<summary> Descripcion </summary>
Se aprovecha la estructura de un arbol para realizar una pusqueda pre order y asi crear el texto para la elaboracion del grafo del AFN con Thompson
```Java
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

```
```
</details>

## Cerradura metodo de subconjuntos
<details>
<summary> Descripcion </summary>
Una cerradura en el metodo de conjutnos es la lista de todos los estados a los que se puede llegar con un grupo de estados utilizando epsilon (a la lista se incluyen estos mismos estados)
```Java
    public List cerradura(List<String> movimientos){
        List cerradura = movimientos;
        //System.out.println("cantidad de movimeintos dentro de esta cerradura: "+movimientos.size());        
        this.cerraduraActual = cerradura;
        String estadoInicial;
        for (int i=0; i<movimientos.size(); i++){  
            estadoInicial = movimientos.get(i);
            
            System.out.println("Buscando cerradura del estado: "+ estadoInicial);
            //cerradura.addAll(estadosAlcanzables("ε",estadoInicial));
            cerradura = agregarTodos(cerradura, estadosAlcanzables("ε",estadoInicial));   //agrego a la cerradura todos los estados con los que el estado puede llegar con epsilon                 
            this.cerraduraActual = cerradura;
            
            System.out.println("cerr("+movimientos.toString()+") = "+ cerradura.toString());
        }       
        System.out.println("++cerr("+movimientos.toString()+") = "+ cerradura.toString()+"\n");
        
        return cerradura;        
    }

```
```
</details>

## Ejemplo parcial formato  Archivo JFlex
<details>
<summary> Descripcion </summary>
JFlex sirve par ael analisis léxico del archivo el cual genrara salidas y partes de codigo.
  
```JFlex
/* 1. Package e importaciones */
package Analizadores;
import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.List;

%%
/* 2. Configuraciones para el analisis (Opciones y Declaraciones) */
%{
    //Codigo de usuario en sintaxis java
%}

//Directivas
%class Scanner
%public 
%cup
%char
%column
%full
%line
%unicode
%ignorecase

//Expresiones regulares
BLANCOS=[ \r\t]+
ENTERO=[0-9]+
DECIMALES=[0-9]+("."[  |0-9]+)?

//Reglas Semanticas
//Palabras reservadas
%%
"conj" {  
    System.out.println("Reconocio PR: "+yytext()); 
    lexemas.add( new Lexema(yytext(),"Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_VOID,yyline,yychar,yytext());}   
/Simbolos importantes
";" { 
    System.out.println("Reconocio "+yytext()+" punto y coma"); 
    lexemas.add( new Lexema(";"," punto y coma",yyline,yychar));
    return new Symbol(sym.PTCOMA,yyline,yychar,yytext());     
} 
//Operaciones
"+" {
    lexemas.add( new Lexema("+","Operador Más",yyline,yychar));
    return new Symbol(sym.MAS,yyline,yychar,yytext());
}

//Aciones con palabras reservadas
{ID} {System.out.println("Reconocio ID: "+yytext());    
    lexemas.add( new Lexema(yytext(),"ID",yyline,yychar));
    return new Symbol(sym.ID,yyline,yychar, yytext()); } 
. {
    //Aqui se debe guardar los valores (yytext(), yyline, yychar ) para posteriormente generar el reporte de errores Léxicos.
    System.out.println("Este es un error lexico: "+yytext()+ ", en la linea: "+yyline+", en la columna: "+yychar);
}
```
</details>

## Ejemplo parcial formato  Archivo Cup
<details>
<summary> Descripcion </summary>
Jcup sirve par ael analisis sintactico del archivo el cual genrara salidas y partes de codigo.
  
```Cup
/* 1. Package e importaciones */
package Analizadores; 
import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 2. Codigo para el parser, variables, metodos 
parser code 
{:
    //Clases, objetos, variables, lista, etc... en sintaxis java
    
public void CrearAutomatas(Arbol arbolActualito, String nombreArchivo){

        String infografo = arbolActualito.graphvizThompson(0) ; //Se saca la informacion del grafo 
        arbolActualito.crearTransitions(infografo);              //Con esta misma informacion(String) se hace la lista de transiciones

        String dataArchivo = "digraph G { \n graph[layout = dot, rankdir = LR] \n\n"+ infografo + arbolActualito.graphvizEstadoAceptacion()+"}"; // es necesario que haga lo de estados de aceptacion
        System.out.println(dataArchivo);
        GuardarArchivo.Graph("Thompson\\"+nombreArchivo, dataArchivo);

        Automata momento = new Automata(arbolActualito.transiciones, arbolActualito.Lexemas(), arbolActualito.estadoAceptacion);
        infografo = momento.metodoSubconjuntos(); //guardamos la base del grafo del AFD en 'infografo'
        dataArchivo = "digraph G { \n graph[layout = dot, rankdir = LR] \n\n"+ infografo +"}"; //Se arregla para el graphviz 
        GuardarArchivo.Graph("AFD\\"+nombreArchivo, dataArchivo);
}

:} 

// 3. Terminales 
terminal String PTCOMA,PARIZQ,PARDER,LLAVDER,LLAVIZQ,CORDER,CORIZQ,IGUAL,PUNTO,COMA, DOSPUNTOS, DOLLAR;

// 4. No Terminales
non terminal ini, estructura;
non terminal conjuntos, conjunto;

// 5. Precedencias
precedence left MAS,MENOS,COMA;
precedence left POR;
precedence left AND,OR;

// 6. Producciones
start with ini; 
ini::= LLAVIZQ estructura LLAVDER
;

estructura ::= conjuntos expresiones
            {: String salida="def main() :{\n " + "" + "";  RESULT=salida;  salidas.add(salida);:}
            
;

conjuntos ::= conjunto PTCOMA 
            | conjuntos conjunto PTCOMA 
;

```
```
</details>
