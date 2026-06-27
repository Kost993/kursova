package singleton;

import model.*;

import java.io.Serializable;
import java.util.*;

public class FitnessCenter implements Serializable {

    private static FitnessCenter instance;

    private List<Client> clients;
    private List<Trainer> trainers;
    private List<Workout> workouts;
    private List<Visit> visits;

    private FitnessCenter() {

        clients = new ArrayList<>();
        trainers = new ArrayList<>();
        workouts = new ArrayList<>();
        visits = new ArrayList<>();
    }

    public static FitnessCenter getInstance() {

        if(instance == null) {
            instance = new FitnessCenter();
        }

        return instance;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public Client findClientById(int id) {

        for(Client client : clients) {

            if(client.getId() == id) {
                return client;
            }
        }

        return null;
    }

    public Trainer findTrainerById(int id) {

        for(Trainer trainer : trainers) {

            if(trainer.getId() == id) {
                return trainer;
            }
        }

        return null;
    }

    public void showAllClients() {

        if(clients.isEmpty()) {
            System.out.println("Клієнтів немає.");
            return;
        }

        for(Client client : clients) {
            System.out.println(client);
        }
    }

    public void showAllWorkouts() {

        if(workouts.isEmpty()) {
            System.out.println("Тренувань немає.");
            return;
        }

        for(Workout workout : workouts) {
            System.out.println(workout);
        }
    }

    public void showStatistics() {

        Map<Integer,Integer> statistics =
                new HashMap<>();

        for(Visit visit : visits) {

            int hour =
                    visit.getVisitDate().getHour();

            statistics.put(
                    hour,
                    statistics.getOrDefault(hour,0) + 1
            );
        }

        System.out.println(
                "\nСтатистика завантаженості залу:"
        );

        for(Integer hour : statistics.keySet()) {

            System.out.println(
                    hour + ":00 -> " +
                            statistics.get(hour) +
                            " відвідувань"
            );
        }
    }
}