package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PokedexTest {

    private Pokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
    }

    @Test
    public void testSize() {
        // Ajouter un Pokémon pour tester la taille
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokedex.addPokemon(bulbizarre);

        // Vérifier que la taille est correcte
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

        // Ajouter un Pokémon
        int index = pokedex.addPokemon(bulbizarre);

        // Vérifier que l'index retourné est correct
        assertEquals(0, index);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokedex.addPokemon(bulbizarre);

        // Vérifier que la méthode renvoie le bon Pokémon
        Pokemon pokemon = pokedex.getPokemon(0);
        assertNotNull(pokemon);
        assertEquals("Bulbizarre", pokemon.getName());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonInvalidId() throws PokedexException {
        // Tester un ID invalide qui doit lancer une exception
        pokedex.getPokemon(999);
    }

    @Test
    public void testGetPokemons() {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokedex.addPokemon(bulbizarre);

        // Tester que la méthode retourne la bonne liste
        assertEquals(1, pokedex.getPokemons().size());
    }

    @Test
    public void testGetPokemonsWithSorting() {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);

        // Tri basé sur le CP
        List<Pokemon> sortedPokemons = pokedex.getPokemons(Comparator.comparingInt(Pokemon::getCp));

        // Vérifier que la liste est triée par CP
        assertEquals("Bulbizarre", sortedPokemons.get(0).getName());
        assertEquals("Aquali", sortedPokemons.get(1).getName());
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(metadata);

        // Tester la récupération des métadonnées
        PokemonMetadata returnedMetadata = pokedex.getPokemonMetadata(0);
        assertNotNull(returnedMetadata);
        assertEquals("Bulbizarre", returnedMetadata.getName());
    }
}
