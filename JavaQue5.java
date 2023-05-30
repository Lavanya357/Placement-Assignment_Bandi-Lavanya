abstract class Person
{
	abstract public void study();
	abstract public void play();
	public void eat()
	{
		System.out.println("person eats");
	}
}
class Student extends Person
{
	public void study()
	{
		System.out.println("Student study");
	}
	public void play()
	{
		System.out.println("Student plays");
	}
}
public class JavaQue5 {

	public static void main(String[] args) {
		Student s= new Student();
		s.eat();
		s.study();
		s.play();
	}
}
