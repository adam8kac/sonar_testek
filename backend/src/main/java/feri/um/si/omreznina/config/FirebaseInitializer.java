package feri.um.si.omreznina.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
@Profile("!test")
public class FirebaseInitializer {

    @PostConstruct
    public void initfirebase() throws IOException {
        List<FirebaseApp> apps = FirebaseApp.getApps();

        if (apps == null || apps.isEmpty()) {
            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("serviceAccountKey.json");

            if (serviceAccount == null) {
                throw new IllegalStateException("Firebase serviceAccountKey.json not found in classpath.");
            }
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Work?");
        } else {
            System.out.println("Found " + apps.getFirst() + " Firebase apps");
        }
    }
}
