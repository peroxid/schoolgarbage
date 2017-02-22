package tasklist;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Runner {

	public static void main(String[] args) throws InterruptedException, ParseException {
		TaskList myTaskList = new TaskList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Task task1 = new Task("a task", sdf.parse("2017-01-01 22:00"));
		Task task2 = new Task("b task", sdf.parse("2017-01-02 13:00"));
		Task task3 = new Task("c task", sdf.parse("2016-10-10 09:00"));
		task1.setRepetitive(true, Task.REPEATEVERY.MONDAY);


		myTaskList.add(task1);
		myTaskList.add(task2);
		myTaskList.add(task3);
		myTaskList.add(task2);
		myTaskList.add(task2);
		task2.close();
		myTaskList.add(task2);
		myTaskList.add(task1);
		myTaskList.add(task2);
		myTaskList.add(task3);
		myTaskList.add(task1);
		myTaskList.add(task2);
		myTaskList.add(task3);
		task3.close();
		myTaskList.add(task1);
		myTaskList.add(task2);
		myTaskList.add(task3);
		
		myTaskList.saveToDisk(Paths.get("tasks_as_added"), sdf);
		myTaskList.sortTasksBy(new DueDateSortStrategy());
		myTaskList.saveToDisk(Paths.get("sorted_by_due_date"), sdf);
		myTaskList.sortTasksBy(new StatusSortStrategy());
		myTaskList.saveToDisk(Paths.get("sorted_by_due_date_and_status"), sdf);
		
	}

}
