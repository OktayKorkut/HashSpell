
public class GenericStack<Item> {
    private Item[] a;
    private int top;

    public GenericStack(int capacity) {
        a = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(Item item) {
        if (top == a.length) {
            resize(2 * a.length);
        }

        a[top++] = item;
    }

    public Item pop() {
        return a[--top];
    }

    public Item search(Item item){
        for (int i = 0; i < top; i++){
            if (a[i] == item){
                return a[i];
            }
        }
        return null;
    }

    public Item popSelected(Item item){
        for (int i = 0; i < top; i++){
            if (a[i] == item){
                Item temp = a[i];
                a[i] = a[top-1];
                top--;
                return temp;
            }
        }
        return null;
    }

    public Item resize(int capacity){
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < top; i++){
            temp[i] = a[i];
        }
        a = temp;
        return null;
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            int x = top;
            String str = "";
            while (x > 0) {
                x--;
                str += a[x].toString() + "\n";
            }
            return str;
        }
        return "Stack is empty!";
    }

}

