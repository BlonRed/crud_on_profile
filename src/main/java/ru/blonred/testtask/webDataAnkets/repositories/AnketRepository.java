package ru.blonred.testtask.webDataAnkets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.blonred.testtask.webDataAnkets.models.Anket;

import java.util.List;

public interface AnketRepository extends JpaRepository<Anket, Long> {
    List<Anket> findByFirstName(String firstName);
}
