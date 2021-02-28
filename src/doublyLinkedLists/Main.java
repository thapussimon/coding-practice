package doublyLinkedLists;
class Node{
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        Node head=null;
        head=insertEnd(head,1);
        head=insertEnd(head,2);
        head=insertEnd(head,3);
        head=insertEnd(head,4);
        head=insertEnd(head,5);
        traverse(head);
        head=reverseDLL(head);
        traverse(head);
    }

    //Traversal of a DLL

    public static void traverse(Node head){
        Node curr=head;
        while (curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    //Insert at Beginning of a DLL
    public static Node insertBegin(Node head,int x){
        Node temp=new Node(x);
        if (head==null){
            return temp;
        }
        temp.next=head;
        head.prev=temp;
        return temp;

    }

    //Insert at the End of DLL
    public static Node insertEnd(Node head,int x){
        Node temp=new Node(x);
        if (head==null){
            return temp;
        }
        Node curr=head;
        Node prev=null;
        while (curr!=null){
            prev=curr;
            curr=curr.next;
        }
        prev.next=temp;
        temp.prev=prev;
        return head;
    }

    //Delete Head of a DLL
    public static Node deleteHead(Node head){
        if (head==null || head.next==null){
            return null;
        }
        head=head.next;
        head.prev=null;
        return head;
    }

    //Delete Last Node of a DLL
    public static Node deleteTail(Node head){
        if (head==null || head.next==null){
            return null;
        }
        Node curr=head;
        Node prev=null;
        while (curr.next!=null){
            prev=curr;
            curr=curr.next;
        }
        prev.next=null;
        //We cannot do null.prev because it would give null pointer exception
        return head;
    }


    //Reverse a DLL when tail pointer is given
    public static void reverse(Node tail){
        Node curr=tail;
        while (curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.prev;
        }
        System.out.println();

    }

    //Reverse a DLL when head is given
    //Swapping prev & next pointers

    public static Node reverseDLL(Node head){
        if (head==null || head.next==null){
            return head;
            //Handling for empty DLL & when there is a single node the output should be that node itself
        }
        Node prev=null;
        Node curr=head;
        while (curr!=null){
            //Swapping starts here, prev is the temporary variable used to store data
            prev=curr.prev;
            curr.prev=curr.next;
            curr.next=prev;
            //Swapping ends here
            //Now we need to move curr to next node
            //As of now next & prev references are swapped
            //So thats the reason we use curr.prev to move to the second node, as prev & next references are swapped
            curr=curr.prev;
        }
        return prev.prev; // returns the head of the reversed DLL
    }







































}
