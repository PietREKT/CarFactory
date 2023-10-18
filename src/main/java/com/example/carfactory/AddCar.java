package com.example.carfactory;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

enum BODY_TYPE {
    SUV,
    HATCHBACK,
    SEDAN,
    COUPE
}

enum FUEL{
    BENZYNA,
    DIESEL,
    HYBRYDA,
    ELEKTRYCZNY
}

enum INTERIOR {
    BASIC,
    COMFORT,
    PREMIUM
}

public class AddCar {
    @FXML
    private ChoiceBox<String> fuelChoiceBox;
    @FXML
    private ChoiceBox<String> bodyChoiceBox;

    @FXML
    private ChoiceBox<String> interiorChoiceBox;

    @FXML
    private TextField brandTextBox;
    @FXML
    private TextField modelTextBox;
    @FXML
    private TextField engineCapacityTextBox;



    @FXML
    private Button submitButton;
    public void onSubmitButtonClick(ActionEvent actionEvent) throws InterruptedException, IOException {
        Stage stage = (Stage) submitButton.getScene().getWindow();

        String model = modelTextBox.getText(), brand = brandTextBox.getText();
        int engineCap = Integer.parseInt(engineCapacityTextBox.getText());

        BODY_TYPE bodyType = BODY_TYPE.valueOf(bodyChoiceBox.getValue().toUpperCase());
        INTERIOR interior = INTERIOR.valueOf(interiorChoiceBox.getValue().toUpperCase());
        FUEL fuel = FUEL.valueOf(fuelChoiceBox.getValue().toUpperCase());
        stage.close();

        Car car = new Car(brand, model, engineCap, bodyType, fuel, interior);
        System.out.println(car.toString());
        MainController.carList.add(car);


    }
}
