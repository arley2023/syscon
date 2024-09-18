package Concessionaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
// cria array
	ArrayList<String> codigo = new ArrayList<>();

// armazena a conexão
	private Connection connection = null;

// armazena as consultas
	private Statement statement = null;
	private Statement statement1 = null;
	private Statement statement2 = null;
	private Statement statement3 = null;
	private Statement statement4 = null;
	private Statement statement5 = null;

// armazena os resultados
	private ResultSet resultset = null;
	private ResultSet resultset1 = null;
	private ResultSet resultset2 = null;
	private ResultSet resultset3 = null;
	private ResultSet resultset4 = null;
	private ResultSet resultset5 = null;

// cria a comboBox	
	JComboBox comboBox;

	public void conectar() {

// caminho
		String servidor = "jdbc:mysql://localhost:3306/Concessionaria";

// usuario
		String usuario = "root";

// senha
		String senha = "arley911";

// local driver instalado
		String driver = "com.mysql.cj.jdbc.Driver";
		try {

// acessa o driver
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);

// consultas
			this.statement = this.connection.createStatement();
			this.statement2 = this.connection.createStatement();
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

	private JFormattedTextField ascod;
	private JFormattedTextField veiin;
	private JFormattedTextField veiout;
	private JTextArea acenome;
	private JTextField ascod2;
	private JTextField veiin2;
	private JTextField veiout2;

// lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO	
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

// cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO
	public conas() {
		initialize();
	}

// deixa a JANELA VISIVEL QUANDO CHAMADA deixa a JANELA VISIVEL QUANDO CHAMADA
	public void visivel() {
		conas windows = new conas();
		windows.frame.setVisible(true);
	}

// inicia a JANELA inicia a JANELA inicia a JANELA inicia a JANELA
	private void initialize() {
		conectar();
		frame = new JFrame();
		frame.setBounds(100, 100, 1011, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

// MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS
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

// label janela ACESSÓRIOS SYSCON label janela ACESSÓRIOS SYSCON label janela ACESSÓRIOS SYSCON
		JLabel labcli = new JLabel("Acessórios");
		labcli.setFont(new Font("Tahoma", Font.BOLD, 50));
		labcli.setBounds(45, 33, 293, 61);
		frame.getContentPane().add(labcli);

		JLabel lablogo = new JLabel("SysCon");
		lablogo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lablogo.setBounds(758, 33, 183, 61);
		frame.getContentPane().add(lablogo);

// linha CÓDIGO DO ACESSÓRIO linha CÓDIGO DO ACESSÓRIO linha CÓDIGO DO ACESSÓRIO
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

// linha NOME ACESSÓRIO linha NOME ACESSÓRIO linha NOME ACESSÓRIO linha NOME ACESSÓRIO
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

// linha de VEÍCULOS COM O ACESSÓRIO linha de VEÍCULOS COM O ACESSÓRIO
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
		
// linha ADICIONAR VEÍCULOS linha ADICIONAR VEÍCULOS linha ADICIONAR VEÍCULOS	
		JLabel labadveias = new JLabel("Adicionar Veículo");
		labadveias.setFont(new Font("Tahoma", Font.BOLD, 24));
		labadveias.setBounds(42, 280, 230, 35);
		frame.getContentPane().add(labadveias);

		JLabel labadveiasform = new JLabel("formato 9999");
		labadveiasform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labadveiasform.setBounds(42, 305, 150, 28);
		frame.getContentPane().add(labadveiasform);

		// veiin = new JTextArea();
		veiin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		veiin.setBounds(260, 291, 150, 35);
		frame.getContentPane().add(veiin);
		
// linha EXCLUIR VEÍCULOS linha ADICIONAR VEÍCULOS linha EXCLUIR VEÍCULOS	
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

// linha BOTÃO SALVAR linha BOTÃO SALVAR linha BOTÃO SALVAR	 linha BOTÃO SALVAR	
		JButton btnassalvar = new JButton("Salvar");
		btnassalvar.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnassalvar.setBounds(45, 367, 223, 53);
		frame.getContentPane().add(btnassalvar);
		btnassalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ascod2 = ascod.getText();
				String veiin2 = veiin.getText();
				String veiout2 = veiout.getText();
				botaosalvar(veiin2, veiout2, ascod2);
			}
		});
		
// linha BOTÃO EXCLUIR ACESSÓRIO linha BOTÃO EXCLUIR ACESSÓRIO linha BOTÃO EXCLUIR ACESSÓRIO
		JButton btnasexcluir = new JButton("Excluir");
		btnasexcluir.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnasexcluir.setBounds(383, 367, 223, 53);
		frame.getContentPane().add(btnasexcluir);
		btnasexcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent i) {
				String ascod2 = ascod.getText();
				botaoexcluir(ascod2);
				}
			});
			public void actionPerformed(ActionEvent m) {
				conini tel = new conini();
				tel.visivel();
				frame.dispose();
			};
		
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
	
