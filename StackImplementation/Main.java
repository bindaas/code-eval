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
		int size = stack.length ;
		boolean hasElements = size >=2 ;
		int i = size-1;
		while (hasElements){
			System.out.print (stack[i]+" ");
			i = i -2 ;
			hasElements = i >=0 ;
		}

	}



}
