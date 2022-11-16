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
 * This class models an iterable singly-linked list data structure which stores elements of type MultipleChoiceQuestion.
 */
public class ListQuizzer extends Object implements Iterable<MultipleChoiceQuestion>{
    private LinkedNode<MultipleChoiceQuestion> head;
    private ListingMode listingMode;
    private int size;
    private LinkedNode<MultipleChoiceQuestion> tail;

    /**
     * this constructor creates a new empty instance of ListQuizzer which contains zero elements and sets its listing mode to be ListingMode.ALL by default.
     */
    public ListQuizzer(){
        this.head=null;
        this.listingMode=ListingMode.ALL;
        this.size=0;
        this.listingMode=null;
    }

    /**
     * Checks whether this list is empty
     * @return true if this list is empty and false otherwise
     */
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    /**
     * Gets the size of this list
     * @return the size of this list
     */
    public int size(){
        return this.size;
    }

    /**
     * Adds a specific MutlipleChoiceQuestion to the head of this list
     * @param question question - some MultipleChoiceQuestion to add to the head of this list
     * @throws NullPointerException  with a descriptive error message if newQuestion is null
     */
    public void addFirst(MultipleChoiceQuestion question) throws NullPointerException{
        if(question==null){
            throw new NullPointerException("Question cannot be null!");
        }
        if(this.size==0){
            LinkedNode<MultipleChoiceQuestion> newQuestion=new LinkedNode<MultipleChoiceQuestion>(question);
            this.head=newQuestion;
            this.tail=newQuestion;
        }
        else{
            LinkedNode<MultipleChoiceQuestion> newQuestion=new LinkedNode<MultipleChoiceQuestion>(question, head);
            this.head=newQuestion;
        }
        size+=1;
    }

    /**
     * Adds a specific MutlipleChoiceQuestion to the tail of this list
     * @param question some MultipleChoiceQuestion to add to the tail of this list
     * @throws NullPointerException with a descriptive error message if newQuestion is null
     */
    public void addLast(MultipleChoiceQuestion question) throws NullPointerException{
        if(question==null){
            throw new NullPointerException("Question cannot be null!");
        }
        if(this.size==0){
            LinkedNode<MultipleChoiceQuestion> newQuestion=new LinkedNode<MultipleChoiceQuestion>(question);
            this.head=newQuestion;
            this.tail=newQuestion;
        }
        else{
            LinkedNode<MultipleChoiceQuestion> newQuestion=new LinkedNode<MultipleChoiceQuestion>(question);
            this.tail.setNext(newQuestion);
            this.tail=newQuestion;
        }
        size+=1;
    }

    /**
     * Gets the MultipleChoiceQuestion at the head of this list
     * @return the MultipleChoiceQuestion at the head of this list
     * @throws NoSuchElementException  with a descriptive error message if this list is empty
     */
    public MultipleChoiceQuestion getFirst() throws NoSuchElementException{
        if(this.size==0){
            throw new NoSuchElementException("List is empty!");
        }
        return this.head.getData();
    }


     /**
     * Gets the MultipleChoiceQuestion at the tail of this list
     * @return the MultipleChoiceQuestion at the tail of this list
     * @throws NoSuchElementException  with a descriptive error message if this list is empty
     */
    public MultipleChoiceQuestion getLast() throws NoSuchElementException{
        if(this.size==0){
            throw new NoSuchElementException("List is empty!");
        }
        return this.tail.getData();
    }

    /**
     * Returns the MultipleChoiceQuestion stored at the given index within this list
     * @param index index of the MultipleChoiceQuestion to return
     * @return the MultipleChoiceQuestion stored at the given index within this list
     * @throws IndexOutOfBoundsException if index is out of the range 0 .. size()-1 inclusive
     */
    public MultipleChoiceQuestion get(int index) throws IndexOutOfBoundsException{
        if(index+1>size() || index<0){
            throw new IndexOutOfBoundsException("Index if out of bounds!");
        }

        LinkedNode<MultipleChoiceQuestion> currentNode = head;
        for(int i=0; i<index; i++){
            currentNode=currentNode.getNext();
        }
        return currentNode.getData();
    }

