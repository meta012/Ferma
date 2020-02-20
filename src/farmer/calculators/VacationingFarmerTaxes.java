package farmer.calculators;

import java.io.Serializable;

/**
 * Represents vacationing farmer tax calculator
 *
 */
public class VacationingFarmerTaxes extends FarmerTaxCalculator implements Serializable {
    public VacationingFarmerTaxes(String fullName, long id, double hourlyRate) {

        super(fullName, id, 40, hourlyRate);
    }
    @Override
    //metodas, uzklojantis getGrossPay metodu getGrossPayWithoutBonus
    public double getGrossPay() {

        return super.getGrossPayWithoutBonus();
    }
    @Override
    // uzklojamas fermeriu skaiciavimas, nes atostogose jie nedirba
    public int getFarmersCount() {

        return 0;
    }
}
