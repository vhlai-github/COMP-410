package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  @Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }
  
  
  @Override
  public boolean insert(String s) {
	  if (root == null) {
		  BST_Node temp = new BST_Node(s);
		  root = temp;
		  size++;
		  return true;
	  } else if (root.insertNode(s, root)) {
		  size++;
		  return true;
	  } else {return false;}
  }

  @Override
  public boolean remove(String s) {
	  if (contains(s)) {
		  size--;
		  if (root.data == s) {
			  BST_Node temp = new BST_Node(s);
			  temp.left = root;
			  boolean res = root.removeNode(s,  temp);
			  root = temp.left;
			  return res;
		  }else {
			  return root.removeNode(s,  null);}
	  } else {return false;}
  }
  
  @Override
  public String findMin() {
	  if(empty()) {return null;}
	  else {return root.findMin().data;}
  }
  
  @Override
  public String findMax() {
	  if(empty()) {return null;}
	  else {return root.findMax().data;}
  }
  
  @Override
	public boolean empty() {	
		if(size == 0){return true;} 
		else {return false;}
	}
  
  @Override
	public boolean contains(String s) {
		if (size == 0){return false;} 
		else {return root.containsNode(s, root);}
	}

	@Override
	public int size() {return size;}

	@Override
	public int height() {return root.getHeight(root);}
  
}