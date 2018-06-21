import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//Стрелы – это подстроки вида ‘>>-->’ и ‘<--<<’.
//<<<< >>--> <--<< --<<> >>--> <<<<< = 3(в вашем примере равен 4)
public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        String inputFileName = "src/txt/input.txt";
        String outputFileName = "src/txt/output.txt";
        String content = readUsingApacheCommonsIO(inputFileName);

        int count = 0;

        for (int i = 0; i < content.length()-4;i++)
        {
            if ((content.charAt(i) == '<' && content.charAt(i+1) == '-'
                    &&content.charAt(i+2) == '-' &&
                    content.charAt(i+3) == '<' &&
                    content.charAt(i) == '<') ||
                    (content.charAt(i) == '>' && content.charAt(i+1) == '>'
                    &&content.charAt(i+2) == '-' &&
                    content.charAt(i+3) == '-' &&
                    content.charAt(i) == '>'))
            {
                count++;
            }
        }
        logger.log(Level.INFO,"To write in the file "+count);
        createAndWriteIntoFile(outputFileName,count);
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
