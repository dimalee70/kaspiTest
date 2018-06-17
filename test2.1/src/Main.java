import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    private static int[] arr = new int[100];
    private static String text = "";

    public static void main(String[] args) {
        String inputFileName = "src/txt/input.txt";
        String outputFileName = "src/txt/output.txt";
        int content = readFromFile(inputFileName);
        getSummands(content, content, 0);
        createAndWriteIntoFile(outputFileName,text);
//        System.out.println(text);
    }

    private static void getSummands(int n, int k, int i) {
        if ( n < 0 )
            return ;
        if ( n == 0 )
        {
            for (int j = 0; j < i; j++)
                text+=arr[j]+" ";
            text += "\n";
        }
        else
            {
            if ( n >= k)
            {
                arr[i] = k;
                getSummands(n - k, k, i + 1);
            }
            if ( k > 1)
                getSummands(n, k - 1, i);
        }
    }
    private  static void  createAndWriteIntoFile(String fileNme,String data)
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
    private static int readFromFile(String fileName)
    {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            int line0 = scanner.nextInt();
            return  line0;
        } catch (IOException e) {

            logger.log(Level.ERROR, e.getMessage());
        }
        return 0;
    }

}
