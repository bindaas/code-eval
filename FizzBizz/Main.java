import java.io.* ;

public class Main {
    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        String[] lineArray = line.split(" ");
        if (lineArray.length > 0) {
            Integer divider1 = new Integer(lineArray[0]);
            Integer divider2 = new Integer(lineArray[1]);
            Integer count = new Integer(lineArray[2]);
			fizzBizz (divider1 , divider2 , count);
        }
    }
  }

  private static void fizzBizz (Integer divider1 , Integer divider2 , Integer count){
		System.out.println ("divider1->"+divider1+"\tdivider2->"+divider2+"\tcount->"+count);

  }

}
