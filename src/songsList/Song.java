package songsList;

import java.io.*;
import java.util.*;

/**
 * Compares two Song<?> objects' song name (i.e. songData2) and returns a numeric value.
 * 
 * <p> Wraps a variable of type E as a String therefore it can only compare strings.
 * 
 * @author alvar
 *
 */
class SongComparator implements Comparator<Song<?>>{
	public int compare(Song<?> o1, Song<?> o2) {
		return ((String) o1.songData2).compareTo((String) o2.songData2);
	}
}

/**
 * Compares two Song<?> objects' year values (i.e. songData4) and returns a numeric value.
 * 
 * <p> Wraps a variable of type E as a String therefore it can only compare strings.
 * 
 * @author alvar
 *
 */
class YearComparator implements Comparator<Song<?>>{
	public int compare(Song<?> o1, Song<?> o2) {
		return((String) o1.songData4).compareTo((String) o2.songData4);
	}
}

/**
 * Contains necessary code to read a song list and convert each song and its information as an object
 * to be inserted onto a usable ArrayList or LinkedList. New list's elements can be manipulated via 
 * setters, can be accessed via getters, can be passed as an argument, and can be sorted via comparator.
 * 
 * <p> Contains a bug for setter methods not working with primitive types
 * 
 * @author alvar
 *
 * @param <E>
 */
public class Song<E> {
	
	E songData1, songData2, songData3, songData4; // Instance Variables
	
	public Song() {} // Default Constructor
	
	public Song(E id, E title, E artist, E year) {
		super();
		this.songData1 = id;
		this.songData2 = title;
		this.songData3 = artist;
		this.songData4 = year;
	}
	
	/**
	 * 
	 * GETTERS
	 * 	AND
	 * SETTERS
	 * 
	 */
	public E getSongData1() {
		return songData1;
	}


	public void setSongData1(E id) {
		this.songData1 = id;
	}

	public E getSongData2() {
		return songData2;
	}

	public void setSongData2(E title) {
		this.songData2 = title;
	}

	public E getSongData3() {
		return songData3;
	}

	public void setSongData3(E artist) {
		this.songData3 = artist;
	}

	public E getSongData4() {
		return songData4;
	}

	public void setSongData4(E year) {
		this.songData4 = year;
	}
	
	/**
	 * Prints the first 3 songs of a LinkedList
	 * 
	 * @param list LinkedList of Song objects
	 */
	public static void displayAllSongs(LinkedList<Song<?>> list) {
		for(int i = 0; i < 3; i++) {
			System.out.println(list.getFirst());
			list.removeFirst();
		}
	}
	
	/**
	 * Reads a .txt file song list by using Java I/O and splits the columns
	 * into separate arrays: name, artist, and year. Recompiles them as a Song object
	 * via the for-loop by declaring a new song with the parameters being name[i], artist[i], year[i], and
	 * a randomly generated ID. Song object is then added to a master list named songList
	 * 
	 * @param file A .txt file Song list formatted as ID, Song Name, Artist, Year
	 * @return songList is an ArrayList of Song objects made from file
	 */
	public static ArrayList<Song<?>> readSongs(File file){
		
		ArrayList<Song<?>> songList = new ArrayList<>();
		
		try {
			Scanner scanner = new Scanner(file); 
			
			ArrayList<String> nameList = new ArrayList<>(); // names
			ArrayList<String> artistList = new ArrayList<>(); // artists
			ArrayList<String> yearList = new ArrayList<>(); // years
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] columns = line.split(","); // parameters separated by "," The first column is placeholder IDs
				nameList.add(columns[1]); // add elements of the second column to nameList
				artistList.add(columns[2]); //add elements of the third column to artistList
				yearList.add(columns[3]); // add elements of the fourth column to yearList
			}
			
			for(int i = 0; i < nameList.size(); i++) {
				Song<?> song = new Song<>(randomNumber(),nameList.get(i),artistList.get(i),yearList.get(i)); // combine
				songList.add(song);
			}
			
