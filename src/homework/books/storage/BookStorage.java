package homework.books.storage;


import homework.books.model.Author;
import homework.books.model.Book;

public class BookStorage {
    private Book[] array = new Book[10];
    private int size = 0;

    public void add(Book book) {
        if (array.length == size) {
            extend();
        }
        array[size++] = book;
    }
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + "." +array[i] + " ");
        }
    }

    public void printBooksByAuthorName(Author author) {
        for (int i = 0; i < size; i++) {
            if (array[i].getAuthorName().equals(author)){
                System.out.println(array[i]);
            }

        }
    }
    public void printBooksByBookGenre(String bookGenre) {
        for (int i = 0; i < size; i++) {
            if (array[i].getGenre().equals(bookGenre)){
                System.out.println(array[i]);
            }

        }
    }

    private void extend() {
        Book[] temp = new Book[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public void printBooksByPriceRange(double lowPrice, double highPrice) {
        for (int i = 0; i < size ; i++) {
            if (array[i].getPrice() > lowPrice && array[i].getPrice()<highPrice){
                System.out.println(array[i]);
            }
        }

    }
}
