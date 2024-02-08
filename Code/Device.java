import java.util.Random;

class Device extends Thread {
    private String type;
    private int connectionNumber;
    static Router router;


    public String getType() {
        return type;
    }

    public Device(String name, String type) {
        super(name);
        this.type = type;
    }

    public int getConnectionNumber() {
        return connectionNumber;
    }

    public void setConnectionNumber(int connectionNumber) {
        this.connectionNumber = connectionNumber;
    }

    public void printMessage(Device d, String message) {
        System.out.println("- Connection " + (d.getConnectionNumber() + 1) + ": " + message);
    }

    public void connect() {
        printMessage(this, this.getName() + " login");
    }

    public void perform() {
        printMessage(this, this.getName() + " performs online activity");
    }

    public void logout() {
        printMessage(this, this.getName() + " logged out");
    }


    private void randomWait() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() {
        randomWait();
        connect();

        randomWait();
        perform();

        randomWait();
        logout();

        router.releaseConnection(this);
    }

}