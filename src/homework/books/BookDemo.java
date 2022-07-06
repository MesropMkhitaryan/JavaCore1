package homework.books;

import homework.books.command.Commands;
import homework.books.exception.AuthorNotFoundException;
import homework.books.model.Author;
import homework.books.model.Book;
import homework.books.storage.AuthorStorage;
import homework.books.storage.BookStorage;

import java.util.Scanner;

public class BookDemo implements Commands {
    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();
    private static AuthorStorage authorStorage = new AuthorStorage();

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            Commands.printComands();
            int command = 0;
            try {
                command = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("please input correct command index");
                Commands.printComands();
                command = Integer.parseInt(scanner.nextLine());
            }

            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_ALL_BOOKS:
                    bookStorage.printArray();
                    break;
                case PRINT_BOOKS_BY_GENRE:
                    System.out.println("please input book genre");
                    String bookGenre = scanner.nextLine();
                    bookStorage.printBooksByBookGenre(bookGenre);
                    break;
                case PRINT_BOOKS_BY_PRICE_RANGE:
                    printByPriceRange();
                    break;
                case ADD_AUTHOR:
                    addAuthor();
                    break;
                case PRINT_AUTHORS:
                    authorStorage.printArray();
                    break;
                case GET_AUTHOR_BY_INDEX:
                    getAuthorByIndex();
                    break;
                default:
                    System.out.println("invalid number");

            }
        }
    }

    private static void printByPriceRange() {
        double lowPrice =0;

        try {
            lowPrice = getLowPrice(lowPrice);
        }
        catch (NumberFormatException e){
            System.out.println("please input numbers only");
            getLowPrice(lowPrice);
        }
        double highPrice = 0;
       try {
           highPrice = getHighPrice(highPrice);
       }
       catch (NumberFormatException e){
           System.out.println("please input numbers only");
           getHighPrice(highPrice);
       }

        bookStorage.printBooksByPriceRange(lowPrice, highPrice);
    }

    private static double getHighPrice(double highPrice) {
        System.out.println("please input highest price range");
        String highPriceStr = scanner.nextLine();
        highPrice = Double.parseDouble(highPriceStr);
        return highPrice;
    }

    private static double getLowPrice(double lowPrice) {
        System.out.println("please input lowest price range");
        String lowPriceStr = scanner.nextLine();
        lowPrice = Double.parseDouble(lowPriceStr);
        return lowPrice;
    }

    private static void getAuthorByIndex() {
        authorStorage.printArray();
        System.out.println("please input author index");
        int autInd = Integer.parseInt(scanner.nextLine());

        try {
            System.out.println(authorStorage.getAuthorByIndex(autInd));
        }
        catch (AuthorNotFoundException e){
            System.out.println("invalid index");
            getAuthorByIndex();
        }
    }

    private static void addAuthor() {

        System.out.println("please input author name");
        String name = scanner.nextLine();
        System.out.println("please input author surname");
        String surname = scanner.nextLine();
        System.out.println("please input author email");
        String email = scanner.nextLine();
        System.out.println("please input author gender");
        String gender = scanner.nextLine();
        if (gender.equals("male") || gender.equals("female")){
            Author author = new Author(name,surname,email,gender);
            authorStorage.add(author);
        }
        else {
            System.out.println("there is no such a gender please try again");
            addAuthor();
        }




    }

    private static void addBook() {
        if (authorStorage.getSize() == 0){
            System.out.println("please input author");
            addAuthor();
        }
        else {
            authorStorage.printArray();
            System.out.println("please choose author index");
            int authorIndex = Integer.parseInt(scanner.nextLine());
            Author author = authorStorage.getByIndex(authorIndex);
            if (author == null){
                System.out.println("please input correct index");
                addBook();
            }

            System.out.println("Please input book title");
            String title = scanner.nextLine();
            double price = 0;
            try {
                price = getPrice(price);
            }
            catch (NumberFormatException e){
                System.out.println("please input numbers only");
                getPrice(price);
            }
            int count = 0;
            try {
                count = getCount(count);
            }
            catch (NumberFormatException e){
                System.out.println("please input numbers only");
                getCount(count);
            }
            System.out.println("please input book genre");
            String genre = scanner.nextLine();
            Book book = new Book(title, author, price, count, genre);
            bookStorage.add(book);
            System.out.println("thank you, book added");
        }



    }

    private static int getCount(int count) {
        System.out.println("please input book count");
        String countStr = scanner.nextLine();
        count = Integer.parseInt(countStr);
        return count;
    }

    private static double getPrice(double price) {
        System.out.println("Please input book price");
        String priceStr = scanner.nextLine();
        price = Double.parseDouble(priceStr);
        return price;
    }
}
