/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import Utilities.ProductDataIO;
/**
 *
 * @author Admin
 */
public class ProductDataIOTest {
    
    public ProductDataIOTest() {
        
    }

    @org.junit.Test
    public void testReadData1() {
        ProductDataIO pr = new ProductDataIO();
        String str = "Cake 2" + "\n" + "Sweet Cake 2" + "\n" + "Biscuist 2" + "\n";
        Assert.assertEquals(str, pr.readData1());
    }

    @org.junit.Test
    public void testWriteData() {
        
    }
    
}
