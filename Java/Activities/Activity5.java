package Activities;

public class Activity5 {
	
	public static void main(String[] args)
	{
		String title="Harry Porter";
		Book newNovel=new MyBook();
		newNovel.setTitle(title);
		System.out.println("The title is : "+newNovel.getTitle());
	}

}
