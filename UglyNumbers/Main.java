import java.io.* ;
import java.util.* ;

public class Main {
    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
			String expression = addPlusSign(line);
			Node root  = createNode(expression);
			int value = calculateNode (root);
			System.out.println("expression->"+expression+" value->"+value);

    }
  }


  private static int countUglyNumbers(String number){
	int count = 0;
	List<String> expressions = generateExpressions (number);
	for (String expression:expressions){
		int value = calculateExpression (new Stack());
		if (isUglyNumber(value)){
			count++;
		}
	}
	return count ;
  }


  private static List <String> generateExpressions (String number){
  	return new ArrayList<String> (0);
  }

  private static int calculateExpression (Stack expression){
	  int value = 0 ;
	  while (true){
		if (expression.size() ==0){
			break;
		}
		String element = (String)expression.pop ();
	  }
  	  return value ;
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
