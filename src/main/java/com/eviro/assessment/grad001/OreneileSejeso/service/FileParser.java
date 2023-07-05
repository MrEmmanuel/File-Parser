package com.eviro.assessment.grad001.OreneileSejeso.service;

import java.io.File;
import java.net.URI;

public interface FileParser {

    void parseCSV(File csvFile);
    File convertCSVDataToImage(String base64ImageData, String imageFormat);
    URI createImageLink(File fileImage);
}
