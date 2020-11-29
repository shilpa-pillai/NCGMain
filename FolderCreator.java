
import java.io.File;

public class FolderCreator {
    public String location;
    public String directoryName;

    public FolderCreator(String location, String directoryName) {
        this.location = location;
        this.directoryName = directoryName;
    }

    public String GenerateFolders() {
        String message = "";

        // make rootDir
        File rootDir = new File(location + directoryName);
        boolean bool = rootDir.mkdir();

        // create the cssDir
        File cssDir = new File(location + directoryName + "//" + "css");
        cssDir.mkdir();

        // create the scriptsDir
        File scriptsDir = new File(location + directoryName + "//" + "scripts");
        scriptsDir.mkdir();

        // create the assetsDir
        File assetsDir = new File(location + directoryName + "//" + "assets");
        assetsDir.mkdir();

        // create the imagesDir
        File imagesDir = new File(location + directoryName + "//" + "assets/images");
        imagesDir.mkdir();

        if (bool) {
            message = "Directory created successfully";
        } else {
            message = "Sorry couldn’t create specified directory";
        }

        return message;
    }
}