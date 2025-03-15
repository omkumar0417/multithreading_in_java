package homework;


class Cat 
{
 void printCat(int n) 
 {
     for (int i = 1; i <= 5; i++) 
     {
         System.out.println(n * i);
         try {
             Thread.sleep(400);
         } 
         catch (Exception e) {
             System.out.println(e);
         }
     }
 }
}

class Red extends Thread {
 Cat t;
 Red(Cat t) {
     this.t = t;
 }
 public void run() {
     t.printCat(5);
 }
}

class Apple extends Thread {
 Cat t;
 Apple(Cat t) {
     this.t = t;
 }
 public void run() {
     t.printCat(100);
 }
}

class HariOm {
 public static void main(String args[]) {
     Cat obj = new Cat();
     Red t1 = new Red(obj);
     Apple t2 = new Apple(obj);
     t1.start();
     t2.start();
 }
}

