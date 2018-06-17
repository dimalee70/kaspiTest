
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        String inputFileName = "src/txt/input.txt";
        String outputFileName = "src/txt/output.txt";
        String content = readUsingApacheCommonsIO(inputFileName);
        logger.log(Level.INFO,"from file " +content);
        String replaceSpace = content.replaceAll("[^0-9]+|1+", " ");
        logger.log(Level.INFO,"without 1s "+replaceSpace);
        String[] parts = replaceSpace.split(" ");
        int outputInFile = getTheLargerNumber(parts);
        logger.log(Level.INFO,"To write in the file "+outputInFile);
        createAndWriteIntoFile(outputFileName,outputInFile);


    }
    private static String readUsingApacheCommonsIO(String fileName) {
        try {
            //использовал библиотеку для считывания файла org.apache.commons.io
            return FileUtils.readFileToString(new File(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {

            logger.log(Level.ERROR,e.getMessage());
            return null;
        }
    }
    private  static void  createAndWriteIntoFile(String fileNme,int data)
    {
        try
        {
//            File file = ;
//            FileUtils.touch(file);
            FileUtils.write(new File(fileNme),String.valueOf(data),StandardCharsets.UTF_8,false);
        }
        catch (Exception e)
        {
            logger.log(Level.ERROR,e.getMessage());
        }
    }
    private  static  int getTheLargerNumber(String [] arr)
    {
        int max = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i].length() > max)
            {
                max = arr[i].length();
            }
        }
        return max;
    }
}
