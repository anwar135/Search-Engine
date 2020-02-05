import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Gather_All_Files extends Engine {

	public static boolean searched = false;
	public static ArrayList<File> myFile = new ArrayList<File> ();

	public static void GatherAll() 
	{
		if(searched == false) 
		{
			int[] count = {0};
			try {
			    Files.walkFileTree(
			            Paths.get("C:\\Users\\" + System.getProperty("user.name")), 
			            new HashSet<FileVisitOption>(Arrays.asList(FileVisitOption.FOLLOW_LINKS)),
			            Integer.MAX_VALUE, new SimpleFileVisitor<Path>() 
			            {
			                @Override
			                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) 
			                throws IOException 
			                {		         
			                	//System.out.println("Visting " + file);
			                    
			                    if(file.toString().endsWith(".txt")) 
			                    {
			                    	myFile.add(file.toFile());
			                    }
			                    
			                    return FileVisitResult.CONTINUE;
			                }
	
			                @Override
			                public FileVisitResult visitFileFailed(Path file, IOException e) throws IOException 
			                {
			                    //System.err.printf("Visiting failed for %s\n", file);
			                    return FileVisitResult.SKIP_SUBTREE;
			                }
	
			                @Override
			                public FileVisitResult preVisitDirectory(Path dir,BasicFileAttributes attrs) 
			                        throws IOException 
			                {
			                    //System.out.printf("About to visit directory %s\n", dir);
			                    return FileVisitResult.CONTINUE;
			                }
			            });
		} catch (IOException e) 
		{
		}	
			searched = true;
		}
		searched = true;
		System.out.println("Finshing Searching");
		Engine.ButtonClicked();
	}
	
	private static void RemoveDublicate(ArrayList<File> file) 
	{
		
	}
	
}
