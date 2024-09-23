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

public class convei {
	
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
		JComboBox comboBoxace;
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
	
	private JFormattedTextField veicod;
	private JFormattedTextField veiano;
	private JFormattedTextField veikm;
	private JFormattedTextField veimod;
	private JFormattedTextField veiplaca;
	private JTextArea veicambio;
	private JTextArea veicarroc;
	private JTextArea veicombustivel;
	private JTextArea veicondicao;
	private JTextArea veicor;
	private JTextArea veimarca;
	private JTextArea veinome;
	private JTextArea veimais;
	private JTextField veicod2;
	private JTextField veiano2;
	private JTextField veikm2;
	private JTextField veimod2;
	private JTextField veiplaca2;
	
	
// lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO	
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				convei window = new convei();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		});
	}

// cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO
	public convei() {
		initialize();
	}

// deixa a JANELA VISIVEL QUANDO CHAMADA deixa a JANELA VISIVEL QUANDO CHAMADA
	public void visivel() {
		convei window = new convei();
		window.frame.setVisible(true);
	}

// inicia a JANELA inicia a JANELA inicia a JANELA inicia a JANELA inicia a JANELA
	private void initialize() {
		conectar();
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 697);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
// MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS
		NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setAllowsInvalid(false);
        try {
		    MaskFormatter mask = new MaskFormatter("####");
		    veiano = new JFormattedTextField(mask);
		    MaskFormatter mask1 = new MaskFormatter("####");
		    veimod = new JFormattedTextField(mask1);
		    MaskFormatter mask3 = new MaskFormatter("***-****");
			veiplaca = new JFormattedTextField(mask3);
			MaskFormatter mask4 = new MaskFormatter("####");
			veicod = new JFormattedTextField(mask4);
			MaskFormatter mask2 = new MaskFormatter("###.###");
			veikm = new JFormattedTextField(mask2);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO na formatação de Campos", "erro", JOptionPane.ERROR_MESSAGE);
		}		

// label janela CLIENTE E LOGOTIPO label janela CLIENTE E LOGOTIPO
		JLabel labcli = new JLabel("Veículo");
		labcli.setFont(new Font("Tahoma", Font.BOLD, 50));
		labcli.setBounds(43, 22, 240, 61);
		frame.getContentPane().add(labcli);
		
		JLabel lablogo = new JLabel("SysCon");
		lablogo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lablogo.setBounds(1262, 22, 183, 61);
		frame.getContentPane().add(lablogo);
		
// linha CÓDIGO VEÍCULO linha CÓDIGO VEÍCULO linha CÓDIGO VEÍCULO linha CÓDIGO VEÍCULO
		JLabel labcodvei = new JLabel("Veículo cod.");
		labcodvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcodvei.setBounds(44, 94, 150, 35);
		frame.getContentPane().add(labcodvei);
				
		JLabel labcodveiform = new JLabel("formato 9999");
		labcodveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcodveiform.setBounds(44, 119, 150, 28);
		frame.getContentPane().add(labcodveiform);
			
		//JTextArea veicod = new JTextArea();
		veicod.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veicod.setBounds(204, 105, 111, 35);
		frame.getContentPane().add(veicod);
		veicod.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void insertUpdate(DocumentEvent e) {
				atualizarInformacoes(veicod.getText());
				atualizarInformacoes1(veicod.getText());
				atualizarInformacoes2(veicod.getText());
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				atualizarInformacoes(veicod.getText());
				atualizarInformacoes1(veicod.getText());
				atualizarInformacoes2(veicod.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				atualizarInformacoes(veicod.getText());
				atualizarInformacoes1(veicod.getText());
				atualizarInformacoes2(veicod.getText());
			}
		});
		
// linha NOME VEÍCULO linha NOME VEÍCULO linha NOME VEÍCULO linha NOME VEÍCULO
		JLabel labnomevei = new JLabel("Nome");
		labnomevei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labnomevei.setBounds(338, 94, 150, 35);
		frame.getContentPane().add(labnomevei);
				
		JLabel labnomeveiform = new JLabel("formato texto");
		labnomeveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labnomeveiform.setBounds(338, 119, 150, 28);
		frame.getContentPane().add(labnomeveiform);
		
		veinome = new JTextArea();
		veinome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veinome.setBounds(445, 101, 485, 35);
		frame.getContentPane().add(veinome);	
		
