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
 * Implements an iterator to iterate over incorrectly answered MultipleChoiceQuestion(s) stored in a singly linked list defined by its head.
 */
public class IncorrectQuestionsIterator extends Object implements Iterator<MultipleChoiceQuestion>{
    private LinkedNode<MultipleChoiceQuestion> next;

    /**
     * Creates a new InCorrectQuestionsIterator to start iterating through a singly linked list storing MultipleChoiceQuestion elements
     * @param startNode pointer to the head of the singly linked list
     */
    public IncorrectQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode){
        this.next=startNode;
    }

    /**
     * Returns true if this iteration has more incorrect MultipleChoiceQuestion(s).
     * @return true if there are more incorrect MultipleChoiceQuestion(s) in this iteration.
     */
    @Override
    public boolean hasNext() {
        LinkedNode<MultipleChoiceQuestion> a=this.next;
        while(a!=null){
            if(a.getData().isCorrect()==false){
                return true;
            }
            a=a.getNext();
        }
        return false;
    }

    /**
     * Returns the next MultipleChoiceQuestion in this iteration
     * @return the next MultipleChoiceQuestion in this iteration
     * @throws NoSuchElementException - with a descriptive error message if there are no more questions in this iteration
     */
    @Override
    public MultipleChoiceQuestion next() throws NoSuchElementException{
        if(!this.hasNext()){
            throw new NoSuchElementException("There are no more incorrect questions!");
        }
        while(this.next!=null){
            if(this.next.getData().isCorrect()==false){
                LinkedNode<MultipleChoiceQuestion> a=this.next;
                this.next=this.next.getNext();
                return a.getData();
            }
            this.next=this.next.getNext();
        }
        return null;
    }
    
}
