package Parser;

import Exeptions.DataExeption;
import Exeptions.GenderExeption;
import Exeptions.PhoneExeption;
import Exeptions.QuantityExeption;
import Exeptions.WordExeption;

//import java.util.ArrayList;

public class Parser {
    private String inInfo;
    private String[] info;
    private boolean flag;

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

    public String[] work(){
        this.flag = true;
        // Проверка количества данных
        try {
            this.info = splitInfo(inInfo);
        } catch (QuantityExeption e) {
            this.flag = false;
            System.out.println("Ошибка: " + e.getMessage());
        }
        // Проверка ФИО
        try {
            for (int i=0; i<3; i++){
                checkString(info[i]);
            }
        } catch (WordExeption e) {
            this.flag = false;
            System.out.println("Ошибка: " + e.getMessage());
        }
        // Проверка даты рождения
        try {
            checkData(info[3]);
        } catch (DataExeption e) {
            this.flag = false;
            System.out.println("Ошибка: " + e.getMessage());
        }
        // Проверка номера телефона
        try {
            checPhone(info[4]);
        } catch (PhoneExeption e) {
            this.flag = false;
            System.out.println("Ошибка: " + e.getMessage());
        }
        // Проверка пола
        try {
            checGender(info[5]);
        } catch (GenderExeption e) {
            this.flag = false;
            System.out.println("Ошибка: " + e.getMessage());    
        }

        if (this.flag) return info;
        else return null;

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
                System.out.println("NumberFormatExeption!");
                return false;
            }
        }
        if (!((data[0] > 0)&&(data[0] <= 2024 ))) return false;
        if (!((data[1] > 0)&&(data[1] <= 12 ))) return false;
        if (!((data[2] > 0)&&(data[2] <= 31 ))) return false;

        return true;
    }

    private boolean checPhone (String phone) throws PhoneExeption{
        char[] chars = phone.toCharArray();

        for (char c : chars) {
            if(!Character.isDigit(c)) {
                throw new PhoneExeption("Неверный формат номера телефона!");
            }
        }
        return true;       
    }

    private boolean checGender (String gender) throws GenderExeption{
        if (gender.equals("f")||(gender.equals("m"))){
            return true;
        }
        else throw new GenderExeption("Неверный формат пола!");
    }
}