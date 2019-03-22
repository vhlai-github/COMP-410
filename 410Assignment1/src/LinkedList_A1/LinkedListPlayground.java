package LinkedList_A1;

public class LinkedListPlayground {

  public static void main(String[] args) { 
    /*
     here you can instantiate your LinkedList and play around with it to check
     correctness. We've graciously also provided you a bit of extra test data for debugging.
     It doesn't matter what you have in here. We will not grade it. This is for your use in testing your implementation.
      */
	clearTests();
	sizeTests();
    insertTests();
    removeTests();
    getTests();
    everythingTest();

  }
  
  public static void clearTests() {
	  System.out.println("ClearTests");
	  LinkedListImpl L = new LinkedListImpl();
	  System.out.println("1............");
	  L.insert(3, 0);
	  L.clear();
	  L.insert(5, 0);
	  L.insert(6, 1);
	  L.insert(4, 0);
	  printList(L);
	  System.out.println("2...........");
	  L.clear();
	  System.out.println(L.isEmpty());
	  L.clear();
	  L.insert(3, 0);
	  L.insert(5, 0);
	  L.insert(6, 1);
	  L.clear();
	  L.insert(4, 0);
	  printList(L);
  }
  public static void sizeTests() {
	  System.out.println("SizeTests");
	  System.out.println("1............");
	  LinkedListImpl L = new LinkedListImpl();
	  System.out.println(L.size);
	  System.out.println("2............");
	  L.clear();
	  L.insert(45.0, 0);
	  System.out.println(L.size);
	  L.clear();
	  System.out.println("3............");
	  L.insert(3, 0);
	  L.insert(2.0, 1);
	  L.insert(1.0, 2);
	  L.remove(0);
	  System.out.println(L.size);
	  L.clear();
	  System.out.println("4............");
	  System.out.println(L.size);
  }
  
  public static void insertTests() {
	  System.out.println("InsertTests");
	  LinkedListImpl L= new LinkedListImpl();
	  System.out.println("1............");
	  L.insert(3, 0);
	  L.insert(5, 1);
	  L.insert(6, 2);
	  L.insert(4, 1);
	  printList(L);
	  L.clear();
	  System.out.println("2............");
	  L.insert(3,0);
	  L.insert(5, 0);
	  L.insert(6, 0);
	  L.insert(4, 3);
	  printList(L);
	  L.clear();
	  System.out.println("3............");
	  L.insert(3, 0);
	  L.insert(5, 1);
	  L.insert(6, 2);
	  L.insert(4, 3);
	  printList(L);
	  L.clear();
	  System.out.println("4............");
	  System.out.println(L.insert(3, 1));
	  L.clear();
  }
  
  public static void removeTests() {
	  System.out.println("RemoveTests");
	  LinkedListImpl L= new LinkedListImpl();
	  System.out.println("1............");
	  L.insert(3, 0);
	  L.insert(5, 1);
	  L.insert(6, 2);
	  L.insert(4, 1);
	  L.remove(2);
	  printList(L);
	  L.clear();
	  System.out.println("2............");
	  L.insert(3, 0);
	  L.insert(5, 1);
	  L.insert(6, 2);
	  L.insert(4, 1);
	  L.remove(3);
	  printList(L);
	  L.clear();
	  System.out.println("3............");
	  L.insert(3, 0);
	  L.insert(5, 1);
	  L.insert(6, 2);
	  L.insert(4, 1);
	  L.remove(0);
	  printList(L);
	  L.clear();
	  System.out.println("4............");
	  L.insert(3, 0);
	  L.insert(5, 1);
	  L.insert(6, 2);
	  L.insert(4, 1);
	  L.remove(3);
	  printList(L);
	  System.out.println(L.remove(7));
  }
  
  public static void getTests() {
	  System.out.println("GetTests");
	  LinkedListImpl L= new LinkedListImpl();
	  System.out.println("1............");
	  L.insert(3,0);
	  L.insert(5, 1);
	  System.out.println(L.get(0));
	  L.clear();
	  System.out.println("1............");
	  System.out.println(L.get(0));
  }
  
  
  public static void everythingTest(){
    // example test cases
	  System.out.println("EverythingTests");
    LinkedListImpl L= new LinkedListImpl();
    L.insert(3, 0);
	L.insert(2.0, 1);
	L.insert(1.0, 2);
	L.remove(0);
	L.clear();
	L.insert(3, 0);
	L.insert(2.0, 1);
	L.insert(1.0, 0);
	L.remove(2);
	System.out.println(L.size());
	printList(L);
  }
  
  public static void test2() {
	  
  }

public static void test3() {
	  
  }

public static void test4() {
	  
}

public static void test5() {
	  
}

public static void test6() {
	  
}

public static void test7() {
	  
}

public static void test8() {
	  
}

public static void test9() {
	  
}

public static void test10() {
	  
}

  
  public static void printList(LinkedListImpl L){ 
    //note that this is a good example of how to iterate through your linked list
    // since we know how many elements are in the list we can use a for loop
    // and not worry about checking the next field to see if we hit the end sentinel
    Node curr=L.sentinel.next; // the first data node in the list is the one after sentinel. 
    System.out.print("sentinel");
    for(int i=0; i<L.size(); i++) { 
      System.out.print(" --> " + curr.data);
      curr=curr.next;
    }
    System.out.println();
  }
}