package picross.Vista;

import picross.Controlador.*;
import picross.Modelo.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("unused")
public class PicrossWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PicrossWindow frame = new PicrossWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PicrossWindow() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("tamaño de la matriz:");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(92, 105, 249, 37);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(92, 153, 249, 37);
		contentPane.add(textField);
		textField.setColumns(10);



		textField_1 = new JTextField();
		textField_1.setBounds(92, 57, 249, 37);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre del Jugador:");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(92, 11, 249, 35);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Iniciar Juego");
		btnNewButton.setBounds(92, 201, 249, 49);
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tamanio = textField.getText();
				String nombre= textField_1.getText();
				try {
                    int tamanioMatriz = Integer.parseInt(tamanio);
                    Juego juego = new Juego(nombre, tamanioMatriz);

                    dispose();

                    PicrossGame picrossGame = new PicrossGame(juego);
                    picrossGame.pack();
                    picrossGame.setVisible(true);
                    System.out.print(juego.getTablero().toString());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingresa un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
			}
		});

		contentPane.add(btnNewButton);

	}
}
