package com.project.callbreak.services;

import com.project.callbreak.info.GamePlayer;

public class LinkedListPlayers {
    
    
    
    //Represents the node of list.  
    public class Node{ 
        public GamePlayer player;
        public int flag;  
        public Node next;  
        public Node(GamePlayer  player,int flag) {  
            this. player= player;
            this.flag = flag;  
        }  
    }  

    //Declaring head and tail pointer as null.  
    public Node head = null;  
    public Node tail = null;  

    //This function will add the new node at the end of the list.  
    public void add(GamePlayer  player,int flag){  
        //Create new node  
        Node newNode = new Node( player,flag);  
        //Checks if the list is empty.  
        if(head == null) {  
             //If list is empty, both head and tail would point to new node.  
            head = newNode;  
            tail = newNode;  
            newNode.next = head;  
        }  
        else {  
            //tail will point to new node.  
            tail.next = newNode;  
            //New node will become new tail.  
            tail = newNode;  
            //Since, it is circular linked list tail will point to head.  
            tail.next = head;  
        }  
    }  

    //Displays all the nodes in the list  
    public void display() {  
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
        }  
        else {  
            System.out.println("Nodes of the circular linked list: ");  
             do{  
                //Prints each node by incrementing pointer.  
                 System.out.print(" "+ current.player);  
                System.out.print(" "+ current.flag);  
                current = current.next;  
            }while(current != head);  
            System.out.println();  
        }  
    }  
    public Node returnList()
    {
        return head;
    }

}