package persistencia;

import java.sql.*;

public abstract class Dao {

	protected Connection con;  // é a interface de conexao com o banco
	protected PreparedStatement stmt;  // recebe e prepara um comando SQL
	protected ResultSet rs;  // guarda os registros de uma consulta SQL
	
	public void open()throws Exception{
		Class.forName("com.mysql.jdbc.Driver"); // é o caminho da classe de acesso ao banco
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/odonto","root","odonto"); // caminho do banco, usuario, senha
	}
	
	public void close()throws Exception{
		con.close();
	}
	
	
}
