class Mapa {
    private Veiculo[] mapa;
    private int size;

    public Mapa(int capacity) {
        mapa = new Veiculo[capacity];
        size = 0;
    }

    public int hash(int chassi) {
        return chassi % mapa.length;
    }

    public void put(Veiculo veiculo) {
        if (size >= mapa.length) {
            resize(2 * mapa.length);
        }
        int hash = hash(veiculo.getChassi());
        while (mapa[hash] != null) {
            hash = (hash + 1) % mapa.length;
        }
        mapa[hash] = veiculo;
        size++;
    }

    public Veiculo get(int chassi) {
        int hash = hash(chassi);
        while (mapa[hash] != null) {
            if (mapa[hash].getChassi() == chassi) {
                return mapa[hash];
            }
            hash = (hash + 1) % mapa.length;
        }
        return null;
    }

    public void remove(int chassi) {
        int hash = hash(chassi);
        while (mapa[hash] != null) {
            if (mapa[hash].getChassi() == chassi) {
                mapa[hash] = null;
                size--;
                return;
            }
            hash = (hash + 1) % mapa.length;
        }
    }

    private void resize(int capacity) {
        Veiculo[] oldMapa = mapa;
        mapa = new Veiculo[capacity];
        size = 0;
        for (Veiculo veiculo : oldMapa) {
            if (veiculo != null) {
                put(veiculo);
            }
        }
    }

    public void show() {
        for (Veiculo veiculo : mapa) {
            if (veiculo != null) {
                System.out.println(veiculo);
            }
        }
    }
}
