package gr.codehub.dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainNew {

    private static final String ROOT = "data\\";

    public static void main(String[] args) {
        System.out.println("Processing started");
        try {
            List<String> fileLines = readFile();
            if (!isEnglish(fileLines)) {
                dataSelectionFailed();
                System.exit(1);
            }
            List<String> upperCaseLines = convertCase(fileLines);
            saveFile(upperCaseLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Processing completed");
    }

    private static List<String> convertCase(List<String> lines) {
        List<String> newLines = new ArrayList<>();
        for(String line: lines) {
            newLines.add(line.toUpperCase());
        }
        return newLines;
    }

    private static void dataSelectionFailed() {
        System.out.println("No english text, no processing done");
    }

    private static boolean isEnglish(List<String> lines) {
        String firstLineLower = lines.get(0).toLowerCase();
        return firstLineLower.contains("e") ||
               firstLineLower.contains("t") ||
               firstLineLower.contains("a") ||
               firstLineLower.contains("o");
    }

    private static List<String> readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(ROOT + "input.txt")));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    private static void saveFile(List<String> lines) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(new File(ROOT + "output.txt")));
        for (String s : lines)
            writer.write(s + "\n");
        writer.close();
    }
}

