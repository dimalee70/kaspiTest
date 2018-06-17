import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
        String content = readUsingApacheCommonsIO(inputFileName);
        String sub;
        int i, c, length;
        length = content.length();
        int count = 0;
        TreeSet<Integer> counters = new TreeSet<>();

        for (int j = 0; j <= length/2 ; j++)
        {
            for (int k = j+1; k <= length/2 ; k++) {
//                System.out.println(content.substring(j,k));// 1 2
//                System.out.println(content.substring(k,k + (k-j)));// 2 3
                if (content.substring(j,k).equals(content.substring(k,k + (k-j))))
                {
                    count = content.substring(j,k).length();
                    counters.add(count);
//                    System.out.println(count);

                }
            }
        }
//        System.out.println(count);
        logger.log(Level.INFO,counters.last());
        createAndWriteIntoFile(outputFileName,counters.last());
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
}