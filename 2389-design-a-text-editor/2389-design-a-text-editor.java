class TextEditor {
    Node head;
    Node tail;
    Node cursor;

    public TextEditor() {
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.cursor = head;
    }
    
    public void addText(String text) {
        Node tempNext = cursor.next;
        for(int i = 0; i < text.length(); i++) {
            char currChar = text.charAt(i);
            Node newNode = new Node(currChar);
            cursor.next = newNode;
            newNode.prev = cursor;
            cursor = newNode;
        }
        cursor.next = tempNext;
        tempNext.prev = cursor;
    }

    public int deleteText(int k) {
        int doDelete = k;
        Node tempNext = cursor.next;
        while(k != 0 && cursor != head) {
            cursor = cursor.prev;
            k--;
        }
        cursor.next = tempNext;
        tempNext.prev = cursor;
    
        return doDelete - k;
    }
    
    public String cursorLeft(int k) {
        while(k!=0 && cursor != head) {
            cursor = cursor.prev;
            k--;
        }
        String last10 = "";
        int toGoBack = 10;
        Node tempCursor = cursor;
        while(toGoBack!=0 && tempCursor != head) {
            last10 = tempCursor.value + last10;
            tempCursor = tempCursor.prev;
            toGoBack--;
        }
        return last10;
    }
    
    public String cursorRight(int k) {
        while(k!=0 && cursor.next != tail) {
            cursor = cursor.next;
            k--;
        }
        String last10 = "";
        int toGoBack = 10;
        Node tempCursor = cursor;
        while(toGoBack!=0 && tempCursor != head) {
            last10 = tempCursor.value + last10;
            tempCursor = tempCursor.prev;
            toGoBack--;
        }
        return last10;
    }
}

class Node {
    Character value;
    Node prev;
    Node next;

    Node() {}

    Node(Character c) {
        this.value = c;
        prev = null;
        next = null;
    }
}