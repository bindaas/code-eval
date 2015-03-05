import java.io.* ;

public class Main {
    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        String[] lineArray = line.split(",");
        if (lineArray.length > 0) {
			System.out.println (replaceCharacters(lineArray[0],lineArray[1].trim()));
        }
    }
  }

	private static String replaceCharacters(String text , String replace){
		for (int i = 0 ; i < replace.length() ;i++){
			char c = replace.charAt(i);
			String [] splitStrings = text.split(c+"");
			text= concat(splitStrings);
		}
		return text ;
	}

	private static String concat(String [] splitStrings){
		String rebuild ="";
		for (int i = 0 ; i<splitStrings.length ;++i ){
			rebuild += splitStrings[i];
		}
		return rebuild ;
	}


}
