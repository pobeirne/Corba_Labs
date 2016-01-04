import HelloWorldTieApp.*;
import org.omg.CORBA.*;
import java.util.Date;
import java.io.*;
import java.net.*;

class HelloInterfaceServant implements HelloWorldInterfaceOperations{

	public String sayHelloMethod(){
		return "Hello";

	}
}