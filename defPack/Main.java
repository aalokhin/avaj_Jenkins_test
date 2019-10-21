package defPack;
import java.io.*;
import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by aalokhin on 2/2/19.
 */
public class Main {
    public static void main(String[] args)
            throws IOException
    {

        if(args.length < 1)
        {
            System.out.println("=))))) Error, usage: java ClassName inputfile");
            System.exit(1);
            return ;
        }

        String input = args[0];
        File inputFile = new File(input);
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(input), StandardCharsets.UTF_8))
        {
            Parser parser = new Parser(reader);
            Launcher scenario = new Launcher(parser.getFlyables(), parser.getFactory(), parser.getTower(), parser.getChanges());
            scenario.launchScenario();
            if (reader != null) {
                reader.close();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                FileWriter fileWriter = new FileWriter("simulation.txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.print(Result.resultBuilder.toString());
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("The simulation has been finished. See the output in \"simulation.txt\"\n" + Result.resultBuilder.toString());
        }


    }
}
