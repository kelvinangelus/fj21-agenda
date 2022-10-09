<%-- 
    Document   : adiciona-contato-logica
    Created on : 8 de out de 2022, 11:11:19
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
        <form action="adicionaContatoLogica"> <!-- Envia a requisição para AdicionaContatoLogica.java -->
            Adicionar um contato: <br/>
            Nome: <input type="text" name="nome" required><br/>
            Email: <input type="email" name="email"><br/>
            Endereço: <input type="text" name="endereco"><br/>
            Nascimento: <input type="text" name="dataNascimento"> (Formato: dd/MM/yyyy)<br/>
            
            <input type="submit" value="Gravar">
        </form>
    </body>
</html>
