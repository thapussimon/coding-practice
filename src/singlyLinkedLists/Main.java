package singlyLinkedLists;

class Node{
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
        this.next=null;
    }
}

public class Main {

    public static void main(String[] args) {
            Node head=null;
           head=insertEnd(head,5);
           head=insertEnd(head,6);
           head=insertEnd(head,7);
           head=insertEnd(head,8);
           printListIterative(head);
        System.out.println();
        System.out.println(searchIterative(head,5));


    }
//Traversing a Singly Linked List  using Iterative approach
    public static void printListIterative(Node head){
        Node curr=head;
        while (curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }

    }
    //Traversing a SLL using Recursive Approach
    public static void printListRecursive(Node head){
        if (head==null) return;
        System.out.print(head.data+" ");
        printListRecursive(head.next);
    }

    //Insert at the beginning of Linked list

    public static Node insertBegin(Node head,int val){
        Node temp=new Node(val);
        temp.next=head;
        return temp;
    }

    //Insert at the end of a SLL


    public static Node insertEnd(Node head,int val){
        Node temp=new Node(val);
        if (head==null){
            return temp; //Only need to modify head if it is only empty
        }else{
            Node curr=head;
            while (curr.next!=null){
                curr=curr.next;
            }
            curr.next=temp;
        }
        return head;

    }

    //Delete First Node of SLL

    public static Node deleteHead(Node head){
        if (head==null || head.next==null){
            return null;
        }else{
            return head.next;
        }
    }

    //Delete Last Node of a SLL or Tail of a SLL
    //I have used two pointer approach

    public static Node deleteEnd(Node head){
        if (head==null || head.next==null){
            return null; //Only change head in this case only
        }
        else {
            Node curr=head;
            Node prev=null;
            while (curr.next!=null){
                prev=curr;
                curr=curr.next;
            }
            prev.next=null;
        }
        return head;
    }

    //Insert at a given position in a SLL
    public static Node insertAtPos(Node head,int pos,int value){
        Node temp=new Node(value);
        //If you want to insert at the start
        if (pos==1){
            temp.next=head;
            head=temp;
            return head; //Temp becomes the new node if it is inserted at position 1
        }
        Node curr=head;
        for (int i=1;i<=pos-2 && curr!=null;i++){
            curr=curr.next;
        }
        //if curr goes out of LL that is exceeds last node we need to return the head
        if (curr==null){
            return head;
        }
        temp.next=curr.next;
        curr.next=temp;
        return head;

    }

    //Search in a SLL
    public static int searchIterative(Node head,int x){
        if (head==null){
            return -1;
        }else{
            int count=0;
            Node curr=head;
            while (curr!=null){
                //When the count of the nodes>0 we enter the LL
                count++;
                if (curr.data==x){
                    return count;
                }
                curr=curr.next;
            }
            return -1;
        }
    }

    //Search in LL Recursive
    public static int rSearch(Node head,int x){
        if (head==null){
            return -1;
        }
        if (head.data==x){
            return 1;
        }else {
            int res=rSearch(head.next,x);
            if (res==1) return -1;
            else{
                return res+1;
            }
        }
    }














































































}
