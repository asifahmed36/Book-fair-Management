/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author ANIK
 */
public class UpdateBookQuantity {
    private String bookNameLabel;
     private String writerNamelabel;
    private String  publisherLabel;

    public UpdateBookQuantity(String bookNameLabel, String writerNamelabel, String publisherLabel) {
        this.bookNameLabel = bookNameLabel;
        this.writerNamelabel = writerNamelabel;
        this.publisherLabel = publisherLabel;
    }

    public String getBookNameLabel() {
        return bookNameLabel;
    }

    public String getWriterNamelabel() {
        return writerNamelabel;
    }

    public String getPublisherLabel() {
        return publisherLabel;
    }

    public void setBookNameLabel(String bookNameLabel) {
        this.bookNameLabel = bookNameLabel;
    }

    public void setWriterNamelabel(String writerNamelabel) {
        this.writerNamelabel = writerNamelabel;
    }

    public void setPublisherLabel(String publisherLabel) {
        this.publisherLabel = publisherLabel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UpdateBookQuantity{");
        sb.append("bookNameLabel=").append(bookNameLabel);
        sb.append(", writerNamelabel=").append(writerNamelabel);
        sb.append(", publisherLabel=").append(publisherLabel);
        sb.append('}');
        return sb.toString();
    }
    
    
}
