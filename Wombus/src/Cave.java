/**
 * @ Justin Mattix and Dax Ewing
 */
import java.io.*;
import java.util.*;
public class Cave
{
	//defining variables
	static File gameFile = new File("Layout");
	private CaveLayout[] caves;
	private CaveLayout currentcave;
	private boolean alive = false;
	boolean gameOver = true;
	List<String> messages;
	int wumpusroom;
	int currentroom;
	int numArrows = 3;
	//making the warning for the caves
	enum Danger 
	    {
	        Wumpus("there's an awful smell"),
	        Bat("you hear a rustling"),
	        Pit("you feel a draft");
	 
	        Danger(String warning) 
	        {
	            this.warning = warning;
	        }
	        final String warning;
	    }

	
	public void readCave() throws FileNotFoundException
	{
	   
		//reading in file
		Scanner input = new Scanner(gameFile);
		int numberofcaves = input.nextInt();
		this.caves = new CaveLayout[numberofcaves];
		for(int i = 1; i <= numberofcaves; i++)
		{
			int cavenumber = input.nextInt();
			int adjacent1 = input.nextInt();
			int adjacent2 = input.nextInt();
			int adjacent3 = input.nextInt();
			this.caves[numberofcaves] = new CaveLayout(cavenumber, adjacent1, adjacent2, adjacent3);
			input.close();
		}	
			this.alive = true;
			this.currentcave =this.caves[0];
			this.currentcave.BeenVisited();
	}

	//getting file
	public void getFile() throws FileNotFoundException
	{
		Scanner s = new Scanner(gameFile);
		while(s.hasNext())
		{
			String result = s.nextLine();
			System.out.println(result);
		}
		s.close();
	}
	//move function
	public String playerMove(int rooms)
	{
		this.currentcave = this.caves[this.currentcave.getAdjacentnum(rooms)];
		this.currentcave.BeenVisited();
		return "OK";
	Object[] links;
	for (int link : links[currentroom]) 
	{
        int cx = rooms[link][0];
        int cy = rooms[link][1];
        if (insideRoom(ex, ey, cx, cy)) 
        {
            int selectedRoom = link;
            break;
        }
	}
    }
	//shoot function
	// don't place hazards close to the starting room
    boolean tooClose(int room) {
        if (currentroom == room)
            return true;
        for (int link : link[currentroom])
            if (room == link)
                return true;
        return false;
    }
 
    void situation() {
        Set<Danger> set = Danger[currentroom];
 
        if (set.contains(Danger.Wumpus)) 
        	{
            messages.add("you've been eaten by the Wumpus");
            gameOver = true;
            } 
        else if (set.contains(Danger.Pit)) 
        	{
            messages.add("you fell into a pit");
            gameOver = true;
            } 
        else if (set.contains(Danger.Bat)) 
        {
            messages.add("a bat dropped you in a random room");
 
            // teleport, but avoid 2 teleports in a row
            do 
            {
                currentcave = rand.nextInt(caves.length);
            } 
            while (Danger[currentroom].contains(Danger.Bat));
 
            // relocate the bat, but not to the player room or a room with a bat
            set.remove(Danger.Bat);
            int newRoom;
            do 
            {
                newRoom = rand.nextInt(caves.length);
            } 
            while (newRoom == currentroom || dangers[newRoom].contains(Danger.Bat));
            dangers[newRoom].add(Danger.Bat);
 
            // re-evaluate
            situation();
 
        } else {
 
            // look around
            for (int link : links[currentroom]) {
                for (Danger danger : dangers[link])
                    messages.add(Danger.warning);
	void shoot(int room) {
        if (dangers[room].contains(Danger.Wumpus)) {
            messages.add("You win! You've killed the Wumpus!");
            gameOver = true;
 
        } else {
            numArrows--;
            if (numArrows == 0) {
                messages.add("You ran out of arrows.");
                gameOver = true;
 
            } else if (rand.nextInt(4) != 0) { // 75 %
                dangers[wumpusroom].remove(Danger.Wumpus);
                wumpusroom = caves[wumpusroom][rand.nextInt(3)];
 
                if (wumpusroom == currentroom) 
                {
                    messages.add("You woke the Wumpus and he ate you");
                    gameOver = true;
                } 
                else 
                {
                    messages.add("You woke the Wumpus and he moved");
                    dangers[wumpusroom].add(Danger.Wumpus);
                }
            }
        }
    }
	//finding the players location
	public String currentLocation()
	{
		String message = "You are now in" + this.currentcave.getCaveNumber();
		for(int i = 0; i < 3; i++)
		{
			CaveLayout adjacentcave = this.caves[this.currentcave.getAdjacentnum(1)];
			if(adjacentcave.BeenVisited())
			{
				message += "/n (" + i + ") " + adjacentcave.getCaveNumber();
			}
		}
		return message;
	}
	
	public boolean stillAlive()
	{
		return this.alive;
	}
	
	public boolean hasWumpus()
	{
		return true;
	}
}

