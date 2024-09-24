package Concessionaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JComboBox;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
public class conas {
	private Connection connection = null;
	private Statement statement = null;
	private Statement statement1 = null;
	private Statement statement2 = null;
	private Statement statement3 = null;
	private Statement statement4 = null;
	private Statement statement5 = null;
	private ResultSet resultset = null;
	private ResultSet resultset1 = null;
	private ResultSet resultset2 = null;
	private ResultSet resultset3 = null;
	private ResultSet resultset4 = null;
	private ResultSet resultset5 = null;
	JComboBox comboBox;
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/Concessionaria";
		String usuario = "root";
		String senha = "";
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
			this.statement1 = this.connection.createStatement();
			this.statement2 = this.connection.createStatement();
			this.statement3 = this.connection.createStatement();
			this.statement4 = this.connection.createStatement();
			this.statement5 = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
	public boolean estaConectado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}
	}
	private JFrame frame;
	private JFormattedTextField ascod;
	private JFormattedTextField veiin;
	private JFormattedTextField veiout;
	private JTextArea acenome;
	private JTextField ascod2;
	private JTextField veiin2;
	private JTextField veiout2;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conas window = new conas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public conas() {
		initialize();
	}
	public void visivel() {
		conas windows = new conas();
		windows.frame.setVisible(true);
	}
	private void initialize() {
		conectar();
		frame = new JFrame();
		frame.setBounds(100, 100, 1011, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		NumberFormat numberFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
		numberFormatter.setAllowsInvalid(false);
		try {
			MaskFormatter mask = new MaskFormatter("####");
			ascod = new JFormattedTextField(mask);
			MaskFormatter mask1 = new MaskFormatter("####");
			veiin = new JFormattedTextField(mask1);
			MaskFormatter mask2 = new MaskFormatter("####");
			veiout = new JFormattedTextField(mask2);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO na formatação de Campos", "erro", JOptionPane.ERROR_MESSAGE);
		}
		JLabel labcli = new JLabel("Acessórios");
		labcli.setFont(new Font("Tahoma", Font.BOLD, 50));
		labcli.setBounds(45, 33, 293, 61);
		frame.getContentPane().add(labcli);
		JLabel lablogo = new JLabel("SysCon");
		lablogo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lablogo.setBounds(758, 33, 183, 61);
		frame.getContentPane().add(lablogo);
		JLabel labcodas = new JLabel("Código");
		labcodas.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcodas.setBounds(45, 114, 150, 35);
		frame.getContentPane().add(labcodas);
		JLabel labcodasform = new JLabel("formato 9999");
		labcodasform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcodasform.setBounds(45, 139, 150, 28);
		frame.getContentPane().add(labcodasform);
		// JTextArea ascod = new JTextArea();
		ascod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ascod.setBounds(180, 125, 141, 35);
		frame.getContentPane().add(ascod);
		ascod.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// String id = ascod.getText();
				atualizarInformacoes(ascod.getText());
				atualizarInformacoes2(ascod.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				atualizarInformacoes(ascod.getText());
				atualizarInformacoes2(ascod.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				atualizarInformacoes(ascod.getText());
				atualizarInformacoes2(ascod.getText());
			}
		});
		JLabel labnomeas = new JLabel("Nome");
		labnomeas.setFont(new Font("Tahoma", Font.BOLD, 24));
		labnomeas.setBounds(45, 167, 150, 35);
		frame.getContentPane().add(labnomeas);
		JLabel labnomeasform1 = new JLabel("formato texto");
		labnomeasform1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labnomeasform1.setBounds(45, 192, 150, 28);
		frame.getContentPane().add(labnomeasform1);
		acenome = new JTextArea();
		acenome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		acenome.setBounds(180, 178, 761, 35);
		frame.getContentPane().add(acenome);
		JLabel labveias = new JLabel("Veículos com");
		labveias.setFont(new Font("Tahoma", Font.BOLD, 24));
		labveias.setBounds(44, 223, 183, 35);
		frame.getContentPane().add(labveias);
		JLabel labveiasform = new JLabel("formato 9999");
		labveiasform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labveiasform.setBounds(44, 248, 203, 28);
		frame.getContentPane().add(labveiasform);
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBox.setBounds(228, 234, 713, 35);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(comboBox);
		comboBox.setSelectedItem("Veículos que tem o Acessório");
		JLabel labadveias = new JLabel("Adicionar Veículo");
		labadveias.setFont(new Font("Tahoma", Font.BOLD, 24));
		labadveias.setBounds(42, 280, 230, 35);
		frame.getContentPane().add(labadveias);
		JLabel labadveiasform = new JLabel("formato 9999");
		labadveiasform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labadveiasform.setBounds(42, 305, 150, 28);
		frame.getContentPane().add(labadveiasform);
		//veiin = new JTextArea();
		veiin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		veiin.setBounds(260, 291, 150, 35);
		frame.getContentPane().add(veiin);
		JLabel labexcveias = new JLabel("Excluir Veículo");
		labexcveias.setFont(new Font("Tahoma", Font.BOLD, 24));
		labexcveias.setBounds(585, 280, 230, 35);
		frame.getContentPane().add(labexcveias);
		JLabel labexcveiform = new JLabel("formato 9999");
		labexcveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labexcveiform.setBounds(585, 305, 150, 28);
		frame.getContentPane().add(labexcveiform);
		// JTextArea veiout = new JTextArea();
		veiout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		veiout.setBounds(791, 291, 150, 35);
		frame.getContentPane().add(veiout);
		JButton btnassalvar = new JButton("Salvar");
		btnassalvar.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnassalvar.setBounds(45, 367, 223, 53);
		frame.getContentPane().add(btnassalvar);
		btnassalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ascod2 = ascod.getText().trim();
				String veiin2 = veiin.getText().trim();
				String veiout2 = veiout.getText().trim();
				String acenome2 = acenome.getText().trim();
				btnsalvar(ascod2, veiin2, veiout2, acenome2);
				conas tel = new conas();
				tel.visivel();
				frame.dispose();
			}
		});
		JButton btnasexcluir = new JButton("Excluir");
		btnasexcluir.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnasexcluir.setBounds(383, 367, 223, 53);
		frame.getContentPane().add(btnasexcluir);
		btnasexcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ascod2 = ascod.getText();
				btnexcluir(ascod2);
				conas tel = new conas();
				tel.visivel();
				frame.dispose();
				}
			});
	
