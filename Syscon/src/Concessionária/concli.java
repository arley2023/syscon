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

public class concli {
	
private static final String ComboBoxclivei = null;

	//armazena a conexão	
	private Connection connection = null;

//armazena as consultas
	private Statement statement = null;
	private Statement statement1 = null;
	private Statement statement2 = null;
	private Statement statement3 = null;
	private Statement statement4 = null;

//armazena os resultados
	private ResultSet resultset = null;
	private ResultSet resultset1 = null;
	private ResultSet resultset2 = null;
	private ResultSet resultset3 = null;
	private ResultSet resultset4 = null;

// cria a comboBox	
	JComboBox comboBoxcli;
	
	public void conectar() {
	
//caminho
	String servidor = "jdbc:mysql://localhost:3306/Concessionaria";

//usuario
	String usuario = "root";

//senha
	String senha = "";

//local driver instalado
	String driver = "com.mysql.cj.jdbc.Driver";
	try {

//acessa o driver
		Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);

//consultas
			this.statement = this.connection.createStatement();
			this.statement1 = this.connection.createStatement();
			this.statement2 = this.connection.createStatement();
			this.statement3 = this.connection.createStatement();
			this.statement4 = this.connection.createStatement();
		}catch (Exception e) {
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

	private JFormattedTextField clicod;
	private JFormattedTextField cliwhats;
	private JFormattedTextField cliadvei;
	private JFormattedTextField cliexvei;
	private JTextArea clinome;
	private JTextArea connome;
	private JTextField clicod2;
	private JTextField cliexvei2;
	private JTextField cliadvei2;
	
	
// lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					concli window = new concli();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

// cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO
	public concli() {
		initialize();
	}

// deixa a JANELA VISIVEL QUANDO CHAMADA deixa a JANELA VISIVEL QUANDO CHAMADA
	public void visivel() {
		concli window = new concli();
		window.frame.setVisible(true);
	}

// inicia a JANELA inicia a JANELA inicia a JANELA inicia a JANELA inicia a JANELA
	private void initialize() {
		conectar();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1011, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
// MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS
		NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setAllowsInvalid(false);
        try {
        	MaskFormatter mask = new MaskFormatter("####");
			clicod = new JFormattedTextField(mask);
			MaskFormatter mask1 = new MaskFormatter("####");
			cliadvei = new JFormattedTextField(mask1);
			MaskFormatter mask2 = new MaskFormatter("####");
			cliexvei = new JFormattedTextField(mask2);
			MaskFormatter mask4 = new MaskFormatter("(##) #.####-####"); 
			cliwhats = new JFormattedTextField(mask4);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO na formatação de Campos", "erro", JOptionPane.ERROR_MESSAGE);
		}

// label janela CLIENTE E LOGOTIPO label janela CLIENTE E LOGOTIPO
		JLabel labcli = new JLabel("Cliente");
		labcli.setFont(new Font("Tahoma", Font.BOLD, 50));
		labcli.setBounds(45, 33, 183, 61);
		frame.getContentPane().add(labcli);

		JLabel lablogo = new JLabel("SysCon");
		lablogo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lablogo.setBounds(758, 33, 183, 61);
		frame.getContentPane().add(lablogo);

// linha CÓDIGO DO CLIENTE linha CÓDIGO DO CLIENTE linha CÓDIGO DO CLIENTE
		JLabel labcodcli = new JLabel("Cliente cod.");
		labcodcli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcodcli.setBounds(45, 114, 150, 35);
		frame.getContentPane().add(labcodcli);

		JLabel labcodcliform = new JLabel("formato 9999");
		labcodcliform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcodcliform.setBounds(45, 139, 150, 28);
		frame.getContentPane().add(labcodcliform);

		//JTextArea clicod = new JTextArea();
		clicod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clicod.setBounds(229, 124, 86, 35);
		frame.getContentPane().add(clicod); 
		clicod.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void insertUpdate(DocumentEvent e) {
			//String id = cli_cod.getText();
				atualizarInformacoes(clicod.getText());
				atualizarInformacoes2(clicod.getText());
				atualizarInformacoes3(clicod.getText());
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				atualizarInformacoes(clicod.getText());
				atualizarInformacoes2(clicod.getText());
				atualizarInformacoes3(clicod.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				atualizarInformacoes(clicod.getText());
				atualizarInformacoes2(clicod.getText());
				atualizarInformacoes3(clicod.getText());
			}
		});
	
// linha CONSULTOR CLIENTE linha CONSULTOR CLIENTE linha CONSULTOR CLIENTE	
		JLabel labconcli = new JLabel("Consultor");
		labconcli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labconcli.setBounds(348, 114, 124, 35);
		frame.getContentPane().add(labconcli);

		JLabel labconcliform = new JLabel("formato 9999");
		labconcliform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labconcliform.setBounds(348, 139, 107, 28);
		frame.getContentPane().add(labconcliform);
	
		connome = new JTextArea();
		connome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		connome.setBounds(488, 125, 453, 35);
		frame.getContentPane().add(connome);
	
// linha NOME CLIENTE linha NOME CLIENTE linha NOME CLIENTE linha NOME CLIENTE
		JLabel labnomecli = new JLabel("Nome");
		labnomecli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labnomecli.setBounds(45, 167, 150, 35);
		frame.getContentPane().add(labnomecli);

		JLabel labnomecliform = new JLabel("formato texto");
		labnomecliform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labnomecliform.setBounds(45, 192, 150, 28);
		frame.getContentPane().add(labnomecliform);

		clinome = new JTextArea();
		clinome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clinome.setBounds(231, 178, 710, 40);
		frame.getContentPane().add(clinome);

// linha WHATS CLIENTE linha WHATS CLIENTE linha WHATS CLIENTE linha WHATS CLIENTE
		JLabel labwhatscli = new JLabel("WhatsApp");
		labwhatscli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labwhatscli.setBounds(45, 231, 150, 35);
		frame.getContentPane().add(labwhatscli);

		JLabel labwhatscliform = new JLabel("formato (85) 9.9999-99");
		labwhatscliform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labwhatscliform.setBounds(45, 256, 203, 28);
		frame.getContentPane().add(labwhatscliform);

		//cliwhats = new JFormattedTextField();
		cliwhats.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cliwhats.setBounds(229, 234, 712, 40);
		frame.getContentPane().add(cliwhats);
		
// linha VISITAS CLIENTE linha VISITAS CLIENTE linha VISITAS CLIENTE	
		JLabel labviscli = new JLabel("Veículos visitados");
		labviscli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labviscli.setBounds(45, 295, 220, 35);
		frame.getContentPane().add(labviscli);

		JLabel labviscliform = new JLabel("formato 9999");
		labviscliform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labviscliform.setBounds(45, 320, 203, 28);
		frame.getContentPane().add(labviscliform);

		comboBoxcli = new JComboBox();
		comboBoxcli.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBoxcli.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxcli.setEditable(true);
		comboBoxcli.setBounds(288, 301, 653, 35);
		frame.getContentPane().add(comboBoxcli);
		comboBoxcli.setSelectedItem("Veículos visitados");
		
// linha CADASTRAR VEÍCULO linha CADASTRAR VEÍCULO linha CADASTRAR VEÍCULO
		JLabel labadveicli = new JLabel("Cadastrar Veículo");
		labadveicli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labadveicli.setBounds(45, 349, 234, 35);
		frame.getContentPane().add(labadveicli);

		JLabel labcadcliform = new JLabel("formato 9999");
		labcadcliform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcadcliform.setBounds(45, 374, 203, 28);
		frame.getContentPane().add(labcadcliform);

		JTextArea cliadvei = new JTextArea();
		cliadvei.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cliadvei.setBounds(275, 360, 160, 35);
		frame.getContentPane().add(cliadvei);

// linha EXCLUIR VEÍCULO linha EXCLUIR VEÍCULO linha EXCLUIR VEÍCULO
		JLabel labexveicli = new JLabel("Excluir Veículo");
		labexveicli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labexveicli.setBounds(572, 349, 183, 35);
		frame.getContentPane().add(labexveicli);

		JLabel labconcliform_1 = new JLabel("formato 9999");
		labconcliform_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labconcliform_1.setBounds(572, 374, 203, 28);
		frame.getContentPane().add(labconcliform_1);

		JTextArea cliexvei = new JTextArea();
		cliexvei.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cliexvei.setBounds(781, 360, 160, 35);
		frame.getContentPane().add(cliexvei);

// linha BOTÃO SALVAR linha BOTÃO SALVAR linha BOTÃO SALVAR	 linha BOTÃO SALVAR	
		JButton btnclisalvar = new JButton("Salvar");
		btnclisalvar.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnclisalvar.setBounds(42, 443, 223, 53);
		frame.getContentPane().add(btnclisalvar);
		btnclisalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = clicod.getText();
				String nome = clinome.getText();
				String whats = cliwhats.getText();
				btnsalvar(id, nome, whats);
				concli tel = new concli();
				tel.visivel();
				frame.dispose();
				}
			});
		
// linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR
		JButton btncliExcluir = new JButton("Excluir");
		btncliExcluir.setFont(new Font("Tahoma", Font.BOLD, 36));
		btncliExcluir.setBounds(380, 443, 223, 53);
		frame.getContentPane().add(btncliExcluir);
		btncliExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = clicod.getText();
				btnexcluir(id);
				concli tel = new concli();
				tel.visivel();
				frame.dispose();
			}
		});
		
// linha BOTÂO VOLTAR linha BOTÂO VOLTAR linha BOTÂO VOLTAR linha BOTÂO VOLTAR
		JButton btnclivoltar = new JButton("Voltar");
		btnclivoltar.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnclivoltar.setBounds(714, 443, 223, 53);
		frame.getContentPane().add(btnclivoltar);
		btnclivoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conini tel = new conini();
				tel.visivel();
				frame.dispose();
			}
		});
	
	
// buscar o cliente buscar o cliente buscar o cliente buscar o cliente buscar o cliente
	public void atualizarInformacoes(String id) {
		try {
			String querynomecli = "Select (cli_id,cli_whats) from Cliente where cli_id = '"+id+"'";
			this.resultset = this.statement.executeQuery(querynomecli);
			while (this.resultset.next());
				String clinome = this.resultset.getString("cli_nome");
				String cliwhats = this.resultset.getString("cli_whats");
		}catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
			
// buscar o consultor buscar o consultor buscar o consultor buscar o consultor buscar o consultor
		public void atualizarInformacoes2(String id) {
			try {	
				String querybuscaconsultor = "Select concli_id, from conlci where left(concli_id, 4) = '"+id+"'";
				this.resultset1 = this.statement1.executeQuery(querybuscaconsultor);
				// Obtendo a chave "veiace_id"
				String pegaconsultor = this.resultset1.getString("concli_id");
			
				// Dividindo a chave "con_id" em três grupos de 4 dígitos
				String grupo1 = pegaconsultor.substring(0, 4); // Primeiro grupo (con_id)
				String grupo2 = pegaconsultor.substring(4); // Segundo grupo (cli_id)
				
				// buscando veiculo do grupo3
				String concod2 = grupo1;
				String querypegaconsultor = "Select con_nome from Consultor where con_id ='" + concod2 + "'";
				this.resultset2 = this.statement2.executeQuery(querypegaconsultor);
				String connome = this.resultset2.getString("concod2"+"  "+"con_nome");
			}catch (Exception e) {
				System.out.println("ERROR: " + e.getMessage());
			}
		}
			
// buscar veículos visitados buscar veículos visitados buscar veículos visitados buscar veículos visitados
	public void atualizarInformacoes3(String id) {
		try {
			comboBoxcli.removeAllItems();
			String queryveivis = "Select clivei_id from clivei where left(clivei_id, 4) = '"+id+"'";
			this.resultset3 = this.statement3.executeQuery(queryveivis);
			
			// Percorrendo todos os registros no banco de dados "ligacao"
			while (this.resultset3.next()) {
				
				// Obtendo a chave "veiace_id"
				String cliveivis = this.resultset.getString("clivei_id");
				
				// Dividindo a chave "veiace_id" em dois grupos de 4 dígitos
				String grupo1a = cliveivis.substring(0, 4); // Primeiro grupo (cli_id)
				String grupo2a = cliveivis.substring(4, 8); // Segundo grupo (vei_id)

				// buscando veiculo do grupo3
				String cliveibusca = grupo2a;
				String querybuscveivis = "Select vei_nome from Veiculo where vei_id ='" + cliveibusca + "'";
				this.resultset4 = this.statement4.executeQuery(querybuscveivis);
				String vei_nome2 = this.resultset4.getString("vei_nome");
				comboBoxcli.addItem(grupo2a + "  " + vei_nome2);
			}
		}catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}

// botão salvar botão salvar botão salvar botão salvar botão salvar botão salvar botão salvar botão salvar botão salvar
	public void btnsalvar(String id,String nome,String whats) {
		try {
			String querycliente = "Select cli_id from Cliente where cli_id = '" + id + "'";
			this.resultset3 = this.statement3.executeQuery(querycliente);
			if (resultset3.next()) {
					String queryupcli = "update Acessorios set ace_nome = '"+acenome2+"' where ace_id = '"+ascod2+"'";
					this.statement2.executeUpdate(queryupcli);
				}else {	
					String queryupcliin = "insert into Acessorios(cli_id,cli_nome,cli_whats) values ('"+id+"','"+nome+"','"+whats+"')";
					this.statement4.executeUpdate(queryupcliin);
				}
			if(cliadvei.isEmpty()==false&&cliadvei.isEmpty()==false) {
				String codeincluir = id + cliadvei;
				String queryupadicionavei = "insert into veiace (veiace_id) values ('"+codeincluir+"')";
				this.statement2.executeUpdate(queryupadicionavei);
			}
			if(cliexvei.isEmpty()==false&&cliexvei.isEmpty()==false) {
				String codexcluir = id + cliexvei;
				String queryupexcluivei = "delete from veiace where veiace_id = '"+codexcluir+"'";
				this.statement1.executeUpdate(queryupexcluivei);
			}
		}catch (Exception d) {
			System.out.println("ERROR: " + d.getMessage());
		}
	}

// botão salvar botão salvar botão salvar botão salvar botão salvar botão salvar botão salvar botão salvar botão salvar
	public void btnexcluir(String id) {
		try {
			String queryexcluicli = "delete from Cliente where cli_id = '" + id + "'";
			this.resultset = this.statement.executeQuery(queryexcluicli);
		}catch (Exception m) {
			System.out.println("ERROR: " + m.getMessage());
		}
		try {
			String queryexcluir = "delete from concli where right(concli_id, 4) = '" + id + "'";
			this.resultset3 = this.statement3.executeQuery(queryexcluir);
		}catch (Exception n) {
			System.out.println("ERROR: " + n.getMessage());
		}
		try {
			String queryveiexcluir = "delete from clivei where left(clivei_id, 4) = '" + id + "'";
			this.resultset4 = this.statement4.executeQuery(queryveiexcluir);
		}catch (Exception g) {
			System.out.println("ERROR: " + g.getMessage());
		}
	}	
	}
