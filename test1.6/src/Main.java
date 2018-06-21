import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Main{
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        String inputFileName = "src/txt/input.txt";
        String outputFileName = "src/txt/output.txt";
        int t = readFromFile(inputFileName);
        int output = 0;
        for (int i = 0; ; i++)
        {
            if (isTwice(t - i))
            {
                output = t-i;
                break;
            }
            if (isTwice (t+i))
            {
                output = t+i;
                break;
            }
        }
        createAndWriteIntoFile(outputFileName,output);

    }
    public static boolean isTwice(int t)
    {
        boolean returnBool;
        boolean isNumber [] = new boolean[10];
        while (t > 0) {
            isNumber[t % 10] = true;
            t /= 10;
        }
        int count = 0;
        for (int i = 0; i <= 9; i++) {
            if (isNumber[i])
                count++;
        }
        returnBool = count <= 2;
        return returnBool;
    }
    private  static void  createAndWriteIntoFile(String fileNme,int data)
    {
        try
        {
            logger.log(Level.INFO,data);
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
