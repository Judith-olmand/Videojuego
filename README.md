# ⚔️ Videojuego RPG de Combate por Turnos

Juego de rol por consola desarrollado en Java que implementa un sistema de combate por turnos con múltiples clases de personajes, serialización de partidas y mecánicas de progresión.

## 📋 Descripción

Este es un RPG completo de combate por turnos donde el jugador puede elegir entre 4 clases diferentes (Guerrero, Mago, Elfo, Arquero), enfrentarse a enemigos generados aleatoriamente, y guardar/cargar su progreso mediante serialización de objetos.

## 🎮 Características Principales

- ⚔️ **4 Clases Jugables** con estadísticas únicas
- 🎲 **Generación Aleatoria** de enemigos y atributos
- 💾 **Sistema de Guardado** mediante serialización
- 🎯 **Combate Estratégico** por turnos
- 💚 **Sistema de Curación** para clases específicas
- 📊 **Seguimiento de Victorias** contra cada tipo de enemigo
- 🎨 **Interfaz Colorida** con códigos ANSI
- 🎭 **Polimorfismo y Herencia** en el diseño OOP

## 🏗️ Estructura del Proyecto

```
Videojuego RPG/
│
├── Personajes/                    # Paquete de personajes
│   ├── Personaje.java            # Clase abstracta base
│   ├── Guerrero.java             # Clase jugable: Alta defensa y salud
│   ├── Mago.java                 # Clase jugable: Alto ataque, baja defensa
│   ├── Elfo.java                 # Clase jugable: Equilibrado con curación
│   ├── Arquero.java              # Clase jugable: Stats medios
│   ├── Enemigo.java              # Enemigos generados aleatoriamente
│   ├── Curable.java              # Interfaz para habilidad de curación
│   └── NumeroAleatorio.java      # Utilidad para generar valores aleatorios
│
├── GestorPartida/                # Paquete de gestión de partidas
│   ├── GuardarPartida.java       # Serialización de la partida
│   └── CargarPartida.java        # Deserialización de la partida
│
├── Videojuego.java               # Clase principal (menú y flujo del juego)
├── CrearPersonaje.java           # Creación y selección de personajes
├── IniciarCombate.java           # Sistema de combate
├── Turnos.java                   # Gestión de turnos jugador/enemigo
├── MostrarEnemigosDerrotados.java # Estadísticas de combate
├── UsarHabilidadEspecial.java    # Sistema de habilidades (en desarrollo)
├── LectorArchivo.java            # Carga el banner ASCII del juego
├── Banner.txt                    # Arte ASCII del título
└── partida.dat                   # Archivo de guardado (generado)
```

## 🎭 Clases de Personajes

### ⚔️ Guerrero
```
💪 Salud: 160 HP (★★★★★)
🗡️ Ataque: 15-25 DPT (★★★★☆)
🛡️ Defensa: 10-18 DR (★★★★☆)
💚 Curación: ❌

Variación de daño: 80% - 120%
Ideal para: Jugadores que prefieren resistencia
```

### 🧙‍♂️ Mago
```
💪 Salud: 90 HP (★★☆☆☆)
🗡️ Ataque: 25-40 DPT (★★★★★)
🛡️ Defensa: 5-10 DR (★★☆☆☆)
💚 Curación: ✅ (15-30 HP)

Variación de daño: 70% - 140%
Ideal para: Jugadores agresivos y ofensivos
```

### 🧝 Elfo
```
💪 Salud: 110 HP (★★★☆☆)
🗡️ Ataque: 15-22 DPT (★★★☆☆)
🛡️ Defensa: 15-25 DR (★★★★★)
💚 Curación: ✅ (10-20 HP)

Variación de daño: 85% - 120%
Ideal para: Jugadores equilibrados y defensivos
```

### 🏹 Arquero
```
💪 Salud: 120 HP (★★★☆☆)
🗡️ Ataque: 18-28 DPT (★★★★☆)
🛡️ Defensa: 8-14 DR (★★★☆☆)
💚 Curación: ❌

Variación de daño: 90% - 120%
Ideal para: Jugadores equilibrados
```

## 👾 Enemigos

Los enemigos se generan aleatoriamente con los siguientes tipos:

- 🧟 **Orco** - Fuerza bruta
- 🧌 **Troll** - Alta resistencia
- 💀 **Esqueleto** - Rápido pero frágil
- 🐉 **Dragón** - Boss poderoso
- 👺 **Goblin** - Débil pero numeroso

**Estadísticas Aleatorias:**
- Salud: 80-130 HP
- Ataque: 10-25 DPT
- Defensa: 5-15 DR
- Variación de daño: 90% - 140%

## 🎮 Mecánicas de Juego

### Sistema de Combate

