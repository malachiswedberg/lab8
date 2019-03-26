import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.junit.Assert;
import org.junit.Test;

public class GameTests {

	@SuppressWarnings("serial")
	@Test
	public void BoardGameTest(){
		BoardGame bg = new BoardGame();
		bg.addPlayer("jimmy", GamePiece.BLUE_BOOT, Location.BALLROOM);
		bg.addPlayer("joe", GamePiece.BLUE_RACER, Location.BALLROOM);
		bg.addPlayer("josh", GamePiece.GREEN_BOOT, Location.BILLIARD_ROOM);
		
		Assert.assertEquals("Incorrect getPlayerGamePiece Method", GamePiece.BLUE_BOOT, bg.getPlayerGamePeice("jimmy"));
		Assert.assertEquals("Incorrect getPlayerWithGamePiece Method", "jimmy", bg.getPlayerWithGamePeice(GamePiece.BLUE_BOOT));
		Assert.assertEquals("Incorrect getPlayersLocation Method", Location.BALLROOM, bg.getPlayersLocation("jimmy"));
		Assert.assertEquals("Incorrect getPlayersAtLocation Method", new ArrayList<String>() {
			{	
				add("jimmy");
				add("joe");
			}
		}, bg.getPlayersAtLocation(Location.BALLROOM));
		
		Assert.assertEquals("Incorrect getGamePiecesAtLocation Method", new ArrayList<GamePiece>() {
			{
				add(GamePiece.BLUE_BOOT);
				add(GamePiece.BLUE_RACER);
			}
		}, bg.getGamePeicesAtLocation(Location.BALLROOM));
		
		Assert.assertEquals("Incorrect getPlayers Method", new LinkedHashSet<String>() {
			{
				add("jimmy");
				add("joe");
				add("josh");
			}
		}, bg.getPlayers());
		
		Assert.assertEquals("Incorrect getPlayersLocations Method", new LinkedHashSet<Location>() {
			{
				add(Location.BALLROOM);
				add(Location.BILLIARD_ROOM);
			}
		}, bg.getPlayersLocations());

		Assert.assertEquals("Incorrect getPlayersPieces Method", new LinkedHashSet<GamePiece>() {
			{
				add(GamePiece.BLUE_BOOT);
				add(GamePiece.BLUE_RACER);
				add(GamePiece.GREEN_BOOT);
			}
		}, bg.getPlayerPieces());
		
		String[] a = {"josh", "joe"};
		Location[] b = {Location.CONSERVATORY, Location.CONSERVATORY};
		bg.movePlayer("jimmy", Location.BILLIARD_ROOM);
		bg.moveTwoPlayers(a, b);
		
		Assert.assertEquals("Incorrect movePlayer method", Location.BILLIARD_ROOM, bg.getPlayersLocation("jimmy"));
		Assert.assertEquals("Incorrect moveTwoPlayers method, or getPlayersAtLocation method", new ArrayList<String>(){
			{
				add("joe");
				add("josh");
			}
		}, bg.getPlayersAtLocation(Location.CONSERVATORY));
	}

	@Test
	public void GamePieceTest() {
		Assert.assertEquals(Color.BLUE, GamePiece.BLUE_BOOT.getColor());
		Assert.assertEquals(Shape.BOOT, GamePiece.BLUE_BOOT.getShape());
		Assert.assertEquals("RED_RACER: a RED RACECAR with priority 0", GamePiece.RED_RACER.toString());
	}

	@Test
	public void colorTest() {
		Assert.assertEquals(255, Color.RED.getR());
		Assert.assertEquals(0, Color.RED.getG());
		Assert.assertEquals(0, Color.RED.getB());
	}
}
