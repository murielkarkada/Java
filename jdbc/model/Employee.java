package model;

public class Employee
{
	private int empno;
	private String ename;
	private float sal;
	private int dno;
	public Employee(int empno,String ename,float sal, int dno)
	{
		this.empno=empno;this.ename=ename;this.sal=sal;this.dno=dno;
	}
	public Employee(String ename,float sal, int dno)
	{
		this.ename=ename;this.sal=sal;this.dno=dno;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public int getEmpno() {
		return empno;
	}
	
	
	
	
	
	
	
	
	
	
}

