package hoonminiproject;
// 도서 데이터 저장
public class Book {
    // 도서 번호
    private long id;
    // 도서 제목
    private String title;
    // 저자
    private String author;
    // 대여여부
    private boolean isRented;

    public Book(long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isRented = false; // 기본값: 대여 가능
    }

    public long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isRented() { return isRented; }

    public void rent() { this.isRented = true; }
    public void returnBook() { this.isRented = false; }

    @Override
    public String toString() {
        return String.format("[%d] %s / %s / %s",
                id, title, author, (isRented ? "대여 중" : "대여 가능"));
    }
}

