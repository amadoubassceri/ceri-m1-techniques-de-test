package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        // Créer des mocks de IPokedexFactory, IPokemonMetadataProvider et IPokemonFactory
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokedex() {

        IPokedex pokedex = Mockito.mock(IPokedex.class);


        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);


        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);


        assertNotNull(createdPokedex);
    }
}
