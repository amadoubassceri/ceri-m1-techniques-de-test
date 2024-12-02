package fr.univavignon.pokedex.api;

public class Main {
    public static void main(String[] args) {
        // Création des objets metadataProvider et pokemonFactory
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider(); // Implémentation à fournir
        IPokemonFactory pokemonFactory = new PokemonFactory(); // Implémentation à fournir

        // Création de la factory
        IPokedexFactory pokedexFactory = new PokedexFactory();

        // Création du pokedex
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Ajouter un Pokémon au pokedex
        Pokemon bulbasaur = new Pokemon(0, "Bulbizarre", 118, 111, 128, 612, 64, 4000, 4, 50.0);
        pokedex.addPokemon(bulbasaur);

        // Afficher la taille du pokédex
        System.out.println("Taille du Pokédex : " + pokedex.size());
    }
}
