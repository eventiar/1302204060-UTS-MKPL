package lib;

public class TaxFunction {

    private static final int BASIC_TAX_EXEMPTION = 54000000;
    private static final int MARRIAGE_EXEMPTION = 4500000;
    private static final int CHILD_EXEMPTION = 1500000;
    private static final int MAX_CHILDREN_COUNT = 3;
    
    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        
        int tax = 0;
        
        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }
        
        numberOfChildren = Math.min(numberOfChildren, MAX_CHILDREN_COUNT);
        
        int taxableIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking - deductible;
        int taxExemption = calculateTaxExemption(isMarried, numberOfChildren);
        
        tax = (int) Math.round(0.05 * (taxableIncome - taxExemption));
        
        return Math.max(tax, 0);
    }
    
    private static int calculateTaxExemption(boolean isMarried, int numberOfChildren) {
        int exemption = BASIC_TAX_EXEMPTION;
        exemption += isMarried ? MARRIAGE_EXEMPTION : 0;
        exemption += numberOfChildren * CHILD_EXEMPTION;
        return exemption;
    }
}