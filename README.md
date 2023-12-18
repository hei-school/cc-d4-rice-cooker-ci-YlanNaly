[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/__xb4cFP)

This Kotlin project simulates a rice cooker with various functionalities such as cooking rice, boiling water, maintaining warmth, and more.
Functionality
*IRiceCooker Interface*

The IRiceCooker interface defines the following functionalities for the rice cooker:

    cook(minutes: String): Initiates the cooking process for a specified duration.
    boil(minutes: String): Starts boiling water for a specified duration.
    powerOn(): Turns on the rice cooker.
    powerOff(): Turns off the rice cooker.
    keepWarm(): Keeps the food warm.
    stopWarm(): Stops the warm function.
    getStatus(): String: Retrieves the current status of the rice cooker.
    addWater(liters: Int): Adds water to the rice cooker within its capacity.
    addRice(grams: Int): Adds rice to the rice cooker within its capacity.
    isCooking(): Boolean: Checks if the rice cooker is currently cooking.

## Usage

The application logic in Main.kt allows users to interact with the rice cooker functionalities using a console-based menu system. Users can perform operations such as cooking rice, boiling water, turning the cooker on/off, keeping food warm, and checking the status.
Convention and Coding Style

This project adheres to conventional coding practices in Kotlin to ensure readability, maintainability, and consistency across the codebase. Here are the key aspects of our coding conventions:

1. Naming Conventions: Descriptive names are used for classes, functions, variables following camelCase or PascalCase.

2. Indentation and Formatting: Code is formatted with 4 spaces for indentation. Braces are placed at the end of the line. Code lines are limited within recommended length.

3. Kotlin Code Style: We follow the official Kotlin code style guide provided by JetBrains (kotlin.code.style=official).

4. Ktlint: Although the project attempts to use the Ktlint Maven plugin (com.github.shyiko:ktlint-maven-plugin) to enforce consistent code formatting and style, there might be circumstances where direct usage of Ktlint from the command line or IDE plugin might be necessary.

5. Documentation: KDoc is used for documenting classes, functions, and significant code sections to enhance code readability and maintainability.

6. Null Safety: The project leverages Kotlin's null safety features to handle null values effectively.

## Ktlint Integration

The project attempts to use the Ktlint Maven plugin for enforcing code style and formatting. This plugin helps maintain consistency across the codebase by ensuring adherence to the established conventions.
