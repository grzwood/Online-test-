package com.ht.servlet;

//////���ݿ������//////
import java.sql.*;
import java.util.*;
public class DataBaseOperator {
	Connection conn=null;//���ݿ����ӱ���
	static DataBaseOperator instance=null;//����ģʽ
	DataBaseOperator(){
		init();
	}
	//ʹ��JDBC�������ݿ�
	void init(){
		try{
			//���ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/javaee";
			String user="root";
			String password="123456";
			conn=DriverManager.getConnection(url,user,password);
			System.out.println("���ӳɹ�");
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	//��øõ�����ķ���
	public static DataBaseOperator getInstance(){
		if(instance==null) instance=new DataBaseOperator();
		return instance;
	}
	
	//���ӡ�ɾ�����޸�����
	public int updata(String sql){
		Statement stat=null;
		int num=-1;//��¼���ĸ���
		try {
			stat=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//����sql���
		try {
			num = stat.executeUpdate(sql);
			if(stat!=null){stat.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	//��ѯ����
	public ArrayList<String []> search(String sql ){
		Statement stat=null;
		ArrayList<String []> list = new ArrayList<String []>();//�洢��ѯ���
		try {
			stat=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//����sql���
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
