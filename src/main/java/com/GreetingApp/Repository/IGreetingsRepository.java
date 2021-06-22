package com.GreetingApp.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.GreetingApp.Model.Greeting;

public interface IGreetingsRepository extends JpaRepository<Greeting, Long> {

}
