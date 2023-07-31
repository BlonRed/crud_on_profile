package ru.blonred.testtask.crud_on_profiles.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.blonred.testtask.crud_on_profiles.models.Profile;
import ru.blonred.testtask.crud_on_profiles.repositories.ProfileRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    public boolean existsById(Long id) {
        return profileRepository.existsById(id);
    }

    public List<Profile> getListProfiles(String firstName) {
        if (firstName != null && !firstName.isEmpty()) {
            return profileRepository.findByFirstName(firstName);
        }
        return profileRepository.findAll();
    }

    public Profile getProfileById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Profile saveProfile(Profile profile) throws Exception {
        if (profile.getId() != null && existsById(profile.getId())) {
            throw new Exception("Profile with id: " + profile.getId() + " already exists");
        }
        log.info("Saving new{}", profile);
        return profileRepository.save(profile);
    }

    public void updateProfile(Profile profile) throws Exception {
        if (!existsById(profile.getId())) {
            throw new Exception("Cannot find Profile with id: " + profile.getId());
        }
        log.info("Update {}", profile);
        profileRepository.save(profile);
    }

    public void deleteProfile(Long id) throws Exception {
        if (!existsById(id)) {
            throw new Exception("Cannot find Profile with id: " + id);
        }
        log.info("Delete {}", getProfileById(id));
        profileRepository.deleteById(id);
    }

    public Profile createProfileFromCsv(MultipartFile uploadCsv) throws Exception {
        return ProfileFromCsv.createProfileFromCsv(uploadCsv);
    }

}
