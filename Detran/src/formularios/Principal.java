package formularios;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* Criando objetos JDBC para conexão e uso do banco */
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icones/sisdetran.png")));
		setTitle("Detran");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnMulta = new JButton("");
		btnMulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastromulta multa = new Cadastromulta();
				multa.setVisible(true);
			}
		});
		btnMulta.setIcon(new ImageIcon(Principal.class.getResource("/icones/multa2.png")));
		btnMulta.setToolTipText("Cadastro Multa");
		btnMulta.setBounds(10, 84, 128, 128);
		contentPane.add(btnMulta);

		JButton btnVeiculo = new JButton("");
		btnVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastroveiculo veiculo = new Cadastroveiculo();
				veiculo.setVisible(true);
			}
		});
		btnVeiculo.setIcon(new ImageIcon(Principal.class.getResource("/icones/addcarro.png")));
		btnVeiculo.setToolTipText("Cadastro Veiculo");
		btnVeiculo.setBounds(148, 84, 128, 128);
		contentPane.add(btnVeiculo);

		JLabel lblCadastroDeMulta = new JLabel("Cadastro de Multa");
		lblCadastroDeMulta.setBounds(22, 59, 128, 14);
		contentPane.add(lblCadastroDeMulta);

		JLabel lblCadastroDeVeculo = new JLabel("Cadastro de Ve\u00EDculo");
		lblCadastroDeVeculo.setBounds(148, 59, 116, 14);
		contentPane.add(lblCadastroDeVeculo);

		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pesquisamultas pesquisa = new Pesquisamultas();
				pesquisa.setVisible(true);
			}
		});
		btnPesquisar.setIcon(new ImageIcon(Principal.class.getResource("/icones/multa.png")));
		btnPesquisar.setToolTipText("Cadastro Multa");
		btnPesquisar.setBounds(286, 84, 128, 128);
		contentPane.add(btnPesquisar);

		JLabel lblPesquisarMultas = new JLabel("Pesquisar Multas");
		lblPesquisarMultas.setBounds(292, 59, 109, 14);
		contentPane.add(lblPesquisarMultas);
		// teste de conexão
		// Connection con = null;
		// con = DAO.conectar();
		// if (con != null) {
		// System.out.println("Banco conectado");
		// } else {
		// System.out.println("Erro de conexão");
	} //fim do construtor
	
}
