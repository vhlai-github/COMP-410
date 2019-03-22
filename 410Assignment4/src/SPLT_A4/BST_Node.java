package SPLT_A4;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  BST_Node par; //parent...not necessarily required, but can be useful in splay tree
  boolean justMade; //could be helpful if you change some of the return types on your BST_Node insert.
            //I personally use it to indicate to my SPLT insert whether or not we increment size.
  
  BST_Node(String data){ 
    this.data=data;
    this.justMade=true;
  }
  
  BST_Node(String data, BST_Node left,BST_Node right,BST_Node par){ //feel free to modify this constructor to suit your needs
    this.data=data;
    this.left=left;
    this.right=right;
    this.par=par;
    this.justMade=true;
  }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is (meaning also make sure they do in fact return data,left,right respectively)

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------

  
  // --- Some example methods that could be helpful ------------------------------------------
  //
  // add the meat of correct implementation logic to them if you wish

  // you MAY change the signatures if you wish...names too (we will not grade on delegation for this assignment)
  // make them take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

  
  public BST_Node containsNode(String s){
		if(data.equals(s))return this;
		if(data.compareTo(s)>0){
			if(left==null)return this;
			return left.containsNode(s);
		}
		if(data.compareTo(s)<0){
			if(right==null)return this;
			return right.containsNode(s);
		}
		return null; 
	} //note: I personally find it easiest to make this return a Node,(that being the node splayed to root), you are however free to do what you wish.
  
  public BST_Node insertNode(String s){
		if(data.compareTo(s)>0){
			if(left==null){
				left=new BST_Node(s);
				return left;
			}
			return left.insertNode(s);
		}
		else if(data.compareTo(s)<0){
			if(right==null){
				right=new BST_Node(s);
				return right;
			}
			return right.insertNode(s);
		}
		else{return null;//ie we have a duplicate
		}
	} //Really same logic as above note
  public boolean removeNode(String s){
		if(data==null)return false;
		if(data.equals(s)){
			if(left!=null){
				data=left.findMax().data;
				left.removeNode(data);
				if(left.data==null)left=null;
			}
			else if(right!=null){
				data=right.findMin().data;
				right.removeNode(data);
				if(right.data==null)right=null;
			}
			else data=null;
			return true;
		}
		else if(data.compareTo(s)>0){
			if(left==null)return false;
			if(!left.removeNode(s))return false;
			if(left.data==null)left=null;
			return true;
		}
		else if(data.compareTo(s)<0){
			if(right==null)return false;
			if(!right.removeNode(s))return false;
			if(right.data==null)right=null;
			return true;
		}
		return false;
	}
	public BST_Node findMin(){
		if(left!=null)return left.findMin();
		return this;
	}
	public BST_Node findMax(){
		if(right!=null)return right.findMax();
		return this;
	}
	public int getHeight(){
		int l=0;
		int r=0;
		if(left!=null)l+=left.getHeight()+1;
		if(right!=null)r+=right.getHeight()+1;
		return Integer.max(l, r);
	}

 // private void splay(BST_Node toSplay) { return false; } //you could have this return or take in whatever you want..so long as it will do the job internally. As a caller of SPLT functions, I should really have no idea if you are "splaying or not"
                        //I of course, will be checking with tests and by eye to make sure you are indeed splaying
                        //Pro tip: Making individual methods for rotateLeft and rotateRight might be a good idea!
 

  // --- end example methods --------------------------------------

  
  

  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  	public BST_Node rotateLeft(BST_Node parent){
		BST_Node temp = parent.right;
		parent.right = temp.left;
		temp.left = parent;
		return temp;
	}
	
  	public BST_Node rotateRight(BST_Node parent){
		BST_Node temp = parent.left;
		parent.left = temp.right;
		temp.right = parent;
		return temp;
	}
  
  	public BST_Node callSplay(BST_Node place, BST_Node target){
		return this.splay(place, target.data);
	}
	
	private BST_Node splay(BST_Node place, String target){
		if(place == null){
			return null;
		}
		//Tests side of root
		int tree0 = target.compareTo(place.data);
		if(tree0 < 0){ //Node to left of root
			
			if(place.left == null){
				return place;
			}
			
			//Tests side of child node
			int tree1 = target.compareTo(place.left.data);
			//Recursive splay statements
			if(tree1 < 0){
				place.left.left = splay(place.left.left, target);
				place = rotateRight(place);
			} else if (tree1 > 0){
				place.left.right = splay(place.left.right, target);
				if(place.left.right != null){
					place.left = rotateLeft(place.left);
				}
			} 
			if(place.left == null){
				return place;
			} else {	
				return rotateRight(place);
			}	
		} else if(tree0 > 0){ //Node to right of root
			if(place.right == null){
				return place;
			}
			//Tests side of child node
			int tree1 = target.compareTo(place.right.data);
			
			//Recursive splay statements
			if(tree1 < 0){
				place.right.left = splay(place.right.left, target);
				if(place.right.left != null){
					place.right = rotateRight(place.right);
				}
				
			} else if(tree1 > 0){
				place.right.right = splay(place.right.right, target);
				place = rotateLeft(place);
			}
			
			if(place.right == null){
				return place;
			} else {
				return rotateLeft(place);
			}
					
		}	
		else {
			return place;
		}
	} 
}