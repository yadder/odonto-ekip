function aviso(){
	alert("Aviso teste");
}

function confirmarExclusao(){
	var excluir = confirm ("Deseja realmente excluir?");
	if (excluir){ 
		alert(document.getElementById("botao").value);
		document.form.submit();
	}
}

function confirmOperacao(){
	
}