package chapter_14;

import java.io.*;

public class FileFF {
    public static void main(String[] args) {
        File f = new File("MyCode.txt");

        //создать каталог

        File dir = new File("chapter_00");
        dir.mkdir();

        //вывести содержимое каталога
        if(dir.isDirectory()){
            String[] dirContent = dir.list();
            for(int i = 0; i< dirContent.length; i++){
                System.out.println(dirContent[i]);
            }
        }
        //получить абсолютный путь файла или каталога
        System.out.println(dir.getAbsolutePath());

        // удалить файл или каталог (возвращает булевое значение)
        boolean isDeleted = f.delete();
    }

}
