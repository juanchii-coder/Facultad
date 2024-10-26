package picross.Vista;

import picross.Controlador.*;
import picross.Modelo.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class PicrossGame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton[][] buttons; // Matriz para los botones

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Juego juego = new Juego("", 5); // Tamaño del tablero: 5x5 (ajustar según necesidad)
                PicrossGame frame = new PicrossGame(juego);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PicrossGame(Juego juego) {
        int tamanio = juego.getTablero().getTamanio();
        Tablero tablero = juego.getTablero();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 500); // Tamaño inicial de la ventana
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        contentPane.setLayout(gbl_contentPane);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;

        buttons = new JButton[tamanio][tamanio]; // Inicializar matriz de botones

        // Botón de verificación de solución
        JButton topButton = new JButton("solucion");
        gbc.gridx = 0; // Columna
        gbc.gridy = 0; // Fila
        contentPane.add(topButton, gbc);
        topButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                if (juego.esSolucionCorrecta()) {
                    System.out.println("Puzzle Terminado");
                    juego.setJuegoTerminado(true);
                    dispose();
                    PicrossEnd picrossEnd = new PicrossEnd(juego);
                    picrossEnd.pack();
                    picrossEnd.setVisible(true);
                } else {
                    topButton.setText("X");
                    topButton.setForeground(Color.RED);
                    System.out.println(juego.mostrarTableroActual());
                }
            }
        });

        // Crear botones en el tablero
        for (int i = 1; i < tamanio + 1; i++) {
            for (int j = 1; j < tamanio + 1; j++) {
                JButton button = new JButton("");
                buttons[i - 1][j - 1] = button;
                gbc.gridx = j; // Columna
                gbc.gridy = i; // Fila
                contentPane.add(button, gbc);

                final int fila = i;
                final int columna = j;

                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            if (button.getBackground() == java.awt.Color.BLACK) {
                                button.setBackground(java.awt.Color.WHITE);
                                button.setText("");
                                juego.setCelda(fila - 1, columna - 1, EstadoCelda.DESCONOCIDO);
                                System.out.println("se puso vacia la celda de la columna "+(columna-1)+" y la fila "+(fila-1));
                            } else {
                                button.setBackground(java.awt.Color.BLACK);
                                button.setText("");
                                juego.setCelda(fila - 1, columna - 1, EstadoCelda.RELLENO);
                                System.out.println("se relleno la celda de la columna "+(columna-1)+" y la fila "+(fila-1));
                            }
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                            if (button.getText().equals("X")) {
                                button.setText("");
                                button.setBackground(java.awt.Color.WHITE);
                                juego.setCelda(fila - 1, columna - 1, EstadoCelda.DESCONOCIDO);
                                System.out.println("se puso vacia la celda de la columna "+(columna-1)+" y la fila "+(fila-1));
                            } else {
                                button.setText("X");
                                button.setBackground(java.awt.Color.WHITE);
                                juego.setCelda(fila - 1, columna - 1, EstadoCelda.MARCADO);
                                System.out.println("se marco con una x la celda de la columna "+(columna-1)+" y la fila "+(fila-1));
                            }
                        }
                    }
                });
            }
        }

        // Filas (Pistas)
        for (int i = 0; i < tamanio; i++) {
            JLabel label = new JLabel(tablero.getpFilas()[i].toString());
            label.setHorizontalAlignment(SwingConstants.CENTER);
            gbc.gridx = 0; // Columna
            gbc.gridy = i + 1; // Fila
            contentPane.add(label, gbc);
        }

        // Columnas (Pistas)
        for (int i = 0; i < tamanio; i++) {
            JLabel label = new JLabel(tablero.getpColumnas()[i].toString());
            label.setHorizontalAlignment(SwingConstants.CENTER);
            gbc.gridx = i + 1; // Columna
            gbc.gridy = 0; // Fila
            contentPane.add(label, gbc);
        }

        // Listener para mantener los botones cuadrados
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeButtons(tamanio);
            }
        });

        // Redimensionar botones al inicio
        resizeButtons(tamanio);
    }

    private void resizeButtons(int tamanio) {
        Insets insets = getInsets();
        int availableWidth = getWidth() - insets.left - insets.right;
        int availableHeight = getHeight() - insets.top - insets.bottom - 40; // Ajustar por el espacio de la etiqueta superior

        int width = availableWidth / (tamanio + 1); // Ancho por botón (más uno para la columna de pistas)
        int height = availableHeight / (tamanio + 1); // Alto por botón (restar espacio para etiquetas)
        int size = Math.min(width, height); // Asegura un tamaño cuadrado

        for (JButton[] row : buttons) {
            for (JButton b : row) {
                b.setPreferredSize(new java.awt.Dimension(size, size));
                b.setMinimumSize(new java.awt.Dimension(size, size));
                b.setMaximumSize(new java.awt.Dimension(size, size));
            }
        }
        revalidate(); // Volver a validar el panel
        repaint(); // Volver a dibujar el panel
    }
}
