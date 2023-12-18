[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/__xb4cFP)

# Rice Cooker TypeScript Project

This project implements a Rice Cooker program using TypeScript.

## Prerequisites

Ensure you have Node.js installed on your machine.

## Installation

1. Clone the repository:

   ```bash
   git clone <repository_url>

   ```
   Install dependencies:
   ```bash
    cd rice-cooker-ts
    npm install
    ```

Setting Up TypeScript and Jest

This project uses TypeScript for static typing and Jest for testing. Follow these steps to configure TypeScript and Jest:
    Install TypeScript and Jest as dev dependencies:
    ```
npm install --save-dev typescript jest @types/jest ts-jest
    ```
Configure TypeScript:

Create a tsconfig.json file in the root directory of your project:

```bash
json

{
  "compilerOptions": {
    "target": "es6",
    "module": "commonjs",
    "strict": true,
    "esModuleInterop": true
  },
  "include": ["src/**/*"],
  "exclude": ["node_modules", "**/*.spec.ts"]
}
```
Configure Jest:

Create a jest.config.js file in the root directory:

javascript

    module.exports = {
      preset: 'ts-jest',
      testEnvironment: 'node',
    };

Setting Up ESLint

This project uses ESLint for linting. Follow these steps to configure ESLint with TypeScript:

Install ESLint and necessary plugins:

```
npm install --save-dev eslint @typescript-eslint/eslint-plugin @typescript-eslint/parser
```
Create an ESLint configuration file:

Create a .eslintrc.json file in the root directory:

```bash
json

    {
      "env": {
        "browser": true,
        "es6": true
      },
      "parser": "@typescript-eslint/parser",
      "parserOptions": {
        "ecmaVersion": 2021,
        "sourceType": "module"
      },
      "plugins": ["@typescript-eslint"],
      "extends": [
        "eslint:recommended",
        "plugin:@typescript-eslint/eslint-recommended",
        "plugin:@typescript-eslint/recommended"
      ],
      "rules": {
      }
    }
```

Usage

After setting up the project and configurations, you can run the tests or start the program by running appropriate npm scripts.
