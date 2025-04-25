import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String FILE_PATH = "C:\\Users\\ASUS\\Desktop\\file.txt";
    private static List<Product> productList = new ArrayList<Product>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        readFromFile();
      while (true) {
          System.out.println("_____MENU_____");
          System.out.println("1. Add Product");
          System.out.println("2. display all products");
          System.out.println("3. search product");
          System.out.println("4. exit");
          String choice = scanner.nextLine();
          switch (choice) {
              case "1":
                  addProduct();
                  break;
                  case "2":
                      displayProducts();
                      break;
                      case "3":
                          searchProduct();
                          break;
                          case "4":
                              saveToFile();
                              System.out.println("Thoát chương trình");
                              return;
                              default:
                                  System.out.println("lựa chọn không hợp lệ! ");
                                  break;
          }
      }
    }
    public static void addProduct() {
        System.out.println("Enter product ID: ");
        int productID = scanner.nextInt();
        System.out.println("Enter product name: ");
        String productName = scanner.next();
        System.out.println("Enter product price: ");
        double productPrice = scanner.nextDouble();
        System.out.println("Enter product manufacturer: ");
        String productManufacturer = scanner.next();
        System.out.println("Enter product description: ");
        String productDescription = scanner.next();
        productList.add(new Product(productID, productName, productPrice, productManufacturer, productDescription));
        System.out.println("added product to list");
    }
    public static void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        for (Product product : productList) {
            System.out.println(product);
        }
    }
    public static void searchProduct() {
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine().toLowerCase();
        Boolean findProduct = false;
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(productName)) {
                System.out.println(product);
                findProduct = true;
            }
        }
        if (!findProduct) {
            System.out.println("product not found");
        }
    }
    public static void saveToFile() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(productList);
        } catch (IOException e) {
            System.out.println("error while saving to file "+e.getMessage());;
        }
    }
    public static void readFromFile() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            productList = (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error while reading from file "+e.getMessage());
            productList = new ArrayList<>();
        }
    }
}