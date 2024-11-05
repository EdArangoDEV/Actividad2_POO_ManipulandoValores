package edu.actividad1.poo2.actividad2_poo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Button LargoPalabras;

    @FXML
    private Button MayMin;

    @FXML
    private Button contarVocales;

    @FXML
    private Label lbLargoP;

    @FXML
    private Label lbMayMin;

    @FXML
    private Label lbVocales;

    @FXML
    private TextField textField;

    @FXML
    private Button botonLimpiar;

    // Contador para el botón MayMin
    private int mayMinClickCount = 0;

    @FXML
    void clicLargoPalabras(ActionEvent event) {
        String texto = textField.getText();
        String[] palabras = texto.split("\\s+"); // Divide el texto en palabras
        String palabraMasLarga = "";
        String palabraMasCorta = palabras[0];
        int totalLetras = texto.replace(" ", "").length(); // Total de letras sin contar espacios

        for (String palabra : palabras) {
            if (palabra.length() > palabraMasLarga.length()) {
                palabraMasLarga = palabra;
            }
            if (palabra.length() < palabraMasCorta.length()) {
                palabraMasCorta = palabra;
            }
        }

        lbLargoP.setText("Más larga: " + palabraMasLarga + ", Más pequeña: " + palabraMasCorta + ", Total letras: " + totalLetras);
    }


    @FXML
    void clicMayMIn(ActionEvent event) {
        String texto = textField.getText();
        mayMinClickCount++;

        switch (mayMinClickCount) {
            case 1:
                lbMayMin.setText(texto.toUpperCase()); // Mostrar en mayúsculas
                break;
            case 2:
                lbMayMin.setText(texto.toLowerCase()); // Mostrar en minúsculas
                break;
            case 3:
                String[] palabras = texto.split("\\s+");
                StringBuilder resultado = new StringBuilder();

                for (int i = 0; i < palabras.length; i++) {
                    if (i % 2 == 0) { // Posición impar
                        resultado.append(palabras[i].toUpperCase());
                    } else { // Posición par
                        resultado.append(palabras[i].toLowerCase());
                    }
                    resultado.append(" "); // Agregar espacio entre palabras
                }

                lbMayMin.setText(resultado.toString().trim()); // Mostrar resultado final
                mayMinClickCount = 0; // Reiniciar contador después de la tercera acción
                break;
        }
    }

    @FXML
    void clicVocales(ActionEvent event) {
        String texto = textField.getText();
        int contadorVocales = 0;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if ("aeiouAEIOU".indexOf(c) != -1) { // Comprobar si es vocal
                contadorVocales++;
            }
        }

        lbVocales.setText("La cantidad de vocales en el texto es: " + contadorVocales);
    }


    @FXML
    void clicLimpiar(ActionEvent event) {
        final String texto = "Esperando el ingreso del texto";
        textField.setText("");
        lbLargoP.setText(texto);
        lbVocales.setText(texto);
        lbMayMin.setText(texto);
    }
}
