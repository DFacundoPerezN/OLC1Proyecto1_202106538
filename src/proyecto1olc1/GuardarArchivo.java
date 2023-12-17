
package proyecto1olc1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
    
    static public void Graph(String name, String info) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("./Reportes\\"+name+".dot");
            pw = new PrintWriter(fichero);
            
            pw.println(info);
            
            pw.println("}");
        } catch (IOException e1) {
            System.out.println("No se pudo generar la tabla de siguientes...");
            e1.printStackTrace();
            
        } finally {
            try {
                if(null != fichero){
                    fichero.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        
        try {
            String dotPath = "dot";
            String fileInputPath = "./Reportes\\"+name+".dot";
            
            String fileOutputPath = "./Reportes\\"+name+".png";
            
            String tParam = "-Tpng";
            String tOParam = "-o";
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}
