
import HelloDynamicInvocation.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paul
 */
public class HelloServant implements HelloOperations {

    @Override
    public String sayHello(int audience) {
        System.out.println("Servant has been called with parameter " + audience);

        switch (audience) {
            case 1:
                return "\nHello world !!\n";
            case 2:
                return "\nHello Ireland !!\n";
            case 3:
                return "\nHello Dublin !!\n";
        }
        return "\nSwitch not executed !!\n";

    }
}

