package fr.univavignon.pokedex.api;

/**
 * Implementation of the IPokedexFactory interface.
 * This class creates a new instance of Pokedex using the provided metadata provider
 * and Pokémon factory.
 */
public class PokedexFactory implements IPokedexFactory {

    /**
     * Creates a new Pokedex instance using the given metadata provider and Pokémon factory.
     *
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory Pokémon factory the created pokedex will use.
     * @return Created pokedex instance.
     */
    @Override
    public IPokedex createPokedex(
            IPokemonMetadataProvider metadataProvider,
            IPokemonFactory pokemonFactory) {
        // Create and return a new Pokedex instance
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
