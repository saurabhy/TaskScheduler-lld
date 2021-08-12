package common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import pojos.Task;

public class TaskHolder {
	
	 // list to hold the task
     private static List<Task> tasks = null;
     
     // lock for write
     private static Object writeLock = new Object();
     
     private static SynchronousQueue<Task> taskQ = new SynchronousQueue<>();
     
     private TaskHolder() {
    	 
     }
     
     public static List<Task> getTasks(){
    	 if(tasks ==null) {
    		 tasks = new ArrayList<>();
    	 }
    	 return tasks;
     }
     
     public static void addtask(Task t) {
    	 synchronized(writeLock) {
    		 getTasks().add(t);
    	 }
     }
     
     public static void addElement(Task t1) {
    	 try {
			taskQ.put(t1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
     }
     
     public static Task getElement() {
    	 try {
			return taskQ.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
     }
}
