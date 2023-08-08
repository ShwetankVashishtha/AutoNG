package com.autong.utilities.fileOperations;

import com.opencsv.*;

import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2023
 */
public class ReadWriteCSVs {

    private static CSVParser getParser(char separator) {
        return new CSVParserBuilder()
                .withSeparator(separator)
                .build();
    }

    private static CSVReaderHeaderAware getHeaderAwareReader(String path, char separator) {
        CSVReaderHeaderAware csvHeaderAware = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(path).toURI()));
            csvHeaderAware = (CSVReaderHeaderAware) new CSVReaderHeaderAwareBuilder(reader)
                    .withCSVParser(getParser(separator))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return csvHeaderAware;
    }

    public static List<Map<String, String>> readUsingHeaderAwareReader(String path, char separator) {
        List<Map<String, String>> records = new ArrayList<>();
        CSVReaderHeaderAware csvHeaderAware = getHeaderAwareReader(path, separator);
        Map<String, String> entry;
        try {
            String[] headers = getSimpleReader(path, separator).readAll().get(0);
            while ((entry = csvHeaderAware.readMap()) != null) {
                LinkedHashMap<String, String> entryMap = new LinkedHashMap<>();
                for (String header : headers) {
                    entryMap.put(header, entry.get(header));
                }
                records.add(entryMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    private static CSVReader getSimpleReader(String path, char separator) {
        CSVReader simpleCsvReader = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(path).toURI()));
            simpleCsvReader = new CSVReaderBuilder(reader)
                    .withCSVParser(getParser(separator))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleCsvReader;
    }

    private static Map<String, String> arrayToMap(String[] values) {
        Map<String, String> positionAwareMap = new HashMap<>();
        int index = 1;
        for (String value : values) {
            positionAwareMap.put(String.valueOf(index), value);
            index++;
        }
        return positionAwareMap;
    }

    public static List<String[]> readUsingSimpleCsvReader(String path, char separator) {
        CSVReader csvReader = getSimpleReader(path, separator);
        try {
            return csvReader.readAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<String[]> covertToWritable(List<Map<String, String>> entries) {
        List<String[]> data = new ArrayList<>();
        String[] header = entries.get(0).keySet().toArray(String[]::new);
        data.add(header);
        for (Map<String, String> entry : entries) {
            String[] values = entry.values().toArray(String[]::new);
            data.add(values);
        }
        return data;
    }

    public static void writeHeaderAwareData(String filePath, List<Map<String, String>> data) {
        File file = new File(filePath);
        try {
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile);
            writer.writeAll(covertToWritable(data));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeSimpleCsv(String filePath, List<String[]> data) {
        File file = new File(filePath);
        try {
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile);
            writer.writeAll(data);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
