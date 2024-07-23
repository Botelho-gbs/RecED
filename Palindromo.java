class Palindromo {
    public static boolean isPalindromo(String palavra) {
        Pilha pilha = new Pilha(palavra.length());
        for (int i = 0; i < palavra.length(); i++) {
            pilha.push(new Veiculo());
        }
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) != pilha.pop().getMarca().charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