1. **Daño Base**: Cada ataque tiene un rango de variación
2. **Reducción de Daño**: `Daño Real = max(1, Daño - Defensa)`
3. **Daño Mínimo**: Siempre se inflige al menos 1 punto de daño
4. **Turnos Alternados**: Jugador → Enemigo → Jugador...

### Sistema de Curación

Solo disponible para **Mago** y **Elfo**:
- No puede exceder la salud máxima de la clase
- Se puede usar durante el turno del jugador
- Mago: 15-30 HP | Elfo: 10-20 HP

### Persistencia de Datos

- **Guardado**: Serializa el objeto `Personaje` completo
- **Cargado**: Restaura todos los atributos y progreso
- **Archivo**: `partida.dat` (binario)

## 🚀 Ejecución

### Requisitos

- Java JDK 8 o superior
- Archivo `Banner.txt` en el directorio raíz (opcional)

### Compilación

```bash
# Compilar todos los archivos
javac Personajes/*.java
javac GestorPartida/*.java
javac *.java
```

### Ejecución

```bash
java Videojuego
```

## 📊 Flujo del Juego

```
┌─────────────────────┐
│   Menú Principal    │
│  1. Nueva partida   │
│  2. Cargar partida  │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│ Selección de Clase  │
│  • Guerrero 🗡️     │
│  • Mago 🧙‍♂️        │
│  • Elfo 🧝          │
│  • Arquero 🏹       │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│  Aparece Enemigo    │
│  (Aleatorio)        │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│   Turno Jugador     │
│  1. Atacar          │
│  2. Guardar y salir │
│  3. Huir            │
│  4. Ver victorias   │
│  5. Ver HP          │
│  6. Curarse*        │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│   Turno Enemigo     │
│  (Ataque auto)      │
└──────────┬──────────┘
           │
      ┌────┴────┐
      │         │
   Victoria   Derrota
      │         │
      └────┬────┘
           │
           ▼
┌─────────────────────┐
│ ¿Continuar?         │
│  S → Nuevo combate  │
│  N → Guardar/Salir  │
└─────────────────────┘
```

## 🎨 Características Visuales

### Códigos de Color ANSI

```java
🟢 fondoVerde = "\u001B[42m"  // Mensajes positivos
🔴 fondoRojo = "\u001B[41m"   // Errores
🟣 fondoLila = "\u001B[45m"   // Títulos de sección
🔵 fondoAzul = "\u001B[46m"   // Información de combate
```

### Emojis Utilizados

- ⚔️ Combate
- 🗡️ Guerrero
- 🧙‍♂️ Mago
- 🧝 Elfo
- 🏹 Arquero
- 💚 Curación
- 🎯 Ataque
- 🛡️ Defensa
- ⛔ Error

## 💾 Sistema de Guardado

### Estructura del Archivo Serializado

```
partida.dat (binario)
├── Nombre del personaje
├── Clase (Guerrero/Mago/Elfo/Arquero)
├── Salud actual
├── Ataque
├── Defensa
└── Map<String, Integer> enemigosDerrotados
```

### Métodos de Guardado

**Guardar Partida:**
```java
GuardarPartida.guardarPartida(jugador);
// Serializa el objeto completo en partida.dat
```

**Cargar Partida:**
```java
Personaje jugador = CargarPartida.cargarPartida();
// Deserializa y restaura el progreso
```

## 🎓 Conceptos de Programación Aplicados

### Programación Orientada a Objetos

- ✅ **Herencia**: `Guerrero extends Personaje`
- ✅ **Polimorfismo**: `Personaje jugador = new Mago()`
- ✅ **Abstracción**: Clase abstracta `Personaje`
- ✅ **Encapsulación**: Atributos privados con getters/setters
- ✅ **Interfaces**: `Curable` implementada por Mago y Elfo

### Patrones y Técnicas

- 🏗️ **Template Method**: `atacar()` implementado en subclases
- 📦 **Serialization**: Persistencia de objetos
- 🎲 **Factory Pattern**: Generación de enemigos
- 🔄 **Polymorphic Dispatch**: Métodos sobrescritos
- 🎯 **Type Checking**: `instanceof` para casting seguro

## 🎯 Ejemplo de Combate

```
⚔️⚔️⚔️ INICIANDO COMBATE ⚔️⚔️⚔️

Se acerca un Orco
El Orco tiene 115 HP de salud, 18 DPT de ataque y 9 DR de defensa.

        TURNO DEL JUGADOR
¿Qué quieres hacer?
1. Atacar
2. Guardar partida y salir
3. Huir y salir
4. Mostrar enemigos derrotados
5. Mostrar datos de la salud
6. Curarte

> 1

Arthas golpea a Orco causando 22 de daño.
Orco tiene una defensa de 9 DR y solo recibe 13 de daño.
Orco tiene 102 HP restantes.

        TURNO DEL ENEMIGO
Orco lanza un ataque a Arthas de 19 de daño.
Arthas tiene una defensa de 14 DR y solo recibe 5 de daño.
Arthas tiene 155 HP restantes.

...

¡Has derrotado al Orco!
```

