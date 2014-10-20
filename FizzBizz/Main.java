import java.io.* ;

public class Main {
    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        String[] lineArray = line.split(" ");
        if (lineArray.length > 0) {
            int divider1 = new Integer(lineArray[0]).intValue();
            int divider2 = new Integer(lineArray[1]).intValue();
            int count = new Integer(lineArray[2]).intValue();
			fizzBizz (divider1 , divider2 , count);
			System.out.println ();
        }
    }
  }

  private static void fizzBizz (int divider1 , int divider2 , int count){
		for (int i= 1 ; i <= count;i++){
			boolean isFizz = false;
			boolean isBizz = false;

			if (i%divider1==0){
				isFizz = true ;
			}
			if (i%divider2==0){
				isBizz = true ;
			}
			if (isFizz){
				System.out.print ("F");
			}
			if (isBizz){
				System.out.print ("B");
			}
			if ((!isFizz)&& (!isBizz)){
				System.out.print (i);
			}
			if (i != count){
				System.out.print (" ");
			}

		}

  }

}
