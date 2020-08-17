package input2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.BufferedReader;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.sql.*;
import java.io.*;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
public class Gui_student{

	public JFrame frame;
	public JTextField textField_1;
	private JTextField textField_2;
	public static String pass;
	public static String an1;
	private JPasswordField passwordField;
	public static String q="";
	public static int ctr=0;
	public static String subCode;
	public static String roll;
	
	/**
	 * Launch the application.
	 */
	
	//for jdbc
	private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:B:\\java\\DataBase\\stu_answers.db";
        Connection conn1 = null;
        try {
            conn1 = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("not found");
        }
            
        return conn1;
    }

	public void student_disp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_student window = new Gui_student();
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
	public Gui_student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	public void initialize() {
		
 		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(127, 255, 212));
		frame.getContentPane().setForeground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 736, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("enter password");
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setBounds(151, 57, 103, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(317, 134, 96, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(317, 183, 96, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(318, 54, 95, 20);
		frame.getContentPane().add(passwordField);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("enter roll no.");
		lblNewLabel_1.setBounds(151, 137, 124, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("YES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gui_student ob=new Gui_student();
				
				subCode=textField_2.getText();
				roll=textField_1.getText();
				pass=passwordField.getText();
				ob.getQuest(subCode,pass,roll);
												
			}			
		});
		btnNewButton.setBounds(186, 327, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("NO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(337, 327, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Do you want to take the quiz ?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(168, 265, 268, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("enter subject code");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(76, 182, 212, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		
	}
	
	//setting answers
	
	public void insert(String subCode, String roll, String an) {
		
		
		String sql = "INSERT INTO students(subCode, roll, answer) VALUES(?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, subCode);
            pstmt.setString(2, roll);
            pstmt.setString(3, an);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.exit(0);
	    }
    
	
	//getting questions
	
	public void getQuest(String subCode, String pass1, String roll){
		String sql1 = "SELECT password "
	               + "FROM teachers WHERE subCode = ?";
		
	    String sql = "SELECT questions "
	               + "FROM questions WHERE subCode = ?";
	    
	    Gui_input ob3=new Gui_input();
	    Scanner sc=new Scanner(System.in);
	    int t=2;
	   
	    System.out.println("Your test has started at "+LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute()+":"+LocalDateTime.now().getSecond());
	    
	       
	    try {
			Connection conn = this.connect();
			  PreparedStatement pstmt1  = conn.prepareStatement(sql1);
			  
			// set the value
				 pstmt1.setString(1,subCode);
				 //
				 ResultSet rs1  = pstmt1.executeQuery();
				 
				 // loop through the result set
				 while (rs1.next()) {
				    String pass= rs1.getString("password");
				 } 
			  
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	if(pass.equals(pass1))
	{

	try (Connection conn = this.connect();
	  PreparedStatement pstmt  = conn.prepareStatement(sql)){
	 
	 // set the value
	 pstmt.setString(1,subCode);
	 //
	 ResultSet rs  = pstmt.executeQuery();
	 
	 
	 int i=0;
	// System.out.println("\n Enter the answers for the following questions:\n You have "+t+" mins to take the test\n");
	 //System.out.println("!!! All the best !!!\n ");
	 // loop through the result set
	 while (rs.next()) {
		 q=rs.getString("questions");
	     i++;
	    break;
	 }	 
	 
	// System.out.println("\n    THANK YOU FOR ATTEMPTING THIS QUIZ  \n");
	
	 //System.out.println(ans);
	} catch (SQLException e) {
	 System.out.println(e.getMessage());
	}
	Gui_student ob1=new Gui_student();
	questAns ob2=new questAns();
	
	ob2.quest();	
	String an = null;
	//an=questAns.ans;	
	System.out.println(an);
	//ob1.insert(subCode, roll, an);
	}
	
	else
	{
		JOptionPane.showMessageDialog(null,"Wrong Password");
	}
	
}
}
