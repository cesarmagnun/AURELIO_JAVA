package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// CLASSE RESPONS�VEL POR OFERECER CONEX�ES COM BANCO DE DADOS.
// A CLASSE EST� NO PADR�O DE PROJETO SIGLETON, OU SEJA APENAS UMA INST�NCIA DA MESMA PODE SER CRIADA.
// A NECESSIDADE DAS CONEX�ES SEREM REQUERIDAS APENAS UMA VEZ POR OUTROS SERVI�OS FORTALECE A ESCOLHA DO USO DA SINGLETON.
public class SingletonFabricaConexao {

	// ATRIBUTO RESPONS�VEL POR REPRESENTAR A �NICA INST�NCIA DA CLASSE
	private static SingletonFabricaConexao instancia;

	// M�TODO CONSTRUTOR EST� PRIVADO PARA N�O SE OBTER MAIS INST�NCIAS DESSA CLASSE.
	private SingletonFabricaConexao() {
	}

	// M�TODO RESPONS�VEL POR FORNCECER A �NICA INST�NCIA DA CLASSE.
	public static SingletonFabricaConexao pegaInstancia() {
		if (instancia == null) {
			instancia = new SingletonFabricaConexao();
		}
		return instancia;
	}
	
	// M�TODO RESPONS�VEL POR OBTER CONEX�ES DE BANCO DE DADOS
	// AS CONEX�ES PODEM SER ADQUIRIDAS EM DOIS HOSTS DE BANCO DE DADOS
	// HOST BD PARA TESTE (DB4FREEE) 
	// HOST BD PARA APRESENTA��O (RASPBERRY)
	// Obs1.: Comente um dos drivers no m�todo forName para poder realizar a conex�o.
	// Obs2.: Comente um dos retornos para usar o banco de dados correpondente.
	// Obs3.: Ao usar o banco de dados do RASPBERRY lembrar que o endere�o do host pode se alterar de acordo com a rede utilizada.
	
	public Connection pegaConexao() {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://db4free.net:3306/teste4tcc?useSSL=false", "cesarmagnun",
					"12345678"); 
//			return DriverManager.getConnection("jdbc:mysql://192.168.15.22:3306/teste", "cesar", "123");  
		} catch (SQLException | ClassNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return null;
	}

}
