import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;
public class MySQLConnect {
	String Host = "localhost";
	String UserName = "root";
	String Password = "";
	String DataBase = "khohang";	
	Connection connect = null;
	Statement stmt = null;
	ResultSet result = null;
	
	public MySQLConnect() {}	
	public MySQLConnect(String host, String username, String password, String database) {
		this.Host = host;
		this.UserName = username;
		this.Password = password;
		this.DataBase = database;
	}
	protected void driverTest() throws Exception{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(java.lang.ClassNotFoundException e) {
			throw new Exception("Not Found");
		}
	}
	protected Connection getConnection() throws Exception{
		if(this.connect == null) 
			driverTest();
		String url = "jdbc:mysql://" + this.Host +":3306/" + this.DataBase;
		try {
			this.connect = DriverManager.getConnection(url, this.UserName, this.Password);
		}
		catch(java.sql.SQLException e){
			throw new Exception("Không thể kết nối!!");
		}
		return this.connect;
	}
	protected Statement getStatement() throws Exception{
		if(this.stmt == null ? true: this.stmt.isClosed()) {
			this.stmt = this.getConnection().createStatement();
		}
		return this.stmt;
	}
	public ResultSet executeQuery(String Query) throws Exception{
		try {
			this.result = getStatement().executeQuery(Query);
		}
		catch(Exception e) {
			throw new Exception("Erro:"+e.getMessage() + "-" + Query);
		}
		return this.result;
	}
	public int executeUpdate(String Query) throws Exception{
		int res = Integer.MIN_VALUE;
		try {
			res = getStatement().executeUpdate(Query);
		}
		catch(Exception e) {
			throw new Exception("Erro:" + e.getMessage() + " - " + Query);
		}
		finally {
			this.Close();
		}
		return res;
	}
	public void Close() throws SQLException{
		if(this.result != null && ! this.result.isClosed()) {
			this.result.close();
			this.result = null;
		}
		if(this.stmt != null && ! this.stmt.isClosed()) {
			this.stmt.close();
			this.stmt = null;
		}
		if(this.connect != null && ! this.connect.isClosed()) {
			this.connect.close();
			this.connect = null;
		}
	}
	protected static int CountRow(ResultSet result) throws SQLException{
		int count = 0;
		while (result.next()) {
			count++;
		}
		return count;
	}
}

