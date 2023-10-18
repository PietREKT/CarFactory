package com.example.carfactory;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CarCreator {
    private BlockingQueue<Car> bodyQueue = new LinkedBlockingQueue<>();
    private BlockingQueue<Car> engineQueue = new LinkedBlockingQueue<>();
    private BlockingQueue<Car> interiorQueue = new LinkedBlockingQueue<>();

    public void createBody(Car car, int ttw) throws InterruptedException {
        bodyQueue.add(car);
//        listInManufacturing.getItems().add(car);
        while (!bodyQueue.isEmpty()){
            //TODO implement showing this on screen
            Thread.sleep(ttw * 1000);
            engineQueue.put(car);
            car.setProductionStage("Zakończono tworzenie karoserii. Wkładanie silnika do środka...");
            bodyQueue.remove(car);
            System.out.println("Body done!");

        }
    }
    public void putEngine(int ttw) throws InterruptedException {
        Car car = engineQueue.take();
        Thread.sleep(ttw * 1000);
        car.setProductionStage("Silnik został włożony. Tworzenie wnętrza...");
        interiorQueue.put(car);
        System.out.println("Engine in!");
    }

    public void createInterior(int ttw) throws InterruptedException {
        Car car = interiorQueue.take();

        Thread.sleep(ttw * 1000);
        car.setInterior(INTERIOR.PREMIUM);

        car.setManufacturedAt(LocalDateTime.now());
        car.setProductionStage("Produkcję zakończono o " + car.getManufacturedAt().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
        + ", po " + ChronoUnit.SECONDS.between(car.getProductionStarted(), car.getManufacturedAt()) + " sekundach pracy");
        System.out.println("CAR DONE!!");

    }


}
