
import java.io.File;  // Import the File class
import java.io.IOException;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileCreator {
    private ArrayList<String> fc = new ArrayList<String>();
    private String projectType;
    
    public FileCreator(String projectType) {
        this.projectType = projectType;
    } // constructor

    public void ReadFile(String fileDetails) {
        try {
            File file = new File(fileDetails);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fc.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    } // ReadFile()
    
    public void CreateFile(String fileDetails) {
        try {
            File file = new File(fileDetails);
            if (file.createNewFile()) {
                CopyFileContents(file);
                System.out.println("File created: " + file.getName());
            } 
            else {
            System.out.println("File already exists.");
            }
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    } // CreateFile() 

    private void CopyFileContents(File file) throws IOException {
        try (FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw)) {
            bw.newLine();
            for(int i = 0; i < fc.size(); i++) {
                bw.write(fc.get(i));
                bw.newLine();   // add new line, System.lineSeparator()
            }
        }
    } // CopyFileContents()
} // class