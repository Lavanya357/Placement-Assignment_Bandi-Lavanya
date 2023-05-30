interface Animal
{
	public void sleep();
	public void sound();
}
class Dog implements Animal 
{
	public void sleep()
	{
		System.out.println("Dog sleeping");
	}
	public void sound()
	{
		System.out.println("Dog makes sound");
	}
}
class Cat implements Animal
{
	public void sleep()
	{
		System.out.println("Cat sleeping");
	}
	public void sound()
	{
		System.out.println("Cat makes sound");
	}
}
public class JavaQue5b {

	public static void main(String[] args) {
		Dog d=new Dog();
		Cat c=new Cat();
		d.sleep();
		d.sound();
		c.sleep();
		c.sound();
	}
}
