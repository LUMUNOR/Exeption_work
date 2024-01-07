package Filewriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
/**
 * Класс осуществляющий запись проверенных данных в файл с именем Фамилии. Принимает массив строк.
 * Однофамильцы записываются в один файл.
 */
public class Filewriter {

    private HashSet<String> surnames; // множество с фамилиями

    public Filewriter(){
        this.surnames = new HashSet<>();
    }

    public void work(String[] info){
        if (surnames.add(info[0])){
            newFile(info);
        }
        else{
            addFile(info);
        }
    }

    private void newFile (String[] info){
        
        try( FileWriter writer = new FileWriter(info[0]+".txt"))
        {
           writer.write(formaString(info));
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
    }

    private void addFile (String[] info){
        
        try( FileWriter writer = new FileWriter(info[0]+".txt",true))
        {
           writer.append('\n');
           writer.write(formaString(info));
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
    }
    
    private String formaString (String[] info){
        StringBuilder sb = new StringBuilder();
        for (String str : info){
            sb.append("<");
            sb.append(str);
            sb.append(">");
        }
        return sb.toString();

    }
}