<%@page import="com.gft.sitron.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gft.Stax.SelectXMLTransacao"%>
<%@page import="org.jdom2.Element"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="editar.css">

<link rel="stylesheet" href="jquery-ui.css">
<script src="jquery-2.1.3.min.js"></script>
<script src="jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">

<script>

$(function() {
	$( "input[type=submit], input[type=reset], a, button" )
	.button()
	.click(function( UpdateTransacao ) {
	event.preventDefault();
	});
	});
    
$(function() {
	$( "#radio" ).buttonset();
	});
    
</script>

</head>
<body>
	<%
		String nomeTransacao = request.getParameter("id");

		if (nomeTransacao != null) {

			SelectXMLTransacao s = new SelectXMLTransacao();
			List<Transacao> lista = new ArrayList<Transacao>();
			lista = s.selectTransacao(nomeTransacao);
			
			List<Element> listrequest = s.selectRequest(nomeTransacao);
			List<Element> listresponse = s.selectResponse(nomeTransacao);

			for (Transacao t : lista) {
	%>

	<form action="UpdateTransacao" name="main_form" method="post">
		<input type="hidden" name="redirect" value="<%=request.getHeader("referer")%>">
		<input type="hidden" name="nomeTransacao" value="<%=t.getNomeTransacao()%>">

		<label>Nome da Transação:</label>
		<u><%=t.getNomeTransacao()%></u>
		<p></p>
		
		<label>Descrição:</label>
		<input type="text" name="descTransacao" size="60" value="<%=t.getDescTransacao()%>">
		<p></p>
		
		<label>Status:</label>
		<div id="radio"> 
			<input type="radio" id="Ativo" name="codSituacaoTransacao"	value="Ativo" <%if (t.getCodSituacaoTransacao().equals("Ativo")) {%> checked="checked"<%}%>><label for="Ativo">Ativado</label> 
			<input type="radio"	id="Desativado" name="codSituacaoTransacao" value="Desativado" <%if (t.getCodSituacaoTransacao().equals("Desativado")) {%> checked<%}%>><label for="Desativado">Desativado</label>
		</div>		
		<p></p>
		
		<div style= "float: left; width: 50%;">
		<h2 align="center">Request</h2> <textarea name="requestTransacao" rows="30" cols="68"><%=listrequest.get(0).getValue()%></textarea>
		</div>
		
		<div style="float: right; width: 50%;">	
		<h2 align="center">Response</h2> <textarea name="responseTransacao" rows="30" cols="68"><%=listresponse.get(0).getValue()%></textarea></th>
		</div>

		<p></p>

		<div style= "text-align:center;">
		<input type="submit" value="Confirmar" /> 
		<input type="reset" value="Limpar" />
		</div>	
			
	</form>
	<%
		}
	%>
	<%
		}
	%>
</body>
</html>
