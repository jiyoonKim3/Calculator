package com.samsung.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.samsung.emp.utils.JDBCUtils;
import com.samsung.user.vo.HUserVO;

public class HomeUserDAO {

	public void insertUser(HUserVO user) {

		Connection conn = JDBCUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into hUsers values ( nvl((select max(seq)+1 from husers), 0) , ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getAge());
			ps.setInt(5, user.getGender());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(ps, conn);
		}
		
	}

	public ArrayList<HUserVO> getUserList() {
		ArrayList<HUserVO> list = new ArrayList<>();
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from husers order by seq";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				int age = rs.getInt("age");
				int gender = rs.getInt("gender");
				HUserVO user = new HUserVO(name, password, email, age, gender);
				System.out.println(user);
				list.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, ps, conn);
		}
		return list;
	}

}
