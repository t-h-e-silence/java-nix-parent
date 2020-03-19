package com.alevel.java.nix.collections.List;

public class Node<T> {

    protected Node<T> nextNode;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