			scanner.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return songList;
	}

	/**
	 * Reads a .txt file song list by using Java I/O and splits the columns
	 * into separate arrays: name, artist, and year. Recompiles them as a Song object
	 * via the for-loop by declaring a new song with the parameters being name[i], artist[i], year[i], and
	 * a randomly generated ID. Song object is then added to a master list named songList
	 * 
	 * @param file A .txt file Song list formatted as ID, Song Name, Artist, Year
	 * @return songList is an LinkedList of Song objects made from file
	 */
	public static LinkedList<Song<?>> readSongs2(File file) {
		LinkedList<Song<?>> songList = new LinkedList<>();
		
		try {
			Scanner scanner = new Scanner(file);
			
			LinkedList<String> nameList = new LinkedList<>();
			LinkedList<String> artistList = new LinkedList<>();
			LinkedList<String> yearList = new LinkedList<>();
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] columns = line.split(",");
				nameList.add(columns[1]);
				artistList.add(columns[2]);
				yearList.add(columns[3]);
			}
			
			for(int i = 0; i < nameList.size(); i++) {
				Song<?> song = new Song<>(randomNumber(),nameList.get(i),artistList.get(i),yearList.get(i));
				songList.add(song);
			}
			
			scanner.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return songList;
	}
	
	/**
	 * Searches a song given a String key and an ArrayList. The search is unsorted
	 * 
	 * <p> Code is inefficient and can be improved
	 * 
	 * @param key The song that is being searched by iterating through the list
	 * @param unsortedList An unsorted list meant to be iterated over
	 */
	public static void searchSongs(String key, ArrayList<Song<?>> unsortedList) {
		
		boolean keyFound = false;
		int count = 0;
		for(Song<?> e : unsortedList) {
			if(key.equals(e.getSongData2())) {
				keyFound = true;
				break;
			} else {
				count++;
			}
		}
		
		if(keyFound) {
			System.out.println("Song found at position: " + count);
		} else {
			System.out.println("Song not found on list");
		}
	}
	
	/**
	 * Searches a song given 2 String keys and an ArrayList. The search is unsorted
	 * 
	 * <p> Code is inefficient and can be improved
	 * 
	 * @param key The year that is being searched by iterating through the list
	 * @param key2 The song that is being searched by iterating through the list
	 * @param unsortedList An unsorted list meant to be iterated over
	 */
	public static void searchSongs2(Integer key, String key2, ArrayList<Song<?>> unsortedList) {
		boolean keyFound = false;
		int count = 0;
		for(Song<?> e : unsortedList) {
			if(Integer.toString(key).equals(e.getSongData4())) {
				if(key2.equals(e.getSongData2())) {
					keyFound = true;
					break;
				}
			} else {
				count++;
			}
		}
		
		if(keyFound) {
			System.out.println("Song and year found at position: " + count);
		} else {
			System.out.println("Song not found on list");
		}
	}
	
	/**
	 * Randomly generates a number; ANSWERS Q5
	 * @return random int
	 */
	public static int randomNumber() {
		Random rd = new Random();
		return rd.nextInt(999999) + 1000000;
	}
	
	@Override
	public String toString() {
		return "Song [ID=" + songData1 + ", Title=" + songData2 + ", Artist=" + songData3 + ", Year="
				+ songData4 + "]";
	}

	/**
	 * 
	 * MAIN
	 * METHOD
	 * 
	 * Mostly for testing 
	 * 
	 */
	public static void main(String[] args) {
		
		// Q6 IS ANSWERED ASSUMING GENERIC CLASS SONG IS SET UP CORRECTLY
		
		try {
			/*
			 * MAKE SURE TO CHANGE FILE DIRECTORY OF THE SONGLIST .TXT FILE 
			 */
			File file = new File("C:\\Users\\alvar\\eclipse-workspace\\Gendermag\\songList.txt"); // ANSWERS Q3 & Q4
			Scanner scanner = new Scanner(file);
			
			System.out.println("Testing displayAllSongs() method: ");
			displayAllSongs(readSongs2(file)); // ANSWERS Q7
			
			Song<?> song1 = new Song<>(randomNumber(), "Follow Me", "Rocket Boys", 2007); // ANSWERS Q8
			Song<?> song2 = new Song<>(randomNumber(), 2007, "BECK", "Spice of Life"); // Q8
			Song<?> song3 = new Song<>(randomNumber(), "Moon on the Water", 2007, "Koyuki"); //Q8
			
			System.out.println("\nTesting Song methods: ");
			System.out.println(song1.getSongData1()); //Q8
			System.out.println(song2.getSongData2()); //Q8
			System.out.println(song3.getSongData3()); //Q8
			System.out.println(song1.getSongData4()); //Q8
			
			System.out.println("\nTesting readSongs() method: ");
			System.out.println(readSongs(file)); // ANSWERS Q9
			
			System.out.println("\nTesting searchSongs() methods: ");
			searchSongs("Operation Dawnseeker", readSongs(file)); // ANSWERS Q10
			searchSongs2(1982, "Africa", readSongs(file));
			
			ArrayList<Song<?>> list = readSongs(file);
			Collections.sort(list, new SongComparator()); // ANSWERS Q11
			System.out.println("\nSorted Listed by Song Name: ");
			list.forEach(System.out::println);
			
			Collections.sort(list, new YearComparator().thenComparing(new SongComparator())); // Q11
			System.out.println("\nSorted Listed by Year then Song Name: ");
			list.forEach(System.out::println);
			
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}