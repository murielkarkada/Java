package view;

import java.util.*;
import model.*;

import controller.EmployeeController;
public class Program
{
	
	public static void main(String []args)
	{
		Scanner scan=new Scanner(System.in);
		int  x=1;
		while(x==1)
		{
		//int ch;
		System.out.println("Menu:\n1.Display All\n2.Display Details by ID\n3.Add New Employee\n4.Update\n5.Delete");
		System.out.println("Enter the choice:");
		int ch=Integer.parseInt(scan.nextLine());
		switch(ch)
		{
		case 1://disp all
		
			ArrayList arr=EmployeeController.displayALL();
			for(Object obj : arr)
			{
				if(obj instanceof Employee)
				{
					Employee emp=(Employee)obj;
					System.out.println(emp.getEmpno()+"\t"+emp.getEname());
				}
			}
			break;
		//----------------------------------------
		case 2://Display by id
			System.out.println("Enter empno:");
			int empno=Integer.parseInt(scan.nextLine());
			Employee emp1=EmployeeController.displayByEmpno(empno);
			if(emp1==null)
			{
				System.out.println("No records found");
			}
			else
			{
				System.out.println(emp1.getEmpno()+"\t"+emp1.getEname());
			} 
			break;
		case 3://add contact
			System.out.println("Enter employee name:");
			String ename = scan.nextLine();
			System.out.println("Enter salary:");
			float sal=scan.nextFloat();
			System.out.println("Enter depatment number:");
			int dn=Integer.parseInt(scan.nextLine());
			String det=EmployeeController.add(ename,sal,dn);
			
		default: break;
		
			}
		System.out.println("Do u want to continue:1/0");
		 x=Integer.parseInt(scan.nextLine());
		}
	}
}