import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Player player = new Player(100, 10, 10);//5 base dmg - za mało 

        Event currentEvent;
        do {
            currentEvent = new Event(Event.randomType());
        } while (currentEvent.startEvent(player, scanner));

        scanner.close();
    }
}
