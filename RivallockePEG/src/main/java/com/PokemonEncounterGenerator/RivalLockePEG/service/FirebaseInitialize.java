package com.PokemonEncounterGenerator.RivalLockePEG.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseInitialize {

    //public static Firestore db;

    @PostConstruct
    public void intitialize() throws IOException {
        try {
            FileInputStream serviceAccount = new FileInputStream("/Users/jeff/Git/PokemonEncounterGenerator/RivalLockePEG/src/main/resources/serviceAccount.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            //db = FirestoreClient.getFirestore();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}