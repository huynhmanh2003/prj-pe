/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DTBconnect.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contact;

/**
 *
 * @author Manh
 */
public class ContactDao {

    public ArrayList<Contact> getContact() {
        Connection con = null;
        ArrayList<Contact> list = new ArrayList<>();
        ConnectDatabase db = new ConnectDatabase();
        PreparedStatement stmt = null;
        try {
            con = db.connect();
            String query = "select * from Contact";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Contact(rs.getInt(1), rs.getInt(5), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContactDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public Contact getcontact(int id) {
        ContactDao c1 = new ContactDao();
        ArrayList<Contact> arr = c1.getContact();
        for (Contact c : arr) {
            if (c.getId() == id) {
                return c;
            } 
            }
        return null;
    }

    public void addContact(Contact u1) {
        Connection con = null;
        PreparedStatement stmt = null;
        ConnectDatabase db = new ConnectDatabase();
        try {
            con = db.connect();
            String query = "insert into Contact(FirstName, LastName, GroupName, Phone)\n"
                    + "values(?,?,?,?);";
            stmt = con.prepareStatement(query);
            stmt.setString(1, u1.getFname());
            stmt.setString(2, u1.getLname());
            stmt.setString(3, u1.getGroupname());
            stmt.setInt(4, u1.getPhone());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User added successfully!");
            } else {
                System.out.println("Failed to add user!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContactDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void deleteUser(int ContactID) {
        Connection con = null;
        PreparedStatement stmt = null;
        ConnectDatabase db = new ConnectDatabase();
        try {
            con = db.connect();
            String query = "DELETE FROM Contact WHERE ID = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, ContactID);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User with ID " + ContactID + " deleted successfully!");
            } else {
                System.out.println("No user found with ID " + ContactID + " to delete.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContactDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void updateContact(Contact u1) {
        Connection con = null;
        PreparedStatement stmt = null;
        ConnectDatabase db = new ConnectDatabase();
        try {
            con = db.connect();
            String query = "UPDATE Contact SET FirstName = ?, LastName = ?, GroupName = ?, Phone = ? WHERE ID = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, u1.getFname());
            stmt.setString(2, u1.getLname());
            stmt.setString(3, u1.getGroupname());
            stmt.setInt(4, u1.getPhone());
            stmt.setInt(5, u1.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Contact updated successfully!");
            } else {
                System.out.println("No Contact found with ID " + u1.getId() + " to update.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContactDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        ContactDao c = new ContactDao();
        c.deleteUser(1);
        System.out.println(c.getContact());
    }
}
