package controller;
import java.util.ArrayList;

import dao.EmployeeDAO;
import model.*;
public class EmployeeController
{
	public static String add(String ename,float sal,int dno)
	{
		Employee emp=new Employee(ename,sal,dno);
		if(EmployeeOper.add(emp))
			return "Added successully";
		return "Not Added.";
	}
	public static ArrayList displayALL()
	{
		ArrayList arr=EmployeeOper.displayALL();
		return arr;
	}
	public static Employee displayByEmpno(int empno)
	{	
	  Employee emp1=EmployeeOper.displayByEmpno(empno);
	  return emp1;
	}
	}
	

