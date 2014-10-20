import java.io.* ;

public class Main {

    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        String[] lineArray = line.split(" ");
        if (lineArray.length > 0) {
			doublePop (lineArray);
			System.out.println ();
        }
    }
	}

    private static void doublePop (String[] stack){
		int i = stack.length-1;
		while (i >=0){
			System.out.print (stack[i]+" ");
			i = i -2 ;
		}

	}



}
