package farmer.calculators;

/**
 * Represents sick farmer tax calculator
 *
 */
public class SickFarmerTaxes extends FarmerTaxCalculator {
    public SickFarmerTaxes(String fullName, long id, double hourlyRate) {

        super(fullName, id, 40, hourlyRate);
    }
    @Override
    public double getWorkplacePay() {

        return 0;
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
