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
	private JFormattedTextField chaveligacaomask;
	private JTextArea connome;
	private JTextField concod2;
	private JTextField adcli2;
	private JTextField excli2;
	private JTextField advei2;
	private JTextField exvei2;

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
		    MaskFormatter mask5 = new MaskFormatter("############");
		    chaveligacaomask = new JFormattedTextField(mask5);
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
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				atualizarInformacoes(concod.getText());
				atualizarInformacoes2(concod.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				atualizarInformacoes(concod.getText());
				atualizarInformacoes2(concod.getText());
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
				String adcli2 = conadcli.getText();
				String excli2 = conexcli.getText();
				String advei2 = conadvei.getText();
				String exvei2 = conexvei.getText();
				btnsalvar(concod2, connome2, adcli2, excli2, advei2, exvei2);
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
				apagarConsultor(concod2);
				connome.setText("");
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
	
// buscar clientes e veiculos buscar clientes e veiculos buscar clientes e veiculos buscar clientes e veiculos
	public void atualizarInformacoes2(String concod2) {
		try {
			comboBoxvei.removeAllItems();
			comboBoxcli.removeAllItems();
			String queryconclivei = "Select ligacao_id from ligacao where left(ligacao_id, 4)= '"+concod2+"'";
			this.resultset = this.statement.executeQuery(queryconclivei);
			// Percorrendo todos os registros no banco de dados "ligacao"
			while (this.resultset.next()) {
				// Obtendo a chave "veiace_id"
				String conclivei = this.resultset.getString("ligacao_id");
				
				// Dividindo a chave "veiace_id" em dois grupos de 4 dígitos
				String grupo1 = conclivei.substring(0, 4); // Primeiro grupo (con_id)
				String grupo2 = conclivei.substring(4, 8); // Segundo grupo (cli_id)
				String grupo3 = conclivei.substring(8, 12); // Terceiro grupo (vei_id)

				// buscando cliente atendido
				String cli_id = grupo2;
				System.out.println("buscando nome cliente");
				String querycli = "Select cli_nome from Cliente where cli_id ='" + cli_id + "'";
				this.resultset1 = this.statement1.executeQuery(querycli);
				while (this.resultset1.next()) {
					String cliNome1 = this.resultset1.getString("cli_nome");
					comboBoxcli.addItem(cli_id + "  " + cliNome1);
				}
				
				// buscando veiculo visitado
				String vei_id = grupo3;
				System.out.println("buscando veiculo");
				String queryvei = "Select vei_nome from Veiculo where vei_id ='" + vei_id + "'";
				this.resultset2 = this.statement2.executeQuery(queryvei);
				while (this.resultset2.next()) {
					String veiNome1 = this.resultset2.getString("cli_nome");
					comboBoxvei.addItem(vei_id + "  " + veiNome1);
				}
			}
		} catch (Exception e) {
				System.out.println("ERROR: " + e.getMessage());
		}
	}
	
// ações do botão salvar ações do botão salvar ações do botão salvar ações do botão salvar
	public void btnsalvar(String concod2, String connome2, String adcli2, String excli2, String advei2, String exvei2) {
		try {			
			String queryconsultorsalvar = "update Consultor set con_nome ='"+connome2+"' where con_id = '"+concod2+"'";
			this.resultset3 = this.statement3.executeQuery(queryconsultorsalvar);
			if (resultset3.next()) {
				String queryupconnome = "update Consultor set con_nome = '"+connome2+"' where ace_id = '"+concod2+"'";
				this.statement.executeUpdate(queryupconnome);
			}else {	
				String queryinsertconnome = "insert into Consultor(con_id,con_nome) values ('"+concod2+"','"+connome2+"')";
				this.statement2.executeUpdate(queryinsertconnome);
			}
			
			// Dividindo a chave "veiace_id" em três grupos de 4 dígitos
			String conchave = this.resultset.getString("con_id");
			String grupo1 = conchave.substring(0, 4); // Primeiro grupo (con_id)
			String grupo2 = conchave.substring(4, 8); // Segundo grupo (cli_id)
			String grupo3 = conchave.substring(8, 12); // Terceiro grupo (vei_id)
			
			// Adicionar e excluir cliente
			if(adcli2.isEmpty()==false&&adcli2.isEmpty()==false) {
				chaveligacaomask.setText (concod2 + adcli2 + "0000");
				int cliincluir = Integer.parseUnsignedInt(chaveligacaomask);
				String queryincluircli = "insert into ligacao (ligacao_id) values ('"+cliincluir+"')";
				this.statement1.executeUpdate(queryincluircli);
			}
			if(excli2.isEmpty()==false&&excli2.isEmpty()==false) {
				chaveligacaomask.setText (concod2 + excli2 + "0000");
				int cliexcluir = Integer.parseUnsignedInt(chaveligacaomask);
				String queryupexcluirvei = "delete from ligacao where ligacao_id = '"+cliexcluir+"'";
				this.statement3.executeUpdate(queryupexcluirvei);
			}
						
			// Adicionar e excluir veículo
			if(advei2.isEmpty()==false&&advei2.isEmpty()==false) {
				chaveligacaomask.setText (concod2 + "0000" + advei2);
				int veiincluir = Integer.parseUnsignedInt(chaveligacaomask);
				String queryincluirvei = "insert into ligacao (ligacao_id) values ('"+veiincluir+"')";
				this.statement2.executeUpdate(queryincluirvei);
			}
			if(exvei2.isEmpty()==false&&exvei2.isEmpty()==false) {
				chaveligacaomask.setText (concod2 + "0000" + exvei2);
				int veiexcluir = Integer.parseUnsignedInt(chaveligacaomask);
				String queryupexcluirvei = "delete from ligacao where ligacao_id = '"+veiexcluir+"'";
				this.statement4.executeUpdate(queryupexcluirvei);
			}
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
			}
		}
			
// ações botão excluir ações botão excluir ações botão excluir ações botão excluir ações botão excluir
	public void apagarConsultor(String concod2) {
		try { 
		String query = "delete from Consultor where con_id ='"+concod2+"'";
			this.statement.executeUpdate(query);	
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
		try { 
			String queryligexcluirconsultor = "delete from ligacao where left(ligacao_id, 4) = '" + concod2 + "'";
			this.statement3.executeUpdate(queryligexcluirconsultor);	
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
}
