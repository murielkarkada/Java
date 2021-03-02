import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LinearArrayMultiplication_L4
{
    public static final Logger logger = LogManager.getLogger(LinearArrayMultiplication_L4.class);

    public static void main(String args[]) throws IOException {
        BasicConfigurator.configure();
        HashMap<Integer, String> arrayNames = new HashMap<Integer, String>();
        //storing program arguments in variable
        String programArgument_1 = args[0];
        String programArgument_2 = args[1];


        File argumentInputFile1  = new File( programArgument_1 );
        File argumentInputFile2  = new File( programArgument_2 );
        File formattedInputFile1 = new File( "/home/user1/formattedsystem.dat" );
        File formattedInputFile2 = new File( "/home/user1/formattedtransaction.dat" );

        //check if system.dat file exists or not
        if (!argumentInputFile1.exists()) {
            logger.error( argumentInputFile1 + "file does not exist" );
            System.exit( -3 );
        }

        //checking for permissions
        //Checking the Read permission
        if (!argumentInputFile1.canRead()) {
            logger.error( argumentInputFile1 + " FILE PERMISSION ERROR : Cannot Read!!!" );
            System.exit( -402 );
        }

        //Checking the Write permission
        if (!argumentInputFile1.canWrite()) {
            logger.error( argumentInputFile1 + " FILE PERMISSION ERROR : Cannot Write!!!" );
            System.exit( -401 );
        }

        //Checking the Execute permission
        if (!argumentInputFile1.canExecute()) {
            logger.error( argumentInputFile1 + " FILE PERMISSION ERROR : Cannot Execute!!!" );
            System.exit( -403 );
        }

        //Checking if the file is empty
        if (argumentInputFile1.length() == 0) {
            logger.error( argumentInputFile1 + " File is empty" );
            System.exit( -404 );

        }


        //check if transaction.dat file exists or not
        if (!argumentInputFile2.exists()) {
            logger.error( argumentInputFile2 + "file does not exist" );
            System.exit( -32 );
        }

        //checking for permissions
        //Checking the Read permission
        if (!argumentInputFile2.canRead()) {
            logger.error( argumentInputFile2 + " FILE PERMISSION ERROR : Cannot Read!!!" );
            System.exit( -422 );
        }

        //Checking the Write permission
        if (!argumentInputFile2.canWrite()) {
            logger.error( argumentInputFile2 + " FILE PERMISSION ERROR : Cannot Write!!!" );
            System.exit( -421 );
        }

        //Checking the Execute permission
        if (!argumentInputFile2.canExecute()) {
            logger.error( argumentInputFile2 + " FILE PERMISSION ERROR : Cannot Execute!!!" );
            System.exit( -423 );
        }

        //Checking if the file is empty
        if (argumentInputFile2.length() == 0) {
            logger.error( argumentInputFile2 + " File is empty" );
            System.exit( -424 );

        }

        //deleting leading and trailing white spaces from system.dat file
        FileReader fileReader = new FileReader( argumentInputFile1 );
        BufferedReader bufferedReader = new BufferedReader( fileReader );
        FileWriter fileWriter = new FileWriter( formattedInputFile1 );
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            line = line.trim();
            //deleting extra whitespaces and the spaces before and after ":"
            line = line.replaceAll( "\\s+", " " ).replaceAll( "\\s+:", ":" ).replaceAll( ":+\\s", ":" ) + "\n";

            fileWriter.write( line );
        }
        fileReader.close();
        fileWriter.close();

        //deleting leading and trailing white spaces from transaction.dat file
        FileReader fileReader2 = new FileReader( argumentInputFile2 );
        BufferedReader bufferedReader2 = new BufferedReader( fileReader2 );
        FileWriter fileWriter2 = new FileWriter( formattedInputFile2 );
        String line2;
        while ((line2 = bufferedReader2.readLine()) != null)
        {
            line2 = line2.trim();
            //deleting extra whitespaces and the spaces before and after ":"
            line2 = line2.replaceAll( "\\s+", " " ).replaceAll( "\\s+:", ":" ).replaceAll( ":+\\s", ":" ) + "\n";

            fileWriter2.write( line2 );
        }
        fileReader2.close();
        fileWriter2.close();

        //taking variables from the file
        Scanner inputFile = new Scanner( formattedInputFile1 );
        String[] currentFileVariable = new String[2];
        ArrayList <String> arrayValuesString = new ArrayList <String>();
        HashMap <String, String> inputFileVariables = new HashMap <String, String>();
        while (inputFile.hasNextLine())
        {
            currentFileVariable = inputFile.nextLine().split( ":" );
            inputFileVariables.put( currentFileVariable[0], currentFileVariable[1] );

            //storing array values separately
            if (currentFileVariable[0].startsWith( "ELEMENTS" ))
            {
                arrayValuesString.add( currentFileVariable[1] );
            }
        }


        //checking whether minimum and arrayCount is specified
        String minArrayCountString = inputFileVariables.get( "minArrayCount" );
        if (minArrayCountString == null) {
            logger.error( "Minimum array count is not specified" );
            System.exit( -404 );
        }
        //checking whether maximum arrayCount is specified
        String maxArrayCountString = inputFileVariables.get( "maxArrayCount" );
        if (maxArrayCountString == null) {
            logger.error( "Maximum array count is not specified" );
            System.exit( -404 );
        }

        //checking whether arrayCount is specified
        String arrayCountString = inputFileVariables.get( "arrayCount" );
        if (arrayCountString == null) {
            logger.error( "Array count is not specified" );
            System.exit( -404 );
        }


        //checking whether array count is within the min and max array count
        int minArrayCount = Integer.parseInt( minArrayCountString );
        int maxArrayCount = Integer.parseInt( maxArrayCountString );
        int arrayCount = Integer.parseInt( arrayCountString );
        if (arrayCount < minArrayCount) {
            logger.error( "Minimum " + minArrayCount + " arrays required" );
            System.exit( -404 );
        }
        if (arrayCount > maxArrayCount) {
            logger.error( "Maximum " + maxArrayCount + " arrays can only be specified" );
            System.exit( -404 );
        }


        //checking for array names
        String arrayNamesString = inputFileVariables.get( "arrayNames" );
        if (arrayNamesString == null) {
            logger.error( "Array names are not specified" );
            System.exit( -404 );
        }


        //check check whether start and end position of array are specified
        String startCountString = inputFileVariables.get( "startCount" );
        if (startCountString == null) {
            logger.error( "Arrays start count is not specified" );
            System.exit( -404 );
        }

        //check check whether start and end position of array are specified
        String endCountString = inputFileVariables.get( "endCount" );
        if (endCountString == null) {
            logger.error( "Arrays end count is not specified" );
            System.exit( -404 );
        }

        //this is the start and end position of the array
        int startCount = Integer.parseInt( inputFileVariables.get( "startCount" ) );
        int endCount = Integer.parseInt( inputFileVariables.get( "endCount" ) );

        //converting string values of array to integer
        String arrayNamesList = inputFileVariables.get( "arrayNames" );
        String[] arrayNamesArray = arrayNamesList.split( "," );
        int namesEndCount = arrayNamesArray.length - 1;
        HashMap <String, String> inputArrayNameValue = new HashMap <String, String>();
        for (int indexOfArray = startCount; indexOfArray <= namesEndCount; indexOfArray++) {
            inputArrayNameValue.put( arrayNamesArray[indexOfArray], arrayValuesString.get( indexOfArray ) );
        }

        //converting each array values to integer and storing in integer array
        String arrayStringValues;

        String[] arrayStringValuesArray;
        HashMap <String, ArrayList <Integer>> finalArrayValueList = new HashMap <String, ArrayList <Integer>>();

        for (Map.Entry mapElement : inputArrayNameValue.entrySet()) {

            arrayStringValues = (String) mapElement.getValue();
            arrayStringValuesArray = arrayStringValues.split( "," );
            int loopEndCount = arrayStringValuesArray.length - 1;
            String arrayName = (String) mapElement.getKey();
            logger.info( arrayName );

            //Getting array names

            for(int loopindex = startCount; loopindex <maxArrayCount; loopindex++)
            {
                arrayNames.put( loopindex,arrayName );
            }

            ArrayList <Integer> arr = new ArrayList <Integer>();
            for (int indexOfArray = startCount; indexOfArray <= loopEndCount; indexOfArray++) {
                arr.add( Integer.parseInt( arrayStringValuesArray[indexOfArray] ) );
            }
            finalArrayValueList.put( arrayName, arr );
        }

//        //calculating the size of each array
//        logger.info( arrayNames );
//        int[] ArrayElementCount = new int[];
//        int[] array = new int[];
//        for (int loopindex = startCount; loopindex < arrayNames.size(); loopindex++)
//        {
//            ArrayList <Integer> array = finalArrayValueList.get( arrayNames.get(loopindex) );
//             ArrayElementCount[loopindex] = array[loopindex].size();
//            logger.info( "Size of Array " + loopindex+1 + "= [" + ArrayElementCount[loopindex] + "]" );
//        }

        ArrayList <Integer> array1 = finalArrayValueList.get( "firstArray" );
        int ArrayElementCount_1 = array1.size();

        ArrayList <Integer> array2 = finalArrayValueList.get( "secondArray" );
        int ArrayElementCount_2 = array2.size();

        logger.info( "ElementCount Array 1 = [" + ArrayElementCount_1 + "]" );
        logger.info( "ElementCount Array 2 = [" + ArrayElementCount_2 + "]" );

        //taking operation to be performed from the file
        Scanner transactionFile = new Scanner( formattedInputFile2 );
        String[] currentoperation = new String[2];

        currentoperation = transactionFile.nextLine().split( ":" );
        String arrayOperation = currentoperation[1];


        //initializing the initial value

        logger.info( "Initialisation START..." );


        logger.info( "Initial Position of Array = [" + startCount + "]" );
        logger.info( "End Position of Array = [" + endCount + "]" );
        logger.info( "Operation to be performed =[" + arrayOperation + "]" );

        logger.info( "Initialisation END....." );

        //checking if the arrays are of same length otherwise exit
        //checking if the initial position of the arrays are within the array size
        //checking if the end position of the arrays are within the array size

        switch (arrayOperation) {
            case "addition":
                ArrayList <Integer> SumOfArrays = new ArrayList <Integer>();
                for (int sumloop = 0; sumloop < ArrayElementCount_1; sumloop++) {
                    SumOfArrays.add( array1.get( sumloop ) + array2.get( sumloop ) );
                }
                logger.info( "Sum of Arrays =" + SumOfArrays );
                break;

            case "subtraction":
                ArrayList <Integer> DifferenceOfArrays = new ArrayList <Integer>();
                for (int differenceloop = 0; differenceloop < ArrayElementCount_1; differenceloop++) {
                    DifferenceOfArrays.add( array1.get( differenceloop ) - array2.get( differenceloop ) );
                }
                logger.info( "Difference of Arrays =" + DifferenceOfArrays );
                break;

            case "multiplication":
                ArrayList <Integer> ProductOfArrays = new ArrayList <Integer>();
                for (int productloop = 0; productloop < ArrayElementCount_1; productloop++)
                {
                    ProductOfArrays.add( array1.get( productloop ) * array2.get( productloop ) );
                }
                    logger.info( "Product of Arrays =" + ProductOfArrays  );
                    break;
                    default:
                        logger.info( "Invalid operation" );
                }

        }
    }

