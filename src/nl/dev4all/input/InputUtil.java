package nl.dev4all.input;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class InputUtil {
    public static List<BigInteger> readInput(String filename, String seperator)  {
        List<BigInteger> bigInts = new ArrayList<BigInteger>();
        try {
            FileInputStream fstream = new FileInputStream(filename);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (seperator == null) {
                    bigInts.add(new BigInteger(strLine));
                }

                if (seperator != null) {
                    String[] arr = strLine.split(seperator);
                    for (String line : arr) {
                        bigInts.add(new BigInteger(line));
                    }
                }
            }

            in.close();
        } catch (Exception e) {
            System.out.println("Error reading file " + filename);
        }

        return bigInts;
    }


}
