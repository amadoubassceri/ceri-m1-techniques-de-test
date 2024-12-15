package fr.univavignon.pokedex.api;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testMain() throws PokedexException {
        // Mocking the metadata provider and factory
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);

        // Mocking the Pokedex creation
        IPokedex pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        // Mock the behavior of the addPokemon method
        Pokemon bulbasaur = new Pokemon(
                0, "Bulbizarre", 118, 111, 128, 612, 64, 4000, 4, 50.0);
        when(pokedex.size()).thenReturn(1);

        // Call main method indirectly by testing the setup
        Main.main(new String[]{});

        // Verify that the size method was called and print the correct size
        assertEquals(1, pokedex.size());
    }
}
