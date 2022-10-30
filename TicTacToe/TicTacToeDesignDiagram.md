### Tic Tac Toe

## v1: Initial Design

```mermaid
classDiagram

    class Game{
        -Board board
        -HumanPlayer humanPlayer
        -BotPlayer botPlayer
        +register(HumanPlayer) HumanPlayer
        +startGame(HumanPlayer, BotPlayer, int row, int column) Board
        +makeMove(PlayerId, int x, int y) Board
    }

    class Board{
        -Cell[][] cells
        +Board(int, int): Board
    }

    class Cell{
        -int x
        -int y
        -Symbol symbol
    }

    class HumanPlayer{
        -String name
        -String email
        -Byte[] photo
        -Symbol symbol
        +play(Board) : cell
    }

    class BotPlayer{
        -Level level
        -Symbol symbol
        +play(Board): cell
    }

    Game "1" --* "1" Board
    Board "1" --* "*" Cell
    Game "1" --* "1" BotPlayer
    Game "1" --* "1" HumanPlayer

```
Problems
* There is no common contract (generic player) for Human and Bot Player to be used in methods such as make move.
* Human Player cannot play with human player. There is tight coupling between Game and different types of players. It is not extinsible to support multiple players.
* OCP & SRP violations in play() method based on the difficulty level.
* Huge memory consumption- multiple instances of the player will be created for multiple games. Each instances has a new photo.

## Solutions

### <b>Common contract - `Player parent class`</b>
- common beahviour - `play()`
- common attr - `symbol`

```mermaid
classDiagram
    class Player {
        <<abstract>>
        -Symbol symbol
        +play(Board)* Cell
    }

    class HumanPlayer{
        -String name
        -String email
        -String photo
        +play(Board) Cell
    }

    class BotPlayer{
        -Level level
        +play(Board) Cell
    }

    Player <|-- HumanPlayer
    Player <|-- BotPlayer

```
### Now

* ~~There is no common contract (generic player) for Human and Bot Player to be used in methods such as make move.~~
* Human Player cannot play with human player. There is tight coupling between Game and different types of players. It is not extinsible to support multiple players.
* OCP & SRP violations in play() method based on the difficulty level.
* Huge memory consumption- multiple instances of the player will be created for multiple games. Each instances has a new photo.

### <b>Tight coupling</b>
- HumanPlayer
- BotPlayer
- Player[] players

### <b>OCP and SRP violation in play method - `Strategy Pattern`</b>

### <b>Huge memory consumption - `Flyweight Pattern`</b>





