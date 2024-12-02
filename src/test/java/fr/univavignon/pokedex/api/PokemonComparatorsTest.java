package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PokemonComparatorsTest {

    private Pokemon pikachu;
    private Pokemon bulbasaur;

    @Before
    public void setUp() {
        // Créer les Pokémons pour le test
        pikachu = new Pokemon(1, "Pikachu", 112, 100, 90, 900, 60, 500, 4, 85.0);
        bulbasaur = new Pokemon(2, "Bulbizarre", 118, 111, 128, 612, 64, 4000, 4, 50.0);
    }

    @Test
    public void testNameComparator() {
        // Comparaison des Pokémons par nom
        int result = PokemonComparators.NAME.compare(pikachu, bulbasaur);

        // Pikachu vient avant Bulbizarre dans l'ordre alphabétique
        assertTrue("Pikachu should come before Bulbizarre by name", result < 0);

        result = PokemonComparators.NAME.compare(bulbasaur, pikachu);
        // Vérification inverse : Bulbizarre devrait venir après Pikachu
        assertTrue("Bulbizarre should come after Pikachu by name", result > 0);
    }

    @Test
    public void testIndexComparator() {
        // Comparaison des Pokémons par index
        int result = PokemonComparators.INDEX.compare(pikachu, bulbasaur);

        // L'index de Pikachu est plus petit que celui de Bulbizarre
        assertTrue("Pikachu should have a smaller index than Bulbizarre", result < 0);

        result = PokemonComparators.INDEX.compare(bulbasaur, pikachu);
        // Vérification inverse : Bulbizarre devrait avoir un index plus grand que Pikachu
        assertTrue("Bulbizarre should have a larger index than Pikachu", result > 0);
    }

    @Test
    public void testCpComparator() {
        // Comparaison des Pokémons par CP
        int result = PokemonComparators.CP.compare(pikachu, bulbasaur);

        // Le CP de Pikachu est plus élevé que celui de Bulbizarre
        assertTrue("Pikachu should have a higher CP than Bulbizarre", result > 0);

        result = PokemonComparators.CP.compare(bulbasaur, pikachu);
        // Vérification inverse : Bulbizarre devrait avoir un CP plus faible que Pikachu
        assertTrue("Bulbizarre should have a lower CP than Pikachu", result < 0);
    }

    @Test
    public void testEqualPokemonsByName() {
        // Créer un Pokémon avec le même nom, index et CP
        Pokemon pikachu1 = new Pokemon(1, "Pikachu", 112, 100, 90, 900, 60, 500, 4, 85.0);
        Pokemon pikachu2 = new Pokemon(1, "Pikachu", 112, 100, 90, 900, 60, 500, 4, 85.0);

        // Comparaison des Pokémons par nom
        int result = PokemonComparators.NAME.compare(pikachu1, pikachu2);
        // Les Pokémons devraient être égaux par nom
        assertEquals("Pokemons should be equal by name", 0, result);
    }

    @Test
    public void testEqualPokemonsByIndex() {
        // Créer un Pokémon avec le même nom, index et CP
        Pokemon pikachu1 = new Pokemon(1, "Pikachu", 112, 100, 90, 900, 60, 500, 4, 85.0);
        Pokemon pikachu2 = new Pokemon(1, "Pikachu", 112, 100, 90, 900, 60, 500, 4, 85.0);

        // Comparaison des Pokémons par index
        int result = PokemonComparators.INDEX.compare(pikachu1, pikachu2);
        // Les Pokémons devraient être égaux par index
        assertEquals("Pokemons should be equal by index", 0, result);
    }

    @Test
    public void testEqualPokemonsByCp() {
        // Créer un Pokémon avec le même nom, index et CP
        Pokemon pikachu1 = new Pokemon(1, "Pikachu", 112, 100, 90, 900, 60, 500, 4, 85.0);
        Pokemon pikachu2 = new Pokemon(1, "Pikachu", 112, 100, 90, 900, 60, 500, 4, 85.0);

        // Comparaison des Pokémons par CP
        int result = PokemonComparators.CP.compare(pikachu1, pikachu2);
        // Les Pokémons devraient être égaux par CP
        assertEquals("Pokemons should be equal by CP", 0, result);
    }

    @Test
    public void testReverseCpComparator() {
        // Comparaison inversée des Pokémons par CP
        int result = PokemonComparators.CP.reversed().compare(pikachu, bulbasaur);

        // Comme l'ordre est inversé, Bulbizarre devrait avoir un CP plus élevé que Pikachu
        assertTrue("After reversal, Bulbizarre should have a higher CP than Pikachu", result < 0);
    }
}
