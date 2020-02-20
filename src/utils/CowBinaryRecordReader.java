package utils;

import animals.Cow;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A binary record reader to read info about cows from file
 *
 */
public class CowBinaryRecordReader {
    DataInputStream dataInput;
    public CowBinaryRecordReader(String filename) throws IOException {
        dataInput = new DataInputStream(new FileInputStream(filename));
    }
    public List<Cow> readAll() throws IOException {
        List<Cow> listCow = new ArrayList<>();
        try {
            while (true) {
                Boolean sold = dataInput.readBoolean();
                int age = dataInput.readInt();
                String quality = dataInput.readUTF();

                Cow cow = new Cow(sold, age, quality);
                listCow.add(cow);
            }
        } catch (EOFException ex) {
        }
        dataInput.close();
        return listCow;
    }
}