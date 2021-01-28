package formularios;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.awt.Color;

public class Cadastroveiculo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* Criando objetos JDBC para conexão e uso do banco */
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMarca;
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField txtRenavam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cadastroveiculo dialog = new Cadastroveiculo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cadastroveiculo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastroveiculo.class.getResource("/icones/addcar.png")));
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Cadastro Veiculo");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblMarca = new JLabel("MARCA*");
		lblMarca.setBounds(30, 110, 64, 14);
		contentPanel.add(lblMarca);

		txtMarca = new JTextField();
		txtMarca.setBounds(94, 107, 96, 20);
		contentPanel.add(txtMarca);
		txtMarca.setColumns(10);

		JLabel lblNewLabel = new JLabel("PLACA*");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(30, 28, 48, 14);
		contentPanel.add(lblNewLabel);

		txtPlaca = new JTextField();
		txtPlaca.setBounds(84, 25, 96, 20);
		contentPanel.add(txtPlaca);
		txtPlaca.setColumns(10);

		JLabel lblModelo = new JLabel("MODELO*");
		lblModelo.setBounds(30, 139, 64, 14);
		contentPanel.add(lblModelo);

		txtModelo = new JTextField();
		txtModelo.setBounds(94, 136, 96, 20);
		contentPanel.add(txtModelo);
		txtModelo.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("RENAVAM*");
		lblNewLabel_1.setBounds(216, 139, 70, 14);
		contentPanel.add(lblNewLabel_1);

		txtRenavam = new JTextField();
		txtRenavam.setBounds(295, 136, 96, 20);
		contentPanel.add(txtRenavam);
		txtRenavam.setColumns(10);

		JButton btnCreate = new JButton("");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnCreate.setToolTipText("Cadastrar Carro ");
		btnCreate.setIcon(new ImageIcon(Cadastroveiculo.class.getResource("/icones/addcarro.png")));
		btnCreate.setBounds(84, 181, 64, 64);
		contentPanel.add(btnCreate);

		JButton btnRead = new JButton("");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnRead.setToolTipText("Pesquisar registro de carro ");
		btnRead.setIcon(new ImageIcon(Cadastroveiculo.class.getResource("/icones/sisdetran.png")));
		btnRead.setBounds(190, 18, 32, 32);
		contentPanel.add(btnRead);

		JButton btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
		btnUpdate.setToolTipText("Editar cadastro de carro ");
		btnUpdate.setIcon(new ImageIcon(Cadastroveiculo.class.getResource("/icones/editcar.png")));
		btnUpdate.setBounds(190, 181, 64, 64);
		contentPanel.add(btnUpdate);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerVeiculo();
			}
		});
		btnDelete.setToolTipText("Deletar registro de carro ");
		btnDelete.setIcon(new ImageIcon(Cadastroveiculo.class.getResource("/icones/deletecar.png")));
		btnDelete.setBounds(292, 181, 64, 64);
		contentPanel.add(btnDelete);
		
		JLabel lblCampos = new JLabel("Campos Obrigat\u00F3rios(*)");
		lblCampos.setForeground(Color.RED);
		lblCampos.setBounds(285, 28, 135, 14);
		contentPanel.add(lblCampos);
	}// Fim do contrutor

	/** CRUD CREATE **/

	private void adicionar() {
		if (txtPlaca.getText().isEmpty() || txtMarca.getText().isEmpty() || txtModelo.getText().isEmpty()
				|| txtRenavam.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
		} else {

			String adicionar = "insert into veiculo(placa,marca,modelo,renavam) values(?,?,?,?)";
			try {
				con = DAO.conectar();
				pst = con.prepareStatement(adicionar);
				// a linha abaixo obtem o valor da caixa de texto txtPlaca e armazena(set) no
				// campo 1 do banco de dados
				pst.setString(1, txtPlaca.getText());
				pst.setString(2, txtMarca.getText());
				pst.setString(3, txtModelo.getText());
				pst.setString(4, txtRenavam.getText());
				// a estrutura abaixo executa o comando sql e exibe uma mensagem de confirmação
				// ao usuário
				int adicionado = pst.executeUpdate();
				if (adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Veiculo adicionado");
				}
				// limpar campos
				limpar();

				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/* método limpar campos */
	private void limpar() {
		txtPlaca.setText(null);
		txtMarca.setText(null);
		txtModelo.setText(null);
		txtRenavam.setText(null);
	}

	/** CRUD READ **/

	private void pesquisar() {
		String create1 = "select * from veiculo where placa = ?";
		try {
			// abrir a conexao com o banco
			con = DAO.conectar();
			// a linha abaixo irá executar a instrução
			pst = con.prepareStatement(create1);
			// substituir o argumento ? pelo conteúdo da caixa de texto txtPlaca (1 é o
			// primeiro campo da tabela)
			pst.setString(1, txtPlaca.getText());
			rs = pst.executeQuery();// recuperar os dados do banco
			// setar os campos do formulário com as informações recuperadas do banco
			// rs.next -> significa se houver informações para recuperar
			if (rs.next()) {
				txtPlaca.setText(rs.getString(1));
				txtRenavam.setText(rs.getString(4));
				txtModelo.setText(rs.getString(3));
				txtMarca.setText(rs.getString(2));
			} else {
				// mensagem ao usuário
				JOptionPane.showMessageDialog(null, "Veiculo não cadastrado");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD UPDATE **/

	private void alterar() {
		if (txtPlaca.getText().isEmpty() || txtMarca.getText().isEmpty() || txtModelo.getText().isEmpty()
				|| txtRenavam.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
		} else {
			String update = "update veiculo set marca=?,modelo=?,renavam=? where placa=?";
			try {
				con = DAO.conectar();
				pst = con.prepareStatement(update);
				pst.setString(4, txtPlaca.getText());
				pst.setString(1, txtMarca.getText());
				pst.setString(2, txtModelo.getText());
				pst.setString(3, txtRenavam.getText());
				// confirmação de alteração
				int adicionado = pst.executeUpdate();
				if (adicionado == 1) {
					JOptionPane.showMessageDialog(null, "Veículo alterado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível alterar o veículo");
				}
				con.close();
				// Limpar os campos
				limpar();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/** CRUD DELETE **/

	private void removerVeiculo() {
		int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este veículo?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String remover = "delete from veiculo where placa = ?";
			try {
				con = DAO.conectar();
				pst = con.prepareStatement(remover);
				pst.setString(1, txtPlaca.getText());
				int removido = pst.executeUpdate();
				if (removido == 1) {
					limpar();
					JOptionPane.showMessageDialog(null, "Veículo Removido com sucesso");

				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível remover este veículo");
				}
				con.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);

			}
		}
	}
}
