/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.caelum.servlet;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Kelvin Angelus
 */

//Executado ao submeter o formulário de adiciona-contato.jsp (POST request)
@WebServlet("/adicionaContato") //Mapeia a requisição enviada por adiciona-contato.jsp
public class AdicionaContatoServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        //busca o writer
        PrintWriter out = response.getWriter();
        
        //buscando os parâmetros no request
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataEmTexto = request.getParameter("dataNascimento");
        Calendar dataNascimento = null;
    
        try{
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto); //Converte de String para Date e formata
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException ex) {
            out.println("Erro de conversão de data");
            return; //Para a execução do método
        }
        
        //monta um objeto contato
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDataNascimento(dataNascimento);
        
        //busca a conexão pendurada na requisição (vem de FiltroConexao.java)
        Connection connection = (Connection) request.getAttribute("conexao");
        
        //salva o contato
        //ContatoDao dao = new ContatoDao();
        
        //Salva o contato usando o filtro de criação de conexão ao banco
        ContatoDao dao = new ContatoDao(connection);
        dao.adiciona(contato);
        
        /*
        //imprime o nome do contato que foi adicionado
        out.println("<html>");
        out.println("<body>");
        out.println("Contato " + contato.getNome() + " adicionado com sucesso");
        out.println("</body>");
        out.println("</html>");
        */
        
        RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
        rd.forward(request, response);
    }
}