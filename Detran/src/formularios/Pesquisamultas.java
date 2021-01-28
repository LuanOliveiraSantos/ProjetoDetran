package formularios;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Pesquisamultas extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* Criando objetos JDBC para conexão e uso do banco */
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtReadplaca;
	private JTextField txtReadrenavam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Pesquisamultas dialog = new Pesquisamultas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Pesquisamultas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Pesquisamultas.class.getResource("/icones/multa.png")));
		setTitle("Registro de Multas");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblPlaca = new JLabel("PLACA");
		lblPlaca.setBounds(68, 53, 48, 14);
		contentPanel.add(lblPlaca);
		
		txtReadplaca = new JTextField();
		txtReadplaca.setBounds(145, 50, 96, 20);
		contentPanel.add(txtReadplaca);
		txtReadplaca.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("RENAVAM");
		lblNewLabel.setBounds(68, 98, 67, 14);
		contentPanel.add(lblNewLabel);
		
		txtReadrenavam = new JTextField();
		txtReadrenavam.setBounds(145, 95, 96, 20);
		contentPanel.add(txtReadrenavam);
		txtReadrenavam.setColumns(10);
		
		JButton btnReadregistro = new JButton("");
		btnReadregistro.setIcon(new ImageIcon(Pesquisamultas.class.getResource("/icones/pesquisarcar.png")));
		btnReadregistro.setToolTipText("Pesquisar registros");
		btnReadregistro.setBounds(318, 155, 64, 64);
		contentPanel.add(btnReadregistro);
	}
}
