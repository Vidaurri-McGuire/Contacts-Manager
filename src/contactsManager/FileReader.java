package contactsManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class FileReader{
private String directoryName;
private String fileName;

private Path directoryPath;
private Path filePath;
public List<String> fileLines;

    // Constructor
    public FileReader(String directoryName, String fileName) throws IOException {
        this.directoryName = directoryName;
        this.fileName = fileName;

        this.directoryPath = Paths.get(directoryName);
        this.filePath = Paths.get(directoryName, fileName);

        if (Files.notExists(this.filePath)){
            try {
                Files.createFile(this.filePath);
            } catch (IOException e){
                throw new IOException("Unable to create file. (" + this.fileName + ")!");
            }
        }
        System.out.println(filePath);
        this.fileLines = Files.readAllLines(this.filePath);
    }


    public String getDirectoryName(){ return directoryName;}
    public void setDirectoryName(String directoryName){
        this.directoryName = directoryName;
    }


    //  Getters/Setters
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Path getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(Path directoryPath) {
        this.directoryPath = directoryPath;
    }

    public Path getFilePath() {
        return filePath;
    }

    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }

    public List<String> getFileLines() {
        return fileLines;
    }

    public void setFileLines(List<String> fileLines) {
        fileLines = fileLines;
    }

}

