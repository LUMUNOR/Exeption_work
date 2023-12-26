package Consoler;

import java.util.Scanner;

public class Console{
    private Scanner scanner;
    private String info;

    public Console(){
        scanner = new  Scanner(System.in);
    }

    private void work(){
        System.out.println("Введите разделяя пробелом: Фамилию Имя Отчество датурождения номертелефона пол(f\\m)\n");
        this.info = scanner.nextLine();
    }

    public String getInfo(){
        work();
        return info;
    }
}