// inicio ação botao salvar inicio ação botao salvar inicio ação botao salvar inicio ação botao salvar inicio ação botao salvar
		
// AÇÕES BOTÃO SALVAR AÇÕES BOTÃO SALVAR AÇÕES BOTÃO SALVAR AÇÕES BOTÃO SALVAR AÇÕES BOTÃO SALVAR	
	public void botaosalvar(String ascod2, String veiin2, String veiout2) {
		
// salvar alterações de acessorios
		if (ascod2.getText() != null && ascod2.getText() !=0) {
			String queryupaces = "update acessorio set ace_nome = '"+acenome+"' where ace_id = '"+ascod2+"'";
			this.statement.executeUpdate(queryupaces);	
		};

// incluir veiculo na ligação		
		if (veiin2.getText() != null && veiin2.getText() != 0) {
			String queryVeiin = "Select vei_id from veiculo where vei_id = "+veiin2+"";
		    this.resultset1 = this.statement1.executeQuery(queryVeiin);
		    if (this.resultset1.next()) {
		    	chaveace = veiin2 + ascod2;
		    	String querychacesexiste = "Select ace_id from ligacao where ace_id = "+chaveace+"";
			    this.resultset2 = this.statement2.executeQuery(querychacesexiste);
			    if (this.resultset2.next()) {
			    	break;
			    }else {
			    	String queryinlig = "insert into acessorio (as_id) values '"+chaveace+"'";
			    	this.statement3.executeUpdate(queryinlig);
			    }
		    }
		}
		
// excluir veiculo da ligação
		if (veiout2.getText() != null && veiout2.getText() != 0) {
			String queryVeiin = "Select vei_id from veiculo where vei_id = "+veiout2+"";
		    this.resultset3 = this.statement4.executeQuery(queryVeiin);
		    if (this.resultset3.next()) {
		    	chaveace2 = veiout2 + ascod2;
		    	String querychacesexiste = "Select ace_id from ligacao where ace_id = "+chaveace2+"";
			    this.resultset4 = this.statement5.executeQuery(querychacesexiste);
			    if (this.resultset4.next()) {
			    	break;
			    }else {
			    	String queryinlig = "delete into acessorio (as_id) values '"+chaveace2+"'";
			    	this.statement6.executeUpdate(queryinlig);
			    }
		    }
		}
	}
	
// fim ação botao salvar fim ação botao salvar fim ação botao salvar fim ação botao salvar fim ação botao salvar
		    	

	
// inicio ação botao excluir inicio ação botao excluir inicio ação botao excluir inicio ação botao excluir

