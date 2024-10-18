package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {

        trainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
    }

    @Test
    public void testCreateTrainer() {

        IPokedex pokedex = Mockito.mock(IPokedex.class);


        PokemonTrainer expectedTrainer = new PokemonTrainer("Ash", Team.VALOR, pokedex);


        when(trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory)).thenReturn(expectedTrainer);


        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);


        assertNotNull(trainer);


        assertEquals("Ash", trainer.getName());
        assertEquals(Team.VALOR, trainer.getTeam());
        assertEquals(pokedex, trainer.getPokedex());


        verify(trainerFactory).createTrainer("Ash", Team.VALOR, pokedexFactory);
    }
}
