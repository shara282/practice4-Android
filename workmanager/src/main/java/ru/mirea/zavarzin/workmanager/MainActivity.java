package ru.mirea.zavarzin.workmanager;

import static androidx.work.NetworkType.CONNECTED;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // КРИТЕРИЙ подключения к WiFi или Mobile Data
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(CONNECTED)
                .build();

        WorkRequest uploadWorkRequest = new OneTimeWorkRequest.Builder(UploadWorker.class)
                .setConstraints(constraints).build();

        WorkManager.getInstance(this).enqueue(uploadWorkRequest);
    }
}