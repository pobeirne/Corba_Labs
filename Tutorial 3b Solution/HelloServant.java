import HelloNaming.*;

class HelloServant implements HelloOperations
{
    public String sayHello()
    {
		System.out.println("Received a client call.");
		return "\nHello world !!\n";
    }
}
