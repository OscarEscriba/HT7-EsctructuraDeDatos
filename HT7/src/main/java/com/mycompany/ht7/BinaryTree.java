/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ht7;

/**
 *
 * @author Oscar Escriba
 */ 
public class BinaryTree<K extends Comparable<K>, V> {
    private Node<K, V> root;

    public void insert(K key, V value) {
        root = insertRec(root, key, value);
    }

    private Node<K, V> insertRec(Node<K, V> root, K key, V value) {
        if (root == null) {
            return new Node<>(key, value);
        }

        if (key.compareTo(root.key) < 0) {
            root.left = insertRec(root.left, key, value);
        } else if (key.compareTo(root.key) > 0) {
            root.right = insertRec(root.right, key, value);
        }

        return root;
    }

    public void inOrderTraversal() {
        inOrderTraversalRec(root);
        System.out.println();
    }

    private void inOrderTraversalRec(Node<K, V> root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.print("(" + root.key + ", " + root.value + ") ");
            inOrderTraversalRec(root.right);
        }
    }

    public V search(K key) {
        return searchRec(root, key);
    }

    private V searchRec(Node<K, V> root, K key) {
        if (root == null || key == null) {
            return null;
        }

        if (key.compareTo(root.key) == 0) {
            return root.value;
        }

        if (key.compareTo(root.key) < 0) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }
}
