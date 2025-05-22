class RecorridoAnchuraConInterfaz {
    public static <T> String porNiveles(InterfazArbol<T> arbol) {
        if (arbol.esVacio()) return "";

        StringBuilder sb = new StringBuilder();
        Queue<InterfazArbol<T>> queue = new LinkedList<>();
        queue.add(arbol);

        while (!queue.isEmpty()) {
            InterfazArbol<T> actual = queue.poll();
            sb.append(actual.raiz()).append(" ");

            if (!actual.izq().esVacio()) queue.add(actual.izq());
            if (!actual.der().esVacio()) queue.add(actual.der());
        }
        return sb.toString();
    }
}

// Versión 2: usando clase Nodo

class RecorridoAnchuraConNodos {
    public static String porNiveles(Nodo raiz) {
        if (raiz == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<Nodo> queue = new LinkedList<>();
        queue.add(raiz);

        while (!queue.isEmpty()) {
            Nodo actual = queue.poll();
            sb.append(actual.dato).append(" ");

            if (actual.izq != null) queue.add(actual.izq);
            if (actual.der != null) queue.add(actual.der);
        }
        return sb.toString();
    }
}