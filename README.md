[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/__xb4cFP)

This Scala project simulates a rice cooker with various functionalities such as cooking rice, boiling water, maintaining warmth, and more.

## Functionalities

### TRiceCooker Trait

The `TRiceCooker` trait defines the following functionalities for the rice cooker:

- `cook(minutes: String)`: Initiates the cooking process for a specified duration.
- `boil(minutes: String)`: Starts boiling water for a specified duration.
- `powerOn()`: Turns on the rice cooker.
- `powerOff()`: Turns off the rice cooker.
- `keepWarm()`: Keeps the food warm.
- `stopWarm()`: Stops the warm function.
- `getStatus()`: Retrieves the current status of the rice cooker.
- `addWater(liters: Int)`: Adds water to the rice cooker within its capacity.
- `addRice(grams: Int)`: Adds rice to the rice cooker within its capacity.
- `isCooking()`: Checks if the rice cooker is currently cooking.

## Conventional Coding Style

This project adheres to conventional coding practices in Scala to ensure readability, maintainability, and consistency across the codebase. Here are the key aspects of our coding conventions:

- **Naming Conventions**: Descriptive names following camelCase or PascalCase.
- **Indentation and Formatting**: Code is formatted for readability with consistent indentation.
- **Scala Version**: This project is built with Scala 2.13.
- **Running the Project**: Ensure Scala 2.13 is installed, then compile and run the project using `sbt` or your preferred Scala build tool.

## How to Run

To run the Scala Rice Cooker Application:

1. Make sure you have Scala 2.13 installed.
2. Clone the repository.
3. Navigate to the root directory of the project.
4. Compile and run the project using `sbt`, or your preferred Scala build tool.

Example using `sbt`:

```bash
sbt run
```
## Using IntelliJ IDEA with Scala Plugin

This project can be seamlessly developed using IntelliJ IDEA with the Scala plugin, providing a rich integrated development environment for Scala.

### FIRST STEP

1. **Install IntelliJ IDEA**: Download and install IntelliJ IDEA from the [official website](https://www.jetbrains.com/idea/).

2. **Install Scala Plugin**: Open IntelliJ IDEA and go to `File` > `Settings` > `Plugins`. Search for "Scala" in the Marketplace tab and install the Scala plugin.

### SECOND STEP

1. Clone the repository containing the Scala Rice Cooker project to your local machine.

2. Open IntelliJ IDEA and select `File` > `New` > `Project from Existing Sources`.

3. Navigate to the root directory of the cloned project and select it.

4. Choose "SBT" as the project model and click `Finish` to import the project.

### Working with Scala Code

- **Code Highlighting**: IntelliJ IDEA with the Scala plugin provides syntax highlighting, error checking, and code suggestions to facilitate Scala development.

- **Code Navigation**: Use keyboard shortcuts like `Ctrl + Click` or `Cmd + Click` to navigate to the definition of classes, methods, or traits.

- **Running Scala Code**: Run the Scala Rice Cooker application directly from IntelliJ IDEA by configuring a run configuration and executing the `Main.scala` file.

## Style

The code follows conventional Scala coding styles, including:

    Descriptive variable and function names.
    Proper indentation with two spaces.
    Consistent formatting for improved readability.
