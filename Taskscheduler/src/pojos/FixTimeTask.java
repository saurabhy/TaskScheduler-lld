package pojos;

public class FixTimeTask extends Task{
	
   private long timeScheduled;
   
   private FixTimeTask() {
	   
   }
   public long getTimeScheduled() {
	  return timeScheduled;
   }
   public void setTimeScheduled(long timeScheduled) {
	  this.timeScheduled = timeScheduled;
   }
   public FixTimeTask(long time,int id, String name) {
	   this.timeScheduled=time;
	   this.setId(id);
	   this.setName(name);
	   this.setType(1);
   }
   
   @Override
   public void runTask() {
	   System.out.println("Running task with id = "+this.getId()+" name = "+this.getName()+" at time = "+System.currentTimeMillis());
   }
}
