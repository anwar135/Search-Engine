
public class File_Info
{
	private String Title;
	private String Destintation;
	private String Content;

	File_Info(String Title, String Destintation, String Content)
	{
		this.Title = Title;
		this.Destintation = Destintation;
		this.Content = Content;
	}
	
	public String GetTitle() {
		return Title;
	}
	public String Destintation() {
		return Destintation;
	}
	public String Content() {
		return Content;
	}
}
