import java.io.* ;

public class Main {
    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
			stringPermutations (line);
    }
  }

  private static void stringPermutations (String word){
			System.out.println (word);

  }

}
