class Pilha {
    private Veiculo[] stack;
    private int top;

    public Pilha(int capacity) {
        stack = new Veiculo[capacity];
        top = -1;
    }

    public void push(Veiculo veiculo) {
        if (top == stack.length - 1) {
            resize(2 * stack.length);
        }
        stack[++top] = veiculo;
    }

    public Veiculo pop() {
        if (isEmpty()) {
            return null;
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void resize(int capacity) {
        Veiculo[] copy = new Veiculo[capacity];
        for (int i = 0; i <= top; i++) {
            copy[i] = stack[i];
        }
        stack = copy;
    }
}
