package Xingxin.util;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 231
 * @date 2020-06-12 9:20
 */
public class mouselistener extends MouseAdapter {

    JPopupMenu popupMenu;
    public mouselistener(JPopupMenu popupMenu)
    {
        this.popupMenu=popupMenu;
    }
    @Override
    public void mousePressed(MouseEvent e)
    {
        showPopupMenu(e);
    }
    @Override
    public void mouseReleased(MouseEvent e)
    {
        showPopupMenu(e);
    }
    private void showPopupMenu(MouseEvent e)
    {
        if(e.isPopupTrigger())
        {
            popupMenu.show(e.getComponent(),e.getX(),e.getY());
        }
    }
}
