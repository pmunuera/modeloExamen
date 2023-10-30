package ModeloExamen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ModeloExamenMain extends Thread {
    static ArrayList<App> aplicaciones = new ArrayList<App>();
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"\\AplicacionesGoogle.txt"));
            
            String nombre="";
            int usuarios = 0;
            int costo = 0;
            while(sc.hasNextLine()){
                String[] linea = sc.nextLine().split(":");
                if(linea[0].equalsIgnoreCase("Aplicacion")){
                    nombre=linea[1].replace(" ", "");
                }
                else if(linea[0].equalsIgnoreCase("Cantidad Usuarios")){
                    usuarios=Integer.parseInt(linea[1].replace(" ", ""));
                }
                else if(linea[0].equalsIgnoreCase("Costo Mensual")){
                    costo=Integer.parseInt(linea[1].replace(" ", ""));
                }

                if(!nombre.equals("") && usuarios!= 0 && costo != 0){
                    aplicaciones.add(new App(nombre, usuarios, costo));
                    System.out.println("Leida la aplicacion "+nombre);
                    nombre="";
                    usuarios = 0;
                    costo = 0;
                }
            }
            sc.close();
            ModeloExamenMain mem = new ModeloExamenMain();
            mem.start();
            try{
                mem.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub

        try {
            String directorio = System.getProperty("user.dir");
            String ruta_NombreArchivo = directorio+"\\output_proceso_google.txt";
            String texto = "";
            for(App a: aplicaciones){
                texto+="\nAplicacion: "+a.getNombre();
                texto+="\nGanancia neta mensual: "+ a.calculoGanancia();
                texto+="\nTotal usuarios anuales: "+ a.totalUsuarios();;
                System.out.println("Cargada aplicacion: "+a.getNombre());
                Thread.sleep(1000);
            }
            File archivo = new File(ruta_NombreArchivo);
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.close();
            System.out.println("Subiendo informacion...");
            System.out.println("Archivo escrito y creado con exito");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
