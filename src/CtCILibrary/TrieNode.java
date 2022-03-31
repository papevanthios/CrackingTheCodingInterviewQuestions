package CtCILibrary;

import java.util.HashMap;

/**
 * The TrieNode program implemented in Java for learning purposes.
 *
 * The trie data structure is used in a few problems to make it easier to look up if a word is a prefix of any other
 * words in a dictionary (or list of valid words). This is often used when we're recursively building words so that we
 * can short circuit when the word is not valid.
 *
 * The Trie class uses the TrieNode class.
 *
 * @author Evanthios Papadopoulos
 * @since 31-Mar-22
 **/

public class TrieNode {

    // The children of this node in the trie.
    private HashMap<Character, TrieNode> children;
    private boolean terminates = false;

    // The character stored in this node as data.
    private char character;


}
