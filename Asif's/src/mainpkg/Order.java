/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author USER
 */
public class Order {
    private String bookname;
    private String price;
    private String quantity;

    public Order(String bookname, String price, String quantity) {
        this.bookname = bookname;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBookname() {
        return bookname;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" + "bookname=" + bookname + ", price=" + price + ", quantity=" + quantity + '}';
    }
    
    
    
}
