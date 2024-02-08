import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Network {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        /*
            2
            2
            C1 Mobile
            C2 Pc

            3
            4
            C1 Mobile
            C2 Pc
            C3 Tablet
            C4 laptop
         */

        System.out.println("What is the number of WI-FI Connections?");
        int N = sc.nextInt();
        sc.nextLine();

        System.out.println("What is the number of devices Clients want to connect?");
        int TC = sc.nextInt();
        sc.nextLine();


        Router router = new Router(N);
        Device.router = router;
        ArrayList<Device> devices = new ArrayList<>();

        for (int i = 1; i <= TC; ++i) {
            System.out.println("Enter device " + i + " name and type: ");
            String name = sc.next();
            String type = sc.next();
            devices.add(new Device(name, type));
        }


        PrintStream out = new PrintStream(new FileOutputStream("log.txt"));
        System.setOut(out);

        for (int i = 0; i < TC; ++i) {
            router.addConnection(devices.get(i));
        }

    }
}