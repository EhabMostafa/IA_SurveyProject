/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataBaseHandle.Crud;
import DataBaseHandle.Pair;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
         Crud crud = new Crud();
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        
        String type = (String) session.getAttribute("type");
        log(type);
        String UserName = request.getParameter("usernameR");
        log(UserName);
        String Email = request.getParameter("email");
        String PassWord = request.getParameter("password");  
        // Pair p;
        if (checkUsername(UserName , type) && checkmail(Email,type)){
         ArrayList<Pair> values = new  ArrayList<Pair>();
         Pair pair = new Pair();
         Pair pair1 = new Pair();
         Pair pair2 = new Pair();
         Pair pair3 = new Pair();
         Pair pair4 = new Pair();
         pair.setKey("UserName");
         pair.setValue(UserName);
         pair1.setKey("email");
         pair1.setValue(Email);
         pair2.setKey("password");
         pair2.setValue(PassWord);
         values.add( pair);
         values.add( pair1);
         values.add( pair2);
         int size = values.size();
        if(type.equals("user")){
            String gender =request.getParameter("gender"); 
            pair3.setKey("gender");
            pair3.setValue(gender);
            pair4.setKey("suspend");
            pair4.setValue("0");
            log(gender);
            values.add( pair3);
            values.add(pair4);
            
           int id = crud.insertRecord ("user" ,values );
           // log(l+"");
             session.setAttribute("UserID", id);
             log(UserName);
             session.setAttribute("UN",UserName);
                        
             RequestDispatcher rd=request.getRequestDispatcher("JSP/HomePage.jsp");
             rd.forward(request,response);  
           
        }
        
        else if (type.equals("admin")){
        crud.insertRecord ("admin" ,values );
       
        }
        }
        else {
            out.print("UserName or Email is aleady taken");
            RequestDispatcher rd=request.getRequestDispatcher("JSP/index.jsp");
             rd.forward(request,response); 
        }
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
    
    protected boolean checkUsername(String userName , String type){
             
        
        //String name = request.getParameter("usernameR");
        //HttpSession Session = request.getSession(true) ;
        //String type = (String)Session.getAttribute("type");
        System.out.println(userName);
        Crud crud = new Crud ();
        //PrintWriter out = response.getWriter();
        ResultSet result = null ;
        if (type.equalsIgnoreCase("admin")){
           result = crud.select("admin","UserName",userName);
        }  
        else if (type.equalsIgnoreCase("user")){
            result = crud.select("user","UserName",userName);
        }
        try {
            if (result.next()){
              //out.print("User name is already taken ");
              return false ;
            }
            else {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckOnUsername.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


   protected boolean checkmail(String email, String type){     
        // String email = request.getParameter("email");
        //String type = request.getParameter("type");
        Crud crud = new Crud ();
       // PrintWriter out = response.getWriter();
        ResultSet result = null ;
        if (type.equalsIgnoreCase("admin")){
           result = crud.select("admin","email",email);
        }  
        else if (type.equalsIgnoreCase("user")){
            result = crud.select("user","email",email);
        }
        try {
            if (result.next()){
             // out.print("email is  taken ");
             return false;
            }
            else {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckOnUsername.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
}
    


