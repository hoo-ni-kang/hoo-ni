package hoonminiproject;
// 인터페이스
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        boolean running = true;

        System.out.println("===== 도서 관리 시스템 =====");

        while (running) {
            System.out.println("\n메뉴 선택:");
            System.out.println("1. 도서 추가         2. 전체 도서 목록 조회 ");
            System.out.println("3. 도서 검색         4. 도서 대여");
            System.out.println("5. 도서 반납         6. 종료");
            System.out.print("선택 >> ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("제목 입력: ");
                    String title = sc.nextLine();
                    System.out.print("저자 입력: ");
                    String author = sc.nextLine();
                    library.addBook(title, author);
                }
                case 2 -> library.listAllBooks();
                case 3 -> {
                    System.out.print("검색할 제목 입력: ");
                    String keyword = sc.nextLine();
                    library.searchBook(keyword);
                }
                case 4 -> {
                    System.out.print("대여할 도서 ID 입력: ");
                    try {
                        long rentId = Long.parseLong(sc.nextLine());
                        library.rentBook(rentId);
                    } catch (NumberFormatException e) {
                        System.out.println("ID를 입력해주세요.");
                    }
                }
                case 5 -> {
                    System.out.print("반납할 도서 ID 입력: ");
                    try {
                        long returnId = Long.parseLong(sc.nextLine());
                        library.returnBook(returnId);
                    } catch (NumberFormatException e) {
                        System.out.println("숫자 ID를 입력해주세요.");
                    }
                }
                case 6 -> {
                    running = false;
                    System.out.println("프로그램을 종료합니다.");
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }

        sc.close();
    }
}