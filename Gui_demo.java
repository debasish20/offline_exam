package input2;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;


import java.awt.EventQueue;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Gui_demo {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_demo window = new Gui_demo();
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
	public Gui_demo() {
		initialize();
	}

	
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(152, 251, 152));
		frame.getContentPane().setForeground(Color.CYAN);
		frame.setBounds(100, 100, 662, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Gui_input ob=new Gui_input();
		Gui_student ob2=new Gui_student();
		
		
		JButton btnNewButton = new JButton("TEACHER");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ob.input_take();		
			}
			
		});
		btnNewButton.setBounds(248, 235, 157, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("STUDENT");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ob2.student_disp();
			
			}
		});
		btnNewButton_1.setBounds(248, 298, 157, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Enter your choice");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(113, 144, 404, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME TO DEBASISH'S  EXAM SYSTEM");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(63, 36, 499, 53);
		frame.getContentPane().add(lblNewLabel_1);
		
		
	}
}
