package jfsd.assessments.phase2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jfsd.assessments.phase2.entities.User;

public final class UsersDB {
	private static Connection getConnection()
	{

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			// mysql on windows : 3306
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd?autoReconnect=true&useSSL=false",
					"root", "password");
			System.out.println("DB Connected");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static User getUser(String uname)
	{
		Connection con = getConnection();

		String sql = "SELECT * FROM loginusers WHERE uname = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return new User(rs.getString("uname"), rs.getString("fname"), rs.getString("email"), rs.getString("password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String validateUserExists(String unameOrEmail)
	{
		Connection con = getConnection();

		String sql = "SELECT uname FROM loginusers WHERE uname = ? OR email = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, unameOrEmail);
			ps.setString(2, unameOrEmail);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return rs.getString("uname");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
