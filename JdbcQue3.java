import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcQue3 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		String filePath="C:/Users/user/Documents/input.txt";
		
		Class.forName("org.postgresql.Driver");
			
		String url="jdbc:postgresql://localhost:5432/jdbcpgms";
		String user="postgres";
		String password="root123";
		
		try
		(Connection connection=DriverManager.getConnection(url, user, password))
		{
			try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
			{
				String line;
				String insertQuery = "INSERT INTO persons (column1, column2) VALUES (?, ?)";
				PreparedStatement statement = connection.prepareStatement(insertQuery);

				// Set auto-commit to false for batch processing
				connection.setAutoCommit(false);

				while((line = br.readLine()) != null) 
				{
					String[] data = line.split(",");
					String column1 = data[0];
					String column2 = data[1];

					// Set parameter values
					statement.setString(1, column1);
					statement.setString(2, column2);

					// Add statement to the batch
					statement.addBatch();
				}
				// Execute the batch update
				statement.executeBatch();

				// Commit the transaction
				connection.commit();

				System.out.println("Batch update completed successfully.");
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		} 
		catch(Exception e) 
		{
        e.printStackTrace();
		}
	}
}
