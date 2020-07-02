# RiskGame
This game developed based on both Risk (Game) and Domination (Risk Board Game). For more details please check the below links:
https://en.wikipedia.org/wiki/Risk_(game)
https://sourceforge.net/projects/domination/


# Game Rules
The rules of this game design based on the following links, please check the links:
https://www.hasbro.com/common/instruct/risk.pdf
https://media.wizards.com/2015/downloads/ah/Risk_rules.pdf
https://www.ultraboardgames.com/risk/game-rules.php
https://www.wikihow.com/Play-Risk


## Risk Game development
- Coding Standard : https://www.geeksforgeeks.org/java-naming-conventions/
- Exception handling : https://google.github.io/styleguide/javaguide.html#s6.2-caught-exceptions


## Build - 2
This version is designed and developed based on the MVC Architectural Paterrn and Observer Design Pattern.

### Functional Requirements
- The game must include a command prompt that is available throughout the usage of the game (even if you have a GUI). All the commands should be validated and give proper feedback on their effect or invalidity. Each of the commands should only work in the game phase for which they are designed for. 
- The commands should use the exact same syntax as defined below. Some commands have options preceded by a
dash. Either or both options can be used and may be used multiple times in a command. Command parameters
are noted in italics.

===============================================================================================================================================================

### Map Editor

#### User-driven creation of map elements: country, continent and connectivity between countries.

##### Map editor commands

###### Commands for creating and editing continents:
- editcontinent -add continentname continentvalue 
- editcontinent -remove continentname

###### Commands for creating and editing countries:
- editcountry -add countryname continentname
- editcountry -remove countryname

###### Commands for adding or removing neighbor countries:
- editneighbor -add countryname neighborcountryname
- editneighbor -remove countryname neighborcountryname

###### Command for seeing the map:
- showmap (show all continents and countries and their neighbors)

###### Command for saving the map as a file:(Extention format should be ".map")
- savemap filename: Saving a map to a text file exactly as edited (using the "domination" game map format).

###### Command fot editing the map file:
- editmap filename: Loading a map from an existing "domination" map file to edit or create a new map from scratch if the file does not exist.

##### Verification and validation of the map:
The map should be automatically validated upon loading and before saving (at least 3 types of incorrect maps). 
The validatemap command can be triggered anytime during map editing.
###### Command for verifing and validating the map file:
- validatemap

##### Command for loading the existing or validated map file:
- loadmap

===============================================================================================================================================================

### Startup Phase

#### Player Editor

##### Command for creating and removing players: 
- gameplayer -add playername
- gameplayer -remove playername

##### Command for populating countries to the players: 
- populatecountries

===============================================================================================================================================================

### Reinforcement Phase

#### Reinforcement phase commands:
- reinforce countryname num (until all reinforcement armies allocated to the player have been placed)
- exchangecards num num num –none (exchange three cards from the hand, as specified by three numbers that represent the position of the exchanged cards in the player’s hand. If –none is specified, choose to not exchange cards.)

===============================================================================================================================================================

### Attack Phase

#### Attack phase commands:
- attack countrynamefrom countynameto numdice –allout –noattack (do a single attack from countrynamefrom to countynameto using numdice number of dice. If –allout is specified, attack until no attack is possible using maximum number of dice to attack/defend. If –noattack is specified, stop attacking, ending the attack phase.)
- defend numdice (after attack is declared, defender chooses number of dice to defend with)
- attackmove num (After a country has been conquered, move num number of armies to this country from the attacking country.)

===============================================================================================================================================================

### Fortification Phase

#### Fortification phase commands:
- fortify fromcountry tocountry num –none (move num number of armies from fromcountry to tocountry. If –none is specified, choose to not do a move during the fortification phase)

===============================================================================================================================================================

### Game Play
- Implementation of a game driver implementing and controlling the game phases according to the Risk rules.
- Game play command: showmap (show all countries and continents, armies on each country, ownership, and connectivity)

