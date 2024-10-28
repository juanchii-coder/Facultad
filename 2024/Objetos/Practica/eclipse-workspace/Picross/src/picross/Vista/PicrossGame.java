package picross.Vista;

import picross.Controlador.*;
import picross.Modelo.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
	private class PicrossButton extends JButton {
		private boolean isMarked = false;

		public PicrossButton() {
			setContentAreaFilled(false);
			setOpaque(true);
		}

		public void setMarked(boolean marked) {
			this.isMarked = marked;
			repaint(); // Redibuja el botón
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (isMarked) {
				Graphics2D g2d = (Graphics2D) g; // Cast a Graphics2D
				g2d.setColor(Color.BLACK); // Color de la "X"
				g2d.setStroke(new BasicStroke(3)); // Define el grosor de la línea (3 es un ejemplo)

				// Dibuja la "X" con las líneas más gruesas
				g2d.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
				g2d.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
			}
		}

	}
	
	private class SolutionPanel extends JPanel {
	    private Celda[][] solution; // Matriz de Celdas que representa la solución

	    public SolutionPanel(int size) {
	        this.solution = new Celda[size][size]; // Inicializa la matriz de solución
	        for (int i = 0; i < size; i++) {
	            for (int j = 0; j < size; j++) {
	                solution[i][j] = new Celda(j, i); // Inicializa cada celda
	            }
	        }
	        setPreferredSize(new Dimension(200, 200)); // Ajusta el tamaño según lo necesites
	    }

	    public void setSolution(Celda[][] solution) {
	        this.solution = solution;
	        repaint(); // Redibuja el panel con la nueva solución
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        int size = Math.min(getWidth(), getHeight()) / solution.length;

	        for (int i = 0; i < solution.length; i++) {
	            for (int j = 0; j < solution[i].length; j++) {
	                Celda celda = solution[i][j];

	                // Solo dibuja celdas que están en la solución y son del estado RELLENO
	                if (celda.getSolucion() && celda.getEstado() == EstadoCelda.RELLENO) {
	                    g.setColor(Color.BLACK);
	                    g.fillRect(j * size, i * size, size, size); // Dibuja el cuadrado
	                    g.setColor(Color.GRAY); // Color del borde
	                    g.drawRect(j * size, i * size, size, size); // Dibuja el borde
	                }
	            }
	        }
	    }
	}



	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PicrossButton[][] buttons; // Matriz para los botones

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Juego juego = new Juego("", 5); // Tamaño del tablero: 5x5 (ajustar según necesidad)
				PicrossGame frame = new PicrossGame(juego);
				System.out.println(juego.getTablero().toString());
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public PicrossGame(Juego juego) {
		int tamanio = juego.getTablero().getTamanio();
		Tablero tablero = juego.getTablero();

		// Configuración de la ventana principal
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600); // Ajustar el tamaño según lo necesario
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout()); // Configurar GridLayout para 2x2
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		
		// Cuadrante 0,0 - Display del estado actual del puzzle
		SolutionPanel displayPanel = new SolutionPanel(juego.getTablero().getTablero().length);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.weightx = 0.1;
	    gbc.weighty = 0.1;
	    gbc.fill = GridBagConstraints.BOTH;
		contentPane.add(displayPanel,gbc);

		// Cuadrante pistas filas
		JPanel buttonPanelTop = new JPanel(new GridBagLayout());
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.weightx = 1;
	    gbc.weighty = 0.3;
	    gbc.fill = GridBagConstraints.BOTH;
	    contentPane.add(buttonPanelTop, gbc);

	    // Configuración para el panel de pistas de filas (parte izquierda)
	    JPanel buttonPanelLeft = new JPanel(new GridBagLayout());
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.weightx = 0.3;
	    gbc.weighty = 1;
	    gbc.fill = GridBagConstraints.BOTH;
	    contentPane.add(buttonPanelLeft, gbc);

		// Agregar pistas de las columnas en el panel superior (buttonPanelTop)
		for (int col = 0; col < tamanio; col++) {
		    int numPistasColumna = tablero.getpColumnas()[col].getValor().size();
		    for (int j = 0; j < numPistasColumna; j++) {
		        JLabel label = new JLabel(tablero.getpColumnas()[col].getValor().get(j).toString());
		        label.setHorizontalAlignment(SwingConstants.CENTER);

		        gbc.gridx = col;
		        gbc.gridy = j-tamanio;
		        buttonPanelTop.add(label, gbc);
		    }
		}

		// Agregar pistas de las filas en el panel izquierdo (buttonPanelLeft)
		for (int row = 0; row < tamanio; row++) {
		    int numPistasFila = tablero.getpFilas()[row].getValor().size();
		    for (int j = 0; j < numPistasFila; j++) {
		        JLabel label = new JLabel(tablero.getpFilas()[row].getValor().get(j).toString());
		        label.setHorizontalAlignment(SwingConstants.CENTER);

		        gbc.gridx = j-tamanio;
		        gbc.gridy = row;
		        buttonPanelLeft.add(label, gbc);
		    }
		}

		// Cuadrante 1,1 - Matriz principal de botones
		JPanel buttonPanelBottom = new JPanel(new GridLayout(tamanio, tamanio));
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.weightx = 1;
	    gbc.weighty = 1;
		contentPane.add(buttonPanelBottom,gbc);
		
		buttons = new PicrossButton[tamanio][tamanio];

		// Crear botones en la matriz principal (Cuadrante 1,1)
		for (int i = 0; i < tamanio; i++) {
			for (int j = 0; j < tamanio; j++) {
				PicrossButton button = new PicrossButton();
				buttons[i][j] = button;
				buttonPanelBottom.add(button); // Añadir al panel correspondiente

				final int fila = i;
				final int columna = j;

				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						if (e.getButton() == MouseEvent.BUTTON1) {
							if (button.getBackground() == Color.BLACK) {
								button.setBackground(null);
								button.setMarked(false);
								juego.setCelda(fila, columna, EstadoCelda.DESCONOCIDO);
							} else {
								button.setBackground(Color.BLACK);
								button.setMarked(false);
								juego.setCelda(fila, columna, EstadoCelda.RELLENO);
							}
						} else if (e.getButton() == MouseEvent.BUTTON3) {
							if (button.isMarked) {
								button.setMarked(false);
								juego.setCelda(fila, columna, EstadoCelda.DESCONOCIDO);
							} else {
								button.setMarked(true);
								button.setBackground(null);
								juego.setCelda(fila, columna, EstadoCelda.MARCADO);
							}
						}
						Celda[][] currentSolution = juego.getTablero().getTablero(); // Asegúrate de que este método retorna la solución actual
				        displayPanel.setSolution(currentSolution);
						
						if(juego.esSolucionCorrecta()) {
							juego.setJuegoTerminado(true);
							dispose();
							PicrossEnd picrossEnd= new PicrossEnd(juego);
							picrossEnd.setVisible(true);
						}
					}
				});
			}
		}
		


		// Mantener los botones cuadrados
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				resizeButtons(tamanio);
			}
		});
		resizeButtons(tamanio);
	}

	private void resizeButtons(int tamanio) {
	    Insets insets = getInsets();
	    int availableWidth = getWidth() - insets.left - insets.right;
	    int availableHeight = getHeight() - insets.top - insets.bottom - 40; // Ajusta este valor según tus necesidades

	    // Calcula el tamaño del botón asegurando que sea cuadrado
	    int size = Math.min(availableWidth / tamanio, availableHeight / tamanio);

	    for (PicrossButton[] row : buttons) {
	        for (PicrossButton b : row) {
	            b.setPreferredSize(new Dimension(size, size));
	            b.setMinimumSize(new Dimension(size, size));
	            b.setMaximumSize(new Dimension(size, size));
	        }
	    }
	    revalidate(); // Revalida el contenedor para que los cambios surtan efecto
	    repaint(); // Redibuja la interfaz
	}

}