// linha ANO VEÍCULO linha ANO VEÍCULO linha ANO VEÍCULO linha ANO VEÍCULO
		JLabel labcanovei = new JLabel("Ano");
		labcanovei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcanovei.setBounds(959, 94, 150, 35);
		frame.getContentPane().add(labcanovei);
				
		JLabel labanoveiform = new JLabel("formato 9999");
		labanoveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labanoveiform.setBounds(959, 119, 150, 28);
		frame.getContentPane().add(labanoveiform);
			
		//veiano = new JTextArea();
		veiano.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veiano.setBounds(1344, 105, 101, 35);
		frame.getContentPane().add(veiano);
		
// linha MODELO VEÍCULO linha MODELO VEÍCULO linha MODELO VEÍCULO linha MODELO VEÍCULO
		JLabel labcmodvei = new JLabel("Modelo");
		labcmodvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcmodvei.setBounds(1223, 94, 150, 35);
		frame.getContentPane().add(labcmodvei);
				
		JLabel labmodveiform = new JLabel("formato 9999");
		labmodveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labmodveiform.setBounds(1223, 119, 150, 28);
		frame.getContentPane().add(labmodveiform);
			
		//veimod = new JTextArea();
		veimod.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veimod.setBounds(1079, 101, 111, 35);
		frame.getContentPane().add(veimod);
		
// linha MARCA VEÍCULO linha MARCA VEÍCULO linha MARCA VEÍCULO linha MARCA VEÍCULO
		JLabel labmarcavei = new JLabel("Marca");
		labmarcavei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labmarcavei.setBounds(43, 152, 104, 35);
		frame.getContentPane().add(labmarcavei);
		
		JLabel labmarcaveiform = new JLabel("Selecione");
		labmarcaveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labmarcaveiform.setBounds(43, 177, 104, 28);
		frame.getContentPane().add(labmarcaveiform);
		
		veimarca = new JTextArea();
		veimarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veimarca.setBounds(157, 162, 147, 35);
		frame.getContentPane().add(veimarca);
		
// linha CONDIÇÃO VEÍCULO linha CONDIÇÃO VEÍCULO linha CONDIÇÃO VEÍCULO linha CONDIÇÃO VEÍCULO
		JLabel labcondvei = new JLabel("Condição");
		labcondvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcondvei.setBounds(349, 152, 150, 35);
		frame.getContentPane().add(labcondvei);
		
		JLabel labcondveiform = new JLabel("Selecione");
		labcondveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcondveiform.setBounds(349, 177, 150, 28);
		frame.getContentPane().add(labcondveiform);
		
		veicondicao = new JTextArea();
		veicondicao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veicondicao.setBounds(473, 162, 160, 35);
		frame.getContentPane().add(veicondicao);		
		
// linha PLACA VEÍCULO linha PLACA VEÍCULO linha PLACA VEÍCULO linha PLACA VEÍCULO
		JLabel labplacavei = new JLabel("Placa");
		labplacavei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labplacavei.setBounds(692, 155, 150, 35);
		frame.getContentPane().add(labplacavei);
		
		JLabel labplacaveiform = new JLabel("formato XXX-XXXX");
		labplacaveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labplacaveiform.setBounds(692, 180, 150, 28);
		frame.getContentPane().add(labplacaveiform);
		
		//veiplaca = new JTextArea();
		veiplaca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veiplaca.setBounds(852, 162, 150, 35);
		frame.getContentPane().add(veiplaca);
		
// linha QUILOMETRAGEM VEÍCULO linha QUILOMETRAGEM VEÍCULO linha QUILOMETRAGEM VEÍCULO
		JLabel labkmvei = new JLabel("Quilometragem");
		labkmvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labkmvei.setBounds(1076, 155, 201, 35);
		frame.getContentPane().add(labkmvei);
		
		JLabel labkmveiform = new JLabel("formato 999.999");
		labkmveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labkmveiform.setBounds(1076, 180, 150, 28);
		frame.getContentPane().add(labkmveiform);
		
		//veikm = new JTextArea();
		veikm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veikm.setBounds(1298, 158, 147, 35);
		frame.getContentPane().add(veikm);
		
// linha COMBUSTÍVEL VEÍCULO linha COMBUSTÍVEL VEÍCULO linha COMBUSTÍVEL VEÍCULO	
		JLabel lblCombvei = new JLabel("Combustível");
		lblCombvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCombvei.setBounds(44, 213, 150, 35);
		frame.getContentPane().add(lblCombvei);
		
		JLabel labcombveiform = new JLabel("Selecione");
		labcombveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcombveiform.setBounds(44, 238, 150, 28);
		frame.getContentPane().add(labcombveiform);
		
		veicombustivel = new JTextArea();
		veicombustivel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		veicombustivel.setBounds(223, 220, 148, 35);
		frame.getContentPane().add(veicombustivel);
		
