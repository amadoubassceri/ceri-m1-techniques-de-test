package fr.univavignon.pokedex.api;

/**
 * Implementation of the IPokemonTrainerFactory interface.
 * Creates and returns a new PokemonTrainer instance.
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    /**
     * Creates and returns a PokemonTrainer instance.
     *
     * @param name Name of the created trainer.
     * @param team Team of the created trainer.
     * @param pokedexFactory Factory to use for creating associated pokedex instance.
     * @return Created trainer instance.
     */
    @Override
    public PokemonTrainer createTrainer(
            String name,
            Team team,
            IPokedexFactory pokedexFactory) {
        // Create the associated pokedex using the provided factory.
        IPokedex pokedex = pokedexFactory.createPokedex(
                new PokemonMetadataProvider(),
                new PokemonFactory());

        // Create and return the PokemonTrainer instance with the provided name, team, and pokedex.
        return new PokemonTrainer(name, team, pokedex);
    }
}
