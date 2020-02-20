package farmer.calculators;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * Represents farmer tax calculator - a program to calculate net/gross pay and all of the taxes
 * @author Meta Bambalaite
 * @since 2019.02
 *
 */
public class FarmerTaxCalculator implements Serializable{
    private static DecimalFormat df2 = new DecimalFormat("0.00");

    private String fullName;
    private double hoursPerWeekWorked;
    private int usualHoursPerWeekWorked;
    private double hourlyRate;
    private int weeksWorked;
    private long id;
    private final static double overtimeHourRatePercent = 0.50;
    // konstruktoriai
    public FarmerTaxCalculator() {

        this.weeksWorked = 4;
    }
    private FarmerTaxCalculator(int x) {
        this();
        this.usualHoursPerWeekWorked = x;
    }
    public FarmerTaxCalculator(String fullName, long id, double hoursPerWeekWorked, double hourlyRate) {
        this(40);
        this.fullName = fullName;
        this.id = id;
        this.hoursPerWeekWorked = hoursPerWeekWorked;
        this.hourlyRate = hourlyRate;
    }
    /**
     * @return weeks worked
     */
    public final int getWeeksWorked() {
        return weeksWorked;
    }
    /**
     * @return farmers unique ID
     */
    public long getId() {
        return id;
    }
    /**
     * @return farmers full name
     */
    public String getFarmersFullName() {

        return fullName;
    }
    /**
     * @return whether farmer is working overtime
     */
    private boolean isWorkingOvertime() {

        return hoursPerWeekWorked > usualHoursPerWeekWorked;
    }
    /**
     * @return overtime pay percent
     */
    private double getOvertimePayPercent() {
        if (isWorkingOvertime()) {
            return overtimeHourRatePercent;
        } else {
            return 0;
        }
    }
    /**
     * @return overtime payment during fixed time
     */
    public double getOvertimePay() {
        return (hoursPerWeekWorked - usualHoursPerWeekWorked) * hourlyRate * weeksWorked * getOvertimePayPercent();
    }
    /**
     * @return gross pay without bonus
     */
    public final double getGrossPayWithoutBonus() {

        return hoursPerWeekWorked*hourlyRate*weeksWorked;
    }
    /**
     * @return gross pay with bonus
     */
    public double getGrossPay() {

        return getGrossPayWithoutBonus();
    }
    /**
     * @return social pay that is payable by the workplace
     */
    private double getWorkplaceSocialPay() {

        return getGrossPayWithoutBonus()*0.0177;
    }
    /**
     * @return overall workplace pay for a farmer
     */
    public double getWorkplacePay() {

        return getWorkplaceSocialPay()+getGrossPayWithoutBonus();
    }
    /**
     * @return tax exemptions
     */
    private double getTaxExemptions() {
        if (getGrossPay() <= 555) {
            return 300;
        } else if (getGrossPay() > 2555) {
            return 0;
        } else {
            return 300 - 0.15 * (getGrossPay() - 555);
        }
    }
    /**
     * @return income taxes
     */
    private double getIncomeTax() {
        if (getGrossPay() >= 136344) {
            return (getGrossPay()-getTaxExemptions()) * 0.27;
        }
        else {
            return (getGrossPay() - getTaxExemptions()) * 0.20;
        }
    }
    /**
     * @return health insurance taxes
     */
    private double getHealthInsuranceTax() {

        return getGrossPay()*0.0698;
    }
    /**
     * @return social insurance taxes
     */
    private double getSocialInsurance() {

        return getGrossPay()*0.1252;
    }
    /**
     * @return farmers net pay
     */
    public double getNetPay() {

        return getGrossPay()- getIncomeTax()- getHealthInsuranceTax()- getSocialInsurance();
    }
    // dirbantiem fermeriam apskaiciuoti - dirba
    public int getFarmersCount() {
        return 1;
    }

    // Overriding hashcode and equals for farmers not to duplicate
    @Override
    public int hashCode () {
        return (int)getId();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        FarmerTaxCalculator other = (FarmerTaxCalculator) obj;
        if (getId() != other.getId()) {
            return false;
        }
        return true;
    }
    public String toString() {
        return "\nFermeris " + getFarmersFullName() +
                " (ID: "+ getId() +
                ") uzdirba " + df2.format(getGrossPay()) +
                ". I rankas -  "+ df2.format(getNetPay()) +
                ". Darbo vietos kaina: "+ df2.format(getWorkplacePay());
    }
}