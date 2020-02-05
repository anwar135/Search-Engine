import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


//This Class will Bring the Backend stuff together and will work directly with the Gui 
public class Engine {
	
	static ArrayList<File_Info> file = new ArrayList<File_Info>();
	
	public static void ButtonClicked() 
	{		
		if(Gather_All_Files.searched == true)
		{
			Main_Gui.Display_InfoTo_User("");
			file = All_ReadableFiles.GetFiles(Main_Gui.SearchText);				
			instantiateFiles(file);		
		}else
		{
			Gather_All_Files.GatherAll();
		}
	}
	
	public static void instantiateFiles(ArrayList<File_Info> file) 
	{   
		if(file.size() == 0) 
		{
			Main_Gui.Display_InfoTo_User("No Match Found");
			return;
		}
		for(File_Info file1 : file) 
		{
			Main_Gui.AddToList(file1.GetTitle());
		}
	}
	
	public static void UpdateDescription(int index) 
	{
		Main_Gui.UpdateDescription(file.get(index).Content());
	}
	
	public static void OpenFile(int index) throws IOException 
	{
        Desktop desktop = Desktop.getDesktop();
        File _file = new File(file.get(index).Destintation());
		desktop.open(_file);
	}
	
}
