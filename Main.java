import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Fila fila = new Fila();
        for (int i = 0; i < 20; i++) {
            fila.enqueue(new Veiculo());
        }

        Mapa mapa = new Mapa(10);
        for (int i = 0; i < 20; i++) {
            mapa.put(new Veiculo());
        }

        while (true) {
            System.out.println("\n### MENU ###");
            System.out.println("1. Mostrar fila original de veículos");
            System.out.println("2. Inverter a fila de veículos");
            System.out.println("3. Remover veículos com marcas palíndromos da fila");
            System.out.println("4. Mostrar mapa de veículos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Fila original:");
                    fila.show();
                    break;
                case 2:
                    Pilha pilha = new Pilha(fila.size());
                    while (!fila.isEmpty()) {
                        pilha.push(fila.dequeue());
                    }
                    while (!pilha.isEmpty()) {
                        fila.enqueue(pilha.pop());
                    }
                    System.out.println("Fila invertida:");
                    fila.show();
                    break;
                case 3:
                    Fila novaFila = new Fila();
                    while (!fila.isEmpty()) {
                        Veiculo v = fila.dequeue();
                        if (!Palindromo.isPalindromo(v.getMarca())) {
                            novaFila.enqueue(v);
                        }
                    }
                    fila = novaFila;
                    System.out.println("Fila sem marcas palíndromos:");
                    fila.show();
                    break;
                case 4:
                    System.out.println("Mapa de veículos:");
                    mapa.show();
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        }
    }
}
