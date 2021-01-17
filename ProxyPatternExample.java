//package jdp2e.proxy.demo;

abstract class Subject
{
	public abstract void doSomeWork();
}
	// ConcreteSubject class
class ConcreteSubject extends Subject
{
	@Override
	public void doSomeWork()
	{
	System.out.println("doSomeWork() inside ConcreteSubject is invoked.");
	}
}

class Proxy extends Subject
{
	static Subject cs;
	@Override
	public void doSomeWork()
	{
	System.out.println("Proxy call happening now...");
	 
	if (cs == null)
	{
	cs = new ConcreteSubject();
	}
	cs.doSomeWork();
	}
}
public class ProxyPatternExample {
public static void main(String[] args) {
	System.out.println("***Proxy Pattern Demo***\n");
	Proxy px = new Proxy();
	px.doSomeWork();
	}
}