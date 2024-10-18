package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {

        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadata_Bulbizarre() throws PokedexException {

        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);


        when(metadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarreMetadata);


        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(0);


        assertNotNull(metadata);
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    @Test
    public void testGetPokemonMetadata_Aquali() throws PokedexException {

        PokemonMetadata aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);


        when(metadataProvider.getPokemonMetadata(133)).thenReturn(aqualiMetadata);


        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(133);


        assertNotNull(metadata);
        assertEquals(133, metadata.getIndex());
        assertEquals("Aquali", metadata.getName());
        assertEquals(186, metadata.getAttack());
        assertEquals(168, metadata.getDefense());
        assertEquals(260, metadata.getStamina());
    }
}
