import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter source file: ");
        String sourcePath = scanner.nextLine();
        System.out.println("enter destination file: ");
        String destPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try{
            copyFileUsingJava7File(sourceFile,destFile);
        } catch (IOException e) {
            System.out.println("Can't copy file");
            System.out.println(e.getMessage());
        }
    }
    public static void  copyFileUsingJava7File(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    public static void  copyFileUsingStream(File source, File dest) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream(source);
            fos = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        }
        finally {
            fis.close();
            fos.close();
        }
    }
}