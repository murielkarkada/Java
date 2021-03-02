import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import java.io.*;
import java.util.*;

public class LinearArrayMultiplication_L6
{
    public static final Logger logger = LogManager.getLogger(LinearArrayMultiplication_L6.class);

    public static void main(String args[]) throws IOException {

        //storing program arguments in variable
        logger.info("storing program arguments in variable....");
        String programArgument_1= args[0];
        String programArgument_2= args[1];
        File argumentSystemFile = new File(programArgument_1);
        File argumentTransactionFile = new File(programArgument_2);
        logger.info("Arguments stored in file successfully");


        //Validation check for the files passed as argument
        //validations for system.dat file
        //check if specified file exists or not
        logger.info( " validating for system.dat file" );
        if (!argumentSystemFile.exists()){
            logger.trace( "Check if specified file exists or not...." );
            logger.error("file does not exist");
            System.exit(-3);
        }

        //checking for permissions
        //Checking the Read permission
        logger.trace( "Checking the Read permission..." );
        if (!argumentSystemFile.canRead())
        {
            logger.error(" FILE PERMISSION ERROR : Cannot Read!!!");
            System.exit(-402);
        }

        //Checking the Write permission
        logger.trace( "Checking the Write permission..." );
        if (!argumentSystemFile.canWrite())
        {
            logger.error(" FILE PERMISSION ERROR : Cannot Write!!!");
            System.exit(-401);
        }

        //Checking the Execute permission
        logger.trace( "Checking the Execute permission..." );
        if (!argumentSystemFile.canExecute())
        {
            logger.error(" FILE PERMISSION ERROR : Cannot Execute!!!");
            System.exit(-403);
        }

        logger.info(" File Premission Checked");

        //Checking if the file is empty
        logger.info( "Checking if the file is empty" );
        if (argumentSystemFile.length() == 0)
        {
            logger.error(" File is empty");
            System.exit(-404);

        }
        logger.info( "system.dat File not empty" );

        //deleting leading and trailing white spaces
        logger.info( " formatting the system.dat file..." );
        FileReader fileReader = new FileReader(argumentSystemFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> lines = new ArrayList<String>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            line = line.trim();
            //deleting extra whitespaces and the spaces before and after ":"
            line = line.replaceAll("\\s+", " ").replaceAll("\\s+:", ":").replaceAll(":+\\s", ":")+"\n";
            lines.add(line);
        }
        fileReader.close();
        bufferedReader.close();
        FileWriter fileWriter = new FileWriter(argumentSystemFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for(String eachLine : lines)
        {
            bufferedWriter.write(eachLine);
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        logger.info( "system.dat file formatted successfully" );

        //validations for transaction.dat file
        //check if specified file exists or not
        logger.info( "validations for transaction.dat file" );
        if (!argumentTransactionFile.exists()){
            logger.error("file does not exist");
            System.exit(-3);
        }

        //checking for permissions
        //Checking the Read permission
        logger.info( "Checking the Read permission... " );
        if (!argumentTransactionFile.canRead())
        {
            logger.error(" FILE PERMISSION ERROR : Cannot Read!!!");
            System.exit(-402);
        }

        //Checking the Write permission
        logger.info( "Checking the Write permission... " );
        if (!argumentTransactionFile.canWrite())
        {
            logger.error(" FILE PERMISSION ERROR : Cannot Write!!!");
            System.exit(-401);
        }

        //Checking the Execute permission
        logger.info( "Checking the Execute permission... " );
        if (!argumentTransactionFile.canExecute())
        {
            logger.error(" FILE PERMISSION ERROR : Cannot Execute!!!");
            System.exit(-403);
        }
        logger.info( " File Permissions checked." );

        //Checking if the file is empty
        logger.info( "Checking if the file is empty... " );
        if (argumentTransactionFile.length() == 0)
        {
            logger.error(" File is empty");
            System.exit(-404);

        }
        logger.info( "File not empty" );

        //deleting leading and trailing white spaces of transaction.dat
        logger.info( "Formatting the transaction.dat file...." );
        FileReader transactionFileReader = new FileReader(argumentTransactionFile);
        BufferedReader transactionBufferedReader = new BufferedReader(transactionFileReader);

        List<String> transactionFileLines = new ArrayList<String>();
        String transactionFileLine;
        while ((transactionFileLine = transactionBufferedReader.readLine()) != null) {

            transactionFileLine = transactionFileLine.trim();
            //deleting extra whitespaces and the spaces before and after ":"
            transactionFileLine = transactionFileLine.replaceAll("\\s+", " ").replaceAll("\\s+:", ":").replaceAll(":+\\s", ":")+"\n";
            transactionFileLines.add(transactionFileLine);
        }
        transactionFileReader.close();
        transactionBufferedReader.close();
        FileWriter transactionFileWriter = new FileWriter(argumentTransactionFile);
        BufferedWriter transactionBufferedWriter = new BufferedWriter(transactionFileWriter);
        for(String eachLine : transactionFileLines)
        {
            transactionBufferedWriter.write(eachLine);
        }
        transactionBufferedWriter.flush();
        transactionBufferedWriter.close();
        logger.info(" Formatted transaction.dat file successfully");

        //deleting leading and trailing white spaces of system.dat
        logger.info( "Formatting the system.dat file...." );
        FileReader systemFileReader = new FileReader(argumentSystemFile);
        BufferedReader systemBufferedReader = new BufferedReader(systemFileReader);

        List<String> systemFileLines = new ArrayList<String>();
        String systemFileLine;
        while ((systemFileLine = systemBufferedReader.readLine()) != null) {

            systemFileLine = systemFileLine.trim();
            //deleting extra whitespaces and the spaces before and after ":"
            systemFileLine = systemFileLine.replaceAll("\\s+", " ").replaceAll("\\s+:", ":").replaceAll(":+\\s", ":")+"\n";
            systemFileLines.add(systemFileLine);
        }
        systemFileReader.close();
        systemBufferedReader.close();
        FileWriter systemFileWriter = new FileWriter(argumentSystemFile);
        BufferedWriter systemBufferedWriter = new BufferedWriter(systemFileWriter);
        for(String eachLine : systemFileLines)
        {
            systemBufferedWriter.write(eachLine);
        }
        systemBufferedWriter.flush();
        systemBufferedWriter.close();

        //taking variables from the file
        Scanner systemFile = new Scanner(argumentSystemFile);
        Scanner transactionFile = new Scanner(argumentTransactionFile);

        String[] currentSystemFileVariable = new String[2];
        //ArrayList<String> arrayValuesString=new ArrayList<String>();
        HashMap<String, String> inputSystemFileVariables = new HashMap<String, String>();
        while(systemFile.hasNextLine())
        {
            currentSystemFileVariable = systemFile.nextLine().split(":");
            inputSystemFileVariables.put(currentSystemFileVariable[0], currentSystemFileVariable[1]);

        }

        String[] currentTransactionFileVariable = new String[2];
        ArrayList<String> arrayValuesString=new ArrayList<String>();
        HashMap<String, String> inputTransactionFileVariables = new HashMap<String, String>();
        while(transactionFile.hasNextLine())
        {
            currentTransactionFileVariable = transactionFile.nextLine().split(":");
            inputTransactionFileVariables.put(currentTransactionFileVariable[0], currentTransactionFileVariable[1]);

            //storing array values separately
            if(currentTransactionFileVariable[0].startsWith("ELEMENTS"))
            {
                arrayValuesString.add(currentTransactionFileVariable[1]);
            }
        }



        //checking whether minimum and arrayCount is specified
        String minArrayCountString = inputSystemFileVariables.get("minArrayCount");
        if(minArrayCountString == null)
        {
            logger.error("Minimum array count is not specified");
            System.exit(-404);
        }
        //checking whether maximum arrayCount is specified
        String maxArrayCountString = inputSystemFileVariables.get("maxArrayCount");
        if(maxArrayCountString == null)
        {
            logger.error("Maximum array count is not specified");
            System.exit(-404);
        }

        //checking whether arrayCount is specified
        String arrayCountString = inputSystemFileVariables.get("arrayCount");
        if(arrayCountString == null)
        {
            logger.error("Array count is not specified");
            System.exit(-404);
        }


        //checking whether array count is within the min and max array count
        int minArrayCount = Integer.parseInt(minArrayCountString);
        int maxArrayCount = Integer.parseInt(maxArrayCountString);
        int arrayCount = Integer.parseInt(arrayCountString);
        if(arrayCount < minArrayCount)
        {
            logger.error("Minimum "+minArrayCount+" arrays required");
            System.exit(-404);
        }
        if(arrayCount > maxArrayCount)
        {
            logger.error("Maximum "+maxArrayCount+" arrays can only be specified");
            System.exit(-404);
        }


        //checking for array names
        String arrayNamesString = inputTransactionFileVariables.get("arrayNames");
        if(arrayNamesString == null)
        {
            logger.error("Array names are not specified");
            System.exit(-404);
        }


        //check check whether start and end position of array are specified
        String startCountString = inputSystemFileVariables.get("startCount");
        if(startCountString == null)
        {
            logger.error("Arrays start count is not specified");
            System.exit(-404);
        }

        //check check whether start and end position of array are specified
        String endCountString = inputSystemFileVariables.get("endCount");
        if(endCountString == null)
        {
            logger.error("Arrays end count is not specified");
            System.exit(-404);
        }

        //this is the start and end position of the array
        int startCount = Integer.parseInt(inputSystemFileVariables.get("startCount"));
        int endCount   = Integer.parseInt(inputSystemFileVariables.get("endCount"));

        //converting string values of array to integer
        String arrayNamesList = inputTransactionFileVariables.get("arrayNames");
        String[] arrayNamesArray = arrayNamesList.split(",");
        int namesEndCount = arrayNamesArray.length-1;
        HashMap<String, String> inputArrayNameValue = new HashMap<String, String>();
        for(int indexOfArray=startCount; indexOfArray<=namesEndCount; indexOfArray++ )
        {
            //logger.trace("");
            inputArrayNameValue.put(arrayNamesArray[indexOfArray] ,arrayValuesString.get(indexOfArray));
        }

        //converting each array values to integer and storing in integer array
        String arrayStringValues;
        String[] arrayStringValuesArray;
        HashMap<String, Object[]> arrayNameValueList = new HashMap<String, Object[]>();

        for(Map.Entry mapElement : inputArrayNameValue.entrySet())
        {
            arrayStringValues = (String) mapElement.getValue();
            arrayStringValuesArray = arrayStringValues.split(",");
            int loopEndCount = arrayStringValuesArray.length-1;
            String arrayName = (String)mapElement.getKey();
            ArrayList<Integer> arrList=new ArrayList<Integer>();
            for (int indexOfArray=startCount; indexOfArray <= loopEndCount; indexOfArray++)
            {
                arrList.add(Integer.parseInt(arrayStringValuesArray[indexOfArray]));

            }
            Object[] array = arrList.toArray();
            arrayNameValueList.put(arrayName, array);
        }

        //logger.log(arrayNameValueList.get("firstArray"));

        //The length is computed dynamically
        int[] arrayElementCount = new int[endCount];
        for (int indexOfArray = startCount; indexOfArray < arrayCount; indexOfArray++)
        {
            arrayElementCount[indexOfArray] = endCount;
            if (arrayElementCount[indexOfArray] != arrayCount-1)
                if (arrayElementCount[indexOfArray] != arrayElementCount[indexOfArray])
                {
                    //checking if the arrays are of same length otherwise exit
                    logger.error("The array lengths are different and hence exiting");
                    System.exit(-1);
                }

            //checking if the initial position of the arrays are within the array size
            if(startCount > arrayElementCount[indexOfArray])
            {
                logger.info("Array initial position ->[" + startCount + "] is greater than or equal the size of the array ->[" + arrayElementCount[indexOfArray]);
                System.exit(-300);
            }
            //checking if the end position of the arrays are within the array size
            if(endCount > arrayElementCount[indexOfArray])
            {
                logger.info("Array end position ->[" + endCount + "] is greater than or equal the size of the array ->[" + arrayElementCount[indexOfArray]);
                System.exit(-301);
            }
        }
        for (int indexOfArray = startCount; indexOfArray < arrayCount; indexOfArray++)
        {
            logger.info("ElementCount of Array " +(indexOfArray+1)+ " = [" + arrayElementCount[indexOfArray] + "]");
        }


        //this holds the transaction or operations of 4 arrays
        int ArrayProduct[] = new int[endCount];
        int ArraySum[] = new int[endCount];
        int ArrayDifference[] = new int[endCount];

        //Looping construct for finding the product of elements in the array
        //ASSUMPTION: both the arrays lengths should same
        for(int indexOfArray = startCount; indexOfArray < endCount; indexOfArray++ )
        {
            //initialising the product array
            /*ArrayProduct[indexOfArray] = startCount;
            ArraySum[indexOfArray] = startCount;
            ArrayDifference[indexOfArray] = startCount;*/

            int[] ElementOfArray = new int[arrayCount];
            for (int innerIndex = startCount; innerIndex < arrayCount; innerIndex++)
            {
                ElementOfArray[innerIndex] = (int)arrayNameValueList.get(arrayNamesArray[innerIndex])[indexOfArray];
                logger.info("Element value of array "+(innerIndex+1)+" in the position[" + indexOfArray + "] = " +ElementOfArray[innerIndex] );
            }
            int innerIndex2_EndCount = ElementOfArray.length;
            int productOfElements = 1;
            int sumOfElements = 0;
            int differenceOfElements = 0;
            for (int innerIndex2 = startCount; innerIndex2 < innerIndex2_EndCount; innerIndex2++)
            {
                productOfElements *= ElementOfArray[innerIndex2];
                sumOfElements += ElementOfArray[innerIndex2];
                differenceOfElements -= ElementOfArray[innerIndex2];
            }
            ArrayProduct[indexOfArray] = productOfElements;
            ArraySum[indexOfArray] = sumOfElements;
            ArrayDifference[indexOfArray] = differenceOfElements;

            logger.info("Product value at position [" + indexOfArray + "] = " + ArrayProduct[indexOfArray]);
            logger.info("Sum value at position [" + indexOfArray + "] = " + ArraySum[indexOfArray]);
            logger.info("Difference value at position [" + indexOfArray + "] = " + ArrayDifference[indexOfArray]);

        }
    }
}
