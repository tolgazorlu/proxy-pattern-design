abstract class Subject
{
 public abstract void doSomeWork();
}
class ConcreteSubject extends Subject
{
 @Override
 public void doSomeWork()
 {
 System.out.println("doSomeWork() inside ConcreteSubject is invoked");
 }
}
class Proxy extends Subject
{
	static Subject cs;
	static int count=0;
	public Proxy()
	{
		cs = new ConcreteSubject();
		count ++;
	}
	@Override
	public void doSomeWork()
	{
		System.out.println("Proxy call happening now...");

		cs.doSomeWork();
	}
}

public class ProxyPatternAlternate {
	public static void main(String[] args) 
	{
		System.out.println("***Proxy Pattern Demo without lazy instantiation***\n");
		Proxy px = new Proxy();
		px.doSomeWork();

		Proxy px2 = new Proxy();
		px2.doSomeWork();
		System.out.println("Instance Count="+Proxy.count);
	}
}