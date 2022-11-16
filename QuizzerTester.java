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
 * This class checks the correctness of the an implementation of cs300 Fall 2022 p07 Quizzer
 */
public class QuizzerTester {
    
    /**
     * Main method
     * @param args list of input arguments if any
     */
    public static void main(String[] args){
        System.out.println("testMultipleChoiceQuestion(): "+testMultipleChoiceQuestion());
        System.out.println("testLinkedNode(): "+testLinkedNode());
        System.out.println("testAddLast(): "+testAddLast());
        System.out.println("testAddFirst(): "+testAddFirst());
        System.out.println("testRemoveLast(): "+testRemoveLast());
        System.out.println("testRemoveFirst(): "+testRemoveFirst());
        System.out.println("testAdd(): "+testAdd());
        System.out.println("testRemove(): "+testRemove());
        System.out.println("testQuizQuestionsIterator(): "+testQuizQuestionsIterator());
        System.out.println("testCorrectQuestionsIterator(): "+testCorrectQuestionsIterator());
        System.out.println("testInCorrectQuestionsIterator(): "+testInCorrectQuestionsIterator());
        System.out.println("runAllTests(): "+runAllTests());
    }

    /**
     * Runs all the tester methods defined in this QuizzerTester
     * @return true if all tests pass and false if any of the tests fails
     */
    public static boolean runAllTests(){
        if(!testMultipleChoiceQuestion()){
            return false;
        }
        if(!testLinkedNode()){
            return false;
        }
        if(!testAddLast()){
            return false;
        }
        if(!testAddFirst()){
            return false;
        }
        if(!testRemoveLast()){
            return false;
        }
        if(!testRemoveFirst()){
            return false;
        }
        if(!testAdd()){
            return false;
        }
        if(!testRemove()){
            return false;
        }
        if(!testQuizQuestionsIterator()){
            return false;
        }
        if(!testCorrectQuestionsIterator()){
            return false;
        }
        if(!testInCorrectQuestionsIterator()){
            return false;
        }
        return true;
    }

    /**
     * This method test and make use of the MultipleChoiceQuestion constructor, an accessor (getter)
   * method, overridden method toString() and equal() method defined in the MultipleChoiceQuestion
   * class.
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testMultipleChoiceQuestion(){
            try{
            String[] answers={"1", "2"};
            MultipleChoiceQuestion quiz=new MultipleChoiceQuestion("Quiz", "1+0", answers, 1, 69);
            //test getter/setter for title
            if(!quiz.getTitle().equals("Quiz")){
                System.out.println("getTitle() for MultipleChoiceQuestion didn't work!");
                return false;
            }
            quiz.setTitle("Test");
            if(!quiz.getTitle().equals("Test")){
                System.out.println("setTitle() for MultipleChoiceQuestion didn't work!");
                return false;
            }
            //getter/setter for question
            if(!quiz.getQuestion().equals("1+0")){
                System.out.println("getQuestion() for MultipleChoiceQuestion didn't work!");
                return false;
            }
            quiz.setQuestion("1+1");
            if(!quiz.getQuestion().equals("1+1")){
                System.out.println("setQuestion() for MultipleChoiceQuestion didn't work!");
                return false;
            }
            //test equal
            quiz=new MultipleChoiceQuestion("Quiz", "1+0", answers, 1, 69);
            MultipleChoiceQuestion test=new MultipleChoiceQuestion("Quiz", "1+0", answers, 1, 69);

            if(!quiz.equals(test)){
                System.out.println("equals() method doesn't work for MultipleChoiceQuestion");
                return false;
            }

            if(!quiz.toString().equals(test.toString())){
                System.out.println("toString() method doesn't work for MultipleChoiceQuestion");
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * This method test and make use of the LinkedNode constructor, an accessor (getter) method, and a mutator (setter) method defined in the LinkedNode class.
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testLinkedNode(){
        try{
        //test getter/setter/constructor
        LinkedNode<String> node1=new LinkedNode<String>("Node1");
        LinkedNode<String> node2=new LinkedNode<String>("Node2", node1);
        LinkedNode<String> node3=new LinkedNode<String>("Node3");
        if(!node2.getNext().equals(node1)){
            System.out.println("getNext() isn't working!");
            return false;
        }
        node2.setNext(node3);
        if(!node2.getNext().equals(node3)){
            System.out.println("setNext() isn't working");
            return false;
        }
    }   
    catch(Exception e){
        return false;
    }
        return true;
    }

    /**
     * This method checks for the correctness of QuizQuestionsIterator class
     * @return true when this test verifies a correct functionality, and false otherwise
     */ 
    public static boolean testAddLast(){
        ListQuizzer a=new ListQuizzer();
        String[] answers={"1", "2"};
        MultipleChoiceQuestion q1=new MultipleChoiceQuestion("Quiz", "1+0", answers, 0, 69);
        MultipleChoiceQuestion q2=new MultipleChoiceQuestion("Quiz", "1+1", answers, 1, 69);
        a.addLast(q1);
        if(a.size()!=1 || a.getLast().equals(q1)==false){
            System.out.println("addLast() doesn't work!");
            return false;
        }
        return true;
    }

