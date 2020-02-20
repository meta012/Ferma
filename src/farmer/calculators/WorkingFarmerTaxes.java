package farmer.calculators;

import java.io.Serializable;

/**
 * Represents working farmer tax calculator
 *
 */
public class WorkingFarmerTaxes extends FarmerTaxCalculator implements Serializable {
    private double bonus = 0.00;
    public WorkingFarmerTaxes(String fullName, long id, double hoursPerWeekWorked, double hourlyRate) {

        super(fullName, id, hoursPerWeekWorked, hourlyRate);
    }
    // metodas - kvieciamas tiesiai is lauko - koks gaunamas bonusas
    public void setBonus(boolean bonus) {
        if (bonus) {
            this.bonus = 50.00;
        }
    }
    public double getBonus() {

        return bonus;
    }
    // papildomas (bendras)uzmokestis uz darba
    private double getOverallBonus() {
        if (getBonus()>0) {
            return getOvertimePay(this.bonus);
        }
        else return super.getOvertimePay();
    }
    // metodas, apskaiciuojantis, kiek fermeris uzdirba is virsvalandziu per menesi su bonusu
    private double getOvertimePay(double bonus) {

        return super.getOvertimePay()+bonus;
    }
    @Override
    public double getGrossPay() {
        return super.getGrossPay()+getOverallBonus();
    }
}
