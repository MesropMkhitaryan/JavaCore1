package homework.fileutil;

import java.io.*;
import java.nio.CharBuffer;
import java.util.Scanner;

public class FileUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        contentSearch();
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static void fileSearch() {
        System.out.println("please input path of the file");
        String folderPath = scanner.nextLine();
        System.out.println("please input  fileName");
        String fileName = scanner.nextLine();
        File file = new File(folderPath);
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                String name = file1.getName();
                if (name.equals(fileName)){
                    System.out.println(true);
                }
            }
        }
        }




    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։
    static void contentSearch() throws IOException {
        System.out.println("please input path of the file");
        String folderPath = scanner.nextLine();
        System.out.println("please input  word");
        String keyword = scanner.nextLine();

        File file = new File(folderPath);


        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isFile() && file1.canRead()){
                   BufferedReader out = new BufferedReader(new FileReader (file1.getAbsoluteFile()));
                    String line = "";

                    while ((line = out.readLine()) != null) {
                        if (line.contains(keyword)) {
                            System.out.println(file1.getName());
                        }
                    }
                }
            }

        }
    }



    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - txtPath txt ֆայլի փաթը
    // 2 - keyword - ինչ որ բառ
    // տալու ենք txt ֆայլի տեղը, ու ինչ որ բառ, ինքը տպելու է էն տողերը, որտեղ գտնի էդ բառը։
    static void findLines() throws IOException {
        System.out.println("please input path of the textfile");
        String txtPath = scanner.nextLine();
        System.out.println("please input  word");
        String keyword = scanner.nextLine();
        File file = new File(txtPath);

        if (file.isFile() && txtPath.endsWith(".txt")){
            try (BufferedReader out = new BufferedReader(new FileReader (txtPath));) {
                String line = "";
                while ((line = out.readLine()) != null) {
                    if (line.contains(keyword)) {
                        System.out.println(line);
                    }
                }
            }


        }

    }

    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static void printSizeOfPackage() {
        System.out.println("input file path");
        String path = scanner.nextLine();
        File myfile = new File(path);

        if (myfile.exists() && myfile.exists()){
            long length = 0;
            for (File file : myfile.listFiles()) {
                length += file.length();
            }
            System.out.println(length);
        }

    }

    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
    // 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
    // 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
    // 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
    // որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը

    static void createFileWithContent() throws IOException {
        System.out.println("please input where create file");
        String path = scanner.nextLine();
        System.out.println("please input filename");
        String fileName = scanner.nextLine();
        System.out.println("please input content");
        String content = scanner.nextLine();
        File mydirec = new File(path);
        File myfile = new File(path + "\\" +  fileName);

        if (mydirec.isDirectory()){
            if (!myfile.exists()){
                myfile.createNewFile();
               try( BufferedWriter out = new BufferedWriter(new FileWriter(myfile.getAbsoluteFile()))) {
                   out.write(content);
               }

            }

        }
    }

}
