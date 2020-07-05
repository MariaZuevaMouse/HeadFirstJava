package chapter_14.QuizeCard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class QuizeCardPlayer_Structure {
    public void go(){
        //сформулируем и выведем на эеран GUI
    }
    class NextCardListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    class OpenMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev){
            // вызываем диалоговое окно, позволяющее пользователю выбирать
            //какой набор карточек открыть
        }
    }
    private void loadFile(File file){
        //нужно содать ArrayList с карточками, считывая их из текстового файла,
        //вызванного из обработчика событий класса OpenMenuListener,
        // прочитать файл по одной строке за один раз
        //и вызвать метод makeCrd() для создания новой карточки из строки
        //(одна строка в файле содержит вопрос и ответ, разделенные символом / )

    }
    private void makeCard(String lineToPars){
        //вызывается методом LoadFile,  берет строку из текстового файла,
        //делит её на две части - вопрос и ответ - и создает новы объект QuizeCard
        // а затем добавляет его в ArrayList с помощью cardList
    }
}
