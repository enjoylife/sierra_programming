/**  Player class is used by a game logic class ie; Conc
 * Constructors: String name, int id,
 * 
 * Used get only: Id, Name
 *      set only:
 *      both: Score
 * 
 *
 */     
class Player implements Comparable
    {
   
        public String name;//, description;
        private int id;
        private int score;
        
        //private int hand;

        public Player(String name, int id)
        {
            this.id = id;
            this.name = name;
            //this.hand = 0;
        }
        
        
        public int getScore()
        {
            return this.score;
        }
        public void setScore(int s)
        {
            this.score= s;
            
        }
        
        public int getId()
        {
            return this.id;
        }
        
        public String getName()
        {
            return this.name;
        }
        
        
        
        /** Used For the shuffle Comparable func */
        public int compareTo(Object o)
        {
            Player p = (Player)o;
            if (score < p.getScore())
            {
                return -1;
            }
            if (score> p.getScore())
            {
                return 1;
            }
            return 0;
        }
        /**
        public int getHand(){
            return this.hand;
        }
        public void setHand(int hand){
            this.hand =hand;
        }*/

    }