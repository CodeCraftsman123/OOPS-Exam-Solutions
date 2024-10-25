// create a thread 
class MyThread extends Thread{
	public void run() {
					System.out.println("User defind thread");
	}
}
public class Ex1 {

	public static void main(String[] args) {//main thread
		MyThread t = new MyThread();
		t.start();//thread 0
		
			System.out.println("Main thread");

	}

}

	//creating multiple threads
	class MultithreadingDemo extends Thread {
	
		public void run()
		{
			try {
	// Displaying the thread that is running
	System.out.println(
			"Thread " + Thread.currentThread().getId()
			+ " is running");
			}
			catch (Exception e) {
				// Throwing an exception
				System.out.println("Exception is caught");
			}
		}
	}
//creating thread using runnable interface
	
	public class Multiple_threads {
		public static void main(String[] args) throws InterruptedException
		{
			int n = 5; // Number of threads
			for (int i = 0; i < n; i++) {
				MultithreadingDemo object
					= new MultithreadingDemo();
				object.start();
	}
			System.out.println("Count :"+Thread.activeCount());
		}
	}





public class UsingRunnable_interface implements Runnable
{
	 public void run()
	 {
	 System.out.println(" userdefined thread running ");
	 }
	
	 public static void main(String[] args) throws InterruptedException
	 {
	  System.out.println("Main thread running ");	 

	// UsingRunnable_interface r = new UsingRunnable_interface();
	 //OR
	  Runnable r = new UsingRunnable_interface();
	  Thread t=new Thread(r);
	  t.start(); 
	  
	 }
	}

//Different threads executing same application/task
class MyThread extends Thread{
	public void run() {
		for(int i=0;i<3;i++)
			System.out.println("User defind thread");
	}
}
public class Ex1 {

	public static void main(String[] args) {//main thread
		MyThread t1 = new MyThread();
		t1.start();//thread
		
		MyThread t2 = new MyThread();
		t2.start();//thread
		
		MyThread t3 = new MyThread();
		t3.start();//thread
			//System.out.println("Main thread");

	}

}



//Different threads executing different applications/tasks

class MyThread1 extends Thread{
	public void run() {
		for(int i=0;i<3;i++)
			System.out.println("User defind thread 1");
	}
}
class MyThread2 extends Thread{
	public void run() {
		for(int i=0;i<3;i++)
			System.out.println("User defind thread 2");
	}
}
class MyThread3 extends Thread{
	public void run() {
		for(int i=0;i<3;i++)
			System.out.println("User defind thread 3");
	}
}
public class Ex1 {

	public static void main(String[] args) {//main thread
		MyThread1 t1 = new MyThread1();
		t1.start();//thread
		
		MyThread2 t2 = new MyThread2();
		t2.start();//thread
		
		MyThread3 t3 = new MyThread3();
		t3.start();//thread
			//System.out.println("Main thread");

	}

}






//thread Priority
class MyThreadEx extends Thread{
	public void run() {
		System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getPriority());
	}
}
public class Ex3 {

	public static void main(String[] args) {
		MyThreadEx t1 = new MyThreadEx();
		t1.setPriority(Thread.MAX_PRIORITY);
		
		MyThreadEx t2 = new MyThreadEx();
		
		t1.start();
		t2.start();
		
		
	}

}




//Methods 
class MyThreadEx extends Thread{
	public void run() {
		
	}
}
public class Ex3 {

	public static void main(String[] args) {
		MyThreadEx t1 = new MyThreadEx();
		t1.start();
		
		MyThreadEx t2 = new MyThreadEx();
		t2.start();
		
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		t1.setName("Harshal");
		System.out.println(t1.getName());
		
		System.out.println(Thread.currentThread().getName());
		Thread.currentThread().setName("Ämey");
		System.out.println(Thread.currentThread().getName());
		
		System.out.println(t1.getId());
		System.out.println(t2.getId());
		
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
		
		System.out.println(Thread.activeCount());
	}

}
//Deamon thread
class MyThreadEx extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Deamon thread");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}
public class Ex3 {

	public static void main(String[] args) {
		MyThreadEx t1 = new MyThreadEx();
		
		t1.setDaemon(true);
		t1.start();
		for(int i=0;i<3;i++) {
			System.out.println("Main thread");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			}
		}
		
		
	}


