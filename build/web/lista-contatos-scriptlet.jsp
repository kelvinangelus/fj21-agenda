<%-- 
    Document   : lista-contatos-scriptlet
    Created on : 21 de set de 2022, 20:05:25
    Author     : Kelvin Angelus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*,
         br.com.caelum.jdbc.dao.*,
         br.com.caelum.jdbc.modelo.*,
         java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>Nome</th>
                <th>Email</th>
                <th>Endereço</th>
                <th>Nascimento</th>
            </tr>
            <%
                ContatoDao dao = new ContatoDao();
                List<Contato> contatos = dao.getLista();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                
                for (Contato contato : contatos){
                     
                String resultado = formatter.format(contato.getDataNascimento().getTime());
            %>
            
            <tr>
                
                <td><%=contato.getNome() %></td>
                <td><%=contato.getEmail() %></td>
                <td><%=contato.getEndereco() %></td>
                <td><%= resultado %></td>
            </tr>
            <%
                }
            %>
</table>
    </body>
</html>
