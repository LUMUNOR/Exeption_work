package Parser;

import Exeptions.QuantityExeption;

//import java.util.ArrayList;

public class Parser {
    private String inInfo;
    private String[] info;

    public Parser(String info){
        this.inInfo = info;
    }

    public String[] splitInfo(String input) throws QuantityExeption{
        String[] split = input.split(" ");
        if (info.length < 5){
            throw new QuantityExeption("Вы ввели недостаточно данных!");
        }
        if (info.length > 5){
            throw new QuantityExeption("Вы ввели избыточное количество данных!");
        }
        return split;
    }

    public void work() throws QuantityExeption{
        this.info = splitInfo(inInfo);
        String surname = info[0];
        String name = info[1];
        String patronymic = info[2];

    }

    public boolean checkString(String string){
        char[] chars = string.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}