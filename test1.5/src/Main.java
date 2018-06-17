import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main
{
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        String inputFileName = "src/txt/input.txt";
        String outputFileName = "src/txt/output.txt";
        int [] numbers = readFromFile(inputFileName);
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]);
//        }
//        System.out.println(getIdx(numbers,96));
//        System.out.println("summ "+getCash(numbers));
        createAndWriteIntoFile(outputFileName,getCash(numbers));

    }
    private static int getIdx(int [] arr, int temp)
    {
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == temp)
                return i;
        }
        return 0;
    }

    private static  int getCash(int [] numbers)
    {
        int sale = 0, idx = 0, summ = 0, days = 1;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) {
            linkedList.add(numbers[i]);
        }
        Collections.sort(linkedList);
//        for (int t: linkedList
//             ) {
//            System.out.println(t);
//        }

        int diff = 0;

        while (idx < numbers.length-1){
            int temp = getIdx(numbers,linkedList.getLast());

//            System.out.println("temp "+temp);
            if (temp >= idx) {
                diff = (days+=temp) - diff;
//                System.out.println("days " + days);
//                System.out.println("diff " + diff );
//                System.out.println("into");
                idx = temp;
                summ += linkedList.getLast() * diff;
//                System.out.println("summ "+summ);
//                System.out.println("loc" + diff);
                days = 1;


            }
            linkedList.removeLast();
//            System.out.println("ind"+idx);
        }
        return summ;
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
