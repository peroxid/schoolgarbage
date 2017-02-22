package tasklist;

public class StatusSortStrategy implements TaskSortingStrategy {

	@Override
	public int compare(Task t1, Task t2) 
	{
		if(t1.isOpen())
		{
			if(t2.isOpen())
			{
				return 0;
			}
			return -1;
		}
		return 1;
	}
}