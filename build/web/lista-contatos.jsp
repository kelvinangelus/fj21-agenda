<%-- 
    Document   : lista-contatos
    Created on : 22 de set de 2022, 09:34:18
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
        
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
        <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
        <c:import url="cabecalho.jsp" />
        
        <!-- cria o DAO -->
        <!-- jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"/ --> 
        <!-- a linha acima não é mais utilizada devido à criação da classe ListaContatosLogica --> 
        
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Email</th>
                <th>Endereço</th>
                <th>Nascimento</th>
                <td colspan="2" align="center">
                    <a href="adiciona-contato-logica.jsp">Adicionar</a>
                </td>
            </tr>
            <!-- percorre contatos montando as linhas da tabela -->
            <!-- {dao.lista} se usar a instância de ContatoDao -->
            <c:forEach var="contato" items="${contatos}" varStatus="id" > <!-- contatos vem de ListaContatosLogica.java -->
            
                <tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
                    <td>${contato.nome}</td>
                    <td>
                        <c:if test="${not empty contato.email}">
                            <a href="mailto:${contato.email}">${contato.email}</a>
                        </c:if>
                        <c:if test="${empty contato.email}">
                            E-mail não informado
                        </c:if>
                    </td>
                    <td>${contato.endereco}</td>
                    <td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
                    <td>
                        <a href="mvc?logica=RemoveContatoLogica&id=${contato.id}">Remover</a>
                    </td>
                    <td>
                        <a href="altera-contato.jsp?id=${contato.id}&nome=${contato.nome}&email=${contato.email}
                           &endereco=${contato.endereco}&dataNascimento=${contato.dataNascimentoFormatada}">Alterar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:import url="rodape.jsp" />
    </body>
</html>
