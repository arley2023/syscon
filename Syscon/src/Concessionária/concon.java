package Concessionaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

public class concon {
private static final String Try = null;

	// armazena a conexão
	private Connection connection = null;

// armazena as consultas
	private Statement statement = null;
	private Statement statement1 = null;
	private Statement statement2 = null;
	private Statement statement3 = null;
	private Statement statement4 = null;
	
// armazena os resultados
	private ResultSet resultset = null;
	private ResultSet resultset1 = null;
	private ResultSet resultset2 = null;
	private ResultSet resultset3 = null;
	private ResultSet resultset4 = null;

// cria a comboBox	
	JComboBox comboBoxcli;
	JComboBox comboBoxvei;
	//JComboBox<String> comboBoxcli;
	//JComboBox<String> comboBoxvei;
	
	public void conectar() {
		
// caminho
		String servidor = "jdbc:mysql://localhost:3306/Concessionaria";

// usuario
		String usuario = "root";

// senha
		String senha = "";

// local driver instalado
		String driver = "com.mysql.cj.jdbc.Driver";
		try {

// acessa o driver
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			
// consultas
		this.statement = this.connection.createStatement();
		this.statement1 = this.connection.createStatement();
		this.statement2 = this.connection.createStatement();
		this.statement3 = this.connection.createStatement();
		this.statement4 = this.connection.createStatement();
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

// DEFININDO CAMPOS DEFININDO CAMPOS DEFININDO CAMPOS DEFININDO CAMPOS
	private JFrame frame;
	
	private JFormattedTextField concod;
	private JFormattedTextField conadcli;
	private JFormattedTextField conexcli;
	private JFormattedTextField conadvei;
	private JFormattedTextField conexvei;
	private JFormattedTextField campolig;
	private JFormattedTextField campolig1;
	private JTextArea connome;
	private JTextArea clinome;
	private JTextArea veinome;
	private JTextField concod2;
	private JTextField clicod2;
	private JTextField conadcli2;
	private JTextField conexcli2;
	private JTextField conadvei2;
	private JTextField conexvei2;

// lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					concon window = new concon();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

// cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO
	public concon() {
		initialize();
	}

// deixa a JANELA VISIVEL QUANDO CHAMADA deixa a JANELA VISIVEL QUANDO CHAMADA
	public void visivel() {
		concon windows = new concon();
		windows.frame.setVisible(true);
	}
	
// inicia a JANELA inicia a JANELA inicia a JANELA inicia a JANELA
	private void initialize() {
		conectar();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1011, 609);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
// MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS
		NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setAllowsInvalid(false);
        try {
		    MaskFormatter mask = new MaskFormatter("####");
		    concod = new JFormattedTextField(mask);
		    MaskFormatter mask1 = new MaskFormatter("####");
		    conadcli = new JFormattedTextField(mask1);
		    MaskFormatter mask2 = new MaskFormatter("####");
		    conexcli = new JFormattedTextField(mask2);
		    MaskFormatter mask3 = new MaskFormatter("####");
		    conadvei = new JFormattedTextField(mask3);
		    MaskFormatter mask4 = new MaskFormatter("####");
		    conexvei = new JFormattedTextField(mask4);
		    MaskFormatter mask5 = new MaskFormatter("########");
		    campolig = new JFormattedTextField(mask5);
		 } catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO na formatação de Campos", "erro", JOptionPane.ERROR_MESSAGE);
		 }

// label janela CONSULTOR SYSCON label janela CONSULTOR SYSCON label janela CONSULTOR SYSCON
		JLabel labcli = new JLabel("Consultor");
		labcli.setFont(new Font("Tahoma", Font.BOLD, 50));
		labcli.setBounds(45, 33, 293, 61);
		frame.getContentPane().add(labcli);
		
		JLabel lablogo = new JLabel("SysCon");
		lablogo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lablogo.setBounds(758, 33, 183, 61);
		frame.getContentPane().add(lablogo);

// linha CÓDIGO DO CONSULTOR linha CÓDIGO DO CONSULTOR linha CÓDIGO DO CONSULTOR
		JLabel labcodcon = new JLabel("Código");
		labcodcon.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcodcon.setBounds(45, 114, 150, 35);
		frame.getContentPane().add(labcodcon);
		
		JLabel labcodconform = new JLabel("formato 9999");
		labcodconform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcodconform.setBounds(45, 139, 150, 28);
		frame.getContentPane().add(labcodconform);
		
		// JTextArea concod = new JTextArea();
		concod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		concod.setBounds(180, 125, 104, 35);
		frame.getContentPane().add(concod);
		concod.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// String id = concod.getText();
				atualizarInformacoes(concod.getText());
				atualizarInformacoes2(concod.getText());
				atualizarInformacoes3(concod.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				atualizarInformacoes(concod.getText());
				atualizarInformacoes2(concod.getText());
				atualizarInformacoes3(concod.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				atualizarInformacoes(concod.getText());
				atualizarInformacoes2(concod.getText());
				atualizarInformacoes3(concod.getText());
			}
		});

// linha NOME CONSULTOR linha NOME CONSULTOR linha NOME CONSULTOR
		JLabel labnomecon = new JLabel("Nome");
		labnomecon.setFont(new Font("Tahoma", Font.BOLD, 24));
		labnomecon.setBounds(45, 167, 150, 35);
		frame.getContentPane().add(labnomecon);
		
