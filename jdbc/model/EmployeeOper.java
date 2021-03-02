package model;
import dao.*;
import java.util.*;
public class EmployeeOper
{
	public static boolean add(Employee emp)
	{
		if(emp.getSal()>=15000 && emp.getSal()<=500000)
		{
		  if(EmployeeDAO.add(emp))
		     return true;
		  return false;
		}
		return false;		
	}
	public static ArrayList displayALL()
	{
		ArrayList arr=EmployeeDAO.displayAll();
		return arr;
	}
	public static Employee displayByEmpno(int empno)
	{	
	  Employee emp1=EmployeeDAO.displayByEmpno(empno);
	  return emp1;
	}

	}

