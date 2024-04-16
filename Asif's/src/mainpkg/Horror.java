/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author USER
 */
public class Horror {
    private String booklist;

    public Horror(String booklist) {
        this.booklist = booklist;
    }

    public String getBooklist() {
        return booklist;
    }

    public void setBooklist(String booklist) {
        this.booklist = booklist;
    }

    @Override
    public String toString() {
        return "Horror{" + "booklist=" + booklist + '}';
    }
    
    
}
