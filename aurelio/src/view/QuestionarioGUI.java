package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.MenuControl;
import control.QuestionarioControle;
import utility.TestaDados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class QuestionarioGUI extends JFrame {
	
	//�ndice Global usado pelas classes internas manipuladoras de eventos
	private Integer indice = 1;
	private JLabel lblQuestao = null;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionarioGUI frame = new QuestionarioGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuestionarioGUI() {
		
		Float[] respostas = new Float[5];
		TestaDados.statusDados(respostas);

		setIconImage(new ImageIcon(getClass().getResource("logo.png")).getImage());
		setTitle("Question�rio");
		setBounds(100, 100, 532, 336);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		System.out.println("CHEGOU AQUI 1");
		JPanel panel = new JPanel();
		panel.setForeground(Color.ORANGE);
		panel.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, true));
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(39, 11, 437, 120);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		lblQuestao = new JLabel("<html>\t<b>&nbsp;Questao <font color=\"#ff0000\">" + indice
				+ "</font></b><hr><br><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ new QuestionarioControle().atualizaQuestao(indice) + "</p></html>");
		lblQuestao.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		lblQuestao.setVerticalAlignment(SwingConstants.TOP);
		lblQuestao.setBounds(10, 11, 417, 98);
		panel.add(lblQuestao);
		
		JComboBox<String> cbNota = new JComboBox<String>();
		cbNota.setModel(new DefaultComboBoxModel<String>(
				new String[] { "0", "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1" }));
		cbNota.setBounds(39, 166, 80, 20);
		contentPane.add(cbNota);

		JButton btnAvancar = new JButton();
		btnAvancar.setIcon(new ImageIcon(QuestionarioGUI.class.getResource("right.png")));
		btnAvancar.setEnabled(false);
		btnAvancar.setBounds(408, 224, 68, 52);
		contentPane.add(btnAvancar);

		JButton btnVoltar = new JButton();
		btnVoltar.setIcon(new ImageIcon(QuestionarioGUI.class.getResource("left.png")));
		btnVoltar.setEnabled(false);
		btnVoltar.setBounds(39, 224, 68, 52);
		contentPane.add(btnVoltar);

		JLabel lblAvaliar = new JLabel("Impacto");
		lblAvaliar.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		lblAvaliar.setBounds(39, 142, 80, 20);
		contentPane.add(lblAvaliar);

		JLabel lblNumQuestao = new JLabel(indice.toString() + "/" + respostas.length);
		lblNumQuestao.setBackground(new Color(25, 25, 112));
		lblNumQuestao.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 73));
		lblNumQuestao.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumQuestao.setBounds(202, 165, 111, 111);
		contentPane.add(lblNumQuestao);

		cbNota.addItemListener(new ItemListener() {
			// Sujeito a melhoria
			public void itemStateChanged(ItemEvent arg0) {
//				if (respostas[indice - 1] == null && Float.parseFloat(cbNota.getSelectedItem().toString()) == 0.0) {
//
//				} else {
					respostas[indice - 1] = Float.parseFloat(cbNota.getSelectedItem().toString());
					btnAvancar.setEnabled(true);
					TestaDados.statusDados(respostas);
//				}

			}
		});
		
		// EVENTO DO BOT�O AVAN�AR PARA A PR�XIMA QUEST�O
		btnAvancar.addActionListener(new ActionListener() {	// IN�CIO DA CLASSE INTERNA AN�NIMA
			public void actionPerformed(ActionEvent e) {	// M�TODO RESPONS�VEL PELA A��O AP�S EVENTO DE CLICK NO BOT�O
				indice++;	// AVAN�A O �NDICE DA QUEST�O
				lblQuestao.setText("<html>\t<b>&nbsp;Questao <font color=\"#ff0000\">" + indice	// ATUALIZA O LABEL PARA A QUEST�O POSTERIOR
						+ "</font></b><hr><br><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ new QuestionarioControle().atualizaQuestao(indice) + "</p></html>");
				if (indice == 5) { // CONDI��O 1 - ENTENDE QUE ESTA N� �LTIMA QUEST�O E APRESENTA O BOT�O PARA FINALIZAR O QUESTION�RIO.
					btnAvancar.setIcon(new ImageIcon(QuestionarioGUI.class.getResource("check.png")));
				}
				if (indice == 6) { // CONDI��O 2 - CHAMA O CONTROL PARA ENVIAR TODAS AS RESPOSTAS DO ADM AO BANCO DE DADOS
					
					TestaDados.testeSoma(respostas); // TESTE - SOMA TODAS AS RESPOSTAS DO VETOR 
					
					new QuestionarioControle().finalizar(respostas); // ENVIA AS RESPOSOTAS PARA O CONTROLLER
					
					
					int escolha = JOptionPane.showOptionDialog(null, "Voc� deseja responder um novo question�rio?",
							"Mensagem do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
							new String[] {"Sim", "N�o" }, "Sim");
					if (escolha == JOptionPane.YES_OPTION) {
						dispose();
						new MenuControl().abreQuestionario();
					} else {
						dispose();
					}
				} else {
					if (indice != 1) {
						btnVoltar.setEnabled(true);
					}
					if (respostas[indice - 1] != null) {
						cbNota.setSelectedItem(respostas[indice - 1].toString());

					} else {
						cbNota.setSelectedIndex(0);
						btnAvancar.setEnabled(false);
					}
					lblNumQuestao.setText(indice.toString() + "/" + respostas.length);
				}
			}
		});
		
		// EVENTO DO BOT�O VOLTAR PARA A QUEST�O ANTERIOR
		btnVoltar.addActionListener(new ActionListener() { // IN�CIO DA CLASSE INTERNA AN�NIMA
			
			public void actionPerformed(ActionEvent e) { // M�TODO RESPONS�VEL PELA A��O AP�S EVENTO DE CLICK NO BOT�O
				--indice; // VOLTA O �NDICE DA QUEST�O
				
				lblQuestao.setText("<html>\t<b>&nbsp;Questao <font color=\"#ff0000\">" + indice  // ATUALIZA O LABEL PARA A QUEST�O ANTERIOR
						+ "</font></b><hr><br><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ new QuestionarioControle().atualizaQuestao(indice) + "</p></html>");
				
				lblNumQuestao.setText(indice.toString() + "/" + respostas.length); // ATUALIZA O LABEL N�MERO DA QUEST�O PARA A ANTERIOR
				
				cbNota.setSelectedItem(respostas[indice - 1].toString()); // INICIALIZA A COMBOBOX COM O VALOR QUE J� HAVIA SIDO RESPONDIDO
				
				btnAvancar.setEnabled(true); // ATIVA O BOT�O VOLTAR
				
				if (indice == 1) { // CONDI��O - DESATIVA O BOT�O VOLTAR SE FOR A 1� QUEST�O DO QUESTION�RIO
					btnVoltar.setEnabled(false);
				}

			}
		});
	}
	

}
