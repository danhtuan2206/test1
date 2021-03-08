package Utilities;

import Order.Order;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class OrderDataIO {

    public OrderDataIO() {
    }

    public ArrayList<Order> readData() {
        ArrayList<Order> orders = null;
    try {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("users.dat"));
        orders = (ArrayList<Order>) in.readObject(); 
        in.close();
    }
    catch(Exception e) {
        System.out.println(e.getMessage());
    }
        return orders;
    }

    public void writeData(List<Order> orders) {
        try {
            FileOutputStream fos = new FileOutputStream("users.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(orders);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
