import java.io.* ;
import java.util.* ;

public class Main {
    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    List <List<Boolean>> matrix = new ArrayList <List<Boolean>>();
    while ((line = in.readLine()) != null) {
			System.out.println (line);
			List<Boolean>cellsRow = parseCells(line);
			matrix.add (cellsRow);
    }
    		System.out.println ();
    printMatrix(matrix);

  }

  private static List<Boolean>  parseCells (String line){
		List<Boolean> cells = new ArrayList<Boolean> (100);
		char[] charArray = line.toCharArray();
		for (char c :charArray){
			Boolean isAlive = (c=='*')?new Boolean (true):new Boolean (false);
			cells.add (isAlive);
		}
		return cells ;
  }


   private void runGenerations(List <List<Boolean>> seedMatrix, int count){
		List <List<Boolean>> newMatrix = transformMatrix (seedMatrix);
		printMatrix(newMatrix);
   }

   private static void printMatrix (List <List<Boolean>> matrix){
	   for (List<Boolean>rows :matrix){
	   		for (Boolean cell:rows){
				String cellContents=(cell)?"*":".";
				System.out.print(cellContents);
			}
			System.out.println();
	   }

   }

   private List <List<Boolean>> transformMatrix (List <List<Boolean>> matrix){
   		return null ;
   }

  private static List<Boolean> getNeighbours (int row,int col,List <List<Boolean>> matrix){
	  Boolean top = null,bottom = null,left = null,right = null ;
	  List<Boolean> neighbours = new ArrayList<Boolean> (4);

	  if (row == 0){
	  	top = new Boolean (false);
	  }else{

	  }

	  neighbours.add(top);
	  neighbours.add(bottom);
	  neighbours.add(left);
	  neighbours.add(right);
	  return neighbours ;
  }

  private Boolean transformCell (Boolean currentState,List<Boolean> neighbours){
  	return null ;
  }

}
