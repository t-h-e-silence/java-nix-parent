package com.alevel.java.nix.collections.List;

import java.util.AbstractList;

public class ForwardLinkedList<T> extends AbstractList {

    private int listCount;
    private Node<T> head;

    public ForwardLinkedList() {
        head = new Node<>(null);
        listCount = 0;
    }

    public boolean add(Object data) {
        Node newNode = new Node(data);
        Node currentNode = head;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode=newNode;
        listCount++;
        return true;
    }

    public void add(T data, int index) {

        if (index <= listCount && index > 0) {
            Node<T> newNode = new Node<>(data);
            Node<T> currentNode = head;

            for (int i = 1; i < index; i++) {
                currentNode = currentNode.nextNode;
            }
            newNode.nextNode=currentNode.nextNode;
            currentNode.nextNode=newNode;
            listCount++;
        }
    }

    public Node get(int index) {

        if (index > listCount || index <= 0)
            return null;

        Node<T> currentNode = head;
        for (int i = 1; i <= index; i++) {
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    @Override
    public Object remove(int index) {
        if (index > listCount || index <= 0)
            return false;

        Node<T> currentNode = head;
        for (int i = 0; i < index - 2; i++) {
            currentNode = currentNode.nextNode;
        }

        currentNode.nextNode=currentNode.nextNode.nextNode;
        listCount--;
        return true;
    }

    public int size() {
        return listCount;
    }
}
