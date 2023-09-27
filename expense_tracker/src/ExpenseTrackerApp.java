import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {

    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");

    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {

      // Get transaction data from view
      boolean successfulTransaction = true;
      String errorMessage = "";

      double amount = -1;
      try {
        amount = view.getAmountField();
        if (!InputValidation.validAmount(amount)) {
          successfulTransaction = false;
          errorMessage += "Amount input must be between 0 and 1000 (exclusive)\n";
        }
      } catch (Exception ex) {
        successfulTransaction = false;
        errorMessage += "Amount input must be a decimal number between 0 and 1000 (exclusive)\n";
      }

      String category = view.getCategoryField();
      if (!InputValidation.validCategory(category)) {
        successfulTransaction = false;
        errorMessage += "Category input must be one of: food, travel, bills, entertainment, other\n";
      }

      if (successfulTransaction) {

        view.setInputErrorMessage(null);

        // Create transaction object
        Transaction t = new Transaction(amount, category);

        // Call controller to add transaction
        view.addTransaction(t);
      } else {
        view.setInputErrorMessage(errorMessage);
        view.refresh();
      }

    });

  }

}