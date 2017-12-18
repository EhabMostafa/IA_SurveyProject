/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataBaseHandle.Crud;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class LogIn extends HttpServlet {

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
            out.println("<title>Servlet LogIn</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LogIn at " + request.getContextPath() + "</h1>");
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
   // String type  = request.getParameter("type");  
   
      
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
         String n=request.getParameter("username");  
    String p=request.getParameter("password");  
    PrintWriter out = response.getWriter();  
    HttpSession session = request.getSession(true);
     String pass="";
    Crud crud = new Crud();
    int id;
    ResultSet result = null ;
     result=  crud.select("admin","UserName",n);  
        try {
            if (result.next()){
                
                pass  = result.getString("password");
                if(pass.equals(p)){  
                    String ID = result.getString("id");
                    System.out.println("ID ely 3awzah "+ID);
                    session.setAttribute("UserID",ID);
                    
                    RequestDispatcher rd=request.getRequestDispatcher("JSP/HomePage.jsp");  // han7ot el page ely han3ml 3leha redirect
                     rd.forward(request,response);  
                 }  
                else{  
                    out.print("Sorry username or password error");  
                }
            } 
            else {
               result=  crud.select("user","UserName",n);  
               if(result.next()){
               pass  = result.getString("password");
                if(pass.equals(p)){  
                      String ID = result.getString("id");
                    System.out.println("ID ely 3awzah "+ID);
                    session.setAttribute("UserID",ID);
                    RequestDispatcher rd=request.getRequestDispatcher("JSP/HomePage.jsp");  // han7ot el page ely han3ml 3leha redirect
                     rd.forward(request,response);  
                 }  
                else{  
                    out.print("Sorry username or password error");  
                }
            }
               else {
                   out.print("Sorry username is incorrect");
               }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
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
    
}
