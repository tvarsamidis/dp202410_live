package gr.codehub.dp.service;

import java.util.ArrayList;
import java.util.List;

public class ScreenDisplayService implements DataSenderService {

    private List<String> data;

    @Override
    public void sendData(List<String> data, String target) throws Exception {
        this.data = new ArrayList<>(data);
        System.out.println("******* " + target + " ********");
        for (String s: data)
            System.out.println(s);
    }

    @Override
    public List<String> getData() {
        return data;
    }
}
