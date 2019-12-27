

package model;
import utility.SingletonFabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

// CLASSE RESPONS�VEL PELAS OPERA��ES NO BANCO DE DADOS (INSERT, SELECT E ETC...)
public class QuestionarioDao {
	
	private SingletonFabricaConexao sfc;	// ATRIBUTO SINGLETON DE CONEX�O COM BANCO DE DADOS
	private Connection con;					// ATRIBUTO CONEX�O
	private PreparedStatement ps;			// ATRIBUTO DECLARA��O DE OPERA��O PARA O BANCO DE DADOS
	private ResultSet rs;					// ATRIBUTO RESULTADOS DO BANCO DE DADOS
	
	// O CONSTRUTOR INICIA A CLASSE COM A SINGLETON DE CONEX�O PARA REALIZAR FUTURAS CONEX�ES.
	public QuestionarioDao() {
		sfc = SingletonFabricaConexao.pegaInstancia();
	}
	
	// ESSE M�TODO PEGA A DESCRI��O DE UMA QUEST�O DO BANCO DE DADOS ATRAV�S DO �NDICE FORNCECIDO 
	// ESSE M�TODO � UTILIZADO PARA ATUALIZAR O LABEL DA QUEST�O DURANTE O QUESTION�RIO.
	public String pegaQuestao(int i) {
		try {
			
			con = sfc.pegaConexao();
			ps = con.prepareStatement("SELECT * FROM risco WHERE codigo = ?");
			ps.setInt(1, i);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getString("descricao");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			e.getMessage();
		} return null;
	}
	
	
	/*
	public void insereResultadoGeral(Float[] respostas) throws ClassNotFoundException, SQLException {
		con = sfc.pegaConexao();
		ps = con.prepareStatement("INSERT INTO respostas VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		int i=0;
		while(i <= respostas.length + 1) {
			if(i == 0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				ps.setString(i+1, sdf.format(new Date()));
			}
			if(i == 11) {
				float soma = 0;
				for(int j=0; j<=respostas.length-1; j++) {
					soma = soma+respostas[j];
				}
				ps.setFloat(i+1, ( soma / respostas.length) );
			}
			if( (i != 0 ) && ( i != 11 )) {
				ps.setFloat(i+1, respostas[i-1]);
			}
			i++;
		}
		ps.execute();
	}	
	*/
	
	// ESSE M�TODO GRAVA AS RESPOSTAS DO ADM NO BANCO DE DADOS
	public void insereRespostas(Float[] respostas) {
		try {
			con = sfc.pegaConexao();
			ps = con.prepareStatement("INSERT INTO respostasAdm (dataResp, r1, r2, r3, r4, r5) VALUES(?, ?, ?, ? ,? ,?)");
			int i=0;
			while(i <= respostas.length) {
				if(i == 0) {
					SimpleDateFormat sdf = new SimpleDateFormat();
					ps.setString(0+1, sdf.format(new Date()));
				}else {
					ps.setFloat(i+1, respostas[i-1]);
				}i++;
			}
			ps.execute();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}

	}	
}

