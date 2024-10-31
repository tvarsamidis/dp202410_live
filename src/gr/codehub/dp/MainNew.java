package gr.codehub.dp;

import gr.codehub.dp.service.CaseConverterService;
import gr.codehub.dp.service.EnglishCheckerService;
import gr.codehub.dp.service.FileReaderService;
import gr.codehub.dp.service.FileWriterService;
import gr.codehub.dp.service.GreekCheckerService;
import gr.codehub.dp.service.LanguageCheckerService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainNew {

    private static final String ROOT = "data\\";

    public static void main(String[] args) {
        System.out.println("Processing started");
        try {
            List<String> fileLines = readFile(ROOT + "input.txt");
            if (!isEnglish(fileLines)) {
                dataSelectionFailed();
                System.exit(1);
            }
            List<String> upperCaseLines = convertCase(fileLines);
            saveFile(ROOT + "output.txt", upperCaseLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Processing completed");
    }

    private static List<String> convertCase(List<String> lines) {
        List<String> convertedLines = CaseConverterService.convertCase(lines);
        return convertedLines;
    }

    private static void dataSelectionFailed() {
        System.out.println("No english text, no processing done");
    }

    private static boolean isEnglish(List<String> lines) { // dependency injection
        LanguageCheckerService ls = new GreekCheckerService();
        return ls.isLanguage(lines);
    }

    private static List<String> decideWhichTypeOfList() {
        return Math.random() >= 0 ? new ArrayList<>() : new LinkedList<>();
    }

    private static List<String> readFile(final String fileName) throws IOException {
        List<String> lines = FileReaderService.readFile(fileName);
        return lines;
    }

    private static void saveFile(final String fileName, List<String> lines) throws IOException {
        FileWriterService.saveFile(fileName, lines);
    }
}

