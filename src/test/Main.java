package test;

class Node{
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        Node head=new Node(10);
        Node node2=new Node(11);
        Node node3=new Node(13);
        head.next=node2;
        node2.next=node3;
        System.out.println(rsearch(head,11));
    }
    public static int rsearch(Node head,int x){
        if (head==null) return -1;
        if (head.data==x) return 1;
        else{
            int res=rsearch(head.next,x);
            if (res==-1) return -1;
            else return res+1;
        }
    }
}
