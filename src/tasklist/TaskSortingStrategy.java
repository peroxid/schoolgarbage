package tasklist;
import java.util.Comparator;

public interface TaskSortingStrategy extends Comparator<Task> {
	
	public int compare(Task t1, Task t2);

}
