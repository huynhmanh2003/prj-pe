/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Manh
 */
public class Contact {
    private int id,phone;
    String fname,lname,groupname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", phone=" + phone + ", fname=" + fname + ", lname=" + lname + ", groupname=" + groupname + '}';
    }

    public Contact(int id, int phone, String fname, String lname, String groupname) {
        this.id = id;
        this.phone = phone;
        this.fname = fname;
        this.lname = lname;
        this.groupname = groupname;
    }
    
}
