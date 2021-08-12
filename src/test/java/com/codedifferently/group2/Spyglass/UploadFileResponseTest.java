package com.codedifferently.group2.Spyglass;

import com.codedifferently.group2.Spyglass.Payload.UploadFileResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class UploadFileResponseTest {

    @MockBean
    private UploadFileResponse uploadFileResponse;

    @Test
    void testGetFileName() {
        // Declare new UploadFileResponse object
        UploadFileResponse thisResponse = new UploadFileResponse("New File", "New file.download", "Image", 20L);
        // Set the expected file name
        String expectedFileName = "New File";
        // Get the actual file name
        String actualFileName = thisResponse.getFileName();
        // Test the expected and actual file names
        assert(expectedFileName).equals(actualFileName);
    }

    @Test
    void testSetFileName() {
        // Declare new UploadFileResponse object
        UploadFileResponse thisResponse = new UploadFileResponse("New File", "New file.download", "Image", 20L);
        // Set the expected file name
        String expectedFileName = "New File Name";
        // Get the actual file name
        thisResponse.setFileName(expectedFileName);
        String actualFileName = thisResponse.getFileName();
        // Test the expected and actual file names
        assert(expectedFileName).equals(actualFileName);
    }

    @Test
    void testGetFileDownloadUri() {
        // Declare new UploadFileResponse object
        UploadFileResponse thisResponse = new UploadFileResponse("New File", "New file.download", "Image", 20L);
        // Set the expected file download uri
        String expectedFileDownloadUri = "New file.download";
        // Get the actual file download uri
        String actualFileDownloadUri = thisResponse.getFileDownloadUri();
        // Test the expected and actual file download uri
        assert(expectedFileDownloadUri).equals(actualFileDownloadUri);
    }

    @Test
    void testSetFileDownloadUri() {
        // Declare new UploadFileResponse object
        UploadFileResponse thisResponse = new UploadFileResponse("New File", "New file.download", "Image", 20L);
        // Set the expected file download uri
        String expectedFileDownloadUri = "New file download.download";
        // Get the actual file download uri
        thisResponse.setFileDownloadUri(expectedFileDownloadUri);
        String actualFileDownloadUri = thisResponse.getFileDownloadUri();
        // Test the expected and actual file download uri
        assert(expectedFileDownloadUri).equals(actualFileDownloadUri);
    }

    @Test
    void testGetFileType() {
        // Declare new UploadFileResponse object
        UploadFileResponse thisResponse = new UploadFileResponse("New File", "New file.download", "Image", 20L);
        // Set the expected file type
        String expectedFileType = "Image";
        // Set the actual file type
        String actualFileType = thisResponse.getFileType();
        // Test the expected and actual file types
        assert(expectedFileType).equals(actualFileType);
    }

    @Test
    void testSetFileType() {
        // Declare new UploadFileResponse object
        UploadFileResponse thisResponse = new UploadFileResponse("New File", "New file.download", "Image", 20L);
        // Set the expected file type
        String expectedFileType = "File";
        // Set the actual file type
        thisResponse.setFileType(expectedFileType);
        String actualFileType = thisResponse.getFileType();
        // Test the expected and actual file types
        assert(expectedFileType).equals(actualFileType);
    }

    @Test
    void testGetSize() {
        // Declare new UploadFileResponse object
        UploadFileResponse thisResponse = new UploadFileResponse("New File", "New file.download", "Image", 20L);
        // Set the expected file type
        Long expectedFileSize = 20L;
        // Set the actual file type
        Long actualFileSize = thisResponse.getSize();
        // Test the expected and actual file types
        assert(expectedFileSize).equals(actualFileSize);
    }

    @Test
    void testSetSize() {
        // Declare new UploadFileResponse object
        UploadFileResponse thisResponse = new UploadFileResponse("New File", "New file.download", "Image", 20L);
        // Set the expected file size
        Long expectedFileSize = 30L;
        // Set the actual file size
        thisResponse.setSize(expectedFileSize);
        Long actualFileSize = thisResponse.getSize();
        assert(expectedFileSize).equals(actualFileSize);
    }
}
