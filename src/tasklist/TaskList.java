package tasklist;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class TaskList {
	
	private ArrayList<Task> tasks;
	
	TaskList()
	{
		this.tasks = new ArrayList<Task>();
	}
	
	public void add(Task t)
	{
		this.tasks.add(t);
	}
	
	public void remove(Task t)
	{
		this.tasks.remove(t);
	}
	
	public ArrayList<Task> getOpenTasks()
	{
		return (ArrayList<Task>) this.tasks.stream().filter(t -> t.isOpen()).collect(Collectors.toList());
	}
	
	public ArrayList<Task> getTasksForDescription(final String description)
	{
		return (ArrayList<Task>) this.tasks.stream().filter(t -> t.getDescription().equals(description)).collect(Collectors.toList());		
	}
	
	public ArrayList<Task> getTasksUntilDueDate(final Date dueDate)
	{
		return (ArrayList<Task>) this.tasks.stream().filter(t -> t.getDueDate().before(dueDate)).collect(Collectors.toList());
	}
	
	public void sortTasksBy(TaskSortingStrategy sortStrategy)
	{
		this.tasks.sort(sortStrategy);
	}
	
	public void saveToDisk(Path path, SimpleDateFormat sdf)
	{
		Iterator<Task> it = this.tasks.iterator();
		StringBuilder builder = new StringBuilder();
		builder.append("Description\tState\tRepeat Every\tDue Date\n");
		while(it.hasNext())
		{
			Task t = it.next();
			builder.append(t.getDescription());
			builder.append("\t");
			if(t.isOpen())
			{
				builder.append("Open\t");
			}
			else
			{
				builder.append("Closed\t");
			}
			if(t.isRepetitive())
			{
				builder.append(String.valueOf(t.getRepeatDay()));
				builder.append("\t");
			}
			else
			{
				builder.append("Nope\t");
			}
			builder.append(sdf.format(t.getDueDate()));
			builder.append("\n");
		}
		try {
			Files.write(path, builder.toString().getBytes());
		} catch (IOException e) {
			// literally unable to can
			e.printStackTrace();
		}

	}

}
