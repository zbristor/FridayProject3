import java.util.ArrayList;

public class Print {
	private ArrayList Education;
	private ArrayList Work;
	private ArrayList Person;
public void print(String name, String email, ArrayList e, ArrayList f, ArrayList g)
{
	System.out.println("===========================================================");
	System.out.println(name);
	System.out.println(email);
	System.out.println();
	System.out.println("Education");
	for(int i=0; i<e.size();i++)
	{
		//e.set(e.size()-1, "");
		System.out.println(e.get(i));
	}
	System.out.println();
	System.out.println("Experience");
	for(int j=0; j<f.size(); j++)
	{
		//f.set(f.size()-1, "");
		System.out.println(f.get(j));
	}
	System.out.println();
	System.out.println("Skills");
	for(int k=0; k<g.size(); k++)
	{
		//g.set(g.size()-1, "");
		System.out.println(g.get(k));
	}
}
}
/*


*/