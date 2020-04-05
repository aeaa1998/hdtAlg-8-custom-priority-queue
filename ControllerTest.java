import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @org.junit.jupiter.api.Test
    void fillPoolTest() {
        Controller controller = new Controller();
        controller.fillPool();
        controller.setHeap(new VectorHeap<>(new Vector<Patient>(){{addAll(controller.getPatients());}}));
        assertTrue(controller.getHeap().peek().compareTo(controller.getHeap().peek()) < 1);
    }
    @org.junit.jupiter.api.Test
    void fillPoolTestFail() {
        Controller controller = new Controller();
        controller.fillPool();
        controller.setHeap(new VectorHeap<>(new Vector<Patient>(){{addAll(controller.getPatients());}}));
        assertFalse(controller.getHeap().peek().compareTo(controller.getHeap().peek()) >= 1);
    }
}