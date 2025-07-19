// Form to add new patient
public class AddPatientActivity extends AppCompatActivity {
    EditText name, age;
    Spinner emergency;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        emergency = findViewById(R.id.emergency_level);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(v -> {
            Patient p = new Patient(
                name.getText().toString(),
                Integer.parseInt(age.getText().toString()),
                Integer.parseInt(emergency.getSelectedItem().toString()),
                System.currentTimeMillis()
            );
            FirebaseHelper.addPatient(p);
            finish();
        });
    }
}
