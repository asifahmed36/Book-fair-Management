/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author USER
 */
public class Venue {
   private String venuename;

    public Venue(String venuename) {
        this.venuename = venuename;
    }

    public String getVenuename() {
        return venuename;
    }

    public void setVenuename(String venuename) {
        this.venuename = venuename;
    }

    @Override
    public String toString() {
        return "Venue{" + "venuename=" + venuename + '}';
    }
   
    
}