		JLabel labnomeconform = new JLabel("formato texto");
		labnomeconform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labnomeconform.setBounds(45, 192, 150, 28);
		frame.getContentPane().add(labnomeconform);
		
		connome = new JTextArea();
		connome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		connome.setBounds(180, 178, 761, 35);
		frame.getContentPane().add(connome);
				
// linha de CLIENTES linha de CLIENTES linha de CLIENTES linha de CLIENTES
		JLabel labclicon = new JLabel("Clientes");
		labclicon.setFont(new Font("Tahoma", Font.BOLD, 24));
		labclicon.setBounds(44, 231, 183, 35);
		frame.getContentPane().add(labclicon);
				
		JLabel labcliconform = new JLabel("formato texto");
		labcliconform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcliconform.setBounds(44, 256, 203, 28);
		frame.getContentPane().add(labcliconform);
		
		comboBoxcli = new JComboBox();
		comboBoxcli.setEditable(true);
		comboBoxcli.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBoxcli.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxcli.setBounds(228, 238, 713, 35);
		frame.getContentPane().add(comboBoxcli);
		comboBoxcli.setSelectedItem("Clientes atendidos");
							
// linha ADICIONAR CLIENTE linha ADICIONAR CLIENTE linha ADICIONAR CLIENTE
		JLabel labadclicon = new JLabel("Adicionar Cliente");
		labadclicon.setFont(new Font("Tahoma", Font.BOLD, 24));
		labadclicon.setBounds(42, 288, 230, 35);
		frame.getContentPane().add(labadclicon);
		
		JLabel labadveiconform = new JLabel("formato 9999");
		labadveiconform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labadveiconform.setBounds(42, 313, 150, 28);
		frame.getContentPane().add(labadveiconform);
		
		//JTextArea conadcli = new JTextArea();
		conadcli.setFont(new Font("Tahoma", Font.PLAIN, 18));
		conadcli.setBounds(278, 291, 150, 35);
		frame.getContentPane().add(conadcli);
						
// linha EXCLUIR CLIENTE linha ADICIONAR CLIENTE linha EXCLUIR CLIENTE	
		JLabel labexclicon = new JLabel("Excluir Cliente");
		labexclicon.setFont(new Font("Tahoma", Font.BOLD, 24));
		labexclicon.setBounds(585, 281, 230, 35);
		frame.getContentPane().add(labexclicon);
		
		JLabel labexcliconform = new JLabel("formato 9999");
		labexcliconform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labexcliconform.setBounds(585, 306, 150, 28);
		frame.getContentPane().add(labexcliconform);
		
		//JTextArea conexcli = new JTextArea();
		conexcli.setFont(new Font("Tahoma", Font.PLAIN, 18));
		conexcli.setBounds(791, 292, 150, 35);
		frame.getContentPane().add(conexcli);

// linha de VEÍCULOS linha de VEÍCULOS linha de VEÍCULOS linha de VEÍCULOS
		JLabel labveias = new JLabel("Veículos");
		labveias.setFont(new Font("Tahoma", Font.BOLD, 24));
		labveias.setBounds(44, 339, 183, 35);
		frame.getContentPane().add(labveias);
		
		JLabel labveiasform = new JLabel("formato texto");
		labveiasform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labveiasform.setBounds(44, 364, 203, 28);
		frame.getContentPane().add(labveiasform);
			
		comboBoxvei = new JComboBox();
		comboBoxvei.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBoxvei.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxvei.setEditable(true);
		comboBoxvei.setBounds(228, 350, 713, 35);
		frame.getContentPane().add(comboBoxvei);
		comboBoxvei.setSelectedItem("Veículos visitados");
		
// linha ADICIONAR VEÍCULOS linha ADICIONAR VEÍCULOS linha ADICIONAR VEÍCULOS	
		JLabel labadveias = new JLabel("Adicionar Veículo");
		labadveias.setFont(new Font("Tahoma", Font.BOLD, 24));
		labadveias.setBounds(42, 396, 230, 35);
		frame.getContentPane().add(labadveias);
				
		JLabel labadveiasform = new JLabel("formato 9999");
		labadveiasform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labadveiasform.setBounds(42, 421, 150, 28);
		frame.getContentPane().add(labadveiasform);
		
