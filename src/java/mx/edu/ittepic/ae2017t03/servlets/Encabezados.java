/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.ae2017t03.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.math.BigDecimal;
import java.util.Enumeration;

/**
 *
 * @author alba
 */
@WebServlet(name = "Encabezados", urlPatterns = {"/Encabezados"})
public class Encabezados extends HttpServlet {

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
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Encabezados</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Encabezados at " + request.getContextPath() + "</h1>");
            out.println("<h2>"+request.getMethod()+"</h2>");
            out.println("<p>accept:"+request.getHeader("accept")+"<br>");
            out.println("accept-languaje:"+request.getHeader("accept-languaje")+"<br></p>");
            String []params = request.getQueryString().split("&"); // Trae toda la peticion
            out.print("<p>");
            for (int i=0;i<params.length;i++){
                out.println("<strong>"+(i+1)+"."+params[i]+"</strong>");
            }
            out.println("</body>");
            out.println("</html>"); */
                
                JsonObjectBuilder constructor = Json.createObjectBuilder();
                JsonObjectBuilder parameters = Json.createObjectBuilder();
                          
                Enumeration<String> parametros = request.getParameterNames();
                if(parametros != null){
                    while(parametros.hasMoreElements()){
                        String nombreParametro = parametros.nextElement();
                        parameters.add(nombreParametro, request.getParameter(nombreParametro));
                    }
                }
                
                constructor.add("Parameters", parameters);
                
                JsonObject peticion = constructor.build();
                
                out.print(peticion);
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
