package gr.codehub.dp.service;

import java.util.List;

public class GreekCheckerService implements LanguageCheckerService {
    private boolean isGreek(List<String> lines) {
        String firstLineLower = lines.get(0).toLowerCase();
        return firstLineLower.contains("e") ||
               firstLineLower.contains("t") ||
               firstLineLower.contains("a") ||
               firstLineLower.contains("o");
    }

    @Override
    public boolean isLanguage(List<String> lines) {
        return isGreek(lines);
    }
}
