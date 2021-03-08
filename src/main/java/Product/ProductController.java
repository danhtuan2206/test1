/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import Utilities.ProductDataIO;
import Utilities.Validate;

/**
 *
 * @author Admin
 */
public class ProductController {
    public static ProductController productController = null;
    private Product product;
    private ProductDataIO productDataIO;
    private Validate validate;
  
    public void groupProduct(){
        productDataIO = new ProductDataIO();
        
        productDataIO.readData1();
    }
}
