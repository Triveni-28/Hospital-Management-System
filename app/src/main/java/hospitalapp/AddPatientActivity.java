// Form to add new patient
import com.hospital management system.hospitalapp.Utils;

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
    String nameStr = name.getText().toString().trim();
    String ageStr = age.getText().toString().trim();

    if (!Utils.isValidName(nameStr)) {
        Toast.makeText(this, getString(R.string.error_invalid_name), Toast.LENGTH_SHORT).show();
        return;
    }

    if (!Utils.isValidAge(ageStr)) {
        Toast.makeText(this, getString(R.string.error_invalid_age), Toast.LENGTH_SHORT).show();
        return;
    }

    int emergencyLevel = Integer.parseInt(emergency.getSelectedItem().toString());
    int ageVal = Integer.parseInt(ageStr);

    Patient p = new Patient(nameStr, ageVal, emergencyLevel, System.currentTimeMillis());
    FirebaseHelper.addPatient(p);
    finish();
        });
    }
}
