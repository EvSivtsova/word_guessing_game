# Word-guessing game

This is a Makers Academy challenge from three week course on Java - week 1.

## Specifications of the game

In this week's pairing challenge, you'll build an old school favourite — a word-guessing game in the terminal! Here's the specification for this game:

* When the game starts, it will choose a random word from a list of words.
* The game will then display the word to guess, with only the first letter visible (e.g H____ for "HOUSE").
* The player starts a counter of 10 attempts.
* The player will then be prompted to enter a letter they think might be in the word.
* If the letter is in the word, the game will display the word to guess, with the new letter visible.
* If the letter is not in the word, the game will display the same letters as before, and decrease the counter of remaining attempts.
* If the counter of attempts reaches zero, the player loses.
* If the player finds all the letters in the word, they win.

## Learning Objectives
* Initialising a new project with gradle.
* Writing a test class and tests
* Writing a class and a method.
* Define a class constructor.
* Define class attributes.
* Using a loop and some of Java's built-in classes, like StringBuilder.
* Running tests.

## TechBit

Technologies used:

* Java(17.0.5)
* Gradle(7.5.1
* Groovy(3.0.10)
* Guava(31.0.1-jre)

Testing:
* JUnit(4.13.2)
* Mockito-core(3)

Clone the repository and run bundle install to install the dependencies within the folder:

```
git clone https://github.com/EvSivtsova/word_guessing_game.git
cd word_guessing_game
```
Run the program and test directly from corresponding files:<br>

To play the game: `app/src/main/java/game/App.java`<br>

To run tests: `app/src/test/java/game`<br>

## One player game

<img src="https://github.com/EvSivtsova/word_guessing_game/blob/main/outputs/one_player_game_with_name_output.png">

## Two player game

<img src="https://github.com/EvSivtsova/word_guessing_game/blob/main/outputs/two_player_game_with_names_output.png">
