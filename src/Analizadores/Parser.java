
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analizadores;

import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Estructuras.Arbol;
import Estructuras.Automata;
import proyecto1olc1.GuardarArchivo;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\035\000\002\002\004\000\002\002\005\000\002\003" +
    "\004\000\002\004\004\000\002\004\005\000\002\005\007" +
    "\000\002\005\007\000\002\010\005\000\002\010\005\000" +
    "\002\013\003\000\002\013\003\000\002\013\003\000\002" +
    "\013\003\000\002\012\003\000\002\012\005\000\002\007" +
    "\004\000\002\007\005\000\002\006\005\000\002\011\005" +
    "\000\002\011\005\000\002\011\004\000\002\011\004\000" +
    "\002\011\004\000\002\016\005\000\002\016\003\000\002" +
    "\016\003\000\002\016\003\000\002\016\003\000\002\016" +
    "\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\070\000\004\010\004\001\002\000\004\037\011\001" +
    "\002\000\004\002\006\001\002\000\004\002\001\001\002" +
    "\000\004\004\072\001\002\000\006\031\034\037\011\001" +
    "\002\000\004\016\014\001\002\000\004\007\013\001\002" +
    "\000\004\002\000\001\002\000\004\031\015\001\002\000" +
    "\004\023\016\001\002\000\012\022\023\024\017\030\024" +
    "\032\021\001\002\000\012\004\ufff7\015\ufff7\021\ufff7\036" +
    "\ufff7\001\002\000\004\004\ufffb\001\002\000\012\004\ufff8" +
    "\015\ufff8\021\ufff8\036\ufff8\001\002\000\006\004\ufffc\015" +
    "\032\001\002\000\012\004\ufff5\015\ufff5\021\ufff5\036\ufff5" +
    "\001\002\000\012\004\ufff6\015\ufff6\021\ufff6\036\ufff6\001" +
    "\002\000\012\004\ufff4\015\ufff4\021\027\036\026\001\002" +
    "\000\012\022\023\024\017\030\024\032\021\001\002\000" +
    "\012\022\023\024\017\030\024\032\021\001\002\000\004" +
    "\004\ufff9\001\002\000\004\004\ufffa\001\002\000\012\022" +
    "\023\024\017\030\024\032\021\001\002\000\006\004\ufff3" +
    "\015\ufff3\001\002\000\004\023\044\001\002\000\004\004" +
    "\043\001\002\000\006\007\uffff\031\034\001\002\000\004" +
    "\004\040\001\002\000\006\007\ufff2\031\ufff2\001\002\000" +
    "\004\004\042\001\002\000\006\007\ufff1\031\ufff1\001\002" +
    "\000\006\031\ufffd\037\ufffd\001\002\000\014\014\045\020" +
    "\046\022\051\026\052\033\050\001\002\000\026\005\061" +
    "\014\045\020\046\022\051\024\057\026\052\030\053\032" +
    "\056\033\050\035\055\001\002\000\026\005\061\014\045" +
    "\020\046\022\051\024\057\026\052\030\053\032\056\033" +
    "\050\035\055\001\002\000\004\004\ufff0\001\002\000\026" +
    "\005\061\014\045\020\046\022\051\024\057\026\052\030" +
    "\053\032\056\033\050\035\055\001\002\000\026\005\061" +
    "\014\045\020\046\022\051\024\057\026\052\030\053\032" +
    "\056\033\050\035\055\001\002\000\026\005\061\014\045" +
    "\020\046\022\051\024\057\026\052\030\053\032\056\033" +
    "\050\035\055\001\002\000\030\004\uffe5\005\uffe5\014\uffe5" +
    "\020\uffe5\022\uffe5\024\uffe5\026\uffe5\030\uffe5\032\uffe5\033" +
    "\uffe5\035\uffe5\001\002\000\026\005\061\014\045\020\046" +
    "\022\051\024\057\026\052\030\053\032\056\033\050\035" +
    "\055\001\002\000\030\004\uffe9\005\uffe9\014\uffe9\020\uffe9" +
    "\022\uffe9\024\uffe9\026\uffe9\030\uffe9\032\uffe9\033\uffe9\035" +
    "\uffe9\001\002\000\030\004\uffe8\005\uffe8\014\uffe8\020\uffe8" +
    "\022\uffe8\024\uffe8\026\uffe8\030\uffe8\032\uffe8\033\uffe8\035" +
    "\uffe8\001\002\000\030\004\uffe6\005\uffe6\014\uffe6\020\uffe6" +
    "\022\uffe6\024\uffe6\026\uffe6\030\uffe6\032\uffe6\033\uffe6\035" +
    "\uffe6\001\002\000\030\004\uffe7\005\uffe7\014\uffe7\020\uffe7" +
    "\022\uffe7\024\uffe7\026\uffe7\030\uffe7\032\uffe7\033\uffe7\035" +
    "\uffe7\001\002\000\004\031\062\001\002\000\004\006\063" +
    "\001\002\000\030\004\uffea\005\uffea\014\uffea\020\uffea\022" +
    "\uffea\024\uffea\026\uffea\030\uffea\032\uffea\033\uffea\035\uffea" +
    "\001\002\000\030\004\uffee\005\uffee\014\uffee\020\uffee\022" +
    "\uffee\024\uffee\026\uffee\030\uffee\032\uffee\033\uffee\035\uffee" +
    "\001\002\000\030\004\uffed\005\uffed\014\uffed\020\uffed\022" +
    "\uffed\024\uffed\026\uffed\030\uffed\032\uffed\033\uffed\035\uffed" +
    "\001\002\000\030\004\uffeb\005\uffeb\014\uffeb\020\uffeb\022" +
    "\uffeb\024\uffeb\026\uffeb\030\uffeb\032\uffeb\033\uffeb\035\uffeb" +
    "\001\002\000\030\004\uffec\005\uffec\014\uffec\020\uffec\022" +
    "\uffec\024\uffec\026\uffec\030\uffec\032\uffec\033\uffec\035\uffec" +
    "\001\002\000\026\005\061\014\045\020\046\022\051\024" +
    "\057\026\052\030\053\032\056\033\050\035\055\001\002" +
    "\000\030\004\uffef\005\uffef\014\uffef\020\uffef\022\uffef\024" +
    "\uffef\026\uffef\030\uffef\032\uffef\033\uffef\035\uffef\001\002" +
    "\000\006\031\ufffe\037\ufffe\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\070\000\004\002\004\001\001\000\010\003\011\004" +
    "\007\005\006\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\010\005\034\006\036\007\035\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\010\010\017\012" +
    "\021\013\024\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\013\030\001\001" +
    "\000\004\013\027\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\013\032\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\006\040\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\011\046\001\001\000" +
    "\006\011\057\016\067\001\001\000\006\011\057\016\066" +
    "\001\001\000\002\001\001\000\006\011\057\016\065\001" +
    "\001\000\006\011\057\016\064\001\001\000\006\011\057" +
    "\016\053\001\001\000\002\001\001\000\006\011\057\016" +
    "\063\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\006\011\057\016" +
    "\070\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    //Clases, objetos, variables, lista, etc... en sintaxis java    
    //Creo una lista de tipo String llamada 'salidas', donde guardare cada uno de las salidas analizadas
    //Para el proyecto se sugiere HashMap
    public List<String> salidas = new ArrayList<String>();
    public Map<String, Double> mapaDouble = new HashMap<>();    
    public Map<String, String> mapaString = new HashMap<>();

    public List<Double> valores = new ArrayList<>();


