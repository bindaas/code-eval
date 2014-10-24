import java.io.* ;

public class Main {
    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        String[] lineArray = line.split(" ");
        if (lineArray.length > 0) {
			System.out.println(convertIntoTextDollars(line)+"Dollars");
        }
    }
  }



  private static String convertIntoTextDollars (String amount){
  	if ("0".equals(amount)) return "Zero" ;
  	String convertedText ="";
  	int length = amount.length();
	//System.out.println("convertIntoTextDollars:amount->"+amount);

  	if (length > 9){
		throw new RuntimeException ("Not implemented yet->"+amount);
	}else if (length > 6){
		return convertHundreds(amount.substring(0,length-6),"Million")+convertHundreds(amount.substring(length-6,length-4),"Thousand");
		//+convertHundreds(amount.substring(length-3,length-1),"");
	}else if (length > 3){
		return convertHundreds(amount.substring(0,length-3),"Thousand")+convertHundreds(amount.substring(length-3,length),"");
	}
	else return convertHundreds(amount.substring(0,length),"");
  }


  private static String convertHundreds (String amount, String suffix ){
	  //System.out.println("convertHundreds:amount->"+amount);
	  int length = amount.length ();
	  switch (length){
	 	case 1: return convertOnes(amount.charAt(0)) + ((amount.charAt(0)=='0')?"":suffix);
	 	case 2: return convertUnitTens(amount.charAt(0),amount.charAt(1)) + (((amount.charAt(0)=='0')&&(amount.charAt(1)=='0'))?"":suffix);
	 	case 3: return convertOnes(amount.charAt(0)) +((amount.charAt(0)=='0')?"":"Hundred")+ convertUnitTens(amount.charAt(1),amount.charAt(2)) + suffix;

	 	default: throw new RuntimeException ("Unexpected length");
	  }
  }


  private static String convertUnitTens (char t, char u ){
	  //System.out.println ("t->"+t+" u->"+u);
	  if ((t > '1') && (t <= '9')){
		String tens = convertTens(t);
		String units = convertOnes(u);
		return tens+units ;
	  }else if (t == '0'){
	  	return convertOnes(u);
	  }else if (t == '1'){
		  return convertTeens (u);
	  } else throw new RuntimeException ("Unexpected t:"+t);
  }

  private static String convertTeens (char u){
	//System.out.println (" u->"+u);
	switch (u){
		case '0' : return "Ten";
		case '1' : return "Eleven";
		case '2' : return "Twelve";
		case '3' : return "Thirteen";
		case '4' : return "Forteen";
		case '5' : return "Fifteen";
		case '6' : return "Sixteen";
		case '7' : return "Seventeen";
		case '8' : return "Eighteen";
		case '9' : return "Nineteen";
		default : throw new RuntimeException ();
	}
  }


  private static String convertTens (char c){
	switch (c){
		case '2' : return "Twenty";
		case '3' : return "Thirty";
		case '4' : return "Forty";
		case '5' : return "Fifty";
		case '6' : return "Sixty";
		case '7' : return "Seventy";
		case '8' : return "Eighty";
		case '9' : return "Ninety";
		default : throw new RuntimeException ();
	}
  }



  private static String convertOnes (char c){
	switch (c){
		case '1' : return "One";
		case '2' : return "Two";
		case '3' : return "Three";
		case '4' : return "Four";
		case '5' : return "Five";
		case '6' : return "Six";
		case '7' : return "Seven";
		case '8' : return "Eight";
		case '9' : return "Nine";
		case '0' : return "";
		default : throw new RuntimeException ();
	}
  }


}