    /**
     * Tester for ListQuizzer.removeFirst() method
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testAddFirst(){
        try{
            ListQuizzer a=new ListQuizzer();
            String[] answers={"1", "2"};
            MultipleChoiceQuestion q1=new MultipleChoiceQuestion("Quiz", "1+0", answers, 0, 69);
            MultipleChoiceQuestion q2=new MultipleChoiceQuestion("Quiz", "1+1", answers, 1, 69);
            a.addFirst(q1);
            a.addFirst(q2);
            if(a.size()!=2 || a.getFirst().equals(q2)==false){
                System.out.println("addFirst() doesn't work!");
                return false;
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    /**
     * Tester for ListQuizzer.removeLast() method
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testRemoveLast(){
        try{
            ListQuizzer a=new ListQuizzer();
            String[] answers={"1", "2"};
            MultipleChoiceQuestion q1=new MultipleChoiceQuestion("Quiz", "1+0", answers, 0, 69);
            MultipleChoiceQuestion q2=new MultipleChoiceQuestion("Quiz", "1+1", answers, 1, 69);
            a.addLast(q1);
            a.addLast(q2);
            a.removeLast();
            if(a.size()!=1 || !a.getLast().equals(q1)){
                System.out.println("removeLast() doesn't work!");
                return false;
            }
            a.removeLast();
            if(!a.isEmpty()){
                System.out.println("removeLast() doesn't work");
                return false;
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public static boolean testRemoveFirst(){
        try{
            ListQuizzer a=new ListQuizzer();
            String[] answers={"1", "2"};
            MultipleChoiceQuestion q1=new MultipleChoiceQuestion("Quiz", "1+0", answers, 0, 69);
            MultipleChoiceQuestion q2=new MultipleChoiceQuestion("Quiz", "1+1", answers, 1, 69);
            a.addFirst(q1);
            a.addFirst(q2);
            a.removeFirst();
            if(a.size()!=1 || !a.getFirst().equals(q1)){
                System.out.println("removeFirst() doesn't work");
                return false;
            }
            a.removeFirst();
            if(!a.isEmpty()){
                System.out.println("removeFirst() doesn't work");
                return false;
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    /**
     * Tester for ListQuizzer.add() method
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testAdd(){
        try{
            ListQuizzer a=new ListQuizzer();
            String[] answers={"1", "2", "3"};
            MultipleChoiceQuestion q1=new MultipleChoiceQuestion("Quiz", "1+0", answers, 0, 69);
            MultipleChoiceQuestion q2=new MultipleChoiceQuestion("Quiz", "1+1", answers, 1, 69);
            MultipleChoiceQuestion q3=new MultipleChoiceQuestion("Quiz", "1+2", answers, 2, 69);
            a.addLast(q1); 
            a.addLast(q2); 
            a.add(1, q3);
            if(a.size()!=3 || !a.get(1).equals(q3)){
                System.out.println("Add() doesn't work!");
                return false;
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    /**
     * Tester for ListQuizzer.remove() method
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testRemove(){
        try{
            ListQuizzer a=new ListQuizzer();
            String[] answers={"1", "2", "3"};
            MultipleChoiceQuestion q1=new MultipleChoiceQuestion("Quiz", "1+0", answers, 0, 69);
            MultipleChoiceQuestion q2=new MultipleChoiceQuestion("Quiz", "1+1", answers, 1, 69);
            MultipleChoiceQuestion q3=new MultipleChoiceQuestion("Quiz", "1+2", answers, 2, 69);
            a.addLast(q1); 
            a.addLast(q2); 
            a.addLast(q3);
            a.remove(1);
            if(a.size()!=2 || !a.getFirst().equals(q1) || !a.getLast().equals(q3)){
                System.out.println("Remove() doesn't work!");
                return false;
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    /**
     * This method checks for the correctness of QuizQuestionsIterator class
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testQuizQuestionsIterator(){
        try{
            String[] answers={"1", "2", "3"};
            MultipleChoiceQuestion q1=new MultipleChoiceQuestion("Quiz", "1+0", answers, 0, 69);
            MultipleChoiceQuestion q2=new MultipleChoiceQuestion("Quiz", "1+1", answers, 1, 69);
            MultipleChoiceQuestion q3=new MultipleChoiceQuestion("Quiz", "1+2", answers, 2, 69);
            LinkedNode<MultipleChoiceQuestion> node1=new LinkedNode<MultipleChoiceQuestion>(q1);
            LinkedNode<MultipleChoiceQuestion> node2=new LinkedNode<MultipleChoiceQuestion>(q2);
            LinkedNode<MultipleChoiceQuestion> node3=new LinkedNode<MultipleChoiceQuestion>(q3);
            node1.setNext(node2);
            node2.setNext(node3);
           //check hasNext()
            QuizQuestionsIterator it=new QuizQuestionsIterator(node1);
            if(it.hasNext()==false){
                System.out.println("hasNext() isn't working!");
                return false;
            }
            if(!it.next().equals(q1)){
                System.out.println("next() isn't working!");
                return false;
            }
            return true;
        }
        catch(Exception e){
            System.out.println("Exception !");
            return false;
        }
    }
    
    /**
     * This method checks for the correctness of CorrectQuestionsIterator class
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testCorrectQuestionsIterator(){
        try{
            String[] answers={"1", "2", "3"};
            MultipleChoiceQuestion q1=new MultipleChoiceQuestion("Quiz", "1+0", answers, 0, 69);
            //q1.setStudentAnswerIndex(0);
            MultipleChoiceQuestion q2=new MultipleChoiceQuestion("Quiz", "1+1", answers, 1, 69);
            MultipleChoiceQuestion q3=new MultipleChoiceQuestion("Quiz", "1+2", answers, 2, 69);
            q3.setStudentAnswerIndex(2);
            //System.out.println(q3.isCorrect());
            LinkedNode<MultipleChoiceQuestion> node1=new LinkedNode<MultipleChoiceQuestion>(q1);
            LinkedNode<MultipleChoiceQuestion> node2=new LinkedNode<MultipleChoiceQuestion>(q2);
            LinkedNode<MultipleChoiceQuestion> node3=new LinkedNode<MultipleChoiceQuestion>(q3);
            node1.setNext(node2);
            node2.setNext(node3);
            CorrectQuestionsIterator it=new CorrectQuestionsIterator(node1);
            if(it.hasNext()==false){
                System.out.println("hasNext() is not working!");
                return false;
            }
            if(!it.next().equals(q3)){
                System.out.println("next() isn't working!");
                return false;
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    /**
     * This method checks for the correctness of IncorrectQuestionsIterator class
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testInCorrectQuestionsIterator(){
        try{
            String[] answers={"1", "2", "3"};
            MultipleChoiceQuestion q1=new MultipleChoiceQuestion("Quiz", "1+0", answers, 0, 69);
            q1.setStudentAnswerIndex(0);
            MultipleChoiceQuestion q2=new MultipleChoiceQuestion("Quiz", "1+1", answers, 1, 69);
            MultipleChoiceQuestion q3=new MultipleChoiceQuestion("Quiz", "1+2", answers, 2, 69);
            q3.setStudentAnswerIndex(2);
            LinkedNode<MultipleChoiceQuestion> node1=new LinkedNode<MultipleChoiceQuestion>(q1);
            LinkedNode<MultipleChoiceQuestion> node2=new LinkedNode<MultipleChoiceQuestion>(q2);
            LinkedNode<MultipleChoiceQuestion> node3=new LinkedNode<MultipleChoiceQuestion>(q3);
            node1.setNext(node2);
            node2.setNext(node3);
            IncorrectQuestionsIterator it=new IncorrectQuestionsIterator(node1);
            if(!it.hasNext()){
                System.out.println("hasNext() isn't working");
                return false;
            }
            if(!it.next().equals(q2)){
                System.out.println("hasNext() isn't working");
                return false;
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }


}
