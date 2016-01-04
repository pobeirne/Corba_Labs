
import AnyExample.Time;
import AnyExample.TimeHelper;
import AnyExample.TimeOfDayOperations;
import java.util.Date;
import org.omg.CORBA.Any;
import org.omg.CORBA.AnyHolder;
import org.omg.CORBA.DATA_CONVERSION;
import org.omg.CORBA.MARSHAL;
import org.omg.CORBA.ORB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author paul
 */
public class TimeOfDayImpl implements TimeOfDayOperations{
    
    private final String location ;    
    private final ORB orb ;  

    public TimeOfDayImpl(ORB orb, String location) {
        this.orb = orb ;       
        this.location = location ; 
    }

    @Override
    public Any hello(AnyHolder anyTime) {

        Any l = null, t;
        try {
            Date date = new Date();
            //Instantiating the class Time (IDL - Struct)   
            Time tStruct = new Time(date.getHours(), date.getMinutes());

            //Create Any  
            l = orb.create_any();

            //Insert String  
            l.insert_string(location);

            t = orb.create_any();

            //Inserting a class tstruct into the any  
            TimeHelper.insert(t, tStruct);

            //Inserting the any into an AnyHolder. Used for sending information 
            //back to the client as a parameter in the operation call.  
            anyTime.value = t;
        } catch (DATA_CONVERSION | MARSHAL e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
        return l;
    }
}
