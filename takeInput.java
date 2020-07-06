package input;
import java.util.Scanner;

public class takeInput {
	static int i = 0;
	static String[] s=new String[10];
	static int n;
	static int marks[]=new int[10];
	static String passcodes;
	static String passcodet;
	public static int ctr;
	Scanner sc=new Scanner(System.in);
	
	
	public void input()
	{
		
		    ctr=0;
		    sc.nextLine();
			System.out.println("Create a new password for teacher");
			passcodet=sc.nextLine();
			System.out.println("Create a password for student");
			passcodes=sc.nextLine();			
			System.out.println("Enter the number of questions to be added:");
			n=sc.nextInt();
			sc.nextLine();
			while(i<n)
			{
				
				System.out.println("Enter the question number "+ (i+1));			
				s[i]=sc.nextLine();
				i++;
			}
			for(i=0;i<n;i++)
			{
				System.out.println("Enter the marks of q.no "+ (i+1));
				marks[i]=sc.nextInt();
				
							
			
			
		}
			ctr=1;
			
	}
		

public void display()
{
	
		String pcode;
		
		try{
			sc.nextLine();
			System.out.println("enter the password for students to see the questions :");		
		    pcode=sc.nextLine();		
			
			while(!pcode.equals(passcodes)){
                 
				System.out.println("the password entered by you is "+ pcode);
				System.out.println("the password is incorrect");
				System.out.println("enter correct password :");
				pcode=sc.nextLine();
			}
			
for(i=0;i<3;i++)
System.out.println("===========*********************============");

System.out.println("The respective questions and their marks are displayed below\n\n");
for(i=0;i<n;i++)
{
			System.out.println("     "+ (i+1) +") "+ s[i] +"\t\t marks... "+ marks[i]+"\n\n");
}

			
		}catch(Exception e)
		{
		   }
	}
}

	
	
	

	
