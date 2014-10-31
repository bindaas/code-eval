import java.io.* ;
import java.util.* ;

public class Main {
    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        String[] lineArray = line.split(" ");
        if (lineArray.length > 0) {
			System.out.println("line->"+line+" isUglyNumber:"+isUglyNumber(new Integer(line).intValue()));
        }
    }
  }


  private static int countUglyNumbers(String number){
	int count = 0;
	List<String> expressions = generateExpressions (number);
	for (String expression:expressions){
		int value = calculateExpression (expression);
		if (isUglyNumber(value)){
			count++;
		}
	}
	return count ;
  }


  private static List <String> generateExpressions (String number){
  	return new ArrayList<String> (0);
  }

  private static int calculateExpression (String expression){
  	return 0 ;
  }

  private static boolean isUglyNumber( int number){
	  if ((number % 2) == 0) return true;
	  else if ((number % 3) == 0) return true;
	  else if ((number % 5) == 0) return true;
	  else if ((number % 7) == 0) return true;
  	  else return false ;
  }

}
