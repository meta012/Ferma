package utils;

import farm.calculator.FarmTaxCalculator;

import java.io.*;
import java.util.ArrayList;

/**
 * Serialize objects, to put farmers info to/from file in a binary manner
 *
 */
public class FarmersSerialization {

    public static void saveObject (Serializable object, String filename) throws IOException {
        ObjectOutputStream objStream = new ObjectOutputStream(new FileOutputStream(filename));
        objStream.writeObject(object);
        objStream.close();
    }
    public static Object loadObject (String filename) throws ClassNotFoundException, IOException {
        ObjectInputStream objStream = new ObjectInputStream(new FileInputStream(filename));
        ArrayList<FarmTaxCalculator> farmers2 = (ArrayList<FarmTaxCalculator>) objStream.readObject();
        objStream.close();
        return farmers2;
    }

}
