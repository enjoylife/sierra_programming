      class Player implements Comparable
    {
        private String name, description;
        private int id;
        private int score;
        private int hand;

        public Player(int id, String name)
        {
            this.id = id;
            this.hand = 0;
            this.name = name;
        }
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
        public int getScore()
        {
            return this.score;
        }
        public int setScore(int s)
        {
            this.score= s;
            return this.score;
        }
        public int getId()
        {
            return this.id;
        }
        public String getName()
        {
            return this.name;
        }
        public int getHand(){
            return this.hand;
        }
        public void setHand(int hand){
            this.hand =hand;
        }

    }