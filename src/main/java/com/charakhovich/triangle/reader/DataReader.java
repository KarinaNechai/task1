package com.charakhovich.triangle.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {
    private static final String DEFAULT_PATH = "data/temp.txt ";
    static final Logger logger = LogManager.getLogger();

    public List<String> readDataFromFile(String filePath) {
        File file = new File(getClass().getClassLoader().getResource(filePath).getFile());
        if (!file.exists() || !file.isFile()) {
            logger.log(Level.INFO, "File not found" + filePath);
            file = new File(getClass().getClassLoader().getResource(DEFAULT_PATH).getFile());
        }
        List<String> lines = null;
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            lines = bufferedReader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return lines;
    }
}






