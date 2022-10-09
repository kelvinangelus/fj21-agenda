<%-- 
    Document   : campoData
    Created on : 23 de set de 2022, 14:39:44
    Author     : Kelvin Angelus
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="id" required="true" %>

<%-- any content can be specified here e.g.: --%>
<%-- os atributos id e name do input são passado através do parâmetro id criado em attribute --%>
<%-- o valor "dataNascimento" será passado para os atributos id e name do input --%>
<input type="text" id="${id}" name="${id}" />
<script>
    <%-- o atributo id de uma tag HTML é usado com o caractere # --%>
    $("#${id}").datepicker({dateFormat: 'dd/mm/yy',
                            changeMonth: true,
                            changeYear: true,
                            yearSuffix: "Teste"}
                          );
</script>

<%-- o atributo id de campoData receberá o valor "dataNascimento" e este valor será
passado para os atributos id e name do input. O script abrirá um calendário quando o
foco for para esse input. O valor escolhido no datepicker é enviado para a propriedade 
value do input. O atributo name identifica em qual input os dados foram submetidos --%>