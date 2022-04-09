import java.util.Scanner;

public class TestChatPlaceManager {
    public static void main(String[] args) {
        ChatPlaceManager chatPlaceManager = new ChatPlaceManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String text = scanner.nextLine();
            chatPlaceManager.handle(text);
        }
    }
}
