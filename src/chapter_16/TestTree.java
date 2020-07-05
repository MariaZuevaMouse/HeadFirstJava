package chapter_16;

import java.util.Comparator;
import java.util.TreeSet;

public class TestTree {
    public static void main(String[] args) {
        new TestTree().go();
    }

    public void go() {
        Book b1 = new Book("Как устроены кошки");
        Book b2 = new Book("Постройте заново свое тело");
        Book b3 = new Book("В поисках Эмо");

        TreeSet<Book> tree = new TreeSet<Book>();
//        BookCompare bookCompare = new BookCompare();
//        TreeSet<Book> treeSet = new TreeSet<Book>(bookCompare);
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        System.out.println(tree);
    }
//    public class BookCompare implements Comparator<Book>{
//        public int compare(Book one, Book two){
//            return (one.title.compareTo(two.title));
//        }
//    }
}
class Book implements Comparable{
    String title;
    public Book(String t){
        title = t;
    }
    public int compareTo(Object b){
        Book book = (Book) b;
        return (title.compareTo(book.title));
    }
}
