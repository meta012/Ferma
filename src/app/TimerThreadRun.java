package app;

import animals.Cow;
import utils.CowBinaryRecordReader;
import utils.CowBinaryRecordWriter;
import exceptions.AnimalAgeException;
import farm.calculator.FarmTaxCalculator;
import utils.FarmersSerialization;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer realization
 *
 */
public class TimerThreadRun extends TimerTask implements Runnable{
    private String filename = "animals.dat";
    private String outputFile = "animals.dat";
    private Timer timer;
    public TimerThreadRun(Timer timer) {
        this.timer = timer;
    }

    public void run() {
        try {

            FarmersSerialization.saveObject(FarmTaxCalculator.farmers, filename);
            System.out.println(FarmersSerialization.loadObject(filename));

            CowBinaryRecordWriter writer = new CowBinaryRecordWriter(outputFile);
            for (Cow cowss : FarmTaxCalculator.cows) {
                writer.write(cowss);
            }
            writer.save();
            CowBinaryRecordReader reader = new CowBinaryRecordReader(filename);
            List<Cow> listCow = reader.readAll();
            for (Cow cowss : listCow) {
                System.out.println("Pardavimas: " + cowss.isSold());
                System.out.println("Amzius: " + cowss.getAge());
                System.out.println("Kokybe: " + cowss.getQuality() + "\n");
            }
        } catch (IOException | ClassNotFoundException | AnimalAgeException ex) {
            ex.printStackTrace();
        }
        timer.cancel();
    }

}
