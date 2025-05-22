class Nodo {
    int dato;
    Nodo izq, der;

    Nodo(int dato) {
        this.dato = dato;
        izq = der = null;
    }
}
// Clase Arista: representa una conexión con peso
class Arista {
    String destino;
    int peso;
//
    Arista(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

// Clase Grafo: implementación base de un grafo ponderado no dirigido
import java.util.*;

class Grafo {
    private Map<String, List<Arista>> adyacencias = new HashMap<>();

    // Agrega un nodo (vértice) al grafo
    public void agregarNodo(String nodo) {
        adyacencias.putIfAbsent(nodo, new ArrayList<>());
    }

    // Agrega una arista ponderada entre dos nodos
    public void agregarArista(String origen, String destino, int peso) {
        adyacencias.get(origen).add(new Arista(destino, peso));
        adyacencias.get(destino).add(new Arista(origen, peso));

        // 👉 Si el grafo fuera DIRIGIDO, COMENTA la línea siguiente:
        // adyacencias.get(destino).add(new Arista(origen, peso));
    }

    // Devuelve solo los nombres de los nodos adyacentes a uno dado
    public List<String> obtenerAdyacencias(String nodo) {
        List<String> vecinos = new ArrayList<>();
        for (Arista a : adyacencias.getOrDefault(nodo, new ArrayList<>())) {
            vecinos.add(a.destino);
        }
        return vecinos;
    }

    // Devuelve todas las aristas con destino y peso
    public List<Arista> obtenerAristas(String nodo) {
        return adyacencias.getOrDefault(nodo, new ArrayList<>());
    }
}

// Clase principal con ejemplo de uso
public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.agregarNodo("A");
        grafo.agregarNodo("B");
        grafo.agregarNodo("C");

        grafo.agregarArista("A", "B", 4);
        grafo.agregarArista("B", "C", 2);
        grafo.agregarArista("A", "C", 5);

        System.out.println("Adyacencias de A: " + grafo.obtenerAdyacencias("A"));
        System.out.println("Aristas desde A:");
        for (Arista a : grafo.obtenerAristas("A")) {
            System.out.println("  -> " + a.destino + " (" + a.peso + ")");
        }
    }
}

// 🧠 TRUCO 1: Si no dicen el tipo de grafo, usa NO DIRIGIDO y PONDERADO (más completo y sirve para todo)
// 🧠 TRUCO 2: Si te piden NO PONDERADO, puedes usar List<String> en lugar de List<Arista> y quitar el peso