function aviso(){
	alert("Aviso teste");
}

function confirmarExclusao(){
	if (confirm("Deseja realmente excluir?")){
		document.formulario.submit();
	}
}
