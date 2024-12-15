package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class PokemonTrainerFactoryTest {

    private PokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
        trainerFactory = new PokemonTrainerFactory();
    }

    @Test
    public void testCreateTrainer() {
        // Mocking the Pokedex and Team
        IPokedex pokedex = mock(IPokedex.class);
        Team team = Team.MYSTIC;

        when(pokedexFactory.createPokedex(any(), any())).thenReturn(pokedex);

        // Create trainer
        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", team, pokedexFactory);

        // Verify the trainer creation
        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
        assertEquals(team, trainer.getTeam());
        assertNotNull(trainer.getPokedex());
    }
}
