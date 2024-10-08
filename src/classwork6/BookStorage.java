package classwork6;

import java.util.Arrays;

public class BookStorage {

    private  Book[] books = new Book[10];
    private  int size;

    public boolean isEmpty () {
        return  size == 0;
    }

    public void add(Book book) {
        if (books.length == size){
            extendStorage();
        }
        books[size++] = book;
    }

    private void extendStorage() {
        books = Arrays.copyOf(books, size + 10);
    }

    public  void  print() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public void searchByBookName(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().toUpperCase().contains(keyword.toUpperCase())) {
                System.out.println(books[i]);
            }
        }
    }

    public Book getBookById(String id){
        for (int i = 0; i < size; i++) {
            if (books[i].getId().equalsIgnoreCase(id)) {
                return books[i];
            }
        }
        return null;
    }

    public void deleteBookByID(String id) {

        for (int index = 0; index < size; index++) {
            if (books[index].getId().equalsIgnoreCase(id)) {
                for (int j = index; j <size-1 ; j++) {
                    books[j] =books[j+1];
                }
                size--;
                return;
            }
        }
    }
}
