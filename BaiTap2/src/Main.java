import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        File source = new File("C:\\Users\\ASUS\\Desktop\\number.txt");
        File destination = new File("C:\\Users\\ASUS\\Desktop\\result.txt");
        if (!source.exists()) {
            System.out.println("Tập tin không tồn tại!");
            return;
        }
        if (!destination.exists()) {
            System.out.println("Tập dest tin không tồn tại!");
            return;
        }
        InputStream sourceStream = null;
        OutputStream destinationStream = null;
        try {
            sourceStream = new FileInputStream(source);
            destinationStream = new FileOutputStream(destination);
            byte[] buffer = new byte[1024];
            int bytesRead;
            long totalBytes = 0;
            while ((bytesRead=sourceStream.read(buffer))!=-1){
                destinationStream.write(buffer,0,bytesRead);
                totalBytes += bytesRead;
            }
            System.out.println("Completed");
            System.out.println(totalBytes);
        } finally {
            sourceStream.close();
            destinationStream.close();
        }
    }
}