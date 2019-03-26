import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
/**
 * 
 * @author Malachi Swedberg
 *
 */

public class BoardGame {

	protected LinkedHashMap<String, GamePiece> playerPieces;
	
	protected LinkedHashMap<String, Location> playerLocations;
	
	public BoardGame() {
		this.playerPieces = new LinkedHashMap<String, GamePiece>();
		this.playerLocations = new LinkedHashMap<String, Location>();
	}
	
	public boolean addPlayer(String playerName, GamePiece gamePiece, Location initialLocation) {
		if (!this.playerLocations.containsKey(playerName)) {
			this.playerPieces.put(playerName, gamePiece);
			this.playerLocations.put(playerName, initialLocation);
			
			return true;
		}
		
		return false;
	}
	
	public GamePiece getPlayerGamePeice(String playerName) {
		return playerPieces.get(playerName);
	}
	
	public String getPlayerWithGamePeice(GamePiece gamePiece) {
		Set<String> set = playerPieces.keySet();
		String result = null; 
		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()) {
			String next = iter.next();
			if (playerPieces.get(next).equals(gamePiece)) {
				result = next;
			}
		}
		
		return result;
	}
	
	public void movePlayer(String playerName, Location newLocation) {
		playerLocations.put(playerName, newLocation);
	}
	
	public String[] moveTwoPlayers(String[] playerNames, Location[] newLocations) {
		GamePiece first = GamePiece.movesFirst(playerPieces.get(playerNames[0]), playerPieces.get(playerNames[1]));
		String[] result = new String[2];
		
		if (first.name().equals(playerNames[0])) {
			playerLocations.put(playerNames[0], newLocations[0]);
			playerLocations.put(playerNames[1], newLocations[1]);
			result[0] = playerNames[0];
			result[1] = playerNames[1];
		}
		else {
			playerLocations.put(playerNames[1], newLocations[1]);
			playerLocations.put(playerNames[0], newLocations[0]);
			result[0] = playerNames[1];
			result[1] = playerNames[0];
		}
		
		return result;
	}
	
	public Location getPlayersLocation(String player) {
		return playerLocations.get(player);
	}
	
	public ArrayList<String> getPlayersAtLocation(Location loc) {
		Set<String> set = playerLocations.keySet();
		ArrayList<String> result = new ArrayList<String>(); 
		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()) {
			String next = iter.next();
			if (playerLocations.get(next).equals(loc)) {
				result.add(next);
			}
		}
		
		return result;
	}
	
	public ArrayList<GamePiece> getGamePeicesAtLocation(Location loc) {
		Set<String> set = playerLocations.keySet();
		Iterator<String> iter = set.iterator();
		ArrayList<GamePiece> result = new ArrayList<GamePiece>();
		
		while(iter.hasNext()) {
			String next = iter.next();
			if (playerLocations.get(next).equals(loc)) {
				result.add(playerPieces.get(next));
			}
		}
		
		return result;
	}

	public Set<String> getPlayers() {
		Set<String> result = playerLocations.keySet();
		
		return result;
	}
	
	public Set<Location> getPlayersLocations() {
		Set<String> set = playerLocations.keySet();
		Iterator<String> iter = set.iterator();
		
		Set<Location> result = new HashSet<Location>();
		
		while(iter.hasNext()) {
			Location next = playerLocations.get(iter.next());
			if(!result.contains(next)) {
				result.add(next);
			}
		}
		
		return result;
	}
	
	public Set<GamePiece> getPlayerPieces() {
		Set<String> set = playerPieces.keySet();
		Iterator<String> iter = set.iterator();
		
		Set<GamePiece> result = new HashSet<GamePiece>();
		
		while(iter.hasNext()) {
			GamePiece next = playerPieces.get(iter.next());
			if(!result.contains(next)) {
				result.add(next);
			}
		}
		
		return result;
	}
}
