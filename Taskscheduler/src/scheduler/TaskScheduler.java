package scheduler;

import java.util.List;

import common.TaskHolder;
import pojos.FixTimeTask;
import pojos.IntervalTask;
import pojos.Task;

public class TaskScheduler extends Thread{
    
	private static long day=24*60*60*1000;
	
	public void run() {
		while(true) {
			List<Task> tasks = TaskHolder.getTasks();
			for(int i=0;i<tasks.size();i++) {
				if(tasks.get(i).getType()==1) {
					//System.out.println(tasks.get(i).getName()+" "+((FixTimeTask)tasks.get(i)).getTimeScheduled());
					checkType1(tasks.get(i));
				}
				else if(tasks.get(i).getType()==2) {
					//System.out.println(tasks.get(i).getName()+" "+tasks.get(i).getLastStarted());
					checkType2(tasks.get(i));
				}
			}
		} 
	}

	private void checkType1(Task task) {
		long curTime = System.currentTimeMillis();
		long scheduledTime = ((FixTimeTask)task).getTimeScheduled();
		
		if(curTime>=scheduledTime && !task.isPresent()) {
			//System.out.println("Scheduling task "+task.getName()+" at "+curTime);
			task.setPresent(true);
			task.setLastStarted(curTime);
			((FixTimeTask)task).setTimeScheduled(scheduledTime+day);
			TaskHolder.addElement(task);
		}
		
	}

	private void checkType2(Task task) {
		
		long curTime = System.currentTimeMillis();
		long interval = ((IntervalTask)task).getInterval();
		if(curTime-task.getLastStarted()>=interval && !task.isPresent()) {
			//System.out.println("Scheduling task "+task.getName()+" at "+curTime);
			task.setPresent(true);
			task.setLastStarted(curTime);
			TaskHolder.addElement(task);
		}
	}
	
}