		//JTextArea conadvei = new JTextArea();
		conadvei.setFont(new Font("Tahoma", Font.PLAIN, 18));
		conadvei.setBounds(260, 407, 150, 35);
		frame.getContentPane().add(conadvei);
		
// linha EXCLUIR VEÍCULOS linha ADICIONAR VEÍCULOS linha EXCLUIR VEÍCULOS	
		JLabel labexcveias = new JLabel("Excluir Veículo");
		labexcveias.setFont(new Font("Tahoma", Font.BOLD, 24));
		labexcveias.setBounds(585, 396, 230, 35);
		frame.getContentPane().add(labexcveias);
		
		JLabel labexcveiform = new JLabel("formato 9999");
		labexcveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labexcveiform.setBounds(585, 421, 150, 28);
		frame.getContentPane().add(labexcveiform);
		
		//JTextArea conexvei = new JTextArea();
		conexvei.setFont(new Font("Tahoma", Font.PLAIN, 18));
		conexvei.setBounds(791, 407, 150, 35);
		frame.getContentPane().add(conexvei);
		
// linha BOTÃO SALVAR linha BOTÃO SALVAR linha BOTÃO SALVAR	 linha BOTÃO SALVAR	
		JButton btnassalvar = new JButton("Salvar");
		btnassalvar.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnassalvar.setBounds(45, 483, 223, 53);
		frame.getContentPane().add(btnassalvar);
		btnassalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String concod2 = concod.getText();
				String connome2 = connome.getText();
				String conadcli2 = conadcli.getText();
				String conexcli2 = conexcli.getText();
				String conadvei2 = conadvei.getText();
				String conexvei2 = conexvei.getText();
				btnsalvar(concod2, connome2, conadcli2, conexcli2, conadvei2, conexvei2);
				concon tel = new concon();
				tel.visivel();
				frame.dispose();
			}
		});
		
// linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR
		JButton btnasexcluir = new JButton("Excluir");
		btnasexcluir.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnasexcluir.setBounds(383, 483, 223, 53);
		frame.getContentPane().add(btnasexcluir);
		btnasexcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String concod2 = concod.getText();
				btnexcluir(concod2);
				concon tel = new concon();
				tel.visivel();
				frame.dispose();
			}
		});
		
// linha BOTÂO VOLTAR linha BOTÂO VOLTAR linha BOTÂO VOLTAR linha BOTÂO VOLTAR
		JButton btnasvoltar = new JButton("Voltar");
		btnasvoltar.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnasvoltar.setBounds(718, 483, 223, 53);
		frame.getContentPane().add(btnasvoltar);		
		btnasvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conini tel = new conini();
				tel.visivel();
				frame.dispose();
			}
		});
	}
	
