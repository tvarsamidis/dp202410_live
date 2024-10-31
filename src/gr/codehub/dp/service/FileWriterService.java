package gr.codehub.dp.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileWriterService implements DataSenderService {

    private List<String> data;
    private Exception exception = null;

    private static void saveFile(final String fileName, List<String> lines) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        for (String s : lines)
            writer.write(s + "\n");
        writer.close();
    }

    @Override
    public void sendData(List<String> data, String target) {
        this.data = new ArrayList<>(data);
        exception = null;
        try {
            saveFile(target, data);
        } catch(Exception e) {
            exception = e;
        }
    }

    @Override
    public List<String> getData() {
        return data;
    }

    public Exception getException() {
        return exception;
    }
}
