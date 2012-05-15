package persistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

public class DaoUsuario extends Dao{
	
	public void cadastrar (Usuario u) throws Exception{
		open();
			stmt = con.prepareStatement("insert into tb_usuario values(null,?,?,?,?,?,?,?,?)");
			stmt.setString(1, u.getNomeUsuario());
			stmt.setString(2, u.getLoginUsuario());
			stmt.setString(3, u.getSenhaUsuario());
			stmt.setString(4, u.getPerfilUsuario());
			stmt.setString(5, u.getRgUsuario());
			stmt.setString(6, u.getCpfUsuario());
			stmt.setDate(7, (Date)u.getDataNascimento());
			stmt.setString(8, u.getSexoUsurio());
			stmt.execute();
			stmt.close();		
		close();		
	}
	
	public void alterar (Usuario u) throws Exception{
		open();
			stmt = con.prepareStatement("update tb_usuario set nome_usuario=?,login_usuario=?,senha_usuario=?,perfil_usuario=?,rg_usuario=?,cpf_usuario=?,data_nascimento_usuario=?,sexo_usuario=? where codigo_usuario=?");
			stmt.setString(1, u.getNomeUsuario());
			stmt.setString(2, u.getLoginUsuario());
			stmt.setString(3, u.getSenhaUsuario());
			stmt.setString(4, u.getPerfilUsuario());
			stmt.setString(5, u.getRgUsuario());
			stmt.setString(6, u.getCpfUsuario());
			stmt.setDate(7, (Date)u.getDataNascimento());
			stmt.setString(8, u.getSexoUsurio());
			stmt.execute();
			stmt.close();		
		close();		
	}
	
	public void excluir (Usuario u) throws Exception{
		open();
			stmt = con.prepareStatement("delete from tb_usuario where codigo_usuario = ?");
			stmt.setInt(1, u.getCodigoUsuario());
			stmt.execute();
			stmt.close();
		close();
	}
	
	public List<Usuario> findAll() throws Exception{
		List<Usuario> lista = new ArrayList<Usuario>();
		open();  //abre a conexao com o banco
		stmt = con.prepareStatement("select * from usuario");
		rs = stmt.executeQuery();  // o objeto RS esta preechido com toda informacao da consulta
		while (rs.next()){
		//metodo sobrecarregado - o idpessoa é a coluna do banco de dados 
/*			Usuario p = new Usuario(
						rs.getInt("codigoUsuario"),
						rs.getString("nomeUsuario"),
						rs.getString("sexoUsuario")
						passar todos os parametros aqui.
					);
			lista.add(p);
*/		}
		rs.close();  // fecha a conexao com a tabela
		close();   // fecha a conexao com o banco
		return lista;
	}

}
