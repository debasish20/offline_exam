package input2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

public class questAns extends Gui_student {

	//public static String ans;
	private JFrame frame;
	private JTextField textField;
	public static String ans;
	
	/**
	 * Launch the application.
	 */
	public void quest() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					questAns window = new questAns();
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
	public questAns() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		frame.setBounds(100, 100, 1297, 758);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		 textPane.setBounds(39, 323, 1076, 346);
		 frame.getContentPane().add(textPane);
		 
	
		// while(ctr!=1)
		 
		 
		 
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//System.out.println(ans);
				an1=textPane.getText();
				Gui_student ob1=new Gui_student();
				ob1.insert(subCode, roll, an1);
				System.out.println(an1);
				ctr=1;
				//System.exit(0);
			}
		});
		
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(255, 160, 122));
		btnNewButton_1.setBounds(1125, 446, 137, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(new Color(211, 211, 211));
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPane_1.setBounds(29, 77, 1119, 141);
		frame.getContentPane().add(textPane_1);
		
				
		Gui_student ob=new Gui_student();
		String q11=Gui_student.q;
		
		 LocalTime time=java.time.LocalTime.now();
		    int m1=time.getMinute();
		    int m=time.getMinute();
		
		    int t=2;
		    
		   
		 String q1="";
		 int len=q11.length();
		 int i;
		 for(i=0;i<len;i++)
		 {
			 char ch=q11.charAt(i);
			 if(ch=='\n')
			 {
				q1=q1+"\n";
			 }
			 else
			 {
				 q1=q1+ch;		 
		 
			 }
			 m=LocalDateTime.now().getMinute();
			  if(m==59) {
				  m=0;
				  m1=0;
			  }
			  
			if(m==(m1+t))
			  {
				  
				JOptionPane.showMessageDialog(null,"Sorry your times up");
			      //System.exit(0);
				  break;
			  }
			  
		 }
		 
		 
		 textPane_1.setText(q1);
		 
		 textField = new JTextField();
		 textField.setForeground(new Color(128, 0, 128));
		 textField.setHorizontalAlignment(SwingConstants.CENTER);
		 textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		 textField.setBackground(new Color(175, 238, 238));
		 textField.setBounds(29, 11, 1119, 39);
		 frame.getContentPane().add(textField);
		 textField.setColumns(10);
		 
		 String s11= "Your test has started at "+LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute()+":"+
		 LocalDateTime.now().getSecond()+" and You have "+ t +" mins to take the test" ;
				 
	
		 textField.setText(s11);
		 
		 JTextPane txtpnGeneralInstructions = new JTextPane();
		 txtpnGeneralInstructions.setForeground(new Color(25, 25, 112));
		 txtpnGeneralInstructions.setFont(new Font("Tahoma", Font.BOLD, 14));
		 txtpnGeneralInstructions.setText("General Instructions:\r\n 1. You may get overwhelmed by the questions but please remember to write the question number before every answer. \r\n2. Its an exam platform and not a time machine so you can't modify your answers once you click submit.\r\n3. As you can find no other blank space except the one below, so without wasting further time go on with your answers there .\r\n");
		 txtpnGeneralInstructions.setBackground(new Color(144, 238, 144));
		 txtpnGeneralInstructions.setBounds(29, 229, 1119, 83);
		 frame.getContentPane().add(txtpnGeneralInstructions);
		 
		 
		 
		
	}
}
