package com.ppro.web.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class used to read Test data from CSV file
 */
public class ReadTestData {

    public Iterator<Object[]> parseCsvData(InputStream fileName) throws IOException {
        BufferedReader input = null;
        InputStreamReader inputStreamReader = new InputStreamReader(fileName);
        input = new BufferedReader(inputStreamReader);
        String line = null;
        ArrayList<Object[]> testCases = new ArrayList<>();
        while ((line = input.readLine()) != null) {
            String in = line.trim();
            String[] data = in.split(",");
            List<Object> array = new ArrayList();
            for (String s : data) {
                array.add(s);
            }
            testCases.add(array.toArray());
        }
        input.close();
        return testCases.iterator();
    }
}
