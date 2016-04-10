package com.liebe.list;

/**
 * Created by sjtu on 16-2-25.
 */
public class Node {
    private Object element;
    private Node nextNode;

    public Node(Node nextNode){
        this.nextNode = nextNode;
    }

    public Node(Object element,Node nextNode){
        this.element = element;
        this.nextNode = nextNode;
    }

    public Object getElement(){return this.element;}
    public void setElement(Object value){this.element = value;}

    public Node getNextNode(){return this.nextNode;}
    public void setNextNode(Node nextNode){this.nextNode = nextNode;}

}
