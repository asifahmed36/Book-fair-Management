/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author ANIK
 */
public class SellerInformation {
     private String usernamelabel;
     private String passwordlabel;
     private String mobileNumberlabel;
    private String  nationIDlabel;

    public SellerInformation(String usernamelabel, String passwordlabel, String mobileNumberlabel, String nationIDlabel) {
        this.usernamelabel = usernamelabel;
        this.passwordlabel = passwordlabel;
        this.mobileNumberlabel = mobileNumberlabel;
        this.nationIDlabel = nationIDlabel;
    }

    public String getUsernamelabel() {
        return usernamelabel;
    }

    public String getPasswordlabel() {
        return passwordlabel;
    }

    public String getMobileNumberlabel() {
        return mobileNumberlabel;
    }

    public String getNationIDlabel() {
        return nationIDlabel;
    }

    public void setUsernamelabel(String usernamelabel) {
        this.usernamelabel = usernamelabel;
    }

    public void setPasswordlabel(String passwordlabel) {
        this.passwordlabel = passwordlabel;
    }

    public void setMobileNumberlabel(String mobileNumberlabel) {
        this.mobileNumberlabel = mobileNumberlabel;
    }

    public void setNationIDlabel(String nationIDlabel) {
        this.nationIDlabel = nationIDlabel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SellerInformation{");
        sb.append("usernamelabel=").append(usernamelabel);
        sb.append(", passwordlabel=").append(passwordlabel);
        sb.append(", mobileNumberlabel=").append(mobileNumberlabel);
        sb.append(", nationIDlabel=").append(nationIDlabel);
        sb.append('}');
        return sb.toString();
    }

   
    }
   



