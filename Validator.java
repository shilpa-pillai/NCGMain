
import javax.swing.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private StringBuilder commandText = new StringBuilder();
    private String[] args;

    public Validator(String[] args) {
        this.args = args;
    }

    public void CheckArgs() {

        // foldername -b
        if (args[0].length() != 2 && args[0].charAt(0) == '-') {
            System.out.println("Invalid Argument:"+args[0]);
            throw new RuntimeException("Invalid Argument:"+args[0]);
        } else if (args.length <= 3 && args.length > 0) {
            for (String arg : args) {
                this.commandText.append(arg);
            }
        } else {
            System.out.println("Invalid number of Arguments");
            throw new RuntimeException("Invalid number of Arguments");
        }
    }

    public String CheckLocation() {
        String location = "";
        int dashPos = commandText.indexOf("-");

        if (dashPos < 0) {
            location = "";
        } else if (dashPos == 0) {
            location += this.commandText.charAt(0);
            location += this.commandText.charAt(1);
            commandText.delete(dashPos, 2);
        } else {
            location = "";
        }

        switch (location) {
            case "help": { // prints directions
                Help help = new Help();
                help.PrintLocationOptions();
                System.exit(0);
            }
            case "":
            case "-c": { // uses current location
                location = ".//";
                break;
            }
            case "-d": { // documents folder
                location = new JFileChooser().getFileSystemView().getDefaultDirectory().toString() + "\\";
                // System.out.println("from -d");
                break;
            }
            default: { // oops
                System.out.println("Invalid argument:" + location);
                throw new RuntimeException("Invalid argument:" + location);
            }
        } // switch
          // System.out.println("Location is:"+location);
        return location;
    } // CheckLocation()

    public String CheckType() {
        String projectType = "";
        int dashPos = commandText.indexOf("-");

        if (dashPos < 0) {
            projectType = "";
        } else if (dashPos > 0) {
            if ((commandText.length() - 1) > dashPos) {
                projectType = commandText.substring(dashPos, dashPos + 2);
                commandText.delete(dashPos, commandText.length());
            } else {
                Help help = new Help();
                help.PrintTypeOptions();
                System.out.println("this is not fun");
                System.exit(0);
            }
        } else {
            projectType += commandText.charAt(commandText.length() - 2);
            projectType += commandText.charAt(commandText.length() - 1);
            commandText.delete(dashPos, commandText.length());
        }

        switch (projectType) {
            case "":
            case "-b": { // basic folder and files - no design
                projectType = "basic";
                System.out.println("You get a no-frills basic site!");
                break;
            }
            case "-t": { // complete template w design etc...
                projectType = "template";
                System.out.println("You want fries with everything!");
                break;
            }
            default: { // oops
                Help help = new Help();
                help.PrintTypeOptions();
                System.out.println("this is really fun");
                System.exit(0);
            }
        } // switch

        return projectType;
    } // CheckType()

    public String CheckFolder() {
        String directoryName = "";
        String folderName = this.commandText.toString();
        Help help = new Help();
        /******Check is foldername is empty ******/
        if(folderName == null || folderName.length()==0){
            System.out.println("Folder name not provided in arguments");
            throw new RuntimeException("Folder name not provided in arguments");
        }
        // check char[0] not a num
        char firstChar = folderName.charAt(0);
        if (Character.isDigit(firstChar)) {
            help.PrintFolderOptions();
            System.exit(0);
        }

        // check for alphanumeric
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(folderName);

        if (matcher.matches()) {
            directoryName = folderName;
        } else {
            help.PrintFolderOptions();
            System.exit(0);
        }

        return directoryName;
    } // CheckFolder()

} // Validator()