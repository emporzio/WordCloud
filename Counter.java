
/**
 * Description: Class that implements WordCounter, Counter is an object
 * that holds a String and its occurrence count. These Counters
 * will be 'Comparable' to other Counters.
 * 
 * @author: Erik Porzio
 * 
 */
public class Counter implements WordCounter
{
	private String word;
	private int count;
	/**
	 * Constructor.
	 * 	
	 * @param wrd 
	 * @param cnt
	 */
	public Counter( String wrd, int cnt )
	{
		word = wrd;
		count = cnt;
	}
	
	/**
	 * Returns a positive or negative int value, or 0, depending on
	 * whether or not word's value is greater, less than, or equal to
	 * wc's word.
	 * 
	 * @return int found by the comparison of the two words.
	 */
	@Override
	public int compareTo( WordCounter wc ) 
	{
		return word.compareTo( wc.getWord( ) );
	}
	
	/**
	 * Returns boolean statement of whether the two counters equal each other.
	 * 
	 * @return true/false.
	 */
	public boolean equals( Object obj )
	{
		if( !( obj instanceof WordCounter ) )
			return false;
		
		WordCounter wc = ( WordCounter ) obj;
		if( word.compareTo( wc.getWord() ) == 0 )
			return true;
		
		return false;
	}
	
	 /**
     * Returns word stored by this object.
     * 
     * @return String stored by this object.
     */
	@Override
	public String getWord() 
	{
		return word;
	}

	/**
     * Returns number of occurrences of String that is returned by getWord().
     * 
     * @return Number of occurrences for the associated String.
     */
	@Override
	public int getCount() 
	{
		return count;
	}
	
	/**
     * Sets the word that is stored by this object.
     * 
     * @param word A single word to be stored.
     */
	@Override
	public void setWord( String wrd ) 
	{
		word = wrd;
	}
	
	/**
     * Sets the occurrence value for the word stored by this object.
     * 
     * @param count A number of occurrences for the given word (some value
     *            greater than 0).
     */
	@Override
	public void setCount( int cnt ) 
	{
		count = cnt;
	}
}
