package getData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * getDataFromOracle class is to connect to my Oracle Database (Using a Thin Driver) and query the SPORTYCARS table to obtain the entire and 
 * complete array of Sport Cars
 * @author Yuhang Zhao, student#=150467199
 *
 */
public class getDataFromOracle {
	
	public static SportyCars[] requestDataThroughThin() {
		SportyCars[] carsArray = new SportyCars[4];
		int i = 0;
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName(OracleInfo.DRIVER_CLASS);
			connection = DriverManager.getConnection(OracleInfo.DB_THIN_CONNECTION, OracleInfo.U, OracleInfo.P);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM SPORTYCARS");
			while (resultSet.next()) {
				
				int year = resultSet.getInt("YEAR");
				String make = resultSet.getString("MAKE");
				String model = resultSet.getString("MODEL");
				Double price = resultSet.getDouble("PRICE");
				
				SportyCars car = new SportyCars(year, make, model, price);
				if(i <= 3) {
					carsArray[i] = car;
					i++;
				}
			}
		} catch (ClassNotFoundException cnfex) {
			System.err.println("Failed to load JDBC driver.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception: " + e.getMessage());
		}
		
		return carsArray;
	}
	
	
}
