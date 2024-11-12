package com.example.demo;

import CLasses.Produto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/HelloView.fxml"));
        Parent root = loader.load();

        HelloController controller = loader.getController();

        List<Produto> todosProduto = Arrays.asList(
                new Produto(1L, "Laptop", 500.0, 10),
                new Produto(2L, "Mouse", 100.0, 30),
                new Produto(3L, "Teclado", 400.0, 20),
                new Produto(4L, "Monitor", 800.0, 15),
                new Produto(5L, "Remote Play", 1000.0, 10),
                new Produto(6L, "Memoria ram", 300.0, 30),
                new Produto(7L, "Placa de video", 800.0, 5)
        );
        controller.setProdutos(todosProduto);

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Sistema de Produtos");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}