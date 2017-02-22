
public class DueDateSortStrategy implements TaskSortingStrategy {

	@Override
	public int compare(Task t1, Task t2) {
		return t1.getDueDate().compareTo(t2.getDueDate());
	}

}
