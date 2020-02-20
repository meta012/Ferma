package farm.calculator;

import animals.Animal;
import animals.Cow;
import customer.Customer;
import customer.CustomersInfo;
import exceptions.AnimalAgeException;
import farm.Inventory;
import farmer.calculators.FarmerTaxCalculator;
import farmer.calculators.WorkingFarmerTaxes;

import java.text.DecimalFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents overall farm tax calculator
 *
 */
public class FarmTaxCalculator {

    public static HashSet<FarmerTaxCalculator> farmers = new HashSet<>();  // Set neimplementina Serializable, o HashSet implementina
    public static Set<Animal> animals = new HashSet<>();
    public static Set<Cow> cows = new HashSet<>();
    private double animalsEarnings = 0;
    private double taxes = getSoldAnimalsEarnings();

//    public static List<WorkingFarmerTaxes> workingFarmers = new ArrayList<>();

    private final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static DecimalFormat df2 = new DecimalFormat("0.00");
    private double soldAnimalsEarnings;
    private int count = 0;
    private double overallEmploymentPay;
    private double overallItemsExpenses;
    private double bonusTaxes;

    public boolean isTaxInfoExact() {
        return CustomersInfo.cust
                .stream()
                .allMatch(p -> taxesPredicate(p));
    }
    private boolean taxesPredicate(Customer cus) {
        this.taxes = taxes - cus.getPayment();
        return taxes >= 0;
    }
    // visu fermeriu darbo vietos kaina be bonusu
    private double getAllFarmersTaxesWithoutBonus() {
        this.overallEmploymentPay = 0;
        this.count = 0;
        for (FarmerTaxCalculator farmer: farmers){
            this.overallEmploymentPay = this.overallEmploymentPay + farmer.getWorkplacePay();
            this.count = this.count + farmer.getFarmersCount();
        }
        return overallEmploymentPay;
    }
/*
    // visu fermeriu bonusai
    private double getFarmersBonusTaxes() {
        this.bonusTaxes = 0;
        for (int i = 0; i < workingFarmers.size(); i++){
            this.bonusTaxes = this.bonusTaxes + workingFarmers.get(i).getBonus();
        }
        return bonusTaxes;
    }
    */
    // visu fermeriu darbo vietos kaina su bonusu
    public final double getOverallFarmersPayment() {
        getAllFarmersTaxesWithoutBonus();
  //      getFarmersBonusTaxes();
        return overallEmploymentPay+bonusTaxes;
    }
    // dirbantiem fermeriam apskaiciuoti - atostogose nedirba
    public int getWorkingFarmersCount() {
        getAllFarmersTaxesWithoutBonus();
        return this.count;
    }
    // parduotu gyvuliu pelnas
    private double getSoldAnimalsEarnings() {
        this.count = 0;
        this.soldAnimalsEarnings = 0;
        try {
            for (Animal animal : animals) {
                if (animal.isSold()) {
                    count++;
                }
            }
            if (count >= 5) {
                for (Animal animal : animals) {
                    if (animal.isSold()) {
                        this.soldAnimalsEarnings = this.soldAnimalsEarnings + animal.getPriceWithDiscount();
                    }
                }
            } else {
                for (Animal animal : animals) {
                    if (animal.isSold()) {
                        this.soldAnimalsEarnings = this.soldAnimalsEarnings + animal.getPrice();
                    }
                }
            }
        } catch (AnimalAgeException e) {
            log.log(Level.WARNING, String.valueOf(e), e);
        }

        return soldAnimalsEarnings;
    }
    private double getInventorisationExpenses() {
        for (int i = 0; i < Inventory.itemsPrice.size(); i++) {
            this.overallItemsExpenses = overallItemsExpenses + Inventory.itemsPrice.get(i);
        }
        return overallItemsExpenses;
    }
    // fermos pelnas
    private double getFarmEarnings() {

        return getSoldAnimalsEarnings()-getOverallFarmersPayment()-getInventorisationExpenses();
    }

    public String toString() {
        return "\nVisu fermeriu darbo vietos islaidos, su bonusais: "+df2.format(getOverallFarmersPayment())+
                "\nInventorizacijos kastai: "+getInventorisationExpenses()+
                "\nGyvuliu fermoje yra: "+animals.size()+
                "\nFermos pelnas "+df2.format(getFarmEarnings());
    }

}