package nl.dev4all.input;

import nl.dev4all.piramid.NumberPiramid;
import nl.dev4all.piramid.Row;

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

    public static NumberPiramid createNumberPiramid(String filename, String seperator)  {

        NumberPiramid piramid = new NumberPiramid();

        try {
            FileInputStream fstream = new FileInputStream(filename);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            int count = 1;
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (seperator != null) {
                    String[] arr = strLine.split(seperator);
                    int[] ints = new int[count];

                    int temp = 0;
                    for (String line : arr) {
                        ints[temp] = Integer.valueOf(line);
                        temp++;
                    }

                    Row row = new Row(count, ints);
                    piramid.addRow(row);
                }

                count++;
            }

            in.close();
        } catch (Exception e) {
            System.out.println("Error reading file " + filename);
        }

        return piramid;
    }

    public static List<String> getListOfNames(String filename, String seperator, String strip)  {
        List<String> names = new ArrayList<String>();

        try {
            FileInputStream fstream = new FileInputStream(filename);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strip != null) {
                    strLine = strLine.replaceAll(strip, "");
                }

                if (seperator != null) {
                    String[] arr = strLine.split(seperator);
                    for (String name : arr) {
                        names.add(name);
                    }
                }
            }

            in.close();
        } catch (Exception e) {
            System.out.println("Error reading file " + filename);
        }

        return names;
    }
}
