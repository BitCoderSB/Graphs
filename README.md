# 📊 Graphs — Motor de Visualización y Análisis de Grafos

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/JavaFX-007396?style=for-the-badge&logo=java&logoColor=white" alt="JavaFX"/>
  <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white" alt="CSS"/>
  <img src="https://img.shields.io/badge/License-MIT-green?style=for-the-badge" alt="License"/>
</p>

**Graphs** es un motor interactivo de visualización y análisis de grafos construido con **Java** y **JavaFX**. Diseñado para ofrecer una experiencia visual fluida e intuitiva, permite construir, manipular y analizar estructuras de grafos en tiempo real mediante una interfaz gráfica completamente interactiva con renderizado dinámico.

---

## ✨ Características Principales

### 🖱️ Construcción Interactiva de Grafos
- **Creación de vértices con doble clic** — Agrega nodos en cualquier punto del canvas con un simple doble clic. El sistema detecta automáticamente colisiones para evitar solapamientos.
- **Creación de aristas mediante drag & drop** — Arrastra desde un vértice origen hacia un vértice destino para crear conexiones de manera visual e intuitiva.
- **Asignación automática de pesos** — Las aristas se generan con pesos aleatorios, simulando escenarios reales de redes ponderadas.

### 🔄 Manipulación en Tiempo Real
- **Drag & Drop de vértices** — Reposiciona cualquier nodo libremente por el canvas. Todas las aristas conectadas se recalculan y redibujan dinámicamente manteniendo la coherencia visual del grafo.
- **Renderizado en vivo** — El motor de renderizado repinta todo el grafo en cada frame de interacción, garantizando una visualización siempre actualizada y sin artefactos gráficos.

### 🏹 Soporte para Grafos Dirigidos
- **Flechas direccionales** — Las aristas dirigidas se representan con puntas de flecha triangulares renderizadas con cálculos vectoriales precisos, indicando claramente la dirección del flujo.
- **Cálculo vectorial avanzado** — El sistema utiliza normalización de vectores, productos perpendiculares y geometría computacional para posicionar las flechas perfectamente en el borde de cada vértice.

### 📐 Algoritmos de Grafos
- **DFS (Depth-First Search)** — Recorrido en profundidad para exploración exhaustiva del grafo.
- **BFS (Breadth-First Search)** — Recorrido en amplitud para búsqueda por niveles.
- **Dijkstra** — Algoritmo de caminos más cortos para encontrar la ruta óptima entre dos nodos en grafos ponderados.
- **Prim** — Algoritmo de árbol de expansión mínima para encontrar el subconjunto de aristas que conecta todos los vértices con el menor costo total.

### 🗃️ Estructura de Datos Optimizada
- **Lista de adyacencia con HashMap** — Implementación eficiente basada en `HashMap<Vertex, List<Edge>>` que proporciona acceso O(1) a los vecinos de cualquier vértice.
- **Detección de duplicados** — El sistema previene la creación de vértices y aristas duplicados, manteniendo la integridad estructural del grafo.
- **Detección de colisiones circular** — Algoritmo de hit-testing basado en distancia euclidiana para detectar si un punto del canvas intersecta con un vértice existente.

### 🎨 Interfaz Visual Personalizada
- **Estilos CSS personalizados** — Diseño visual modular con hojas de estilo CSS que controlan la apariencia de vértices, aristas, etiquetas y flechas direccionales.
- **Vértices con etiquetas** — Cada nodo muestra su identificador con tipografía en negrita para máxima legibilidad.
- **Pesos visibles en aristas** — Los valores de peso se muestran sobre cada arista con estilo destacado en rojo para fácil identificación.
- **Interfaz responsive** — El panel principal se adapta al tamaño de la ventana utilizando bindings de JavaFX.

---

## 🏗️ Arquitectura

El proyecto sigue una arquitectura **MVC (Model-View-Controller)** limpia:

```
src/
├── Controllers/          # Controladores de la interfaz
│   ├── main.java         # Punto de entrada de la aplicación
│   └── GraphViewerController.java  # Controlador principal del canvas
├── Data/                 # Modelos de datos
│   ├── Vertex.java       # Representación de vértices con renderizado
│   └── Edge.java         # Representación de aristas dirigidas
├── Logic/                # Lógica de negocio
│   └── Graph.java        # Motor del grafo (lista de adyacencia)
├── Scenes/               # Vistas FXML
│   └── graphViewer.fxml  # Layout principal de la interfaz
└── Styles/               # Hojas de estilo
    └── graphviewer.css   # Estilos visuales del grafo
```

---

## 🚀 Cómo Ejecutar

### Prerrequisitos
- **Java JDK 21** o superior
- **JavaFX SDK**
- **Apache NetBeans** (recomendado) o cualquier IDE con soporte para JavaFX

### Ejecución
1. Clona el repositorio:
   ```bash
   git clone https://github.com/BitCoderSB/Graphs.git
   cd Graphs
   ```
2. Abre el proyecto en NetBeans o tu IDE preferido.
3. Ejecuta la clase `Controllers.main`.

---

## 🎮 Guía de Uso

| Acción | Cómo hacerlo |
|--------|-------------|
| Crear vértice | Doble clic en cualquier punto vacío del canvas |
| Crear arista | Clic sostenido en un vértice y arrastra hacia otro |
| Mover vértice | Activa "Mover Vertices" ☑️ y arrastra el nodo |

---

## 👤 Autor

**Carlos** — [@BitCoderSB](https://github.com/BitCoderSB)

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT.
