/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.caelum.mvc.logica;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kelvin Angelus
 */
//Mapeia a requisição de adiciona-contato.jsp
//@WebServlet("/adicionaContatoLogica") 
public class AdicionaContatoLogica extends HttpServlet{
    
    //A requisição é feita ao clicar no botão Gravar em adiciona-contato.jsp
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String endereco = req.getParameter("endereco");
                
        Contato contato = new Contato();
        
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setEndereco(endereco);
        
        String dataEmTexto = req.getParameter("dataNascimento");
        Calendar dataNascimento = null;
        
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto); //Converte de String para Date e formata
        } catch (ParseException ex) {
            Logger.getLogger(AdicionaContatoLogica.class.getName()).log(Level.SEVERE, null, ex);
        }
        dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(date);
        
        contato.setDataNascimento(dataNascimento);
        
        ContatoDao dao = new ContatoDao();
        dao.adiciona(contato);
        
        RequestDispatcher rd = req.getRequestDispatcher("/contato-adicionado.jsp");
        rd.forward(req, res);
    }
}
