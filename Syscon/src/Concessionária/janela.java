package Concessionaria;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JTextPane;

public class janela {
	
//armazena a conexão	
	private Connection connection = null;

//armazena as consultas
	private Statement statement = null;

//armazena os resultados
	private ResultSet resultset = null;

	public void conectar() {

//caminho
	String servidor = "jdbc:mysql://localhost:3306/Concessionaria";

//usuario
	String usuario = "root";

//senha
	String senha = "arley911";

//local driver instalado
	String driver = "com.mysql.cj.jdbc.Driver";
	try {

//acessa o driver
		Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);

//consultas
			this.statement = this.connection.createStatement();
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

	private JFormattedTextField cli_cod;
	private JFormattedTextField clicpf;
	private JTextArea clinome;
	private JTextArea clivis;
	//private JFormattedTextField cliwhats;
	private JFormattedTextField cliwhats_1;
	// private JFormattedTextField excveicli;
	// private JFormattedTextField cadveicli;
	private JFormattedTextField con_nome;
	private JLabel lblNewLabel;
	
// lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO	
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					concli window = new concli();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

// cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO
	public janela() {
	
	}

// deixa a JANELA VISIVEL QUANDO CHAMADA deixa a JANELA VISIVEL QUANDO CHAMADA
	public void visivel() {
		concli window = new concli();
	
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
			cli_cod = new JFormattedTextField(mask);
		//	concod = new JFormattedTextField(mask);
		//	asvei = new JFormattedTextField(mask1);
		//	asadveicod = new JFormattedTextField(mask2);
		//	asexcveicod = new JFormattedTextField(mask3);
			MaskFormatter mask4 = new MaskFormatter("(##) #.####-####"); 
			cliwhats_1 = new JFormattedTextField(mask4);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO na formatação de Campos", "erro", JOptionPane.ERROR_MESSAGE);
		}

		/*
		 * // MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS
		 * MÁSCARAS NumberFormat numberFormat = NumberFormat.getIntegerInstance();
		 * NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
		 * MaskFormatter("(##) 9.####-####"); cliwhats = new JFormattedTextField(mask3);
		 * MaskFormatter mask4 = new MaskFormatter("####"); excveicli = new
		 * JFormattedTextField(mask4); MaskFormatter mask6 = new MaskFormatter("####");
		 * cadveicli = new JFormattedTextField(mask6); } catch (Exception e) {
		 * JOptionPane.showMessageDialog(null, "ERRO na formatação de Campos", "erro",
		 * JOptionPane.ERROR_MESSAGE); }
		 */

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

		// JTextArea cli_cod = new JTextArea();
		cli_cod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cli_cod.setBounds(229, 124, 86, 35);
		frame.getContentPane().add(cli_cod); 
		cli_cod.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void insertUpdate(DocumentEvent e) {
			//String id = cli_cod.getText();
				atualizarInformacoes(cli_cod.getText());
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				atualizarInformacoes(cli_cod.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				atualizarInformacoes(cli_cod.getText());
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
	
		// JTextArea concod = new JTextArea();

		
/*		// CONTORNO BRANCO
		con_nome = new JFormattedTextField();
		con_nome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		con_nome.setBounds(589, 124, 352, 35);
		frame.getContentPane().add(con_nome);

		// SOMENTE EXIBIÇÃO DO TEXTO SEM EDIÇÃO
		JLabel blNewLabel = new JLabel("");
		// lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(589, 85, 282, 28);
		frame.getContentPane().add(lblNewLabel);
		*/
	
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
		clinome.setBounds(229, 174, 712, 40);
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

		//cliwhats_1 = new JFormattedTextField();
		cliwhats_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cliwhats_1.setBounds(229, 234, 712, 40);
		frame.getContentPane().add(cliwhats_1);
		
// linha VISITAS CLIENTE linha VISITAS CLIENTE linha VISITAS CLIENTE	
		JLabel labviscli = new JLabel("Veículos visitados");
		labviscli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labviscli.setBounds(45, 295, 220, 35);
		frame.getContentPane().add(labviscli);

		JLabel labviscliform = new JLabel("formato 9999");
		labviscliform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labviscliform.setBounds(45, 320, 203, 28);
		frame.getContentPane().add(labviscliform);

		clivis = new JTextArea();
		clivis.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clivis.setBounds(275, 302, 666, 35);
		frame.getContentPane().add(clivis);

// linha CADASTRAR VEÍCULO linha CADASTRAR VEÍCULO linha CADASTRAR VEÍCULO
		JLabel labadveicli = new JLabel("Cadastrar Veículo");
		labadveicli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labadveicli.setBounds(45, 349, 234, 35);
		frame.getContentPane().add(labadveicli);

		JLabel labcadcliform = new JLabel("formato 9999");
		labcadcliform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcadcliform.setBounds(45, 374, 203, 28);
		frame.getContentPane().add(labcadcliform);

		JTextArea cadveicli = new JTextArea();
		cadveicli.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cadveicli.setBounds(275, 360, 160, 35);
		frame.getContentPane().add(cadveicli);

// linha EXCLUIR VEÍCULO linha EXCLUIR VEÍCULO linha EXCLUIR VEÍCULO
		JLabel labexveicli = new JLabel("Excluir Veículo");
		labexveicli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labexveicli.setBounds(572, 349, 183, 35);
		frame.getContentPane().add(labexveicli);

		JLabel labconcliform_1 = new JLabel("formato 9999");
		labconcliform_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labconcliform_1.setBounds(572, 374, 203, 28);
		frame.getContentPane().add(labconcliform_1);

		JTextArea excveicli = new JTextArea();
		excveicli.setFont(new Font("Tahoma", Font.PLAIN, 18));
		excveicli.setBounds(781, 360, 160, 35);
		frame.getContentPane().add(excveicli);

// linha BOTÃO SALVAR linha BOTÃO SALVAR linha BOTÃO SALVAR	 linha BOTÃO SALVAR	
		JButton btnclisalvar = new JButton("Salvar");
		btnclisalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = cli_cod.getText();
				String nome = clinome.getText();
				String whats = cliwhats_1.getText();
				if(verificarContato(id)) {
					editarContato(id,nome,whats);
				}else {
					inserirContato(id,nome,whats);
				}
			}
		});
		btnclisalvar.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnclisalvar.setBounds(42, 443, 223, 53);
		frame.getContentPane().add(btnclisalvar);

// linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR
		JButton btncliExcluir = new JButton("Excluir");
		btncliExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = cli_cod.getText();
				apagarContato(id);
				clinome.setText("");
				cliwhats_1.setText("");
			}
		});
		btncliExcluir.setFont(new Font("Tahoma", Font.BOLD, 36));
		btncliExcluir.setBounds(380, 443, 223, 53);
		frame.getContentPane().add(btncliExcluir);

