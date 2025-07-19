// Displays scheduled appointments
package com.mediqueue.hospitalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    FirebaseHelper firebaseHelper;
    Button addPatientBtn, scheduleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding UI
        listView = findViewById(R.id.patientList);
        addPatientBtn = findViewById(R.id.add_patient_btn);
        scheduleBtn = findViewById(R.id.schedule_btn);

        // Set button text from strings.xml
        addPatientBtn.setText(getString(R.string.btn_add_patient));
        scheduleBtn.setText(getString(R.string.btn_schedule_appointments));

        // Button actions
        addPatientBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddPatientActivity.class));
        });

        scheduleBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ScheduleActivity.class));
        });

        // Load and display patients
        firebaseHelper = new FirebaseHelper();
        firebaseHelper.getAllPatients(patients -> {
            AppointmentScheduler scheduler = new AppointmentScheduler(patients);
            List<Patient> sorted = scheduler.getScheduledPatients();
            PatientAdapter adapter = new PatientAdapter(this, sorted);
            listView.setAdapter(adapter);
        });
    }
}