// linha CÂMBIO VEÍCULO linha CÂMBIO VEÍCULO linha CÂMBIO VEÍCULO linha CÂMBIO VEÍCULO
		JLabel labcambvei = new JLabel("Câmbio");
		labcambvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcambvei.setBounds(456, 213, 150, 35);
		frame.getContentPane().add(labcambvei);
		
		JLabel labcambveiform = new JLabel("Selecione");
		labcambveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcambveiform.setBounds(456, 238, 150, 28);
		frame.getContentPane().add(labcambveiform);
		
		veicambio = new JTextArea();
		veicambio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		veicambio.setBounds(570, 220, 150, 35);
		frame.getContentPane().add(veicambio);
		
// linha CARROCERIA VEÍCULO linha CARROCERIA VEÍCULO linha CARROCERIA VEÍCULO	
		JLabel labcarrocvei = new JLabel("Carroceria");
		labcarrocvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcarrocvei.setBounds(819, 213, 150, 35);
		frame.getContentPane().add(labcarrocvei);
		
		JLabel labcarrocveiform = new JLabel("Selecione");
		labcarrocveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcarrocveiform.setBounds(819, 238, 150, 28);
		frame.getContentPane().add(labcarrocveiform);
		
		veicarroc = new JTextArea();
		veicarroc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		veicarroc.setBounds(971, 220, 150, 35);
		frame.getContentPane().add(veicarroc);
		
// linha COR VEÍCULO linha COR VEÍCULO linha COR VEÍCULO linha COR VEÍCULO	
		JLabel labcorvei = new JLabel("Cor");
		labcorvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcorvei.setBounds(1195, 213, 150, 35);
		frame.getContentPane().add(labcorvei);
		
		JLabel labcorveiform = new JLabel("Selecione");
		labcorveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcorveiform.setBounds(1195, 238, 150, 28);
		frame.getContentPane().add(labcorveiform);
		
		veicor = new JTextArea();
		veicor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		veicor.setBounds(1295, 220, 150, 35);
		frame.getContentPane().add(veicor);
		
// linha ACESSÓRIOS NO VEÍCULO linha ACESSÓRIOS NO VEÍCULO linha ACESSÓRIOS NO VEÍCULO
		JLabel labasvei = new JLabel("Acessórios");
		labasvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labasvei.setBounds(43, 277, 150, 35);
		frame.getContentPane().add(labasvei);
		
		comboBoxace = new JComboBox();
		comboBoxace.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxace.setEditable(true);
		comboBoxace.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBoxace.setBounds(213, 277, 514, 35);
		frame.getContentPane().add(comboBoxace);
		comboBoxace.setSelectedItem("Lista de acessório");
		
// linha CLIENTES INTERESSADOS linha CLIENTES INTERESSADOS linha CLIENTES INTERESSADOS
		JLabel labclivei = new JLabel("Clientes");
		labclivei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labclivei.setBounds(787, 278, 150, 35);
		frame.getContentPane().add(labclivei);
		
		comboBoxcli = new JComboBox();
		comboBoxcli.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxcli.setEditable(true);
		comboBoxcli.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBoxcli.setBounds(931, 278, 514, 35);
		frame.getContentPane().add(comboBoxcli);
		comboBoxcli.setSelectedItem("Clientes que visitarm");

// linha MAIS SOBRE O VEÍCULO linha MAIS SOBRE O VEÍCULO linha MAIS SOBRE O VEÍCULO
		JLabel labmaisvei = new JLabel("Mais sobre o Veículo");
		labmaisvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labmaisvei.setBounds(43, 324, 262, 35);
		frame.getContentPane().add(labmaisvei);
		
		veimais = new JTextArea();
		veimais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veimais.setBounds(45, 361, 1400, 99);
		frame.getContentPane().add(veimais);
						
