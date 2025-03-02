public class Library {
    Book firstBook;

    public Book returnBook(Book firstBook, String isbn, String title, String author) {
        // implement this function

        // This function adds a new book to the library by inserting it into the BST
        // - Returns the root node of the updated BST
        // - Please use compareTo method for comparisons
        // - Do nothing if there are duplicate books

        Book newbook = new Book(isbn, title, author);

        if (firstBook == null) {
           return newbook;
        }

        // start from root;
        Book current = firstBook;
        Book parent = null;

        while (current != null) {// while current is not null,find node thats gonna be the parent
            parent = current;// change prev node
            if (current.compareTo(newbook) > 0) {
                current = current.lowerISBN;

            } else if (current.compareTo(newbook) < 0) {
                current = current.higherISBN;

            } else {
                return firstBook;
            }

        }

        if (parent != null) { // Ensure parent is not null before assigning
            if (parent.compareTo(newbook) < 0) {
              parent.higherISBN = newbook;
            } else {
                  parent.lowerISBN = newbook;
            }
        } else {
            firstBook = newbook; // If parent is null, update root
        }
        
        return firstBook;

    }

    public Book borrowBook(Book firstBook, String isbn, String title, String author) {
        // implement this function
        // 3 cases

        // case 1 : delete leaf node(easy)

        // case 2: delete node with single child
        // case 3: delete node with 2 children
        if (firstBook == null) {// just return null
            return firstBook;
        }
        Book del = new Book(isbn, title, author);
        if (firstBook.compareTo(del) > 0) {
            firstBook.lowerISBN = borrowBook(firstBook.lowerISBN, isbn, title, author);// left is smaller

        } else {
            if (firstBook.compareTo(del) < 0) {// right is bigger,move right
                firstBook.higherISBN = borrowBook(firstBook.higherISBN, isbn, title, author);
            } else {// found it or null

                if (firstBook.lowerISBN == null) {
                    return firstBook.higherISBN; 
                }
                if (firstBook.higherISBN == null) {
                    return firstBook.lowerISBN; 
                }
                

                Book helperBook = helperfunc(firstBook);
                firstBook.isbn = helperBook.isbn;
                firstBook.title = helperBook.title;
                firstBook.author = helperBook.author;
                firstBook.higherISBN = borrowBook(firstBook.higherISBN, helperBook.isbn, helperBook.title,
                        helperBook.author);

            }

        }

        return firstBook;

    }

    public Book helperfunc(Book newbook) {
        newbook = newbook.higherISBN;
        while (newbook != null && newbook.lowerISBN != null) {
            newbook = newbook.lowerISBN;
        }
        return newbook;

    }

    public Book findLowestISBN(Book firstBook) {

        if (firstBook == null) {
            return firstBook;
        }

        Book curr = firstBook;

        while (curr.lowerISBN != null) {

            curr = curr.lowerISBN;

        }

        // implement this function
        return curr;
    }

    public boolean checkAvailability(Book firstBook, String isbn) {

        // implement this function

        if (firstBook == null)
            return false;

        Book curr = firstBook;
        Book comp = new Book(isbn, "", "");

        while (curr != null) {

            if (curr.compareTo(comp) == 0) {
                return true;

            }

            if (curr.compareTo(comp) < 0) {
                curr = curr.higherISBN; 
            } else {
               curr = curr.lowerISBN;
            }

        }

        return false;
    }

    public String inorderPrint(Book root) {
        // implement this function
        String str = "";
        if (root == null) {
            return "";

        }
        str += inorderPrint(root.lowerISBN);

        str += "Book{ISBN: " + root.isbn + ", Title: " + root.title + ", Author: " + root.author + "}\n";

        str += inorderPrint(root.higherISBN);

        return str;
    }

    public String preorderPrint(Book root) {
        // implement this function

        String str = "";
        if (root == null) {
            return "";

        }

        str += "Book{ISBN: " + root.isbn + ", Title: " + root.title + ", Author: " + root.author + "}\n";
        str += preorderPrint(root.lowerISBN);
        str += preorderPrint(root.higherISBN);

        return str;

    }

    public String postorderPrint(Book root) {
        // implement this function
        String str = "";
        if (root == null) {
            return "";

        }
        str += postorderPrint(root.lowerISBN);
        str += postorderPrint(root.higherISBN);

        str += "Book{ISBN: " + root.isbn + ", Title: " + root.title + ", Author: " + root.author + "}\n";

        return str;

    }

    public int getShelfHeight(Book firstBook) {
        if (firstBook == null) {
            return 0;
        }

        int l = getShelfHeight(firstBook.lowerISBN);
        int r = getShelfHeight(firstBook.higherISBN);

        // implement this function
        return Math.max(r, l) + 1;
    }

    // Do not Change this function as it will negatively affect your marks
    @Override
    public String toString() {
        if (firstBook == null) {
            return "Library is empty.";
        }
        return firstBook.toString();
    }
}