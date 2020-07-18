package com.example.samislibrary;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;

    public Utils() {
        if(null==Allbooks){
            Allbooks=new ArrayList<>();
            initData(); }
        if(null==CurentReadingbooks){
            CurentReadingbooks=new ArrayList<>();
        }
        if(null==AlreadyReadbooks){
            AlreadyReadbooks=new ArrayList<>();
        }
        if(null==Wishlistbooks){
            Wishlistbooks=new ArrayList<>();
        }
        if(null==Favouritebooks){
            Favouritebooks=new ArrayList<>();
        }
    }

    private void initData() {
        Allbooks.add(new book(1,"Red, White & Royal Blue: A Novel","Casey McQuiston",1100,"Red, White & Royal Blue concerns a rivalry-turned-romance between the Prince of Wales and the First Son of the United States. Alex Claremont-Diaz, whose mother is running for a second term for president, is sharp, passionate, and eager to kick-start his own political career.","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1566742512l/41150487._SY475_.jpg"));
        Allbooks.add(new book(2,"The Bride Test","Helen Hoang",890,"The Bride Test is about Khai, Michael's cousin in The Kiss Quotient. He is Vietnamese-American, autistic, and believes himself to be incapable of the emotions that matter. Like grief. Or love.","https://images-na.ssl-images-amazon.com/images/I/71ix9ZnGCFL.jpg"));
        Allbooks.add(new book(3,"Meet Cute","Helena Hunting",1340,"From Wikipedia, the free encyclopedia. In film and television, a meet cute is a scene in which the two people who will form a future romantic couple meet for the first time, typically under unusual, humorous, or \"cute\" circumstances. This type of scene is a staple of romantic comedies.","https://img1.od-cdn.com/ImageType-400/4575-1/3B3/800/65/%7B3B380065-2B54-45F8-AB7E-41DAA6038940%7DImg400.jpg"));
        Allbooks.add(new book(4,"The Right Swipe: A Novel","Alisha Rai",1207,"Alisha Rai returns with a sizzling new novel, in which two rival dating app creators find themselves at odds in the boardroom but in sync in the bedroom. Only there aren't any rules to govern her attraction to her newest match, former pro-football player Samson Lima.","https://i.pinimg.com/originals/54/aa/76/54aa76d83f78b8ff0f902ab07fb71682.jpg"));
        Allbooks.add(new book(5,"Well Met","Jen DeLuca",690,"(Well Met #1) All's faire in love and war for two sworn enemies who indulge in a harmless flirtation in a laugh-out-loud rom-com from debut author, Jen DeLuca. ... Yet on the faire grounds he becomes a different person, flirting freely with Emily when she's in her revealing wench's costume.","https://bookandfilmglobe.com/wp-content/uploads/2020/02/1250-5ea45221b624ff276c76477cdead73ca-800x445.jpg"));
        Allbooks.add(new book(6,"The Kiss Thief"," L. J. Shen",896,"Senator Wolfe Keaton has not only stolen Princess Francesca Rossi's first kiss, he has stolen her dreams, her life and is working his way to steal her heart too. Al, these she'd been safeguarding for Angelo Bandini. He took the power. MY power. Wolfe Keaton was A KISS THIEF","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1544101164l/41450662._SY475_.jpg"));
        Allbooks.add(new book(7,"The Unhoneymooners","Christina Lauren",1054,"The Unhoneymooners is an enemies to lovers romance set in a romantic destination. It has Christina Lauren's trademark humor and wit, but a plot twist and tonal shift knocked me off balance and left me unable to regain my footing. Ami and Olive Torres are twins.","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1548201335i/42201431._UY400_SS400_.jpg"));

    }

    private static ArrayList<book> Allbooks;
    private static ArrayList<book> CurentReadingbooks;
    private static ArrayList<book> AlreadyReadbooks;
    private static ArrayList<book> Wishlistbooks;
    private static ArrayList<book> Favouritebooks;

    public static ArrayList<book> getAllbooks() {
        return Allbooks;
    }

    public static ArrayList<book> getCurentReadingbooks() {
        return CurentReadingbooks;
    }

    public static ArrayList<book> getAlreadyReadbooks() {
        return AlreadyReadbooks;
    }

    public static ArrayList<book> getWishlistbooks() {
        return Wishlistbooks;
    }

    public static ArrayList<book> getFavouritebooks() {
        return Favouritebooks;
    }

    public static Utils getInstance() {
        if(null==instance){
            instance=new Utils();
            return instance;
        }
        else{
            return instance; } }
   public book GetbookById(int id) {
      for(book b:Allbooks) {
          if(b.getId()==id){
              return b;
          } }
return null;
   }
   public boolean AddtoAlreadyReadBuks(book buk) {

       return AlreadyReadbooks.add(buk);
   }
   public boolean AddtoCurrentreadingbuks(book buk){
        return CurentReadingbooks.add(buk);
   }
   public boolean AddtoWishLIst(book buk) {
        return Wishlistbooks.add(buk);
   }
   public boolean AddtoFav(book b){
        return Favouritebooks.add(b);
   }
   public boolean RemovefromCurrentList(book b){
        return CurentReadingbooks.remove(b);
   }
   public boolean RemovefromFavList(book b){
        return Favouritebooks.remove(b);
   }
   public boolean RemovefromAlreadyList(book b){
        return AlreadyReadbooks.remove(b);
   }
   public boolean RemovefromWishlist(book b ){
        return Wishlistbooks.remove(b);
   }



   }



