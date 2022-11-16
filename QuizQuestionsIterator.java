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
 * This is an iterator that moves through MultipleChoiceQuestion(s) in a singly linked list defined by its head
 */
public class QuizQuestionsIterator extends Object implements Iterator<MultipleChoiceQuestion>{
    private LinkedNode<MultipleChoiceQuestion> next;

    /**
     * Creates a new QuizQuestionsIterator to start iterating through a singly linked list storing MultipleChoiceQuestion elements
     * @param startNode pointer to the head of the singly linked list
     */
    public QuizQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode){
        this.next=startNode;
    }

    /**
     * Returns true if this iteration has more MultipleChoiceQuestion(s).
     * @return true if there are more MultipleChoiceQuestion(s) in this iteration.
     */
    @Override
    public boolean hasNext() {
        if(this.next!=null){
            return true;
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
        if(this.next==null){
            throw new NoSuchElementException("There are no more questions in this iteration");
        }
        else{
            LinkedNode<MultipleChoiceQuestion> a=this.next;
            this.next=this.next.getNext();
            return a.getData();
        }
    }
}
