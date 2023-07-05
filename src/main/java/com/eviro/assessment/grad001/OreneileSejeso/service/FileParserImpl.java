package com.eviro.assessment.grad001.OreneileSejeso.service;

import com.eviro.assessment.grad001.OreneileSejeso.repository.AccountProfile;
import com.eviro.assessment.grad001.OreneileSejeso.repository.AccountProfileRepository;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URI;
import java.util.Base64;

@Component
public class FileParserImpl implements FileParser {

    private final AccountProfileRepository accountProfileRepository;

    public FileParserImpl(AccountProfileRepository accountProfileRepository) {
        this.accountProfileRepository = accountProfileRepository;
    }

    @Override
    public void parseCSV(File csvFile){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            String line;
            //Loop through the csvfile rows
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 4) {
                    String name = fields[0].trim();
                    String surname = fields[1].trim();
                    String imageFormat = fields[2].trim();
                    String imageData = fields[3].trim();

                    if(name == "name" || surname == "surname" || imageFormat == "imageformat" || imageData == "imageData"){
                        continue;
                    }

                    // Convert base64 image data to a physical file
                    File imageFile = convertCSVDataToImage(imageData, imageFormat);
                    // Create the httpImageLink
                    URI httpImageLink = createImageLink(imageFile);

                    // Create and save the AccountProfile entity
                    AccountProfile accountProfile = new AccountProfile(name, surname, httpImageLink.toString());
                    accountProfileRepository.save(accountProfile);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File convertCSVDataToImage(String base64ImageData, String imageFormat){

        try {
            // Decode the base64 image data
            byte[] imageData = Base64.getDecoder().decode(base64ImageData);

            // Create a unique file name based on timestamp
            String fileName = System.currentTimeMillis() + "." + imageFormat;

            File imageFolder = new File("images/");
            if (!imageFolder.exists()) {
                imageFolder.mkdirs();
            }
            File imageFile = new File("images/" + fileName);
            try (FileOutputStream fos = new FileOutputStream(imageFile)) {
                fos.write(imageData);
            }
            return imageFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public URI createImageLink(File fileImage){
        String imagePath = fileImage.getPath();
        String imageLink = "/v1/api/image/" + imagePath.replace("images/", "");
        return URI.create(imageLink);
    }
}
