/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataBaseHandle.Crud;
import DataBaseHandle.Pair;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author norhan
 */
public class AddAdminOrUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddAdminOrUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddAdminOrUser at " + request.getContextPath() + "</h1>");
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
        Crud crud = new Crud();
        String type = request.getParameter("type");
        String UserName = request.getParameter("username");
        String Email = request.getParameter("email");
        String PassWord = request.getParameter("password");  
        // Pair p;
         ArrayList<Pair> values = new  ArrayList<Pair>();
         values.get(0).setKey("UserName");
         values.get(0).setValue(UserName);
         values.get(1).setKey("email");
         values.get(1).setValue(Email);
         values.get(2).setKey("password");
         values.get(2).setValue(PassWord); 
        if(type.equals("user")){
            String gender =request.getParameter("gender"); 
            values.get(3).setKey("gender");
            values.get(3).setValue(gender); 
            crud.insertRecord ("user" ,values );
           
        }
        else if (type.equals("admin")){
           crud.insertRecord ("admin" ,values );
        }
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
