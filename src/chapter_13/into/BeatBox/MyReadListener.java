package chapter_13.into.BeatBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

//public class MyReadListener implements ActionListener {
//    public void actionPerformed(ActionEvent ev){
//        boolean[] checkboxState = null;
//        try{
//            FileInputStream fileIn = new FileInputStream(new File("Checkbox.ser"));
//            ObjectInputStream is = new ObjectInputStream(fileIn);
//            checkboxState = (boolean[]) is.readObject();
//
//        }catch(Exception ex){ex.printStackTrace();}
//
//        for (int i = 0; i<256; i++){
//            JCheckBox check = (JCheckBox) checkboxList.get(i);
//            if(checkboxState[i]){
//                check.setSelected(true);
//            }else{
//                check.setSelected(false);
//            }
//        }
//    }
//}
