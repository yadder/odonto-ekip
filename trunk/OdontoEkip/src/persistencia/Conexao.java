package persistencia;

import java.sql.*;

public class Conexao {

    private Connection connection = null;
    
	public Connection getConexao() throws SQLException {  
		try {  
			// Carregando o driver
	        Class.forName("com.mysql.jdbc.Driver");
	        
	        //Configurando a conexão com o banco de dados
	        String url = "jdbc:mysql://localhost:3306/odonto";
	        String username = "root";        //nome do usuário      
	        String password = "odonto";      //senha do banco
	        connection = DriverManager.getConnection(url, username, password);
            //Testa sua conexão//  
	        if (connection != null) {
	        	return connection;
	        } else {
	            return null;
	        }
	   } catch (ClassNotFoundException e) {  
		  //Driver não encontrado
	      System.out.println("O driver expecificado não foi encontrado."+e.getMessage());
	      return null;
	   } catch (SQLException e) {
	   	  //Não conseguindo se conectar ao banco
	      System.out.println("Nao foi possível conectar ao Banco de Dados."+e.getMessage());
	      return null;
	   }
	}
}
