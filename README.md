# Blackjack Game - Spring Boot REST API

A modern, responsive blackjack game built with Spring Boot and RESTful APIs. This project provides both a web interface and REST API endpoints for playing blackjack.

## Features

- 🃏 Complete blackjack game logic
- 🌐 RESTful API endpoints
- 🎨 Modern, responsive web interface
- 📱 Mobile-friendly design
- 🔄 Real-time game state management
- 🎯 Session-based gameplay

## Technology Stack

- **Backend**: Spring Boot 3.3.2, Java 17
- **Frontend**: HTML5, CSS3, JavaScript (ES6+)
- **Build Tool**: Maven
- **Template Engine**: Thymeleaf

## API Endpoints

### Blackjack Game API

Base URL: `/api/blackjack`

#### 1. Start New Game
- **POST** `/start`
- **Description**: Starts a new blackjack game
- **Response**: Game state with initial cards dealt

```json
{
  "success": true,
  "message": "Game started",
  "data": {
    "playerCards": ["A♠", "K♥"],
    "dealerCards": ["7♣", "J♦"],
    "playerValue": 21,
    "dealerValue": 17,
    "playerBust": false,
    "dealerBust": false,
    "roundOver": false,
    "gameResult": null,
    "gameStarted": true
  }
}
```

#### 2. Hit (Draw Card)
- **POST** `/hit`
- **Description**: Player draws another card
- **Response**: Updated game state

#### 3. Stand
- **POST** `/stand`
- **Description**: Player stands, dealer plays automatically
- **Response**: Final game state with winner determination

#### 4. Get Game State
- **GET** `/state`
- **Description**: Retrieves current game state
- **Response**: Current game state

#### 5. Reset Game
- **POST** `/reset`
- **Description**: Resets the current game session
- **Response**: Confirmation message

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Installation

1. Clone the repository:
```bash
git clone <your-repo-url>
cd gambling
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

4. Open your browser and navigate to:
```
http://localhost:8080
```

### Development

To run in development mode with hot reload:
```bash
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.devtools.restart.enabled=true"
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/gambling/
│   │       ├── GamblingApplication.java          # Main Spring Boot application
│   │       ├── config/
│   │       │   └── WebConfig.java               # CORS and web configuration
│   │       ├── dto/
│   │       │   ├── ApiResponse.java             # Generic API response wrapper
│   │       │   └── GameStateDto.java            # Game state data transfer object
│   │       ├── model/
│   │       │   ├── Card.java                    # Card model with suit and rank
│   │       │   ├── Deck.java                    # Deck management
│   │       │   └── Hand.java                    # Hand management with blackjack logic
│   │       ├── service/
│   │       │   └── BlackjackService.java        # Game logic service
│   │       └── web/
│   │           ├── BlackjackController.java     # REST API controller
│   │           └── HomeController.java          # Web page controller
│   └── resources/
│       └── templates/
│           └── blackjack.html                   # Game web interface
└── test/
```

## Game Rules

- Standard blackjack rules apply
- Dealer must hit on 16 and stand on 17
- Aces can be 1 or 11 (automatically calculated)
- Player busts on 22 or higher
- Blackjack (21 with 2 cards) beats other 21s

## API Usage Examples

### Using curl

Start a new game:
```bash
curl -X POST http://localhost:8080/api/blackjack/start
```

Hit (draw a card):
```bash
curl -X POST http://localhost:8080/api/blackjack/hit
```

Stand:
```bash
curl -X POST http://localhost:8080/api/blackjack/stand
```

Get current state:
```bash
curl http://localhost:8080/api/blackjack/state
```

### Using JavaScript

```javascript
// Start a new game
const response = await fetch('/api/blackjack/start', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' }
});
const gameState = await response.json();

// Hit
await fetch('/api/blackjack/hit', { method: 'POST' });

// Stand
await fetch('/api/blackjack/stand', { method: 'POST' });
```

## Deployment

### Local JAR
```bash
mvn clean package
java -jar target/gambling-0.0.1-SNAPSHOT.jar
```

### Docker (Optional)
Create a `Dockerfile`:
```dockerfile
FROM openjdk:17-jdk-slim
COPY target/gambling-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

Build and run:
```bash
docker build -t blackjack-game .
docker run -p 8080:8080 blackjack-game
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## License

This project is open source and available under the [MIT License](LICENSE).

## Future Enhancements

- [ ] User authentication and game history
- [ ] Multiple game types (poker, etc.)
- [ ] Real-time multiplayer support
- [ ] Statistics and analytics
- [ ] Mobile app version
- [ ] Database persistence
