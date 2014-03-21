package admin.builder.actions.read;

import java.io.IOException;
import java.util.ArrayList;

import utils.ReadIn;
public class ReadUsers {
	/**
	 * Provides methods for reading information about individual users
	 * @author JaminB
	 */
	//Save Variables
	private ArrayList<String> users;
    private ArrayList<String> scoreCache = new ArrayList<String>();
    /**
     * Fetches a list of all users
     * @param compLoc location of competition
     * @param smb true if we are using a remote path
     * @return userList list of all users
     * @throws IOException
     */
	public ArrayList<String> FetchAllUsers(String compLoc, boolean smb) throws IOException{
		String userLoc = compLoc + "/Users.ctf";
        String scoreLoc = compLoc + "/Scores.ctf";
		ReadIn fileData = new ReadIn();
		ArrayList<String> users = fileData.read(userLoc, smb);
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).isEmpty()) users.remove(i);
		}
        scoreCache = new ReadIn().read(scoreLoc,smb);
		this.users = users;
		return this.users;
	}
	/**
	 * Checks whether a user exists in a competition
	 * @param username the name of a user
	 * @param compLoc location of the competition
	 * @param smb true if we are using a remote path
	 * @return true if user exists; false otherwise
	 * @throws IOException
	 */
	public boolean checkExists(String username, String compLoc, boolean smb) throws IOException{
		ArrayList<String> users = FetchAllUsers(compLoc, smb);
		return users.contains(username);
	}
	
	/**
	 * Search for a particular user
	 * @param searchForUser the name of a user
	 * @param compLoc location of the competition
	 * @param smb true if we are using a remote path
	 * @return searchResults the results of the search entered
	 * @throws IOException
	 */
	public ArrayList Search(String searchForUser, String compLoc, boolean smb) throws IOException{
		ArrayList<String> users = FetchAllUsers(compLoc, smb);	
		ArrayList<Integer> matches= new ArrayList<Integer>();
		for(int i = 0; i < users.size(); i++){
			int matchScore = 0;
			for(int j = 0; j < users.get(i).length(); j++){
				if(j < searchForUser.length()){
					if(users.get(i).toLowerCase().charAt(j) == searchForUser.toLowerCase().charAt(j)){
						matchScore++;
					}
				}
			}
			matches.add(matchScore);
			
		}
		ArrayList<Integer> indexList = sortA(users, matches, true);
		ArrayList<String> valueOrderList = sortA(users, matches, false);
		ArrayList<String> results = new ArrayList<String>();
		
		for(int i = 0; i < indexList.size(); i++){
			if(indexList.get(i).intValue() != 0){
				results.add(valueOrderList.get(i));
			}
		}
		return results;
	}
	
	/**
	 * Get the score of a particular user
	 * @param username the name of a user
	 * @param compLoc location of the competition
	 * @param smb true if we are using a remote path
	 * @return score the score associated with a user
	 * @throws IOException
	 */
	public int GetScore(String username, String compLoc, boolean smb) throws IOException{
		String scoresLoc = compLoc + "/Scores.ctf";
		ReadIn fileData = new ReadIn();
		ArrayList<String> scores;
                if(scoreCache.isEmpty()){
                    scores = fileData.read(scoresLoc, smb);
                }
                else{
                    scores = scoreCache;
                }
		
		for(int i = 0; i < scores.size(); i++){
			String[] splitLoc = scores.get(i).split("\\|");
			if(splitLoc[0].equals(username)){
				try{
					return Integer.parseInt(splitLoc[1]);
				}catch(Exception e){
					System.err.println("Corrupted file detected.");
				}
			}
			
		}
		return 0;
	}
	/**
	 * Get the challenges completed by a particular user
	 * @param username the name of a user
	 * @param compLoc location of the competition
	 * @param smb true if we are using a remote path
	 * @return challengesCompletedList the challenges completed by a particular user
	 * @throws IOException
	 */
	public ArrayList<String> GetCompletedChallenges(String username, String compLoc, boolean smb) throws IOException{
		String compComplLoc = compLoc +"/Challenges_Completed.ctf";
		ReadIn fileData = new ReadIn();
		ArrayList<String> compsCompleted = fileData.read(compComplLoc, smb);
		ArrayList<String> markedComplete = new ArrayList<String>();
		for(int i = 0; i < compsCompleted.size(); i++){
			String[] splitLoc = compsCompleted.get(i).split("\\|");
			if(username.equals(splitLoc[0])){
				for(int j = 1; j < splitLoc.length; j++){
					markedComplete.add(splitLoc[j]);
				}
			}
		}
		return markedComplete;
	}
		
	private ArrayList sortA (ArrayList<String> listToSort, ArrayList<Integer> listToSortBy, boolean returnIndexList){ //Double list bubble sort ascending
		for(int i = 0; i < listToSortBy.size(); i++){
			for(int j = 0; j < listToSortBy.size(); j++){
					if(listToSortBy.get(i).intValue() > listToSortBy.get(j).intValue()){
						Integer tempIndex = listToSortBy.get(i);
						String tempData = listToSort.get(i);
						listToSortBy.set(i, listToSortBy.get(j));
						listToSort.set(i, listToSort.get(j));
						listToSortBy.set(j, tempIndex);
						listToSort.set(j, tempData);
					}		
			}
		}
		
		if (!returnIndexList) return listToSort;
		else return listToSortBy;
	}
	
	
	
}
	
