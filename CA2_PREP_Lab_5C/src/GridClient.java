import GridWorld.* ;
import org.omg.CORBA.* ;
import java.io.* ;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

public class GridClient {

	public static void main(String[] args) {
	try{ ORB orb = ORB.init(args, null);

		org.omg.CORBA.Object nameObj=orb.resolve_initial_references("NameService");

		NamingContext rootCtx=NamingContextHelper.narrow(nameObj);
		NameComponent[] name = new NameComponent[1];
		name[0] = new NameComponent("POA", "Obj");
		Grid g = GridHelper.narrow(rootCtx.resolve(name));

		System.out.println("rows " + g.rows());
		System.out.println("columns " + g.columns());
		g.set(23,23,43) ;
		int value = g.get(23,23) ;
		System.out.println( "Val returned(should be 43)" + value) ;
		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
			}
	}
}