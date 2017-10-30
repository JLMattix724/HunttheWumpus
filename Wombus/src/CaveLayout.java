/**
 * 
 * @author Justin Mattix and Dax Ewing
 *
 */
public class CaveLayout extends java.lang.Object
{
	//having the layout for the dungeon of the wumpus
	private int cavenumber;
	private int adjacent1;
	private int adjacent2;
	private int adjacent3;
	
	private boolean visited = false;
	
	public CaveLayout(int cavenumber, int adjacent1, int adjacent2, int adjacent3)
	{
		this.cavenumber = cavenumber;
		this.adjacent1 = adjacent1;
		this.adjacent2 = adjacent2;
		this.adjacent3 = adjacent3;
	}
	
	public int getCaveNumber()
	{
		return cavenumber;
	}
	
	public int getAdjacentnum(int room)
	{
		return 0;
	}
	
	public boolean hasBeenVisited()
	{
		return visited;
	}
	
	public void setContents()
	{
		
	}
	
	public boolean BeenVisited()
	{
		return visited = true;
	}
	
}
