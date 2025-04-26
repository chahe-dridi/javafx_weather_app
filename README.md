# WeatherFX

A simple JavaFX application that fetches and displays the current weather for a city using the WeatherAPI.

## Features
- Enter any city name and get the current temperature and weather condition.
- Display weather information with an icon.
- Modern JavaFX UI design.
- Fetches real-time weather data using WeatherAPI.

## Technologies Used
- **Java 17**
- **JavaFX** (controls, FXML)
- **Maven**
- **WeatherAPI**
- **JSON parsing** (org.json)

## Project Structure

```
src/main/java/com/example/demo/
├── Main.java               // Launches the JavaFX application
├── WeatherController.java  // Handles UI logic and API communication

src/main/resources/
├── WeatherFX.fxml          // JavaFX FXML layout
├── Style/styles.css        // CSS styling
└── cloud.png               // Default weather icon

pom.xml                     // Maven configuration file
```

## Setup Instructions

1. Clone the repository:
    ```bash
    git clone https://github.com/chahe-dridi/javafx_weather_app.git
    cd javafx_weather_app
    ```

2. Install dependencies:  
    Maven will handle all dependencies automatically from the `pom.xml`.

3. Run the application:

    Using Maven:
    ```bash
    mvn javafx:run
    ```

    Or, build and run from your IDE (like IntelliJ IDEA or Eclipse).

## Important Notes
- Make sure you have **Java 17** installed.
- Ensure you have a valid WeatherAPI key.
- Replace the `API_KEY` in `WeatherController.java` with your actual key:
    ```java
    private final String API_KEY = "your_actual_api_key_here";
    ```