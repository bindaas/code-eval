import java.io.* ;
import java.util.Stack;
import java.text.* ;

public class Main {
    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        String[] lineArray = line.split(" ");
        if (lineArray.length > 0) {
			Double result = calculate (lineArray);
			DecimalFormat df = new DecimalFormat("#.##");
			System.out.println(df.format(result.doubleValue()));
        }
    }
  }

  private static Double calculate (String [] expression){
  	Stack expressionStack = new Stack ();
  	int i = expression.length -1;
  	do{
		if (isNumeric(expression[i])){
			expressionStack.push (new Double(expression[i]));
		}else{
			Double operand1 = (Double)expressionStack.pop ();
			Double operand2 = (Double)expressionStack.pop ();
			Double result = compute(expression[i],operand1,operand2);
			expressionStack.push (result);
		}
		i--;

	}while ((expressionStack.size()>0) && (i >-1));
	return (Double)expressionStack.pop ();
  }


  private static boolean isNumeric(String str)
  {
	try
	  {
	    double d = Double.parseDouble(str);
	  }
	  catch(NumberFormatException nfe)
	  {
	    return false;
	  }
	  return true;
  }

private static Double compute (String operator , Double operand1, Double operand2){
	if ("+".equals(operator)){
		return (Double)operand1 + (Double)operand2 ;
	}else if ("-".equals(operator)){
		return (Double)operand1 - (Double)operand2 ;
	}else if ("*".equals(operator)){
		return (Double)operand1 * (Double)operand2 ;
	}else if ("/".equals(operator)){
		return new Double((Double)operand1 / (Double)operand2) ;
	}else{
		throw new RuntimeException ();
	}

}


}
