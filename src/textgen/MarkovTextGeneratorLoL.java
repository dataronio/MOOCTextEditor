package textgen;

//import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		if (sourceText == "") return;
		String[] str = sourceText.split("\\s+");
		starter = str[0];
		String prevword = starter;
		
		
        
		for (int i = 1; i < str.length; i++) {
			boolean binList = false;
			for (int j = 0; j < wordList.size();j++) {
				ListNode cur = wordList.get(j);
				if (cur.getWord().equals(prevword)) {
					cur.addNextWord(str[i]);
					wordList.set(j, cur);
					binList = true;
				}
			}
			if (binList == true) {
				prevword = str[i];
			} else {
				ListNode newNode = new ListNode(prevword);
				newNode.addNextWord(str[i]);
				wordList.add(newNode);
				prevword = str[i];
			}
			
		}
		boolean binlist2 = false;
		for(ListNode node : wordList) {
			if (node.getWord().equals(str[str.length - 1])) {
				node.addNextWord(starter);
				binlist2 = true;
			}
		}
		if (binlist2 == false) {
			ListNode lastNode = new ListNode(str[str.length - 1]);
			lastNode.addNextWord(starter);
			wordList.add(lastNode);
		}
		
	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
		if (starter == "") return "";
		if (wordList == null) return "";
		if (wordList.size() == 0) return "";
		if (numWords == 0) return "";
	    String currword = starter;
	    String output = "";
		output = output + currword;
		int wordnum = 1;
		
		while (wordnum < numWords) {
			for(ListNode node : wordList) {
				if (node.getWord().equals(currword)) {
				String	word = node.getRandomNextWord(rnGenerator);
				output = output + " " + word;
			    currword = word;
			    wordnum++;
			    break;
				}			
		    }
		}
		return output;
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		wordList = new LinkedList<ListNode>();
		if (sourceText == "") return;
		String[] str = sourceText.split("\\s+");
		starter = str[0];
		String prevword = starter;
		
			
        
		for (int i = 1; i < str.length; i++) {
			boolean binList = false;
			for (int j = 0; j < wordList.size();j++) {
				ListNode cur = wordList.get(j);
				if (cur.getWord().equals(prevword)) {
					cur.addNextWord(str[i]);
					wordList.set(j, cur);
					binList = true;
				}
			}
			if (binList == true) {
				prevword = str[i];
			} else {
				ListNode newNode = new ListNode(prevword);
				newNode.addNextWord(str[i]);
				wordList.add(newNode);
				prevword = str[i];
			}
			
		}
		boolean binlist2 = false;
		for(ListNode node : wordList) {
			if (node.getWord().equals(str[str.length - 1])) {
				node.addNextWord(starter);
				binlist2 = true;
			}
		}
		if (binlist2 == false) {
			ListNode lastNode = new ListNode(str[str.length - 1]);
			lastNode.addNextWord(starter);
			wordList.add(lastNode);
		}
		
		
	}
	
	// TODO: Add any private helper methods you need here.
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String shortString = "hi hi there there leo.";
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		//System.out.println(textString);
		//gen.retrain(textString);
		gen.retrain("");
		System.out.println(gen.toString());
		System.out.println(gen.generateText(20));
		//System.out.println("Now we retrain.");
		//gen.retrain(shortString);
		//System.out.println(gen.toString());
		//System.out.println(gen.generateText(20));
		/**
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
			*/	
		//System.out.println(textString2);
		//gen.retrain(textString2);
		//System.out.println(gen);
		//System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
		int n = nextWords.size();
		int rand = generator.nextInt(n);
	    return nextWords.get(rand);
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


