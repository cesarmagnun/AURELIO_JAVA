package control;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.QuestionarioDao;


public class QuestionarioControle {
	
	public String atualizaQuestao(int i)  {
		return new QuestionarioDao().pegaQuestao(i); 
	}
	
	public void finalizar(Float[] respostas)  {
		new QuestionarioDao().insereRespostas(respostas);
		JOptionPane.showMessageDialog(null, "Respostas gravadas com sucesso!", "Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
}
