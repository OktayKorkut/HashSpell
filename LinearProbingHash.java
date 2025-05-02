
import java.io.*;

public class LinearProbingHash<Key> {

    GenericStack<Key>[] table;
    int M;
    int N;

    public LinearProbingHash(int M) {
        table = (GenericStack<Key>[]) new GenericStack[M];
        this.N = 0;
        this.M = M;
    }

    public int hash(Key t) {
        return ((t.hashCode() & 0x7fffffff) % M);
    }

    public boolean insert(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
        if (N >= M / 2) {
            resize(2 * M);
        }

        int h = hash(key);
        System.out.println("hash(" + key + ")= " + h);
        if (table[h] == null) {
            table[h] = new GenericStack<>(1);
        }

        table[h].push(key);
        N++;

        return true;
    }

    public boolean insertList(int index, GenericStack<Key> stack) {
        if (stack == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
        if (N >= M / 2) {
            resize(2 * M);
        }

        table[index] = stack;
        N++;

        return true;
    }


    private void resize(int capacity) {
        System.out.println("resize");
        LinearProbingHash<Key> temp = new LinearProbingHash<Key>(capacity);
        for (int i = 0; i < M; i++) {
            if (table[i] != null) {
                temp.insertList(i,table[i]);
            }
        }
        table = temp.table;
        M = temp.M;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }

        int i = hash(key);
        table[i].popSelected(key);
    }

    public Key get(Key key) throws Exception {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }

        int i = hash(key);
        if (table[i] == null){
            throw new Exception("The word is not found.");
        }

        if (table[i].isEmpty()){
            throw new Exception("The word is not found.");
        }

        Key result = table[i].search(key);

        return result;
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < M; i++) {
            s += table[i] + ",";
        }
        return s + "]";
    }

    public void checkSpell(LinearProbingHash<Key> checkBy) throws IOException {
        File file = new File("checkOutput.txt");
        FileWriter writer = new FileWriter(file);

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null){
                continue;
            }

            if (table[i].isEmpty()){
                continue;
            }

            while (!table[i].isEmpty()){
                Key word = table[i].pop();
                try{
                    checkBy.get(word);
                } catch (Exception e){
                    writer.write(word + " is not found.\n");
                    continue;
                }

            }
        }


        writer.close();

        System.out.println("The dictionary is checked.");
    }
}
