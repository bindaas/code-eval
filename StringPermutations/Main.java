import java.io.* ;
import java.util.* ;

public class Main {
	private static boolean DEBUG = false ;
    public static void main (String[] args) throws Exception{
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
			stringPermutations (line.trim());
    }
  }

  private static void stringPermutations (String word){
  	  		List <String> allPermutations = new ArrayList<String> ();
  	  		permutations (allPermutations,word);
  	  		String reverseWord = new StringBuilder(word).reverse().toString();
  	  		permutations (allPermutations,reverseWord);
  	  		Object[] sortedList = sort (allPermutations);
  	  		if (DEBUG){
  	  			System.out.println ("******************");
  	  		}
  	  		print (sortedList);
  }

      private static List<String> permutations (List <String> allPermutations,String word){
    	int wordLength = word.length();
    	if (wordLength ==0){
    		return allPermutations;
    	} else if (wordLength ==1){
			allPermutations.add (word);
    	}
  	  	if (DEBUG){
  	  		System.out.println ("word->"+word);
  	  	}	
    	for (int i= 0 ; i < wordLength ; ++i){
    		String c = word.substring(i,i+1);
    		String rest = word.substring(i+1,wordLength);
    		if (DEBUG){
    			System.out.println ("c["+i+"]->"+c+" rest->"+rest);
    		}
    		
    		for (int j = i+1 ;j <wordLength ;j++){
    			String c2 = word.substring(j,j+1);
    			String newWord = swap (i,j, word);
				if (DEBUG){
					System.out.println ("c2["+j+"]->"+c2+" newWord->"+newWord);
				}
				if (allPermutations.contains(newWord)){
					return allPermutations;
				}else{
					allPermutations.add (newWord);
					permutations (allPermutations, newWord);
					String reverseWord = new StringBuilder(newWord).reverse().toString();
					permutations (allPermutations,reverseWord);
				}  
    		}
    	}
    	return allPermutations;
    }

    
    private static String swap (int i , int j , String word){
    	char[] allChar = word.toCharArray();
    	char one = allChar[i] ;
    	char two = allChar[j] ;
    	allChar [j] = one;
    	allChar [i] = two;
    	return new String (allChar);
    	
    }
    
    private static Object[] sort (List <String> allPermutations){
    		Object[] allPermutationsArray = allPermutations.toArray ();
    		Arrays.sort(allPermutationsArray);
			return allPermutationsArray ;
  }

    private static void print (Object[] sortedList){
      	  for (int i = 0 ; i <sortedList.length ; ++i){
      	  	  System.out.print (sortedList[i]);
      	  	  if (i != sortedList.length-1){
      	  	  	  System.out.print(",");
      	  	  }
      	  }
      	  System.out.println("");
    }

}
