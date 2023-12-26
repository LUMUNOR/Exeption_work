 import Consoler.Console;
import Exeptions.QuantityExeption;
import Parser.Parser;
 
 public class Main {
    public static void main (String[] args) {
        Console console = new Console();
        String info = console.getInfo();
        Parser parser = new Parser(info);
        
        try {
            parser.work();
        } catch (QuantityExeption e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}