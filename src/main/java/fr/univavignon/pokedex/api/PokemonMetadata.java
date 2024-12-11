package fr.univavignon.pokedex.api;

/**
 * Represents the metadata for a Pokémon.
 * This class holds essential information about a Pokémon, such as its index,
 * name, attack, defense, and stamina levels.
 *
 * It is used to provide detailed information about a Pokémon in the Pokedex.
 */
public class PokemonMetadata {

/** Pokémon index (unique identifier). */
private final int index;

/** Pokémon name. */
private final String name;

/** Pokémon attack level. */
private final int attack;

/** Pokémon defense level. */
private final int defense;

/** Pokémon stamina level. */
private final int stamina;

/**
* Constructs a Pokémon metadata object with the given attributes.
*
* @param index Pokémon index (unique identifier for the Pokémon).
* @param name Name of the Pokémon.
* @param attack Attack level of the Pokémon.
* @param defense Defense level of the Pokémon.
* @param stamina Stamina level of the Pokémon.
*/
public PokemonMetadata(
final int index,
final String name,
final int attack,
final int defense,
final int stamina) {
this.index = index;
this.name = name;
this.attack = attack;
this.defense = defense;
this.stamina = stamina;
}

/**
* Gets the index of the Pokémon.
*
* @return The Pokémon index.
*/
public int getIndex() {
return index;
}

/**
* Gets the name of the Pokémon.
*
* @return The Pokémon's name.
*/
public String getName() {
return name;
}

/**
* Gets the attack level of the Pokémon.
*
* @return The attack level of the Pokémon.
*/
public int getAttack() {
return attack;
}

/**
* Gets the defense level of the Pokémon.
*
* @return The defense level of the Pokémon.
*/
public int getDefense() {
return defense;
}

/**
* Gets the stamina level of the Pokémon.
*
* @return The stamina level of the Pokémon.
*/
public int getStamina() {
return stamina;
}
}
