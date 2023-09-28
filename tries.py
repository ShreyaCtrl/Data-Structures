class TrieNode:
    def __init__(self):
        self.endOfWord = False
        self.children = {}
        self.countOfWords = 0
        # print(type(self.children))
    def insert(self, word):
        currentNode = self
        for i in range(len(word)):
            if currentNode.children.get(word[i]) is None:
                currentNode.children[word[i]] = TrieNode()
                currentNode = currentNode.children[word[i]]
                currentNode.countOfWords += 1
                print(word,' : ',currentNode.countOfWords)
            else:
                currentNode = currentNode.children[word[i]]
                currentNode.countOfWords += 1
                print(word,' : ',currentNode.countOfWords)
        currentNode.endOfWord = True
        print('Word inserted successfully')

    def search(self, word):
        currentNode = self
        for i in range(len(word)):
            if currentNode.children.get(word[i]) is None:
                print(word,' : ', currentNode.countOfWords)
                return False
            else:
                currentNode = currentNode.children[word[i]]
                print(word,' : ', currentNode.countOfWords)
        if currentNode.endOfWord == True:
            return True
        else:
            return False

    def delete(self, word):
        currentNode = self
        for i in range(len(word)):
            if currentNode.children.get(word[i]) is None:
                return False
            else:
                currentNode.countOfWords -= 1
                # Nothing common with other words
                if currentNode.countOfWords == 0:
                    deleteNode = currentNode
                    # currentNode = currentNode.children[word[i]]
                    deleteNode.children[word[i]] = None
                elif currentNode.countOfWords != 0:
                    deleteNode = currentNode
                    currentNode = currentNode.children[word[i]]
                    if currentNode.countOfWords == 1:
                        deleteNode.children[word[i]] = None
        currentNode.countOfWords -= 1
        currentNode.endOfWord = False


if __name__ == '__main__':
    Root = TrieNode()
    # print(type(Root.children))
    n = int(input('Number of strings to be inserted: '))
    for i in range(n):
        word = input("Enter the word: ")
        Root.insert(word)

    switch = True
    while(switch):
        print('1. Search a word')
        print('2. Insert a word')
        print('3. Delete a word')
        print('3. Exit')
        choice = int(input('Enter your choice: '))
        if choice == 1:
            word = input('Enter the word to be searched: ')
            if Root.search(word):
                print('Word found')
            else:
                print('Word not found')
        elif choice == 2:
            word = input('Enter the word to be inserted: ')
            Root.insert(word)
        elif choice == 3:
            word = input('Enter the word to be deleted: ')
            Root.delete(word)
        elif choice == 4:
            switch = False
        else:
            print('Invalid choice')