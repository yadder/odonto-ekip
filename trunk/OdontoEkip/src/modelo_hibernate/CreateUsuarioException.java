package modelo_hibernate;

import java.io.Serializable;

class CreateUsuarioException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;

	public CreateUsuarioException(String o_codigo_do_usuario_nao_pode_ser_null_ao_c) {
    }
    
}
