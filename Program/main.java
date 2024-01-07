 import Consoler.Console;
import Filewriter.Filewriter;
import Parser.Parser;
 
 public class Main {
    public static void main (String[] args) {
        Console console = new Console();
        Parser parser = new Parser();
        Filewriter writer = new Filewriter();
        String inInfo = null;
        while (true) {
            inInfo = console.getInfo();
            if (inInfo.equals(" ")) break;
            if (parser.work(inInfo)==null) continue;
            else writer.work(parser.work(inInfo));
        }
        
    }
}