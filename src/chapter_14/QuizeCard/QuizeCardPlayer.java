package chapter_14.QuizeCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class QuizeCardPlayer {
    private JTextArea display;
    private JTextArea answer;
    private ArrayList<QuizeCard> cardList;
    private QuizeCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private  JButton nextButton;
    private boolean isShowAnswer;

    public static void main(String[] args) {
        QuizeCardPlayer reader = new QuizeCardPlayer();
        reader.go();
    }

    public void go(){
        //сформулируем и выведем на эеран GUI

        frame = new JFrame("Quiz Card Player");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        display = new JTextArea(10,20);
        display.setFont(bigFont);

        display.setLineWrap(true);
        display.setEditable(false);

        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        nextButton = new JButton("Show Question");
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(640,500);
        frame.setVisible(true);


    }
    class NextCardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(isShowAnswer){
                //показываем ответ, так как вопрос уже был увиден
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next card");
                isShowAnswer = false;
            } else{
                //показываем следующий вопрос
                if(currentCardIndex < cardList.size()){
                    showNextCard();
                } else{
                    //больше карточек нет!
                    display.setText("That was a last card");
                    nextButton.setEnabled(false);
                }
            }
        }
    }
    class OpenMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev){
            // вызываем диалоговое окно, позволяющее пользователю выбирать
            //какой набор карточек открыть
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    }
    private void loadFile(File file){
        //нужно содать ArrayList с карточками, считывая их из текстового файла,
        //вызванного из обработчика событий класса OpenMenuListener,
        // прочитать файл по одной строке за один раз
        //и вызвать метод makeCrd() для создания новой карточки из строки
        //(одна строка в файле содержит вопрос и ответ, разделенные символом / )
        cardList = new ArrayList<QuizeCard>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                makeCard(line);
            }
            bufferedReader.close();
        }catch (Exception ex){
            System.out.println("could't read the card file");
            ex.printStackTrace();
        }
        //пришло время показать первую карточку
        showNextCard();
    }
    private void makeCard(String lineToPars){
        //вызывается методом LoadFile,  берет строку из текстового файла,
        //делит её на две части - вопрос и ответ - и создает новы объект QuizeCard
        // а затем добавляет его в ArrayList с помощью cardList
        String[] result =lineToPars.split("/");
        QuizeCard card = new QuizeCard(result[0],result[1]);
        cardList.add(card);
        System.out.println("made a card");
    }
    private void showNextCard(){
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show answer");
        isShowAnswer = true;

    }
}
