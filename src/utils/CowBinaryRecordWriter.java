package utils;

import animals.Cow;
import exceptions.AnimalAgeException;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * A binary record writer to write info about cows to file
 *
 */
public class CowBinaryRecordWriter {
    DataOutputStream dataOutput;
    public CowBinaryRecordWriter(String outputFile) throws IOException {
        dataOutput = new DataOutputStream(new FileOutputStream(outputFile));
    }
    public void write(Cow cow) throws IOException, AnimalAgeException {
        dataOutput.writeBoolean(cow.isSold());
        dataOutput.writeInt(cow.getAge());
        dataOutput.writeUTF(cow.getQuality());
    }
    public void save() throws IOException {
        dataOutput.close();
    }
}
