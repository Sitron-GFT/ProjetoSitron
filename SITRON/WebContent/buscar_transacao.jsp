<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gft.sitron.*"%>
<%@page import="com.gft.Stax.SelectXMLTransacao"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="buscar_transacao.css">

<script src="jquery-2.1.3.min.js" type="text/javascript"></script>

<link rel="stylesheet" href="jquery-ui.css">
<script src="jquery-2.1.3.min.js"></script>
<script src="jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">

<script type="text/javascript">

function validateForm() {
    var x = document.forms["search_form"]["nomeTransacao"].value;
    if (x == null || x == "") {
        alert("Você deve digitar o Nome da Transação");
        return false;
	}
}
	
	var request;

	function excluir(id) {

		$(document).on('click','a[name="excluir"]', function(event){
		       event.preventDefault();      

		           var idvar = $(this).attr('id'); 
		    	   $("#dialog-confirm").dialog({ 
					resizable : false,
					height : 100,
					modal : true,
					title : "Deseja excluir o ítem?",
					buttons : {Sim : function() {
									$(this).dialog('close');
									simexcluir(idvar);
									$('#test').load(location.href);
									},
							   Não : function() {$(this).dialog('close');}
					}
				}); 
		   });
	}

	function simexcluir(id){
		var v = id;
		var url = "delete_transacao.jsp?id=" + v;

		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		try {
			request.onreadystatechange = getInfo;
			request.open("POST", url, false);
			request.send();

		} catch (e) {
			alert("Unable to connect to server");
		}
	}
	
	function getInfo() {
		if (request.readyState == 4) {
			var val = request.responseText;
			document.getElementById('retorno').innerHTML = "Transação excluída com sucesso.";
		} else {
			document.getElementById('retorno').innerHTML = "Transação não pode ser excluída."
		}

	}

	$(function() {
		$("input[type=submit], input[type=reset], a, button").button().click(
				function(Cadastrar) {
					event.preventDefault();
				});
	});
</script>

</head>
<body>

		<form id="search_form" method="GET" onsubmit="return validateForm()">
		
				<h2 align="center">
					Nome da Transação: <input type="text" name="nomeTransacao" size="60">					
				</h2>

				<h2 align="center">
				<input id="teste" type="submit" value="Pesquisar" onclick="myFunction()"> 
				<input type="reset" value="Limpar Dados">
				</h2>
				
				<script>
					function myFunction() {
						document.getElementById("test").style.display = "table";
					}
				</script>
			
				<hr width="600">
		

				<%
					String nomeTransacao = request.getParameter("nomeTransacao");
					if (nomeTransacao != null) {
				%>
				<table id="test" align="center">
					<thead>
						<tr bgcolor="#F1F1F1">
							<td align=center><h2>Nome</h2></td>
							<td align=center><h2>Situação</h2></td>
							<td align=center><h2>Descrição</h2></td>
							<td align=center><h2>Ação</h2></td>
						</tr>
					</thead>

					<tbody>
						<%
							SelectXMLTransacao s = new SelectXMLTransacao();
							List<Transacao> lista = new ArrayList<Transacao>();
							lista = s.selectTransacao(nomeTransacao);

							for (Transacao t : lista) {
						%>
						<tr align=center>
							<td align=center><h2><%=t.getNomeTransacao()%></h2></td>
							<td align=center><h2><%=t.getCodSituacaoTransacao()%></h2></td>
							<td align=center><h2><%=t.getDescTransacao()%></h2></td>
							<td align=center><h2><a href="editar.jsp?id=<%=t.getNomeTransacao()%>">Editar</a> | <a
							id="<%=t.getNomeTransacao()%>" name="excluir" onclick="excluir(this.id)">Excluir</a></h2></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<%
					}
				%>

		</form>
<div id="dialog-confirm">
		<p>
			<span class="ui-icon ui-icon-alert"
				style="float: left; margin: 0 7px 20px 0;"></span>
		</p>
	</div>
</body>
</html>







