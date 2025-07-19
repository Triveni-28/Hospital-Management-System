public class PatientManager {
    private LinkedList<Patient> history = new LinkedList<>();

    public void addPatient(Patient p) {
        history.add(p);
    }

    public List<Patient> getAllPatients() {
        return history;
    }
}
