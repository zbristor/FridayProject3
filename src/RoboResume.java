import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoboResume {
	public static void main(String[] args) {
		Input input1 = new Input();
		String b = input1.inputBio();
		String[] bParts = b.split(" ");
		String fName = bParts[0];
		String lName = bParts[1];
		String email = bParts[2];
		input1.inputWork();
		input1.inputEducation();
		
		String s = "";
		String p = "";
		String w = "";
		String sql=null;
		String sql2=null;
		String sql3=null;
		String sql5=null;
		String degree=null;
		String school=null;
		String year=null;
		String position=null;
		String company=null;
		String startTime=null;
		String endTime=null;
		String duty1=null;
		String duty2=null;
		List<String> eduList = new ArrayList<String>();
		List<String> workList = new ArrayList<String>();
		List<String> skillList = new ArrayList<String>();
		for (int j=0;j<input1.inputEducation().size();j++)
		{
			eduList.add(input1.inputEducation().get(j));
		}
		for (int m=0; m<input1.inputWork().size();m++)
		{
			workList.add(input1.inputWork().get(m));
		}
		for (int g=0; g<input1.inputSkill().size();g++)
		{
			skillList.add(input1.inputSkill().get(g));
		}
			sql = "insert into Person(FirstName,LastName,Email)values(?,?,?)";
			sql2 = "insert into Education(Degree,School,Year)values(?,?,?)";
			sql3 = "insert into Work(Position,Company,StartTime,EndTime,Duty1,Duty2)values(?,?,?,?,?,?)";
			sql5 = "insert into Skills(SkillName)values(?)";
		
		Connection con = null;
		//ResultSet rs = null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		PreparedStatement pstmt5=null;
		{
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Resume?"+ "user=root&password=password");
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, fName);
            pstmt.setString(2, lName);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
            // The following for loop is used in the event that someone enters more than one school
    		for(int j=0; j<eduList.size();j++)
    		{
    			s = eduList.get(j);
    			String[] eParts = s.split("/");
    			//System.out.println(eParts);
    			degree = eParts[0];
    			school = eParts[1];
    			year = eParts[2];
    			pstmt2 = con.prepareStatement(sql2);
    			pstmt2.setString(1, degree);
    			pstmt2.setString(2, school);
    			pstmt2.setString(3, year);
    			pstmt2.executeUpdate();
    		}		
    		// I could not get the work code to function. I kept on getting a Null Pointer Exception and could not figure out why.
    		
            for(int d=0; d<workList.size();d++)
            {
            	w = workList.get(d);
            	String[] wParts = w.split("/");
            	//System.out.println(wParts);
            	position = wParts[0];
            	company = wParts[1];
            	startTime = wParts[2];
            	endTime = wParts[3];
            	duty1 = wParts[4];
            	duty2 = wParts[5];
            	pstmt3 = con.prepareStatement(sql3);
            	pstmt3.setString(1, position);
            	pstmt3.setString(2, company);
            	pstmt3.setString(3, startTime);
            	pstmt3.setString(4, endTime);
            	pstmt3.setString(5, duty1);
            	pstmt3.setString(6, duty2);
            	pstmt3.executeUpdate();
            }
            
    		for(int l=0; l<skillList.size();l++)
    		{
    			p = skillList.get(l);
    			String[] sParts = p.split(" ");
    			String skillName = sParts[0];
    			pstmt5 = con.prepareStatement(sql5);
    			pstmt5.setString(1, skillName);
    			pstmt5.executeUpdate();
    		}
    		
        	}catch (SQLException e){

		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}finally {
			try {

				pstmt.close();
				pstmt2.close();
				pstmt3.close();
				pstmt5.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	//input1.print();
}
	
	}
