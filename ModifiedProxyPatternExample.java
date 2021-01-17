import java.util.ArrayList;
import java.util.List;

abstract class Subject
{
	public abstract void doSomeWork();
}

class ConcreteSubject extends Subject
{
	@Override
	public void doSomeWork()
	{
		System.out.println("doSomeWork() inside ConcreteSubject is invoked.");
	}
}
class ModifiedProxy extends Subject
{
	/*Chapter 1*/
	static Subject cs;
	String currentUser;
	List<String> registeredUsers;
	
	/*Chapter 2*/
	public ModifiedProxy(String currentUser)
	{
		registeredUsers = new ArrayList<String>();
		registeredUsers.add("Admin");
		registeredUsers.add("Rohit");
		registeredUsers.add("Sam");
		this.currentUser = currentUser;
	}
	
	/*Chapter 3*/
	@Override
	public void doSomeWork()
	{
		System.out.println("\n Proxy call happening now...");
		System.out.println(currentUser+" wants to invoke a proxy method.");
		if (registeredUsers.contains(currentUser))
		{
	 
			if (cs == null)
			{
				cs = new ConcreteSubject();
			}
 
			cs.doSomeWork();
		}
		else
		{
			System.out.println("Sorry "+ currentUser+ " , you do not have access rights.");
		}
	}
}

public class ModifiedProxyPatternExample 
{
	public static void main(String[] args) 
	{
		System.out.println("***Modified Proxy Pattern Demo***\n");
		ModifiedProxy px1 = new ModifiedProxy("Admin");
		px1.doSomeWork();
		ModifiedProxy px2 = new ModifiedProxy("Robin");
		px2.doSomeWork();
	}
}