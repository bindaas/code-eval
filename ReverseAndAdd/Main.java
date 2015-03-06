import java.io.* ;

public class Main {
    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
			String[]result = findPalindrome (line);
			System.out.println (result[1]+" "+result[0]);
			//System.out.println (isPalindrome(new Integer(line).intValue()));
    }
  }

  private static String[] findPalindrome (String line){
	  int i = 0 ;
	  int number = new Integer(line).intValue();
	  while (!isPalindrome (number) && (i <100)){
		  i++;
		  number += reverseNumber (number);
	  }
	  String []result= new String[2];
	  result[0]= ""+number;
	  result[1] = ""+i;
	  return result;
  }

  private static String reverseNumberString (String numberText) {
	  int length = numberText.length();
	  String reverseNumber= "";
	  for (int i = length-1 ; i>=0 ;i--){
		reverseNumber += numberText.charAt(i);
	  }
	  return reverseNumber ;
  }


  private static int reverseNumber (int number) {
	  String numberText = number+"";
	  String reverseNumber = reverseNumberString(numberText);
	  return new Integer(reverseNumber).intValue() ;
  }

  private static boolean isPalindrome (int number) {
	  String numberText = number+"";
	  String reverseNumber = reverseNumberString(numberText);
	  return numberText.equals(reverseNumber) ;
  }

}
