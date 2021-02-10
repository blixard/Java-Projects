import java.sql.*;

public class Sqlj{
	public static void main (String [] args)throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connecting to database...");
		Connection conn = null;
		try {
			int id = 23;
			String name = "helloworld";
			int ch = 5;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
			Statement stm = conn.createStatement();
//			int x = stm.executeUpdate("insert into employes value(2,'rupel')");
			int x = 0;
//			x = stm.executeUpdate("INSERT INTO employes(Id) VALUE ("+id+")");
//			x = stm.executeUpdate("INSERT INTO employes(Name) VALUE ("+id+")");
			
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employes(Id,Name) VALUE(?,?)");
			pstmt.setInt(1, id);;
			pstmt.setString(2, name);
			pstmt.executeUpdate();
			
			ResultSet rs=stm.executeQuery("select * from employes");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
			System.out.println(conn + " " +stm);
		}catch(SQLException se) {
			System.out.println("exception : " + se ) ;
		}
	    
	}
}