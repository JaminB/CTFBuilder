package admin.builder.actions.read;

import java.io.IOException;
import java.util.ArrayList;
import utils.ReadIn;

public class ReadChallenges {
	/**
	 * @author JaminB
	 */

	private ArrayList<String> cachedChallenges = new ArrayList<String>(); 
	
	/**
	 * Fetch all challenges and their attributes
	 * @param compLoc location of competition
	 * @param smb true if we are using a remote path
	 * @return challengeList list containing list of all challenges
	 * @throws IOException
	 */
    public ArrayList<String> FetchAllChallenges(String compLoc, boolean smb) throws IOException{
	ReadIn fileData = new ReadIn();
            //System.out.println(compLoc + "/Challenges.ctf");
            cachedChallenges = fileData.read(compLoc + "/Challenges.ctf", smb);
            System.out.println("FETCHING ALL CHALLENGES");
            return cachedChallenges;
	}
	/**
	 * Fetch all challenge names
	 * @param compLoc location of competition
	 * @param smb true if we are using a remote path
	 * @return challengeNames list containing names of all challenges
	 * @throws IOException
	 */
	public ArrayList<String> FetchAllNames(String compLoc, boolean smb) throws IOException{
		ArrayList<String> challengeNames = new ArrayList<String>();
                ArrayList<String> fileData;
		if(cachedChallenges.isEmpty()){
                    fileData = FetchAllChallenges(compLoc, smb);
                }
                else{
                    fileData = cachedChallenges;
                }
                
		for(int i = 0; i < fileData.size(); i++){
			String[] splitLoc = fileData.get(i).split("\\|");
			challengeNames.add(splitLoc[0]);
		}
		return challengeNames;
	}
	/**
	 * Fetch all challenge flags
	 * @param compLoc location of competition
	 * @param smb true if we are using a remote path
	 * @return challengeFlags list containing flags of all challenges
	 * @throws IOException
	 */
	public ArrayList<String>FetchAllFlags(String compLoc, boolean smb) throws IOException{
		ArrayList<String> flags = new ArrayList<String>();
		ArrayList<String> fileData;
                if(cachedChallenges.isEmpty()){
                    fileData = FetchAllChallenges(compLoc, smb);
                }
                else{
                    fileData = cachedChallenges;
                }
		try{
			for(int i = 0; i < fileData.size(); i++){
				String[] splitLoc = fileData.get(i).split("\\|");
				flags.add(splitLoc[1]);
			}
		}catch(Exception e){
			System.out.println("No such challenge.");
		}
		return flags;
	}
	/**
	 * Fetch all challenge descriptions
	 * @param compLoc location of competition
	 * @param smb true if we are using a remote path
	 * @return challengeDescriptions list containing descriptions of all challenges
	 * @throws IOException
	 */
	public ArrayList<String> FetchAllDescriptions(String compLoc, boolean smb) throws IOException{
		ArrayList<String> description = new ArrayList<String>();
                ArrayList<String> fileData;
		if(cachedChallenges.isEmpty()){
                    fileData = FetchAllChallenges(compLoc, smb);
                }
                else{
                    fileData = cachedChallenges;
                }
		try{
			for(int i = 0; i < fileData.size(); i++){
				String[] splitLoc = fileData.get(i).split("\\|");
				description.add(splitLoc[2]);
			}
		}catch(Exception e){
			System.out.println("No such challenge");
		}
		return description;
	}
	
