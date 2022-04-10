import java.util.Scanner;

public class TestChatPlaceManager {
    public static void main(String[] args) {
        ChatPlaceManager chatPlaceManager = new ChatPlaceManager();

        System.out.println("Commands: Set setting,\n" +
                " Ccy setting - USD and EUR\n" +
                "Set qty - for now just 1 and 2 \n" +
                "Set time - for now just 11 and 12, \n" +
                "Ok\n" +
                "Set bank - Mono, Privat, NBU");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String text = scanner.nextLine();
            chatPlaceManager.handle(text);
        }
    }
}
