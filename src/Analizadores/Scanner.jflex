

/* 1. Package e importaciones */
package Analizadores;
import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.List;

%%
/* 2. Configuraciones para el analisis (Opciones y Declaraciones) */
%{
    //Codigo de usuario en sintaxis java
    //Agregar clases, variables, arreglos, objetos etc...
    public class Lexema{        
            public String lexema;
            public String token;
            public int fila;
            public int columna;


            public Lexema(String lexema, String token, int fila, int columna){
            this.lexema = lexema;
            this.token = token;
            this.fila = fila;
            this.columna = columna;
        }
    }

    public List<Lexema> lexemas = new ArrayList<Lexema>();

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
//%debug

//Inicializar el contador de yychar y fila con 1
%init{ 
    yyline = 1; 
    yychar = 1; 
%init}

//Expresiones regulares
BLANCOS=[ \r\t]+

DIGIT=[0-9]


LETRA = [A-Za-z]

ID = [A-Za-z_][A-Za-z0-9_]+
ELEMENT = [A-Za-z0-9]|[\x20-\x7E]

CHAREX = \"[.+{}*|]\"

STR  =   \"([^\"]|"\\\"")+\"


LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

comentarioSimple = "//"(InputCharacter)*(LineTerminator)?

//Reglas Semanticas

//Palabras reservadas
%%
"conj" {  
    System.out.println("Reconocio PR: "+yytext()); 
    lexemas.add( new Lexema(yytext(),"Palabra Reservada",yyline,yychar));
    return new Symbol(sym.PR_CONJ,yyline,yychar,yytext());}     

//Simbolos importantes
";" { 
    System.out.println("Reconocio "+yytext()+" punto y coma"); 
    lexemas.add( new Lexema(";"," punto y coma",yyline,yychar));
    return new Symbol(sym.PTCOMA,yyline,yychar,yytext());     
} 
"," { 
    System.out.println("Reconocio "+yytext()+" coma"); 
    lexemas.add( new Lexema(";"," coma",yyline,yychar));
    return new Symbol(sym.COMA,yyline,yychar,yytext());     
}
"(" { 
    System.out.println("Reconocio "+yytext()+" parentesis abre"); 
    lexemas.add( new Lexema("(","Abre parentesis",yyline,yychar));    
    return new Symbol(sym.PARIZQ,yyline,yychar,yytext());
} 
")" { 
    System.out.println("Reconocio "+yytext()+" parentesis cierra"); 
    lexemas.add( new Lexema(")","Cierra parentesis",yyline,yychar));
    return new Symbol(sym.PARDER,yyline,yychar,yytext());
} 
"}" { 
    System.out.println("Reconocio "+yytext()+" llave cierra"); 
    lexemas.add( new Lexema("}","Cierra llave",yyline,yychar));
    return new Symbol(sym.LLAVDER,yyline,yychar,yytext());    
} 
"{" { 
    System.out.println("Reconocio "+yytext()+" llave abre"); 
    lexemas.add( new Lexema("{","Abre llave",yyline,yychar));
    return new Symbol(sym.LLAVIZQ,yyline,yychar,yytext());
} 
"->" { 
    System.out.println("Reconocio "+yytext()+" equal"); 
    lexemas.add( new Lexema("->","Equal",yyline,yychar));
    return new Symbol(sym.EQUALS,yyline,yychar,yytext());
}
"-" { 
    System.out.println("Reconocio "+yytext()+" menos"); 
    lexemas.add( new Lexema("-","Guión",yyline,yychar));
    return new Symbol(sym.MENOS,yyline,yychar,yytext());
}
"~" { 
    System.out.println("Reconocio "+yytext()+" virguilla"); 
    lexemas.add( new Lexema("~"," virguilla",yyline,yychar));
    return new Symbol(sym.VIRGUILLA,yyline,yychar,yytext());
}
":" { 
    System.out.println("Reconocio "+yytext()); 
    lexemas.add( new Lexema(yytext(),"Dos Puntos",yyline,yychar));
    return new Symbol(sym.DOSPUNTOS,yyline,yychar,yytext()); 
} 



//Operaciones 
 
"." { 
    System.out.println("Reconocio operador "+yytext()+" punto"); 
    lexemas.add( new Lexema(".","OPerador Punto",yyline,yychar));
    return new Symbol(sym.PUNTO,yyline,yychar,yytext()); 
} 
"|" {
    lexemas.add( new Lexema(yytext(),"Operador Or",yyline,yychar));
    return new Symbol(sym.OR,yyline,yychar,yytext());
} 
"+" {
    lexemas.add( new Lexema("+","Operador Más",yyline,yychar));
    return new Symbol(sym.MAS,yyline,yychar,yytext());
} 
"*" {
    lexemas.add( new Lexema("*","Operador Multiplicador",yyline,yychar));
    return new Symbol(sym.POR,yyline,yychar,yytext());
}
"?" {
    lexemas.add( new Lexema(yytext(),"Operador ninguna o una vez",yyline,yychar));
    return new Symbol(sym.UNKNOWN,yyline,yychar,yytext());
}

\n {yychar=1;}

{BLANCOS} {} 
{comentarioSimple} {System.out.println("Comentario: "+yytext()); }
{LETRA} {System.out.println("Reconocio letra: "+yytext());    
    lexemas.add( new Lexema(yytext(),"Letra",yyline,yychar));
    return new Symbol(sym.LETRA,yyline,yychar, yytext()); }  
{DIGIT} {System.out.println("Reconocio digito: "+yytext());    
    lexemas.add( new Lexema(yytext(),"Digito",yyline,yychar));
    return new Symbol(sym.DIGITO,yyline,yychar, yytext()); }  
{ID} {System.out.println("Reconocio ID: "+yytext());    
    lexemas.add( new Lexema(yytext(),"ID",yyline,yychar));
    return new Symbol(sym.ID,yyline,yychar, yytext()); }  

{ELEMENT} {System.out.println("Reconocio simbolo: "+yytext());    
    lexemas.add( new Lexema(yytext(),"Simbolo",yyline,yychar));
    return new Symbol(sym.SYMBOL,yyline,yychar, yytext()); } 

{CHAREX} {System.out.println("Reconocio caracter terminal: "+yytext());    
    lexemas.add( new Lexema(yytext(),"Caracter terminal",yyline,yychar));
    return new Symbol(sym.CHAREX,yyline,yychar, yytext()); } 

. {
    //Aqui se debe guardar los valores (yytext(), yyline, yychar ) para posteriormente generar el reporte de errores Léxicos.
    System.out.println("Este es un error lexico: "+yytext()+ ", en la linea: "+yyline+", en la columna: "+yychar);
}