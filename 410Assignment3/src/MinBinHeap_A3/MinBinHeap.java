package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
  private EntryPair[] array; //load this array
  private int size;
  private int position; //added for ease use in methods
  private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]

  public MinBinHeap() {
    this.array = new EntryPair[arraySize];
    array[0] = new EntryPair(null, -100000);//0th will be unused for simplicity 
    size = 0; position = 0;                 //of child/parent computations...
                                            //the book/animation page both do this.
  }
    
  //Please do not remove or modify this method! Used to test your entire Heap.
  @Override
  public EntryPair[] getHeap() { 
    return this.array;
  }
  
  public int getPosition() {return position;}
  
  @Override
	public void insert(EntryPair entry) {
		if (size == 0){
			position++;
			array[position] = entry;
			size++;
		} else {
			position++;
			array[position] = entry;
			size++;
			bubbleUp();	
		}	
	}
  
  @Override
	public void delMin() {
		array[1] = array[position];
		array[position] = null;
		size--;	
		position--;
		bubbleDown(1,0);
  }
  
  @Override
	public EntryPair getMin() {return array[1];}
  
  	public int size() {
		return size;
	}

	@Override
	public void build(EntryPair[] entries) {
		for(int i = 0; i < entries.length; i++){
			array[i + 1] = entries[i];
			size++;
			position++;
		}
		for(int i = position; i > 0; i -= 2){
			int tempPosition = i / 2;
			bubbleDown(tempPosition, 0);
		}
	}
  
  
  //extra functions
  public void bubbleUp() {
	  int tempPosition = position;
	  while(tempPosition > 0 && array[tempPosition].getPriority() < array[tempPosition/2].getPriority()){
			swap(tempPosition, tempPosition/2);
			tempPosition = tempPosition/2;
		}
  }
  public void bubbleDown(int currPosition, int newPosition){
		
		int tempPosition = newPosition;
		while(findMinChild(currPosition) != 0){
			tempPosition = findMinChild(currPosition);
			if(array[currPosition].getPriority() > array[tempPosition].getPriority()){
				swap(currPosition, tempPosition);
				currPosition = tempPosition;	
			} else {return;}
		}		
	}
  
  //Used in bubbleDown for my organization's sake
  private int findMinChild(int currPosition){ 						
		if(array[currPosition*2] != null && array[currPosition*2+1] != null){
			if(array[currPosition*2].getPriority() > array[currPosition*2+1].getPriority()){return currPosition*2+1;} 
			else {return currPosition*2;}
		} else if (array[currPosition*2] != null && array[currPosition*2+1] == null){
			if(array[currPosition*2].getPriority() < array[currPosition].getPriority()){return currPosition*2;} 
			else{return 0;}
		} else {return 0;}
	}
  
  	//Creates temp node to perform swap
	public void swap(int a, int b) {
		EntryPair temp = array[a]; 
		array[a] = array[b];
		array[b] = temp;
	}
  
}