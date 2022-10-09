<%-- 
    Document   : altera-contato
    Created on : 4 de out de 2022, 21:02:20
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
        <!-- Melhoria: fazer o action para mvc?logica=AlteraContatoLogica -->
        <form action="alteraContato"> <!-- Enviar a requisição para AlteraContatoLogica.java -->
            Alterar o contato: <br/>
            Id: <input type="text" name="id" value="${param.id}"/><br/>
            Nome: <input type="text" name="nome" value="${param.nome}"/><br/>
            E-mail: <input type="text" name="email" value="${param.email}"/><br/>
            Endereço: <input type="text" name="endereco" value="${param.endereco}" /><br/>
            Nascimento: <input type="text" name="dataNascimento" value="${param.dataNascimento}"/><br/>
            
            <input type="submit" value="Gravar"/>
        </form>
    </body>
</html>
