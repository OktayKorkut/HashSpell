# HashSpell

A hash-based spell checker and dictionary management tool.

Using a generic hash table with linear probing and a stack structure, it allows adding, removing, and searching words, as well as performing spell checking on text files.

---

##  Features

- **Load Dictionary:** Loads a word list from a specified `.txt` file.
- **Search Word:** Searches for a word in the dictionary.
- **Add Word:** Adds a new word to the dictionary.
- **Delete Word:** Removes a word from the dictionary.
- **Spell Check:** Scans a text file and reports words not found in the dictionary.
- **Statistics:** Displays details like hash table load factor and collision count.

---

##  Requirements

- **Java SE 8** or higher
- Terminal or command-line interface

---

##  Installation & Usage

1. **Clone or download the project:**
   ```sh
   git clone https://github.com/oktaykorkut/HashSpell.git
   cd HashSpell
   ```

2. **Compile the Java sources:**
   ```sh
   javac *.java
   ```

3. **Run the application:**
   ```sh
   java Main
   ```

4. **Select operations from the menu:**
   - `1`: Load dictionary
   - `2`: Search word
   - `3`: Add word
   - `4`: Delete word
   - `5`: Spell check
   - `6`: Show statistics
   - `7`: Show dictionary
   - `0`: Exit

---

##  Project Structure

```
HashSpell/
├── Main.java
├── GenericStack.java
└── LinearProbingHash.java
```

---

##  Class Summary

### `GenericStack<Item>`
- A capacity-limited generic stack implementation.
- Provides basic methods like `push`, `pop`, `peek`, and `isEmpty`.

### `LinearProbingHash<Key>`
- A hash table using linear probing.
- Methods: `insert`, `delete`, `contains`, `checkDictionary`, `stats`.
- Uses a `GenericStack<Key>` at each table index to reduce collision overhead.

### `Main`
- Manages the user menu via command-line.
- Controls dictionary loading and spell checking flow.
