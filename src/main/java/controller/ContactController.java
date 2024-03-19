/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Dao.ContactDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contact;
import validate.Validate;

/**
 *
 * @author Manh
 */
@WebServlet(name = "ContactController", urlPatterns = {"/ContactController"})
public class ContactController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String buttonClicked = request.getParameter("submit");
        if ("Add".equals(buttonClicked)) {
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String groupname = request.getParameter("group");
            String testphone = request.getParameter("phone");
            if (fname == null || lname == null || groupname == null || testphone == null) {
                request.getRequestDispatcher("Fail.jsp");
                return;
            }
            if (!Validate.isNumeric(testphone) || !Validate.isNotNumeric(lname) || !Validate.isNotNumeric(fname)) {
                request.getRequestDispatcher("Fail.jsp");
            }
            int phone = Integer.parseInt(testphone);
            ContactDao cd = new ContactDao();
            cd.addContact(new Contact(0, phone, fname, lname, groupname));

        } else {
            response.sendRedirect("ListContact.jsp");
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContactController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContactController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");
            switch (theCommand) {
                case "LOAD":
                    loadStudent(request, response);
                    break;
                case "UPDATE":
                    updateStudent(request, response);
                    break;
                case "DELETE":
                    deleteStudent(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("ListContact.jsp");
    }

    private void loadStudent(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        //read student id from the form data
        String contactid = request.getParameter("contactid");
        int id = Integer.parseInt(contactid);
        //get student from the database
        Contact c1 = new ContactDao().getcontact(id);
        //place student in the request attribute
        request.setAttribute("Contact", c1);
        //send to jsp page: update-student-form.jsp
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("update-student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateStudent(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // read contact info from the form data
        int id = Integer.parseInt(request.getParameter("Contactid"));
        String firstName = request.getParameter("firstNameud");
        String lastName = request.getParameter("lastNameud");
        String groupname = request.getParameter("group");
        int phone = Integer.parseInt(request.getParameter("phoneud"));
        //create a new student object
        ContactDao cd1 = new ContactDao();
        cd1.updateContact(new Contact(id, phone, firstName, lastName, groupname));
        //send them back to the "list contact" page
        listStudents(request, response);
    }

    private void deleteStudent(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        //read student id from the form data
        int id = Integer.parseInt(request.getParameter("contactid2"));
        ContactDao cd1 = new ContactDao();
        cd1.deleteUser(id);
        listStudents(request, response);

    }

    private void listStudents(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("ListContact.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
