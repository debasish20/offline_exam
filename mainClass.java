package input;

import java.util.Scanner;

public class mainClass {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		takeInput ob=new takeInput();
		student ob2=new student();
		try (Scanner sc = new Scanner(System.in)) {
			char ch;
			int n = 0;
			System.out.println("enter any number or -1 to stop");
			n=sc.nextInt();
			
			while(n!=-1)
			{
			System.out.println("Are you a teacher or a student ? >>>> enter t for teacher and s for student");
			 ch=sc.next().charAt(0);
			 
			 if(takeInput.s==null)
			 {
			 
			
			switch(ch)
			{
			case 't':ob.input();
			         ob.display();
			         break;
			case 's':System.out.println("question not yet submitted");
			         break;
					
			default:System.out.println("sorry !!! wrong input");		
			
}
			 }
			else {
				sc.nextLine();
				System.out.println("the question has already been inserted and if you want to change enter password for teacher");
				String s11=sc.nextLine();
				if(s11.equals(takeInput.passcode))
				{
					ob.input();
				}
				else {
			    if(ch=='s') {
				
				ob2.answer();
				break;
				
			}
				}
			 }
				
		
		}
		}
	}
}
	



