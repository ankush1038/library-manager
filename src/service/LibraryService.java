package service;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> books;

    public LibraryService(){
        books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
        System.out.println("Book Added successfully");
    }

    public void viewBooks(){
        if(books.isEmpty()){
            System.out.println("No Books available");
            return;
        }
        for(Book book : books){
            System.out.println(book);
        }
    }

    public void searchBook(String title){
        boolean found = false;

        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                System.out.println(book);
                found = false;
            }
        }
        if(!found){
            System.out.println("No book with provided title is present in the library!");
        }
    }

    public void issueBook(int id){
        for(Book book : books){
            if(book.getId() == id){
                if(book.isIssued()){
                    System.out.println("Book is already issue!");
                }
                else{
                    book.setIssued(true);
                    System.out.println("Book issued succesfully");
                }
                return;
            }
        }

    }
    public void returnBook(int id){
        for(Book book : books){
            if(book.getId() == id){
                if(!book.isIssued()){
                    System.out.println("Book was not issued");
                }
                else{
                    book.setIssued(false);
                    System.out.println("Book returned successfully");
                }
                return;
            }
        }
        System.out.println("Book not Found");
    }
}