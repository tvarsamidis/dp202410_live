package gr.codehub.dp.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileWriterService implements DataSenderService {

    private List<String> data;

    private static void saveFile(final String fileName, List<String> lines) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        for (String s : lines)
            writer.write(s + "\n");
        writer.close();
    }

    @Override
    public void sendData(List<String> data, String target) throws Exception {
        this.data = new ArrayList<>(data);
        saveFile(target, data);
    }

    @Override
    public List<String> getData() {
        return data;
    }
}
