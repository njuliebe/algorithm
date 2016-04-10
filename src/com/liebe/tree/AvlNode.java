package com.liebe.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sjtu on 16-3-2.
 */
public class AvlNode {
    public int element;
    public AvlNode left;
    public AvlNode right;
    public int height;

    public AvlNode(int element,AvlNode left,AvlNode right){
        this.element = element;
        this.left = left;
        this.right = right;
        this.height = 0;
    }

    private int height(AvlNode node){
        if(node == null)
            return -1;
        else return node.height;
    }


    public AvlNode find(int element,AvlNode root){
       if(element < root.element){
            return find(element,root.left);
        }else if(element > root.element){
            return find(element,root.right);
        }else if(element == root.element){
           return root;}
        else return null;
    }

    public void printTree(AvlNode tree){
        if(tree != null){
            printTree(tree.left);
            System.out.println(tree.height + " : " + tree.element);

            printTree(tree.right);
        }
    }

    public void levelPrint(AvlNode root){
        if(root == null){
            return;
        }
        Queue<AvlNode> queue = new LinkedList<AvlNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            AvlNode tmp = queue.poll();
            System.out.println("layer " + tmp.height + " " + tmp.element);
            if(tmp.left != null)
            queue.add(tmp.left);
            if(tmp.right != null)
            queue.add(tmp.right);
        }

    }

    //some bug
    public void convert2DList(AvlNode root,AvlNode first,AvlNode last){
        AvlNode leftFirst = null;
        AvlNode leftLast = null;
        AvlNode rightFirst = null;
        AvlNode rightLast = null;
        if(root == null){
            first = null;
            last = null;
            return;
        }
        if(root.left == null){
            first = root;
        }else{
            convert2DList(root.left,leftFirst,leftLast);
            first = leftFirst;
            root.left = leftLast;
            leftLast.right = root;
        }

        if(root.right == null){
            last = root;
        }else{
            convert2DList(root.right,rightFirst,rightLast);
            last = rightLast;
            root.right = rightFirst;
            rightFirst.left = root;
        }
        return;
    }

    public int getNumKLevel(AvlNode root,int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        int leftNum = getNumKLevel(root.left, k - 1);
        int rightnum = getNumKLevel(root.right, k - 1);
        return leftNum+rightnum;

    }

    public int getLeafNum(AvlNode root){
        if(root == null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int leftNum = getLeafNum(root.left);
        int rightNum = getLeafNum(root.right);
        return leftNum+rightNum;
    }

    public int getHeight(AvlNode root){
        if(root == null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    public boolean getPath(AvlNode root,int element, LinkedList<Integer> list){
        if(root == null){
            return false;
        }
        if(root.element == element){
            return true;
        }
        list.addLast((Integer) root.element);
        boolean found = false;
        if(!found && root.left!=null){
            found = getPath(root.left,element,list);
        }
        if(!found && root.right!=null){
            found = getPath(root.right,element,list);
        }

        if(!found)
            list.removeLast();
        return found;

    }

    public int getLastCommonParent(AvlNode root,int element1, int element2){
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();

        getPath(root,element1,list1);
        getPath(root,element2,list2);

        int tmp = 0;
        while(!list1.isEmpty()&&!list2.isEmpty()){
            int ele1 = list1.poll();
            int ele2 = list2.poll();
            if(ele1 == ele2){
                tmp = ele1;

            }
        }
        return tmp;
    }

    public int getTreeDistance(AvlNode root){
        if(root == null){
            return 0;
        }else if(root.left==null&&root.right==null){
            return 0;
        }
        int dis = Math.max(getTreeDistance(root.left),getTreeDistance(root.right));
        dis = Math.max(getHeight(root.left)+getHeight(root.right),dis);
        return dis;
    }

    public AvlNode insert(int element,AvlNode tree){
        if(tree == null){
            tree = new AvlNode(element,null,null);
        }else if(element < tree.element){
            tree.left = insert(element,tree.left);
            if(height(tree.left)-height(tree.right) == 2){
                if(element < tree.left.element){
                    tree = singleRotateWithLeft(tree);
                }else if(element > tree.left.element){
                    tree = DoubleRotateWithLeft(tree);
                }
            }
        }else if(element > tree.element){
            tree.right = insert(element,tree.right);
            if(height(tree.right)-height(tree.left) == 2){
                if(element > tree.right.element){
                    tree = singleRotateWithRight(tree);
                }else if(element < tree.right.element){
                    tree = DoubleRotateWithRight(tree);
                }
            }
        }

        tree.height = Math.max(height(tree.left),height(tree.right)) + 1;
        return tree;
    }

    public AvlNode singleRotateWithLeft(AvlNode k2){
        AvlNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = Math.max(height(k2.left),height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left),k2.height) +1;

        return k1;
    }

    public AvlNode singleRotateWithRight(AvlNode k2){
        AvlNode k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;

        k2.height = Math.max(height(k2.left),height(k2.right)) + 1;
        k1.height = Math.max(height(k1.right),k2.height) + 1;

        return k1;
    }

    public AvlNode DoubleRotateWithLeft(AvlNode k3){
        k3.left = singleRotateWithRight(k3.left);
        return singleRotateWithLeft(k3);
    }

    public AvlNode DoubleRotateWithRight(AvlNode k3){
        k3.right = singleRotateWithLeft(k3.right);
        return singleRotateWithRight(k3);
    }

//非递归遍历
    //preOrder
    public void preOrder2(AvlNode root){
        AvlNode tmp = root;
        Stack<AvlNode> s = new Stack<AvlNode>();

        while(tmp!=null || !s.isEmpty()){
            while(tmp!= null){
                System.out.print("  "+tmp.element);
                s.push(tmp);
                tmp = tmp.left;
            }
            if(!s.isEmpty()){
                tmp = s.pop();
                tmp = tmp.right;
            }
        }

    }

    //inOrder
    public void inOrder2(AvlNode root){
        AvlNode tmp = root;
        Stack<AvlNode> s = new Stack<AvlNode>();

        while(tmp!=null || !s.isEmpty()){
            while(tmp != null){
                s.push(tmp);
                tmp = tmp.left;
            }
            if(!s.isEmpty()){
                tmp = s.pop();
                System.out.print("  "+tmp.element);
                tmp = tmp.right;
            }
        }
    }

    public void postOrder2(AvlNode root){
        Stack<AvlNode> s = new Stack<AvlNode>();
        AvlNode cur = null;
        AvlNode pre = null;

        s.push(root);

        while(!s.isEmpty()){
            cur = s.peek();
            if(cur.left==null&&cur.right==null ||
                    (pre!=null)&&pre==cur.left||pre==cur.right){
                System.out.print("  "+cur.element);
                s.pop();
                pre = cur;
            }else{
                if(cur.right != null)
                    s.push(cur.right);
                if(cur.left != null)
                    s.push(cur.left);
            }
        }

    }

    public static void  main(String[] args){
        AvlNode tree = new AvlNode(10,null,null);
        int[] elements = {3,4,7,5,2,6,9,11,34,45};
        long begin ,end;
        begin = System.nanoTime();
        for(int element:elements){
            System.out.println("insert "+element);
            tree = tree.insert(element,tree);
//            tree.printTree(tree);

        }
        end = System.nanoTime();
//        System.out.println("insert cost " + (end - begin) + " ns");
        tree.printTree(tree);

        tree.levelPrint(tree);

        AvlNode first = null;
        AvlNode last = null;
        AvlNode tmp = null;

//        System.out.println("leaf num "+tree.getLeafNum(tree));
//
//        System.out.println("tree height " + tree.getHeight(tree));

        LinkedList<Integer> list = new LinkedList<Integer>();

        tree.getPath(tree,45,list);
//        while(!list.isEmpty()){
//            System.out.print(" "+list.pollLast());
//        }
        Iterator<Integer> iterator = list.iterator();

        tree.postOrder2(tree);
//
//        while(iterator.hasNext()){
//            Integer ele = iterator.next();
//            System.out.print(" "+ele);
//        }

//        System.out.println("  "+tree.getLastCommonParent(tree,9,45));
//        System.out.println("tree distance "+tree.getTreeDistance(tree) );

//        for(int i=1;i<6;i++)
//            System.out.println("level i "+tree.getNumKLevel(tree,i));
//        tree.convert2DList(tree,first,last);
//        tmp = first;
//        while(tmp!=null){
//            System.out.print(" "+tmp.element);
//            tmp = tmp.right;
//        }

//        System.out.println(tree.find(7,tree).left.element);
//        if(tree.find(30,tree)==null){
//            System.out.println("can't find 30");
//        }
    }

}
