package pageObject.pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMysql {
	
	   public static ResultSet retrieveData() throws SQLException{
		      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		      String mysqlUrl = "jdbc:mysql://localhost/classicmodels";
		      Connection con = DriverManager.getConnection(mysqlUrl, "root", "kartik@111");
		      Statement stmt = con.createStatement();
		      ResultSet rs = stmt.executeQuery("SELECT * FROM classicmodels.customers where contactLastName = 'Nelson'");
		      return rs;
		   }


	public static void main(String[] args) throws SQLException {

/*		String sql = "SELECT * FROM classicmodels.customers where contactLastName = 'Nelson'";
		String url = "jdbc:mysql://localhost/classicmodels";
		String username = "root";
		String password = "kartik@111";
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		Statement st = con.createStatement();
		//st.executeQuery(sql);
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		String op1 = rs.getString(2);
		System.out.println(op1);*/
		
		ResultSet rs = retrieveData();
	      System.out.println("Contents of the MyTable");
	    
	      while(rs.next()) {
	         System.out.print(rs.getInt("customerNumber")+", ");
	         System.out.print(rs.getString("customerName")+", ");
	         System.out.print(rs.getString("contactLastName")+", ");
	         System.out.print(rs.getString("contactFirstName")+", ");
	         System.out.print(rs.getString("phone")+", ");
	         System.out.print(rs.getString("addressLine1")+", ");
	         System.out.print(rs.getString("addressLine2")+", ");
	         System.out.print(rs.getString("city"));
	         System.out.println();
		
	}

}
}
