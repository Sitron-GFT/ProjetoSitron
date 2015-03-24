<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gft.sitron.*"%>
<%@page import="com.gft.Stax.ListXMLTransacao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">



<script src="jquery-2.1.3.min.js" type="text/javascript"></script>
<script src="jquery-2.1.3.min.js"></script>
<script src="jquery-ui.js"></script>
<link rel="stylesheet" href="jquery-ui.css">
<link rel="stylesheet" type="text/css" href="listar_transacoes.css">

<script type="text/javascript">

$(function() {
	 
		 $( "#radio" ).buttonset();
		 
		 $( "input[type=submit], input[type=reset], a, button" )
			.button()
			.click(function( Cadastrar ) {
			event.preventDefault();
			});
		
	$('input[type="radio"]', '#list_form').change(function() {
		var status = $(this).val();
		console.log(status);

		if (status == 'MostrarTodas') {
			$('tr', 'tbody').show();
		} else {
			$('tr', 'tbody').hide();
			$('tr:contains(' + status + ')', 'tbody').show();
		}
	});

})

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
								location.reload();
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
</script>

</head>
<body>
	<form id="list_form" method="POST">

			<h2 align="center">
			
			Status: 
			<div id="radio">
			<input type="radio" id="Ativo" name="CodSituacaoTransacao" value="Ativo"><label for="Ativo">Ativado</label> 
			<input type="radio" id="Desativado"	name="CodSituacaoTransacao" value="Desativado"><label for="Desativado">Desativado</label>
			<input type="radio" id="Ambos" name="CodSituacaoTransacao" value="MostrarTodas" checked="checked"><label for="Ambos">Mostrar Todas</label>
			</div>
			</h2>

			
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
	
						ListXMLTransacao l = new ListXMLTransacao();
						List<Transacao> lista = new ArrayList<Transacao>();
						lista = l.listTransacao();
												
						for (Transacao t : lista ) {
					%>
									
						<tr>
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


		</form>
	<div id="dialog-confirm">
		<p>
			<span class="ui-icon ui-icon-alert"
				style="float: left; margin: 0 7px 20px 0;"></span>
		</p>
	</div>
</body>
</html>