//Using runnable interface
class MyThreadEx implements Runnable{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Deamon thread");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}
public class Ex3 {

	public static void main(String[] args) {
		Runnable r = new MyThreadEx();
		Thread t1 = new Thread(r);
		
		t1.setDaemon(true);
		t1.start();
		for(int i=0;i<3;i++) {
			System.out.println("Main thread");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			}
		}
		
		
	}



//Without synchronization 

class Create {
 void  printTable(int n) // Here, method is not synchronized.
		{
		for(int i = 1; i <= 5; i++)
			{  
				System.out.println(n * i);  
					try
						{  
							Thread.sleep(1000);  
						}
					catch(InterruptedException ie)
						{
							System.out.println(ie);
						}  
			}
		}  
}
class Thread1 extends Thread
{
	Create  t; // Declaration of variable t of class type Table.

// Declare one parameterized constructor and pass variable t as a parameter.
	Thread1(Create  t)
	{  
		this.t = t;  
	}	  
	public void run()
	{  
		t.printTable(2);  
	}  
}
 class Thread2 extends Thread
{
	 Create  t;  
	 Thread2(Create  t)
	 {  
		 this.t = t;  
	 }  
	 public void run()
	 {  
		 t.printTable(5);  
	 }  
}
public class Ex1
{
public static void main(String[] args) 
{
// Create an object of class Table.	
	Create  obj = new Create ();
    Thread1 t1 = new Thread1(obj);
    Thread2 t2 = new Thread2(obj);
      t1.start(); 
      t2.start();
 }
}


//with synchronization using synchronized method

class Create {
 synchronized void  printTable(int n) // Here, method is not synchronized.
		{
		for(int i = 1; i <= 5; i++)
			{  
				System.out.println(n * i);  
					try
						{  
							Thread.sleep(1000);  
						}
					catch(InterruptedException ie)
						{
							System.out.println(ie);
						}  
			}
		}  
}
class Thread1 extends Thread
{
	Create  t; // Declaration of variable t of class type Table.

// Declare one parameterized constructor and pass variable t as a parameter.
	Thread1(Create  t)
	{  
		this.t = t;  
	}	  
	public void run()
	{  
		t.printTable(2);  
	}  
}
 class Thread2 extends Thread
{
	 Create  t;  
	 Thread2(Create  t)
	 {  
		 this.t = t;  
	 }  
	 public void run()
	 {  
		 t.printTable(5);  
	 }  
}
public class Ex1
{
public static void main(String[] args) 
{
// Create an object of class Table.	
	Create  obj = new Create ();
    Thread1 t1 = new Thread1(obj);
    Thread2 t2 = new Thread2(obj);
      t1.start(); 
      t2.start();
 }
}



//synchronized block
class t1
{
  void printTable(int x)
 {
    synchronized(this) // Synchronized block.
   {
    for(int i = 1; i <= 3; i++)
    {  
       System.out.println(x * i);  
      try
     {  
         Thread.sleep(400);  
     }
    catch(InterruptedException ie)
   {
       System.out.println(ie);
   }  
 }}
}  
}
class Thread11 extends Thread
{
  t1 t;
  Thread11(t1 t)
 {
    this.t = t;	
  }
public void run()
{  
     t.printTable(2);
 }  
}
 class Thread12 extends Thread
{
  t1 t;
  Thread12(t1 t)
  {
      this.t = t;	
   }	
public void run()
{  
    t.printTable(10); 
 }  
}
public class syncBlockEx
{
public static void main(String[] args) 
{
   t1 t = new t1();	
   Thread11 t1 = new Thread11(t);
   Thread12 t2 = new Thread12(t);
     t1.start(); 
     t2.start();
   }
}


//deadlock
class X 
{
void display1(X obj2)
{
 System.out.println("Thread1 waiting for thread2 to release lock");
 synchronized(obj2){
  System.out.println("work done"); 
 }
 }
void display2(X obj1)
{
 System.out.println("Thread2 waiting for thread1 to release lock");
 synchronized(obj1){
   System.out.println("work done"); 
  }
 } 
}
 class Thread51 extends Thread
{
 X obj1, obj2;
 Thread51(X obj1, X obj2)
 {
   this.obj1 = obj1;
   this.obj2 = obj2;
 }
public void run()
{
 synchronized(obj1){
  try {
	Thread.sleep(2000);  
  }
catch(InterruptedException ie) {
 System.out.println(ie);	
}
obj2.display2(obj2);  
  }
}
}
 class Thread52 extends Thread 
{
X obj1, obj2;
Thread52(X obj1, X obj2)
{
 this.obj1 = obj1;
 this.obj2 = obj2;
}
public void run()
{
synchronized(obj2){
try {
 Thread.sleep(2000);  
}
catch(InterruptedException ie) {
  System.out.println(ie);	
  }
obj1.display1(obj1);
 }
}
}
public class DeadlockEx {
public static void main(String[] args) 
{
X obj1 = new X();
X obj2 = new X();

Thread51 t1 = new Thread51(obj1, obj2);
Thread52 t2 = new Thread52(obj1, obj2);
  t1.start();
  t2.start();
 }
}


//without inter thread communication
class A1 
{
	 int i;	
	 synchronized void deliver(int i)
 	{
		 this.i = i;	 
		 System.out.println("Data Delivered: " +i);	 
 	}
	 synchronized int receive()
	 {
		 System.out.println("Data Received: " + i); 
		 return i;
	 }
}
 class Thread31 extends Thread
	{
	 	A1 obj;
	 	Thread31(A1 obj)
	 	{
	 			this.obj = obj;
	 	}
	 	public void run()
	 	{
	 		for(int j = 1; j <= 5; j++){
	 			obj.deliver(j); 	
	 		}
	 	}
}
class Thread32 extends Thread 
{
		A1 obj;
		Thread32(A1 obj)
		{
			this.obj = obj;
		}
		public void run()
		{
			for(int k = 0; k <= 5; k++){
				obj.receive();	
			}
		}
}
public class NoCommunication 
{
	public static void main(String[] args) 
	{
		A1 obj = new A1();
		Thread31 t1 = new Thread31(obj);
		Thread32 t2 = new Thread32(obj);
		t1.start();
		t2.start();
	}
}
//with inter thread communication
// In this program, we will understand how to use wait and notify.
// It is the most efficient way for thread communication.
 class A12 
{
 int i;	
 boolean flag = false; // flag will be true when data production is over.
synchronized void deliver(int i)
{
 if(flag)
 try
 {
  wait(); // Wait till a notification is received from Thread2. There will be no wastage of time.	 
 }
 catch(InterruptedException ie)
 {
  System.out.println(ie);	 
 }
   this.i = i;	
   flag = true; // When data production is over, it will store true into flag.
   System.out.println("Data Delivered: " +i);
   notify(); // When data production is over, it will notify Thread2 to use it.
   try {Thread.sleep(1000);}catch(InterruptedException e) {System.out.println(e);}
 }
synchronized int receive()
{
if(!flag)
try {
 wait(); // Wait till a notification is received from Thread1.	
}
catch(InterruptedException ie){
 System.out.println(ie);	
}
 System.out.println("Data Received: " + i); 
  flag = false; // It will store false into flag when data is received.
  notify(); // When data received is over, it will notify Thread1 to produce next data.
  try {Thread.sleep(1000);}catch(InterruptedException e) {System.out.println(e);}
  return i;
 }
}
 class Thread41 extends Thread
{
 A12 obj;
 Thread41(A12 obj)
 {
  this.obj = obj;
 }
public void run()
{
for(int j = 1; j <= 5; j++){
 obj.deliver(j); 	
  }
}}
 class Thread42 extends Thread 
{
A12 obj;
Thread42(A12 obj)
{
 this.obj = obj;
}
public void run()
{
for(int k = 0; k <= 5; k++){
 obj.receive();	
}
 }}
public class withintercomm 
{
public static void main(String[] args) 
{
 A12 obj = new A12(); // Creating an object of class A.

// Creating two thread objects and pass reference variable obj as parameter to Thread1 and Thread2.
Thread41 t1 = new Thread41(obj);
Thread42 t2 = new Thread42(obj);
// Run both threads.
  t1.start();
  t2.start();
 }
}
