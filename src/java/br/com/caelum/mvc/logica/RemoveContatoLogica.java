/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.caelum.mvc.logica;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;

/**
 *
 * @author Kelvin Angelus
 */
public class RemoveContatoLogica implements Logica{
    public String executa(HttpServletRequest req, HttpServletResponse res){
        
        //Parâmetro id vem na requisição enviada de lista-contatos.jsp para ControllerServlet.service, parâmetro request 
        long id = Long.parseLong(req.getParameter("id"));
        
        Contato contato = new Contato();
        contato.setId(id);
        
        //busca a conexão pendurada na requisição (vem de FiltroConexao.java)
        Connection connection = (Connection) req.getAttribute("conexao");

        //passe a conexão no contrutor
        ContatoDao dao = new ContatoDao(connection);
        dao.remover(contato);
        
        System.out.println("Excluindo contato... ");
        
        //return "lista-contatos.jsp"; //Não pode pois "lista-contatos.jsp" não instancia mais ContatoDao 
          return  "mvc?logica=ListaContatosLogica"; //Retorna a string de requisição para ControllerServlet
    }
}
