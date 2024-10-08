import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DirectoryList {
    public static void main(String[] args) {
        //Cosas
        int opcion = 3;
        Scanner sc = new Scanner(System.in);

        //PATHS
        String path = ".";
        if(args.length > 0){
            path = args[0];
        }
        //ARRAY
        String[] arrayPathsVariados = new String[] {"./resources/archivo.txt","./.gitignore","./resources"};

        do{
            System.out.println("Escoge opcion");
            System.out.println("[0] Inicio tema");
            System.out.println("[1] Ejercicio 1: ¿Se puede ejecutar, leer o escribir?");
            System.out.println("[2] Ejercicio 2: Existe, es directorio o fichero.");
            System.out.println("[3] Ejercicio 3: Tamaño");
            System.out.println("[4] Ejercicio 4: Obtener el directorio padre");
            System.out.println("[5] Ejercicio 5: Listar el contenido de un directorio");
            System.out.println("[6] Ejercicio 6: Crear archivos");
            System.out.println("[7] Ejercicio 7: Borrar y renombrar");
            System.out.println("[default] Salir ");
            opcion = sc.nextInt();
            switch(opcion){
                case 0:
                    inicioTema(path);
                    break;
                case 1:
                    ej1(arrayPathsVariados);
                    break;
                case 2:
                    ej2(arrayPathsVariados);
                    break;
                case 3:
                    ej3(arrayPathsVariados[0]);
                    break;
                case 4:
                    ej4(arrayPathsVariados[0]);
                    break;
                case 5:
                    ej5(path);
                    break;
                case 6:
                    ej6(arrayPathsVariados[2]);
                    break;
                case 7:
                    ej7(arrayPathsVariados[2]+"/creacion.txt");
                    break;
                default:
                    opcion=33;
            }

        }while(opcion!=33);




    }

    public static void inicioTema(String path){
        File file = new File(path);

        if(!file.exists()){
            System.out.println("File does not exist");

        } else{
            System.out.println("File exists");

            if(file.isFile()){
                System.out.println(file + "is a file");

            } else if(file.isDirectory()){
                System.out.println(file + "is a directory");
                File[] arrayFiles = file.listFiles();

                for(File f : arrayFiles){

                    String descripcion = f.isFile()? "-" : "/";
                    System.out.println(descripcion + f.getName());
                }

            }
        }

        System.out.println(path);

    }


    public static void ej1(String[] arrayPathsVariados){

        for(String path : arrayPathsVariados) {
            File file = new File(path);

            if (file.canExecute()) {
                System.out.println(file + " se puede ejecutar");
            } else {
                System.out.println(file + " no se puede ejecutar");
            }

            if (file.canRead()) {
                System.out.println(file + " se puede leer");
            } else {
                System.out.println(file + " no se puede leer");
            }

            if (file.canWrite()) {
                System.out.println(file + " se puede escribir");
            } else {
                System.out.println(file + " no se puede escribir");
            }
        }
    }


    public static void ej2(String[] arrayPathsVariados){
        for(String path : arrayPathsVariados){
            File file = new File(path);

            if(file.exists()){
                System.out.print(file + " Existe y su tipo es: ");
                if(file.isDirectory()){
                    System.out.println("Directorio");
                } else if (file.isFile()) {
                    System.out.println("Fichero");
                }
            }else{
                System.out.println(file + " No existe.");
            }
        }
    }


    public static void ej3 (String path){
        File file = new File(path);
        System.out.println(file + "  Tiene un tamaño de. " + file.length());
    }

    public static void ej4 (String path){
        File file = new File(path);
        System.out.println("El directorio padre de: " + file.getName() + " es: ");
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());
    }

    public static void ej5 (String path){
        File file = new File(path);
        String [] listado = file.list();
        File[] files = file.listFiles();

        System.out.println("- Listado con list()");
        for(String l : listado){
            System.out.println(l);
        }
        System.out.println("- Listado con listFiles()");
        for(File f : files){
            System.out.println(f.getName());
        }
    }

    public static void ej6(String path){
        path+="/creacion.txt";

        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error (es posible que el archivo ya exista)");
            e.printStackTrace();
        }
    }

    public static void ej7(String path){
        File file = new File(path);
        file.renameTo(new File(path));
        if(file.exists()) {
            file.delete();
        }
    }

    //9  file.toPath



}
