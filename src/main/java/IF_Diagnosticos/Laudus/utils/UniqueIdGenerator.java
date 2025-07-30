package IF_Diagnosticos.Laudus.utils;

public class UniqueIdGenerator {

    private static UniqueIdGenerator instance;
    private int counter;

    private UniqueIdGenerator() {
        this.counter = 0;
    }

    public static synchronized UniqueIdGenerator getInstance() {
        if (instance == null) {
            instance = new UniqueIdGenerator();
        }
        return instance;
    }

    public String generateNextId() {
        counter++;
        // Formato de ID simples. Em um sistema real, seria mais robusto (ex: UUIDs, timestamp + contador)
        return String.format("EXAM-%07d", counter);
    }
}
