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

      double amount = -1;
      try {
        amount = view.getAmountField();
      } catch (Exception ex) {
        successfulTransaction = false;
      }

      String category = "";
      try {
        category = view.getCategoryField();
      } catch (Exception ex) {
        successfulTransaction = false;
      }

      if (successfulTransaction) {
        // Create transaction object
        Transaction t = new Transaction(amount, category);

        // Call controller to add transaction
        view.addTransaction(t);
      }

    });

  }

}