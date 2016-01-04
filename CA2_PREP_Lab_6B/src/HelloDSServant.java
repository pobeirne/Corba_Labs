
import HelloDeferredSynchronous.*;

public class HelloDSServant implements HelloOperations {

    @Override
    public String sayHello(int audience) {
        switch (audience) {

            case 1:
                System.out.println("Servant Hello World");
                return "\nHello world !!\n";
            case 2:
                System.out.println("Servant Hello Ireland");
                return "\nHello Ireland !!\n";
            case 3:
                System.out.println("Servant Hello Dublin");
                return "\nHello Dublin !!\n";
        }
        System.out.println("Parameter not understood.");
        return "\nSwitch not executed !!\n";

    }
}
