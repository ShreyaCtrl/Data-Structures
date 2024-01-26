# Tries

A trie, also called a prefix tree or a radix tree, is a tree-like data structure that stores strings in a way that allows for efficient retrieval and searching. Each node in the trie represents a character in a string, and the children of a node represent the possible characters that can follow that character in a string.

## Implementation

The code above implements a trie in Java. The `TrieNode` class represents a node in the trie, and the `Tries` class represents the trie itself.

### TrieNode

The `TrieNode` class has the following fields:

- `isEnd`: A boolean value that indicates whether the node represents the end of a string.
- `links`: An array of `TrieNode` objects, where each index represents a character in the alphabet. The value at each index is the `TrieNode` object that represents the next character in the string.

### Tries

The `Tries` class has the following methods:

- `insertNode(String word)`: This method inserts a string into the trie. It does this by iterating over the characters in the string and creating a new `TrieNode` object for each character. If a `TrieNode` object already exists for a character, the method simply updates the `isEnd` field of that node to indicate that the string ends at that character.
- `search(String word)`: This method searches for a string in the trie. It does this by iterating over the characters in the string and checking if a `TrieNode` object exists for each character. If a `TrieNode` object does not exist for a character, the method returns `false`. Otherwise, the method returns `true` if the `isEnd` field of the last `TrieNode` object is `true`.
- `startsWith(String prefix)`: This method checks if a string starts with a given prefix. It does this by iterating over the characters in the prefix and checking if a `TrieNode` object exists for each character. If a `TrieNode` object does not exist for a character, the method returns `false`. Otherwise, the method returns `true`.

## Example

The following code shows how to use the `Tries` class to insert, search for, and check if a string starts with a given prefix:

```java
T trie = new T();
trie.insertNode("apple");System.out.("Searching for: " + trie.search("")); // should print "Searching for apple:"
System.out.printlnSearching for banana: " + trie.search("banana")); // should print "Searching for banana: false"
System.out.println("Starts with app: " + trie.startsWith("app")); // should print "Starts with app: true"
System.out.println("Starts with b: " + trie.startsWith("b")); // should print "Starts with b: false"
```

In this example, we first create a new Tries object and insert the string "apple" into it using the insertNode method. We then search for the strings "apple" and "banana" using the search method and print the results. Finally, we check if the strings "app" and "b" are prefixes of any strings in the trie using the startsWith method and print the results.

Note that the Tries class is case-sensitive, so if you want to search for strings that contain uppercase letters, you will need to modify the insertNode, search, and startsWith methods to handle them appropriately.