/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
  Node sentinel; //this will be the entry point to your linked list (the head)
  
  int size = 0; //used to continuously update size
  
  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
    sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
  }
  
  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
 
  public boolean insert(double elt, int index) {
	  Node currentNode = sentinel;
	  Node newNode = new Node(elt);
	  Node tempNode;
	  int counter = 0;
	  if (index > size) {
		  return false;
	  }
	  else if (index == size){
		  if (isEmpty()) {
			  sentinel.next = newNode;
			  newNode.prev = sentinel;
			  newNode.next = null;
			  size++;
			  }
		  else {
			  while(counter < index) {
				  currentNode = currentNode.next;
				  counter++;
			  }
			  newNode.next = null;
			  currentNode.next = newNode;
			  newNode.prev = currentNode;
			  size++;
		  }   
	  }
	  else if (index != size) {
		  if (index == 0) {
			  tempNode = currentNode.next;
			  currentNode.next = newNode;
			  newNode.prev = currentNode;
			  newNode.next = tempNode;
			  size++;
		  }
		  else {
			  while (counter < index) {
				  currentNode = currentNode.next;
				  counter++;
			  }
			  tempNode = currentNode.next;
			  currentNode.next = newNode;
			  newNode.prev = currentNode;
			  newNode.next = tempNode;
			  size++;
		  }
	  }
	  return true;
  }
  public boolean remove(int index) {
	  Node currentNode =sentinel;
	  int counter = 0;
	  if (index > size) {
		  return false;
	  }
	  if (index == 0) {
		  currentNode.next = currentNode.next.next;
		  size--;
		  return true;
	  }
	  else if(index >size) {
		  return false;
	  }
	  else if (index == size){
		  while(counter < index) {
			  currentNode = currentNode.next;
			  counter++;
		  }
		  size--;
		  return true;
	  }
	  else if (index != size) {
		  while(counter < index) {
			  currentNode = currentNode.next;
			  counter++;
		  }
		  currentNode.next = currentNode.next.next;
		  size--;
		  return true;
	  }
	  else {
		  return false;
	  }
  }
  public double get(int index) {
	  Node currentNode = sentinel;
	  int counter = 0;
	  if (isEmpty()) {
		  return Double.NaN;
	  }
	  else if (index > size) {
		  return Double.NaN;
	  }
	  else if (index == 0) {
		  return currentNode.getNext().data;
	  }
	  else {
		  while(counter < index) {
			  currentNode = currentNode.next;
			  counter++;
		  }
		  return currentNode.getNext().data;
	  }
	  
  }
  public int size() {
	  return size;
  }
  public boolean isEmpty() {
	  if (size == 0) {
		  return true;
	  }
	  else {
		  return false;
	  }
  }
  public void clear() {
	  int counter = size;
	  while (counter > 0) {
		  remove(counter);
		  counter--;
	  }
  }
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return sentinel;
  }
}