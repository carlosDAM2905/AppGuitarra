# 🎸 AppGuitarra

**AppGuitarra** es una aplicación educativa desarrollada en Android con Jetpack Compose cuyo objetivo es ayudar a los usuarios a aprender teoría musical aplicada a la guitarra de forma interactiva y visual. Forma parte del **proyecto final del CFGS de Desarrollo de Aplicaciones Multiplataforma (DAM)**.

---

## 📱 Funcionalidades principales

- ✅ Lecciones teóricas ilustradas (armaduras, modos griegos, etc.).
- ✅ Actividades interactivas tipo test con imágenes y animaciones.
- ✅ Sistema de progreso que se guarda localmente con Room.
- ✅ Rosco de progreso circular animado.
- ✅ Navegación entre pantallas con Jetpack Navigation.
- ✅ Animaciones al progresar en actividades y superarlas.
- ✅ Diferentes pantallas de evaluación con feedback según el resultado.

---

## 🧱 Tecnologías utilizadas

- **Kotlin**
- **Jetpack Compose**
- **Room (base de datos local)**
- **ViewModel + State Management**
- **Jetpack Navigation**
- **Lottie (animaciones de confeti)**
- **Material 3**

---

## 🗂 Estructura del proyecto

```
com.example.appguitarra/
│
├── data/                  → Entidades, DAOs y base de datos Room
├── navigation/            → Gestión de rutas entre pantallas
├── ui/                    
│   ├── principal/         → Pantalla de inicio con el mástil, botones y rosco de progreso
│   ├── teoria/            → Pantallas teóricas ilustradas
│   ├── actividades/       → Actividades interactivas tipo test
│   └── components/        → Componentes visuales reutilizables
├── viewmodel/             → Gestión del estado y lógica de UI
└── MainActivity.kt        → Punto de entrada de la app
```

---

## 🧪 Cómo ejecutar el proyecto

1. Clona el repositorio:

   ```bash
   git clone https://github.com/carlosDAM2905/AppGuitarra.git
   ```

2. Ábrelo con **Android Studio** (Hedgehog o posterior).

3. Asegúrate de tener instalado un emulador o dispositivo físico.

4. Ejecuta el proyecto pulsando ▶️.

---



## 👥 Autores

Este proyecto ha sido desarrollado por los siguientes alumnos del **CFGS de Desarrollo de Aplicaciones Multiplataforma**:

- **Carlos Gómez**
- **Robert George**
- **Sergio Benzal**

---

## 📄 Licencia

Proyecto académico sin fines comerciales.
