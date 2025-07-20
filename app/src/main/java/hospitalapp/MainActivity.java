package com.hospitalmanagementsystem.hospitalapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button addPatientBtn, scheduleBtn;
    PatientManager patientManager; // Local file handler

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind UI
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

        // Load and display patients using local file
        patientManager = new PatientManager(this);
        List<Patient> allPatients = patientManager.getAllPatients();  // From local storage

        AppointmentScheduler scheduler = new AppointmentScheduler(allPatients);
        List<Patient> scheduled = scheduler.getScheduledPatients();
        PatientAdapter adapter = new PatientAdapter(this, scheduled);
        listView.setAdapter(adapter);
    }
}
