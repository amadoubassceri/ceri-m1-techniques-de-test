package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of the IPokedex interface.
 * This class stores and manages Pokémon, including adding, retrieving, and sorting them.
 */
public class Pokedex implements IPokedex {

    /** List to store the captured Pokémon. **/
    private final List<Pokemon> pokemons;

    /** Metadata provider for Pokémon. **/
    private final IPokemonMetadataProvider metadataProvider;

    /** Factory for creating Pokémon instances. **/
    private final IPokemonFactory pokemonFactory;

    /**
     * Constructor for the Pokedex class.
     *
     * @param metadataProvider Provider for Pokémon metadata.
     * @param pokemonFactory Factory for creating Pokémon instances.
     */
    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemons = new ArrayList<>();
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Returns the number of Pokémon this Pokedex contains.
     *
     * @return Number of Pokémon in this Pokedex.
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * Adds the given Pokémon to this Pokedex and returns its unique index.
     *
     * @param pokemon Pokémon to add to this Pokedex.
     * @return Index of this Pokémon relative to this Pokedex.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1; // Return the index of the added Pokémon (0-based index)
    }

    /**
     * Locates the Pokémon identified by the given ID.
     *
     * @param id Unique Pokedex relative identifier.
     * @return Pokémon denoted by the given identifier.
     * @throws PokedexException If the given ID is not valid.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("Invalid Pokémon ID: " + id);
        }
        return pokemons.get(id);
    }

    /**
     * Returns an unmodifiable list of all Pokémon this Pokedex contains.
     *
     * @return Unmodifiable list of all Pokémon.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    /**
     * Returns an unmodifiable list of all Pokémon this Pokedex contains.
     * The list view will be sorted using the given order.
     *
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all Pokémon.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(order);
        return Collections.unmodifiableList(sortedPokemons);
    }

    /**
     * Provides metadata about a specific Pokémon.
     *
     * @param id Unique identifier of the Pokémon.
     * @return The metadata of the Pokémon.
     * @throws PokedexException If the Pokémon does not exist.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int id) throws PokedexException {
        return metadataProvider.getPokemonMetadata(id);
    }

    /**
     * Creates a Pokémon using the given parameters and returns it.
     *
     * @param index The index of the Pokémon.
     * @param cp The CP of the Pokémon.
     * @param hp The HP of the Pokémon.
     * @param dust The dust required for upgrading the Pokémon.
     * @param candy The candy required for upgrading the Pokémon.
     * @return The created Pokémon.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }
}
