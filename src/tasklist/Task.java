package tasklist;
import java.util.Date;

public class Task {

	public enum STATUS { OPEN, CLOSED; }
	public enum REPEATEVERY { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY; }


	private STATUS status;
    private String description;
    private Date dueDate;
    private boolean isRepetitive;
	private REPEATEVERY weekday;

	public Task(String description, Date dueDate) {
		super();
		this.description = description;
		this.dueDate = dueDate;
		this.status = Task.STATUS.OPEN;
		this.isRepetitive = false;
	}

    public boolean isRepetitive() {
		return isRepetitive;
	}

    public REPEATEVERY getRepeatDay()
    {
    	return this.weekday;
    }

	public void setRepetitive(boolean isRepetitive, 	REPEATEVERY weekday) {
		if(isRepetitive)
		{
			if(weekday == null)
			{
				throw new RuntimeException("weekday must not be null when setting up repetitiveness");
			}
			this.isRepetitive = isRepetitive;
			this.weekday = weekday;
		}
		else
		{
			this.isRepetitive = isRepetitive;
			this.weekday = null;
		}
	}

	public boolean isOpen() {
		return this.status == Task.STATUS.OPEN;
	}
	public void close() {
		this.status = Task.STATUS.CLOSED;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
}
