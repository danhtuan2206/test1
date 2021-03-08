import Admin.Admin;
import Common.ConsoleColors;
import Common.UserRole;
import Order.Order;
import Order.OrderView;
import Product.Product;
import Product.ProductController;
import Sale.Sale;
import User.User;
import User.UserController;
import Utilities.OrderDataIO;
import Utilities.ProductDataIO;
import Utilities.UserDataIO;
import Utilities.Validate;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Main {
    static ArrayList<Product> products;
    static ArrayList<User> users;
    static Validate validate;
    static UserController userController;
    static ProductController productController;
    static ArrayList<Order> orders;
    public static void main(String[] args) throws ParseException {
        //--//
        SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
        orders = new ArrayList<>();
        orders.add(new Order("Sang", sp.parse("02/03/2000"), "001", "1", 3, 1, 2));
        orders.add(new Order("Sang", sp.parse("02/03/2000"), "001", "1", 3, 1, 2));
        orders.add(new Order("Sang", sp.parse("02/03/2000"), "001", "1", 3, 1, 2));
        new OrderDataIO().writeData(orders);
       
        validate = new Validate();
        userController = UserController.getInstance();
        
        
        //------------------ADD TAM DATA VAO FILE USERS.DAT DE TEST, XOA SAU
        users = new ArrayList<>();
        products = new ArrayList<>();
        
        products.add(new Product(1, "Cake", 23, 23, "Ha Noi"));
        products.add(new Product(1, "Cake", 32, 32, "Hoi An"));
        products.add(new Product(2, "Biscuist", 2, 2, "Hoa Lac"));
        products.add(new Product(2, "Sweet Cake", 3, 3, "Ha Noi"));
        products.add(new Product(3, "Biscuist", 2, 2, "Hoa Lac"));
        products.add(new Product(3, "Sweet Cake", 3, 3, "Ha Noi"));
        
        new ProductDataIO().writeData(products);
        
        users.add(new Admin("admin01", "admin01", "admin01", UserRole.ADMIN));
        users.add(new Sale("sale01", "sale01", "sale01", UserRole.SALE));
        users.add(new Admin("admin02", "admin02", "admin02", UserRole.ADMIN));
        users.add(new Sale("sale02", "sale02", "sale02", UserRole.SALE));

        new UserDataIO().writeData(users);
        //------------------ADD TAM DATA VAO FILE USERS.DAT DE TEST, XOA SAU
        
        
        loginMenu();
        mainMenu();

    }

    private static void printLoginMenu() {
        System.out.println(ConsoleColors.BLUE_BOLD + "--------------------------------");
        System.out.println(ConsoleColors.BLUE_BOLD + "Welcome to Doctor Management Program");
        System.out.println(ConsoleColors.BLUE_BOLD + "1. Login");
        System.out.println(ConsoleColors.BLUE_BOLD + "0. Exit");
        System.out.println(ConsoleColors.BLUE_BOLD + "--------------------------------");
    }

    private static void printAdminMenu() {
        System.out.println(ConsoleColors.BLUE_BOLD + "--------------------------------");
        System.out.println(ConsoleColors.BLUE_BOLD + "ADMIN PANEL");
        System.out.println(ConsoleColors.BLUE_BOLD + "1. View/Add/Update/Delete Product");
        System.out.println(ConsoleColors.BLUE_BOLD + "2. Add/Update Product info");
        System.out.println(ConsoleColors.BLUE_BOLD + "3. View Productinfo incl. Product info");
        System.out.println(ConsoleColors.BLUE_BOLD + "4. View/Add/Update/Delete User; Change User's Password");
        System.out.println(ConsoleColors.BLUE_BOLD + "5. Query & Print out patients info");
        System.out.println(ConsoleColors.BLUE_BOLD + "6. Change password");
        System.out.println(ConsoleColors.BLUE_BOLD + "7. Logout");
        System.out.println(ConsoleColors.BLUE_BOLD + "--------------------------------");
    }

    private static void printDoctorMenu() {
        System.out.println(ConsoleColors.BLUE_BOLD + "--------------------------------");
        System.out.println(ConsoleColors.BLUE_BOLD + "PRODUCT PANEL");
        System.out.println(ConsoleColors.BLUE_BOLD + "1. Add/Update Product info");
        System.out.println(ConsoleColors.BLUE_BOLD + "2. View Product info incl. Product info");
        System.out.println(ConsoleColors.BLUE_BOLD + "3. Change password");
        System.out.println(ConsoleColors.BLUE_BOLD + "4. Log out");
        System.out.println(ConsoleColors.BLUE_BOLD + "--------------------------------");
    }

    private static void loginMenu() {
        int choice = -1;
        while (true) {
            try {
                printLoginMenu();
                choice = validate.getINT_LIMIT("Your choice: ", 0, 1);
                Boolean isLoggedIn = false;
                switch (choice) {
                    case 0:
                        return;
                    case 1:
                        isLoggedIn = userController.login();
                        break;
                    default:
                }

                if (isLoggedIn) {
                    System.out.println(ConsoleColors.PURPLE_BOLD + "LOGGED IN SUCCESSFULLY!!");
                    break;
                } else {
                    System.out.println(ConsoleColors.RED_BOLD + "LOGGED IN FAILED!!");
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private static void mainMenu(){
        User user = userController.getLoggedInUser();

        if (user != null) {
            if (user.getUserRole() == UserRole.ADMIN) {
                adminMenu();
            } else if (user.getUserRole() == UserRole.SALE) {
                doctorMenu();
            }
        }
    }

    private static void adminMenu() {
        int choice = -1;
        while (true) {
            try {
                printAdminMenu();
                choice = validate.getINT_LIMIT("Your choice: ", 1, 7);

                switch (choice) {
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
       
                        break;
                    case 4:
                        break;
                    case 5:
                        ProductController pr = new ProductController();
                        pr.groupProduct();
                        break;
                    case 6:
                        userController.changePassword();
                        break;
                    case 7:
                        userController.logout();
                        loginMenu();
                        mainMenu();
                        return;
                    default:
                        break;

                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private static void doctorMenu() {
        int choice = -1;
        while (true) {
            try {
                printDoctorMenu();
                choice = validate.getINT_LIMIT("Your choice: ", 1, 4);
                
                switch (choice) {
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        userController.changePassword();
                        break;
                    case 4:
                        userController.logout();
                        loginMenu();
                        mainMenu();
                        return;
                    default:
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
