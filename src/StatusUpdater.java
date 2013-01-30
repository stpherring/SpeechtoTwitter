import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;
import java.util.Scanner;

public class StatusUpdater {
	//this scanner will deal with console input
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.println("What do you want to do? (post/read)");
		
		String input = scanner.nextLine();
		
		switch(input){
			case ("post") :
				post();
				break;
			case ("read") :
				read();
				break;
			default :
				System.out.println("Didn't recognize command");
				break;
		}
	}
	
	public static void post(){
		Twitter twitter = TwitterFactory.getSingleton();
		
		try{
			// Print Stuff
			System.out.println("Type the status you want to post!");
			System.out.print("@" + twitter.getScreenName() + ": ");
		
			// Console Input Stuff
			String input = scanner.nextLine();
		
			// Twitter Stuff
			twitter.updateStatus(input);
			System.out.println("Successfully updated status!");
		} catch (TwitterException e) {
			//e.printStackTrace();
			System.out.println("TwitterException thrown: " + e);
		}
	}
	
	public static void read(){
		Twitter twitter = TwitterFactory.getSingleton();
		try {
			List<Status> statuses = twitter.getUserTimeline();
			String user = "@" + twitter.getScreenName();
			System.out.println("Most recent tweet from " + user +":");
			String text = statuses.get(0).getText();
			System.out.println(text);
		} catch (TwitterException e) {
			e.printStackTrace();
			System.out.println("Failed to get Timeline");
		}
		
		
	}
}
