package com.jspiders;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class MyFirstJDBC 
{
	public static void main(String[] args) 
	{
	      Connection con=null;
		  ResultSet rs=null;
		  Statement stmt=null;
		
		try
		{
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			
			String dbUrl="jdbc:mysql://localhost:3306/test?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);
			
			String query = "select * from student_info";
			 stmt = con.createStatement();
		     rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				int regno = rs.getInt("regno");
				String fNM = rs.getString("firstname");
				String mNM = rs.getString("middlename");
				String lNM = rs.getString("lastname");
				
				System.out.println("Registration Number:"+regno);
				System.out.println("First name:"+fNM);
				System.out.println("Middle Name:"+mNM);
				System.out.println("LAST Name:"+lNM);
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			}
		}//END OF while
			
			
			catch(SQLException E)
			{
				E.printStackTrace();
			}
			finally
			{
				try
				{
					if(con!=null)
					{
						con.close();
					}
					if(rs!=null)
					{
						rs.close();
					}
					if(stmt!=null)
						stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
		}
	}