// buscar o consultor buscar o consultor buscar o consultor buscar o consultor buscar o consultor
	public void atualizarInformacoes(String id) {
		try {
			String queryConsultor = "Select con_nome from Consultor where con_id = '"+id+"'";
			this.resultset = this.statement.executeQuery(queryConsultor);
			while (this.resultset.next()) {
				String nome = this.resultset.getString("con_nome");
				connome.setText(nome);
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
	
// buscar clientes buscar clientes buscar clientes buscar clientes buscar clientes buscar clientes buscar clientes
	public void atualizarInformacoes2(String id) {
		try {
			
			// limpando comboBox
			comboBoxcli.removeAllItems();
			System.out.println("1");
			
			// buscando lista de clientes
			String queryconcli = "Select concli_id from concli where left(concli_id, 4)= '"+id+"'";
			this.resultset1 = this.statement1.executeQuery(queryconcli);
			// Percorrendo todos os registros no banco de dados "concli"
			System.out.println("2");
			while (this.resultset1.next()) {
				
				// Obtendo a chave "concli_id"
				String conclichave = this.resultset1.getString("concli_id");
				
				// Dividindo a chave "vconcli_id" em dois grupos de 4 dígitos
				System.out.println("3");
				String grupo1 = conclichave.substring(0, 4); // Primeiro grupo (con_id)
				String grupo2 = conclichave.substring(4, 8); // Segundo grupo (cli_id)
				
				// buscando cliente atendido
				String cli_id = grupo2;
				System.out.println("4");
				String querycli = "Select cli_nome, cli_whats from Cliente where cli_id ='" + cli_id + "'";
				this.resultset2 = this.statement2.executeQuery(querycli);
				System.out.println("5");

				// buscar no cliente
				while (this.resultset2.next()) {
					String cliwhats = this.resultset2.getString("cli_whats");
					String clinome = this.resultset2.getString("cli_nome");
					System.out.println("6");
					comboBoxcli.addItem(cli_id + "  " + cliwhats + "  " + clinome);
					String clicod2 = cli_id;
					}		
				}
			}catch(Exception e) {
				System.out.println("ERROR: "+e.getMessage());
				}
		}
			
// buscar veiculos buscar veiculos buscar veiculos buscar veiculos buscar veiculos buscar veiculos buscar veiculos
	public void atualizarInformacoes3(String id) {
		try {
			
			// limpando comboBox
			comboBoxvei.removeAllItems();
			System.out.println("1a");
			
			// buscando lista de clientes
			String queryconvei = "Select convei_id from convei where left(convei_id, 4)= '"+id+"'";
			this.resultset3 = this.statement3.executeQuery(queryconvei);
			// Percorrendo todos os registros no banco de dados "concli"
			System.out.println("2a");
			while (this.resultset3.next()) {
				
				// Obtendo a chave "concli_id"
				String conveichave = this.resultset3.getString("convei_id");
				
				// Dividindo a chave "vconcli_id" em dois grupos de 4 dígitos
				System.out.println("3a");
				String grupo1a = conveichave.substring(0, 4); // Primeiro grupo (con_id)
				String grupo2a = conveichave.substring(4, 8); // Segundo grupo (vei_id)
				
				// buscando cliente atendido
				String vei_id = grupo2a;
				System.out.println("4a");
				String querycli = "Select vei_nome from Veiculo where vei_id ='" + vei_id + "'";
				this.resultset4 = this.statement4.executeQuery(querycli);
				System.out.println("5a");
					// buscar no cliente
				while (this.resultset4.next()) {
					String veinome = this.resultset4.getString("vei_nome");
					System.out.println("6");
					comboBoxvei.addItem(vei_id + "  " + veinome);
					}		
				}
			}catch(Exception e) {
				System.out.println("ERROR: "+e.getMessage());
				}
			}
	
// ações do botão salvar ações do botão salvar ações do botão salvar ações do botão salvar
	public void btnsalvar(String concod2, String connome2, String conadcli2, String conexcli2, String conadvei2, String conexvei2) {
		try {
			String queyrexistecon = "Select con_nome from Consultor where con_id = '" + concod2 + "'";
			this.resultset = this.statement.executeQuery(queyrexistecon);
			if (resultset.next()) {
				String queryupconnome = "update Consultor set con_nome = '"+connome2+"' where con_id = '"+concod2+"'";
				this.statement.executeUpdate(queryupconnome);
			}else {	
				String queryinsertconnome = "insert into Consultor(con_id,con_nome) values ('"+concod2+"','"+connome2+"')";
				this.statement1.executeUpdate(queryinsertconnome);
			}
			
			// Adicionar e excluir cliente
			if(conadcli2.isEmpty()==false&&conadcli2.isEmpty()==false) {
				campolig.setText (concod2 + conadcli2);
				//int cliincluir = Integer.parseUnsignedInt(campolig);
				String queryincluircli = "insert into concli (concli_id) values ('"+campolig+"')";
				this.statement2.executeUpdate(queryincluircli);
			}
			if(conexcli2.isEmpty()==false&&conexcli2.isEmpty()==false) {
				campolig1.setText (concod2 + conexcli2);
				//int cliexcluir = Integer.parseUnsignedInt(campolig);
				String queryupexcluircli = "delete from concli where concli_id = '"+campolig1+"'";
				this.statement3.executeUpdate(queryupexcluircli);
			}
						
			// Adicionar e excluir veículo
			if(conadvei2.isEmpty()==false&&conadvei2.isEmpty()==false) {
				campolig.setText (concod2 + conadvei2);
				//int veiincluir = Integer.parseUnsignedInt(campolig);
				String queryincluirvei = "insert into convei (convei_id) values ('"+campolig+"')";
				this.statement4.executeUpdate(queryincluirvei);
			}
			if(conexvei2.isEmpty()==false&&conexvei2.isEmpty()==false) {
				campolig1.setText (concod2 + conexvei2);
				//int veiexcluir = Integer.parseUnsignedInt(campolig);
				String queryupexcluirvei = "delete from convei where convei_id = '"+campolig1+"'";
				this.statement3.executeUpdate(queryupexcluirvei);
			}
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
			}
		}
			
// ações botão excluir ações botão excluir ações botão excluir ações botão excluir ações botão excluir
	public void btnexcluir(String concod2) {
		try { 
		String queryconsultor = "delete from Consultor where con_id ='"+concod2+"'";
			this.statement.executeUpdate(queryconsultor);	
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
		try { 
			String queryconvei = "delete from convei where left(convei_id, 4) = '" + concod2 + "'";
			this.statement3.executeUpdate(queryconvei);	
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
		try { 
			String queryconcli = "delete from concli where left(concli_id, 4) = '" + concod2 + "'";
			this.statement2.executeUpdate(queryconcli);	
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
}
