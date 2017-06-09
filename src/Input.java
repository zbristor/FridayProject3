import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
private String Education;
public Input()
{
	
}
Scanner sc = new Scanner(System.in);
String toStop = "stop";
int expCount=0;
int eduCount=0;
int sCount=0;
String input="";
ArrayList<String> wAL = new ArrayList<String>();
ArrayList<String> aAL = new ArrayList<String>();
ArrayList<String> sAL = new ArrayList<String>();
List<String> l= new ArrayList<String>();
public String toString(String e)
{
	return Education;
}
public String inputBio()
{
	System.out.println("Enter your first name: ");
	String fname = sc.nextLine();
	System.out.println("Enter your last name: ");
	String lname = sc.nextLine();
	System.out.println("Enter an email address: ");
	String email = sc.nextLine();
	return fname+" "+lname+" "+email;
}
public ArrayList<String> inputEducation()
{
			do{
				eduCount++;
				if(eduCount!=10)
				{
					if(!(toStop.equalsIgnoreCase(input))){
					System.out.println("Enter the degree that you have earned: ");
					input = sc.nextLine();
					System.out.println("Enter the school that you graduated from: ");
					String school = sc.nextLine();
					System.out.println("Enter the year you graduated: ");
					String gradYear = sc.nextLine();
					String EduInput=input+"/"+school+"/"+gradYear;
					if(!(EduInput.equals("stop/stop/stop")))
							aAL.add(EduInput);
					}
				}
			}while(!(toStop.equals(input)) && eduCount<11);
	return aAL;
}
public ArrayList<String> inputWork()
{
	System.out.println("Enter the work experience and type stop to stop");
			do{
				expCount+=1; 
				if(expCount!=10)
				{
					//if(!(input.equalsIgnoreCase(toStop))){
						input = sc.nextLine();
						wAL.add(input);
					
				}
			}while(!(toStop.equalsIgnoreCase(input)) && expCount<11); 
			//System.out.println(wAL);		
	return wAL;
}
public ArrayList<String> inputSkill()
{
			do{
				sCount+=1;
				if(sCount!=20)
				{
					if(!(toStop.equalsIgnoreCase(input)))
					{
					System.out.println("Enter a skill: ");
					input = sc.nextLine();
					sAL.add(input);
					}
				}
			}while(!(toStop.equals(input)) && sCount<21);
	return sAL;
}
}
