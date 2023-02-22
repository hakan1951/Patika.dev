import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookSorterApp {
    public static void main(String[] args) {
        //Set 1.
        TreeSet<Book> booksByName = new TreeSet<>(Book::compareTo);
        //Inputs.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        booksByName.add(new Book("Shaggy Blackfoot",	260,	"Mordecai Schermick",	LocalDate.parse("16/09/2022",formatter)));
        booksByName.add(new Book("Saltmarsh Bird's-beak",	320,	"Jerrie Devany",	LocalDate.parse("11/08/2022",formatter)));
        booksByName.add(new Book("Incised Fumewort",	338,	"Shalna Blazek",	LocalDate.parse("20/10/2022",formatter)));
        booksByName.add(new Book("Keyflower",	338,	"Osmund Izzatt",	LocalDate.parse("28/10/2022",formatter)));
        booksByName.add(new Book("Arnold Hawthorn",	201,	"Stirling Blesing",	LocalDate.parse("02/07/2022",formatter)));

        //Set 2.
        TreeSet<Book> booksByPageNumber = new TreeSet<>(Book::compareToByPageNumber);
        booksByPageNumber.addAll(booksByName);

        //Outputs.
        printSortedByName(booksByName);

        printSortedByPageNumber(booksByPageNumber);

    }
    static void printSortedByName(Set<Book> books){
        Collections.sort(new ArrayList<>(books));
        Iterator<Book> iterator = books.iterator();
        System.out.println("-----Sorted By Name(Ascending)-----");
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
    static void printSortedByPageNumber(Set<Book> books){
        Collections.sort(new ArrayList<>(books));
        Iterator<Book> iterator = books.iterator();
        System.out.println("-----Sorted By Page Number(Descending)-----");
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
}

class Book implements Comparable<Book>{
    private final String name;
    private final int pageNumber;
    private final String authorName;
    private final LocalDate publishDate;

    public Book(String name, int pageNumber, String authorName, LocalDate publishDate) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    //Name comparison.
    @Override
    public int compareTo(Book o) {
        return this.name.compareTo(o.name);
    }

    //Page Number comparison.
    public int compareToByPageNumber(Book o){
        if (this.pageNumber == o.pageNumber){
            return this.name.equals(o.name) ? 1 : -1;
        }else {
            return this.pageNumber > o.pageNumber ? -1 : 1;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "name: '" + name + '\'' +
                ", pageNumber:" + pageNumber +
                ", authorName: '" + authorName + '\'' +
                ", publishDate: " + publishDate +
                '}';
    }

}

