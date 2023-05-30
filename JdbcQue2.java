import java.sql.*;

public class JdbcQue2 {

	public static void main(String[] args) {
		Connection connection=null;
		
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
            
			// Create a table if it doesn't exist
            createTable(connection);

            insertRecord(connection, 1, "Janu", 25);
            insertRecord(connection, 2, "Anu", 30);
            viewRecords(connection);
            updateRecord(connection, 1, "Janu", 26);
            deleteRecord(connection, 2);
            viewRecords(connection);

            // Close the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTable(Connection connection) throws SQLException 
    {
        Statement stmt = connection.createStatement();
        String sqlCreateQuery = "CREATE TABLE IF NOT EXISTS employees " +
                     "(id INT PRIMARY KEY, name VARCHAR(255), age INT)";
        stmt.executeUpdate(sqlCreateQuery);
        stmt.close();
    }

    public static void insertRecord(Connection connection, int id, String name, int age) throws SQLException 
    {
        String sqlInsertQuery = "INSERT INTO employees (id, name, age) VALUES (?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sqlInsertQuery);
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setInt(3, age);
        pstmt.executeUpdate();
        pstmt.close();
        System.out.println("Record inserted successfully.");
    }

    public static void viewRecords(Connection connection) throws SQLException 
    {
        String sqlSelectQuery = "SELECT * FROM employees";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sqlSelectQuery);

        System.out.println("ID\tName\t\tAge");
        while (rs.next()) 
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println(id + "\t" + name + "\t" + age);
        }
        rs.close();
        stmt.close();
    }

    public static void updateRecord(Connection connection, int id, String name, int age) throws SQLException 
    {
        String sqlUpdateQuery = "UPDATE employees SET name=?, age=? WHERE id=?";
        PreparedStatement pstmt = connection.prepareStatement(sqlUpdateQuery);
        pstmt.setString(1, name);
        pstmt.setInt(2, age);
        pstmt.setInt(3, id);
        int rowsAffected = pstmt.executeUpdate();
        pstmt.close();
        System.out.println(rowsAffected + " record(s) updated successfully.");
    }

    public static void deleteRecord(Connection connection, int id) throws SQLException 
    {
        String sqlDeleteQuery = "DELETE FROM employees WHERE id=?";
        PreparedStatement pstmt = connection.prepareStatement(sqlDeleteQuery);
        pstmt.setInt(1, id);
        int rowsAffected = pstmt.executeUpdate();
        pstmt.close();
        System.out.println(rowsAffected + " record(s) deleted successfully.");
    }
}