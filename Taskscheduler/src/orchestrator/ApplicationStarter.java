package orchestrator;

import common.TaskHolder;
import pojos.FixTimeTask;
import pojos.IntervalTask;
import runner.Runner;
import scheduler.TaskScheduler;

public class ApplicationStarter {
    
	private static int runnerCount = 2;
	public static void main(String [] args) {
		
		// for initialising list of task
		TaskHolder.getTasks();
		
		TaskScheduler taskScheduler = new TaskScheduler();
		
		// for starting producer in queue
		taskScheduler.start();
		
		// for starting consumer
		for(int i=0;i<runnerCount ;i++) {
			Runner runner = new Runner();
			runner.start();
		}
		
		FixTimeTask task1 = new FixTimeTask(System.currentTimeMillis()+5000,1,"type 1 running after every 5 sec");
		IntervalTask task2 = new IntervalTask(10000,2,"type 2 running after every 10 sec");
		IntervalTask task3 = new IntervalTask(20000,3,"type 2 running after every 20 sec");
		
		TaskHolder.addtask(task1);
		TaskHolder.addtask(task2);
		TaskHolder.addtask(task3);
		
	}
}
