import java.text.Collator;
import java.util.HashMap;

import java.util.Collections;
import java.util.Iterator;



/** Card is used by game model class ie; Conc.
 * 
 * Construct: String (name),
 *            String (name), Int (value)
 *            
 * User can get and set its Value, Status, Name
 * 
 *  GOTCHA: it can get and set its status with a key, value of Int, and Int
 */

 class Card implements Comparable
{   
    private HashMap<String, Integer> statlist; 
    public String cardname;
    
    /**used to give a value to the cards in order to decide if their a match */
    private int cardvalue;
    
    /** on this variable store  a game variable*/
    private int status;

    public Card( String n)
    {
        this.cardname= n;
        this.cardvalue=0;
        this.statlist=new HashMap<String, Integer>();
        this.statlist.put("status",1);
        this.statlist.put("clickrate", 0);
    }
    
    public Card( String n, int v)
    {
        this.cardvalue=v;
        this.cardname= n;
        this.statlist=new HashMap<String, Integer>();
        this.statlist.put("status",1);
        this.statlist.put("clickrate", 0);
    }
    
   
    public int getValue(){ return this.cardvalue; }
    public void setValue(int v){  this.cardvalue = v; }
    
    public int getStat(String s){ return this.statlist.get(s);}
    public void setStat(String s, Object o){ this.statlist.put(s, (Integer)o); }
    
    public String getName(){ return this.cardname;}
    public void setName(String name){this.cardname = name;}
   
    public String printStatus(){
        String status="";
        for (String s : statlist.keySet())
        { 
        status= status+ "Key = "+s+ " Value = " + statlist.get(s)+ ", ";
        }
        return status;
    }
    

    
    
    
     /** Used For the shuffle Comparable func */
        public int compareTo(Object o)
        {
            Collator myCollator = Collator.getInstance();
            Card  c = (Card)o;
            if (this.cardvalue < c.getValue())
            {
                return -1;
            }
            else if (this.cardvalue> c.getValue())
            {
                return 1;
            }
            else
            {
                if(myCollator.compare(this.cardname, c.getName())<0)
                {
                    return -1;
                }
                else{ 
                    return 1;
                }
            }
            
        }
}
