package input2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class Gui_input {

	private JFrame frame;
	public static String ps;
	private JPasswordField passwordField;
    public static int time;
    public static JTextField textField_1;
    private JTextField textField;
	/**
	 * Launch the application.
	 */
	//dbms
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:B:\\java\\DataBase\\stu_answers.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("not found");
        }
            System.out.println("connection made");
        
        return conn;
    }

	
	public void input_take() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_input window = new Gui_input();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui_input() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(){
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 240));
		frame.getContentPane().setForeground(new Color(70, 130, 180));
		frame.setBounds(100, 100, 600, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(249, 89, 177, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("create password*");
		lblNewLabel.setBounds(94, 92, 153, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(249, 136, 177, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		

		textField_1 = new JTextField();
		textField_1.setBounds(251, 235, 96, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
			JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"NOT SELECTED", "MCQ", "SUBJECTIVE"}));
		comboBox.setBounds(249, 187, 159, 22);
		frame.getContentPane().add(comboBox);
		
			
			
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ps=passwordField.getText();
			//System.out.println(ps);
			String subCode=textField.getText();
			String testType=(String) comboBox.getSelectedItem();
			time=Integer.parseInt(textField_1.getText());
			
			//location of question
			String s="B:\\java\\sample1.txt ";
			String s1="";
			int l=s.length();
			int i=0;
			char ch;
			//questions reader
			for(i=0;i<l;i++) {
				ch=s.charAt(i);
				if(ch=='"')
				{
					break;
				}
				else
					s1+=ch;
			}	
			File file1 = new File(s1);					
			 
			//object create
			Gui_input obj=new Gui_input();
			
			  BufferedReader br1 = null;
			try {
				br1 = new BufferedReader(new FileReader(file1));
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
		
			JOptionPane.showMessageDialog(null,"Data Saved");
			String st;
			String quest="";
			try {
				while (((st = br1.readLine()) != null))
				{
					 quest +=st+"\n";
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			obj.insert(subCode, testType, ps);
			obj.insert2(subCode, quest);
			
			//System.out.println(time);
			//System.out.println(testType);
			
			
			}
			});
		btnNewButton.setBounds(172, 289, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			input_take();
			}
		});
		btnNewButton_1.setBounds(319, 289, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("enter time limit in minutes*");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(30, 238, 191, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("enter subject code*");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(68, 139, 153, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("exam type*");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(94, 191, 96, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Note : The items with '*' are compulsory");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(172, 30, 254, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		
		
		
	}
	public void insert(String subCode,String type,String password) {
		
        String sql = "INSERT INTO teachers(subCode, type, password, time) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, subCode);
            pstmt.setString(2, type);
            pstmt.setString(3, password);
            pstmt.setInt(4, time);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
public void insert2(String subCode, String questions) {
		
        String sql = "INSERT INTO questions(subCode, questions) VALUES(?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, subCode);
            pstmt.setString(2, questions);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

