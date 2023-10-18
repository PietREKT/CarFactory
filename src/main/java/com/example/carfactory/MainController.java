package com.example.carfactory;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;

public class MainController {

    @FXML
    public TableView<Car> listInManufacturing;
    @FXML private TextField brandField;
    @FXML private TextField modelField;
    @FXML private TextField statusField;

    @FXML
    public ListView<String> completedCars;

    @FXML
    Button addCar;

    public static LinkedList<Car> carList = new LinkedList<>();

    @FXML
    protected void onaddCarButtonClick(){
//        if (clicks < 5) return;
        Parent root;
        try {
            root = FXMLLoader.load(MainApplication.class.getResource("add-car.fxml"));
            Stage stage1 = new Stage();
            stage1.setTitle("Dodaj auto");
            stage1.setScene(new Scene(root, 400, 300));
            stage1.showAndWait();

//            stage1.setOnCloseRequest(new EventHandler<WindowEvent>() {
//                @Override
//                public void handle(WindowEvent windowEvent) {
//
//                }
//            });

            listInManufacturing.getColumns().get(0).setCellValueFactory(
                    new PropertyValueFactory<>("brand")
            );

            listInManufacturing.getColumns().get(1).setCellValueFactory(
                    new PropertyValueFactory<>("model")
            );

            listInManufacturing.getColumns().get(2).setCellValueFactory(
                    new PropertyValueFactory<>("productionStage")
            );
            listInManufacturing.getColumns().get(3).setCellValueFactory(
                    new PropertyValueFactory<>("fuel")
            );
            listInManufacturing.getColumns().get(4).setCellValueFactory(
                    new PropertyValueFactory<>("engineCapacity")
            );
            listInManufacturing.getColumns().get(5).setCellValueFactory(
                    new PropertyValueFactory<>("Body")
            );

            if (!carList.isEmpty()){
               Car c = carList.get(0);
               carList.remove(c);
               listInManufacturing.getItems().add(c);
               Thread.sleep(1000);
               Thread bodyThread = new Thread(() ->{
                    try {
                        int ttw = new SecureRandom().nextInt(5, 15);
                        c.createBody(c, ttw);
                        listInManufacturing.getItems().set(
                                listInManufacturing.getItems().indexOf(c), c
                        );
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
               });

               Thread engineThread = new Thread(() -> {
                   try {
                       int ttw = new SecureRandom().nextInt(5, 15);
                       c.putEngine(ttw);
                       listInManufacturing.getItems().set(
                               listInManufacturing.getItems().indexOf(c), c
                       );
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               });

               Thread interiorThread = new Thread(() -> {
                   try {
                       int ttw = new SecureRandom().nextInt(5, 15);
                       c.createInterior(ttw);
                       listInManufacturing.getItems().set(
                               listInManufacturing.getItems().indexOf(c), c
                       );
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               });

               bodyThread.start();
               engineThread.start();
               interiorThread.start();

            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}