	/**
	 * Fetch all challenge values
	 * @param compLoc location of competition
	 * @param smb true if we are using a remote path
	 * @return challengeValues list containing values of all challenges
	 * @throws IOException
	 */
	public ArrayList<String> FetchAllValues(String compLoc, boolean smb) throws IOException{
		ArrayList<String> value = new ArrayList<String>();
		ArrayList<String> fileData;
                if(cachedChallenges.isEmpty()){
                    fileData = FetchAllChallenges(compLoc, smb);
                }
                else{
                    fileData = cachedChallenges;
                }
		try{
			for(int i = 0; i < fileData.size(); i++){
				String[] splitLoc = fileData.get(i).split("\\|");
				value.add(splitLoc[3]);
			}
		}catch(Exception e){
			System.out.println("No such challenge.");
		}
		return value;
	}
	/**
	 * Checks whether a challenge exists or not
	 * @param compLoc location of competition
	 * @param smb true if we are using a remote path
	 * @return challengeName name of the challenge 
	 * @throws IOException
	 */
	public boolean checkExists(String challengeName, String compLoc, boolean smb) throws IOException{
		ArrayList<String> challengeNames = FetchAllNames(compLoc, smb);	
		return challengeNames.contains(challengeName);
	}
	/**
	 * Gets the flag for a particular challenge
	 * @param challengeName name of the challenge
	 * @param compLoc location of competition
	 * @param smb true if we are using a remote path
	 * @return flag the flag associated with a challenge
	 * @throws IOException
	 */
	public String GetFlag(String challengeName, String compLoc, boolean smb) throws IOException{
			ArrayList<String> challengeNames = FetchAllNames(compLoc, smb);
			ArrayList<String> challengeFlags = FetchAllFlags(compLoc, smb);
			try{
				return challengeFlags.get(challengeNames.indexOf(challengeName));
			}catch(Exception e){
				System.out.println("Could not find this challenge.");
				return null;
			}	
		
	}
	/**
	 * Gets the description for a particular challenge
	 * @param challengeName name of the challenge
	 * @param compLoc location of competition
	 * @param smb true if we are using a remote path
	 * @return description the description associated with a challenge
	 * @throws IOException
	 */
	public String GetDescription(String challengeName, String compLoc, boolean smb) throws IOException{
		ArrayList<String> challengeNames = FetchAllNames(compLoc, smb);
		ArrayList<String> challengeDescriptions = FetchAllDescriptions(compLoc, smb);
		try{
			return challengeDescriptions.get(challengeNames.indexOf(challengeName));
		}catch(Exception e){
			System.out.println("Could not find this challenge.");
			return null;
		}	
		
	}
	/**
	 * Gets the value for a particular challenge
	 * @param challengeName name of the challenge
	 * @param compLoc location of competition
	 * @param smb true if we are using a remote path
	 * @return description the description associated with a challenge
	 * @throws IOException
	 */
	public String GetValues(String challengeName, String compLoc, boolean smb) throws IOException{
		ArrayList<String> challengeNames = FetchAllNames(compLoc, smb);
		ArrayList<String> challengeValues = FetchAllValues(compLoc, smb);
		try{
			return challengeValues.get(challengeNames.indexOf(challengeName));
		}catch(Exception e){
			System.out.println("Could not find this challenge.");
			return null;
		}	
	}
	/**
	 * Search for a particular challenge
	 * @param searchForChallenge challenge to search for
	 * @param compLoc location of competition
	 * @param smb true if we are using a remote path
	 * @return searchResultsList the results of the search entered
	 * @throws IOException
	 */
	public ArrayList Search(String searchForChallenge, String compLoc, boolean smb) throws IOException{
		ArrayList<String> challenges = FetchAllNames(compLoc, smb);	
		ArrayList<Integer> matches= new ArrayList<Integer>();
		for(int i = 0; i < challenges.size(); i++){
			int matchScore = 0;
			for(int j = 0; j < challenges.get(i).length(); j++){
				if(j < searchForChallenge.length()){
					if(challenges.get(i).toLowerCase().charAt(j) == searchForChallenge.toLowerCase().charAt(j)){
						matchScore++;
					}
				}
			}
			matches.add(matchScore);
			
		}
		ArrayList<Integer> indexList = sortA(challenges, matches, true);
		ArrayList<String> valueOrderList = sortA(challenges, matches, false);
		ArrayList<String> results = new ArrayList<String>();
		
		for(int i = 0; i < indexList.size(); i++){
			if(indexList.get(i).intValue() != 0){
				results.add(valueOrderList.get(i));
			}
		}
		return results;
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
