package ru.blonred.testtask.crud_on_profiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.blonred.testtask.crud_on_profiles.models.Profile;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    public List<Profile> findByFirstName(String firstName);
}
