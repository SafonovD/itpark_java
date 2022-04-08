package lesson_22;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson_22.dto.WeatherDto;
import lesson_22.exception.ParameterSkippedException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Run {

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages");
    private static final String EXIT_PHRASE = RESOURCE_BUNDLE.getString("app.exit");
    private static final String APP_ID = "appId";
    private static final String API_WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";
    private static final ThreadLocal<ObjectMapper> OBJECT_MAPPER = new ThreadLocal<>(){
        @Override
        public ObjectMapper get() {
            return new ObjectMapper();
        }
    };

    public static void main(String[] args) throws IOException {

        final String appId = getAppId();

        Scanner inputScaner = new Scanner(System.in);
        System.out.println(RESOURCE_BUNDLE.getString("app.title"));

        while (inputScaner.hasNextLine()) {
            String city = inputScaner.nextLine();
            if (EXIT_PHRASE.equalsIgnoreCase(city)) {
                return;
            }
            String translateCityName = getCityName(city);
            Double cityTemperature = getCityTemperature(appId, translateCityName);
            System.out.printf(RESOURCE_BUNDLE.getString("app.result"), city,cityTemperature);
            System.out.println(RESOURCE_BUNDLE.getString("app.next"));
        }

    }

    private static Double getCityTemperature(String appId, String translateCityName) throws IOException {
        URL apiUrl = new URL(String.format(API_WEATHER_URL, translateCityName, appId));
        try (InputStream is = apiUrl.openStream()) {
            WeatherDto weatherDto = OBJECT_MAPPER.get().readValue(is, WeatherDto.class);
            return weatherDto.getMain().getTemp();
        }
    }

    private static String getAppId() {
//        String appId = Arrays.stream(args).findFirst()
//                    .orElseThrow(() -> new ParameterSkippedException(RESOURCE_BUNDLE.getString("app.errorParameter")));
//            String appId = Optional.ofNullable(System.getenv(APP_ID))
//                    .orElseThrow(() -> new ParameterSkippedException(RESOURCE_BUNDLE.getString("app.errorParameter")));
        return Optional.ofNullable(System.getProperty(APP_ID))
                .orElseThrow(() -> new ParameterSkippedException(RESOURCE_BUNDLE.getString("app.errorParameter")));
    }

    private static String getCityName(String city) {
        try{
            return RESOURCE_BUNDLE.getString(city);
        }catch (Exception e){
            return "Kazan";
        }

    }
}
