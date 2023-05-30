class Parent
{
	public Parent()
	{
		System.out.println("Parent class constructor");
	}
	void disp()
	{
		System.out.println("Parent");
		
	}
}
class Child extends Parent
{
	public Child()
	{
		super();
		System.out.println("child class constructor");
	}
	void disp1()
	{
		System.out.println("child");
	}
}
public class JavaQue2 {

	public static void main(String[] args) {
		Child c=new Child();
		c.disp();
		c.disp1();
	}
}
