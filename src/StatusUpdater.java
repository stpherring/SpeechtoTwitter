import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.Scanner;

public class StatusUpdater {
	public static void main(String[] args){
		System.out.println("Type the status you want to post!");
		System.out.print("@scowalt: ");
		
		// Console Input Stuff
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		
		// Twitter Stuff		
		Twitter twitter = TwitterFactory.getSingleton();
		try {
			twitter.updateStatus(input);
			System.out.println("Successfully updated status!");
		} catch (TwitterException e) {
			//e.printStackTrace();
			System.out.println("TwitterException thrown: " + e);
		}
	}
}
