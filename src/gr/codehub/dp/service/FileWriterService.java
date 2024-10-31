package gr.codehub.dp.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileWriterService {

    public static void saveFile(final String fileName, List<String> lines) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        for (String s : lines)
            writer.write(s + "\n");
        writer.close();
    }
}
