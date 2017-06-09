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
		//input1.inputBio();
		/*
		String b = input1.inputBio();
		String[] bParts = b.split(" ");
		String fName = bParts[0];
		String lName = bParts[1];
		String email = bParts[2];
		input1.inputEducation();
		*/
		String s = "";
		String p = "";
		String sql=null;
		String sql2=null;
		String sql5=null;
		String degree=null;
		String school=null;
		String year=null;
		List<String> eduList = new ArrayList<String>();
		List<String> skillList = new ArrayList<String>();
		for (int g=0; g<input1.inputSkill().size();g++)
		{
			skillList.add(input1.inputSkill().get(g));
		}
		for (int j=0;j<input1.inputEducation().size();j++)
		{
			eduList.add(input1.inputEducation().get(j));
		}

		//System.out.println(eduList);
			sql = "insert into Person(FirstName,LastName,Email)values(?,?,?)";
			sql2 = "insert into Education(Degree,School,Year)values(?,?,?)";
			sql5 = "insert into Skills(SkillName)values(?)";
			//System.out.println(sql);
		
		//String sql=null;
		Connection con = null;
		//ResultSet rs = null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt5=null;
		{
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Resume?"+ "user=root&password=password");
            pstmt = con.prepareStatement(sql);
            /*
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
    		*/
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
		/*
		while(rs.next()){
			System.out.print(rs.getString("FirstName") + "\t");
			System.out.print(rs.getString("LastName"));
			System.out.println();
		}
		*/
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//rs.close();
				pstmt.close();
				//pstmt2.close();
				pstmt5.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}
}
	}
