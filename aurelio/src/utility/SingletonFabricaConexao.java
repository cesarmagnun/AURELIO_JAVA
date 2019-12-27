package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// CLASSE RESPONSÁVEL POR OFERECER CONEXÕES COM BANCO DE DADOS.
// A CLASSE ESTÁ NO PADRÃO DE PROJETO SIGLETON, OU SEJA APENAS UMA INSTÂNCIA DA MESMA PODE SER CRIADA.
// A NECESSIDADE DAS CONEXÕES SEREM REQUERIDAS APENAS UMA VEZ POR OUTROS SERVIÇOS FORTALECE A ESCOLHA DO USO DA SINGLETON.
public class SingletonFabricaConexao {

	// ATRIBUTO RESPONSÁVEL POR REPRESENTAR A ÚNICA INSTÂNCIA DA CLASSE
	private static SingletonFabricaConexao instancia;

	// MÉTODO CONSTRUTOR ESTÁ PRIVADO PARA NÃO SE OBTER MAIS INSTÂNCIAS DESSA CLASSE.
	private SingletonFabricaConexao() {
	}

	// MÉTODO RESPONSÁVEL POR FORNCECER A ÚNICA INSTÂNCIA DA CLASSE.
	public static SingletonFabricaConexao pegaInstancia() {
		if (instancia == null) {
			instancia = new SingletonFabricaConexao();
		}
		return instancia;
	}
	
	// MÉTODO RESPONSÁVEL POR OBTER CONEXÕES DE BANCO DE DADOS
	// AS CONEXÕES PODEM SER ADQUIRIDAS EM DOIS HOSTS DE BANCO DE DADOS
	// HOST BD PARA TESTE (DB4FREEE) 
	// HOST BD PARA APRESENTAÇÃO (RASPBERRY)
	// Obs1.: Comente um dos drivers no método forName para poder realizar a conexão.
	// Obs2.: Comente um dos retornos para usar o banco de dados correpondente.
	// Obs3.: Ao usar o banco de dados do RASPBERRY lembrar que o endereço do host pode se alterar de acordo com a rede utilizada.
	
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
