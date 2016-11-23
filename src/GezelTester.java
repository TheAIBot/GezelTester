import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GezelTester {
	public static void main(String[] args) {
		//hardcode all the stuff because i don't want to use too much time on this one
		try {
			String filename1 = args[0];
			String filename2 = args[1];
			
			List<String> fileContent1 = loadFile(filename1);
			List<String> fileContent2 = loadFile(filename2);
			
			for (int i = 0; i < Math.min(fileContent1.size(), fileContent2.size()); i++) {
				if (!fileContent1.get(i).equals(fileContent2.get(i))) {
					throw new Exception("Line " + (i + 1) + "doesn't match\n" + fileContent1.get(i) + "\n" + fileContent2.get(i));
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace(System.out);
		}
		
		
	}
	
	public static List<String> loadFile(String filename) throws Exception
	{
		Path filePath = Paths.get(filename);

		if (!Files.exists(filePath))
		{
			throw new Exception("File " + filename + " doesn't exist");
		}

		return Files.readAllLines(filePath);
	}
}
