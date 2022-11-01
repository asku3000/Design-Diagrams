# SNAKES AND LADDERS

## QUESTIONS - Current scope
- Board Size `1-> N`
- Multiple Players `> 2`
- `Only` Human Player
- Start Game Dice `1 Or 6/Maximum`
- Snakes & Ladders
    - User inputs the number of snakes and ladders
    - OR Random
    - OR eq number
- A player wins by reaching the last cell
- A player can have multiple tokens
- 1st - All tokens of a single player reaches the last
- If N-1 players wins then `Game Ends`
- Leaderboard

## ACTUAL REQUIREMENT
- A game can be between multiple players.
- A game will only have human players
- Each player can have multiple pieces
- A board can be of any varying size decided by the client
- A board will have different types of cells
- There can be a normal cell and cells with snakes and ladders
- Position of snakes and ladders is random and decided at the start of the game
- The number of snakes and ladders is random and also decided at the start of the game
- The size of snakes and ladders is also random and decided at the start of the game
- A player will move on the basis of a dice
- A player will enter the game only if they get a 1 or maximum face value of the dice
- A player will win if they reach the last cell
- The game will end when all players expect one reach the last cell
- For each game maintain a leaderboard which has the rankings of each player

## ENTITES

- Game
    - Board
        - Cells
        - Snake
        - Ladder
        - Tokens
    - DICE
    - Players
    - LeaderBoard

## Initial Design

```mermaid
classDiagram
 
    class Game{
        -Board board
        -List<Players> players
        -Dice dice
        -LeaderBoard leaderboard
        -StatusType status
        +createGame(CreateGameRequest) Game
        +roll() int
        +makeMove(Player, token)
        +updateLeaderBoard() LeaderBoard
    }

    class Board{
        -int size
        -List<Cells> cells
        -List<Snakes> snakes
        -List<Ladders> ladders

    }

    class Dice{
        -int facevalue
        +roll() int
    }

    class Cell{
        -List<Token> tokens
        -int position
    }

    class Snake{
        -start
        -end
    }

    class Ladder{
        -start
        -end
    }

    class Token{
        String colour
    }

    Game "1" --* "1" Board
    Board "1" --* "M" Cell
    Board "1" --* "M" Snake
    Board "1" --* "M" Ladder
    Game "1" --* "M" Dice
    
    class Player{
        composition because no requirement of registering
        -String name
        -List<Token> tokens
    }

    class Token{
        -colour
    }

    Game "1" --* "M" Player
    Player "1" --* "M" Token
    Cell "1" --* "M" Token

    class LeaderBoard{
        -List<PlayerRanking> rankings
    }

    class PlayerRanking{
        -Player player
        -int ranking
    }

    Game "1" --* "1" LeaderBoard
    LeaderBoard "1" --* "*" PlayerRanking
```

## Problems with Initial Design
- OCP violation in Board, if have to add new type of snake ladder kind of think like frog etc.
- No parent class for specials cells

## Solutions

### Adding a new parent class for snake and ladder

```mermaid
classDiagram

    class Obstacle{
        <<abstract>>
        -int start
        -int end
        +nextLoaction()* int
    }

    class Snake{
        +nextLoaction() int
    }

    class Ladder{
         +nextLoaction() int
    }

    class Board{
        -int size
        -List<Cells> cells
        

    }

    class Cell{
        -List<Token> tokens
        -int position
        -List<Obstacle> obstacles
    }


    Obstacle <|-- Snake
    Obstacle <|-- Ladder
    Board "1" --* "*" Cell
    Cell "1" --* "*" Obstacle

```

- Problem here is we have to add null checks because cell might have obstacle or not
`But these can be fixed by null checks`
