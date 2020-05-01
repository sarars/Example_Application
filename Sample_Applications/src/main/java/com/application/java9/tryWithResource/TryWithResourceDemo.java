package main.java.com.application.java9.tryWithResource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TryWithResourceDemo {

	public static void main(String... args) throws SQLException {
		
		beforeJava9();
		afterJava9();
		
	}

	private static void afterJava9() throws SQLException {
		
		String url = "192.188.92.85";
		String user = "db1";
		String password = "db1_1";
		String sql = "Select * from USER_TABLE";
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		try(con;stm;rs){
			while (rs.next()) {
				System.out.println("Enitity 1");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	private static void beforeJava9() {
		String url = "192.188.92.85";
		String user = "db1";
		String password = "db1_1";
		String sql = "Select * from USER_TABLE";
		try(Connection con = DriverManager.getConnection(url, user, password);
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql)){
			while (rs.next()) {
				System.out.println("Enitity 1");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
