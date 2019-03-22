package SPLT_A4;

public class SPLT implements SPLT_Interface{
	private BST_Node root;
	  private int size;
	  
	  public SPLT() {this.size = 0;} 
	  
	  public BST_Node getRoot() {return root;}
	 
	  public boolean insert(String s) {
		  	if(root==null){
				root=new BST_Node(s);
				size++;
				return true;
			}
			BST_Node ins = root.insertNode(s);
			
			if(ins != null){
				size++;
				root = root.callSplay(root, ins);
				return true;
			} else if(ins == null){
				root = root.callSplay(root, new BST_Node(s));
				return true;
			}
			else return false;
	  };
	  public boolean remove(String s) {
		  	if(root==null) {return false;}
		  	if(size==1&&root.data.equals(s)){
				root=null;
				size--;
				return true;
			}
			 
			root = root.callSplay(root, new BST_Node(s));
			
			if(root.data.compareTo(s) != 0){return false;} 
			else {
				if(root.left == null){
					BST_Node temp = root.right;
					root = temp;
					size--;
					return true;
				}else{
					BST_Node temp = root.left;
					temp = temp.callSplay(temp, new BST_Node(s));
					temp.right = root.right;
					root = temp;
					size--;
					return true;
				}
			}
	  }
	  
	  public String findMin() {
		  if(root==null){
				return null;
			}
			BST_Node ins = root.findMin();
			root = root.callSplay(root, ins);
			return ins.data;
	  }
	  
	  public String findMax() {
		  if(root==null){
				return null;
			}
			BST_Node ins = root.findMax();
			root = root.callSplay(root, ins);
			return ins.data;
	  }
	  
	  public boolean empty() {
		  return size==0;
	  }
	  
	  public boolean contains(String s) {
		  if(empty()){return false;}
			
			BST_Node ins = root.containsNode(s);
			
			if (ins.data == s){
				root = root.callSplay(root, ins);
				return true;
			} else {return false;}
	  };
	  public int size() {return size;}
	  
	  public int height() {
		  if(root==null){return -1;}
		  return root.getHeight();
	}  
}

