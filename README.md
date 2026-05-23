# task. — Productivity Tool 

> A clean and minimal Android task management app built with Jetpack Compose.  
> Designed to help you organize and track your daily tasks with a smooth, modern UI.

---

## Project Description

**task.** is an Android productivity application that allows users to manage their daily tasks efficiently.  
The app features a warm **burgundy and beige** color theme, smooth navigation between screens, and an intuitive interface that makes task tracking simple and enjoyable.

**Key Features:**
- Splash screen with the app branding on launch
- Login screen with username and password authentication
- Home screen displaying all saved tasks in a clean list
- Add Task screen to create new tasks with a title and description
- Profile screen showing the logged-in user's info
- Consistent custom theme applied across all screens

---

## Technologies Used

| Technology | Purpose |
|---|---|
| **Kotlin** | Primary programming language |
| **Jetpack Compose** | Declarative UI framework for building all screens |
| **Navigation Component (Compose)** | Screen routing and navigation graph management |
| **Material 3** | Design system and UI components |
| **ViewModel + State** | State management across screens |
| **Android Studio** | Development environment |
| **Git & GitHub** | Version control and collaboration |

---

## Screenshots



---

## Getting Started

### Prerequisites

Before running the project, make sure you have the following installed:

- [Android Studio](https://developer.android.com/studio) (Hedgehog or later)
- Android SDK (API level 26 or higher)
- Kotlin plugin (comes bundled with Android Studio)
- A physical device or emulator running Android 8.0+

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone https://github.com/hala-dalloul/github-training-project.git
   ```

2. **Open in Android Studio**  
   Go to `File → Open` and select the cloned project folder.

3. **Sync Gradle**  
   Android Studio will automatically sync dependencies. Wait for the sync to finish.

4. **Run the app**  
   Click the ▶️ **Run** button or use the shortcut `Shift + F10`.  
   Select your device or emulator from the list.

5. **Login credentials (for testing)**
   ```
   Username: admin
   Password: admin
   ```

---

## Project Structure

```
app/
└── src/
    └── main/
        └── java/com/example/todo_list/
            ├── data/
            │   └── Task.kt          # Task data model
            ├── navigation/
            │   ├── NavGraph.kt      # Navigation graph & task state
            │   └── Screens.kt       # Screen route definitions
            └── ui/
                ├── screens/
                │   ├── SplashScreen.kt
                │   ├── LoginScreen.kt
                │   ├── HomeScreen.kt
                │   ├── AddTaskScreen.kt
                │   └── ProfileScreen.kt
                └── theme/
                    ├── Color.kt
                    ├── Theme.kt
                    └── Type.kt
```

---

## Student Info

| Field | Details |
|---|---|
| **Name** | Hala Dalloul |
