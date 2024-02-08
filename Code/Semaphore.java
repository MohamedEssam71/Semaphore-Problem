class Semaphore {
    private int value;

    protected Semaphore() {
        value = 0;
    }

    protected Semaphore(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public synchronized void waitP(String name, String type) {
        value--;
        if (value < 0) {
            System.out.println("- (" + name + ") (" + type + ") arrived and waiting");
            try {
                wait();
            } catch (InterruptedException e) {

            }
        } else System.out.println("- (" + name + ") (" + type + ") arrived");
    }

    public synchronized void signalV() {
        value++;
        if (value <= 0) {
            notify();
        }
    }
}