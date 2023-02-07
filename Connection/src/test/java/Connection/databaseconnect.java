package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseconnect {

	public static void main(String[] args) throws SQLException {
		
	//	String host="127.0.0.1";
	//	String port="3306";
		//String databasename= "EmployeeInfo";
		
	//	String ConnectingURL= "jdbc:mysql://"+host+":"+port+"/EmployeeInfo";
		//"jdbc:mysql://"+host+":"+port+"/EmployeeInfo"
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeInfo?enabledTLSProtocols=TLSv1.2", "root", "Root");
		
		Statement s = conn.createStatement();
		
	ResultSet rs = s.executeQuery("select * from EmpDetails where name='raj3';");
		
		while(rs.next())
			
		{
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("age"));
			System.out.println(rs.getString("location"));
		}
	}

}