public void agregarValor(String a){
    try {   
           double decimal = Double.parseDouble(a);
           valores.add(decimal);
        }catch (Exception ex) {
            System.out.println("Error al recibir valor, se ingresara un 0");
            valores.add(0.0);
        }
}

    public ArrayList rangeToArraylist(String range){
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



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= ini EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // ini ::= LLAVIZQ estructura LLAVDER 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ini",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // estructura ::= conjuntos expresiones 
            {
              Object RESULT =null;
		 String salida="def main() :{\n " + "" + "";  RESULT=salida;  salidas.add(salida);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("estructura",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // conjuntos ::= conjunto PTCOMA 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conjuntos",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // conjuntos ::= conjuntos conjunto PTCOMA 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conjuntos",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // conjunto ::= PR_CONJ DOSPUNTOS ID EQUALS lista 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 String conjunto = a+"= {"+b+"}" ; System.out.println(conjunto); RESULT= conjunto; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conjunto",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // conjunto ::= PR_CONJ DOSPUNTOS ID EQUALS rango 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 String conjunto = a+"= "+rangeToArraylist((String) b).toString() ; System.out.println(conjunto); RESULT= conjunto; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conjunto",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // rango ::= simbolo VIRGUILLA simbolo 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		String rango=a+"~"+c; RESULT= rango;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("rango",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // rango ::= simbolo MENOS simbolo 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		String rango=a+"-"+c; RESULT= rango;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("rango",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // simbolo ::= SYMBOL 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT= a;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("simbolo",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // simbolo ::= LETRA 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT= a;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("simbolo",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // simbolo ::= DIGITO 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT= a;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("simbolo",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // simbolo ::= POR 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT= a;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("simbolo",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // lista ::= simbolo 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT= a;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("lista",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // lista ::= lista COMA simbolo 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 String lista = (String) a+ ", "+ (String) b ; RESULT = lista; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("lista",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // expresiones ::= expresion PTCOMA 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresiones",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // expresiones ::= expresiones expresion PTCOMA 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresiones",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // expresion ::= ID EQUALS expresion_en_prefijo 
            {
              Object RESULT =null;
		int nombreleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int nombreright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String nombre = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		Arbol actualito = ((Arbol) b); 
                CrearAutomatas(actualito, nombre);
                RESULT= b;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // expresion_en_prefijo ::= PUNTO componente componente 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		Arbol actual= new Arbol(a); actual.addHijo((Arbol) b); actual.addHijo((Arbol) c); RESULT = actual;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion_en_prefijo",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // expresion_en_prefijo ::= OR componente componente 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		Arbol actual= new Arbol(a); actual.addHijo((Arbol) b); actual.addHijo((Arbol) c); RESULT = actual;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion_en_prefijo",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // expresion_en_prefijo ::= POR componente 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		Arbol actual= new Arbol(a); actual.addHijo((Arbol) b); RESULT = actual;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion_en_prefijo",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // expresion_en_prefijo ::= MAS componente 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		Arbol actual= new Arbol(a); actual.addHijo((Arbol) b); RESULT = actual;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion_en_prefijo",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // expresion_en_prefijo ::= UNKNOWN componente 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		Arbol actual= new Arbol(a); actual.addHijo((Arbol) b); RESULT = actual;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion_en_prefijo",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // componente ::= PARIZQ ID PARDER 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT= new Arbol(a);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("componente",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // componente ::= CHAREX 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT= new Arbol(a.replace("\"","\\\""));
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("componente",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // componente ::= SYMBOL 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT= new Arbol(a);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("componente",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // componente ::= expresion_en_prefijo 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT=a;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("componente",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // componente ::= LETRA 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT= new Arbol(a);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("componente",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // componente ::= DIGITO 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT= new Arbol(a);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("componente",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
