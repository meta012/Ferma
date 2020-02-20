package app;

import animals.*;
import customer.Customer;
import customer.CustomersInfo;
import farm.Inventory;
import farm.calculator.FarmTaxCalculator;
import farmer.TopFarmer;
import farmer.calculators.*;
import products.Milk;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException{

        WorkingFarmerTaxes farmer1 = new WorkingFarmerTaxes("Jonas Jonaitis",33309240064L, 40, 4);
        farmer1.setBonus(false);
        FarmTaxCalculator.farmers.add(farmer1);
        WorkingFarmerTaxes farmer2 = new WorkingFarmerTaxes("Paulius Paulenis",33309240065L, 42, 3);
        farmer2.setBonus(true);
        FarmTaxCalculator.farmers.add(farmer2);
        WorkingFarmerTaxes farmer3 = new WorkingFarmerTaxes("Rokas Rokaitis",33309240066L, 38, 3);
        farmer3.setBonus(true);
        FarmTaxCalculator.farmers.add(farmer3);
        WorkingFarmerTaxes farmer4 = new WorkingFarmerTaxes("Tomas Tomaitis",33309240067L, 39, 4);
        farmer4.setBonus(false);
        FarmTaxCalculator.farmers.add(farmer4);
        WorkingFarmerTaxes farmer5 = new WorkingFarmerTaxes("Tomas Tomaitis",33309240067L, 39, 4); //duplicate
        farmer5.setBonus(false);
        FarmTaxCalculator.farmers.add(farmer5);

        VacationingFarmerTaxes farmer_on_vacation = new VacationingFarmerTaxes("Lukas Lukaitis (atostogos)", 33309240068L, 1.5);
        FarmTaxCalculator.farmers.add(farmer_on_vacation);

        FarmerTaxCalculator farmer_sick = new VacationingFarmerTaxes("Dainius Dainaitis (liga)", 33309240069L, 1);
        FarmTaxCalculator.farmers.add(farmer_sick);

        System.out.println(FarmTaxCalculator.farmers);

        TopFarmer top = new TopFarmer();
        System.out.println(top.getTopWorker());

        Calf calf1 = new Calf(true, 1);
        FarmTaxCalculator.animals.add(calf1);
        Calf calf2 = new Calf(false, 1);
        FarmTaxCalculator.animals.add(calf2);
        Pig pig1 = new Pig(true, 2, "high");
        FarmTaxCalculator.animals.add(pig1);

        Milk highMilk = new Milk(50);
        Cow cow1 = new Cow(true, 8, "high", highMilk);
        FarmTaxCalculator.animals.add(cow1);
        FarmTaxCalculator.cows.add(cow1);

        Milk lowMilk = new Milk(30);
        Cow cow2 = new Cow(true, 2, "low", lowMilk);
        FarmTaxCalculator.animals.add(cow2);
        FarmTaxCalculator.cows.add(cow2);

        Cow highCowClone = (Cow) cow1.clone();
        FarmTaxCalculator.animals.add(highCowClone);
        FarmTaxCalculator.cows.add(highCowClone);
        Cow highCowClone1 = (Cow) cow1.clone();
        FarmTaxCalculator.animals.add(highCowClone1);
        FarmTaxCalculator.cows.add(highCowClone1);

        Cow lowCowClone = (Cow) cow2.clone();
        FarmTaxCalculator.animals.add(lowCowClone);
        FarmTaxCalculator.cows.add(lowCowClone);
        Cow lowCowClone1 = (Cow) cow2.clone();
        FarmTaxCalculator.animals.add(lowCowClone1);
        FarmTaxCalculator.cows.add(lowCowClone1);

/*
        Animal cow10 = AnimalFactory.create("Cow");
        FarmTaxCalculator.animals.add(cow10);
        Animal pig10 = AnimalFactory.create("Pig");
        FarmTaxCalculator.animals.add(pig10);


        String outputFile = "animals.dat";
        try {
            CowBinaryRecordWriter writer = new CowBinaryRecordWriter(outputFile);
            for (Cow cowss: FarmTaxCalculator.cows) {
                writer.write(cowss);
            }
            writer.save();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (AnimalAgeException e) {
            e.printStackTrace();
        }

        String inputFile = "animals.dat";
        try {
            CowBinaryRecordReader reader = new CowBinaryRecordReader(inputFile);
            List<Cow> listCow = reader.readAll();
            for (Cow cowss : listCow) {
                System.out.println("Pardavimas: "+cowss.isSold());
                System.out.println("Amzius: "+cowss.getAge());
                System.out.println("Kokybe: "+cowss.getQuality()+"\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (AnimalAgeException e) {
            e.printStackTrace();
        }

        try {
            FarmersSerialization.saveObject(FarmTaxCalculator.farmers, "animals.dat");
            System.out.println(FarmersSerialization.loadObject("animals.dat"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        new TimerThread(5, 7, 2, 6);
        System.out.println("Task scheduled");
*/

        Inventory item = new Inventory();
        item.addItems("masinos", 3);
        item.addItems("grebliai", 50);
        item.addItems("kastuvai", 30);
        item.buyItems("masinos", 1, 200);
        item.printMap();

        Customer cust1 = new Customer("Ali", 200, "2 karve");
        CustomersInfo.cust.add(cust1);
        Customer cust2 = new Customer("Express", 110, "5 kiaules");
        CustomersInfo.cust.add(cust2);
        Customer cust3 = new Customer("Farmland", 40, "1 versiuka");
        CustomersInfo.cust.add(cust3);
        Customer cust4 = new Customer("Farmland", 50, "1 versiuka");
        CustomersInfo.cust.add(cust4);
        Customer cust5 = new Customer("Express", 120, "5 kiaules");
        CustomersInfo.cust.add(cust5);
        System.out.println(CustomersInfo.cust);

        CustomersInfo customer = new CustomersInfo();
        System.out.println("\nVIP "+customer.getVipCustomers());
        System.out.println("\nPaskutinis pirkejas: "+customer.getLastPayment());
        System.out.println(customer.getMostValuableCustomers());

        FarmTaxCalculator taxes = new FarmTaxCalculator();
        System.out.println(taxes.isTaxInfoExact());

        System.out.println(taxes);

    }
}
