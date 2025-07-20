public class FirebaseHelper {
    private static DatabaseReference ref = FirebaseDatabase.getInstance().getReference("patients");

    public static void addPatient(Patient p) {
        ref.push().setValue(p);
    }

    public void getAllPatients(Consumer<List<Patient>> callback) {
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                List<Patient> list = new ArrayList<>();
                for (DataSnapshot snap : snapshot.getChildren()) {
                    list.add(snap.getValue(Patient.class));
                }
                callback.accept(list);
            }

            public void onCancelled(DatabaseError error) {}
        });
    }
}
