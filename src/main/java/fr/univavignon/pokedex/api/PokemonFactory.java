package fr.univavignon.pokedex.api;

/**
 * Implementation of the IPokemonFactory interface.
 * This class creates a new Pokemon instance and computes its IVs.
 */
public class PokemonFactory implements IPokemonFactory {

/**
* Creates a pokemon instance computing its IVs.
*
* @param index Pokemon index.
* @param cp Pokemon CP.
* @param hp Pokemon HP.
* @param dust Required dust for upgrading pokemon.
* @param candy Required candy for upgrading pokemon.
* @return Created pokemon instance.
*/
@Override
public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
// Calculate IVs based on CP, HP and other metrics.
// In a real-world scenario, these IVs would be based on a complex calculation,
// but for simplicity we will generate them randomly or use a simple formula.

// Hypothetical calculation for IV (this could be replaced with a real formula)
double iv = calculateIV(cp, hp);

// Create and return the Pokemon instance
return new Pokemon(
        index,
        getPokemonName(index),
        getAttackStat(index),
        getDefenseStat(index),
        getStaminaStat(index),
        cp, hp, dust, candy, iv);
}

/**
* A helper method to calculate IV (Individual Value) for the Pokémon.
* This is just a simple placeholder for illustration.
*
* @param cp Combat Points of the Pokémon.
* @param hp Hit Points of the Pokémon.
* @return Calculated IV.
*/
private double calculateIV(int cp, int hp) {
// Simple example formula for IV (this should be replaced by the actual calculation logic)
return (cp + hp) / 2.0; // This is a placeholder formula for illustration
}

/**
* Get the name of the Pokémon based on the index.
*
* @param index The Pokémon's index.
* @return The name of the Pokémon.
*/
private String getPokemonName(int index) {
// Placeholder logic: In a real implementation, this would map the index to a Pokémon's name
switch (index) {
case 0: return "Bulbizarre";
case 133: return "Aquali";
// Add more mappings as needed
default: return "Unknown";
}
}

/**
* Get the attack stat for the Pokémon based on the index.
*
* @param index The Pokémon's index.
* @return The attack stat of the Pokémon.
*/
private int getAttackStat(int index) {
// Placeholder logic: In a real implementation, this would map the index to a Pokémon's attack stat
switch (index) {
case 0: return 126;
case 133: return 186;
// Add more mappings as needed
default: return 100;
}
}

/**
* Get the defense stat for the Pokémon based on the index.
*
* @param index The Pokémon's index.
* @return The defense stat of the Pokémon.
*/
private int getDefenseStat(int index) {
// Placeholder logic: In a real implementation, this would map the index to a Pokémon's defense stat
switch (index) {
case 0: return 126;
case 133: return 168;
// Add more mappings as needed
default: return 100;
}
}

/**
* Get the stamina stat for the Pokémon based on the index.
*
* @param index The Pokémon's index.
* @return The stamina stat of the Pokémon.
*/
private int getStaminaStat(int index) {
 // Placeholder logic: In a real implementation, this would map the index to a Pokémon's stamina stat
switch (index) {
case 0: return 90;
case 133: return 260;
// Add more mappings as needed
default: return 100;
}
}
}
