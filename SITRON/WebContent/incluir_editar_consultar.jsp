<!DOCTYPE html>
<%@page import="com.gft.sitron.*"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="incluir_editar_consultar.css">
<link rel="stylesheet" href="jquery-ui.css">
<script src="jquery-2.1.3.min.js"></script>
<script src="jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">

<script>
function validateForm() {
	    var x = document.forms["main_form"]["nomeTransacao"].value;
	    if (x == null || x == "") {
	        alert("Você deve digitar o Nome da Transação");
	        return false;
    	}
        var y = document.forms["main_form"]["descTransacao"].value;
        if (y == null || y == "") {
            alert("Você deve digitar a Descrição da Transação");
            return false;
        }
        var z = document.forms["main_form"]["requestTransacao"].value;
        if (z == null || z == "") {
            alert("Você deve digitar o Request");
            return false;
        }
        var w = document.forms["main_form"]["responseTransacao"].value;
        if (w == null || w == "") {
            alert("Você deve digitar o Response");
            return false;
        }
    }  
    
$(function() {
	$( "input[type=submit], input[type=reset], a, button" )
	.button()
	.click(function( Cadastrar ) {
	event.preventDefault();
	});
	});
    
$(function() {
	$( "#radio" ).buttonset();
	});
    
</script>

</head>
<body>

<form action="Cadastrar" name="main_form" onsubmit="return validateForm()" method="post">

	<label for="nomeTransacao">Nome da Transação:</label>
	<input type="text" name="nomeTransacao" id="nomeTransacao" size=60>
	<p></p>
	<label for="descTransacao">Descrição:</label>
	<input type="text" name="descTransacao" id="descTransacao" size="60">
	<p></p>
	<label>Status:</label>
	<div id="radio">
		<input type="radio" id="radio1" name="codSituacaoTransacao" value="Ativo" checked="checked"><label for="radio1">Ativado</label> 
		<input type="radio"	id="radio2" name="codSituacaoTransacao" value="Desativado"><label for="radio2">Desativado</label>
	</div>
	<p></p>

	<div style= "float: left; width: 50%;">
	  	<h2 align="center">Request</h2>
		<textarea name="requestTransacao" rows="30" cols="68"></textarea>
	</div>
	<div style="float: right; width: 50%;">
	    <h2 align="center">Response</h2>
		<textarea name="responseTransacao" rows="30" cols="68"></textarea>
	</div>

	<span class="clear"></span>
	
	<p></p>
	
	<div style= "text-align:center;">
	<input type="submit" value="Confirmar"/>
	<input type="reset"  value="Limpar"/>
	</div>

</form>


</body>
</html>
