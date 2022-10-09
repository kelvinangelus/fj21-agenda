<%-- 
    Document   : bemvindo
    Created on : 21 de set de 2022, 19:52:55
    Author     : Kelvin Angelus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%-- comentário em JSO aqui: nossa primeira página JSP --%>
        
        <%
            String mensagem = "Bem vindo ao sistema de agenda do FJ-21!";
        %>
        <% out.println(mensagem); %>
        
        <br/>
        
        <%
            String desenvolvido = "Desenvolvido por (Kelvin)";
        %>
        <%= desenvolvido %>
        
        <br/>
        
        <%
            System.out.println("Tudo foi executado!");
        %>
    </body>
</html>
