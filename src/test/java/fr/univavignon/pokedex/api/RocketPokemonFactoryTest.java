package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RocketPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemonWithUnknownIndex() {
        // Créer un Pokémon avec un index inconnu
        Pokemon pokemon = pokemonFactory.createPokemon(999, 1000, 100, 3000, 5);

        // Vérifier que le nom du Pokémon est "MISSINGNO" pour un index non défini
        assertNotNull(pokemon);
        assertEquals(999, pokemon.getIndex());
        assertEquals("MISSINGNO", pokemon.getName());
    }

    @Test
    public void testCreatePokemonWithNegativeIndex() {
        // Créer un Pokémon avec un index négatif
        Pokemon pokemon = pokemonFactory.createPokemon(-1, 1000, 100, 3000, 5);

        // Vérifier que les stats sont toutes égales à 1000 et IV est 0
        assertNotNull(pokemon);
        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
        assertEquals(0.0, pokemon.getIv(), 0.001); // IV devrait être 0
    }

    @Test
    public void testCreatePokemonWithRandomStats() {
        // Créer un Pokémon avec un index positif
        Pokemon pokemon = pokemonFactory.createPokemon(1, 500, 50, 2000, 3);

        // Vérifier que les stats ne sont pas toutes égales à 1000
        assertNotEquals(1000, pokemon.getAttack());
        assertNotEquals(1000, pokemon.getDefense());
        assertNotEquals(1000, pokemon.getStamina());
    }
}
