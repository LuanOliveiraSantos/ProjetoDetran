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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Cadastromulta extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* Criando objetos JDBC para conexão e uso do banco */
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtLocal;
	private JTextField txtCondutor;
	private JTextField txtCodigo;
	private JTextField txtPontuacao;
	private JTextField txtPlacacm;
	private JTextField txtValor;
	private JTextField txtIdmulta;
	private JTextField txtData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cadastromulta dialog = new Cadastromulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cadastromulta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastromulta.class.getResource("/icones/multa3.png")));
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Cadastro Multa");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblLocal = new JLabel("LOCAL*");
		lblLocal.setBounds(30, 131, 48, 14);
		contentPanel.add(lblLocal);

		JLabel lblCdigo = new JLabel("C\u00D3DIGO*");
		lblCdigo.setBounds(227, 55, 59, 14);
		contentPanel.add(lblCdigo);

		JLabel lblNewLabel = new JLabel("PONTUA\u00C7\u00C2O*");
		lblNewLabel.setBounds(30, 168, 93, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblValor = new JLabel("VALOR*");
		lblValor.setBounds(30, 193, 48, 14);
		contentPanel.add(lblValor);

		JLabel lblPlaca = new JLabel("PLACA*");
		lblPlaca.setBounds(30, 55, 48, 14);
		contentPanel.add(lblPlaca);

		JLabel lblRenavam = new JLabel("CONDUTOR");
		lblRenavam.setBounds(30, 103, 77, 14);
		contentPanel.add(lblRenavam);

		txtLocal = new JTextField();
		txtLocal.setEnabled(false);
		txtLocal.setBounds(116, 128, 195, 20);
		contentPanel.add(txtLocal);
		txtLocal.setColumns(10);

		txtCondutor = new JTextField();
		txtCondutor.setEnabled(false);
		txtCondutor.setBounds(117, 100, 138, 20);
		contentPanel.add(txtCondutor);
		txtCondutor.setColumns(10);

		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(296, 52, 82, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtPontuacao = new JTextField();
		txtPontuacao.setEnabled(false);
		txtPontuacao.setBounds(116, 165, 48, 20);
		contentPanel.add(txtPontuacao);
		txtPontuacao.setColumns(10);

		txtPlacacm = new JTextField();
		txtPlacacm.setBounds(76, 52, 93, 20);
		contentPanel.add(txtPlacacm);
		txtPlacacm.setColumns(10);

		txtValor = new JTextField();
		txtValor.setEnabled(false);
		txtValor.setBounds(116, 193, 96, 20);
		contentPanel.add(txtValor);
		txtValor.setColumns(10);

		JButton btnCreatemulta = new JButton("");
		btnCreatemulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
				txtCodigo.setEnabled(false);
				txtLocal.setEnabled(false);
				txtPontuacao.setEnabled(false);
				txtValor.setEnabled(false);
				txtCondutor.setEnabled(false);
			}
		});
		btnCreatemulta.setToolTipText("Cadastrar Multa");
		btnCreatemulta.setIcon(new ImageIcon(Cadastromulta.class.getResource("/icones/addmulta.png")));
		btnCreatemulta.setBounds(351, 175, 64, 64);
		contentPanel.add(btnCreatemulta);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Cadastromulta.class.getResource("/icones/searchmult.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnNewButton.setToolTipText("Pesquisar Multa");
		btnNewButton.setBounds(388, 37, 32, 32);
		contentPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Cadastromulta.class.getResource("/icones/editmult.png")));
		btnNewButton_1.setToolTipText("Editar Multa");
		btnNewButton_1.setBounds(351, 100, 64, 64);
		contentPanel.add(btnNewButton_1);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(30, 232, 48, 14);
		contentPanel.add(lblId);

		txtIdmulta = new JTextField();
		txtIdmulta.setEditable(false);
		txtIdmulta.setBounds(57, 229, 48, 20);
		contentPanel.add(txtIdmulta);
		txtIdmulta.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("DATA");
		lblNewLabel_1.setBounds(116, 232, 48, 14);
		contentPanel.add(lblNewLabel_1);

		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setBounds(159, 229, 138, 20);
		contentPanel.add(txtData);
		txtData.setColumns(10);

		JLabel lblCamposObrigatrios = new JLabel("Campos Obrigat\u00F3rios(*)");
		lblCamposObrigatrios.setForeground(Color.RED);
		lblCamposObrigatrios.setBounds(148, 11, 138, 14);
		contentPanel.add(lblCamposObrigatrios);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				liberar();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Cadastromulta.class.getResource("/icones/sisdetran.png")));
		btnNewButton_3.setToolTipText("Pesquisar Placa");
		btnNewButton_3.setBounds(179, 37, 32, 32);
		contentPanel.add(btnNewButton_3);
	}

	/** FIm do construtor **/

	/** CRUD CREATE **/

	private void adicionar() {
		if (txtPlacacm.getText().isEmpty() || txtLocal.getText().isEmpty() || txtCodigo.getText().isEmpty()
				|| txtValor.getText().isEmpty() || txtPontuacao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
		} else {
			String adicionar = "insert into multa(condutor,localmulta,codigo,valor,pontuacao,placa) values(?,?,?,?,?,?)";
			try {
				con = DAO.conectar();
				pst = con.prepareStatement(adicionar);
				// a linha abaixo obtem o valor da caixa de texto txtPlaca e armazena(set) no
				// campo 1 do banco de dados
				pst.setString(2, txtLocal.getText());
				pst.setString(1, txtCondutor.getText());
				pst.setString(3, txtCodigo.getText());
				pst.setString(5, txtPontuacao.getText());
				pst.setString(6, txtPlacacm.getText());
				pst.setString(4, txtValor.getText());
				// a estrutura abaixo executa o comando sql e exibe uma mensagem de confirmação
				// ao usuário
				int adicionado = pst.executeUpdate();
				if (adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Multa cadastrada");
				}
				// limpar campos
				limpar();

				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/** Limpar campos do formulário **/
	private void limpar() {
		txtCondutor.setText(null);
		txtLocal.setText(null);
		txtCodigo.setText(null);
		txtValor.setText(null);
		txtPontuacao.setText(null);
		txtPlacacm.setText(null);
		txtIdmulta.setText(null);
		txtData.setText(null);

	}

	/** CRUD READ **/

	private void pesquisar() {
		String create1 = "select * from multa where placa = ? and codigo = ?";
		try {
			// abrir a conexao com o banco
			con = DAO.conectar();
			// a linha abaixo irá executar a instrução
			pst = con.prepareStatement(create1);
			// substituir o argumento ? pelo conteúdo da caixa de texto txtPlacacm e
			// txtCodigo (1 é o
			// primeiro campo da tabela)
			pst.setString(1, txtPlacacm.getText());
			pst.setString(2, txtCodigo.getText());
			rs = pst.executeQuery();// recuperar os dados do banco
			// setar os campos do formulário com as informações recuperadas do banco
			// rs.next -> significa se houver informações para recuperar
			if (rs.next()) {
				txtIdmulta.setText(rs.getString(1));
				txtData.setText(rs.getString(4));
				txtPlacacm.setText(rs.getString(8));
				txtCodigo.setText(rs.getString(5));
				txtCondutor.setText(rs.getString(2));
				txtLocal.setText(rs.getString(3));
				txtPontuacao.setText(rs.getString(7));
				txtValor.setText(rs.getString(6));
			} else {
				// mensagem ao usuário
				JOptionPane.showMessageDialog(null, "Multa não cadastrada");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD UPDATE **/

	private void alterar() {
		if (txtPlacacm.getText().isEmpty() || txtLocal.getText().isEmpty() || txtCodigo.getText().isEmpty()
				|| txtValor.getText().isEmpty() || txtPontuacao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
		} else {
			String update = "update multa set condutor=?,localmulta=?,pontuacao=?,valor=? where placa=? and codigo=?";
			try {
				con = DAO.conectar();
				pst = con.prepareStatement(update);
				pst.setString(1, txtCondutor.getText());
				pst.setString(2, txtLocal.getText());
				pst.setString(3, txtPontuacao.getText());
				pst.setString(4, txtValor.getText());
				pst.setString(5, txtPlacacm.getText());
				pst.setString(6, txtCodigo.getText());

				// confirmação de alteração
				int adicionado = pst.executeUpdate();
				if (adicionado == 1) {
					JOptionPane.showMessageDialog(null, "Multa alterada com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível alterar a multa");
				}
				con.close();
				// limpar os campos
				limpar();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void liberar() {
		String create2 = "select * from veiculo where placa = ?";
		try {
			// abrir a conexao com o banco
			con = DAO.conectar();
			// a linha abaixo irá executar a instrução
			pst = con.prepareStatement(create2);
			// substituir o argumento ? pelo conteúdo da caixa de texto txtPlacacm e
			// (1 é o
			// primeiro campo da tabela)
			pst.setString(1, txtPlacacm.getText());
			rs = pst.executeQuery();// recuperar os dados do banco
			// setar os campos do formulário com as informações recuperadas do banco
			// rs.next -> significa se houver informações para recuperar
			if (rs.next()) {
				txtPlacacm.setText(rs.getString(1));

				txtCodigo.setEnabled(true);
				txtLocal.setEnabled(true);
				txtPontuacao.setEnabled(true);
				txtValor.setEnabled(true);
				txtCondutor.setEnabled(true);
			} else {
				// mensagem ao usuário
				JOptionPane.showMessageDialog(null, "Placa não cadastrada");

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
