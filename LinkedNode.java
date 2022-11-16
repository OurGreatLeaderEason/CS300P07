////////////////LinkedNode//////////////////////////
//
//Title:    P07 Quizzer
//Course:   CS 300 Fall 2022
//
//Author:   Eason Xiao
//Email:    xiao227@wisc.edu
//Lecturer: Jeff Nyhoff
//
/**
 * An instance of this class represents a single node within a singly linked list.
 */
public class LinkedNode<T>{
    private T data;
    private LinkedNode<T> next;

    /**
     * Constructs a new node with the provided information.
     * @param data to be stored within this node
     * @param next  node, which comes after this node in a singly linked list
     */
    public LinkedNode(T data, LinkedNode<T> next){
        if(data==null){
            throw new NullPointerException("Data cannot be null!");
        }
        this.data=data;
        this.next=next;
    }

    /**
     * Constructs a new node with a specific data and NO next node in the list.
     * @param data to be stored within this node
     */
    public LinkedNode(T data){
        if(data==null){
            throw new NullPointerException("Data cannot be null!");
        }
        this.data=data;
        this.next=null;
    }

    /**
     * Mutator method for this node's next node reference.
     * @return next node, which comes after this node in a singly linked list
     */
    public LinkedNode<T> getNext(){
        return this.next;
    }

    /**
     * Mutator method for this node's next node reference.
     * @param next next node, which comes after this node in a singly linked list
     */
    public void setNext(LinkedNode<T> next){
        this.next=next;
    }

    /**
     * Accessor method for this node's data.
     * @return the data stored within this node.
     */
    public T getData(){
        return this.data;
    }

    /**
     * Returns a string representation of this linked node formatted as follows:

  data.toString() if this node does NOT have a next node in the list
  data.toString() + "->" if this node has a next node in the list
     */
    @Override
    public String toString(){
        if(this.next==null){
            return data.toString();
        }
        return data.toString()+"->";
    }

}
