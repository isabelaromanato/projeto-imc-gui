package br.com.academia.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ImcGui {

	public void desenharTela() {

//		Color minhaCor = new Color(172, 57, 61);
		Color minhaCor = new Color(218, 17, 17);
		Font fontTitulo = new Font("Consolas", Font.BOLD, 28);
		Font fontResultado = new Font("Consolas", Font.BOLD, 45);
		// Font fontStatus = new Font("Consolas", Font.BOLD, 20);

		JFrame telaImc = new JFrame();
		telaImc.setSize(450, 350);
		telaImc.setTitle("Calculadora IMC");
		telaImc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		telaImc.getContentPane().setBackground(Color.black);
		telaImc.getContentPane().setBackground(Color.white);
		telaImc.setLayout(null);

		JLabel tituloImc = new JLabel();
		tituloImc.setBounds(10, 10, 100, 30);
		tituloImc.setFont(fontTitulo);
		tituloImc.setForeground(minhaCor);
		tituloImc.setText("IMC");

		JLabel subtituloImc = new JLabel();
		subtituloImc.setBounds(10, 40, 200, 30);
		subtituloImc.setText("Índice de massa corporal");
		subtituloImc.setForeground(Color.black);

		JLabel labelPeso = new JLabel();
		labelPeso.setBounds(10, 90, 300, 30);
		labelPeso.setText("Qual o seu peso?");
		labelPeso.setForeground(Color.black);

		JTextField textFieldPeso = new JTextField();
		textFieldPeso.setBounds(10, 120, 200, 30);
		textFieldPeso.setForeground(Color.black);
		textFieldPeso.setHorizontalAlignment(JTextField.RIGHT);

		JLabel labelAltura = new JLabel();
		labelAltura.setBounds(10, 170, 350, 30);
		labelAltura.setText("Qual a sua altura?");
		labelAltura.setForeground(Color.black);

		JTextField textFieldAltura = new JTextField();
		textFieldAltura.setBounds(10, 200, 200, 30);
		textFieldAltura.setForeground(Color.black);
		textFieldAltura.setHorizontalAlignment(JTextField.RIGHT);

		JLabel labelResultado = new JLabel();
		labelResultado.setBounds(218, 110, 220, 130);
		labelResultado.setForeground(minhaCor);
		labelResultado.setFont(fontResultado);
		labelResultado.setHorizontalAlignment(JLabel.CENTER);

		JLabel labelStatus = new JLabel();
		labelStatus.setBounds(230, 170, 200, 80);
		labelStatus.setFont(fontTitulo);
		labelStatus.setForeground(Color.green);
		labelStatus.setHorizontalAlignment(JLabel.CENTER);

		JButton buttonCalcular = new JButton();
		buttonCalcular.setBounds(10, 250, 200, 30);
		buttonCalcular.setForeground(Color.black);
		buttonCalcular.setText("Calcular IMC");
		buttonCalcular.setBackground(minhaCor);

		telaImc.getContentPane().add(tituloImc);
		telaImc.getContentPane().add(subtituloImc);
		telaImc.getContentPane().add(labelPeso);
		telaImc.getContentPane().add(textFieldPeso);
		telaImc.getContentPane().add(labelAltura);
		telaImc.getContentPane().add(textFieldAltura);
		telaImc.getContentPane().add(buttonCalcular);
		telaImc.getContentPane().add(labelResultado);
		telaImc.getContentPane().add(labelStatus);

		telaImc.setVisible(true);

		// *** Ouvintes de eventos ***
		// LISTENER -> OUVINTE

		buttonCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				double peso = Double.parseDouble(textFieldPeso.getText());
				double altura = Double.parseDouble(textFieldAltura.getText());
				double imc = calcularImc(peso, altura);

				labelResultado.setText(String.format("%.2f", imc));

			}
		});
		// evento de tecla

		textFieldPeso.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("Code: " + e.getKeyCode());
				System.out.println("Char: " + e.getKeyChar());

				if (e.getKeyCode() == 10) {
					textFieldAltura.requestFocus();
				}
			}
		});

		textFieldAltura.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				int x = textFieldAltura.getX();
				int y = textFieldAltura.getY();

				if (e.getKeyCode() == 39) {

					textFieldAltura.setBounds(x + 1, y, 130, 40);

				} else if (e.getKeyCode() == 37) {
					textFieldAltura.setBounds(x - 1, y, 130, 40);

				} else if (e.getKeyCode() == 38) {
					textFieldAltura.setBounds(x, y - 5, 130, 40);
					
				} else if (e.getKeyCode() == 40) {
					textFieldAltura.setBounds(x, y + 5, 130, 40);
				}
			}
				});

	}// fim do método desenhar tela

	private double calcularImc(double peso, double altura) {
		return peso / Math.pow(altura, 2);
	}

}// fim da classe IMC-gui
