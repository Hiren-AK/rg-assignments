package com.example.demo1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args -> {
            Employee rob = new Employee(
                    "Rob",
                    "Accounts"
            );
            Employee alex = new Employee(
                    "Alex",
                    "IT"
            );
            repository.saveAll(List.of(rob, alex));
        };
    }
}
