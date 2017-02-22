import java.io.File;

public class Main {

	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("Error: Invalid parameters!");
			System.out.println("Correct usage: java -jar <jarname.jar> <classpath> <outputfilename>");
			System.out.println("Note:\t\tClasspath has to be relative.\n\t\toutfilename should not contain extension");
		}
		Parser parser = new Parser();
		UMLGenerator umlGenerator = new UMLGenerator();
		File folder = new File(args[0]);
		if(folder == null || !folder.isDirectory()) {
			System.out.println("Unable to read java files from "+ args[0]+". Please check classpath again!");
			return;
		}
		PackageStructure ps = parser.parsePackage(folder);
		umlGenerator.generateUML(ps, args[1]);
	}
}