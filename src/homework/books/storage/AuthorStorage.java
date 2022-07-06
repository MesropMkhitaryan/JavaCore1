package homework.books.storage;


import homework.books.exception.AuthorNotFoundException;
import homework.books.model.Author;
import homework.books.model.Book;

public class AuthorStorage {
    private Author[] array = new Author[10];
    private int size = 0;

    public void add(Author author) {
        if (array.length == size) {
            extend();
        }
        array[size++] = author;
    }
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + "." +array[i] + " ");
        }
    }
    private void extend() {
        Author[] temp = new Author[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }
    public Author getByIndex(int index){
        if (index>=0 && index<size){
            return array[index];
        }
        else {
            return null;
        }
    }
    public int getSize(){
        return size;
    }
    public Author getAuthorByIndex(int index) throws AuthorNotFoundException {
        if (index >= 0 && index < size) {
            return array[index];
        }
        throw new AuthorNotFoundException("Author with " + index + " index does not exists");

    }





}
