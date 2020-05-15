package com.dachui.quickstart;

public class Interview3 {
    public static void main(String[] args) {
        Node node1=new Node(10);
        Node node2=new Node(20);
        Node node3=new Node(30);
        node1.next=node2;
        node2.next=node3;
        Node node=reverseNode(node1);
        System.out.println(node.val);
    }

    static Node arrTransfer(int[] arr){
        if(arr==null){
            return null;
        }
        Node node=new Node(-1);
        Node prev=node;
        for(int i=0;i<arr.length;i++){
            Node temp=new Node(arr[i]);
        }
        return prev.next;
    }

    static Node reverseNode(Node node){
        Node prev =null;
        Node curr=node;

        while(curr!=null){
            //倒转
            Node temp=curr.next;
            curr.next=prev;
            //往下走
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}

class Node{
    int val;
    Node next;
    public Node(int val){
        this.val=val;
    }
}
