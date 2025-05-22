public class Floyd {
}
public ArrayList<ArrayList<Integer>> floyd(Grafo grafo) {

    ArrayList<String> vertices = new ArrayList<>(grafo.vertices());
    int n = vertices.size();

    // Inicializar matriz de distancias
    ArrayList<ArrayList<Integer>> dist = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        ArrayList<Integer> fila = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (i == j) {
                fila.add(0);
            } else {
                int coste = grafo.coste(vertices.get(i), vertices.get(j));
                fila.add(coste);
            }
        }
        dist.add(fila);
    }

    // Algoritmo de Floyd-Warshall
    for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ik = dist.get(i).get(k);
                int kj = dist.get(k).get(j);
                int ij = dist.get(i).get(j);
                if (ik < Integer.MAX_VALUE && kj < Integer.MAX_VALUE && ik + kj < ij) {
                    dist.get(i).set(j, ik + kj);
                }
            }
        }
    }

    return dist;
}