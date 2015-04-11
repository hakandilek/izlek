package me.dilek.izlek.domain;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;

import java.util.LinkedHashSet;
import java.util.Set;

@EBean(scope = Scope.Singleton)
public class Catalog {

    private final Set<TvShow> tvShows;

    public Catalog() {
        this.tvShows = new LinkedHashSet<>();

        TvShow tvShow = new TvShow(
                "Breaking Bad",
                "http://thetvdb.com/banners/_cache/posters/81189-22.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/81189-21.jpg",
                5);
        tvShow.addEpisode(1, 1, "Pilot", "2008-01-20");
        tvShow.addEpisode(1, 2, "Cat's in the Bag...", "2008-01-27");
        tvShow.addEpisode(1, 3, "...And the Bag's in the River", "2008-02-10");
        tvShow.addEpisode(1, 4, "Cancer Man", "2008-02-17");
        tvShow.addEpisode(1, 5, "Gray Matter", "2008-02-24");
        tvShow.addEpisode(1, 6, "Crazy Handful of Nothin'", "2008-03-02");
        tvShow.addEpisode(1, 7, "A No-Rough-Stuff-Type Deal'", "2008-03-09");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "Marvel's Agents of S.H.I.E.L.D.",
                "http://thetvdb.com/banners/_cache/posters/263365-3.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/263365-4.jpg",
                1);
        tvShow.addEpisode(1, 1, "Pilot", "2013-09-24");
        tvShow.addEpisode(1, 2, "0-8-4", "2013-10-01");
        tvShow.addEpisode(1, 3, "The Asset", "2013-10-08");
        tvShow.addEpisode(1, 4, "Eye Spy", "2013-10-15");
        tvShow.addEpisode(1, 5, "Girl in the Flower Dress", "2013-10-22");
        tvShow.addEpisode(1, 6, "F.Z.Z.T.", "2013-11-05");
        tvShow.addEpisode(1, 7, "The Hub", "2013-11-12");
        tvShow.addEpisode(1, 8, "The Well", "2013-11-19");
        tvShow.addEpisode(1, 9, "Repairs", "2013-11-26");
        tvShow.addEpisode(1, 10, "The Bridge", "2013-12-10");
        tvShow.addEpisode(1, 11, "The Magical Place", "2014-01-07");
        tvShow.addEpisode(1, 12, "Seeds", "2014-01-14");
        tvShow.addEpisode(1, 13, "T.R.A.C.K.S.", "2014-02-04");
        tvShow.addEpisode(1, 14, "T.A.H.I.T.I.", "2014-03-04");
        tvShow.addEpisode(1, 15, "Yes Men", "2014-03-11");
        tvShow.addEpisode(1, 16, "End of the Beginning", "2014-04-01");
        tvShow.addEpisode(1, 17, "Turn, Turn, Turn", "2014-04-08");
        tvShow.addEpisode(1, 18, "Providence", "2014-04-15");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "Lost",
                "http://thetvdb.com/banners/_cache/posters/73739-7.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/73739-20.jpg",
                6);
        tvShow.addEpisode(1, 1, "Pilot (1)", "2004-09-22");
        tvShow.addEpisode(1, 2, "Pilot (2)", "2004-09-29");
        tvShow.addEpisode(1, 3, "Tabula Rasa", "2004-10-06");
        tvShow.addEpisode(1, 4, "Walkabout", "2004-10-13");
        tvShow.addEpisode(1, 5, "White Rabbit", "2004-10-20");
        tvShow.addEpisode(1, 6, "House of the Rising Sun", "2004-10-27");
        tvShow.addEpisode(1, 7, "The Moth", "2004-11-03");
        tvShow.addEpisode(1, 8, "Confidence Man", "2004-11-10");
        tvShow.addEpisode(1, 9, "Solitary", "2004-11-17");
        tvShow.addEpisode(1, 10, "Raised by Another", "2004-12-01");
        tvShow.addEpisode(1, 11, "All the Best Cowboys Have Daddy Issues",
                "2004-12-08");
        tvShow.addEpisode(1, 12, "Whatever the Case May Be the Case May Be",
                "2005-01-05");
        tvShow.addEpisode(1, 13, "Hearts and Minds", "2005-01-12");
        tvShow.addEpisode(1, 14, "Special", "2005-01-19");
        tvShow.addEpisode(1, 15, "Homecoming", "2005-02-09");
        tvShow.addEpisode(1, 16, "Outlaws", "2005-02-16");
        tvShow.addEpisode(1, 17, "...In Translation", "2005-02-23");
        tvShow.addEpisode(1, 18, "Numbers", "2005-03-02");
        tvShow.addEpisode(1, 19, "Deus Ex Machina", "2005-03-30");
        tvShow.addEpisode(1, 20, "Do No Harm", "2005-04-06");
        tvShow.addEpisode(1, 21, "The Greater Good (a.k.a. Sides)",
                "2005-05-04");
        tvShow.addEpisode(1, 22, "Born to Run", "2005-05-11");
        tvShow.addEpisode(1, 23, "Exodus (1)", "2005-05-18");
        tvShow.addEpisode(1, 24, "Exodus (2)", "2005-05-25");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "Arrow",
                "http://thetvdb.com/banners/_cache/posters/257655-5.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/257655-16.jpg",
                2);
        tvShow.addEpisode(1, 1, "Pilot", "2012-10-10");
        tvShow.addEpisode(1, 2, "Honor Thy Father", "2012-10-17");
        tvShow.addEpisode(1, 3, "Lone Gunmen", "2012-10-24");
        tvShow.addEpisode(1, 4, "An Innocent Man", "2012-10-31");
        tvShow.addEpisode(1, 5, "Damaged", "2012-11-07");
        tvShow.addEpisode(1, 6, "Legacies", "b2012-11-14");
        tvShow.addEpisode(1, 7, "Muse of Fire", "2012-11-28");
        tvShow.addEpisode(1, 8, "Vendetta", "2012-12-05");
        tvShow.addEpisode(1, 9, "Year's End", "2012-12-12");
        tvShow.addEpisode(1, 10, "Burned", "2013-01-16");
        tvShow.addEpisode(1, 11, "Trust But Verify", "2013-01-23");
        tvShow.addEpisode(1, 12, "Vertigo", "2013-02-06");
        tvShow.addEpisode(1, 13, "Betrayal", "2013-02-06");
        tvShow.addEpisode(1, 14, "The Odyssey", "2013-02-13");
        tvShow.addEpisode(1, 15, "Dodger", "2013-02-20");
        tvShow.addEpisode(1, 16, "Dead to Rights", "2013-02-27");
        tvShow.addEpisode(1, 17, "The Huntress Returns", "2013-03-20");
        tvShow.addEpisode(1, 18, "Salvation", "2013-03-27");
        tvShow.addEpisode(1, 19, "Unfinished Business", "2013-04-03");
        tvShow.addEpisode(1, 20, "Home Invasion", "2013-04-24");
        tvShow.addEpisode(1, 21, "The Undertaking", "2013-05-01");
        tvShow.addEpisode(1, 22, "Darkness on the Edge of Town", "2013-05-08");
        tvShow.addEpisode(1, 23, "Sacrifice", "2013-05-15");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "The Newsroom",
                "http://thetvdb.com/banners/_cache/posters/76399-1.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/76399-1.jpg",
                3);
        tvShow.addEpisode(1, 1, "The Walking Shoe Incident", "1996-10-21");
        tvShow.addEpisode(1, 2, "Dinner at Eight", "1996-10-28");
        tvShow.addEpisode(1, 3, "Deeper, Deeper", "1996-11-04-11-04");
        tvShow.addEpisode(1, 4, "The Kevorkian Joke", "1996-11-11");
        tvShow.addEpisode(1, 5, "A Bad Day", "1996-11-18");
        tvShow.addEpisode(1, 6, "Petty Tyranny", "1996-11-25");
        tvShow.addEpisode(1, 7, "Dis and Dat", "1997-02-10");
        tvShow.addEpisode(1, 8, "Unity", "1997-02-17");
        tvShow.addEpisode(1, 9, "Parking", "1997-02-24");
        tvShow.addEpisode(1, 10, "Meltdown (1)", "1997-03-03");
        tvShow.addEpisode(1, 11, "Meltdown (2)", "1997-03-17");
        tvShow.addEpisode(1, 12, "Meltdown (3)", "1997-03-24");
        tvShow.addEpisode(1, 13, "The Campaign", "1997-03-31");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "How I Met Your Mother",
                "http://thetvdb.com/banners/_cache/posters/75760-29.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/75760-51.jpg",
                9);
        tvShow.addEpisode(1, 1, "Pilot", "2005-09-19");
        tvShow.addEpisode(1, 2, "Purple Giraffe", "2005-09-26");
        tvShow.addEpisode(1, 3, "Sweet Taste of Liberty", "2005-10-03");
        tvShow.addEpisode(1, 4, "Return of the Shirt", "2005-10-10");
        tvShow.addEpisode(1, 5, "Okay Awesome", "2005-10-17");
        tvShow.addEpisode(1, 6, "Slutty Pumpkin", "2005-10-24");
        tvShow.addEpisode(1, 7, "Matchmaker", "2005-11-07");
        tvShow.addEpisode(1, 8, "The Duel", "2005-11-14");
        tvShow.addEpisode(1, 9, "Belly Full of Turkey", "2005-11-21");
        tvShow.addEpisode(1, 10, "The Pineapple Incident", "2005-11-28");
        tvShow.addEpisode(1, 11, "The Limo", "2005-12-19");
        tvShow.addEpisode(1, 12, "The Wedding", "2006-01-09");
        tvShow.addEpisode(1, 13, "Drumroll, Please", "2006-01-23");
        tvShow.addEpisode(1, 14, "Zip, Zip, Zip", "2006-02-27");
        tvShow.addEpisode(1, 15, "Game Night", "2006-02-06");
        tvShow.addEpisode(1, 16, "Cupcake", "2006-03-06");
        tvShow.addEpisode(1, 17, "Life Among the Gorillas", "2006-03-20");
        tvShow.addEpisode(1, 18, "Nothing Good Happens After 2 A.M.",
                "2006-04-10");
        tvShow.addEpisode(1, 19, "Mary the Paralegal", "2006-04-24");
        tvShow.addEpisode(1, 20, "Best Prom Ever", "2006-05-01");
        tvShow.addEpisode(1, 21, "Milk", "2006-05-08");
        tvShow.addEpisode(1, 22, "Come On", "2006-05-15");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "Game of Thrones",
                "http://thetvdb.com/banners/_cache/posters/121361-4.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/121361-15.jpg",
                4);
        tvShow.addEpisode(1, 1, "Winter Is Coming", "2011-04-17");
        tvShow.addEpisode(1, 2, "The Kingsroad", "2011-04-24");
        tvShow.addEpisode(1, 3, "Lord Snow", "2011-05-01");
        tvShow.addEpisode(1, 4, "Cripples, Bastards, and Broken Things",
                "2011-05-08");
        tvShow.addEpisode(1, 5, "The Wolf and the Lion", "2011-05-15");
        tvShow.addEpisode(1, 6, "A Golden Crown", "2011-05-22");
        tvShow.addEpisode(1, 7, "You Win or You Die", "2011-05-29");
        tvShow.addEpisode(1, 8, "The Pointy End", "2011-06-05");
        tvShow.addEpisode(1, 9, "Baelor", "2011-06-12");
        tvShow.addEpisode(1, 10, "Fire and Blood", "2011-06-19");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "Dexter",
                "http://thetvdb.com/banners/_cache/posters/79349-24.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/79349-42.jpg",
                8);
        tvShow.addEpisode(1, 1, "Dexter", "2006-10-01");
        tvShow.addEpisode(1, 2, "Crocodile", "2006-10-08");
        tvShow.addEpisode(1, 3, "Popping Cherry", "2006-10-15");
        tvShow.addEpisode(1, 4, "Let's Give the Boy a Hand", "2006-10-22");
        tvShow.addEpisode(1, 5, "Love American Style", "2006-10-29");
        tvShow.addEpisode(1, 6, "Return to Sender", "2006-11-05");
        tvShow.addEpisode(1, 7, "Circle of Friends", "2006-11-12");
        tvShow.addEpisode(1, 8, "Shrink Wrap", "2006-11-19");
        tvShow.addEpisode(1, 9, "Father Knows Best", "2006-11-26");
        tvShow.addEpisode(1, 10, "Seeing Red", "2006-12-03");
        tvShow.addEpisode(1, 11, "Truth Be Told", "2006-12-10");
        tvShow.addEpisode(1, 12, "Born Free", "2006-12-17");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "House of Cards",
                "http://thetvdb.com/banners/_cache/posters/79861-1.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/79861-3.jpg",
                3);
        tvShow.addEpisode(1, 1, "House of Cards Episode 1", "1990-11-18");
        tvShow.addEpisode(1, 2, "House of Cards Episode 2", "1990-11-25");
        tvShow.addEpisode(1, 3, "House of Cards Episode 3", "1990-12-02");
        tvShow.addEpisode(1, 4, "House of Cards Episode 4", "1990-12-09");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "The Big Bang Theory",
                "http://thetvdb.com/banners/_cache/posters/80379-18.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/80379-38.jpg",
                7);
        tvShow.addEpisode(1, 1, "Pilot", "2007-09-24");
        tvShow.addEpisode(1, 2, "The Big Bran Hypothesis", "2007-10-01");
        tvShow.addEpisode(1, 3, "The Fuzzy Boots Corollary", "2007-10-08");
        tvShow.addEpisode(1, 4, "The Luminous Fish Effect", "2007-10-15");
        tvShow.addEpisode(1, 5, "The Hamburger Postulate", "2007-10-22");
        tvShow.addEpisode(1, 6, "The Middle Earth Paradigm", "2007-10-29");
        tvShow.addEpisode(1, 7, "The Dumpling Paradox", "2007-11-05");
        tvShow.addEpisode(1, 8, "The Grasshopper Experiment", "2007-11-12");
        tvShow.addEpisode(1, 9, "The Cooper-Hofstadter Polarization",
                "2008-03-17");
        tvShow.addEpisode(1, 10, "The Loobenfeld Decay", "2008-03-24");
        tvShow.addEpisode(1, 11, "The Pancake Batter Anomaly", "2008-03-31");
        tvShow.addEpisode(1, 12, "The Jerusalem Duality", "2008-04-14");
        tvShow.addEpisode(1, 13, "The Bat Jar Conjecture", "2008-04-21");
        tvShow.addEpisode(1, 14, "The Nerdvana Annihilation", "2008-04-28");
        tvShow.addEpisode(1, 15, "The Pork Chop Indeterminacy", "2008-05-05");
        tvShow.addEpisode(1, 16, "The Peanut Reaction", "2008-05-12");
        tvShow.addEpisode(1, 17, "The Tangerine Factor", "2008-05-19");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "Sleepy Hollow",
                "http://thetvdb.com/banners/_cache/posters/269578-4.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/269578-4.jpg",
                1);
        tvShow.addEpisode(1, 1, "Pilot", "2013-09-16");
        tvShow.addEpisode(1, 2, "Blood Moon", "2013-09-23");
        tvShow.addEpisode(1, 3, "For the Triumph of Evil", "2013-09-30");
        tvShow.addEpisode(1, 4, "The Lesser Key of Solomon", "2013-10-07");
        tvShow.addEpisode(1, 5, "John Doe", "2013-10-14");
        tvShow.addEpisode(1, 6, "The Sin Eater", "2013-11-04");
        tvShow.addEpisode(1, 7, "The Midnight Ride", "2013-11-11");
        tvShow.addEpisode(1, 8, "Necromancer", "2013-11-18");
        tvShow.addEpisode(1, 9, "Sanctuary", "2013-11-25");
        tvShow.addEpisode(1, 10, "The Golem", "2013-12-09");
        tvShow.addEpisode(1, 11, "The Vessel", "2014-01-13");
        tvShow.addEpisode(1, 12, "Indispensable Man", "2014-01-20");
        tvShow.addEpisode(1, 13, "Bad Blood", "2014-01-20");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "The Vampire Diaries",
                "http://thetvdb.com/banners/_cache/posters/95491-28.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/95491-68.jpg",
                5);
        tvShow.addEpisode(1, 1, "Pilot", "2009-09-10");
        tvShow.addEpisode(1, 2, "The Night of the Comet", "2009-09-17");
        tvShow.addEpisode(1, 3, "Friday Night Bites", "2009-09-24");
        tvShow.addEpisode(1, 4, "Family Ties", "2009-10-01");
        tvShow.addEpisode(1, 5, "You're Undead to Me", "2009-10-08");
        tvShow.addEpisode(1, 6, "Lost Girls", "2009-10-15");
        tvShow.addEpisode(1, 7, "Haunted", "2009-10-29");
        tvShow.addEpisode(1, 8, "162 Candles", "2009-11-05");
        tvShow.addEpisode(1, 9, "History Repeating", "2009-11-12");
        tvShow.addEpisode(1, 10, "The Turning Point", "2009-11-19");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "Friends",
                "http://thetvdb.com/banners/_cache/posters/79168-3.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/79168-6.jpg",
                10);
        tvShow.addEpisode(1, 1, "The One Where Monica Gets A Roommate",
                "1994-09-22");
        tvShow.addEpisode(1, 2, "The One With The Sonogram At The End",
                "1994-09-29");
        tvShow.addEpisode(1, 3, "The One With The Thumb", "1994-10-06");
        tvShow.addEpisode(1, 4, "The One With George Stephanopoulos",
                "1994-10-13");
        tvShow.addEpisode(1, 5,
                "The One With The East German Laundry Detergent", "1994-10-20");
        tvShow.addEpisode(1, 6, "The One With The Butt", "1994-10-27");
        tvShow.addEpisode(1, 7, "The One With The Blackout", "1994-11-03");
        tvShow.addEpisode(1, 8, "The One Where Nana Dies Twice", "1994-11-10");
        tvShow.addEpisode(1, 9, "The One Where Underdog Gets Away",
                "1994-11-17");
        tvShow.addEpisode(1, 10, "The One With The Monkey", "1994-12-15");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "New Girl",
                "http://thetvdb.com/banners/_cache/posters/248682-9.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/248682-20.jpg",
                3);
        tvShow.addEpisode(1, 1, "Pilot", "2011-09-20");
        tvShow.addEpisode(1, 2, "Kryptonite", "2011-09-27");
        tvShow.addEpisode(1, 3, "Wedding", "2011-10-04");
        tvShow.addEpisode(1, 4, "Naked", "2011-11-01");
        tvShow.addEpisode(1, 5, "Cece Crashes", "2011-11-08");
        tvShow.addEpisode(1, 6, "Thanksgiving", "2011-11-15");
        tvShow.addEpisode(1, 7, "Bells", "2011-11-29");
        tvShow.addEpisode(1, 8, "Bad in Bed", "2011-12-06");
        tvShow.addEpisode(1, 9, "The 23rd", "2011-12-13");
        tvShow.addEpisode(1, 10, "The Story of the 50", "2012-01-17");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "Family Guy",
                "http://thetvdb.com/banners/_cache/posters/75978-13.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/75978-27.jpg",
                12);
        tvShow.addEpisode(1, 1, "Death has a Shadow", "1999-01-31");
        tvShow.addEpisode(1, 2, "I Never Met the Dead Man", "1999-04-11");
        tvShow.addEpisode(1, 3, "Chitty Chitty Death Bang", "1999-04-18");
        tvShow.addEpisode(1, 4, "Mind Over Murder", "1999-04-25");
        tvShow.addEpisode(1, 5, "A Hero Sits Next Door", "1999-05-02");
        tvShow.addEpisode(1, 6, "The Son Also Draws", "1999-05-09");
        tvShow.addEpisode(1, 7, "Brian: Portrait of a Dog", "1999-05-16");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "Gossip Girl",
                "http://thetvdb.com/banners/_cache/posters/80547-11.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/80547-24.jpg",
                6);
        tvShow.addEpisode(1, 1, "Pilot", "2007-09-19");
        tvShow.addEpisode(1, 2, "The Wild Brunch", "2007-09-26");
        tvShow.addEpisode(1, 3, "Poison Ivy", "2007-10-03");
        tvShow.addEpisode(1, 4, "Bad News Blair", "2007-10-10");
        tvShow.addEpisode(1, 5, "Dare Devil", "2007-10-17");
        tvShow.addEpisode(1, 6, "The Handmaiden's Talea", "2007-10-24");
        tvShow.addEpisode(1, 7, "Victor (Victrola)", "2007-11-07");
        tvShow.addEpisode(1, 8, "Seventeen Candles", "2007-11-14");
        tvShow.addEpisode(1, 9, "Blair Waldorf Must Pie!", "2007-11-28");
        tvShow.addEpisode(1, 10, "Hi, Society", "2007-12-05");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "American Dad",
                "http://thetvdb.com/banners/_cache/posters/73141-1.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/73141-12.jpg",
                11);
        tvShow.addEpisode(1, 1, "Pilot", "2005-02-06");
        tvShow.addEpisode(1, 2, "Threat Levels", "2005-05-01");
        tvShow.addEpisode(1, 3, "Stan Knows Best", "2005-05-08");
        tvShow.addEpisode(1, 4, "Francine's Flashback", "2005-05-15");
        tvShow.addEpisode(1, 5, "Roger Codger", "2005-06-05");
        tvShow.addEpisode(1, 6, "Homeland Insecurity", "2005-06-12");
        tvShow.addEpisode(1, 7, "Deacon Stan, Jesus Man", "2005-06-19");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "The Simpsons",
                "http://thetvdb.com/banners/_cache/posters/71663-20.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/71663-30.jpg",
                26);
        tvShow.addEpisode(1, 1, "Simpsons Roasting on an Open Fire",
                "1989-12-17");
        tvShow.addEpisode(1, 2, "Bart the Genius", "1990-01-14");
        tvShow.addEpisode(1, 3, "Homer's Odyssey", "1990-01-21");
        tvShow.addEpisode(1, 4, "There's No Disgrace Like Home", "1990-01-28");
        tvShow.addEpisode(1, 5, "Bart the General", "1990-02-04");
        tvShow.addEpisode(1, 6, "Moaning Lisa", "1990-02-11");
        tvShow.addEpisode(1, 7, "The Call of the Simpsons", "1990-02-18");
        tvShow.addEpisode(1, 8, "The Telltale Head", "1990-02-25");
        tvShow.addEpisode(1, 9, "Life on the Fast Lane", "1990-03-18");
        tvShow.addEpisode(1, 10, "Homer's Night Out", "1990-03-25");
        tvShow.addEpisode(1, 11, "The Crepes of Wrath", "1990-04-15");
        tvShow.addEpisode(1, 12, "Krusty Gets Busted", "1990-04-29");
        tvShow.addEpisode(1, 13, "Some Enchanted Evening", "1990-05-13");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "The Mentalist",
                "http://thetvdb.com/banners/_cache/posters/82459-6.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/82459-4.jpg",
                6);
        tvShow.addEpisode(1, 1, "Pilot", "2008-09-23");
        tvShow.addEpisode(1, 2, "Red Hair and Silver Tape", "2008-09-30");
        tvShow.addEpisode(1, 3, "Red Tide", "2008-10-14");
        tvShow.addEpisode(1, 4, "Ladies in Red", "2008-10-21");
        tvShow.addEpisode(1, 5, "Redwood", "2008-10-28");
        tvShow.addEpisode(1, 6, "Red Handed", "2008-11-11");
        tvShow.addEpisode(1, 7, "Seeing Red", "2008-11-18");
        tvShow.addEpisode(1, 8, "The Thin Red Line", "2008-11-25");
        tvShow.addEpisode(1, 9, "Flame Red", "2008-12-02");
        tvShow.addEpisode(1, 10, "Red Brick and Ivy", "2008-12-16");
        tvShows.add(tvShow);

        tvShow = new TvShow(
                "Sons of Anarchy",
                "http://thetvdb.com/banners/_cache/posters/82696-1.jpg",
                "http://thetvdb.com/banners/_cache/fanart/original/82696-18.jpg",
                6);
        tvShow.addEpisode(1, 1, "Pilot", "2008-09-03");
        tvShow.addEpisode(1, 2, "Seeds", "2008-09-10");
        tvShow.addEpisode(1, 3, "Fun Town", "2008-09-17");
        tvShow.addEpisode(1, 4, "Patch Over", "2008-09-24");
        tvShow.addEpisode(1, 5, "Giving Back", "2008-10-01");
        tvShow.addEpisode(1, 6, "AK 51", "2008-10-08");
        tvShow.addEpisode(1, 7, "Old Bones", "2008-10-15");
        tvShow.addEpisode(1, 8, "The Pull", "2008-10-22");
        tvShow.addEpisode(1, 9, "Hell Followed", "2008-10-29");
        tvShow.addEpisode(1, 10, "Better Half", "2008-11-05");
        tvShow.addEpisode(1, 11, "Capybara", "2008-11-12");
        tvShow.addEpisode(1, 12, "The Sleep of Babies", "2008-11-19");
        tvShow.addEpisode(1, 13, "The Revelator", "2008-11-26");
        tvShows.add(tvShow);

    }

    public Set<TvShow> getTvShows() {
        return tvShows;
    }

    public TvShow getTvShowById(String tvShowId) throws TvShowNotFoundException {
        TvShow result = searchTvShowById(tvShowId);
        if (result == null) {
            throw new TvShowNotFoundException("The identifier" + tvShowId
                    + "is not associated to any TvShow");
        }
        return result;
    }

    private TvShow searchTvShowById(String tvShowId) {
        TvShow result = null;
        for (TvShow tvShow : tvShows) {
            if (tvShow.getTitle().equals(tvShowId)) {
                result = tvShow;
                break;
            }
        }
        return result;
    }

    public void addTvShow(TvShow tvShow) {
        tvShows.add(tvShow);
    }
}
