package ru.blonred.testtask.crud_on_profiles.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.blonred.testtask.crud_on_profiles.models.Profile;
import ru.blonred.testtask.crud_on_profiles.services.ProfileService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/")
    public String profiles(Model model,
                           @RequestParam(name = "firstName", required = false) String firstName) {
        List<Profile> allProfiles = profileService.getListProfiles(firstName);
        model.addAttribute("profiles", allProfiles);
        return "profiles";
    }

    @GetMapping("/profile/{profileId}")
    public String profileInfo(Model model,
                              @PathVariable Long profileId) {
        model.addAttribute("profile", profileService.getProfileById(profileId));
        return "profile-info";
    }

    @GetMapping("/profile/add")
    public String showAddProfile(Model model) {
        Profile profile = new Profile();
        model.addAttribute("add", true);
        model.addAttribute("profile", profile);
        return "profile-edit";
    }

    @PostMapping("/profile/add")
    public String AddProfile(@ModelAttribute("profile") Profile profile) {
        try {
            Profile newProfile = profileService.saveProfile(profile);
            return "redirect:/profile/" + newProfile.getId();
        } catch (Exception exc) {
            String message = exc.getMessage();
            System.out.println(message);
        }
        return "profiles";
    }

    @GetMapping("/profile/{profileId}/edit")
    public String showEditProfile(Model model,
                                  @PathVariable long profileId) {
        Profile profile = null;
        try {
            profile = profileService.getProfileById(profileId);
        } catch (Exception exc) {
            String message = exc.getMessage();
            System.out.println(message);
        }
        model.addAttribute("add", false);
        model.addAttribute("profile", profile);
        return "profile-edit";
    }

    @PostMapping("/profile/{profileId}/edit")
    public String updateProfile(@PathVariable long profileId,
                                @ModelAttribute("profile") Profile profile) {
        try {
            profile.setId(profileId);
            profileService.updateProfile(profile);
            return "redirect:/profile/" + profile.getId();
        } catch (Exception exc) {
            String message = exc.getMessage();
            System.out.println(message);
        }
        return "profile-edit";
    }

    @PostMapping("/profile/upload")
    public String uploadProfile(@RequestParam("profileCsv") MultipartFile profileCsv) {
        try {
            profileService.saveProfile(profileService.createProfileFromCsv(profileCsv));
        } catch (Exception exc) {
            String message = exc.getMessage();
            System.out.println(message);
        }
        return "redirect:/";
    }

    @PostMapping("/profile/{id}/delete")
    public String deleteProfile(@PathVariable Long id) {
        try {
            profileService.deleteProfile(id);
        } catch (Exception exc) {
            String message = exc.getMessage();
            System.out.println(message);
        }
        return "redirect:/";
    }
}