// AÇÕES BOTÃO EXCLUIR AÇÕES BOTÃO EXCLUIR AÇÕES BOTÃO EXCLUIR AÇÕES BOTÃO EXCLUIR AÇÕES BOTÃO EXCLUIR	
	public void botaoexcluir(String ascod2) {
			
// verificar se acessorio existe e começar outra public void
	if (ascod2.getText() != null && ascod2.getText() !=0) {
		String queryaceexiste = "Select ace_id from veiculo where ace_id = "+ascod2+"";
	    this.resultset = this.statement.executeQuery(queryaceexiste);
	    if (this.resultset.next()) {
	    	String queryexcace = "delete ace_id from acessorio where ace_id ='"+ascod2+"'";
			this.statement1.executeUpdate(queryexcace);
			verificaligacao(ascod2);			
	    }else {
	    	break;
	    }
	}
	
// verifica veiculos que tem o acessorio e apaga dos registros veiace
	public void verificaligacao(String ascod2) {
		try {
			String queryVeiAce2 = "Select veiace_id from acessorios where RIGHT(veiace_id, 4) = '" + id + "'";
			this.resultset3 = this.statement3.executeQuery(queryVeiAce);
			// Percorrendo todos os registros no banco de dados "ligacao"
			while (this.resultset3.next()) {
				// Obtendo a chave "veiace_id"
				String veiaceid = this.resultset3.getString("veiace_id");

				// Dividindo a chave "veiace_id" em dois grupos de 4 dígitos
				String grupo1 = veiaceid.substring(0, 4); // Primeiro grupo (vei_id)
				String grupo2 = veiaceid.substring(4); // Segundo grupo (ace_id)

				if(ascod2 = grupo2) {
					String queryapagar = "delete ace_id from acessorios where ace_id ='"+id+"'";
					this.statement5.executeUpdate(queryapagar);
				};
			} catch (Exception n) {
				System.out.println("ERROR: " + n.getMessage());
			}
		}
	}
		
		/*
				String queryupaces = "update acessorio set ace_nome = '"+acenome+"' where ace_id = '"+ascod2+"'";
				this.statement.executeUpdate(queryupaces);	
			};

			
			
			
			
		    	consultar veiace se existe
		    	
salvar veiace
			
				if (veiout.getText() != null && veiou.getText() != 0) {
					break;
				}
			}else {
	
	String queryveicexiste = "Select ace_id from acessorios where ace_id = "+ascod+"";
		if (this.resultset.next()) {
			
			// Passo 1 - Conferir se 'veiin' tem algum valor e se é diferente de 0 ou null
			
		    	
		// Começo do LOOP
	// Se o veiculo existe		
		    		int chave1 = Integer.parseInt(vei_id+ace_id);
		    		String queryacevei = "Select veiace_id from veiace where veiace_id = "+chave1+"";
				    		this.resultset2 = this.statement.executeQuery(queryacevei);
				    		if (this.resultset2.next()) {
				    		}else {
				    			String query = "insert into veiace (veiace_id) values('" +chave1+ "')";
				    			this.statement.executeUpdate(query);
				    		}
				    	}else {
				    		// passo 2 - Conferir se 'veiout' tem algum valor e se é diferente de 0 ou null
						    if (veiout.getText() != null && veiout.getText() != 0) {
						    	break;
						    }else {
						    	String queryVeiout = "Select vei_id from veiculo where vei_id = "+veiout+"";
						    	this.resultset = this.statement.executeQuery(queryVeiout);
						    	if (this.resultset.next()) {
						    		int chave2 = Integer.parseInt(vei_id+ace_id);
						    		String queryacevei1 = "Select veiace_id from veiace where veiace_id = "+chave2+"";
						    		this.resultset = this.statement.executeQuery(queryacevei1);
						    		if (this.resultset2.next()) {
						    			String querya = "delete into veiace (veiace_id) values('" +chave2+ "')";
						    			this.statement.executeUpdate(querya);
				    	}
					
				
// **************************		/
			/*			    		
				}else {
					public void actionPerformed(ActionEvent e) {
					conini tel = new conini();
					tel.visivel();
					frame.dispose();
					}
					
					
				
				// Passo 1 - Conferir se 'veiin' tem algum valor e se é diferente de 0 ou null
				if (veiin.getText() != null && veiin.getText() != 0) {
			    	break;
			    }else {
			    	String queryVeiin = "Select vei_id from veiculo where vei_id = "+veiin+"";
			    	this.resultset = this.statement.executeQuery(queryVeiin);
			    	if (this.resultset.next()) {
			    		int chave1 = Integer.parseInt(vei_id+ace_id);
			    		String queryacevei = "Select veiace_id from veiace where veiace_id = "+chave1+"";
			    		this.resultset2 = this.statement.executeQuery(queryacevei);
			    		if (this.resultset2.next()) {
			    			break;
			    		}else {
			    			String query = "insert into veiace (veiace_id) values('" +chave1+ "')";
			    			this.statement.executeUpdate(query);
			    		}
			    	}
			    	
			    	  // passo 2 - Conferir se 'veiout' tem algum valor e se é diferente de 0 ou null
				    if (veiout.getText() != null && veiout.getText() != 0) {
				    	break;
				    }else {
				    	String queryVeiout = "Select vei_id from veiculo where vei_id = "+veiout+"";
				    	this.resultset = this.statement.executeQuery(queryVeiout);
				    	if (this.resultset.next()) {
				    		int chave2 = Integer.parseInt(vei_id+ace_id);
				    		String queryacevei1 = "Select veiace_id from veiace where veiace_id = "+chave2+"";
				    		this.resultset = this.statement.executeQuery(queryacevei1);
				    		if (this.resultset2.next()) {
				    			String querya = "delete into veiace (veiace_id) values('" +chave2+ "')";
				    			this.statement.executeUpdate(querya);
				    		}
				    	}
				    }
			    }
			    
				
				*/
				
			
				
						

// fim ação botao excluir fim ação botao excluir fim ação botao excluir fim ação botao excluir	

						    		
// inicio comboBox veiculos com acessorios inicio comboBox veiculos com acessorios
// parte 1		
// 1 - Consultando o banco de dados	ACESSORIOS
	public void atualizarInformacoes(String id) {
		// codigo.clear();
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

// parte 2 consultar tabela mysql VEIACE 
// Consultando o banco de dados "veiace" para obter o "veiace_id" e inserir na ArrayList
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

				String vei_id = grupo1;
				String queryvei = "Select vei_nome from veiculo where vei_id ='" + vei_id + "'";
				// String queryvei = "Select veiace_id from veiace where RIGHT(veiace_id, 4) =
				// '"+vei_id+"'";

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
// fim comboBox veiculos com acessorios fim comboBox veiculos com acessorios
}
