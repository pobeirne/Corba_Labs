import java.io.*;
import org.omg.CORBA.*;
import HelloNaming.*;
import org.omg.CosNaming.* ;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.PortableServer.*;
import java.util.Properties;

public class HelloNamingServer{

public static void main (String args[]) {
	Properties properties = System.getProperties();
	        properties.put( "org.omg.CORBA.ORBInitialHost",
	            "localhost" );
	        properties.put( "org.omg.CORBA.ORBInitialPort",
	            "1050" );

	try{
	NameComponent nc[] = new NameComponent[1];
	// create and initialize the ORB
	ORB orb = ORB.init(args, properties);
	//Delegation model for creating a servant
	HelloPOA helloRef = new HelloPOATie(new HelloServant());
	org.omg.CORBA.Object objRefPOA = orb.resolve_initial_references("RootPOA");
	POA rootPOA = POAHelper.narrow(objRefPOA);
	org.omg.CORBA.Policy[] policies = {
	rootPOA.create_lifespan_policy(LifespanPolicyValue.PERSISTENT),
	rootPOA.create_id_assignment_policy(IdAssignmentPolicyValue.USER_ID)};

	byte[] objID = "MyPOA".getBytes();
	  /**
	 * This operation creates a new POA as a child of the
	 * target POA.
	 * @param adapter_name identifies the new POA with
	 *        respect to other POAs with the same parent POA.
	 * @param a_POAManager specifies the POA Manager to be
	 *        associated with the new POA.
	 * @param policies specifies policy objects to be
	 *        associated with the POA to control its behavior.
	 * @exception AdapterAlreadyExists specifies that the
	 *            target POA already has a child POA with
	 *            the specified name.
	 * @exception InvalidPolicy is raised if any of the
	 *            policy objects are not valid for the ORB,
	 *            or are in conflict, or require an
	 *            administrative action that has not been
	 *            performed.
	 */
	//  org.omg.PortableServer.POA create_POA (String adapter_name, org.omg.PortableServer.POAManager a_POAManager, org.omg.CORBA.Policy[] policies) throws org.omg.PortableServer.POAPackage.AdapterAlreadyExists, org.omg.PortableServer.POAPackage.InvalidPolicy;

	POA myPOA = rootPOA.create_POA("MyPOA", rootPOA.the_POAManager(), policies);
	/**
	 * This operation enters an association between the
	 * specified Object Id and the specified servant in the
	 * Active Object Map.
	 * @param id object id for the object to be activated.
	 * @param p_servant servant to be associated with the
	 *                  object.
	 * @exception ServantAlreadyActive raised if the POA
	 *            has the UNIQUE_ID policy and the servant
	 *            is already in the Active Object Map.
	 * @exception ObjectAlreadyActive raised if the object is
	 *            already active in the POA.
			 * @exception WrongPolicy raised if the RETAIN policy is
			 *            is not specified.
			 */
	 // void activate_object_with_id (byte[] id, org.omg.PortableServer.Servant p_servant) throws org.omg.PortableServer.POAPackage.ServantAlreadyActive, org.omg.PortableServer.POAPackage.ObjectAlreadyActive, org.omg.PortableServer.POAPackage.WrongPolicy;

	rootPOA.activate_object_with_id(objID, helloRef);
		/**
		* This operation requires the RETAIN policy and either
		* the UNIQUE_ID or IMPLICIT_ACTIVATION policies if
		* invoked outside the context of an operation dispatched
		* by this POA. It has four possible behaviors.
		* 1. If the POA has both the RETAIN and the
		* UNIQUE_ID policy and the specified servant is active,
		* an object reference encapsulating the information used
		* to activate the servant is returned.
		* 2. If the POA has both the RETAIN and the
		* IMPLICIT_ACTIVATION policy and either the POA has the
		* MULTIPLE_ID policy or the specified servant is not
		* active, the servant is activated using a POA-generated
		* Object Id and the Interface Id associated with the
		* servant, and a corresponding object reference is
		* returned.
		* 3. If the operation was invoked in the context of
		* executing a request on the specified servant, the
		* reference associated with the current invocation
		* is returned.
		* 4. Otherwise, the ServantNotActive exception is raised.
		*
		* @param p_servant servant for which the object reference
		*                  needs to be obtained.
		* @return object reference associated with the servant.
		* @exception WrongPolicy if the operation is not invoked
		*            in the context of executing a request on
		*            the specified servant and the required
		*            policies are not present.
		* @exception ServantNotActive if the above specified
		*            policies and rules are not met.
		*/
		 //org.omg.CORBA.Object servant_to_reference (org.omg.PortableServer.Servant p_servant) throws org.omg.PortableServer.POAPackage.ServantNotActive, org.omg.PortableServer.POAPackage.WrongPolicy;

	org.omg.CORBA.Object ServantObjectRef = rootPOA.servant_to_reference(helloRef);

	//You need to locate the naming service. The naming serivce helps you locate other objects.
	//The CORBA orb lets you locate certain services by name. The call
	//String[] services = orb.list_initial_services();
	//lists the names of the standard servicesthat the ORB canconnect to. The Naming service
	//has the standard name NameService. To obtain an object reference to the service you use
	//resolve_initial_reference. It returns a generic CORBA object. Note you have to use
	//org.omg.CORBA.Object otherwise the compiler assumes that you mean java.lang.Object
	org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

	//Next you need to convert this reference into a NamingContext reference
	//so that you can invoke the methods of the NamingContext interface.
	//This is achieved by using the narrow function of the helper class
	NamingContext rootCtx = NamingContextHelper.narrow(objRef);

	//Now that we have the naming context we can use it to place a server object
	//Names are nested sequences of name components. You can use the nesting levels
	//to organize hierarchies of names much like you use directories in a file system.
	//A Name Component consists of an ID and a kind. Teh ID is a name for the component
	//that is unique among all names witht he same parent component. The kind is some indication
	//of the type of the component. Use
	//-"Context" for name components that have nested names; and
	//-"Object" for object names
	nc[0] = new NameComponent("Hello", "Context");
	NamingContext HelloCtx = rootCtx.bind_new_context(nc);

	nc[0] = new NameComponent("World", "Object");
	//NameComponent path[] = {nc};
	//Binding the name to an object that is stored in the Naming Context
	HelloCtx.rebind(nc, ServantObjectRef);

	rootPOA.the_POAManager().activate();

	System.out.println("Server has been started.");
	// wait for invocations from clients
	orb.run();

	} catch (Exception e) {
	System.err.println("Error: "+e);
	e.printStackTrace(System.out);
	}

	}
}