package gr.codehub.dp.service;

public class SenderSelectorService {

    private static DataSenderService lastServiceSelected = null;

    public static DataSenderService select() { // lazy instantiation
        if (lastServiceSelected == null) {
            if (decideIfFile()) {
                lastServiceSelected = new FileWriterService();
            } else {
                lastServiceSelected = new ScreenDisplayService();
            }
        }
        return lastServiceSelected; // singleton design pattern
    }

    public void reset() {
        lastServiceSelected = null;
    }

    private static boolean decideIfFile() {
        return Math.random() > 0.5;
    }
}
