/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.caelum.agenda.filtro;

import Util.ConnectionFactory;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kelvin Angelus
 */
@WebFilter("/*") //Registra o filtro no container e indica que todas as requisições passarão por este filtro
public class FiltroConexao implements Filter{
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException{
         
        try{
            Connection connection = new ConnectionFactory().getConnection(); //Abre a conexão
            
            //pendurando a connection na requisição
            request.setAttribute("conexao", connection);
            
            chain.doFilter(request, response); //Prossegue com a requisição
            
            connection.close(); //Fecha a conexão 
    
        }catch (SQLException e) {
            throw new ServletException(e);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(FiltroConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
