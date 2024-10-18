package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;


public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon_Bulbizarre() {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);

        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);

        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        assertNotNull(pokemon);
        assertEquals(0, pokemon.getIndex());
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
        // Utiliser une tolérance (delta) pour la comparaison des valeurs à virgule flottante
        assertEquals(56.0, pokemon.getIv(), 0.001); // 0.001 est la tolérance
    }

    @Test
    public void testCreatePokemon_Aquali() {
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);

        Pokemon pokemon = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);

        assertNotNull(pokemon);
        assertEquals(133, pokemon.getIndex());
        assertEquals("Aquali", pokemon.getName());
        assertEquals(2729, pokemon.getCp());
        assertEquals(202, pokemon.getHp());
        assertEquals(5000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());

    }
}
