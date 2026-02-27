package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {
    Database database;
    RecSys recommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        database = new InMemoryDatabase(); // fake
        recommender = mock(RecSys.class); // mock
        promoService = mock(PromoService.class); // mock

        andrewWebService = new AndrewWebServices(database, recommender, promoService);
    }

    @Test
    public void testLogIn() {
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        // stub
        when(recommender.getRecommendation("Scotty")).thenReturn("Animal House");

        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
        verify(recommender).getRecommendation("Scotty");
    }

    @Test
    public void testSendEmail() {
        andrewWebService.sendPromoEmail("scotty@cmu.edu");

        verify(promoService).mailTo("scotty@cmu.edu");
    }

    @Test
    public void testNoSendEmail() {
        andrewWebService.logIn("Scotty", 17214);

        verify(promoService, never()).mailTo(anyString());
    }
}
