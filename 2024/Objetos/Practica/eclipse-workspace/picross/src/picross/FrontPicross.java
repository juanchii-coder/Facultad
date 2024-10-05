package picross;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FrontPicross extends Application {
    private Juego juego;
    private Label mensajeEstado;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        juego = new Juego("Jugador1", 5); // Inicializa el juego con un tamaño de 5

        GridPane grid = new GridPane();
        Celda[][] celdas = juego.getTablero().getTablero(); // Obtiene las celdas del tablero

        // Crear la matriz visual
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                Button btnCelda = new Button(celdas[i][j].getSolucion() ? "■" : "X");
                btnCelda.setPrefSize(50, 50); // Ajusta el tamaño de los botones
                grid.add(btnCelda, j, i);
                int fila = i;
                int columna = j;

                // Manejo de eventos para marcar las celdas
                btnCelda.setOnAction(event -> {
                    celdas[fila][columna].marcarRelleno(); // Marca la celda como "rellena"
                    actualizarMatriz(grid);
                    verificarJuegoTerminado();
                });
            }
        }
        
        // Mensaje que muestra el toString del tablero
        Label tableroLabel = new Label(juego.getTablero().toString());
        tableroLabel.setStyle("-fx-text-fill: red;"); // Inicialmente rojo

        // Mensaje de estado
        mensajeEstado = new Label("No ha terminado el puzzle");
        mensajeEstado.setTextFill(Color.RED);

        // Contenedor principal
        VBox root = new VBox(grid, tableroLabel, mensajeEstado); // Asegúrate de incluir tableroLabel
        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Juego Picross");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Actualiza la matriz visual
    private void actualizarMatriz(GridPane grid) {
        Celda[][] celdas = juego.getTablero().getTablero();
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                Button btnCelda = (Button) grid.getChildren().get(i * celdas.length + j);
                btnCelda.setText(celdas[i][j].getEstado() == EstadoCelda.RELLENO ? "■" : "X");
            }
        }
    }

    // Verifica si el juego ha terminado
    private void verificarJuegoTerminado() {
        // Verifica si el juego ha terminado
        if (juego.isJuegoTerminado()) {
            juego.setJuegoTerminado(true); // Establecer que el juego ha terminado
            mensajeEstado.setText("¡Has terminado el puzzle!");
            mensajeEstado.setTextFill(Color.GREEN);
        } else {
            mensajeEstado.setText("No ha terminado el puzzle");
            mensajeEstado.setTextFill(Color.RED);
        }
    }
}
