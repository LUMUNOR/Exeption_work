package Parser;

import Exeptions.QuantityExeption;
import Exeptions.WordExeption;

//import java.util.ArrayList;

public class Parser {
    private String inInfo;
    private String[] info;

    public Parser(String inputInfo){
        this.inInfo = inputInfo;
    }

    public String[] splitInfo(String input) throws QuantityExeption{
        String[] split = input.split(" ");
        if (split.length < 5){
            throw new QuantityExeption("Вы ввели недостаточно данных!");
        }
        if (split.length > 5){
            throw new QuantityExeption("Вы ввели избыточное количество данных!");
        }
        return split;
    }

    public void work(){
        
        try {
            this.info = splitInfo(inInfo);
        } catch (QuantityExeption e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            if (checkString(info[0])) System.out.println("yes");
        } catch (WordExeption e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        //String surname = info[0];
        //String name = info[1];
        //String patronymic = info[2];

    }

    public boolean checkString(String string) throws WordExeption{
        char[] chars = string.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                throw new WordExeption("Неверный формат строки ФИО!");
            }
        }
        return true;
    }

}