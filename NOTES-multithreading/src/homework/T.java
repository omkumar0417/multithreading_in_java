package homework;

class Dog implements Runnable {
    String m = "RED";
    int n = 1;

    Dog() { }

    Dog(String m, int n) {
        this.m = m;
        this.n = n;
    }

    public void run() {
        int i = 0;
        System.out.println("Hello " + m);
        for (i = 1; i <= n; i++) {
            System.out.println("WELCOME " + m);
            try {
                Thread.sleep(500);
                System.out.println("BY " + m);
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }
        }
        System.out.println("GO " + m);
    }
}

class T {
    public static void main(String k[]) {
        Dog p, q, y;
        int i = 0;
        System.out.println("Hello main");

        p = new Dog("Mango", 3);
        q = new Dog();
        y = new Dog("Hari om", 4);

        Thread t1 = new Thread(y);
        Thread t2 = new Thread(q);
        Thread t3 = new Thread();
        Thread t4 = new Thread(new Dog("Ram Pal", 5));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        for (i = 1; i <= 2; i++) {
            System.out.println("WELCOME main");
            try {
                Thread.sleep(500);
                System.out.println("BY main");
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }
        }
        System.out.println("GO main");
        System.out.println("End main");
    }
}