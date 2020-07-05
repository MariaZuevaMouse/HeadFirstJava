package chapter_13.into.BeatBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

//public class MySendListener implements ActionListener {
//    public void actionPerformed(ActionEvent ev){
//        boolean[] checkboxState = new boolean[256];
//
//        for (int i = 0; i<256; i++){
//            JCheckBox check = (JCheckBox) checkboxList.get(i);
//            if(check.isSelected()){
//                checkboxState[i] = true;
//            }
//        }
//        try{
//            FileOutputStream fileSream = new FileOutputStream(new File("Checkbox.ser"));
//            ObjectOutputStream os =new ObjectOutputStream(fileSream);
//            os.writeObject(checkboxState);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//}
