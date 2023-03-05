package trackr.model;

import javafx.collections.ObservableList;
import trackr.model.task.Task;

/**
 * Unmodifiable view of a task list.
 */
public interface ReadOnlyTaskList {

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate persons.
     */
    ObservableList<Task> getTaskList();

}
