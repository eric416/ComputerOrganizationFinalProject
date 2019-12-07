import Stage.InstructionFetch;

import java.io.*;
import java.util.ArrayList;

public class Main
{
    public static void main (String[] args)
    {
        ArrayList<String> bufferedData = new ArrayList<>();
        try
        {
            bufferedData = ReadFile();
        } catch (IOException e) {
            System.out.println("Loading error, can't find the path of file.");
            return;
        }

        InstructionFetch IF = new InstructionFetch(bufferedData);

        for(int i = 0;i < bufferedData.size();i++)
        {
            System.out.println(Debug_toBinary_32bit(IF.Fetch(i)));
        }
    }

    public static ArrayList<String> ReadFile() throws IOException
    {
        File file = new File("res/input.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        ArrayList<String> strList = new ArrayList<>();

        for(String str = in.readLine(); str != null; str = in.readLine())
        {
            strList.add(str);
        }

        return strList;
    }
    public static String Debug_toBinary_32bit(int input)
    {
        StringBuilder str = new StringBuilder();
        boolean isNegative = false;
        if(input < 0)
        {
            isNegative = true;
            input = input & (2147483647);
        }
        for(int i = 0;i < 32;i++)
        {
            if(input % 2 == 1)str.append(1);
            else str.append(0);
            input /= 2;
        }
        str.reverse();
        String result;
        if(isNegative)
        {
            str.setCharAt(0, '1');
        }
        result = str.toString();
        return result;
    }
}
