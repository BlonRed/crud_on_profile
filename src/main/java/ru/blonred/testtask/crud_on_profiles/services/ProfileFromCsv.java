package ru.blonred.testtask.crud_on_profiles.services;

import org.springframework.web.multipart.MultipartFile;
import ru.blonred.testtask.crud_on_profiles.models.Profile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProfileFromCsv {
    private static Profile newProfileFromCsv;
    public static Profile createProfileFromCsv(MultipartFile uploadCsv) {
        newProfileFromCsv = new Profile();
        List<String[]> listFromCsv = getListColumnFromCsv(uploadCsv);
        for (String[] currentColumn : listFromCsv) {
            setValueFromColumnInProfile(currentColumn);
        }
        return newProfileFromCsv;
    }

    private static List<String[]> getListColumnFromCsv(MultipartFile csv) {
        List<String[]> listColumnFromCsv = new ArrayList<>();
        try {
            String line;
            InputStream is = csv.getInputStream();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                while ((line = br.readLine()) != null) {
                    listColumnFromCsv.add(line.trim().split(";"));
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return listColumnFromCsv;
    }

    private static void setValueFromColumnInProfile(String[] column) {
        String nameColumn = column[0].replaceAll("\\W", "");
        String value = column[1];
        switch (nameColumn.toLowerCase()) {
            case "firstname":
                newProfileFromCsv.setFirstName(value);
                break;
            case "lastname":
                newProfileFromCsv.setLastName(value);
                break;
            case "country":
                newProfileFromCsv.setCountry(value);
                break;
            case "city":
                newProfileFromCsv.setCity(value);
                break;
            case "dateb":
                newProfileFromCsv.setDateB(value);
                break;
            case "mail":
                newProfileFromCsv.setMail(value);
                break;
            default:
                throw new RuntimeException("Illegal Value of Column in \".csv\" file: " + value);
        }
    }
}
