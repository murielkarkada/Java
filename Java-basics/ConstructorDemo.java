
class Calc1
{
	int num1;
	int num2;
	int result;
	
	public Calc1()
	{
		num1 = 5;
		num2 = 5;
		System.out.println("in constructor");
	}
	public Calc1(int n)
	{
		num1 = n;
		num2 = n;
	}
	public Calc1(double d,int n)
	{
		num1 = (int) d;
		num2 = n;
	}
	
}

public class ConstructorDemo 
{
	public static void main(String[] args)
	{
		Calc1 obj = new Calc1(9.5,8); //Constructor
		
		System.out.println(obj.num1);

	}
}