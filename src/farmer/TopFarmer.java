package farmer;

import farm.calculator.FarmTaxCalculator;
import farmer.calculators.FarmerTaxCalculator;

import java.util.Optional;

/**
 * Represents the best working farmer
 *
 */
public class TopFarmer{
    public Optional<FarmerTaxCalculator> getTopWorker() {
        return FarmTaxCalculator.farmers
                .stream()
                .reduce((c1, c2) -> c1.getGrossPay() > c2.getGrossPay() ? c1 : c2);

    }
}
