public class AppointmentScheduler {
    private PriorityQueue<Patient> queue;

    public AppointmentScheduler(List<Patient> patients) {
        queue = new PriorityQueue<>((p1, p2) -> p1.emergencyLevel - p2.emergencyLevel);
        queue.addAll(patients);
    }

    public List<Patient> getScheduledPatients() {
        List<Patient> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }
}
