package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokemon() {
        // Créer un Pokémon avec des valeurs spécifiques
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        // Vérifier que le Pokémon est correctement créé
        assertNotNull(pokemon);
        assertEquals(0, pokemon.getIndex());
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
    }

    @Test
    public void testCreatePokemonWithIVCalculation() {
        // Créer un Pokémon et vérifier que l'IV est calculé
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        // Vérifier que l'IV est calculé correctement (basé sur le CP et HP)
        double expectedIv = (613 + 64) / 2.0;
        assertEquals(expectedIv, pokemon.getIv(), 0.001); // Vérifier avec une tolérance
    }

    @Test
    public void testCreatePokemonWithDifferentStats() {
        // Créer un Pokémon avec un autre index
        Pokemon pokemon = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);

        // Vérifier les propriétés du Pokémon "Aquali"
        assertNotNull(pokemon);
        assertEquals(133, pokemon.getIndex());
        assertEquals("Aquali", pokemon.getName());
        assertEquals(2729, pokemon.getCp());
        assertEquals(202, pokemon.getHp());
        assertEquals(5000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
    }

    @Test
    public void testCreatePokemonWithUnknownIndex() {
        // Créer un Pokémon avec un index inconnu
        Pokemon pokemon = pokemonFactory.createPokemon(999, 1000, 100, 3000, 5);

        // Vérifier que le nom du Pokémon est "Unknown" pour un index non défini
        assertNotNull(pokemon);
        assertEquals(999, pokemon.getIndex());
        assertEquals("Unknown", pokemon.getName());
        assertEquals(1000, pokemon.getCp());
        assertEquals(100, pokemon.getHp());
        assertEquals(3000, pokemon.getDust());
        assertEquals(5, pokemon.getCandy());
    }

    @Test
    public void testCreatePokemonWithExtremeStats() {
        // Créer un Pokémon avec des stats extrêmes pour tester le calcul de l'IV
        Pokemon pokemon = pokemonFactory.createPokemon(0, Integer.MAX_VALUE, Integer.MAX_VALUE, 5000, 10);

        // Vérifier que le calcul des IVs est correct même avec des valeurs extrêmes
        double expectedIv = (Integer.MAX_VALUE + Integer.MAX_VALUE) / 2.0;
        assertEquals(expectedIv, pokemon.getIv(), 0.001); // Vérifier avec une tolérance
    }

    @Test
    public void testCreatePokemonWithNegativeStats() {
        // Créer un Pokémon avec des stats négatives (cas invalide mais à tester)
        Pokemon pokemon = pokemonFactory.createPokemon(0, -100, -50, 1000, 2);

        // Vérifier les valeurs des stats (les stats devraient être négatives mais les autres propriétés doivent être valides)
        assertNotNull(pokemon);
        assertEquals(-100, pokemon.getCp());
        assertEquals(-50, pokemon.getHp());
        assertEquals(1000, pokemon.getDust());
        assertEquals(2, pokemon.getCandy());
    }
}
