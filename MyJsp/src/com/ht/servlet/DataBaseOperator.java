package com.ht.servlet;

//////数据库访问类//////
import java.sql.*;
import java.util.*;
public class DataBaseOperator {
	Connection conn=null;//数据库连接变量
	static DataBaseOperator instance=null;//单例模式
	DataBaseOperator(){
		init();
	}
	//使用JDBC连接数据库
	void init(){
		try{
			//数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/javaee";
			String user="root";
			String password="123456";
			conn=DriverManager.getConnection(url,user,password);
			System.out.println("连接成功");
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	//获得该单例类的方法
	public static DataBaseOperator getInstance(){
		if(instance==null) instance=new DataBaseOperator();
		return instance;
	}
	
	//增加、删除、修改数据
	public int updata(String sql){
		Statement stat=null;
		int num=-1;//记录更改个数
		try {
			stat=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//调用sql语句
		try {
			num = stat.executeUpdate(sql);
			if(stat!=null){stat.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	//查询数据
	public ArrayList<String []> search(String sql ){
		Statement stat=null;
		ArrayList<String []> list = new ArrayList<String []>();//存储查询结果
		try {
			stat=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//调用sql语句
		try {
			ResultSet re=null;
			re = stat.executeQuery(sql);
			ResultSetMetaData rsmd = re.getMetaData();
			int num = rsmd.getColumnCount();
			while(re.next()){
				String [] s = new String [num];
				for(int i = 1;i<=num;i++){
					s[i-1] = re.getString(i);
				}
				list.add(s);
			}
			if(re!=null) re.close();
			if(stat!=null) stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
