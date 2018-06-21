import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        String inputFileName = "src/txt/input.txt";
        String outputFileName = "src/txt/output.txt";

        int []content = readFromFile(inputFileName);
        for (int t: content
             ) {
            logger.log(Level.INFO,t);

        }
        createAndWriteIntoFile(outputFileName, getSummOfInt(content),getMultiply(content));
        logger.log(Level.INFO,getMultiply(content));

    }
    private static int [] readFromFile(String fileName)
    {
        int [] numbers;
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            int line0 = scanner.nextInt();
            numbers = new int[line0];
            int i = 0;
            while (scanner.hasNextInt())
            {
                numbers[i++] = scanner.nextInt();
            }
            return  numbers;
        } catch (IOException e) {

            logger.log(Level.ERROR, e.getMessage());
        }
        return null;
    }
        private  static void  createAndWriteIntoFile(String fileNme,int summ, int multiply)
        {
            try
            {
                String data = summ + " " + multiply;
                logger.log(Level.INFO,data);
                FileUtils.write(new File(fileNme),String.valueOf(data),StandardCharsets.UTF_8,false);
            }
            catch (Exception e)
            {
                logger.log(Level.ERROR,e.getMessage());
        }
    }
    private static int getSummOfInt(int [] numbers)
    {
        int sum = 0;
        for (int t: numbers
             ) {
            if(t >= 0)
                sum+=t;
        }
        return sum;
    }
    private  static  int getMinIndex(int [] numbers)
    {
        int minIndex = 0;
        for (int i = 0; i < numbers.length ; i++) {
            if(numbers[i] < numbers[minIndex])
                minIndex = i;
        }
        return minIndex;
    }
    private  static  int getMaxIndex(int [] numbers)
    {
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > numbers[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }
    private  static  int getMultiply(int [] numbers)
    {
        int multiply = 1;
        int max,min;
        if(getMinIndex(numbers) < getMaxIndex(numbers)){
            min = getMinIndex(numbers);
            max = getMaxIndex(numbers);
        }
        else
            {
                max = getMinIndex(numbers);
                min = getMaxIndex(numbers);
            }
        for (int i = min + 1; i < max; i++) {
            multiply*=numbers[i];
        }
        return multiply;
    }
}
