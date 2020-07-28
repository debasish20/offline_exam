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

public class Gui_input {

	private JFrame frame;
	public static String ps;
	private JPasswordField passwordField;
    public static int time;
    public static JTextField textField_1;
	/**
	 * Launch the application.
	 */
	//dbms
	
	
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
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.getContentPane().setForeground(Color.CYAN);
		frame.setBounds(100, 100, 600, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(249, 37, 177, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("create password");
		lblNewLabel.setBounds(94, 40, 153, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ps=passwordField.getText();
			//System.out.println(ps);
		
			JOptionPane.showMessageDialog(null,"Data Saved");
								
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
		
		JLabel lblNewLabel_1 = new JLabel("enter time limit in minutes");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(26, 191, 191, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(251, 188, 96, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
		
		
	}
	
}

