import java.io.* ;
import java.util.* ;

public class Main {
    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        String[] lineArray = line.split(",");
        if (lineArray.length > 0) {
			System.out.println (remove(lineArray[0],lineArray[1].trim()));
        }
    }
  }


	private static String remove(String text , String removableText){
		char[] textChar = text.toCharArray();
		char[] newText = new char[textChar.length];
		int j = 0 ;

		for (int i = 0 ; i < textChar.length ;++i){
			if (!shouldBeRemoved (textChar[i] ,removableText  )){
				newText[j]=textChar[i];
				j++ ;
			}
		}
		return new String(newText).trim() ;
	}

	private static boolean shouldBeRemoved (char c ,String removableText  ){
		return removableText.contains(c+"") ;
	}


}
