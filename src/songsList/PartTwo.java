package songsList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartTwo {
	//This is the Main method I'm using for showing my part of the Assignment
	//GenderMag 2 Part 2 - Aqua Jacinto
	public static void main(String[] args) {
		//Part 7 - Manually adding the first 20 songs.
		SongComparator songComp = new SongComparator();
		AJHeap<Song> songList = new AJHeap<>(songComp);
		/**
		//Adding the First 20 Songs Manually (Ow my wrist)
		songList.addSong(new Song(0,"Operation Dawnseeker","Hypergryph",2022));
		songList.addSong(new Song(1,"Radiant","Hypergrpyh",2021));
		songList.addSong(new Song(2,"Africa","Toto",1982));
		songList.addSong(new Song(3,"Take on Me","a-ha",1985));
		songList.addSong(new Song(4,"September","Greenday",2005));
		songList.addSong(new Song(5,"Everybody Wants to Rule the World","Tears for Fears",1985));
		songList.addSong(new Song(6,"Pine Barrens","Jakey",2022));
		songList.addSong(new Song(7,"Shelter","Porter Robinson",2016));
		songList.addSong(new Song(8,"Money","The Drums",2011));
		songList.addSong(new Song(9,"Here Without You","Three Doors Down",2003));
		songList.addSong(new Song(10,"Mr. Brightside","The Killers",2004));
		songList.addSong(new Song(11,"Hurt","Johnny Cash",2002));
		songList.addSong(new Song(12,"Radioactive","Imagine Dragons",2012)); //I'm judging my partner
		songList.addSong(new Song(13,"Sugar","Maroon",2014));
		songList.addSong(new Song(14,"7 Years","Lukas Graham",2015));
		songList.addSong(new Song(15,"The A Team","Ed Sheeran",2011));
		songList.addSong(new Song(16,"Yellow","Coldplay",2000));
		songList.addSong(new Song(17,"The Nights","Avicii",2014));
		songList.addSong(new Song(18,"Circles","Malone",2019));
		songList.addSong(new Song(19,"Tongue Tied","GROUPLOVE",2011));
		
		//Removing the First 5 Songs Manually
		System.out.println(songList.removeSong() + " Size:" + songList.size());
		System.out.println(songList.removeSong() + " Size:" + songList.size());
		System.out.println(songList.removeSong() + " Size:" + songList.size());
		System.out.println(songList.removeSong() + " Size:" + songList.size());
		System.out.println(songList.removeSong() + " Size:" + songList.size());
		
		*/
		
		//Adding and removing Songs programmatically.
		//I first clear out the list
		songList.deleteAll();
		//I grab the file path on my end.
		try {
			File file = new File("C:\\Users\\ctjac\\git\\GenderMag2\\songList.txt");
			Scanner scanner = new Scanner(file);
			//Reads the File into an arrayList.
			ArrayList<Song<?>> songFile = Song.readSongs(file);
			//Adds the First 20 songs
			for(int i=0;i<20;i++){
				songList.addSong(songFile.get(i));
			}
			//Removing and Printing the first 5 Songs on the Heap.
			for(int i=1;i<=5;i++) {
				//I temporarily commented this out to make sure you only see the output I need.
				//System.out.println(songList.removeSong() + " Size:" + songList.size() );
			}
			
			//Implementing Heap Sort
			//First I output the list of songs unsorted on the Array List.
			songFile.forEach(e -> System.out.println(e.getSongData2()) );
			Song[] songArray = new Song[songFile.size()];
			
			for(int i=0;i<songFile.size();i++) {
				songArray[i] = songFile.get(i);
			}
			
			HeapSort.heapSort(songArray, songComp);
			
			for(int i=0;i<songArray.length;i++) {
				System.out.println(songArray[i]);
			}
			
			scanner.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
