import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
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
 * Implements an iterator to iterate over correctly answered MultipleChoiceQuestion(s) stored in a singly linked list defined by its head.
 */
public class CorrectQuestionsIterator extends Object implements Iterator<MultipleChoiceQuestion>{

    private LinkedNode<MultipleChoiceQuestion> next;

    /**
     * Creates a new CorrectQuestionsIterator to start iterating through a singly linked list storing MultipleChoiceQuestion elements
     * @param startNode pointer to the head of the singly linked list
     */
    public CorrectQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode){
        this.next=startNode;
    }

    /**
     * Returns true if this iteration has more MultipleChoiceQuestion(s) answered correctly.
     * @return true if there are more correct MultipleChoiceQuestion(s) in this iteration.
     */
    @Override
    public boolean hasNext() {
        LinkedNode<MultipleChoiceQuestion> a=this.next;
        while(a!=null){
            if(a.getData().isCorrect()){
                return true;
            }
            a=a.getNext();
        }
        return false;
    }

    /**
     * Returns the next correct MultipleChoiceQuestion in this iteration
     * @return the next MultipleChoiceQuestion in this iteration
     * @throws NoSuchElementException - with a descriptive error message if there are no more questions in this iteration
     */
    @Override
    public MultipleChoiceQuestion next() throws NoSuchElementException{
        if(!this.hasNext()){
            throw new NoSuchElementException("There are no more correct questions!");
        }
        while(this.next!=null){
            if(this.next.getData().isCorrect()){
                LinkedNode<MultipleChoiceQuestion> a=this.next;
                this.next=this.next.getNext();
                return a.getData();
            }
            this.next=this.next.getNext();
        
        }
        return null;
    }
    
}
