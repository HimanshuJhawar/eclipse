package learnOOPS.Interface;

public class Person implements Student , YouTuber{

	public static void main(String[] args) {

		Person obj = new Person();
		obj.study();
		obj.makeVideos();
		
	}

	@Override
	public void study() {

		System.out.println("person is studying");
		
	}

	@Override
	public void makeVideos() {

		System.out.println("person is making a video");
		
	}

}
