<!-- Uso da JSTL neste arquivo -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!-- Usando caminho relativo
O caminho da imagem � relativo a este arquivo cabecalho.jsp 
O diret�rio que contiver cabecalho.jsp tamb�m dever� conter imagens/euzinho.jpg -->

<!-- <image src="imagens/euzinho.jpg" style="width: 10%;"/> -->

<!-- Usando caminho absoluto -->

<!-- src e style s�o atributos da tag img (pode-se usar image a img) -->
<img src="<c:url value="/imagens/euzinho.jpg"/>" style="width: 15%;" />
<h2>Agenda de contatos do(a) Kelvin</h2>
<hr />