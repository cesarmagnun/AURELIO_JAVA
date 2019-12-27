package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.QuestionarioDao;
public class Teste {
	
	public static void main(String[] args) {
		
		Integer i = 1;
		System.out.println(new QuestionarioDao().pegaQuestao(i));
		
		
		
		
		
		
//		int algarismo = 5;
		

		
//		try {
//			System.out.println(5/0);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
		
		
		
		
		/*
		try {
			new QuestionarioDao().insereTeste(5, 2, 7);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		*/
		
		
		
		/*
		Float[] vet = new Float[10];
		
		for(Integer i=0; i<=9; i++) {
			vet[i] = (float) 0.1 + i.floatValue();
			System.out.println(vet[i]+"\n");
		}
		
		try {
			new QuestionarioDao().insereResultadoGeral(vet);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		*/
	}
	
	
	

}
