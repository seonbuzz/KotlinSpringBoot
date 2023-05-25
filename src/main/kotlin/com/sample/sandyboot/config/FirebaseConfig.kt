package com.sample.sandyboot.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream
import javax.annotation.PostConstruct


@Configuration
class FirebaseConfig {
    @PostConstruct
    fun init() {
        try {
            val serviceAccount = FileInputStream("src/main/resources/sandy-firebase.json")
            val options: FirebaseOptions =
                FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build()
            FirebaseApp.initializeApp(options)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}