## 📊 Seguimiento de Progreso

El juego rastrea tus victorias en un `Map<String, Integer>`:

```java
// Ejemplo de salida
ENEMIGOS DERROTADOS
Orco - 3
Goblin - 5
Troll - 1
Esqueleto - 7
```

## 🔧 Personalización y Extensiones

### Añadir Nueva Clase de Personaje

1. Crear nueva clase que extienda `Personaje`
2. Definir stats en el constructor
3. Implementar método `atacar()`
4. (Opcional) Implementar interfaz `Curable`
5. Agregar al switch de `CrearPersonaje`

### Añadir Nuevo Tipo de Enemigo

Modificar el array en `Enemigo.java`:
```java
private static final String[] nombres = {
    "Orco", "Troll", "Esqueleto", "Dragón", "Goblin", "NuevoEnemigo"
};
```

### Añadir Habilidades Especiales

Actualmente `UsarHabilidadEspecial.java` está preparado para expansión.

## ⚠️ Manejo de Errores

El juego maneja:
- ✅ Entrada inválida del usuario (`InputMismatchException`)
- ✅ Archivo de partida no encontrado (`IOException`)
- ✅ Clase no encontrada al deserializar (`ClassNotFoundException`)
- ✅ Salud negativa (evitada con validaciones)

## 🐛 Troubleshooting

### Problema: No se carga la partida guardada

**Solución:**
1. Verifica que existe `partida.dat`
2. Asegúrate de no haber modificado las clases después de guardar
3. Añade `serialVersionUID` a las clases `Serializable`

### Problema: Valores de ataque/defensa parecen incorrectos

**Explicación:**
- Los valores se generan aleatoriamente en cada creación
- La variación de daño añade más aleatoriedad (80%-140%)
- La defensa reduce el daño final

### Problema: El personaje se cura por encima del máximo

**No es un bug:**
- `Math.min()` limita la curación al máximo de la clase
- Revisa la constante `vida` de cada clase

## 📈 Mejoras Futuras

- [ ] Sistema de experiencia y niveles
- [ ] Inventario de objetos
- [ ] Habilidades especiales únicas por clase
- [ ] Diferentes tipos de combate (bosses, arenas)
- [ ] Sistema de logros
- [ ] Interfaz gráfica (GUI)
- [ ] Multijugador local
- [ ] Mazmorras procedurales
- [ ] Sistema de equipamiento

## 🎓 Ejercicios Propuestos

1. **Básico**: Añade un nuevo tipo de enemigo "Vampiro" que se cure al atacar
2. **Intermedio**: Implementa un sistema de experiencia y niveles
3. **Avanzado**: Crea un inventario con pociones y equipamiento
4. **Experto**: Implementa un sistema de habilidades únicas por clase

## 📚 Conceptos para Estudiar

- Serialización de objetos en Java
- Polimorfismo y casting seguro
- Uso de interfaces vs clases abstractas
- Generación de números aleatorios
- Manejo de excepciones
- Colecciones (Map, HashMap)
- Try-with-resources
- Organización en paquetes

## 📖 Recursos de Aprendizaje

- [Oracle Docs: Serialization](https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html)
- [Java OOP Tutorial](https://docs.oracle.com/javase/tutorial/java/concepts/)
- [Java Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/)

## 📝 Notas del Desarrollador

### Diseño de Balanceo

- **Guerrero**: Tank - aguanta mucho pero daño moderado
- **Mago**: Glass Cannon - máximo daño pero muy frágil
- **Elfo**: Tanque Mágico - alta defensa con curación
- **Arquero**: Equilibrado - sin puntos débiles ni fuertes

### Decisiones de Diseño

1. **Daño mínimo de 1**: Evita combates infinitos
2. **Variación de daño**: Añade incertidumbre táctica
3. **Defensa escalada**: Hace que las clases se sientan diferentes
4. **Curación limitada**: Solo 2 clases para balance

## 📄 Licencia

Proyecto educativo para aprendizaje de Java y programación orientada a objetos.

## 👤 Autor

Videojuego RPG desarrollado como proyecto de aprendizaje de Java, demostrando conceptos de OOP, serialización, y diseño de sistemas de juego.

---

## 🎮 ¡Disfruta el Juego!

Escoge tu clase, derrota enemigos, y conviértete en leyenda. ⚔️

**Recuerda**: Guarda tu partida frecuentemente y... ¡que la suerte esté de tu lado!
