package runner;

import common.TaskHolder;
import pojos.Task;

public class Runner extends Thread{
    
	public void run() {
		while(true) {
			Task task = TaskHolder.getElement();
			if(task!=null) {
				task.runTask();
				task.setLastCompleted(System.currentTimeMillis());
				task.setPresent(false);
			}
		}
		
		
	}
}
