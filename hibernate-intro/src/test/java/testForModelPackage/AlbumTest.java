package testForModelPackage;



import java.util.List;

import org.junit.Test;

import daoForModel.AlbumDao;
import model.Album;
import model.Songs;

public class AlbumTest {

	@Test
	public void testAddAlbum() {
		Album album=new Album();
		album.setName("Recovery");
		album.setYear(2010);
		album.setCopyright("Aftermath");
		AlbumDao dao=new AlbumDao();
		dao.save(album);
	}
	@Test
	public void testAddSong() {
		AlbumDao dao=new AlbumDao();
		Album album=(Album) dao.fetchById(Album.class, 264);
		Songs song=new Songs();
		song.setSinger("Eminem");
		song.setTitle("Not Afraid");
		song.setDuration(4.08);
		song.setAlbum(album);
		dao.save(song);
	}
@Test
public void testDuration() {
	AlbumDao dao = new AlbumDao();
	List<Songs> songs= (List<Songs>)dao.fetchSongsByDuration(6);
	for(Songs s: songs) {
		System.out.println(s.getDuration());
		System.out.println(s.getId());
		System.out.println(s.getSinger());
		System.out.println(s.getTitle());
	}
	
}
	
}
