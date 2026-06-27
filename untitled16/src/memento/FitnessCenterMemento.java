package memento;

import model.Client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FitnessCenterMemento
        implements Serializable {

    private List<Client> clients;

    public FitnessCenterMemento(
            List<Client> clients) {

        this.clients =
                new ArrayList<>(clients);
    }

    public List<Client> getClients() {
        return clients;
    }
}