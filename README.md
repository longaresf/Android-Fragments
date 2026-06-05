# Modular UI Architecture & Dynamic Fragments Flow

Este repositorio contiene un proyecto especializado en desarrollo móvil nativo para **Android** utilizando **Kotlin**. El objetivo principal es demostrar la implementación limpia y eficiente de una arquitectura basada en **Fragmentos (Fragments)**, permitiendo la creación de interfaces de usuario modulares, dinámicas y adaptables a diferentes tamaños de pantalla y flujos de navegación.

## 🚀 Características y Capacidades Técnicas

* **Arquitectura de Actividad Única (*Single-Activity*):** Uso de fragmentos como bloques modulares de construcción de UI encapsulados dentro de un contenedor principal, optimizando el rendimiento de la aplicación.
* **Transacciones Dinámicas de Fragmentos:** Reemplazo, adición y remoción de pantallas en tiempo de ejecución de manera fluida utilizando el `FragmentManager` y Jetpack Navigation Component.
* **Comunicación Inter-Fragmentos Segura:** Implementación de flujos limpios para compartir datos o eventos entre fragmentos sin generar acoplamiento fuerte interfaces, Shared ViewModel.
* **Control del Ciclo de Vida Independiente:** Gestión precisa de los estados del ciclo de vida específicos de los fragmentos (`onCreateView`, `onDestroyView`, etc.) para evitar fugas de memoria.

## 🛠️ Stack Tecnológico

* **Lenguaje Principal:** Kotlin
* **Plataforma:** Android SDK Nativo
* **Componente de UI:** Android Fragments Framework
* **IDE:** Android Studio
* **Gestión de Componentes:** View Binding.

## ⚙️ Arquitectura de Interfaz y Solución de Problemas

El desarrollo de este proyecto se centró en resolver desafíos clave de la modularidad en dispositivos móviles:

1. **Gestión del Backstack (Pila de Retroceso):** Se configuraron las transacciones para que el botón nativo de "Atrás" del dispositivo destruya o regrese al fragmento anterior de manera intuitiva, emulando la navegación por actividades pero con un consumo de recursos drásticamente menor.
2. **Ciclo de Vida y Memory Leaks:** Se aplicaron las mejores prácticas para la liberación de referencias visuales (como la asignación de bindings a `null` en `onDestroyView`), garantizando que las pantallas destruidas no retengan memoria RAM de forma innecesaria.
3. **Adaptabilidad del Layout:** Estructuración del diseño preparada para escalar hacia interfaces de panel dividido (*Master-Detail*) o flujos secuenciales según la orientación o resolución del hardware.

## 📌 Ejemplo de Transacción Implementada

La inyección dinámica de los componentes visuales se abstrae mediante transacciones limpias:

```kotlin
supportFragmentManager.beginTransaction()
    .replace(R.id.fragment_container, YourCustomFragment())
    .addToBackStack(null)
    .commit()
   ```
🔧 Configuración e Instalación Local
Para inspeccionar la lógica de las transacciones o compilar el proyecto en Android Studio, sigue estos pasos:

1. Clonar el repositorio:
   Bash
   git clone [https://github.com/longaresf/android-modular-ui-fragments.git](https://github.com/longaresf/android-modular-ui-fragments.git)

2. Abrir en Android Studio:
   Selecciona File > Open y elige el directorio clonado.

3. Sincronización:
   Deja que el sistema Gradle finalice la descarga de las librerías nativas configuradas.

4. Ejecución:
   Corre la aplicación en un emulador o dispositivo físico haciendo clic en el botón Run.

✒️ Autor

    Francisco Longares - Desarrollador Mobile Android - longaresf
