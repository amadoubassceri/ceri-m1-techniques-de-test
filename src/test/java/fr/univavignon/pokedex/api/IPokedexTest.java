package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



public class IPokedexTest {

    private IPokedex pokedex;

    @Before
    public void setUp() {
        // Créer un mock de IPokedex
        pokedex = Mockito.mock(IPokedex.class);
    }

    @Test
    public void testSize() {
        // Définir le comportement du mock
        when(pokedex.size()).thenReturn(151);

        // Appeler la méthode à tester
        int size = pokedex.size();

        // Vérifier le résultat
        assertEquals(151, size);
    }

    @Test
    public void testAddPokemon() {
        // Créer un objet Pokemon pour le test
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

        // Définir le comportement du mock
        when(pokedex.addPokemon(bulbizarre)).thenReturn(1);

        // Appeler la méthode à tester
        int index = pokedex.addPokemon(bulbizarre);

        // Vérifier le résultat
        assertEquals(1, index);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        // Créer un objet Pokemon pour le test
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

        // Définir le comportement du mock
        when(pokedex.getPokemon(0)).thenReturn(bulbizarre);

        // Appeler la méthode à tester
        Pokemon pokemon = pokedex.getPokemon(0);

        // Vérifier le résultat
        assertNotNull(pokemon);
        assertEquals("Bulbizarre", pokemon.getName());
    }
}
