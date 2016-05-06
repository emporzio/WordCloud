/**
 * Interface to be implemented by the Counter class.
 * An interface for an object that holds a String and its occurrence count.
 * Such objects will be Comparable to other ones like them.
 * 
 * @author M. Allen
 * 
 */
public interface WordCounter extends Comparable<WordCounter>
{
    /**
     * Returns word stored by this object.
     * 
     * @return String stored by this object.
     */
    public String getWord();

    /**
     * Returns number of occurrences of String that is returned by getWord().
     * 
     * @return Number of occurrences for the associated String.
     */
    public int getCount();

    /**
     * Sets the word that is stored by this object.
     * 
     * @param word A single word to be stored.
     */
    public void setWord( String word );

    /**
     * Sets the occurrence value for the word stored by this object.
     * 
     * @param count A number of occurrences for the given word (some value
     *            greater than 0).
     */
    public void setCount( int count );
}
