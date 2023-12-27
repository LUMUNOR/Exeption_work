 import Consoler.Console;
import Parser.Parser;
 
 public class Main {
    public static void main (String[] args) {
        Console console = new Console();
        String info = console.getInfo();
        Parser parser = new Parser(info);
        parser.work();
    }
}