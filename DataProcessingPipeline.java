package com.example;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DataProcessingPipeline {
    public static void main(String[] args) {
        String inputDir = "data/input";
        String outputDir = "data/output";
        
        try {
            Files.createDirectories(Paths.get(outputDir));
            
            Files.list(Paths.get(inputDir)).forEach(file -> {
                try {
                    List<String> lines = Files.readAllLines(file);
                    List<String> processedLines = processLines(lines);
                    Files.write(Paths.get(outputDir, file.getFileName().toString()), processedLines);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> processLines(List<String> lines) {
        // Example processing: convert all lines to uppercase
        List<String> processed = new ArrayList<>();
        for (String line : lines) {
            processed.add(line.toUpperCase());
        }
        return processed;
    }
}
