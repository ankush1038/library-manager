import model.Book;
import service.LibraryService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryService();

        int choice;

        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter book id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Title: ");
                    String title = sc.nextLine();
                    sc.nextLine();

                    System.out.println("Enter Author name: ");
                    String author = sc.nextLine();
                    sc.nextLine();

                    Book book = new Book(id, title, author);
                    service.addBook(book);
                    break;

                case 2:
                    service.viewBooks();
                    break;

                case 3:
                    System.out.println("Enter title: ");
                    String searchTitle = sc.nextLine();
                    service.searchBook(searchTitle);
                    break;

                case 4:
                    System.out.println("Enter Book Id to issue: ");
                    int BookId = sc.nextInt();
                    service.issueBook(BookId);
                    break;

                case 5:
                    System.out.println("Enter Book Id to return: ");
                    int returnBookId = sc.nextInt();
                    service.returnBook(returnBookId);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again!");
                }
            } while(choice != 6);

        sc.close();
        }
    }
