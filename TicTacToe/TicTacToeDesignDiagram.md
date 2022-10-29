### Tic Tac Toe

### Initial Design

```mermaid

classDiagram

    class Game{
        -Board board
        -HumanPlayer humanPlayer
        -BotPlayer botPlayer
        +register(HumanPlayer) HumanPlayer
        +startGame(HumanPlayer, BotPlayer, int row, int column) Board
        +makeMove(int, int, int) Board
    }
