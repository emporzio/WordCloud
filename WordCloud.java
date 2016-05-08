/**
 * Description: Parses an input file into distinct, non-common words,
 * counting the occurrences of each such word, before sending the data
 * to a CloudWindow for display as a word-cloud.
 *
 * @author M. Allen
 * @author Erik Porzio
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class WordCloud
{
	private LinkedList<String> commonWords;
	private LinkedList<WordCounter> counts;
    
    /**
     * Simple initiating main(). Sends names of input files to WordCloud object.
     *
     * @param args Not used.
     */
    public static void main( String[] args )
    {
    	final String commonWordsFile;
    	final String inputFile;
    	
    	if( args.length == 2 )
    	{
    		commonWordsFile = args[0];
    		inputFile = args[1];
    	}
    	else
    	{
    		commonWordsFile = "commonest.txt";
    		inputFile = "dream.txt";
    	}
        WordCloud wc = new WordCloud( commonWordsFile, inputFile );
        // wc.addWebPage( "http://www.gutenberg.org/cache/epub/11/pg11.txt" );
        wc.show();
    }
    
    /**
     * Reads words from an input file, counts them, and writes data
     * into a word cloud.
     *
     * @param commonWordsFile Name of a file containing common words
     *        (which are ignored when reading the input).
     * @param inputFile Name of a file containing words to count.
     */
    public WordCloud( String commonWordsFile, String inputFile )
    {
        // load common words to one list
        commonWords = new LinkedList<String>();
        loadCommon( commonWordsFile );
        
        // open CloudWindow to display words
        counts = new LinkedList<>();
        addFile( inputFile );      
    }
    
    /**
     * Takes the name of a 'file' and calls the method to count
     * how many times each words appears in the file
     * 
     * @param fileName
     */
    public void addFile( String fileName )
    {
    	countWordsFile( fileName );
    }
    
    /**
     * url should be an accessible html link. Tries to call
     * countWordsFromReader() find its text-body, then calls the method 
     * to count how many times each word appears in the text-body.
     * 
     * @param url Address of html link to read lines from its text-body.
     */
    public void addWebPage( String url )
    {
    	try 
    	{
		countWordsFromReader( new InputStreamReader( new URL(url).openStream() ) );
	} 
    	catch ( MalformedURLException e ) 
    	{
		e.printStackTrace();
	} 
    	catch ( IOException e ) 
    	{
		e.printStackTrace();
	}
    }
    
    /**
     * Creates the CloudWindow and displays the end results in the window.
     */
    public void show()
    {
    	CloudWindow cw = new CloudWindow();
        cw.makeWindow( counts, "I Have a Dream" );
    }
    
    /**
     * The inFile should be an accessible text-file. Counts the 
     * number of times each word appears in a given input file.
     * 
     * @param inFile Name of file to read lines from.
     */
    private void countWordsFile( String inFile )
    {
    	try 
    	{
		countWordsFromReader( new FileReader( inFile ) );
	} 
    	catch (FileNotFoundException e) 
    	{
		e.printStackTrace();
	}
    }
    
    /**
     * Takes in a 'common words' file( should be accessible text-file), 
     * reads through each line, and stores each word into ArrayList 
     * commonWords.
     * 
     * @param inFile Name of file to read lines from.
     */
    private void loadCommon( String inFile )
    {
       try 
       {
    	   BufferedReader br = new BufferedReader( new FileReader( inFile ) );
    	   
    	   String line = br.readLine();
    	   commonWords.add( line );
    	   
    	   while( line != null ) 
    	   {
    		   line = br.readLine();
    		   commonWords.add( line );
    	   }
    	   
    	   br.close();
       } 
       catch (FileNotFoundException e) 
       {
    	   System.err.println( "File not found!" );
       } 
       catch (IOException e) 
       {
    	   System.err.println( "Error!" );
       }
    }
    
    /**
     * Pre: the inFile should be an accessible text-file/url.
     *
     * Post:  the number of occurrences for each word from the input file/url that is
     * not in the common list should be determined;  the counts list will consist of
     * one Counter object per non-common word, holding the count of that word.
     *
     * @param inFile Name of file to read lines from.
     */
    private void countWordsFromReader( Reader inFile )
    {
    	 try 
         {
      	   BufferedReader br = new BufferedReader( inFile );
      	   
      	   String line = br.readLine();
      	   
			while ( line != null ) 
			{
				String[] r1 = splitLine( line );
				
				// loops through each word in the line and checks
				// whether or not the word is in the common words list
				for ( int i = 0; i < r1.length; i++ ) 
				{
					// checks if the word in array r1 is in ArrayList
					// commonWords
					if ( !commonWords.contains( r1[i] ) ) 
					{
						Counter c = new Counter( r1[i], 1 );

						// checks if word already exists in Counter
						if ( counts.indexOf(c) != -1 ) 
						{
							for ( WordCounter j : counts ) 
							{
								if ( j.equals( c ) ) 
								{
									counts.remove( r1[i] );
									j.setCount( j.getCount() + 1 );
								}
							}
						} 
						else
							counts.add( c );
					}
				}
				line = br.readLine();
			}
			br.close();
		} 
         catch ( FileNotFoundException e ) 
         {
      	 	System.err.println( "File not found!" );
         } 
    	 catch ( IOException e ) 
    	 {
    		System.err.println( "Error!" );
    	 }
    }    
    /**
     *post: returns array containing individual words in s, after removing
     *punctuation and converting to lower-case
     * 
     * @param s
     * @return wds
     */
    private String[] splitLine( String s )
    {
        // remove punctuation from line and convert to lower-case
        s = s.replaceAll( "\\p{Punct}", "" );
        s = s.toLowerCase();
        
        // create array by splitting out all white space
        String[] wds = s.trim().split( "\\s+" );
        return wds;
    }
}
