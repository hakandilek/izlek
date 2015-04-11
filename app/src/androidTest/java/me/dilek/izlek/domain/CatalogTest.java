package me.dilek.izlek.domain;

import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Iterator;

/**
 * Test case for catalogs
 * <p/>
 * Created by Hakan Dilek on 11.04.15.
 */
@RunWith(AndroidJUnit4.class)
public class CatalogTest extends AndroidTestCase {

    @Test
    public void testCatalog() {
        Catalog cat = new Catalog();
        assertNotNull(cat.getTvShows());
        assertEquals(20, cat.getTvShows().size());
    }

    @Test
    public void testTvShows() throws Exception {
        Catalog cat = new Catalog();
        cat.addTvShow(new TvShow("test.1", "test.2", "test.3", 42));
        assertEquals(21, cat.getTvShows().size());
        assertEquals("test.1", cat.getTvShowById("test.1").getTitle());
        assertEquals("test.2", cat.getTvShowById("test.1").getPoster());
        assertEquals("test.3", cat.getTvShowById("test.1").getFanArt());
        assertEquals(42, cat.getTvShowById("test.1").getNumberOfSeasons());
        assertNotNull(cat.getTvShowById("test.1").getSeasons());
    }


    @Test
    public void testEpisode() throws Exception {
        Catalog cat = new Catalog();
        TvShow show = new TvShow("test.1", "test.2", "test.3", 42);
        show.addEpisode(1, 1, "test.41", "test.51");
        show.addEpisode(1, 2, "test.42", "test.52");
        show.addEpisode(2, 1, "test.43", "test.53");
        show.addEpisode(2, 2, "test.44", "test.54");
        cat.addTvShow(show);
        assertNotNull(cat.getTvShowById("test.1").getEpisodes());
        assertEquals(4, cat.getTvShowById("test.1").getEpisodes().size());
        Iterator<Episode> episodes = cat.getTvShowById("test.1").getEpisodes().iterator();
        assertNotNull(episodes);
        assertTrue(episodes.hasNext());
        Episode ep = episodes.next();
        assertNotNull(ep);
        assertEquals("test.41", ep.getTitle());
        assertEquals("test.51", ep.getPublishDate());
        assertEquals(1, ep.getNumber());
        assertTrue(episodes.hasNext());
        ep = episodes.next();
        assertNotNull(ep);
        assertEquals("test.42", ep.getTitle());
        assertEquals("test.52", ep.getPublishDate());
        assertEquals(2, ep.getNumber());
        assertTrue(episodes.hasNext());
        ep = episodes.next();
        assertNotNull(ep);
        assertEquals("test.43", ep.getTitle());
        assertEquals("test.53", ep.getPublishDate());
        assertEquals(1, ep.getNumber());
        assertTrue(episodes.hasNext());
        ep = episodes.next();
        assertNotNull(ep);
        assertEquals("test.44", ep.getTitle());
        assertEquals("test.54", ep.getPublishDate());
        assertEquals(2, ep.getNumber());
    }


}
