import java.sql.*;
public class JdbcQue1 {
	
	public static void main(String[] args)
	{
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try
		{
			//step1: Load and Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully");
			
			//step2: Establish the connection with Database
			String url="jdbc:mysql://localhost:3306/jdbcpgms";
			String user="root";
			String password="root";
			
			connection=DriverManager.getConnection(url, user, password);
			System.out.println("Connection established successfully..");
			
			//step3: Create statement object and send the query
			statement=connection.createStatement();
			
			//step 4: Execute the query and process the resultSet
			String sqlSelectQuery="select sid,sname,sage,saddress from student";
			resultSet=statement.executeQuery(sqlSelectQuery);
			
			System.out.println();
			
			System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
			while(resultSet.next())
			{
				Integer sid=resultSet.getInt(1);
				String sname=resultSet.getString(2);
				Integer sage=resultSet.getInt(3);
				String saddr=resultSet.getString(4);
				
				System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+saddr);
			}
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection!=null)
			{
				try
				{
					connection.close();
					System.out.println("connection closed");
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
			}
		}
	}
}


