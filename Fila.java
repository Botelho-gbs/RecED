class Fila {
    private Node front, rear;
    private int size;

    public Fila() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public void enqueue(Veiculo veiculo) {
        Node newNode = new Node(veiculo);
        if (this.rear == null) {
            this.front = this.rear = newNode;
        } else {
            this.rear.next = newNode;
            this.rear = newNode;
        }
        size++;
    }

    public Veiculo dequeue() {
        if (this.front == null) {
            return null;
        }
        Node temp = this.front;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        size--;
        return temp.veiculo;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public int size() {
        return this.size;
    }

    public void show() {
        Node temp = front;
        while (temp != null) {
            System.out.println(temp.veiculo);
            temp = temp.next;
        }
    }
}
