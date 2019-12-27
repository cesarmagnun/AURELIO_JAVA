package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.MenuControl;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Toolkit;

public class MenuGUI extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUI frame = new MenuGUI();
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
	public MenuGUI() {
		setIconImage(new ImageIcon(getClass().getResource("logo.png")).getImage());
		setTitle("Aur\u00E9lio - Bem Vindo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 336);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAvaliacao = new JMenu("Avalia\u00E7\u00E3o");

		menuBar.add(mnAvaliacao);
		
		JMenu mnQuestionario = new JMenu("Question\u00E1rio\r\n");
		mnAvaliacao.add(mnQuestionario);
		
		JMenuItem mntmIniciar = new JMenuItem("Iniciar");

		mntmIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuControl().abreQuestionario();
			}
		});
		mnQuestionario.add(mntmIniciar);
		
		JMenuItem mntmExposicao = new JMenuItem("Exposi\u00E7\u00E3o");
		mnAvaliacao.add(mntmExposicao);
		
		JMenu mnRelatorios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatorios);
		
		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mnRelatorios.add(mntmBuscar);
		
		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
		
		JMenuItem mntmAurelio = new JMenuItem("Aur\u00E9lio");
		mnSobre.add(mntmAurelio);
		
		JMenuItem mntmVersao = new JMenuItem("Vers\u00E3o");
		mnSobre.add(mntmVersao);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmGuia = new JMenuItem("Guia");
		mnAjuda.add(mntmGuia);
		
		JMenuItem mntmSuporte = new JMenuItem("Suporte");
		mnAjuda.add(mntmSuporte);
		
		JMenu mnConfiguracoes = new JMenu("Configura\u00E7\u00F5es");
		menuBar.add(mnConfiguracoes);
		
		JMenuItem mntmUsuarios = new JMenuItem("Usu\u00E1rios");
		mnConfiguracoes.add(mntmUsuarios);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setEnabled(false);
		lblLogo.setIcon(new ImageIcon("F:\\Dados\\Documentos\\Faculdade\\UNIP\\TCC\\IMAGENS\\logo3.png"));
		lblLogo.setBounds(64, 28, 387, 221);
		contentPane.add(lblLogo);
		
		JLabel lblContFunc = new JLabel("<html><body><font color=\"red\" type=\"verdana\" size=\"26\">"+8+"</font></body></html>");
		lblContFunc.setBounds(480, 11, 25, 40);
		contentPane.add(lblContFunc);
		
		mnAvaliacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogo.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setEnabled(false);
			}
		});
		
		mnRelatorios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogo.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setEnabled(false);
			}
		});
		
		mnSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogo.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setEnabled(false);
			}
		});
		
		mnSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogo.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setEnabled(false);
			}
		});
		
		mnConfiguracoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogo.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setEnabled(false);
			}
		});
		
		mnQuestionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogo.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setEnabled(false);
			}
		});
		
		mntmIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogo.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setEnabled(false);
			}
		});
		
		mntmExposicao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogo.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setEnabled(false);
			}
		});
		
		mntmIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogo.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setEnabled(false);
			}
		});
		
		mntmBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogo.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setEnabled(false);
			}
		});
		
		mntmAurelio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogo.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setEnabled(false);
			}
		});
		
		mntmVersao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogo.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setEnabled(false);
			}
		});
		
		mntmGuia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogo.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setEnabled(false);
			}
		});
		
		mntmSuporte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogo.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setEnabled(false);
			}
		});
		
		mntmUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogo.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setEnabled(false);
			}
		});
		
		


	}
}
