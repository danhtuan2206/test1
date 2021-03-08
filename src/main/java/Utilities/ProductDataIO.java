package Utilities;

import Product.Product;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ProductDataIO {
public ProductDataIO() {
    }

    public String readData1() {
        ArrayList<Product> products = null;
        HashMap<String, Integer> map = new HashMap();
        String str = "";
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\SaleManagement\\Product.dat"));
            products = (ArrayList<Product>) in.readObject();
            
            for (Product i : products) {
                if (map.containsKey(i.getName())) {
                    int count = map.get(i.getName());
                    map.put(i.getName(), ++count);
                } else {
                    map.put(i.getName(), 1);
                }
            }

            System.out.println("Các entry có trong hashMap là: ");
            Set<String> set = map.keySet();
            for (String key : set) {
                System.out.println(key + " " + map.get(key));
                str += key + " " + map.get(key) + "\n";
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return str;
    }

    public void writeData(List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream("D:\\SaleManagement\\Product.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
