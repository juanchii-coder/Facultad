package picross.Vista;

import picross.Controlador.*;
import picross.Modelo.*;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class PicrossEnd extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Juego juego = new Juego("", 5);
                PicrossEnd frame = new PicrossEnd(juego);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public PicrossEnd(Juego juego) {
        Jugador jugador = juego.getJugador();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout()); // Usar GridBagLayout

        // Crear y configurar JLabel para el nombre del jugador
        JLabel lblNewLabel = new JLabel("Jugador: " + jugador.getNombre());
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.insets = new Insets(5, 5, 5, 5);
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.weightx = 1.0; // Permitir que el componente ocupe el espacio adicional en x
        gbc1.weighty = 0.1; // Espacio en y, ajustable según tu preferencia
        gbc1.gridx = 0; // Columna
        gbc1.gridy = 0; // Fila
        gbc1.gridwidth = 2; // Ocupa dos columnas
        contentPane.add(lblNewLabel, gbc1);

        // Crear y configurar JLabel para el tiempo total
        JLabel lblNewLabel_1 = new JLabel("Tiempo: " + juego.getTiempoTotal());
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(5, 5, 5, 5);
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.weightx = 1.0; // Permitir que el componente ocupe el espacio adicional en x
        gbc2.weighty = 0.1; // Espacio en y, ajustable según tu preferencia
        gbc2.gridx = 0; // Columna
        gbc2.gridy = 1; // Fila
        gbc2.gridwidth = 2; // Ocupa dos columnas
        contentPane.add(lblNewLabel_1, gbc2);

        // Crear y configurar botón "Volver a jugar"
        JButton btnNewButton = new JButton("Volver a jugar");
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.insets = new Insets(5, 5, 5, 5);
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.weightx = 0.5; // Ocupa la mitad del espacio en x
        gbc3.weighty = 0.5; // Ocupa la mitad del espacio en y
        gbc3.gridx = 0; // Columna
        gbc3.gridy = 2; // Fila
        gbc3.gridwidth = 1; // Ocupa una columna
        contentPane.add(btnNewButton, gbc3);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PicrossWindow picrossWindow = new PicrossWindow();
                picrossWindow.setVisible(true);
            }
        });

        // Crear y configurar botón "Cerrar Aplicación"
        JButton btnNewButton_1 = new JButton("Cerrar Aplicación");
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.insets = new Insets(5, 5, 5, 5);
        gbc4.fill = GridBagConstraints.BOTH;
        gbc4.weightx = 0.5; // Ocupa la mitad del espacio en x
        gbc4.weighty = 0.5; // Ocupa la mitad del espacio en y
        gbc4.gridx = 1; // Columna
        gbc4.gridy = 2; // Fila
        gbc4.gridwidth = 1; // Ocupa una columna
        contentPane.add(btnNewButton_1, gbc4);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack(); // Ajustar el tamaño del JFrame al contenido
    }
}

