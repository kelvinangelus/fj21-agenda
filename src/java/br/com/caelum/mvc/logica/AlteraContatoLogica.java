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
import static java.lang.System.out;
import java.sql.SQLException;
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
//Mapeia a requisição enviada por altera-contato.jsp
//@WebServlet("/alteraContato") 
public class AlteraContatoLogica extends HttpServlet{
    
    //A requisição é feita ao clicar no botão Gravar em altera-contato.jsp
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        
        
        long id = Long.parseLong(req.getParameter("id")); //id vem como uma string na requisição
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String endereco = req.getParameter("endereco");
        
        
        String dataEmTexto = req.getParameter("dataNascimento");
        Calendar dataNascimento = null;
        
        try{
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException ex) {
            out.println("Erro de conversão de data");
            //return null; //Para a execução do método
        }
        
        Contato contato = new Contato();
        contato.setId(id);
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setEndereco(endereco);
        contato.setDataNascimento(dataNascimento);
        
        ContatoDao dao = new ContatoDao();
        try {
            dao.altera(contato);
        } catch (SQLException ex) {
            Logger.getLogger(AlteraContatoLogica.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       RequestDispatcher rd = req.getRequestDispatcher("/contato-adicionado.jsp");
       rd.forward(req, res);        
    }
}
