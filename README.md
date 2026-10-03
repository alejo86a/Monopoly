# Monopoly

A Java desktop implementation of the classic Monopoly board game, adapted with a
"Monopoly Medellín" theme (custom board artwork referencing Medellín landmarks
and public transport: Metro, MetroCable, MetroPlus, Tranvía).

## Context

University coursework project for the "Análisis y Diseño 2" course at
Instituto Tecnológico Metropolitano (ITM), Medellín, Colombia.

## Tech stack

- Java 8
- Spring Boot 2.0.5 (used mainly for dependency wiring/bootstrapping)
- Java Swing for the graphical UI (`vista` package: panels for start screen,
  board, options and info)
- Apache Commons Digester / Commons IO

## Project structure

- `co.edu.itm.monopoly.modelo` – domain model (board, squares, players, cards,
  bank, taxes, properties, railways, etc.)
- `co.edu.itm.monopoly.controlador` – Swing controllers wiring UI to the model
- `co.edu.itm.monopoly.vista` – Swing panels (UI views)
- `res/` – board images, player tokens and card artwork

## How to run

```bash
./mvnw spring-boot:run
```

This launches the Swing desktop application (main class:
`co.edu.itm.monopoly.controlador.ControladorPrincipal`).

## Notes

This was built for academic purposes and is not an actively maintained
production project.
