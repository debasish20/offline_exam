package input;

import java.util.Scanner;

public class student  {
	
	public void answer() {	
		
	takeInput ob=new takeInput();
	String[] ans=new String[10];
	Scanner sc=new Scanner(System.in);
	int n1=takeInput.n;
	System.out.println("Do you want to take the quiz: y for yes");
	char ch= sc.next().charAt(0);
	sc.nextLine();
	if(ch=='y')
	{
		ob.display();
		System.out.println("Enter you answers here >>> ");
		for(int i=0;i<n1;i++)
		{
		  ans[i]=sc.nextLine();	
		}
		System.out.println("your answers are>>>");
		for(int i = 0;i<n1;i++)
		{
			System.out.println("for q.no "+ i+" answer is---> "+ans[i]);
		}
		
		
	}
	
	
	
	

}
}
