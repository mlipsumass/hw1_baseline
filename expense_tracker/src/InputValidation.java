import java.util.List;
import java.util.ArrayList;

public class InputValidation {

	private static List<String> acceptableCategories;

	// Initialize list of acceptable categories
	static {
		acceptableCategories = new ArrayList<>();
		acceptableCategories.add("food");
		acceptableCategories.add("travel");
		acceptableCategories.add("entertainment");
		acceptableCategories.add("bills");
		acceptableCategories.add("other");
	}

	// Business logic shown here, correct data type handled in ExpenseTrackerApp
	public static boolean validAmount(double amount) {
		return amount > 0 && amount < 1000;
	}

	public static boolean validCategory(String category) {
		return acceptableCategories.contains(category.toLowerCase());
	}
}