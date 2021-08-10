package com.codedifferently.group2.Spyglass.Exceptions;


/**
 * FileStorageException is a Custom exception that indicates an issue with file storage
 */
public class FileStorageException extends RuntimeException {
    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
