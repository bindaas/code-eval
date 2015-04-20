import java.io.* ;
import java.util.* ;

public class Main {

	static int NO_OF_GENERATIONS = 10;
	static int ROW = 100 ;
	static int COL = 100 ;

    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    Boolean[][] matrix = new Boolean[ROW][COL];
    int i=0;
    while ((line = in.readLine()) != null) {
			Boolean[]cellsRow = parseCells(line);
			matrix[i++]= cellsRow;
    }
    //printMatrix(matrix);
    //System.out.println();
    Boolean[][] newMatrix =runGenerations (matrix,NO_OF_GENERATIONS);
    printMatrix(newMatrix);

  }

  private static Boolean[] parseCells (String line){
		Boolean[] cells = new Boolean[line.length()];
		char[] charArray = line.toCharArray();
		int i = 0;
		for (char c :charArray){
			Boolean isAlive = (c=='*')?new Boolean (true):Boolean.FALSE;
			cells[i++]=isAlive;
		}
		return cells ;
  }

   private static void printMatrix (Boolean[][] matrix){
	   for (int r = 0; r < matrix[0].length; r++){
	   		for (int c = 0;c < matrix.length; c++){
				String cellContents=(matrix[r][c])?"*":".";
				System.out.print(cellContents);
			}
			System.out.println();
	   }

   }

  private static List<Boolean> getNeighbours (int row,int col,Boolean[][] matrix){
	  Boolean top = null,bottom = null,left = null,right = null ;
	  Boolean topLeft = null,topRight = null,bottomLeft = null,bottomRight = null ;

	  List<Boolean> neighbours = new ArrayList<Boolean> (8);

	  if (row == 0){
	  	top = Boolean.FALSE;
	  }else{
		top=matrix[row-1][col];
	  }

	  if (row == matrix[0].length-1){
	  	bottom = Boolean.FALSE;
	  }else{
		bottom=matrix[row+1][col];
	  }

	  if (col == 0){
	  	left = Boolean.FALSE;
	  }else{
		left=matrix[row][col-1];
	  }

	  if (col == matrix.length-1){
	  	right = Boolean.FALSE;
	  }else{
		right=matrix[row][col+1];
	  }


	  if ((row == 0)||(col == 0)){
	  	topLeft = Boolean.FALSE;
	  }else {
		topLeft=matrix[row-1][col-1];
	  }

	  if ((row == 0)||(col == matrix.length-1)){
	  	topRight = Boolean.FALSE;
	  }else {
		topRight=matrix[row-1][col+1];
	  }

	  if ((row == matrix[0].length-1)||(col == 0)){
	  	bottomLeft = Boolean.FALSE;
	  }else {
		bottomLeft=matrix[row+1][col-1];
	  }

	  if ((row == matrix[0].length-1)||(col == matrix.length-1)){
	  	bottomRight = Boolean.FALSE;
	  }else{
		bottomRight = matrix[row+1][col+1];
	  }


	  neighbours.add(top);
	  neighbours.add(bottom);
	  neighbours.add(left);
	  neighbours.add(right);
	  neighbours.add(topLeft);
	  neighbours.add(topRight);
	  neighbours.add(bottomLeft);
	  neighbours.add(bottomRight);

	  return neighbours ;
  }

  private static Boolean transformCell (int row,int col,Boolean[][] matrix){
	  List<Boolean> neighbours = getNeighbours ( row,col,matrix);
	  int alive = countAliveNeighbours (neighbours);
	  if (matrix[row][col]==Boolean.TRUE){
		  if ((alive < 2)||(alive>3)) return Boolean.FALSE;
		  else return Boolean.TRUE;
	  }else{
		  if (alive ==3) return Boolean.TRUE ;
		  else return Boolean.FALSE;
	  }
  }


	private static int countAliveNeighbours (List<Boolean> neighbours){
		int alive = 0 ;
		for (Boolean cell:neighbours){
			if (cell) alive++ ;
		}
		return alive ;
	}

   private static Boolean[][] transformMatrix (Boolean[][] matrix){
	   Boolean[][] newGeneration = new Boolean[ROW][COL];
	   for (int r = 0; r < matrix[0].length; r++){
	   		for (int c = 0;c < matrix.length; c++){
				newGeneration[r][c]= transformCell (r,c,matrix);
			}
		}
   	   return newGeneration ;
   }


   private static Boolean[][] runGenerations(Boolean[][] seedMatrix, int count){
		Boolean[][] newMatrix = null ;
		for (int i = 0 ; i < count;i++){
			newMatrix = transformMatrix (seedMatrix);
			seedMatrix = newMatrix ;
		}

		return newMatrix;
   }
}
