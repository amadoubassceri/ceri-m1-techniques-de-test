package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokemonMetadataProviderTest {

    private PokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        metadataProvider = new PokemonMetadataProvider();
    }

    @Test
    public void testGetPokemonMetadataValidIndex() throws PokedexException {
        // Test pour un index valide
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(0);
        assertNotNull(metadata); // Vérifier que la métadonnée n'est pas nulle
        assertEquals("Bulbizarre", metadata.getName()); // Vérifier que le nom est correct
        assertEquals(118, metadata.getAttack()); // Vérifier la stat de l'attaque
        assertEquals(111, metadata.getDefense()); // Vérifier la stat de la défense
        assertEquals(128, metadata.getStamina()); // Vérifier la stat de l'endurance
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        // Test pour un index invalide
        metadataProvider.getPokemonMetadata(999); // L'index 999 n'existe pas dans les données
    }

    @Test
    public void testGetPokemonMetadataMultipleValidIndexes() throws PokedexException {
        // Test pour plusieurs index valides
        PokemonMetadata metadata0 = metadataProvider.getPokemonMetadata(0);
        assertNotNull(metadata0);
        assertEquals("Bulbizarre", metadata0.getName());

        PokemonMetadata metadata1 = metadataProvider.getPokemonMetadata(1);
        assertNotNull(metadata1);
        assertEquals("Herbizarre", metadata1.getName());

        PokemonMetadata metadata2 = metadataProvider.getPokemonMetadata(2);
        assertNotNull(metadata2);
        assertEquals("Florizarre", metadata2.getName());
    }
}
