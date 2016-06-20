
/**
 * Metodo que faz uma pergunta ao usuario antes de tomar uma ação neste caso excluir.
 * @param idUsuario através do id que a exclusão sera feita quando o usuario clicar em confirmar
 */
function confirmaExclusao (idUsuario){
	
	if(window.confirm("Tem Certeza Que deseja Exluir ?")){
		location.href="testeServelet?acao=exc&idUsuario=" + idUsuario;
	}
}