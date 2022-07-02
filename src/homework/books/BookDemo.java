package homework.books;

import homework.books.command.Commands;
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
            int command = Integer.parseInt(scanner.nextLine());
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
                    System.out.println("please input lowest price range");
                    String lowPriceStr = scanner.nextLine();
                    double lowPrice = Double.parseDouble(lowPriceStr);
                    System.out.println("please input highest price range");
                    String highPriceStr = scanner.nextLine();
                    double highPrice = Double.parseDouble(highPriceStr);
                    bookStorage.printBooksByPriceRange(lowPrice, highPrice);
                    break;
                case ADD_AUTHOR:
                    addAuthor();
                    break;
                case PRINT_AUTHORS:
                    authorStorage.printArray();
                    break;
                default:
                    System.out.println("invalid number");

            }
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
            gender.equals(gender);
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

            System.out.println("Please input book price");
            String priceStr = scanner.nextLine();
            System.out.println("please input book count");
            String countStr = scanner.nextLine();
            System.out.println("please input book genre");
            String genre = scanner.nextLine();


            double price = Double.parseDouble(priceStr);
            int count = Integer.parseInt(countStr);


            Book book = new Book(title, author, price, count, genre);
            bookStorage.add(book);
            System.out.println("thank you, book added");
        }



    }
}
