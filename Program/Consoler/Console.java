package Consoler;

import java.util.Scanner;

public class Console{
    private Scanner scanner;
    private String info;

    public Console(){
        scanner = new  Scanner(System.in);
    }

    public String getInfo(){
        System.out.println("--------------------------");
        System.out.println("Для остановки программы введите ПРОБЕЛ");
        System.out.println("Введите разделяя пробелом: Фамилию Имя Отчество датурождения номертелефона пол(f\\m)\n");
        this.info = scanner.nextLine();
        return info;
    }
}