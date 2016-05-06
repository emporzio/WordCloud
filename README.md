WordCloud
=========

General Usage Notes:
--------------------

- WordCloud creates a text field displaying words of varying colors and sizes depending on how often the word appears in a 
given input file. 

- java WordCloud [commonFileName inputFileName]
	
- Parameters:
	- commonFileName (optional) – the name of the file of words that are too common/bland to keep track of
	- inputFileName (optional) - the name of the file that contains a body of text to read through

- To run WordCloud, navigate to the WordCloud main class and run it.

Other Notes:
------------

- This started as some open-source skeleton code that I was working on in a programming class. Some of the classes ( WordCounter, 
CloudWindow ) were created and supplied by Dr. Allen. I then took that code and added my own class, Counter, along with some
methods in the class WordCloud. I changed some of the supplied methods to make them more versatile and efficient.

- Uses the default file dream.txt, or MLK's "I Have A Dream" speech. By uncommenting line 45 of the WordCloud class ( wc.addPage() ),
this program will also read in an e-book url link (Alice in Wonderland) and display how often certain words appear in that body 
of text as well. 

Future Plans:
-------------

- Currently, the counter counts html tags on a website when adding a webpage as well as regular text words, so only e-book links work properly. 
However, even with e-book links, there are a few strings of numbers that are being counted. The plan is to fix this so that any url can be 
inputted.

- There is currently a limit as to how many words can be stored in the WordCloud. I haven't decided whether or not to up the limit of
words that will appear in the WordCloud or whether or not WordCloud will only score the top 'n' most common words, and then sort
them in alphabetical order.

Contact:
--------

Erik Porzio
porzio.erik@uwlax.edu

