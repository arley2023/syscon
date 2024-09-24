package Concessionaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class conini {
	private JFrame frame;
	private Connection connection = null;
	private Statement statement = null;
	public void conectar() {
		String servidor="jdbc:mysql://localhost:3306/cadastro";
		String usuario = "root";
		String senha = "Aluno";
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor,usuario,senha);
			this.statement = this.connection.createStatement();
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conini window = new conini();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public conini() {
		initialize();
	}
	public void visivel() {
		conini window = new conini();
		window.frame.setVisible(true);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 883, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel label999 = new JLabel("SysCon");
		label999.setFont(new Font("Tahoma", Font.BOLD, 50));
		label999.setBounds(345, 31, 183, 61);
		frame.getContentPane().add(label999);
		JButton btncli = new JButton("Cliente");
		btncli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				concli tel = new concli();
				tel.visivel();
				frame.dispose();
			}
		});
		btncli.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btncli.setBounds(114, 168, 219, 70);
		JButton btnvei = new JButton("Veiculos");
		btnvei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convei tel = new convei();
				tel.visivel();
				frame.dispose();
			}
		});
		btnvei.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnvei.setBounds(541, 168, 219, 70);
		JButton btnCon = new JButton("Consultor");
		btnCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				concon tel = new concon();
				tel.visivel();
				frame.dispose();
			}
		});
		btnCon.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnCon.setBounds(541, 317, 219, 70);
		JButton btnas = new JButton("Acessorios");
		btnas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conas tel = new conas();
				tel.visivel();
				frame.dispose();
			}
		});
		btnas.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnas.setBounds(114, 317, 219, 70);
		frame.getContentPane().add(btnas);
	}
}
