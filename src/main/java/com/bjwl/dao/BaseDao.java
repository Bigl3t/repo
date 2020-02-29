package com.bjwl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;


public class BaseDao {
	private Connection conn;
	private PreparedStatement pst;
	protected ResultSet rst;

	private static String username = "root";
	private static String password = "123456";
	private static String url = "jdbc:mysql://127.0.0.1:3306/j2ee?serverTimezone=UTC&useSSL=false";
	private static String driver = "com.mysql.cj.jdbc.Driver";

	
	private boolean isAutoClose = true;

	public void setAutoClose(boolean isClose) {
		this.isAutoClose = isClose;
	}

	public Connection getConnection() {
		if (conn == null) {
			try {
				Class.forName(driver);

				conn = DriverManager.getConnection(url, username, password);
				System.out.println(conn+"=============>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	/**
	 * ����
	 */
	public int update(String sql, Object... params) {
		System.out.println(">>>>>sql:"+sql);
		System.out.println(">>>param:"+Arrays.toString(params));
		conn = getConnection();
		try {
			
			pst = conn.prepareStatement(sql);

			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}
			int rows = pst.executeUpdate();
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(isAutoClose) {
				close();
			}
		}
		return -1;
	}

	

	public void close() {
		try {
			if (rst != null) {
				rst.close();
				rst = null;
			}
			if (pst != null) {
				pst.close();
				pst = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {

		}
	}
	

	protected ResultSet query(String sql,Object... params) {
		System.out.println(">>>>>=="+sql);
		System.out.println(">>>>params:"+Arrays.toString(params));
		getConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			
			if(params!=null&&params.length>0) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i+1, params[i]);
				}
			}
			
			return pst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			/////
		}
		
		
		return null;
	}
	
	
}
