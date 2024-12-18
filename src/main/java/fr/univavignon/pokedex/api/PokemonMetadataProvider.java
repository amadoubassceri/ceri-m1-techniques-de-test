package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the IPokemonMetadataProvider interface.
 * Provides metadata for a given Pokémon index.
 *
 * This class stores and retrieves metadata for Pokémon based on their index. The metadata includes information like
 * the Pokémon's stats (HP, attack, defense, etc.).
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    /** A map to store Pokémon metadata by their index. */
    private final Map<Integer, PokemonMetadata> pokemonMetadataMap;

    /**
     * Constructor for the PokemonMetadataProvider class.
     * Initializes the metadata map with predefined Pokémon data.
     *
     * This constructor populates the metadata map with a few predefined Pokémon. In a real application,
     * this data could be loaded from an external data source, such as a database or API.
     */
    public PokemonMetadataProvider() {
        pokemonMetadataMap = new HashMap<>();

        // Adding some example Pokémon metadata to the map.
        pokemonMetadataMap.put(0, new PokemonMetadata(0, "Bulbizarre", 118, 111, 128));
        pokemonMetadataMap.put(1, new PokemonMetadata(1, "Herbizarre", 151, 143, 155));
        pokemonMetadataMap.put(2, new PokemonMetadata(2, "Florizarre", 190, 189, 190));
        pokemonMetadataMap.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
        pokemonMetadataMap.put(4, new PokemonMetadata(4, "Salamèche", 116, 93, 118));
        pokemonMetadataMap.put(5, new PokemonMetadata(5, "Reptincel", 158, 121, 151));
        pokemonMetadataMap.put(6, new PokemonMetadata(6, "Dracaufeu", 223, 173, 186));
    }

    /**
     * Retrieves and returns the metadata for the Pokémon denoted by the given index.
     *
     * @param index Index of the Pokémon to retrieve metadata for.
     * @return Metadata of the Pokémon corresponding to the provided index.
     * @throws PokedexException If the given index is not valid (index not found).
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        PokemonMetadata metadata = pokemonMetadataMap.get(index);

        if (metadata == null) {
            throw new PokedexException("Invalid Pokémon index: " + index);
        }

        return metadata;
    }
}
