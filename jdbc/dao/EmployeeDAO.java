package dao;
import java.sql.DriverManager;
import java.util.*;
import model.*;
import java.sql.*;
public class EmployeeDAO 
{
	static Connection con;
	static ResultSet rs;
	static PreparedStatement pstmt;
	public static void openConnection()
	{
		try
		{			
			Class.forName("com.mysql.jdbc.Driver");		
			System.out.println("Connecting to database...");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
		     
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void closeConnection()
	{
		try
		{
		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	public static boolean add(Employee emp)
	{	
		try
		{
			openConnection();
			pstmt=con.prepareStatement("insert into emp(ename,sal,deptno) values (?,?,?)");
			//pstmt.setInt(1,emp.getEmpno());
			pstmt.setString(1,emp.getEname() );
			pstmt.setFloat(2, emp.getSal());
			pstmt.setInt(3, emp.getDno());
			int nor=pstmt.executeUpdate();
			closeConnection();
			if(nor>0)
				return true;
			else
				return false;			
		}
		catch(SQLException e)
		{
			e.printStackTrace();return false;	
		}
		catch(Exception e)
		{
		  e.printStackTrace();return false;	
		}
		
	}
	public static ArrayList displayAll()
	{	
		try
		{
			openConnection();
			pstmt=con.prepareStatement("select empno,ename,sal,dno from emp");
			rs=pstmt.executeQuery();
			//ArrayList<Employee> arr=new ArrayList<Employee>();
			ArrayList arr=new ArrayList();
			while(rs.next())
			{
				Employee emp1=new Employee(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
			    arr.add((emp1));
			  
			}
			closeConnection();
			return arr;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();return null;	
		}
		catch(Exception e)
		{
		  e.printStackTrace();return null;	
		}		
	}
	public static Employee displayByEmpno(int empno)
	{	
		try
		{
			openConnection();
			pstmt=con.prepareStatement("select empno,ename,sal,dno from emp where empno=?");
			pstmt.setInt(1, empno);
			rs=pstmt.executeQuery();
			//ArrayList arr=new ArrayList();
			Employee emp1=null;
			if(rs.next())
			{
				emp1=new Employee(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
			}
			closeConnection();
			return emp1;
		}
		catch(SQLException e)
		{
			e.printStackTrace();return null;	
		}
		catch(Exception e)
		{
		  e.printStackTrace();return null;	
		}		
	}
	
}
