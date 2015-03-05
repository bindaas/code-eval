import java.io.* ;
import java.util.* ;

public class Main {
    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
			List<String>combinations = new ArrayList<String> ();
			generateCombinations (combinations,1,line);
			System.out.println("combinations->"+combinations);
			//String expression = addPlusSign(line);
			//Node root  = createNode(expression);
			//int value = calculateNode (root);
			//System.out.println("expression->"+expression+" value->"+value);

    }
  }



  private static void generateCombinations (List<String>combinations ,int i ,String number){
	  if (number.length()== 0){
		return  ;
	  }
	  char c = number.charAt(0);
	  String aCombo = null;
	  if ((1 % 3)==0){
		  aCombo= "+"+c+generateCombinations (combinations ,++i,number.substring(1));
		  System.out.println ("3:"+aCombo);
		  combinations.add (aCombo);
		  return aCombo;
	  }
	  else if ((1 % 2)==0){
		  aCombo= "-"+c+generateCombinations (combinations ,++i,number.substring(1));
		  System.out.println ("2:"+aCombo);
		  combinations.add (aCombo);
		  return aCombo;
	  }
	  else{
		  aCombo= ""+c+generateCombinations (combinations ,++i,number.substring(1));
		  System.out.println ("1:"+aCombo);
		  combinations.add (aCombo);
		  return aCombo;
	  }
  }

  private static String getCombo (char c , int counter){
		if (counter==0){
			return ""+ c;
		}else if (counter==1){
			return "+"+ c;
		}else{
			return "-"+ c;
		}
  }


  private static List<String> generateCombinations (String number){
	List combinations = new ArrayList<ArrayList<String>>();
	char[] digits = number.toCharArray();

	String combination = ""+digits[0];
	for (int i = 1 ; i < digits.length ; ++i){

		for (int j = 0 ; j < 1 ;++j){
			if (j==0){
				combination += digits[i];
			}else if (j==1){
				combination += "+"+digits[i];
			}else{
				combination += "-"+digits[i];
			}
		}
		}
		System.out.println ("Combination :"+combination);

	return combinations;
	}


  private static String addPlusSign (String expression){
  	if ((expression.charAt(0)>='0')&& (expression.charAt(0)<='9')){
		return "+"+expression ;
	}
	else return expression ;
  }

  private static boolean isUglyNumber( int number){
	  if ((number % 2) == 0) return true;
	  else if ((number % 3) == 0) return true;
	  else if ((number % 5) == 0) return true;
	  else if ((number % 7) == 0) return true;
  	  else return false ;
  }

  private static int calculateNode (Node root){
	  int value = 0 ;
	  Iterator opIterator = root.getChildren ();
	  while (opIterator.hasNext()){
			Node opNode = (Node)opIterator.next();
			char op = opNode.getElement ();
			Iterator digitIterator = opNode.getChildren ();
			String number = "";
			while (digitIterator.hasNext()){
				Node digitNode = (Node)digitIterator.next();
				char digit = digitNode.getElement ();
				number+= digit ;
			}
			if (op == '+'){
				value += new Integer(number).intValue();
			}else if (op == '-'){
				value -= new Integer(number).intValue();
			}else{
				throw new RuntimeException ("Invalid op found :"+op);
			}
	  }
	  return value ;
  }

  private static Node createNode(String expression){
	  Node root = new Node ();
	  Node current = null;
	  for (int i = 0 ; i <expression.length(); ++i){
	  	char element = expression.charAt(i) ;
	  	if (isOperator(element)){
			Node op = new Node (element, root);
			current = op ;
		}else{
			Node digit = new Node (element, current);
		}
	  }
	  return root ;
  }

	  private static boolean isOperator (char element){
	  	return ((element =='+')|| (element =='-'));
	  }

  private static class Node {
	  private char element;
	  private Node parent;
	  private List <Node> children ;

	  public Node (){
		this (' ' , null);
	  }

	  public Node (char element , Node parent){
		this.element = element ;
		this.parent = parent;
		if (parent !=null){
			parent.addChild (this);
		}
	  	children = new ArrayList<Node> ();
	  }
	  public boolean isRoot () {
	  	return (parent==null);
	  }
      public char getElement (){
	  	return element ;
	  }

	  public void addChild (Node child) {
		children.add(child);
	  }
	  public Iterator<Node> getChildren (){
	  	return children.iterator ();
	  }

  }
}
