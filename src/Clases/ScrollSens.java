package Clases;

import javax.swing.JScrollPane;

public class ScrollSens {

    JScrollPane miJs;

    public ScrollSens(JScrollPane a) {
        this.miJs = a;
        aumentarSens(25);
    }
 public ScrollSens(JScrollPane a, int valor) {
        this.miJs = a;
        aumentarSens(valor);
    }
    public void aumentarSens(int i) {
        
        this.miJs.getHorizontalScrollBar().setUnitIncrement(i);
        this.miJs.getHorizontalScrollBar().setBlockIncrement(i);

        this.miJs.getVerticalScrollBar().setUnitIncrement(i);
        this.miJs.getVerticalScrollBar().setBlockIncrement(i);

    }
    public void resetScrollBar(){
        this.miJs.getVerticalScrollBar().setValue(0);
    }

}
