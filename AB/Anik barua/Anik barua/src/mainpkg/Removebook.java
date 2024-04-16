/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author ANIK
 */
public class Removebook {
      private String bookNamelabel;
     private String writerNamelabel;
     private String publisherlabel;

    public Removebook(String bookNamelabel, String writerNamelabel, String publisherlabel) {
        this.bookNamelabel = bookNamelabel;
        this.writerNamelabel = writerNamelabel;
        this.publisherlabel = publisherlabel;
    }

    public String getBookNamelabel() {
        return bookNamelabel;
    }

    public String getWriterNamelabel() {
        return writerNamelabel;
    }

    public String getPublisherlabel() {
        return publisherlabel;
    }

    public void setBookNamelabel(String bookNamelabel) {
        this.bookNamelabel = bookNamelabel;
    }

    public void setWriterNamelabel(String writerNamelabel) {
        this.writerNamelabel = writerNamelabel;
    }

    public void setPublisherlabel(String publisherlabel) {
        this.publisherlabel = publisherlabel;
    }

    @Override
    public String toString() {
        return "Removebook{" + "bookNamelabel=" + bookNamelabel + ", writerNamelabel=" + writerNamelabel + ", publisherlabel=" + publisherlabel + '}';
    }
     
    
}
