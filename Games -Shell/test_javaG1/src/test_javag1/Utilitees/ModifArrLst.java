package test_javag1.Utilitees;

public class ModifArrLst<UnType> {

    private UnType[] tab;
    private int sequence = 0;

    public ModifArrLst() {
        tab = (UnType[]) new Object[100];
    }

    public int size() {
        return this.sequence;
    }

    public void add(UnType e) {
        tab[sequence] = e;
        sequence++;
    }

    public UnType set(int i, UnType e) {
        if (i < 0 || i >= sequence) {
            throw new IndexOutOfBoundsException();
        }
        UnType res = tab[i];
        tab[i] = e;
        return res; // retourne la valeur deja presente sur cette addresse
    }

    public UnType get(int i) {
        return tab[i];
    }

    public int getNum(UnType o) {
        for (int n = 0; n < sequence; n++) {
            if(o.toString().equals(tab[n].toString())){
                return n;
            }
        } return -1;
    }

    public UnType remove(int i) {
        if (i < 0 || i >= sequence) {
            throw new IndexOutOfBoundsException();
        }
        UnType res = tab[i];
        for (int j = i; j < sequence - 1; j++) {
            tab[j] = tab[j + 1]; // reculer toutes les valeurs en arriere
        }
        sequence--; // car on a enleve une valeur
        return res;
    }

    public String toString() {
        String res = "\n======\t======\n";
        for (int i = 0; i < sequence; i++) {
            UnType v = this.get(i);
            res += (i + ". " + v + "\n");
        }
        res += "======\t======\n";
        return res;
    }

}
