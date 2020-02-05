import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

//this class will search the Computer and will find all the readable Files
//Only Reads .txt files for now
public class All_ReadableFiles extends Engine
{

	static ArrayList<File_Info> GetFiles(String Word) 
	{
		Word = Word.toLowerCase();
		
		ArrayList<File_Info> fileinfo = new ArrayList<File_Info> ();
		
		for(File file1 : Gather_All_Files.myFile) 
		{
						
			String FileString = ReadFile(file1);
			FileString = FileString.toLowerCase();
			
			 if(FileString.contains(Word))
			 {
				 File_Info file = new File_Info(file1.getName(), file1.getAbsolutePath(), FileString);
				 fileinfo.add(file);
			 } 
		}
		
		return fileinfo;
	}
	
	//figure out a better way to readFile

	private static String ReadFile(File file) 
	{	
		if(file.length() == 0)
		{		
			return "";		
		}
		Scanner scanner = null;
		
		try 
		{
			scanner = new Scanner(file, StandardCharsets.UTF_8.name());
			String data = scanner.useDelimiter("\\A").next();
			return data;
		} catch (Exception e) 
		{
			//e.printStackTrace();
			return "";
		}finally 
		{
			if (scanner != null)
				scanner.close();
		}

	}
	
}
