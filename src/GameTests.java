import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.junit.Assert;
import org.junit.Test;

public class GameTests {

	@Test
	public void BoardGameTest(){
		BoardGame bg = new BoardGame();
		bg.addPlayer("jimmy", GamePiece.BLUE_BOOT, Location.BALLROOM);
		bg.addPlayer("joe", GamePiece.BLUE_RACER, Location.BALLROOM);
		bg.addPlayer("josh", GamePiece.GREEN_BOOT, Location.BILLIARD_ROOM);
		
		Assert.assertEquals("Incorrect getPlayerGamePiece Method", GamePiece.BLUE_BOOT, bg.getPlayerGamePeice("jimmy"));
		Assert.assertEquals("Incorrect getPlayerWithGamePiece Method", "jimmy", bg.getPlayerWithGamePeice(GamePiece.BLUE_BOOT));
		Assert.assertEquals("Incorrect getPlayersLocation Method", Location.BALLROOM, bg.getPlayersLocation("jimmy"));
	}
}
