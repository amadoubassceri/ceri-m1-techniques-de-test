package fr.univavignon.pokedex.api;

import org.junit.Test;
import static org.junit.Assert.*;

public class PokedexExceptionTest {

    @Test
    public void testPokedexExceptionMessage() {
        // Créer une instance de PokedexException avec un message personnalisé
        String errorMessage = "An error occurred in Pokedex";
        PokedexException exception = new PokedexException(errorMessage);

        // Vérifier que le message d'erreur est correctement défini
        assertNotNull(exception);
        assertEquals(errorMessage, exception.getMessage());
    }
    //

    @Test(expected = PokedexException.class)
    public void testThrowPokedexException() throws PokedexException {
        // Simuler un scénario qui lance l'exception
        throw new PokedexException("Test exception thrown");
    }
}
