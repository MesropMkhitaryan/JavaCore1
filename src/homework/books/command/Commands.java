package homework.books.command;

public interface Commands {
    int EXIT = 0;
    int ADD_BOOK = 1;
    int PRINT_ALL_BOOKS = 2;
    int PRINT_BOOKS_BY_GENRE = 3;
    int PRINT_BOOKS_BY_PRICE_RANGE = 4;
    int ADD_AUTHOR = 5;
    int PRINT_AUTHORS = 6;

    public static void printComands(){
        System.out.println("input " + EXIT + " for exit");
        System.out.println("input " + ADD_BOOK + " to add book");
        System.out.println("input " + PRINT_ALL_BOOKS + " to print all books");
        System.out.println("input " + PRINT_BOOKS_BY_GENRE + " to print books by genre");
        System.out.println("input " + PRINT_BOOKS_BY_PRICE_RANGE + " to print books by price range");
        System.out.println("input " + ADD_AUTHOR  + " to add author");
        System.out.println("input " + PRINT_AUTHORS  + " to print authors");
    }

}
