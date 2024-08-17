import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class AviaSoulsTest {
    @Test
    public void testSortFewTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17);
        Ticket ticket5 = new Ticket("UFA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {ticket2, ticket1, ticket6, ticket4, ticket8};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17);
        Ticket ticket5 = new Ticket("UFA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK", "LA");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17);
        Ticket ticket5 = new Ticket("UFA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("UFA", "SPB");
        Ticket[] expected = {ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17);
        Ticket ticket5 = new Ticket("UFA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComporator();

        Ticket[] actual = manager.searchAndSortBy("MSK", "SPB", comparator);
        Ticket[] expected = {ticket8, ticket1, ticket2, ticket6, ticket4};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortZeroTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17);
        Ticket ticket5 = new Ticket("UFA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComporator();

        Ticket[] actual = manager.searchAndSortBy("LA", "MSK", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortOneTicketWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17);
        Ticket ticket5 = new Ticket("UFA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComporator();

        Ticket[] actual = manager.searchAndSortBy("NEW", "LA", comparator);
        Ticket[] expected = {ticket7};
        Assertions.assertArrayEquals(expected, actual);

    }
}