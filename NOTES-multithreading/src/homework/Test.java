package homework;

class Customer {
    int amount = 10000;

    synchronized void withdraw(int amount) {
        System.out.println("going to withdraw...");

        if (this.amount < amount) {
            System.out.println("Less balance; waiting for deposit...");
            try {
                wait();
                System.out.println("check");
            } catch (Exception e) {
            }
        }
        this.amount -= amount;
        System.out.println("withdraw completed...");
    }

    synchronized void deposit(int amount) {
        System.out.println("going to deposit...");
        this.amount += amount;
        System.out.println("deposit completed...");
        notify();
    }
}

class Test {
    public static void main(String args[]) {
        final Customer c = new Customer();

        new Thread() {
            public void run() {
                c.withdraw(15000);
            }
        }.start();

        new Thread() {
            public void run() {
                c.deposit(10000);
            }
        }
        .start();
    }
}





// some key notes
/*
There is no difference between .start and start in Java. However, if you're asking about start() vs. .start();, here’s the explanation:

1. start() (without a dot in explanation)

start() is a method of the Thread class.

It is used to begin the execution of a new thread.

It internally calls the run() method in a separate thread.


2. .start(); (with a dot)

The dot (.) is just the syntax for calling a method on an object.

Example:

Thread t = new Thread();
t.start(); // Calling the start() method

Here, t is an object of Thread, and we call start() using dot notation.


Key Point

.start(); is the correct way to call start(), since in Java, methods are called using dot notation.

start(); alone would be incorrect because it doesn’t specify an object.


Would you like any further clarification?

Anonymous Thread Syntax in Java

An anonymous thread is a thread created without explicitly defining a separate Thread or Runnable class. It is useful for short-lived tasks.


---

1. Using Anonymous Inner Class (Thread)

new Thread() {
    public void run() {
        System.out.println("Thread is running...");
    }
}.start();

✔ Here, we create an anonymous subclass of Thread and override run().


---

2. Using Anonymous Inner Class (Runnable)

new Thread(new Runnable() {
    public void run() {
        System.out.println("Thread is running...");
    }
}).start();

✔ This approach is preferred when we already extend another class, since Java doesn't support multiple inheritance.


---

3. Using Lambda Expression (Java 8+)

new Thread(() -> System.out.println("Thread is running...")).start();

✔ The shortest syntax using a lambda function (only for functional interfaces like Runnable).

Would you like an example using a real-world scenario?


*
*
*
*
*
*
*
*
*
*
*
*
*/