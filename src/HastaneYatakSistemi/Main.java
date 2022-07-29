package HastaneYatakSistemi;

public class Main {
    public static void main(String[] args) {

        for (int i = 1; i <= 15; i++) {
            Client client = new Client(i);
            client.start();
        }

    }
}
