package lib;

public class TaxFunction {

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        
        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }
        
        if (numberOfChildren > 3) {
            numberOfChildren = 3;
        }
        
        int baseTax = calculateBaseTax(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, deductible);
        int exemptions = applyExemptions(isMarried, numberOfChildren);
        
        int tax = (int) Math.round(0.05 * (baseTax - exemptions));
        return tax < 0 ? 0 : tax;
    }

    private static int calculateBaseTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible) {
        return (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking - deductible;
    }

    private static int applyExemptions(boolean isMarried, int numberOfChildren) {
        int basicExemption = 54000000;
        int marriageExemption = isMarried ? 4500000 : 0;
        int childExemption = numberOfChildren * 1500000;
        return basicExemption + marriageExemption + childExemption;
    }
}
