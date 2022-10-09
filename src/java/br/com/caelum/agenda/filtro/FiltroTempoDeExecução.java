/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.caelum.agenda.filtro;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest; //Esta classe herda de ServletRequest
import java.io.IOException;

/**
 *
 * @author Kelvin Angelus
 */
@WebFilter("/*")
public class FiltroTempoDeExecução implements Filter{
    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws IOException, ServletException{
        
        long tempoInicial = System.currentTimeMillis();
        
        chain.doFilter(request, response);
        
        long tempoFinal = System.currentTimeMillis();
        String uri = ((HttpServletRequest) request).getRequestURI(); //Casts objeto 'request' de ServletRequest para HttpServletRequest
        String parametros = ((HttpServletRequest) request).getParameter("logica"); //Se não houver o parâmetro 'logica' na requisição, o valor retornado é null
        
        System.out.println("Tempo da requisição de " + uri + "?logica="
        + parametros + " demorou (ms): " + (tempoFinal - tempoInicial));
    }
    
    //Métodos init e destroy omitidos
}
