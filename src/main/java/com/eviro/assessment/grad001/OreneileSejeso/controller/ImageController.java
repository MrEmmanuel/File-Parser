package com.eviro.assessment.grad001.OreneileSejeso.controller;

import com.eviro.assessment.grad001.OreneileSejeso.repository.AccountProfile;
import com.eviro.assessment.grad001.OreneileSejeso.repository.AccountProfileRepository;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/v1/api/image")
public class ImageController {

    private final AccountProfileRepository accountProfileRepository;

    public ImageController(AccountProfileRepository accountProfileRepository) {
        this.accountProfileRepository = accountProfileRepository;
    }

    @GetMapping(value = "/{name}/{surname}/{\\w\\.\\w}")
    public FileSystemResource gethttpImageLink(@PathVariable String name, @PathVariable String surname){
        //return the result
        AccountProfile accountProfile = accountProfileRepository.findByNameAndSurname(name, surname);
        if (accountProfile != null) {
            String httpImageLink = accountProfile.getHttpImageLink();
            String imagePath = httpImageLink.replace("images/", "");
            File imageFile = new File(imagePath);

            return new FileSystemResource(imageFile);
        }
        return null;
    }
}
