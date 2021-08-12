package pojos;

public class IntervalTask extends Task{
	
	private long interval;

	public long getInterval() {
		return interval;
	}
	
	public IntervalTask(long interval, int id, String name) {
		this.setType(2);
		this.setId(id);
		this.setName(name);
		this.setInterval(interval);
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}

	@Override
	public void runTask() {
		 System.out.println("Running task with id = "+this.getId()+" name = "+this.getName()+ " at time = "+System.currentTimeMillis());
		
	}

}
