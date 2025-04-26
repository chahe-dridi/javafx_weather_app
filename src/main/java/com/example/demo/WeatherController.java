package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class WeatherController {

    @FXML
    private Text City;

    @FXML
    private Text Degrees;

    @FXML
    private TextField cityInput;

    @FXML
    private Button searchButton;

    @FXML
    private ImageView Weather;

    @FXML
    private ImageView AboutCity;

    private final String API_KEY = "c786406a88464571810204524232301"; // Your WeatherAPI.com key

    @FXML
    public void onSearchClicked() {
        String cityName = cityInput.getText().trim();
        if (!cityName.isEmpty()) {
            fetchWeatherData(cityName);
        }
    }

    private void fetchWeatherData(String cityName) {
        try {
            URL url = new URL("http://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=" + cityName + "&aqi=no");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            Scanner sc = new Scanner(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            while (sc.hasNext()) {
                response.append(sc.nextLine());
            }
            sc.close();

            JSONObject jsonObject = new JSONObject(response.toString());

            String temp = jsonObject.getJSONObject("current").get("temp_c").toString();
            String weatherType = jsonObject.getJSONObject("current").getJSONObject("condition").getString("text");
            String iconUrl = "http:" + jsonObject.getJSONObject("current").getJSONObject("condition").getString("icon");

            Degrees.setText(temp + "°C");
            City.setText("City: " + jsonObject.getJSONObject("location").getString("name"));

            // Set the weather icon
            Weather.setImage(new Image(iconUrl));
            AboutCity.setImage(new Image(iconUrl));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
