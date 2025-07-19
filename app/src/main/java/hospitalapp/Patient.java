public class Patient {
    public String name;
    public int age;
    public int emergencyLevel;
    public long timestamp;

    public Patient() {} // Firebase requires empty constructor

    public Patient(String name, int age, int level, long ts) {
        this.name = name;
        this.age = age;
        this.emergencyLevel = level;
        this.timestamp = ts;
    }
}
