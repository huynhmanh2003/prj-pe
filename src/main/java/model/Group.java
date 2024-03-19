/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Manh
 */
public class Group {
    private String groupname,des;

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Group(String groupname, String des) {
        this.groupname = groupname;
        this.des = des;
    }

    @Override
    public String toString() {
        return "Group{" + "groupname=" + groupname + ", des=" + des + '}';
    }
    
}
