package ru.blonred.testtask.webDataAnkets.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.blonred.testtask.webDataAnkets.models.Anket;
import ru.blonred.testtask.webDataAnkets.repositories.AnketRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnketService {
    private final AnketRepository anketRepository;

    public List<Anket> listAnkets(String firstName) {
        if (firstName != null && !firstName.isEmpty()) return anketRepository.findByFirstName(firstName);
        return anketRepository.findAll();
    }

    public void saveAnket(Anket anket) {
        log.info("Saving new{}", anket);
        anketRepository.save(anket);
    }

    public Anket createAnketFromCsv(MultipartFile uploadCsv) {
        Anket newAnketCsv = new Anket();
        List<String> listFromCsv = getListFromCsv(uploadCsv);
        for (int i = 0; i < listFromCsv.size(); i++) {
            String current = listFromCsv.get(i);
            current = current.trim();
            String[] line = current.split(";");
            setDataInAnket(i, line[1], newAnketCsv);
        }
        return newAnketCsv;
    }

    public void deleteAnket(Long id) {
        anketRepository.deleteById(id);
    }

    public Anket getAnketById(Long id) {
        return anketRepository.findById(id).orElse(null);
    }

    public List<String> getListFromCsv(MultipartFile csv) {

        List<String> result = new ArrayList<>();
        try {
            String line;
            InputStream is = csv.getInputStream();
            try( BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                while ((line = br.readLine()) != null) {
                    result.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public void setDataInAnket (int count, String value, Anket newAnket){
        switch (count){
            case 0:
                newAnket.setFirstName(value);
                break;
            case 1:
                newAnket.setLastName(value);
                break;
            case 2:
                newAnket.setCountry(value);
                break;
            case 3:
                newAnket.setCity(value);
                break;
            case 4:
                newAnket.setDateB(value);
                break;
            case 5:
                newAnket.setMail(value);
                break;
        }
    }
}
