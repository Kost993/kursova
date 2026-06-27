package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Visit implements Serializable {

    private Client client;
    private LocalDateTime visitDate;

    public Visit(Client client) {
        this.client = client;
        this.visitDate = LocalDateTime.now();
    }

    public Client getClient() {
        return client;
    }

    public LocalDateTime getVisitDate() {
        return visitDate;
    }

    @Override
    public String toString() {
        return client.getFullName() +
                " | " +
                visitDate;
    }
}