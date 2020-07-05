package chapter_16.lesson;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SortMountains {
    LinkedList<Mountain> mnt = new LinkedList<Mountain>();

    class NameCompare implements Comparator<Mountain>{
        @Override
        public int compare(Mountain o1, Mountain o2) {
            return o1.mName.compareTo(o2.mName);
        }
    }
    class HeightCompare implements Comparator<Mountain>{
        @Override
//        public int compare(Mountain o1, Mountain o2) {
//            boolean res;
//            res = (o1.height == o2.height);
//            if (res){
//                return 1;
//            }else if(!res){
//                return 0;
//            }else {
//                return -1;
//            }
//        }
        public int compare(Mountain m1, Mountain m2){
            return (m2.height- m1.height);
        }
    }

    public static void main(String[] args) {
        new SortMountains().go();
    }
    public void go(){
        mnt.add(new Mountain("Лонг- Рейджинг", 14255));
        mnt.add(new Mountain("Эльюерт", 14433));
        mnt.add(new Mountain("Марун", 14155));
        mnt.add(new Mountain("Касл", 14265));

        System.out.println("В порядке добавления: \n" + mnt);
        NameCompare nc = new NameCompare();
        Collections.sort(mnt, nc);
        System.out.println("по названию \n" + mnt);
        HeightCompare hc = new HeightCompare();
        Collections.sort(mnt,hc);
        System.out.println("По высоте \n" + mnt);
    }
}
class Mountain{
    String mName;
    int height;

    public Mountain(String name, int height){
        this.mName =name;
        this.height = height;
    }

    @Override
    public String toString() {
        return (mName + " "  + height);
    }
}
