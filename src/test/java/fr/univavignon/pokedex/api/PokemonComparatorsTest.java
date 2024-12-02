package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PokemonComparatorsTest {

    private Pokemon pikachu;
    private Pokemon bulbizarre;
    private Pokemon charmander;

    @Before
    public void setUp() {
        // Initialisation des Pokémon pour les tests
        pikachu = new Pokemon(1, "Pikachu", 100, 50, 60, 900, 35, 400, 5, 87.5);
        bulbizarre = new Pokemon(2, "Bulbizarre", 50, 60, 70, 700, 40, 300, 3, 82.5);
        charmander = new Pokemon(3, "Charmander", 60, 55, 50, 600, 30, 200, 2, 85.0);
    }

    // Test pour le comparateur par NOM
    @Test
    public void testNameComparator() {
        List<Pokemon> pokemons = Arrays.asList(pikachu, bulbizarre, charmander);

        // Tri des Pokémon par nom
        pokemons.sort(PokemonComparators.NAME);

        // Vérification que les Pokémon sont triés par ordre lexicographique de leurs noms
        assertEquals("Bulbizarre", pokemons.get(0).getName());
        assertEquals("Charmander", pokemons.get(1).getName());
        assertEquals("Pikachu", pokemons.get(2).getName());
    }

    // Test pour le comparateur par INDEX
    @Test
    public void testIndexComparator() {
        List<Pokemon> pokemons = Arrays.asList(pikachu, bulbizarre, charmander);

        // Tri des Pokémon par index
        pokemons.sort(PokemonComparators.INDEX);

        // Vérification que les Pokémon sont triés par leur index
        assertEquals(1, pokemons.get(0).getIndex());
        assertEquals(2, pokemons.get(1).getIndex());
        assertEquals(3, pokemons.get(2).getIndex());
    }

    // Test pour le comparateur par CP (Combat Points)
    @Test
    public void testCpComparator() {
        List<Pokemon> pokemons = Arrays.asList(pikachu, bulbizarre, charmander);

        // Tri des Pokémon par CP
        pokemons.sort(PokemonComparators.CP);

        // Vérification que les Pokémon sont triés par leur CP
        assertEquals(600, pokemons.get(0).getCp());
        assertEquals(700, pokemons.get(1).getCp());
        assertEquals(900, pokemons.get(2).getCp());
    }
}
