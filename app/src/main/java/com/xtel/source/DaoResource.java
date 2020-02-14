package com.xtel.source;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.xtel.context.*;
import com.xtel.model.*;

public class DaoResource {
	Connection conn;

	public ArrayList<User> selectAll() {
		ArrayList<User> listOfU = new ArrayList<User>();
		try {
			conn = new DBContext().getConnection();
			String sql = "Select * from vietlot_user";
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			while (rs.next()) {
				User u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
				listOfU.add(u);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfU;
	}

	public int addUser(User user) {
		int result = 0;
		try {
        	String SQL = "insert into vietlot_user (name,ticket_number,Identify_number,ticket_cost,In_date)" + 
    				"values('"+user.getName()+"','"+user.getNumber()+"','"+user.getIdentify_number()+"','"+user.getPrice()+"',SYSDATE)";
        	conn = new DBContext().getConnection();
			result = conn.prepareStatement(SQL).executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	public int delete(String id) {
		int result = 0;
		try {
			String sql = "Delete from vietlot_user where vietlot_user.identify_number= '"+ id+"'";
			conn = new DBContext().getConnection();
			result = conn.prepareStatement(sql).executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
