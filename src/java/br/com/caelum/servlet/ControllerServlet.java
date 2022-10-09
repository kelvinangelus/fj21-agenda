/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.caelum.servlet;

import br.com.caelum.mvc.logica.Logica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Kelvin Angelus
 */
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        
        String parametro = request.getParameter("logica"); //logica significa se é listar contatos, remover, etc..
        //Exemplo de requisição no navegador: http://localhost:8080/fj21-agenda/mvc?logica=RemoveContatoLogica&id=15
        
        String nomeDaClasse = "br.com.caelum.mvc.logica." + parametro; //"parametro" é o parâmetro da requisição, ou seja,
                                                                       //"logica", "id", etc..
                                                                       
    
        try{
            //Cria um objeto Class em tempo de execução
            Class classe = Class.forName(nomeDaClasse); //Exemplo de nomeDaClasse: "br.com.caelum.mvc.logica.RemoveContatoLogica"
            
            //Instância da Interface Logica
            Logica logica = (Logica) classe.getConstructor().newInstance(); //classe.newInstance() é deprecated
            
            //Invoca o método "executa" da classe instanciada
            //"pagina" recebe uma string de requisição para o servidor
            String pagina = logica.executa(request, response); 
            //Exemplo de string de requisição: mvc?logica=ListaContatosLogica, "lista-contatos.jsp"
            
            request.getRequestDispatcher(pagina).forward(request, response); //forward repassa uma requisição de uma servlet
                                                                             //para outro recurso (servlet, JSP file, HTML file) no servidor
                                                                             //O mesmo objeto request é repassado para o outro recurso
                                                                             //Ver https://www.javatpoint.com/requestdispatcher-in-servlet
            //request.getRequestDispatcher(pagina) retorna um objeto RequestDispatcher. 
            //O objeto retornado é o recurso "lista-contatos.jsp". O forward faz a chamada para esse recurso
        }catch(Exception e){
            throw new ServletException(
                "A lógica de négocios causou uma exceção", e);
        }
    }
}
