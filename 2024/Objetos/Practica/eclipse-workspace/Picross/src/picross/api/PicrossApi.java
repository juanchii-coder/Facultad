package picross.api;

import picross.Modelo.*;
import picross.Controlador.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import picross.Modelo.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class PicrossApi {
    public static void main(String[] args) {
        SpringApplication.run(PicrossApi.class, args);
    }
}

@RestController
@RequestMapping("/api")
class PicrossController {
    private final Juego juego;

    public PicrossController() {
        // Inicializar el juego con un tamaño de tablero predeterminado (e.g., 5x5) y un jugador
        this.juego = new Juego("Jugador 1", 5);
    }

    @GetMapping("/tablero")
    public Map<String, Object> getTablero() {
        Map<String, Object> response = new HashMap<>();
        response.put("tablero", juego.getTablero().getTablero());
        response.put("pistasFilas", juego.getTablero().getpFilas());
        response.put("pistasColumnas", juego.getTablero().getpColumnas());
        return response;
    }

    @PostMapping("/jugar")
    public Map<String, String> jugar(@RequestParam int fila, @RequestParam int columna, @RequestParam String estado) {
        EstadoCelda nuevoEstado;
        switch (estado.toUpperCase()) {
            case "RELLENO":
                nuevoEstado = EstadoCelda.RELLENO;
                break;
            case "MARCADO":
                nuevoEstado = EstadoCelda.MARCADO;
                break;
            default:
                nuevoEstado = EstadoCelda.DESCONOCIDO;
                break;
        }

        juego.setCelda(fila, columna, nuevoEstado);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Celda actualizada correctamente.");
        return response;
    }

    @GetMapping("/estado")
    public Map<String, Object> getEstadoJuego() {
        Map<String, Object> response = new HashMap<>();
        response.put("juegoTerminado", juego.isJuegoTerminado());
        response.put("solucionCorrecta", juego.esSolucionCorrecta());
        response.put("tiempo", juego.getTiempoTotal());
        return response;
    }
}
