package homework.books;

import homework.books.command.Commands;
import homework.books.enums.Gender;
import homework.books.enums.Role;
import homework.books.exception.AuthorNotFoundException;
import homework.books.model.Author;
import homework.books.model.Book;
import homework.books.model.User;
import homework.books.storage.AuthorStorage;
import homework.books.storage.BookStorage;
import homework.books.storage.UserStorage;

import java.util.Scanner;

public class BookDemo implements Commands {
    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();
    private static AuthorStorage authorStorage = new AuthorStorage();
    private static UserStorage userStorage = new UserStorage();

    public static void main(String[] args) {

        userStorage.add(new User("admin","admin","admin@mail.com","admin", Role.ADMIN));
        boolean run = true;
        while (run){
            Commands.printLoginCommands();

            int command = 0;
            try {
                command = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e){
                command = -1;
            }
            switch (command){
                case 0:
                    run =false;
                    break;
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                default:
                    System.out.println("invalid number");

            }
        }

    }

    private static void login() {
        System.out.println("please input email,password");
        String emailPasswordStr = scanner.nextLine();
        String[] emailPassword = emailPasswordStr.split(",");
        User user = userStorage.getUsersByEmail(emailPassword[0]);
        if (user == null){
            System.out.println("user does not exist!");
        }else {
            if (!user.getPassword().equals(emailPassword[1])) {
                System.out.println("password is wrong!");
            }
            else {
                if (user.getRole() == Role.ADMIN){
                     loginAdmin();
                }
                else if (user.getRole() == Role.USER){
                    userLogin();
                }
            }
        }


    }



    private static void register() {
        System.out.println("please input name,surname,email,password");
        String userDataStr = scanner.nextLine();
        String[] userData = userDataStr.split(",");
        if (userData.length < 4){
            System.out.println("please input correct user data");
        }
        else {
            if (userStorage.getUsersByEmail(userData[2]) == null) {
                User user = new User();
                user.setName(userData[0]);
                user.setSurname(userData[1]);
                user.setEmail(userData[2]);
                user.setPassword(userData[3]);
                user.setRole(Role.USER);
                userStorage.add(user);
                System.out.println("user registered");
            }
            else {
                System.out.println("user with " + userData[2] + " already exist");
            }
        }

    }

    private static void loginAdmin() {
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
                case LOGOUT:
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
    private static void userLogin() {
        boolean run = true;


        while (run) {
            Commands.printUserComands();
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

    private static Gender addAuthor() {

        System.out.println("please input author name");
        String name = scanner.nextLine();
        System.out.println("please input author surname");
        String surname = scanner.nextLine();
        System.out.println("please input author email");
        String email = scanner.nextLine();
        System.out.println("please choose author gender");
        try {
            System.out.println("MALE  FEMALE");
            Gender gender = Gender.valueOf(scanner.nextLine());
            if (gender.equals(Gender.MALE) || gender.equals(Gender.FEMALE)){
                Author author = new Author(name,surname,email,gender);
                authorStorage.add(author);
            }
            else {
                System.out.println("there is no such a gender please try again");
                addAuthor();
            }
        }catch (IllegalArgumentException e) {
            System.out.println("there is no such a gender please try again");
            addAuthor();
        }
        return null;
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
