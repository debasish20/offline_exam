package input;
import java.util.Scanner;

public class takeInput {
	
	
	
	public void quest()
	{
		int i = 0;
		String[] s=new String[10];
		int n;
		int marks[]=new int[10];
		try (Scanner sc = new Scanner(System.in)) {
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
		for(i=0;i<3;i++)
		System.out.println("===========*********************============");
		
		System.out.println("The respective questions and their marks are displayed below");
		for(i=0;i<n;i++)
		{
			System.out.println("question # "+ i +" is "+ s[i] +" and its marks is "+ marks[i]);
		}
		
	}
}
	
	
	

	
