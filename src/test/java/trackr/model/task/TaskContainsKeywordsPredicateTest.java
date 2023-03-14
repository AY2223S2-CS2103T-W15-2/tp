package trackr.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import trackr.testutil.TaskBuilder;

public class TaskContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        TaskContainsKeywordsPredicate firstPredicate =
                new TaskContainsKeywordsPredicate(firstPredicateKeywordList);
        TaskContainsKeywordsPredicate secondPredicate =
                new TaskContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        TaskContainsKeywordsPredicate firstPredicateCopy =
                new TaskContainsKeywordsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_taskNameContainsKeywords_returnsTrue() {
        // One keyword
        TaskContainsKeywordsPredicate predicate =
                new TaskContainsKeywordsPredicate(Collections.singletonList("Buy"));
        assertTrue(predicate.test(new TaskBuilder().withTaskName("Buy Food").build()));

        // Multiple keywords
        predicate = new TaskContainsKeywordsPredicate(Arrays.asList("Buy", "Food"));
        assertTrue(predicate.test(new TaskBuilder().withTaskName("Buy Food").build()));

        // Only one matching keyword
        predicate = new TaskContainsKeywordsPredicate(Arrays.asList("Buy", "Flour"));
        assertTrue(predicate.test(new TaskBuilder().withTaskName("Buy Food").build()));

        // Mixed-case keywords
        predicate = new TaskContainsKeywordsPredicate(Arrays.asList("BUy", "FlOuR"));
        assertTrue(predicate.test(new TaskBuilder().withTaskName("Buy Flour").build()));
    }

    @Test
    public void test_taskNameDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        TaskContainsKeywordsPredicate predicate = new TaskContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new TaskBuilder().withTaskName("Buy").build()));

        // Non-matching keyword
        predicate = new TaskContainsKeywordsPredicate(Arrays.asList("Buy"));
        assertFalse(predicate.test(new TaskBuilder().withTaskName("Sort Inventory").build()));

        // Keywords match deadline and status, but does not match name
        predicate = new TaskContainsKeywordsPredicate(Arrays.asList("11/11/2024", "N"));
        assertFalse(predicate.test(new TaskBuilder().withTaskName("Buy").withTaskDeadline("11/11/2024")
                .withTaskStatus("N").build()));
    }
}