// linha BOTÃO SALVAR linha BOTÃO SALVAR linha BOTÃO SALVAR	 linha BOTÃO SALVAR	
		JButton btnclisalvar = new JButton("Salvar");
		btnclisalvar.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnclisalvar.setBounds(293, 599, 223, 53);
		frame.getContentPane().add(btnclisalvar);
		btnclisalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = veicod.getText();
				String nome = veinome.getText();
				String ano = veiano.getText();
				String mod = veimod.getText();
				String marca = veimarca.getText();
				String condicao = veicondicao.getText();
				String placa = veiplaca.getText();
				String km = veikm.getText();
				String combustivel = veicombustivel.getText();
				String cambio = veicambio.getText();
				String carroc = veicarroc.getText();
				String cor = veicor.getText();
				String mais = veimais.getText();
				btnsalvar(id, nome, ano, mod, marca, condicao, placa, km, combustivel, cambio, carroc, cor, mais);
				convei tel = new convei();
				tel.visivel();
				frame.dispose();
				}
			});
			
// linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR
		JButton btnveiExcluir = new JButton("Excluir");
		btnveiExcluir.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnveiExcluir.setBounds(631, 599, 223, 53);
		frame.getContentPane().add(btnveiExcluir);
		btnclisalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				String id = veicod.getText();
				btnexcluir(id);
				convei tel = new convei();
				tel.visivel();
				frame.dispose();
			}
		});
				
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
		btnclivoltar.setBounds(949, 599, 223, 53);
		frame.getContentPane().add(btnclivoltar);
		
	}
		
