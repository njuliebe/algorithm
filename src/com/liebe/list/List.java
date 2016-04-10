package com.liebe.list;

import java.util.Date;
/**
 * Created by sjtu on 16-2-25.
 */
public class List {
    Node head;
    int size;
    Node current;

    public List(){
        this.head = new Node(null);
        this.current = this.head;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public Node findElement(Object element){
        Node tmp;
        tmp = head.getNextNode();
        while(tmp!=null && tmp.getElement()!=element){
            tmp = tmp.getNextNode();
        }
        return tmp;
    }

    public int findElementIndex(Object element){
        Node tmp = head.getNextNode();
        int  i = 1;
        while(tmp!=null && tmp.getElement()!=element){
            tmp = tmp.getNextNode();
            i++;
        }
        return i;
    }

    public int findElementIndexRecur(Node node,Object element){
        int index = 1;
        while(node != null && node.getElement()!=element){
            node = node.getNextNode();
            findElementIndexRecur(node,element);
            index++;
        }
        return index;
    }

    public Node findPrevious(Node node){
        Node tmp;
        tmp = head;
        while(tmp.getNextNode()!=null && tmp.getNextNode()!=node){
            tmp = tmp.getNextNode();
        }
        return tmp;
    }

    public void insertElement(Object element,Node position){
        Node tmp = new Node(element,position.getNextNode());
        position.setNextNode(tmp);
        size++;
    }

    public Node getNode(int index){
        if(index<0||index>size){
            System.out.println("error index");
            return null;
        }
        Node tmp = head;
        for(int i=1;i<index+1;i++){
            tmp = tmp.getNextNode();
        }
        return tmp;
    }

    public void insertElement(Object element, int index){
        Node position = getNode(index);
        Node tmp;
        tmp = new Node(element,position.getNextNode());
        position.setNextNode(tmp);
        size++;
    }

    public void delElement(int index){
        Node position = getNode(index-1);
        position.setNextNode(position.getNextNode().getNextNode());
        size--;
    }

    public void printList(){
        System.out.println("list size: " + size);
        Node tmp = head.getNextNode();
        while(tmp!=null){
            System.out.println(tmp.getElement());
            tmp=tmp.getNextNode();
        }
    }

    public void reverseList(){
        Node current, previous, next;
        current = head.getNextNode();
        next = current.getNextNode();

        current.setNextNode(null);

        while(next != null){
            previous = current;
            current = next;
            next = current.getNextNode();

            current.setNextNode(previous);
        }
        head.setNextNode(current);
    }

    public static void main(String[] args){
        List list = new List();
        for(int i=0;i<20;i++){
            list.insertElement((Integer) i,i);
        }

//        Date date = new Date();
        long begin, end;

        System.out.println("init list");
        list.printList();

//        begin = System.nanoTime();
//        System.out.println("find 50 at " + list.findElementIndex((Integer) 20));
//        end = System.nanoTime();
//        System.out.println("non recursion cost "+(end-begin)+" ns");
//
//        Node first = list.head.getNextNode();
//        begin = System.nanoTime();
//        System.out.println("find 50 at "+list.findElementIndexRecur(first,20));
//        end = System.nanoTime();
//        System.out.println("recursion cost "+(end-begin)+" ns");

        list.reverseList();
        list.printList();

/*
        System.out.println("init list");
        System.out.println("list size: "+list.size);
        list.printList();

        list.delElement(5);
        System.out.println("list size: " + list.size);
        list.printList();

        System.out.println("add in head");
        list.insertElement((Integer) 100, list.head);
        System.out.println("list size: " + list.size);
        list.printList();

        Node node3 = list.getNode(3);
        list.insertElement((Integer) 200, node3);
        System.out.println("list size: " + list.size);
        list.printList();

//        node3 = list.findElement((Integer) 7);
//        list.insertElement((Integer) 300, node3);
//        System.out.println("list size: " + list.size);
//        list.printList();

        list.delElement(5);
        System.out.println("list size: " + list.size);
        list.printList();
*/
    }

}
