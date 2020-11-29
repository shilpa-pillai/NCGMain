
public class Help {
    public Help() { } // Constructor

    public void PrintLocationOptions() {
        System.out.println("Directory Options:");
        System.out.println("-c : creates directory in current location");
        System.out.println("-d : creates directory in your documents folder\n");
    } // PrintLocationOptions()

    public void PrintFolderOptions() {
        System.out.println("Folder Name Options:");
        System.out.println("Folders cannot begin with a number.");
        System.out.println("and cannot have spaces or symbols!");
    }

    public void PrintTypeOptions() {
        System.out.println("Site/files Options:");
        System.out.println("-b : creates a basic site with index.html app.css app.js files.");
        System.out.println("-t : creates a site template with all files and default layout.");
    } // PrintTypeOptions()
} // Help()