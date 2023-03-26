package ru.blonred.testtask.webDataAnkets.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.blonred.testtask.webDataAnkets.models.Anket;
import ru.blonred.testtask.webDataAnkets.services.AnketService;

@Controller
@RequiredArgsConstructor
public class AnketController {
    private final AnketService anketService;


    @GetMapping("/")
    public String ankets(@RequestParam(name = "firstName", required = false) String firstName, Model model) {
        model.addAttribute("ankets", anketService.listAnkets(firstName));
        return "ankets";
    }

    @GetMapping("/anket/{id}")
    public String anketInfo(@PathVariable Long id, Model model){
        model.addAttribute("anket", anketService.getAnketById(id));
        return "anket-info";
    }

    @PostMapping("/anket/create")
    public String createAnket(Anket anket) {
        anketService.saveAnket(anket);
        return "redirect:/";
    }

    @PostMapping("/anket/upload")
    public String uploadAnket(@RequestParam("anketCsv") MultipartFile anketCsv) {
        anketService.saveAnket(anketService.createAnketFromCsv(anketCsv));
        return "redirect:/";
    }

    @PostMapping("/anket/delete/{id}")
    public String deleteAnket(@PathVariable Long id) {
        anketService.deleteAnket(id);
        return "redirect:/";
    }
}
