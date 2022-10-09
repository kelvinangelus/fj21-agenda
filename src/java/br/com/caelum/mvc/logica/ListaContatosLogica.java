/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.caelum.mvc.logica;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Kelvin Angelus
 */
public class ListaContatosLogica implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res){ //req e res vêm de ControllerServlet
        List<Contato> contatos = new ContatoDao().getLista(); //Retorna a lista de registros no banco de dados
        
        req.setAttribute("contatos", contatos); //Cria um atributo da requisição chamado "contatos"
                                                //e passa para esse atributo a lista resgatada do banco
        return  "lista-contatos.jsp";           //Retorna para ControllerServlet a string  
                                                //com o nome da página a ser renderizada
                                                //"/WEB-INF/jsp/lista-contatos.jsp" não funcionou
    }
}
