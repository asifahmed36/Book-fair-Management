/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author USER
 */
public class Stall {
    private String no;
    private String stallname;
    private String ownername;

    public Stall(String no, String stallname, String ownername) {
        this.no = no;
        this.stallname = stallname;
        this.ownername = ownername;
    }

    public String getNo() {
        return no;
    }

    public String getStallname() {
        return stallname;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setStallname(String stallname) {
        this.stallname = stallname;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    @Override
    public String toString() {
        return "Stall{" + "no=" + no + ", stallname=" + stallname + ", ownername=" + ownername + '}';
    }
    
    
    
}
