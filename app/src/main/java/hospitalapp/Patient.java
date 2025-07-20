import java.io.Serializable;

public class Patient implements Serializable {
    public String name;
    public int age;
    public int emergencyLevel;
    public long timestamp;

    public Patient() {
        // Default constructor (optional, useful for Firebase or deserialization)
    }

    public Patient(String name, int age, int level, long ts) {
        this.name = name;
        this.age = age;
        this.emergencyLevel = level;
        this.timestamp = ts;
    }
}
