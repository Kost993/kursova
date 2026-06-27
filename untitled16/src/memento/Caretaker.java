package memento;

public class Caretaker {

    private FitnessCenterMemento memento;

    public void save(
            FitnessCenterMemento memento) {

        this.memento = memento;
    }

    public FitnessCenterMemento restore() {

        return memento;
    }
}