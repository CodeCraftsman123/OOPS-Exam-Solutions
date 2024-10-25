import java.util.Scanner;

class TwoTableThread extends Thread {
    public synchronized void printTable() {
        System.out.println("2's Table:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("2 * " + i + " = " + (2 * i));
            try {
                Thread.sleep(400); // Adding delay of 400 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        printTable();
    }
}

class FiveTableThread extends Thread {
    public synchronized void printTable() {
        System.out.println("5's Table:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("5 * " + i + " = " + (5 * i));
            try {
                Thread.sleep(400); // Adding delay of 400 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        printTable();
    }
}

class DaemonThread extends Thread {
    public DaemonThread() {
        setDaemon(true); // Setting the thread as daemon
    }

    @Override
    public void run() {
        System.out.println("Daemon thread running in the background...");
        try {
            Thread.sleep(2000); // Simulating some background task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Daemon thread completed.");
    }
}

public class Main16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create 5 threads");
            System.out.println("2. Print 2's Table");
            System.out.println("3. Print 5's Table");
            System.out.println("4. Start Daemon Thread");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Creating 5 threads...");
                    for (int i = 0; i < 5; i++) {
                        Thread thread = new Thread(() -> {
                            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
                            try {
                                Thread.sleep(400); 
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Thread " + Thread.currentThread().getId() + " completed");
                        });
                        thread.start();
                        try {
                            thread.join(); 
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    TwoTableThread twoTableThread = new TwoTableThread();
                    twoTableThread.start();
                    try {
                        twoTableThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    FiveTableThread fiveTableThread = new FiveTableThread();
                    fiveTableThread.start();
                    try {
                        fiveTableThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    DaemonThread daemonThread = new DaemonThread();
                    daemonThread.start();
                   try {
                            daemonThread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
