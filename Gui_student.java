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
public class Gui_student {

	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	private JTextField textField_2;

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
	 */
	private void initialize() {
		
 		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.getContentPane().setForeground(Color.PINK);
		frame.setBounds(100, 100, 620, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(317, 79, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("enter password");
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setBounds(151, 82, 103, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(317, 134, 96, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(317, 183, 96, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		String subCode=textField_2.getText();
		
		JLabel lblNewLabel_1 = new JLabel("enter roll no.");
		lblNewLabel_1.setBounds(151, 137, 124, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("YES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] q1=new String[10];
			     String[] an=new String[10]; 
			     String loc=textField_1.getText();
			     
	        		
				String ps1=textField.getText();
				if(!ps1.equals(Gui_input.ps))
				{
					JOptionPane.showMessageDialog(null,"Wrong Password");
					
				}
				
				 	
					int	t =Integer.parseInt(Gui_input.textField_1.getText());
					
				 	System.out.println(t);
							    
				    LocalTime time=java.time.LocalTime.now();
				    int h=time.getHour();
				      
				      int i=0;
				     
				      Scanner sc=new Scanner(System.in);
				      File file = new File(loc+".txt");
				        try {
							file.createNewFile();
						} catch (IOException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
				        FileWriter writer = null;
						try {
							writer = new FileWriter(file);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

				        
				      
			 if(ps1.equals(Gui_input.ps)) {
				 
				    int m1=time.getMinute();
				    int m=time.getMinute();
				    System.out.println("Your test has started at "+LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute()+":"+LocalDateTime.now().getSecond());
				    
					File file1 = new File("C:\\sample.txt ");					
					  
					
					  BufferedReader br1 = null;
					try {
						br1 = new BufferedReader(new FileReader(file1));
					} catch (FileNotFoundException e1) {
						
						e1.printStackTrace();
					}
					
					System.out.println("Enter the answers for the respective questions:");
					  
					  String st; 
					  try {
						writer.write("The answers given by the student are displayed below:\n\n\n");
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					  System.out.println("\n You have "+ t +" min(s) to take the test \n");
					  
					  //object for jdbc
					  Gui_student ob=new Gui_student();
					  String ans="";
					  
					  try {
						while (((st = br1.readLine()) != null))
						  {  
												
							  System.out.println(st);
							  an[i]=sc.nextLine();
							  ans=ans+"\n"+an[i];
							  writer.write("("+(i+1)+")  "+ an[i]+"\n\n");	
							  i++;
							  m=LocalDateTime.now().getMinute();
							  if(m==59) {
								  m=0;
								  m1=0;
							  }
							  if(m==(m1+t))
							  {
								  
							      System.out.println("\n SORRY!!!! TIMES OUT !!! \n");
							      System.exit(0);
								  break;
							  }
							    
							 
							   
						  }
						ob.insert(subCode, loc, ans);
						writer.flush();
				        writer.close();
						int j=i;
						i=0;
						
						System.out.println("\n\n Your answers are: \n");
						for(i=0;i<j;i++)
						{
							System.out.println(an[i]);
						}
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}				          
					  
				    }
			     
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
	
	public void insert(String subCode, String roll, String ans) {
		Gui_input ob=new Gui_input();
		
		String sql = "INSERT INTO students(subCode, roll, answer) VALUES(?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, subCode);
            pstmt.setString(2, roll);
            pstmt.setString(3, ans);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
