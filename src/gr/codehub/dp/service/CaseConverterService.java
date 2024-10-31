package gr.codehub.dp.service;

import java.util.ArrayList;
import java.util.List;

public class CaseConverterService {
    public static List<String> convertCase(List<String> lines) {
        List<String> newLines = new ArrayList<>();
        for(String line: lines) {
            newLines.add(line.toUpperCase());
        }
        return newLines;
    }
}
