package Parser;

import Exeptions.DataExeption;
import Exeptions.QuantityExeption;
import Exeptions.WordExeption;

//import java.util.ArrayList;

public class Parser {
    private String inInfo;
    private String[] info;
    private String surname,name,patronymic;
    private String birthday;
    private Long number;
    private char gender;

    public Parser(String inputInfo){
        this.inInfo = inputInfo;
    }

    private String[] splitInfo(String input) throws QuantityExeption{
        String[] split = input.split(" ");
        if (split.length < 6){
            throw new QuantityExeption("Вы ввели недостаточно данных!");
        }
        if (split.length > 6){
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
            for (int i=0; i<3; i++){
                if (checkString(info[i])){
                    switch (i) {
                        case 0:
                            this.surname = info[i];
                            break;
                        case 1:
                            this.name = info[i];
                            break;
                        case 2:
                            this.patronymic = info[i];
                            break;
                    }
                }
            }
        } catch (WordExeption e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            checkData(info[3]);
            birthday = info[3];
            System.out.println(birthday);
        } catch (DataExeption e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }

    private boolean checkString(String string) throws WordExeption{
        char[] chars = string.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                throw new WordExeption("Неверный формат строки ФИО!");
            }
        }
        return true;
    }

    private boolean checkData(String string) throws DataExeption{
        String[] split = string.split("\\.");
        if ((split.length == 3)&&(checkNumber(split))){
             return true;
        } else throw new DataExeption("Неверный формат даты рождения!");
    }

    private boolean checkNumber(String[] numbers){
        int[] data = new int[numbers.length];
        for (int i=0; i<numbers.length; i++){
            try {
                data[i] = Integer.parseInt(numbers[i]);
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatExeption");
                return false;
            }
        }
        if (!((data[0] > 0)&&(data[0] <= 2024 ))){
            System.out.println("1");
            return false;
        }
        if (!((data[1] > 0)&&(data[1] <= 12 ))){
            System.out.println("2");
            return false;
        }
        if (!((data[2] > 0)&&(data[2] <= 31 )))return false;

        return true;
    }
}