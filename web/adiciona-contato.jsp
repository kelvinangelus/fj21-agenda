<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<html>
    <head>
        <title>Adiciona Contatos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/jquery-ui.min.css">
        <script src="external/jquery/jquery.js"></script>
        <script src="js/jquery-ui.min.js"></script>
    </head>
    <body>
        <c:import url="cabecalho.jsp" />
        <h1>Adiciona Contatos</h1>
        <hr/>
        <!-- Melhoria: fazer o action para mvc?logica=AdicionaContatoLogica -->
        <form action="adicionaContato"> <!-- Envia a requisição para AdicionaContatoServlet.java -->
            Nome: <input type="text" name="nome"/><br />
            E-mail: <input type="text" name="email"/><br/>
            Endereço: <input type="text" name="endereco"/><br/>
            Data Nascimento: <caelum:campoData id="dataNascimento" /><br/>
            
            <!-- Data Nascimento: <input type="text" name="dataNascimento"/><br/> -->
            <input type="submit" value="Gravar"/>
        </form>
        <c:import url="rodape.jsp" />
    </body>
</html>
