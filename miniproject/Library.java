package hoonminiproject;
// 도서 관리기능
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList = new ArrayList<>();
    private long nextBookId = 1;

    // 도서 추가
    public void addBook(String title, String author) {
        Book book = new Book(nextBookId++, title, author);
        bookList.add(book);
        System.out.println("도서가 추가되었습니다: " + book);
    }

    // 전체 도서 목록 조회
    public void listAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println("등록된 도서가 없습니다.");
        } else {
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
    }

    // 도서검색
    public void searchBook(String keyword) {
        boolean found = false;
        for (Book book : bookList) {
            if (book.getTitle().contains(keyword)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    // 도서 대여
    public void rentBook(long id) {
        for (Book book : bookList) {
            if (book.getId() == id) {
                if (book.isRented()) {
                    System.out.println("이미 대여 중인 도서입니다.");
                } else {
                    book.rent();
                    System.out.println("대여 완료: " + book);
                }
                return;
            }
        }
        System.out.println("해당 ID의 도서를 찾을 수 없습니다.");
    }

    // 도서 반납
    public void returnBook(long id) {
        for (Book book : bookList) {
            if (book.getId() == id) {
                if (!book.isRented()) {
                    System.out.println("이미 반납된 도서입니다.");
                } else {
                    book.returnBook();
                    System.out.println("반납 완료: " + book);
                }
                return;
            }
        }
        System.out.println("해당 ID의 도서를 찾을 수 없습니다.");
    }
}
