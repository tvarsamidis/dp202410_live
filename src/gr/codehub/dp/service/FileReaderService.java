package gr.codehub.dp.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {
    public static List<String> readFile(final String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }
}
