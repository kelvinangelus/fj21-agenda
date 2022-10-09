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
import java.sql.SQLException;
import java.text.DateFormat;
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
@WebServlet(urlPatterns={"/adicionaContatoLogica", "/alteraContato"}) 
public class AdicionaAlteraContatoLogica extends HttpServlet{
    
    //A requisição é feita ao clicar no botão Gravar em adicona-contato-logica.jsp ou altera-contato.jsp
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        
        long id;
        String idTexto = req.getParameter("id"); //Caso o parâmetro não exista na requisição, o valor retornado é null
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String endereco = req.getParameter("endereco");
        
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setEndereco(endereco);
        
        //Instancia um objeto Calendar
        Calendar dataNascimento = Calendar.getInstance();
        //Recebe a String de data do formulário
        String dataEmTexto = req.getParameter("dataNascimento"); 
        //Instância de um formato
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        
        Date data = null;
        try {
            data = formato.parse(dataEmTexto);
        } catch (ParseException ex) {
            Logger.getLogger(AdicionaAlteraContatoLogica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dataNascimento.setTime(data);
                
        //Adiciona a data de nascimento ao contato
        contato.setDataNascimento(dataNascimento);
        
        //Instância de acesso ao banco de dados
        ContatoDao dao = new ContatoDao();
        
        //Se id é null, o método deve adicionar um contato, doutra maneira deve alterar o contato
        if(idTexto==null){
            dao.adiciona(contato);
        }else{  
            id = Long.parseLong(idTexto); //Converte de String para Long
            contato.setId(id);
            try {
                dao.altera(contato);
            } catch (SQLException ex) {
                Logger.getLogger(AdicionaAlteraContatoLogica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/contato-adicionado.jsp");
        rd.forward(req, res);
    }
}
