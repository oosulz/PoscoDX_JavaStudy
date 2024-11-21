package chapter03;

public class SongTest {
	public static void main(String[] args) {
		
		Song song = new Song("아이유","좋은날","Real","2010","이민수",3);
		
		//song.setAlbum("Real");
		//song.setArtist("아이유");
		//song.setComposer("이민수");
		//song.setTitle("좋은날");
		//song.setYear("2010");
		//song.setTrack(3);
		
		song.show();
		
		Song song2 = new Song("New Jeans", "ditto");
		song2.show();
	
	}
	
}
