// Displays scheduled appointments
public class MainActivity extends AppCompatActivity {
    ListView listView;
    FirebaseHelper firebaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.patientList);
        firebaseHelper = new FirebaseHelper();

        firebaseHelper.getAllPatients(patients -> {
            AppointmentScheduler scheduler = new AppointmentScheduler(patients);
            List<Patient> sorted = scheduler.getScheduledPatients();
            PatientAdapter adapter = new PatientAdapter(this, sorted);
            listView.setAdapter(adapter);
        });
    }
}
