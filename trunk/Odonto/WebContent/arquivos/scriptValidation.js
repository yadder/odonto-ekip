function aviso(){
	alert("Aviso teste");
}

function confirmarExclusao(aURL){
	if (confirm('Deseja realmente excluir?'))
		location.href=aURL;
}

function formatar(src, mask){
	var i = src.value.length;
	var saida = mask.substring(0,1);
	var texto = mask.substring(i);
	if (texto.substring(0,1) != saida){
	    src.value += texto.substring(0,1);
	}
}
