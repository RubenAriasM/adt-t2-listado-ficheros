import java.io.File;

public class DirectoryList {
    public static void main(String[] args) {

        String path = ".";

        if(args.length > 0){
            path = args[0];
        }


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
}
