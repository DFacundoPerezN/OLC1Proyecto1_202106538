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

## Errores Lexicos de Statpy
<details> 
<summary> Descripcion</summary>
Recorre el texto ingresado y lee caracter por caracter buscando uno inválido el cual agrega una linea a la tabla en HTML.

```Java
  static String erroresLexicosStatPy(String texto){
        String[] lineas = texto.split("\n");
        String html = inicioHTML;
        html +="\n\t<tr style=\"background-color: skyblue\">";
        html +="\n\t<td>Lexema</td>\n" +
        "\t\t<td>Descripción</td>\n" +
        "\t\t<td>Línea</td>\n" +
        "\t\t<td>Columna</td>";
        html +="</tr>";
        
        for (int j=0; j< lineas.length; j++){   
            //lineas[j] = lineas[j].replaceAll("	", "  "); //Representa la linea/columna del texto ingresado
            //
            for(int i=0; i< lineas[j].length(); i++){
                if (!Character.isDigit(lineas[j].charAt(i)) && !Character.isAlphabetic(lineas[j].charAt(i)) 
                    && lineas[j].charAt(i)!='"' && lineas[j].charAt(i)!=' ' && lineas[j].charAt(i)!='\\'
                    && lineas[j].charAt(i)!='/' && lineas[j].charAt(i)!='{' && lineas[j].charAt(i)!='}'
                    && lineas[j].charAt(i)!='.' && lineas[j].charAt(i)!=':' && lineas[j].charAt(i)!=','
                    && lineas[j].charAt(i)!='\t' && lineas[j].charAt(i)!='+' && lineas[j].charAt(i)!='*'
                    && lineas[j].charAt(i)!='=' && lineas[j].charAt(i)!='(' && lineas[j].charAt(i)!=')'
                    && lineas[j].charAt(i)!='<' && lineas[j].charAt(i)!='>' && lineas[j].charAt(i)!=';'
                    && lineas[j].charAt(i)!='$' && lineas[j].charAt(i)!='[' && lineas[j].charAt(i)!=']'){
                    html +="\n\t<tr>";
                    html +="\n\t\t<td>"+lineas[j].charAt(i)+"</td>\n" +
                    "\t\t<td>Error Léxico</td>\n" +
                    "\t\t<td>"+j+"</td>\n" +
                    "\t\t<td>"+i+"</td>";
                    html +="</tr>";
                    //System.out.println(lineas[j]);
                    System.out.println("Error en la fila "+(j) +" y columna "+i+" :"+lineas[j].charAt(i));
                }
            }
        }
        html +=finalHTML;
        return html;
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


## Traduccion de StatPy a Python
<details>
<summary> Descripcion </summary>

Con las herramientas de JFlex y Jcup realiza un analizis sintactico el cual devuelve una lista que tiene todas las traducciones hechas para que se devuelvan y el programa lo imprime en el area de texto de la interfaz.
```Java
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
        
        return result;
    }
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
"void" {  
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
{BOOL} {System.out.println("Reconocio BOOL: "+yytext());  
    lexemas.add( new Lexema(yytext(),"Boolean",yyline,yychar));
    return new Symbol(sym.BOOLEANO,yyline,yychar, yytext());} 
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
    //Creo una lista de tipo String llamada 'salidas', donde guardare cada uno de las salidas analizadas
    //Para el proyecto se sugiere HashMap
    public List<String> salidas = new ArrayList<String>();
    public Map<String, Double> mapaDouble = new HashMap<>();    
    public Map<String, String> mapaString = new HashMap<>();
:} 

// 3. Terminales 
terminal String PTCOMA,PARIZQ,PARDER,LLAVDER,LLAVIZQ,CORDER,CORIZQ,IGUAL,PUNTO,COMA, DOSPUNTOS, DOLLAR;

// 4. No Terminales
non terminal ini, entradas;
non terminal sentencias, sentencia;

// 5. Precedencias
precedence left MAS,MENOS,COMA;
precedence left POR,DIVIDIDO;

// 6. Producciones
start with ini; 
ini::= entradas
;

entradas ::= PR_VOID PR_MAIN PARIZQ PARDER LLAVIZQ sentencias:a LLAVDER
            {: String salida="def main() :{\n " + a + "\n} f__name__ = “__main__”: \nmain()";
                RESULT=salida; 
                salidas.add(salida);:}
            |archivo_json:a {:RESULT=a; salidas.add(""+a);:}
            
;

```
</details>
