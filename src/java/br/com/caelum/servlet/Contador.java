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
@WebServlet("/contador")
public class Contador extends HttpServlet{

    private int contador = 0; //Variável de instância
    
    public void init(ServletConfig config) throws ServletException{
         super.init(config);
         log("Iniciando a servlet");
     }
     
     public void destroy(){
         super.destroy();
         log("Destruindo a servlet");
     }
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
        contador++; //A cada requisição a mesma variável é incrementada
    
        //recebe o writer
        PrintWriter out = response.getWriter();
    
        //escreve o texto
        out.println("<html>");
        out.println("<body>");
        out.println("Contador agora é: " + contador);
        out.println("</body>");
        out.println("</html>");
    } 
}
