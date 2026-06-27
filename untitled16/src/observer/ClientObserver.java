package observer;

public class ClientObserver implements Observer {

    private String clientName;

    public ClientObserver(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void update(String message) {

        System.out.println(
                "[Повідомлення для " +
                        clientName +
                        "] " +
                        message
        );
    }
}