// linha BOTÂO VOLTAR linha BOTÂO VOLTAR linha BOTÂO VOLTAR linha BOTÂO VOLTAR
		JButton btnasvoltar = new JButton("Voltar");
		btnasvoltar.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnasvoltar.setBounds(718, 367, 223, 53);
		frame.getContentPane().add(btnasvoltar);
		btnasvoltar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent n) {
			conini tel = new conini();
			tel.visivel();
			frame.dispose();
			}
		});
	}
	public void btnsalvar(String ascod2, String veiin2, String veiout2, String acenome2) {
		try {
			String queryAcessorios2 = "Select ace_nome from Acessorios where ace_id = '" + ascod2 + "'";
			this.resultset3 = this.statement3.executeQuery(queryAcessorios2);
			if (resultset3.next()) {
					String queryupacenome = "update Acessorios set ace_nome = '"+acenome2+"' where ace_id = '"+ascod2+"'";
					this.statement.executeUpdate(queryupacenome);
				}else {	
					String queryupacenome2 = "insert into Acessorios(ace_id,ace_nome) values ('"+ascod2+"','"+acenome2+"')";
					this.statement5.executeUpdate(queryupacenome2);
				}
			if(ascod2.isEmpty()==false&&veiin2.isEmpty()==false) {
				String codeincluir = veiin2 + ascod2;
				String queryupadicionavei = "insert into veiace (veiace_id) values ('"+codeincluir+"')";
				this.statement2.executeUpdate(queryupadicionavei);
			}
			if(ascod2.isEmpty()==false&&veiout2.isEmpty()==false) {
				String codexcluir = veiout2 + ascod2;
				String queryupexcluivei = "delete from veiace where veiace_id = '"+codexcluir+"'";
				this.statement5.executeUpdate(queryupexcluivei);
			}
		}catch (Exception d) {
			System.out.println("ERROR: " + d.getMessage());
		}
	}
	public void btnexcluir(String ascod2) {
		try {
			String queryexcace2 = "delete from Acessorios where ace_id ='" + ascod2 + "'";
			this.statement5.executeUpdate(queryexcace2);
		} catch (SQLException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		try {
			String queryVeiAce2 = "delete from veiace where right(veiace_id, 4) = '" + ascod2 + "'";
			this.statement3.executeUpdate(queryVeiAce2);
		} catch (Exception g) {
			System.out.println("ERROR: " + g.getMessage());
		}
	}
	public void atualizarInformacoes(String id) {
		try {
			String queryAcessorios = "Select ace_nome from acessorios where ace_id = '" + id + "'";
			this.resultset = this.statement.executeQuery(queryAcessorios);
			while (this.resultset.next()) {
				String nome = this.resultset.getString("ace_nome");
				acenome.setText(nome);
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
	public void atualizarInformacoes2(String id) {
		try {
			comboBox.removeAllItems();
			String queryVeiAce = "Select veiace_id from veiace where RIGHT(veiace_id, 4) = '" + id + "'";
			this.resultset = this.statement.executeQuery(queryVeiAce);
			// Percorrendo todos os registros no banco de dados "ligacao"
			while (this.resultset.next()) {
				// Obtendo a chave "veiace_id"
				String veiaceid = this.resultset.getString("veiace_id");

				// Dividindo a chave "veiace_id" em dois grupos de 4 dígitos
				String grupo1 = veiaceid.substring(0, 4); // Primeiro grupo (vei_id)
				String grupo2 = veiaceid.substring(4); // Segundo grupo (ace_id)

				// buscando veículo relacionado
				String vei_id = grupo1;
				String queryvei = "Select vei_nome from veiculo where vei_id ='" + vei_id + "'";
				this.resultset2 = this.statement2.executeQuery(queryvei);

				// Se encontrar um veículo correspondente, adiciona o vei_id e vei_nome ao
				// código

				while (this.resultset2.next()) {
					String veiNome = this.resultset2.getString("vei_nome");
					// Salva na lista código
					// codigo.add(vei_id + " " + veiNome);
					comboBox.addItem(vei_id + "  " + veiNome);
				}

			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}
