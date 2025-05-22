class Nodo {
    int dato;
    Nodo izq, der;

    Nodo(int dato) {
        this.dato = dato;
        izq = der = null;
    }
}

public class ArbolBinario {

    // Inserción en ABB
    Nodo insertar(Nodo raiz, int dato) {
        if (raiz == null)
            return new Nodo(dato);
        if (dato < raiz.dato)
            raiz.izq = insertar(raiz.izq, dato);
        else if (dato > raiz.dato)
            raiz.der = insertar(raiz.der, dato);
        return raiz;
    }

    // Recorrido Preorden (raíz - izq - der)
    void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preorden(nodo.izq);
            preorden(nodo.der);
        }
    }

    // Recorrido Inorden (izq - raíz - der)
    void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izq);
            System.out.print(nodo.dato + " ");
            inorden(nodo.der);
        }
    }

    // Recorrido Postorden (izq - der - raíz)
    void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izq);
            postorden(nodo.der);
            System.out.print(nodo.dato + " ");
        }
    }

    // Altura del árbol (o nodo)
    int altura(Nodo nodo) {
        if (nodo == null)
            return -1;
        return 1 + Math.max(altura(nodo.izq), altura(nodo.der));
    }

    // Profundidad de un nodo con cierto valor
    int profundidad(Nodo raiz, int dato) {
        if (raiz == null)
            return -1;
        if (raiz.dato == dato)
            return 0;

        int izq = profundidad(raiz.izq, dato);
        int der = profundidad(raiz.der, dato);

        if (izq != -1)
            return izq + 1;
        if (der != -1)
            return der + 1;

        return -1; // No encontrado
    }

    // Método principal de prueba
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Nodo raiz = null;
        int[] datos = {50, 30, 70, 20, 40, 60, 80};

        for (int dato : datos) {
            raiz = arbol.insertar(raiz, dato);
        }

        System.out.print("Preorden: ");
        arbol.preorden(raiz);
        System.out.print("\nInorden: ");
        arbol.inorden(raiz);
        System.out.print("\nPostorden: ");
        arbol.postorden(raiz);

        System.out.println("\nAltura del árbol: " + arbol.altura(raiz));
        System.out.println("Profundidad del nodo 40: " + arbol.profundidad(raiz, 40));
        System.out.println("Profundidad del nodo 70: " + arbol.profundidad(raiz, 70));
    }
}
}