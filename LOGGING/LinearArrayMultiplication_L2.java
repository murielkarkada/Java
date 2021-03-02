import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

public class LinearArrayMultiplication_L2
{
	public static final Logger logger = LogManager.getLogger(LinearArrayMultiplication_L2.class.getName());	
	
	

	public static void main(String args[]) throws IOException
			{  
			BasicConfigurator.configure();  
			
			String programArgument1= args[0];
			String programArgument2= args[1];

			File input = new File(programArgument1);
			File formattedInput = new File(programArgument2);
			
			//Checking if the file Exits
			if (!input.exists()) 
			{
	            logger.error(" File does not Exists"); 
	            System.exit(-400);
	            
			}
			
			//Checking if the file is empty
			if (input.length() == 0) 
			{
	            logger.error(" File is empty"); 
	            System.exit(-404);
	            
			}
			
			//Checking the Read permission
			if (!input.canRead())
			{
				logger.error(" FILE PERMISSION ERROR : Cannot Read!!!"); 
	            System.exit(-402);
			}
			
			//Checking the Write permission
			if (!input.canWrite())
			{
				logger.error(" FILE PERMISSION ERROR : Cannot Write!!!"); 
	            System.exit(-401);
			}
		    
			//Checking the Execute permission
			if (!input.canExecute())
			{
				logger.error(" FILE PERMISSION ERROR : Cannot Execute!!!"); 
	            System.exit(-403);
			}
			
			 //deleting leading and trailing white spaces
	        FileReader fileReader = new FileReader(input);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        FileWriter fileWriter = new FileWriter(formattedInput);
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {

	            line = line.trim();
	            //deleting extra whitespaces and the spaces before and after ":"
	            line = line.replaceAll("\\s+", " ").replaceAll("\\s+:", ":").replaceAll(":+\\s", ":")+"\n";

	            fileWriter.write(line);
	        }
	        fileReader.close();
	        fileWriter.close();

		         
		       
		      		    
			
			//If the file exists pass it to scanner object
			//Scanner inputFile = new Scanner(input);
			Scanner inputFile = new Scanner(formattedInput);
		
			   
			String[] currentFileVariable = new String[2];
			HashMap<String, String> inputFileVariables = new HashMap<String, String>();
			
			//reading each line of the file,splitting and storing as key value pairs
			while(inputFile.hasNextLine())
			{
			currentFileVariable = inputFile.nextLine().split(":");
//			currentFileVariable[0] = currentFileVariable[0].replaceAll("\\s+", "");
//			currentFileVariable[1] = currentFileVariable[1].replaceAll("\\s+", "");
			inputFileVariables.put(currentFileVariable[0], currentFileVariable[1]);
			}


			String arrayStringValues_1= inputFileVariables.get("array1");
			String arrayStringValues_2= inputFileVariables.get("array2");

			String[] stringArray_1 = arrayStringValues_1.split(",");
			String[] stringArray_2 = arrayStringValues_2.split(",");

			int[] array1 = new int[stringArray_1.length];
			int[] array2 = new int[stringArray_2.length];


			//this is the start and end position of the array
			int startCount = Integer.parseInt(inputFileVariables.get("startCount"));
			int endCount = Integer.parseInt(inputFileVariables.get("endCount"));

			for (int indexOfArray = startCount; indexOfArray < endCount; indexOfArray++)
			{
			String currentStringArrayValue_1 = stringArray_1[indexOfArray];
			String currentStringArrayValue_2 = stringArray_2[indexOfArray];

			array1[indexOfArray] = Integer.parseInt(currentStringArrayValue_1);
			array2[indexOfArray] = Integer.parseInt(currentStringArrayValue_2);
			}
			
			int defaultLoglevel = Integer.parseInt(inputFileVariables.get("defaultLoglevel"));
			int runtimeLoglevel = defaultLoglevel;
			//initializing the initial value
			int InitialProductValue = 0;
			logger.info("Initialisation START...");
			
			logger.info("Default Value for Product Array = [" + InitialProductValue + "]");
			logger.info("Initial Position of Array = [" + startCount + "]");
			logger.info("End Position of Array = [" + endCount + "]");
			logger.info("Default Log Level = [" + defaultLoglevel + "]");
			logger.info("Runtime Log Level = [" + runtimeLoglevel + "]");
			
			logger.info("Initialisation END.....");
			
			
			
			//checking if the start and end are logically correct
			if(startCount >= endCount)
			{   
				
				logger.error("Initial Position ->[" + startCount + "] is greater then or equal to the end position ->[" + endCount +"]");
				System.exit(-3);
			}
				
			
			//The length is computed dynamically
			int ArrayElementCount_1 = array1.length; 
			int ArrayElementCount_2 = array2.length; 
			
			logger.info("ElementCount Array 1 = [" + ArrayElementCount_1 + "]");
			logger.info("ElementCount Array 2 = [" + ArrayElementCount_2 + "]");
			
			
			//checking if both the arrays are of same length otherwise exit
			if(ArrayElementCount_1 != ArrayElementCount_2)
			{
				logger.error("The array lengths are different and hence exiting");
				System.exit(-1);
			}
			
			//checking if the initial positon of the array is within the array size
			if(startCount > ArrayElementCount_1)
			{
				logger.error("Array initial position ->[" + startCount + "] is greater than or equal the size of the array ->[" + ArrayElementCount_1);
				System.exit(-300);
			}
			
			//checking if the end positon of the array is within the array size
			if(endCount > ArrayElementCount_1)
			{
				logger.error("Array end position ->[" + endCount + "] is greater than or equal the size of the array ->[" + ArrayElementCount_1);
				System.exit(-301);
			}
			
				
		    //this holds the product of 2 arrays
			int ArrayProduct[] = new int[ArrayElementCount_1];  
			
			
			//Looping constuct for finding the product of elements in the array
			//ASSUMPTION: both the arrays lengths should e same
			for(int indexOfArray = startCount; indexOfArray < endCount; indexOfArray++ )
			{  
				//initialising the product array
				ArrayProduct[indexOfArray] = InitialProductValue; 
				int ElementOfArray1 = array1[indexOfArray];
				int ElementOfArray2 = array2[indexOfArray];
				
				//displaying the value of array at the current position
				logger.info("Element value of array 1 in the position[" + indexOfArray + "] = " + ElementOfArray1);
				logger.info("Element value of array 2 in the position[" + indexOfArray + "] = " + ElementOfArray2);
				
				//computing products
				int productOfElements = ElementOfArray1 * ElementOfArray2; 
				ArrayProduct[indexOfArray] = productOfElements;
				
				logger.info("Product value at position [" + indexOfArray + "] = " + ArrayProduct[indexOfArray]);   
			} 
		
		}			
			
}