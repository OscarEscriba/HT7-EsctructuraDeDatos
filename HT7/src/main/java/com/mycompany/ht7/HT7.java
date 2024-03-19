/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ht7;

/**
 *
 * @author Oscar Escriba
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HT7 {

    public static void main(String[] args) {
        BinaryTree<String, String> dictionary = new BinaryTree<>();

        // Leer el archivo diccionario.txt y construir el árbol binario
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Oscar Escriba\\Desktop\\7mo semestre UVG\\Algoritmos y estructura de datos\\HT7-EsctructuraDeDatos\\HT7\\src\\main\\java\\com\\mycompany\\ht7\\diccionario.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    String englishWord = parts[0].substring(1).trim();
                    String spanishWord = parts[1].substring(0, parts[1].length() - 1).trim();
                    dictionary.insert(englishWord.toLowerCase(), spanishWord.toLowerCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Recorrer el árbol en in-order para mostrar las asociaciones ordenadas por inglés
        dictionary.inOrderTraversal();

        // Traducir el archivo texto.txt
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Oscar Escriba\\Desktop\\7mo semestre UVG\\Algoritmos y estructura de datos\\HT7-EsctructuraDeDatos\\HT7\\src\\main\\java\\com\\mycompany\\ht7\\texto.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] words = line.split(" ");
                    for (String word : words) {
                        String translation = dictionary.search(word.toLowerCase());
                        if (translation != null) {
                            System.out.print(translation + " ");
                        } else {
                            System.out.print("*" + word + "* ");
                        }
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}