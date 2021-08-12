package pojos;

public abstract class Task {
   private int id;
   private String name;
   private int type;
   private boolean isPresent;
   private long lastCompleted;
   private long lastStarted;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public boolean isPresent() {
	return isPresent;
}
public void setPresent(boolean isPresent) {
	this.isPresent = isPresent;
}
public long getLastCompleted() {
	return lastCompleted;
}
public void setLastCompleted(long lastCompleted) {
	this.lastCompleted = lastCompleted;
}
public long getLastStarted() {
	return lastStarted;
}
public void setLastStarted(long lastStarted) {
	this.lastStarted = lastStarted;
}
public abstract void runTask();
}
