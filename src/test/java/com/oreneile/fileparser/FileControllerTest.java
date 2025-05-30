package com.oreneile.fileparser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class FileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFileUploadAndAnalysis() throws Exception {
        String content = "Hello world\nHello again"; // <- real line break
        MockMultipartFile mockFile = new MockMultipartFile(
                "file", "test.txt", "text/plain", content.getBytes()
        );

        mockMvc.perform(multipart("/api/files/upload").file(mockFile))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lineCount").value(2))
                .andExpect(jsonPath("$.wordCount").value(4));
    }

    @Test
    public void testUploadWithoutFile() throws Exception {
        mockMvc.perform(multipart("/api/files/upload"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testEmptyFileUpload() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile(
                "file", "empty.txt", "text/plain", "".getBytes()
        );

        mockMvc.perform(multipart("/api/files/upload").file(mockFile))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Uploaded file is empty"));
    }

    @Test
    public void testLargeFileUpload() throws Exception {
        StringBuilder largeText = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            largeText.append("Line ").append(i).append(" with some words here.\n");
        }

        MockMultipartFile mockFile = new MockMultipartFile(
                "file", "large.txt", "text/plain", largeText.toString().getBytes()
        );

        mockMvc.perform(multipart("/api/files/upload").file(mockFile))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lineCount").value(1000));
    }

    @Test
    public void testUploadWithInvalidContentType() throws Exception {
        MockMultipartFile fakeFile = new MockMultipartFile(
                "file", "fake.exe", "application/octet-stream", "not a text file".getBytes()
        );

        mockMvc.perform(multipart("/api/files/upload").file(fakeFile))
                .andExpect(status().isOk()) // Your app still reads it, but we can log warnings
                .andExpect(jsonPath("$.lineCount").value(1));
    }

}
