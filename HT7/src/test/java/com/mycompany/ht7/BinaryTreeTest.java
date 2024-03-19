package com.mycompany.ht7;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
import com.mycompany.ht7.BinaryTree;
import static org.junit.Assert.*;
import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testInsertar() {
        BinaryTree<String, String> tree = new BinaryTree<>();
        tree.insert("house", "casa");
        tree.insert("dog", "perro");
        tree.insert("homework", "tarea");

        assertEquals("casa", tree.search("house"));
        assertEquals("perro", tree.search("dog"));
        assertEquals("tarea", tree.search("homework"));
    }

    @Test
    public void testBuscar() {
        BinaryTree<String, String> tree = new BinaryTree<>();
        tree.insert("house", "casa");
        tree.insert("dog", "perro");
        tree.insert("homework", "tarea");

        assertEquals("casa", tree.search("house"));
        assertEquals("perro", tree.search("dog"));
        assertEquals("tarea", tree.search("homework"));

        assertNull(tree.search("cat"));
    }
}
