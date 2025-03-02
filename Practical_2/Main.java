public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book Book1 = new Book("978045152493", "1984", "George Orwell");
        library.firstBook = Book1;
        library.returnBook(library.firstBook, "978006112008", "To Kill a Mockingbird", "Harper Lee");
        System.out.println(library.toString());

       testLibrary();

    //kyleTest();
  
    }

 
    public static void testLibrary() {

        Library library = new Library();

        // Adding books
        Book bookA = new Book("6", "Book A", "Author A");
        library.firstBook = bookA;
        library.firstBook = library.returnBook(library.firstBook, "1", "Book B", "Author B");
        library.firstBook = library.returnBook(library.firstBook, "3", "Book C", "Author C");
        library.firstBook = library.returnBook(library.firstBook, "2", "Book D", "Author D");
        library.firstBook = library.returnBook(library.firstBook, "7", "Book E", "Author E");// delete leaf
        library.firstBook = library.returnBook(library.firstBook, "8", "Book F", "Author F");// delete root
        System.out.println(library.toString());
        System.out.println();

        Book lowest = library.findLowestISBN(library.firstBook);

        System.err.println(library.checkAvailability(library.firstBook, "8"));
        System.err.println(library.checkAvailability(library.firstBook, "1"));
        System.err.println(library.checkAvailability(library.firstBook, "6"));
        System.err.println(library.checkAvailability(library.firstBook, "3"));
        System.err.println(library.checkAvailability(library.firstBook, "13"));
        System.err.println(library.checkAvailability(library.firstBook, "18"));

        System.out.println(library.getShelfHeight(library.firstBook));

        System.out.println(library.inorderPrint(library.firstBook));
        System.out.println(library.postorderPrint(library.firstBook));
        System.out.println(library.preorderPrint(library.firstBook));

        // remove testing
        library.borrowBook(library.firstBook, "8", "Book F", "Author F");// delete leaf
        System.out.println(library.toString() + "#");
        System.out.println();
        library.borrowBook(library.firstBook, "3", "Book C", "Author C");// delete leaf
        System.out.println(library.toString() + "#");
        System.out.println();
        library.borrowBook(library.firstBook, "6", "Book A", "Author A");// delete leaf
        System.out.println(library.toString() + "#");
        System.out.println();
        library.borrowBook(library.firstBook, "7", "Book D", "Author D");// delete leaf
        System.out.println(library.toString() + "#");
        System.out.println();

    }

    public static void kyleTest(){
        Library library = new Library();

        // Adding books
        Book bookA = new Book("6", "Book A", "Author A");
        library.firstBook = bookA;
        library.returnBook(library.firstBook, "1", "1", "1");
        System.out.println(library.toString());
    }

}


