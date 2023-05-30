import java.util.Scanner;
interface Shape
{
	public static final double pi=3.14;
	public void input();
	public void area();
	public void perimeter();
}
class Circle implements Shape
{
	float radius;
	double area;
	double perimeter;
	public void input()
	{ 
		System.out.println("Enter the radius of a circle");
		Scanner sc=new Scanner(System.in);
		radius=sc.nextFloat();
	}
	public void area()
	{
		area=pi*radius*radius;
		System.out.println("The area of a circle is" +area);
	}
	public void perimeter()
	{
		perimeter=2*pi*radius;
		System.out.println("The perimeter of a circle is" +perimeter);
	}
}
class Triangle implements Shape
{
	float a,b,c,s;
	double area;
	double perimeter;
	public void input()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the side a of a triangle");
		a=sc.nextFloat();
		System.out.println("Enter the side b of a triangle");
		b=sc.nextFloat();
		System.out.println("Enter the side c of a triangle");
		c=sc.nextFloat();
		s=a+b+c/2;
	}
	public void area()
	{
		area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
		System.out.println("The area of a triangle is" +area);
	}
	public void perimeter()
	{
		perimeter=a+b+c;
		System.out.println("The perimeter of a triangle is" +perimeter);
	}
}
class Geometry
{
	void permit(Shape s)
	{
		s.input();
		s.area();
		s.perimeter();
	}
}
public class JavaQue1 {

	public static void main(String[] args) {
		Circle c=new Circle();
		Triangle t=new Triangle();
		Geometry g=new Geometry();
		
		g.permit(c);
		g.permit(t);
	}
}