/*// linha GALERIA linha GALERIA linha GALERIA linha GALERIA linha GALERIA linha GALERIA
		JLabel labgalvei = new JLabel("Galeria");
		labgalvei.setFont(new Font("Tahoma", Font.BOLD, 36));
		labgalvei.setBounds(88, 486, 150, 35);
		frame.getContentPane().add(labgalvei);
		
		JTextArea maisvei_1 = new JTextArea();
		maisvei_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		maisvei_1.setBounds(276, 471, 1169, 114);
		frame.getContentPane().add(maisvei_1);
		
// linha BOTÃO EDITAR GALERIA linha BOTÃO EDITAR GALERIA linha BOTÃO EDITAR GALERIA
		JButton btngalvei = new JButton("Editar");
		btnclivoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conini tel = new conini();
				tel.visivel();
				frame.dispose();
			}
		});btngalvei.setFont(new Font("Tahoma", Font.BOLD, 36));
		btngalvei.setBounds(43, 532, 223, 53);
		frame.getContentPane().add(btngalvei);
	}
*/
	
	
// buscar veículo buscar veículo buscar veículo buscar veículo buscar veículo buscar veículo
	public void atualizarInformacoes(String id) {
		try {
			String query = "Select vei_nome,vei_ano,vei_mod,vei_marca,"
				+ "vei_condicao,vei_placa,vei_km,vei_combustivel,"
				+ "vei_cambio,vei_carroc,vei_cor,vei_descricao"
				+ " from Veiculo where vei_id = '"+id+"'";
			this.resultset2 = this.statement2.executeQuery(query);
			while (this.resultset2.next()) {
				String nome = this.resultset2.getString("vei_nome");
				veinome.setText(nome);
				String ano =this.resultset2.getString("vei_ano");
				veiano.setText(ano);
				String mod = this.resultset2.getString("vei_mod");
				veimod.setText(mod);
				String marca = this.resultset2.getString("vei_marca");
				veimarca.setText(marca);
				String condicao = this.resultset2.getString("vei_condicao");
				veicondicao.setText(condicao);				
				String placa = this.resultset2.getString("vei_placa");
				veiplaca.setText(placa);
				String km = this.resultset2.getString("vei_km");
				veikm.setText(km);
				String combustivel = this.resultset2.getString("vei_combustivel");
				veicombustivel.setText(combustivel);
				String cambio = this.resultset2.getString("vei_cambio");
				veicambio.setText(cambio);
				String carroc = this.resultset2.getString("vei_carroc");
				veicarroc.setText(carroc);
				String cor = this.resultset2.getString("vei_cor");
				veicor.setText(cor);
				String descricao =this.resultset2.getString("vei_descricao");
				veimais.setText(descricao);
				}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}

// buscar acessórios buscar acessórios buscar acessórios buscar acessórios buscar acessórios buscar acessórios
	public void atualizarInformacoes1(String id) {
		try {
			comboBoxace.removeAllItems();
			String query = "Select veiace_id from veiace where left(veiace_id, 4) = '"+id+"'";
			this.resultset = this.statement.executeQuery(query);
			// percorrendo registro veiace
			while (this.resultset.next()) {
				// obtendo chave
				String veiaceid = this.resultset.getString("veiace_id");
			
				// Dividindo a chave "veiace_id" em dois grupos de 4 dígitos
				String grupo1 = veiaceid.substring(0, 4); // Primeiro grupo (vei_id)
				String grupo2 = veiaceid.substring(4); // Segundo grupo (ace_id)

				// buscando veículo relacionado
				String ace_id = grupo2;
				String queryvei = "Select ace_nome from Acessorios where ace_id ='" + ace_id + "'";
				this.resultset3 = this.statement3.executeQuery(queryvei);
				
				while (this.resultset3.next()) {
					String aceNome = this.resultset3.getString("ace_nome");
					comboBoxace.addItem(ace_id + "  " + aceNome);
					}
				}	
			} catch (Exception e) {
				System.out.println("ERROR: " + e.getMessage());
			}
		}

// buscar clientes interessados buscar clientes interessados buscar clientes interessados buscar clientes interessados
	public void atualizarInformacoes2(String id) {
		try {
			comboBoxcli.removeAllItems();
			String query = "Select clivei_id from clivei where right(clivei_id, 4) = '"+id+"'";
			this.resultset1 = this.statement1.executeQuery(query);
			// percorrendo registro veiace
			while (this.resultset1.next()) {
				// obtendo chave
				String cliveiid = this.resultset1.getString("clivei_id");
			
				// Dividindo a chave "veiace_id" em dois grupos de 4 dígitos
				String grupo1a = cliveiid.substring(0, 4); // Primeiro grupo (cli_id)
				String grupo2a = cliveiid.substring(4); // Segundo grupo (vei_id)

				// buscando veículo relacionado
				String cli_id = grupo1a;
				String queryvei = "Select cli_nome, cli_whats from Cliente where cli_id ='" + cli_id + "'";
				this.resultset4 = this.statement4.executeQuery(queryvei);
				
				while (this.resultset4.next()) {
					String cliNome = this.resultset4.getString("cli_nome");
					String cliWhats = this.resultset4.getString("cli_whats");
					// Salva na lista código
					// codigo.add(vei_id + " " + veiNome);
					comboBoxcli.addItem(cli_id + "  " + cliWhats + "  " + cliNome);
					}
				}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
// cadastrar ou aterar veículo cadastrar ou aterar veículo cadastrar ou aterar veículo cadastrar ou aterar veículo	
	public void btnsalvar(String id, String nome, String ano, String mod, String marca, String condicao, String placa, String km, String combustivel, String cambio, String carroc, String cor, String mais) {
		try {
			String query = "Select vei_id from Veiculo where vei_id = '"+id+"'";
			this.resultset = this.statement.executeQuery(query);

			if (resultset.next()) {
				String queryupvei = "update Veiculo set vei_nome = '"+nome+"', vei_ano = '"+ano+"', vei_mod = '"+mod+"', vei_marca = '"+marca+"', vei_condicao = '"+condicao+"', vei_placa = '"+placa+"', vei_km = '"+km+"', vei_combustivel = '"+combustivel+"', vei_cambio = '"+cambio+"', vei_carroc = '"+carroc+"', vei_cor = '"+cor+"', vei_descricao = '"+mais+"' where vei_id = '"+id+"'";
				this.statement.executeUpdate(queryupvei);
			}else {	
				String queryinsertvei = "insert into Veiculo(vei_id,vei_nome,vei_ano,vei_mod,vei_marca,vei_condicao,vei_placa,vei_km,vei_combustivel,vei_cambio,vei_carroc,vei_cor,vei_descricao) values ('"+nome+"','"+ano+"','"+mod+"','"+marca+"','"+condicao+"','"+placa+"','"+km+"','"+combustivel+"','"+cambio+"','"+carroc+"','"+cor+"','"+mais+"','"+id+"')";
				this.statement.executeUpdate(queryinsertvei);
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		//return false;
	}
	
// Apagar veículo Apagar veículo Apagar veículo Apagar veículo Apagar veículo Apagar veículo Apagar veículo
	public void btnexcluir(String id) {
		try {
			String queryveic = "delete from Veiculo where vei_id = '"+id+"'";
			this.statement2.executeUpdate(queryveic);
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
			}
		try { 
			String queryacevei = "delete from convei where right(convei_id, 4) = '" + id + "'";
			this.statement3.executeUpdate(queryacevei);	
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
		try { 
			String queryclivei = "delete from clivei where right(clivei_id, 4) = '" + id + "'";
			this.statement4.executeUpdate(queryclivei);	
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
		try { 
			String queryveiace2 = "delete from veiace where left(convei_id, 4) = '" + id + "'";
			this.statement.executeUpdate(queryveiace2);	
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
		}
	}
