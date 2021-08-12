package com.codedifferently.group2.Spyglass.Payload;

/**
 *
 */
public class UploadFileResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    /**
     * @return string of file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return a uri in the form of a string to download the file
     */
    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    /**
     * @param fileDownloadUri
     */
    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    /**
     * @return a string detailing the file type
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * @param fileType
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * @return the file size in a long data type
     */
    public long getSize() {
        return size;
    }

    /**
     * @param size
     */
    public void setSize(long size) {
        this.size = size;
    }
}
