/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author ANIK
 */
public class checkbookavailabity {
    private String booknamelabel;
     private String booktypeComboBox;
     private String pricelabel;

    public checkbookavailabity(String booknamelabel, String booktypeComboBox, String pricelabel) {
        this.booknamelabel = booknamelabel;
        this.booktypeComboBox = booktypeComboBox;
        this.pricelabel = pricelabel;
    }

    public String getBooknamelabel() {
        return booknamelabel;
    }

    public String getBooktypeComboBox() {
        return booktypeComboBox;
    }

    public String getPricelabel() {
        return pricelabel;
    }

    public void setBooknamelabel(String booknamelabel) {
        this.booknamelabel = booknamelabel;
    }

    public void setBooktypeComboBox(String booktypeComboBox) {
        this.booktypeComboBox = booktypeComboBox;
    }

    public void setPricelabel(String pricelabel) {
        this.pricelabel = pricelabel;
    }

    @Override
    public String toString() {
        return "checkbookavailabity{" + "booknamelabel=" + booknamelabel + ", booktypeComboBox=" + booktypeComboBox + ", pricelabel=" + pricelabel + '}';
    }
    
    
}
