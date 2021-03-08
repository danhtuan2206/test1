/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Order implements Serializable{
    String customerName;
    Date orderDate;
    String userCode;
    String status;
    int productId;
    int quantity;
    double amount;

    public Order(String customerName, Date orderDate, String userCode, String status, int productId, int quantity) {
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.userCode = userCode;
        this.status = status;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Order(String customerName, Date orderDate, String userCode, String status, int productId, int quantity, double amount) {
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.userCode = userCode;
        this.status = status;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
    }
    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    
}
