package com.charakhovich.triangle.reader;

import com.charakhovich.triangle.exception.TriangleException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {
    private static final String DEFAULT_PATH = "\resources\\data\\1.txt";
    static final Logger logger = LogManager.getLogger();

    public List<String> readShapeParamsFromFile(String filePath) throws TriangleException {
            ArrayList<String> resultList = new ArrayList();
            File fileToRead = new File(filePath);
            if (!fileToRead.exists()) {
                logger.log(Level.ERROR, "File not found" + filePath);
                logger.log(Level.INFO, "File not found" + filePath);
                fileToRead = new File(DEFAULT_PATH);
            }
            if (!fileToRead.isFile()) {
                throw new TriangleException("File not found.");
            }
            try (FileReader fileReader = new FileReader(filePath);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                  resultList= (ArrayList) bufferedReader.lines().collect(Collectors.toList());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        return resultList;
        }

    }





