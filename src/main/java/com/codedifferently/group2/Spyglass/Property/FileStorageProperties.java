package com.codedifferently.group2.Spyglass.Property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 */
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;

    /**
     * @return a string of the upload directory (goal-photos)
     */
    public String getUploadDir() {
        return uploadDir;
    }

    /**
     * @param uploadDir
     */
    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
