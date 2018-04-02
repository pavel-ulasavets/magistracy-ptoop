package shared;

import javafx.scene.input.MouseEvent;

public class DrawingTransactionByMouse {
    private MouseEvent startEvent;
    private MouseEvent endEvent;

    public void open(MouseEvent e) {
        this.startEvent = e;
    }

    public void close(MouseEvent e) {
        this.endEvent = e;
    }

    public MouseEvent getStartEvent() {
        return this.startEvent;
    }

    public MouseEvent getEndEvent() {
        return this.endEvent;
    }
}
