package gr.codehub.dp.service;

import java.util.List;

public interface DataSenderService {
    void sendData(List<String> data, String target) throws Exception;
    List<String> getData();
}
