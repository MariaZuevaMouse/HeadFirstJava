package chapter_14.QuizeCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class QuizeCardBuilder {

    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizeCard> cardList;
    private  JFrame frame;

    public static void main(String[] args) {
        QuizeCardBuilder builder = new QuizeCardBuilder();
        builder.go();
    }

    public void go(){
        //формируем и выводим на экран GUI
        frame = new JFrame("Quize Card Builder");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        question = new JTextArea(6,20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);

        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        answer = new JTextArea(6,20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);

        JScrollPane aScrollPane = new JScrollPane(answer);
        aScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextButton = new JButton("Next card");

        cardList = new ArrayList<QuizeCard>();

        JLabel qLable = new JLabel("Question: ");
        JLabel aLable = new JLabel("Answer: ");

        mainPanel.add(qLable);
        mainPanel.add(qScroller);
        mainPanel.add(aLable);
        mainPanel.add(aScrollPane);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("new");

        JMenuItem saveMenuItem = new JMenuItem("save");
        newMenuItem.addActionListener(new NewMenuListener());

        saveMenuItem.addActionListener(new SaveMenuListener());
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500,600);
        frame.setVisible(true);

    }
    private class NextCardListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //добавляем текущую карточку
            QuizeCard card = new QuizeCard(question.getText(), answer.getText());
            cardList.add(card);
            clearCard();
        }
    }
    private class SaveMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //вызываем диалоговое окно
            //позволяющее пользователю называть и сохранять набор

            QuizeCard card = new QuizeCard(question.getText(), answer.getText());
            cardList.add(card);

            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }
    }



    private class NewMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //очищаем список карточек  и текстовые области
            cardList.clear();
            clearCard();
        }
    }

    private void clearCard(){
        question.setText(" ");
        answer.setText(" ");
        question.requestFocus();
    }
    private void saveFile(File file){
        //проходим по списку карточек и записываем
        //каждый эл-нт в текстовый файл, который потом
        //можно будет прочитать
          //(т.е. с чистыми разделителями между частями
        try{
            BufferedWriter writter = new BufferedWriter(new FileWriter(file));

            for (QuizeCard card: cardList){
                writter.write(card.getQuestion() + "/");
                writter.write(card.getAnswer() + "\n ");
            }
            writter.close();

        }catch (IOException ex){
            System.out.println("could't write the cardList out");
            ex.printStackTrace();
        }
    }
}
