package fr.univavignon.pokedex.api;

/**
 * Represents a Pokémon trainer.
 * A trainer has a name, a team, and a pokédex.
 *
 * This class holds the essential information of a Pokémon trainer.
 */
public class PokemonTrainer {

/** Trainer's name. */
private final String name;

/** Trainer's team (Mystic, Valor, Instinct). */
private final Team team;

/** Trainer's pokédex. */
private final IPokedex pokedex;

/**
* Constructs a Pokémon trainer with the specified name, team, and pokédex.
*
* @param name Trainer's name.
* @param team Trainer's team (can be one of the predefined teams: Mystic, Valor, Instinct).
* @param pokedex Trainer's pokédex containing Pokémon data.
*/
public PokemonTrainer(
final String name,
final Team team,
final IPokedex pokedex) {
this.name = name;
this.team = team;
this.pokedex = pokedex;
}

/**
* Gets the trainer's name.
*
* @return The name of the trainer.
*/
public String getName() {
return name;
}

/**
* Gets the trainer's team.
*
* @return The team of the trainer.
*/
public Team getTeam() {
return team;
}

/**
* Gets the trainer's pokédex.
*
* @return The pokédex of the trainer.
*/
public IPokedex getPokedex() {
return pokedex;
}
}
