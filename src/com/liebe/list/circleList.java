package com.liebe.list;

/**
 * Created by sjtu on 16-2-27.
 */
public class circleList {
    Node head;
    int size;
    Node currentNode;

    public circleList(Object element){
        head = new Node(element,null);
        head.setNextNode(head);
        size = 1;
    }

    public Node getNode(int index){
        if(index<0 || index>size-1){
            System.out.println("wrong index");
            System.exit(1);
        }
        Node tmp = head;
        for(int i=0;i<index;i++){
            tmp=tmp.getNextNode();
        }
        return tmp;
    }

    public void insertElement(Object element,int index){
        if(index<0 || index>size-1){
            System.out.println("wrong index");
            System.exit(1);
        }
        Node current = getNode(index);
        Node tmp = new Node(element,current.getNextNode());
        current.setNextNode(tmp);
        size++;
    }

    public void printList(){
        System.out.println("list size " + size);
        Node tmp = head;
        for(int i=0;i<size+1;i++){
            System.out.println(tmp.getElement());
            tmp = tmp.getNextNode();
        }
    }

    public Object delElement(int index){
        Node current = getNode(index-1);
        Object del = current.getNextNode().getElement();
        current.setNextNode(current.getNextNode().getNextNode());
        size--;
        System.out.println("delete " + del);
        return del;
    }

    public Node getPrevious(Node node){
        Node tmp = head;
        int i=0;
        while(i<size&&tmp.getNextNode() != node){
            tmp=tmp.getNextNode();
        }
        return tmp;
    }

    public Object delElement(Node node){
        if(node == head){
            head = head.getNextNode();
        }
        Node previous = getPrevious(node);
        previous.setNextNode(node.getNextNode());
        size--;
        System.out.println("delete element "+node.getElement());
        return node.getElement();
    }

    public Node moveSize(Node currentNode,int length){
        Node tmp = currentNode;
        for(int i=0;i<length;i++){
            tmp = tmp.getNextNode();
        }
        return tmp;
    }

    //递归求解删除顺序
    public void Josephus(Node currentNode,int M,int N){
        Node toDel = moveSize(currentNode,M);
        delElement(toDel);

        Node nextCurrent = toDel.getNextNode();
        int nextN = N-1;
        if(nextN>1)
            Josephus(nextCurrent,M,nextN);
    }

    //非递归求解删除顺序
    //O(n*m)
    public void Josephus2(Node currentNode, int M, int N){
        for(int i=0;i<N;i++){
            Node toDel = moveSize(currentNode,M);
            delElement(toDel);
            currentNode = toDel.getNextNode();
        }
    }

    //求解最后被删除的序号
    //O(n)
    public int Josephus(int n, int k){
        int s = 0;
        for(int i=2;i<=n;i++){
            s = (s+k)%i;
        }
        return s;
    }


    public static void main(String []args){
        circleList list = new circleList(0);
        for(int i=1;i<10;i++){
            list.insertElement((Integer)i,i-1);
        }
        list.printList();

//        list.delElement(4);
//        list.printList();
//
//        Node tmp = list.moveSize(list.head,4);
//        System.out.println("tmp value "+tmp.getElement());
//        System.out.println("head value "+list.head.getElement());

//        Node node = list.getNode(4);
//        list.delElement(node);
//        list.printList();

//        list.Josephus2(list.head, 1, 30);

//        System.out.println("del"+list.Josephus(10,2));

    }
}
