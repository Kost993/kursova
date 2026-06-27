package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Workout implements Serializable {

    private int id;
    private String title;
    private Trainer trainer;
    private LocalDateTime dateTime;
    private int maxParticipants;

    private List<Client> participants;

    public Workout(int id,
                   String title,
                   Trainer trainer,
                   LocalDateTime dateTime,
                   int maxParticipants) {

        this.id = id;
        this.title = title;
        this.trainer = trainer;
        this.dateTime = dateTime;
        this.maxParticipants = maxParticipants;

        participants = new ArrayList<>();
    }

    public boolean addParticipant(Client client) {

        if(participants.size() >= maxParticipants) {
            return false;
        }

        participants.add(client);
        return true;
    }

    public void removeParticipant(Client client) {
        participants.remove(client);
    }

    public int getParticipantsCount() {
        return participants.size();
    }

    public String getTitle() {
        return title;
    }

    public List<Client> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {

        return "\nТренування: " + title +
                "\nТренер: " + trainer.getName() +
                "\nДата: " + dateTime +
                "\nУчасників: " +
                participants.size() +
                "/" +
                maxParticipants;
    }
}