package songsList;

public interface AJQueue<E> {
	
	public void addSong(E e);
	
	public void deleteAll();
	
	public boolean isEmpty();
	
	public E peekSong();
		
	public void pushSong(E e);
	
	public E removeSong();
	
	public int size();
	
	
	
}
