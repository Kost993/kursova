import factory.MembershipFactory;
import model.*;
import singleton.FitnessCenter;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static final FitnessCenter center =
            FitnessCenter.getInstance();

    public static void main(String[] args) {

        preloadData();

        while (true) {

            System.out.println("\n===== ФІТНЕС ЦЕНТР =====");
            System.out.println("1. Додати клієнта");
            System.out.println("2. Показати клієнтів");
            System.out.println("3. Видати абонемент");
            System.out.println("4. Зареєструвати відвідування");
            System.out.println("5. Створити тренування");
            System.out.println("6. Показати тренування");
            System.out.println("7. Показати статистику");
            System.out.println("0. Вихід");

            int choice =
                    Integer.parseInt(
                            scanner.nextLine());

            switch(choice) {

                case 1:
                    addClient();
                    break;

                case 2:
                    center.showAllClients();
                    break;

                case 3:
                    createMembership();
                    break;

                case 4:
                    registerVisit();
                    break;

                case 5:
                    createWorkout();
                    break;

                case 6:
                    center.showAllWorkouts();
                    break;

                case 7:
                    center.showStatistics();
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println(
                            "Невірний вибір"
                    );
            }
        }
    }

    private static void addClient() {

        System.out.print("ID: ");
        int id =
                Integer.parseInt(
                        scanner.nextLine());

        System.out.print("ПІБ: ");
        String name =
                scanner.nextLine();

        System.out.print("Телефон: ");
        String phone =
                scanner.nextLine();

        System.out.print("Email: ");
        String email =
                scanner.nextLine();

        center.addClient(
                new Client(
                        id,
                        name,
                        phone,
                        email
                )
        );

        System.out.println(
                "Клієнт доданий."
        );
    }

    private static void createMembership() {

        System.out.print(
                "ID клієнта: "
        );

        int id =
                Integer.parseInt(
                        scanner.nextLine());

        Client client =
                center.findClientById(id);

        if(client == null) {

            System.out.println(
                    "Клієнт не знайдений."
            );

            return;
        }

        System.out.println(
                "MONTHLY / YEARLY / SINGLE"
        );

        String type =
                scanner.nextLine();

        client.setMembership(
                MembershipFactory
                        .createMembership(type)
        );

        System.out.println(
                "Абонемент створено."
        );
    }

    private static void registerVisit() {

        System.out.print(
                "ID клієнта: "
        );

        int id =
                Integer.parseInt(
                        scanner.nextLine());

        Client client =
                center.findClientById(id);

        if(client == null) {

            System.out.println(
                    "Клієнта не знайдено."
            );

            return;
        }

        center.addVisit(
                new Visit(client)
        );

        System.out.println(
                "Відвідування зареєстровано."
        );
    }

    private static void createWorkout() {

        System.out.print(
                "Назва тренування: "
        );

        String title =
                scanner.nextLine();

        Trainer trainer =
                center.getTrainers().get(0);

        Workout workout =
                new Workout(
                        center.getWorkouts().size()+1,
                        title,
                        trainer,
                        LocalDateTime.now(),
                        15
                );

        center.addWorkout(workout);

        System.out.println(
                "Тренування створене."
        );
    }

    private static void preloadData() {

        center.addTrainer(
                new Trainer(
                        1,
                        "Олександр",
                        "CrossFit"
                )
        );
    }
}