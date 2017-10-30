/**
 * Hunt the Wumpus
 * @author Justin Mattix and Dax Ewing
 *
 */
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;
public class Main
{
	//all of the player commands
	private static Scanner Actions;
	public static void main(String[] args) throws FileNotFoundException
	{
		Cave player = new Cave();
		System.out.println("Welcome to your Doom!");
		System.out.println("I guess you'll want controls?");
		System.out.println("To move to a cave, enter 'M' and the cave number you would like to go to ");
		System.out.println("To shoot an arrow into a cave, enter 'S' and the case number.");
		player.readCave();
		Actions = new Scanner(System.in);
		while(player.stillAlive() && player.hasWumpus())
		{
			System.out.println(player.currentLocation());
			String Choice = Actions.next();
			int target = Actions.nextInt();
			if(Choice.toLowerCase().charAt(0) == 's' && target >= 1 && target <= 3)
			{
				System.out.println(player.shootArrow(target));
			}
			else if(Choice.toLowerCase().charAt(0) == 'm' && target >=1 && target >= 3)
			{
				System.out.println(player.playerMove(target));
			}
			else
			{
				System.out.print("You walk into a wall, you shake your head... Try Again");
			}
		}
		System.out.println("Game Over");
	}
}

