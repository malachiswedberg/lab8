/**
 * 
 * @author Malachi Swedberg
 *
 */
public class Driver {
	
	public static void main(String[] args) {
		
		BoardGame bg = new BoardGame();
		
		bg.addPlayer("Jimmy", GamePiece.GREEN_BOOT, Location.CONSERVATORY);
		bg.addPlayer("Kernel Sanders", GamePiece.RED_RACER, Location.KITCHEN);
		bg.addPlayer("Professor White", GamePiece.BLUE_RACER, Location.STUDY);
		bg.addPlayer("Professor Plumb", GamePiece.RED_THIMBLE, Location.CONSERVATORY);
		
		bg.movePlayer("Professor White", Location.HALL);
		bg.moveTwoPlayers(new String[] {"Professor Plumb", "Jimmy"}, new Location[] {Location.DINING_ROOM, Location.HALL});
		
		System.out.println(bg.getPlayersLocations());
		System.out.println(bg.getPlayerPieces());
		System.out.println(bg.getPlayers());
	}
}
