
import HelloOneway.*;

public class HelloOnewayServant implements HelloOperations {

    @Override
    public void sayHello(int audience) {
        switch (audience) {

            case 1: {
                System.out.println("Servant Hello World");
                for (int x = 1; x <= 10000; x++) {
                    System.out.println("Hellow World from the server");
                }
                break;
            }
            case 2: {
                System.out.println("Servant Hello Ireland");
                for (int x = 1; x <= 10000; x++) {
                    System.out.println("Hello Ireland from the server");
                }
            }
            break;
            case 3: {
                System.out.println("Servant Hello Dublin");
                for (int x = 1; x <= 10000; x++) {
                    System.out.println("Hello Dublin from the server");
                }
            }
        }

    }

}
