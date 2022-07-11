package homework.books.storage;


import homework.books.model.User;

public class UserStorage {
    private User[] array = new User[10];
    private int size = 0;

    public void add(User book) {
        if (array.length == size) {
            extend();
        }
        array[size++] = book;
    }

    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + "." + array[i] + " ");
        }
    }

    public User getUsersByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if (array[i].getEmail().equals(email)){
                return array[i];
            }
        }
        return null;
    }


    private void extend() {
        User[] temp = new User[array.length + 10];
        System.arraycopy(array, 0, temp, 0, array.length);
        array = temp;
    }

}
