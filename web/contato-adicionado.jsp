<%-- 
    Document   : contato-adicionado
    Created on : 24 de set de 2022, 09:48:59
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
        <!-- param.nome se refere à variável request.getParameter("nome")
        em AdicionaContatoServlet.java (Expression Language) -->
        Contato ${param.nome} adicionado/alterado com sucesso
    </body>
</html>
