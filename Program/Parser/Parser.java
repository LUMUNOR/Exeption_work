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

    public boolean checkData(String string) throws DataExeption{
        String[] split = string.split(".");
        if (split.length != 3){
            throw new DataExeption("Неверный формат даты рождения!");
        }
    }
}