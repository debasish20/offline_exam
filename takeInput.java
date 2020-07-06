package input;
import java.util.Scanner;

public class takeInput {
	static int i = 0;
	static String[] s=new String[10];
	static int n;
	static int marks[]=new int[10];
	static String passcode;
	static String passcode2;
	Scanner sc=new Scanner(System.in);
	
	public void input()
	{
		
		
		    
			sc.nextLine();
			System.out.println("Create a new password");
			passcode=sc.nextLine();
			System.out.println("Create a password for student");
			passcode2=sc.nextLine();			
			System.out.println("Enter the number of questions to be added:");
			n=sc.nextInt();
			sc.nextLine();
			while(i<n)
			{
				
				System.out.println("Enter the question # "+ i);			
				s[i]=sc.nextLine();
				i++;
			}
			for(i=0;i<n;i++)
			{
				System.out.println("Enter the marks of q.no "+ i);
				marks[i]=sc.nextInt();
				
							
			
			
		}
	}
		

public void display()
{
	
		String pcode;
		
		try{
			sc.nextLine();
			System.out.println("enter the password :");		
		    pcode=sc.nextLine();		
			System.out.println("the password is "+ pcode);
			while(!pcode.equals(passcode2)){

				System.out.println("the password is incorrect");
			}
			
for(i=0;i<3;i++)
System.out.println("===========*********************============");

System.out.println("The respective questions and their marks are displayed below");
for(i=0;i<n;i++)
{
			System.out.println(" # "+ i +") "+ s[i] +"\t\t marks... "+ marks[i]);
}

			
		}catch(Exception e)
		{
		   }
	}
}

	
	
	

	