// linha BOTÂO VOLTAR linha BOTÂO VOLTAR linha BOTÂO VOLTAR linha BOTÂO VOLTAR
		JButton btnclivoltar = new JButton("Voltar");
		btnclivoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conini tel = new conini();
				tel.visivel();
				frame.dispose();
			}
		});
		btnclivoltar.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnclivoltar.setBounds(714, 443, 223, 53);
		frame.getContentPane().add(btnclivoltar);
		
		
	}

	




	
	
	
	
	
	
	
// BUSCAR CONSULTOR BUSCAR CONSULTOR BUSCAR CONSULTOR BUSCAR CONSULTOR BUSCAR CONSULTOR
	public void atualizarInformacoesConsultor(String id) {
		try {
			String query = "Select con_nome from Consultor where con_id= '"+id+"'";
			this.resultset = this.statement.executeQuery(query);
			while (this.resultset.next()) {
			String nome = this.resultset.getString("con_nome");
			//con_nome.setText(nome);
			lblNewLabel.setText(nome);
			}
		}catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}

	
// BUSCAR BANCO DE DADOS E IMPRIMIR BUSCAR BANCO DE DADOS E IMPRIMIR
	public void atualizarInformacoes(String id) {
		try {
			String query = "Select cli_nome,cli_whats from Cliente where cli_id= '"+id+"'";
			this.resultset = this.statement.executeQuery(query);
			while (this.resultset.next()) {
			String nome = this.resultset.getString("cli_nome");
			String whats =this.resultset.getString("cli_whats");
			clinome.setText(nome);
			cliwhats_1.setText(whats);
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
	
	
// EDITAR DADOS EDITAR DADOS EDITAR DADOS EDITAR DADOS EDITAR DADOS EDITAR DADOS
	public void editarContato(String cli_id,String cli_nome, String cli_whats) {
		try {
		
// aspas simple que � usado no mysql
			String query = "update cliente set cli_nome ='"+cli_nome+"',cli_whats = '"+cli_whats+"' where cli_id = '"+cli_id+"'";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
			}
		}
	
		
// APAGAR CLIENTE APAGAR CLIENTE APAGAR CLIENTE APAGAR CLIENTE APAGAR CLIENTE
	public void apagarContato(String id) {
		try {

//aspas simple que � usado no mysql
			String query = "delete from cliente where cli_id ='"+id+"'";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
	
// CADASTRAR OU ALTERAR O CLIENTE CADASTRAR OU ALTERAR O CLIENTE	
	public boolean verificarContato(String id) {
		try {
			String query = "Select * from cliente where cli_id = '"+id+"'";
			this.resultset = this.statement.executeQuery(query);
			while (this.resultset.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		return false;
	}
	public void inserirContato(String id, String nome, String whats) {
		try {

	//aspas simple que � usado no mysql
	String query = "insert into cliente(cli_id,cli_nome,cli_whats) values ('"+id+"','"+nome+"','"+whats+"')";
		this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
}
