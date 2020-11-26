package com.company;

import java.util.*;

public class RedBlack {
    private String option;
    private String username;
    private String password;
    private String greeting;
    private String menu, submenu1;
    private int count = 0;
    Scanner scanner = new Scanner(System.in);
    TreeMap<String, String> books = new TreeMap<>();
    TreeMap<String, String> bookDetail = new TreeMap<>();

    public void start() throws InterruptedException {
        new Load();
        System.out.println("\n===========================================\n");
        greeting = "\n\t\tWelcome!!!\n" +
                "Simple Library Automation System\n" +
                "================================\n" +
                "Enter an option and press < ENTER > key to continue\n";

        menu =
                "1.\tView all books \n" +
                "2.\tSearch for a book \n" +
                "3.\tAdd a new book \n" +
                "4.\tDelete a book\n" +
                "5.\tExit \n";
        submenu1 =
                "\n\t1.\tSort by Author\n" +
                "\t2.\tSort by book title\n" +
                "\t3.\tSort by year published\n" +
                "\t4.\tReload the main menu\n" +
                "\t5.\tExit\n";

        System.out.println(greeting + "\n\n" + menu);
        info();
    }

    private void info() throws InterruptedException {
        System.out.print(">>>> " );
        option = scanner.nextLine();

        switch (option) {
            case "1":
                new Load();
                view_all_books();
                System.out.println(submenu1);
                submenu1Content();
                break;
            case "2":
                search_for_a_book();
                break;
            case "3":
                add_a_new_book();
                break;
            case "4":
                delete_a_book();
                break;
            case "5":
                exit();
                break;
            default:
                System.out.println(
                        "************************\n" +
                        "Select a correct option\n" +
                        "************************"
                );
                start();
                break;
        }
    }

    private void delete_a_book() throws InterruptedException {

        String key;
        System.out.print("\nType the correct title of the book you want to delete: ");
        key = scanner.nextLine();

        if (books.containsKey(key.toUpperCase())){
            books.remove(key);
            count--;
            System.out.println(key + " was deleted successfully");
            System.out.println(menu);
            info();
        }
        else {
            System.out.println(key + " cannot be found");
            System.out.println(menu);
            info();
        }
    }

    private void getBook(String book, String author){
        books.put(book.toUpperCase(), author.toUpperCase());
        count++;
    }
    private void getBookDetail(String desc, String year){
        bookDetail.put(desc, year);
    }
    private void add_a_new_book() throws InterruptedException {
        String newBook;
        String author;
        String description;
        String year;

        System.out.print("Enter the book title: ");
        newBook = scanner.nextLine();
        System.out.print("Enter the author name: ");
        author = scanner.nextLine();
        System.out.print("Enter the description: ");
        description = scanner.nextLine();
        System.out.print("Enter the year published: ");
        year = scanner.nextLine();

        getBook(newBook, author);
        getBookDetail(description, year);
        System.out.println("Book added!!!");
        view_all_books();
        System.out.println(menu);
        info();
    }

    private void submenu1Content() throws InterruptedException {
        System.out.print(">>>> " );
        option = scanner.nextLine();
        switch (option) {
            case "1":
                new Load();
                sort_by_author();
                break;
            case "2":
                sort_by_book_title();
                break;
            case "3":
                sort_by_year_published();
                break;
            case "4":
                start();
                break;
            case "5":
                exit();
                break;
            default:
                submenu1Content();
                break;
        }
    }

    private void info2(){

    }

    private void sort_by_year_published() {
    }

    private void sort_by_book_title() {
    }

    private void sort_by_author() {
    }

    private void view_all_books() throws InterruptedException {
        System.out.println("\nBooks available");
        System.out.println("================");

        /*
        Set set = books.entrySet();
        Set setOther = bookDetail.entrySet();

        for (Object o : set) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println("Title: " + entry.getKey() + " \t -> \tAuthor: " + entry.getValue());

            Map.Entry entryOther = (Map.Entry) o;
            System.out.println("\tDescription: " + entryOther.getKey() + " \n\tYear: " + entryOther.getValue());
        } */

        if (count == 0){
            System.out.println("\nThere are no books in the library\n");
            System.out.println(menu);
            info();
        }
        else {
            Set set = books.entrySet();
            Iterator iterator = set.iterator();
            Set setOther = bookDetail.entrySet();
            Iterator iteratorOther = setOther.iterator();
            for(int i = 0; i < count; i++) {
                Map.Entry entry = (Map.Entry)iterator.next();
                System.out.print("Book Title: "+ entry.getKey().toString()
                        + " \t -> \tAuthor: " + entry.getValue().toString());
                System.out.println();
                Map.Entry entryOther = (Map.Entry)iteratorOther.next();
                System.out.print("\t\t -> Description: "+ entryOther.getKey().toString()
                        + " \n\t\t -> Year Published: " + entryOther.getValue().toString());
                System.out.println();

                System.out.println(
                        "========================================" +
                                "================================"
                );
            }
        }
    }

    private void exit() {
        System.exit(0);
    }

    private void search_for_a_book() {
    }
}