    /**
     * Adds a specific MultipleChoiceQuestion to a given position of this list
     * @param index position index where to add the newQuestion to this list
     * @param question some MultipleChoiceQuestion to add to this list
     * @throws NullPointerException with a descriptive error message if newQuestion is null
     * @throws IndexOutOfBoundsException with a descriptive error message if index is OUT of the range 0 .. size() inclusive
     */
    public void add(int index, MultipleChoiceQuestion question) throws NullPointerException, IndexOutOfBoundsException{
       
        if (question == null) {
            throw new NullPointerException("Question cannot be null!");
        }
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("the index is out of bound");
        }
        LinkedNode<MultipleChoiceQuestion> currentNode = this.head; 
        LinkedNode<MultipleChoiceQuestion> insert = new LinkedNode<MultipleChoiceQuestion>(question);
        if (index == 0) {
            addFirst(question);
        } 
        else if (index == size()){
            addLast(question);
        }
        else {
            for(int i=0; i<index-1; i++){
                currentNode = currentNode.getNext();
            }
            insert.setNext(currentNode.getNext());
            currentNode.setNext(insert);
            size++;
          }
    }

    /**
     * Sets the listing mode of this list to the one provided as input
     * @param listingMode listing mode to set
     */
    public void switchMode(ListingMode listingMode){
        this.listingMode = listingMode;
    }

    /**
     * This method removes all the question from this list. The list should be empty after this method is called.
     */
    public void clear(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    /**
     * Checks whether this list contains a match with someQuestion
     * @param someQuestion some question to find
     * @return true if this list contains a match with someQuestion and false otherwise
     */
    public boolean contains(MultipleChoiceQuestion someQuestion){
        LinkedNode<MultipleChoiceQuestion> currentNode=head;
        for(int i=0; i<this.size()-1; i++){
            if(currentNode.getData().equals(someQuestion)){
                return true;
            }
            currentNode=currentNode.getNext();
        }
        return false;
    }

    /**
     * Removes and returns the MultipleChoiceQuestion at the given index
     * @param index  of the MultipleChoiceQuestion to remove
     * @return the removed MultipleChoiceQuestion
     * @throws IndexOutOfBoundsException with a descriptive error message if index is out of the range 0 .. size()-1 inclusive
     */
    public MultipleChoiceQuestion remove(int index) throws IndexOutOfBoundsException{
        if(index+1>size() || index<0){
            throw new IndexOutOfBoundsException("Index if out of bounds!");
        }
        if(index==0){
            return this.removeFirst();
        }
        else if(index==this.size-1){
            return this.removeLast();
        }
        LinkedNode<MultipleChoiceQuestion> prev=head;
        for(int i=0; i<index-1; i++){
            prev=prev.getNext();
        }
        LinkedNode<MultipleChoiceQuestion> currentNode=prev.getNext();
        LinkedNode<MultipleChoiceQuestion> nextNode=currentNode.getNext();
        prev.setNext(nextNode);
        this.size--;
        return currentNode.getData();

    }

    /**
     * Removes and returns the MultipleChoiceQuestion at the head of this list
     * @return the MultipleChoiceQuestion at the head of this list
     * @throws NoSuchElementException with a descriptive error message if this list is empty
     */
    public MultipleChoiceQuestion removeFirst() throws NoSuchElementException{
        if(this.size==0){
            throw new NoSuchElementException("List is empty!");
        }
        MultipleChoiceQuestion oldHead=this.head.getData();
        if(this.size==1){
            this.head=null;
            this.tail=null;
        }
        else{
            this.head=this.head.getNext();
        }
        this.size--;
        return oldHead;
    }

    /**
     * Removes and returns the MultipleChoiceQuestion at the tail of this list
     * @return the MultipleChoiceQuestion at the tail of this list
     * @throws NoSuchElementException with a descriptive error message if this list is empty
     */
    public MultipleChoiceQuestion removeLast() throws NoSuchElementException{
        MultipleChoiceQuestion oldTail = tail.getData();// creates the multipleChoiceQuestion to be removed
        LinkedNode<MultipleChoiceQuestion> currentNode = head;// creates a reference to head
        if (this.size==0) {
            throw new NoSuchElementException("List is empty!");
        }
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        }
        else {
            for(int i=0; i<this.size-2; i++){
                currentNode=currentNode.getNext();
            }
            currentNode.setNext(null);// sets the pointer to the second last node to node
            this.tail = currentNode;// sets that node to the tail node
      
        }
        this.size--;
        return oldTail;
    }

    /**
     * Calculates the total points of the correctly answered questions of this ListQuizzer
     * @return the score of this ListQuizzer
     */
    public int calculateScore(){
        int score=0;
        LinkedNode<MultipleChoiceQuestion> currentNode=this.head;
        for(int i=0; i<this.size; i++){
            if(currentNode.getData().isCorrect()){
                score+=currentNode.getData().getPointsPossible();
            }
            currentNode=currentNode.getNext();
        }
        return score;
    }

    /**
     * Calculates the total possible points of this ListQuizzer
     * @return the score of this ListQuizzer
     */
    public int calculateTotalPoints(){
        int score=0;
        LinkedNode<MultipleChoiceQuestion> currentNode=this.head;
        for(int i=0; i<this.size; i++){
            score+=currentNode.getData().getPointsPossible();
            currentNode=currentNode.getNext();
        }
        return score;
    }

    /**
     * Returns a deep copy of this list. This method creates a copy of this list as a new ListQuizzer and adds deep copies of each MultipleChoiceQuestion stored in this list to the deep copy.
     * @return a deep copy of this list.
     */
    public ListQuizzer copy(){
        ListQuizzer newList=new ListQuizzer();
        LinkedNode<MultipleChoiceQuestion> currentNode=this.head;
        int index=0;
        for(int i=0; i<this.size; i++){
            newList.add(index, currentNode.getData().copy());
            index++;
            currentNode=currentNode.getNext();
        }
        return newList;
    }

      /**
   * Loads MultipleChoiceQuestions from a file
   * 
   * @author Jeff and Mouna
   * 
   * @param file file to read
   * @return the number of added MultipleChoiceQuestions to this list
   * @throws FileNotFoundException if the file is not found
   */
  public int loadQuestions(File file) throws FileNotFoundException {
    int loadedCount = 0; // count of loaded multiple choice questions
    int answerCount = 0; // count of possible answers per question
    int indexCorrectAnswer = 0; // index of the correct answer
    int points = 0; // possible points for a multiple choice question
    // try to read the file
    Scanner reader = null; // scanner to read the file line by line
    int lineNumber = 0; // number of the last read line

    try {
      reader = new Scanner(file);
      // parse the file lines - while loop to read parts of each multiple choice question
      while (reader.hasNextLine()) { // no more lines to read
        // read title
        String title = reader.nextLine();
        lineNumber++;

        // read question stem
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        String question = reader.nextLine();
        lineNumber++;

        // read possible answers count
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        String count = reader.nextLine();
        lineNumber++;
        // check the validity of count
        try {
          answerCount = Integer.parseInt(count.trim());
          if (answerCount <= 0 || answerCount > 10) {
            throw new NumberFormatException();
          }
        } catch (NumberFormatException e) { // count invalid - print an error message and return
          System.out
              .println("Syntax error! A positive integer less or equal to 10 is expected at line "
                  + lineNumber + (". Load questions operation interrupted!"));
          return loadedCount;
        }
        // valid count -> create the answerList array
        String[] answerList = new String[answerCount];
        int index = 0;
        while (index < answerCount && reader.hasNextLine()) {
          String answer = reader.nextLine();
          lineNumber++;
          answerList[index] = answer;
          index++;
        }

        // read index of the correct answer
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        String line = reader.nextLine();
        lineNumber++;
        try { // check the validity of the index of the correct answer
          indexCorrectAnswer = Integer.parseInt(line.trim());
          if (indexCorrectAnswer < 0 || indexCorrectAnswer >= answerCount) {
            throw new NumberFormatException();
          }
        } catch (NumberFormatException e) { // indexCorrectAnswer invalid - print error and return
          System.out.println("Syntax error! A positive integer less than " + answerCount
              + " is expected at line " + lineNumber + (". Load questions operation interrupted!"));
          return loadedCount;
        }
        // valid index of the correct answer -> read possible points
        // read points
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        line = reader.nextLine();

        lineNumber++;
        try { // check the validity of the index of the correct answer
          points = Integer.parseInt(line.trim());

          if (points < 0) {
            throw new NumberFormatException();
          }
        } catch (NumberFormatException e) { // invalid points - print error message and return
          System.out.println("Syntax error! A positive integer for possible points "
              + " is expected at line " + lineNumber + (". Load questions operation interrupted!"));

          return loadedCount;
        }
          // create and add quizQuestion
          MultipleChoiceQuestion quizQuestion =
              new MultipleChoiceQuestion(title, question, answerList, indexCorrectAnswer, points);

          this.addLast(quizQuestion);
          loadedCount += 1;
          System.out.println("Question " + loadedCount + " loaded!");

      }
    } finally {
      if (reader != null)
        reader.close();
    }

    return loadedCount;
  }


  /**
   * Allows a user to take this quiz. The quiz should be taken on a deep copy of this ListQuizzer.
   * This method should not make any changes to the contents of this ListQuizzer.
   * 
   * @author Jeff and Mouna
   * 
   * @return the instance of ListQuizzer taken by the user. It should include the user's responses.
   */
  public ListQuizzer takeQuiz() {

    ListQuizzer copy = this.copy();
    copy.switchMode(ListingMode.ALL);
    Scanner input = new Scanner(System.in);
    for (MultipleChoiceQuestion question : copy) {
      System.out.println(question);
      System.out.print("Enter your answer: ");
      int entry = input.nextInt();
      question.setStudentAnswerIndex(entry - 1);
      if (question.isCorrect()) {
        System.out.println("Correct!");
      } else {
        System.out.println("Incorrect!");
      }
    }
    int correctPoints = copy.calculateScore();
    int totalPoints = copy.calculateTotalPoints();
    System.out.println("Your Score: " + correctPoints);
    System.out.println("Percentage: " + correctPoints / totalPoints);
    input.close();
    return copy;
  }

  /**
   * Returns true if o is a ListQuizzer which has the exact same contents as this ListQuizzer
   * 
   * @author Mouna
   *
   * @param o an object to compare with
   * @return true if o is instanceof ListQuizzer with the exact same contents as this ListQuizzer
   */
  @Override 
  public boolean equals(Object o) {
    if(o instanceof ListQuizzer) {
      ListQuizzer other = (ListQuizzer)o;
      if(this.size()!= other.size())
        return false;
      this.switchMode(ListingMode.ALL);
      other.switchMode(ListingMode.ALL);
      Iterator<MultipleChoiceQuestion> iterator = this.iterator();
      Iterator<MultipleChoiceQuestion> otherIterator = other.iterator();
      while(iterator.hasNext()) {
        if(!iterator.next().equals(otherIterator.next()))
          return false;
      }
      return true;
    }
    return false;
  }

    /**
     * Returns an iterator to iterate through this list with respect to the listingMode.
     * If the listingMode is ALL, the returned iterator is initialized to the head of this list.
     * If the
   * listingMode is CORRECT, the returned iterator is initialized to the node carrying first
   * correctly answered question If the listingMode is INCORRECT, the returned iterator is
   * initialized to the node carrying first incorrectly answered question
   * @return an iterator to iterate through this list with respect to the listingMode of this list.
     */
    @Override
    public Iterator<MultipleChoiceQuestion> iterator() {
        if(listingMode==ListingMode.ALL){
            QuizQuestionsIterator a=new QuizQuestionsIterator(head);
            return a;
        }
        if(listingMode==ListingMode.CORRECT){
            LinkedNode<MultipleChoiceQuestion> currentNode=this.head;
            for(int i=0; i<this.size; i++){
                if(currentNode.getData().isCorrect()){
                    CorrectQuestionsIterator a=new CorrectQuestionsIterator(currentNode);
                    return a;
                }
                currentNode=currentNode.getNext();
            }
        }
        if(listingMode==ListingMode.INCORRECT){
            LinkedNode<MultipleChoiceQuestion> currentNode=this.head;
            for(int i=0; i<this.size; i++){
                if(currentNode.getData().isCorrect()==false){
                    IncorrectQuestionsIterator a=new IncorrectQuestionsIterator(currentNode);
                    return a;
                }
                currentNode=currentNode.getNext();
            }
        }
        return null;
    }
    
}
