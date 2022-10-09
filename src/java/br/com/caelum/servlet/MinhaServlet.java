/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.caelum.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Kelvin Angelus
 */
@WebServlet("/minhaServlet")
public class MinhaServlet extends HttpServlet{
    
     public void init(ServletConfig config) throws ServletException{
         super.init(config);
         log("Iniciando a servlet");
     }
     
     public void destroy(){
         super.destroy();
         log("Destruindo a servlet");
     }
     
     protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
         //Código do método service
         PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Init e Destroy</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Testando o Init e Destroy</h1>");
        out.println("</body>");
        out.println("</html>");
     }
}
