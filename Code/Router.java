import java.util.ArrayList;
import java.util.Collections;

class Router {
    Semaphore counter;
    private ArrayList<Device> connections;
    private ArrayList<Boolean> isAvailable;

    int N;

    public Router(int N) {
        this.N = N;
        connections = new ArrayList<>(Collections.nCopies(N, null));
        isAvailable = new ArrayList<>(Collections.nCopies(N, true));
        counter = new Semaphore(N);
    }

    public int getFirstAvailable() {
        for (int i = 0; i < N; i++) {
            if (isAvailable.get(i))
                return i;
        }
        return -1;
    }

    public void addConnection(Device d) {
        counter.waitP(d.getName(), d.getType());

        int index = getFirstAvailable();

        d.setConnectionNumber(index);
        connections.set(index, d);
        isAvailable.set(index, false);

        System.out.println("- Connection " + (index + 1) + ": " + d.getName() + " Occupied");

        d.start();
    }

    public void releaseConnection(Device d) {
        counter.signalV();
        connections.set(d.getConnectionNumber(), null);
        isAvailable.set(d.getConnectionNumber(), true);
        d.setConnectionNumber(-1);
    }
}
