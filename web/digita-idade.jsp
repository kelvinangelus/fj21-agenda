<%-- 
    Document   : digita-idade
    Created on : 22 de set de 2022, 08:53:14
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
        Digite sua idade e pressione o botão:<br/>
        
        <form action="mostra-idade.jsp">
            <!-- O atributo name identifica esta tag de maneira única na página -->
            Idade: <input type="text" name="idade"/><input type="submit"/> 
        </form>
    </body>
</html>
