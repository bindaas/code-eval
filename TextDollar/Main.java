import java.io.* ;

public class Main {
    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        String[] lineArray = line.split(" ");
        if (lineArray.length > 0) {
			System.out.println(convertIntoTextDollars(line));
        }
    }
  }

  private static String convertIntoTextDollars (String amount){
  	String convertedText ="Dollars";
  	for (int i = amount.length()-1 ; i >=0; --i){
		char aChar = amount.charAt(i);
		String digit=convertDigit (aChar, i);
		convertedText = digit +convertedText ;

	}

  	return convertedText;
  }


  private static String convertDigit (char c , int place){
	  if (c =='1'){
		  return "One";
      }
  	return "Zero";
  }

}
