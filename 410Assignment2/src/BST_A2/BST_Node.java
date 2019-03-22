package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  
  BST_Node(String data){ this.data=data; }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------

  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

  
  public boolean containsNode(String s, BST_Node currNode){
	  int compare = currNode.data.compareTo(s);
	  
	  if(compare == 0) {
		  return true;
	  }else if(compare > 0 && currNode.left != null) {
		  return containsNode(s, currNode.left);
	  }else if(compare < 0 && currNode.right != null) {
		  return containsNode(s, currNode.right);
	  }else {return false;}
  }
  
  public boolean insertNode(String s, BST_Node currNode){
	  int compare = currNode.data.compareTo(s);
	  
	  if (compare == 0) {return false;} //Node exists
	  else if (compare > 0 && currNode.left == null) { //inserts Left
		  currNode.left = new BST_Node(s); return true;
	  } else if (compare < 0 && currNode.right == null) {  //inserts Right
		  currNode.right = new BST_Node(s); return true;
	  } else if (compare > 0) {return insertNode(s, currNode.left);}  //recursive Left
	  else if (compare < 0) {return insertNode(s, currNode.right);}   //recursive Right
	  else {return false;}
  }
  
  public boolean removeNode(String s, BST_Node parentNode){
	  int compare = this.data.compareTo(s);
	  
	  if (compare > 0) {  //checks left
		  if (this.left != null){return this.left.removeNode(s, this);}
		  else {return false;}
	  }
	  else if (compare < 0) { //checks Right
		  if(this.right != null) {return this.right.removeNode(s, this);}
		  else {return false;}
	  }
	  else {
		  if (this.left != null && this.right != null) {
			  this.data = this.right.findMin().data;
			  this.right.removeNode(this.data, this);
		  } else if (parentNode.left == this) {parentNode.left = (left != null) ? left:right;}
		  else if (parentNode.right == this) {parentNode.right = (left != null) ? left:right;}
	  }
	  return true;
  }
  public BST_Node findMin(){
	  if (this.left == null) {return this;}
	  else {return this.left.findMin();}
  }
  public BST_Node findMax(){ 
	  if (this.right == null) {return this;}
	  else {return this.right.findMax();}
  }
  public int getHeight(BST_Node currNode){ 
	  if(currNode == null) {return -1;} 
	  int leftHeight = getHeight(currNode.left);
	  int rightHeight = getHeight(currNode.right);
	  
	  if (leftHeight > rightHeight) {return leftHeight +1;}
	  else {return rightHeight+1;}
 }
  

  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}