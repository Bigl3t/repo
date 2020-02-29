package com.bjwl.dao;

import com.bjwl.entity.Stu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StuDao extends BaseDao {

	public List<Stu> query(Stu stu){
		
		String sname = stu.getSname();

		String sql = "select sname,sex,age from stu where sname = '"+sname+"'";
		rst = super.query(sql);
		
		List<Stu> list = new ArrayList<Stu>();

		try {
			while(rst.next()){

				Stu p = new Stu();
				int age = rst.getInt("age");
				String name  = rst.getString("sname");
				String sex = rst.getString("sex");

				p.setSname(name);
				p.setAge(age);
				p.setSex(sex);

				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		
		return list;
	}
}
