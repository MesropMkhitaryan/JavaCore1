package homework.books;

import homework.students.Student;
import homework.students.StudentStorage;

import java.util.Scanner;

public class BookDemo {
    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();
    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("input 0 for exit");
            System.out.println("input 1 to add book");
            System.out.println("input 2 to print all books");
            System.out.println("input 3 to print books by author name");
            System.out.println("input 4 to print books by genre");
            System.out.println("input 5 to print books by price range");
            int command = Integer.parseInt(scanner.nextLine());
            switch (command){
                case 0:
                    run = false;
                    break;
                case 1:
                    addBook();
                    break;
                case 2:
                    bookStorage.printArray();
                    break;
                case 3:
                    System.out.println("please input author name");
                    String authorName = scanner.nextLine();
                    bookStorage.printBooksByAuthorName(authorName);
                    break;
                case 4:
                    System.out.println("please input book genre");
                    String bookGenre = scanner.nextLine();
                    bookStorage.printBooksByBookGenre(bookGenre);
                    break;
                case 5:
                    System.out.println("please input lowest price range");
                    String lowPriceStr = scanner.nextLine();
                    double lowPrice;
                    int lowPriceInt = Integer.parseInt(lowPriceStr);
                    lowPrice = (double) lowPriceInt;
                    System.out.println("please input highest price range");
                    String highPriceStr = scanner.nextLine();
                    double highPrice;
                    int highPriceInt = Integer.parseInt(highPriceStr);
                    highPrice = (double) highPriceInt;
                    bookStorage.printBooksByPriceRange(lowPrice,highPrice);
                    break;

            }
        }
    }
    private static void addBook(){
        System.out.println("Please input book title");
        String title = scanner.nextLine();
        System.out.println("Please input author name");
        String authorName =  scanner.nextLine();
        System.out.println("Please input book price");
        String priceStr = scanner.nextLine();
        System.out.println("please input book count");
        String countStr = scanner.nextLine();
        System.out.println("please input book genre");
        String genre = scanner.nextLine();


        double price;
        int priceInt = Integer.parseInt(priceStr);
        price = (double) priceInt;
        int count = Integer.parseInt(countStr);

        Book book = new Book(title,authorName,price,count,genre);
        bookStorage.add(book);
        System.out.println("thank you, book added");
    }
}
