package ru.edu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.edu.config.Log;

@SpringBootApplication
public class MyApp implements CommandLineRunner {

    @Value("${server.port}")
    private String port;

    @Value("${server.address}")
    private String url;

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }

    @Override
    public void run(String... args) {
        Log.startLog.info("URL: http://{}:{}", url, port);
    }

}