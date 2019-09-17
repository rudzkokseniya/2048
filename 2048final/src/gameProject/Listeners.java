package gameProject;

import java.awt.event.*;

public class Listeners implements MouseListener, KeyListener, MouseMotionListener {
    // проверка нажатой клавиши
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();// получить код нажатой клавиши
        // проверка  клавиши
        if (key == KeyEvent.VK_1) {
            GameLogic.keyOne= true;
        }
        if (key == KeyEvent.VK_2) {
            GameLogic.keyTwo = true;
        }
        if (key == KeyEvent.VK_3) {
            GameLogic.keyThree = true;
        }
        if (key == KeyEvent.VK_4) {
            GameLogic.keyFour = true;
        }
        if (key == KeyEvent.VK_5) {
            GameLogic.keyFive = true;
        }
        if (key == KeyEvent.VK_6) {
            GameLogic.keySix = true;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            if (Panel.state == Panel.STATES.PLAY)Panel.state = Panel.STATES.MENUE; // переход в меню из игры
            GameLogic.esc = true;
        }
    }
    // проверка отжатой клавиши
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_1) {
            GameLogic.keyOne = false;
        }
        if (key == KeyEvent.VK_2) {
            GameLogic.keyTwo = false;
        }
        if (key == KeyEvent.VK_3) {
            GameLogic.keyThree = false;
        }
        if (key == KeyEvent.VK_4) {
            GameLogic.keyFour = false;
        }
        if (key == KeyEvent.VK_5) {
            GameLogic.keyFive = false;
        }
        if (key == KeyEvent.VK_6) {
            GameLogic.keySix = false;
        }


    }
    public void keyTyped(KeyEvent e){

        }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {

            if (Panel.state == Panel.STATES.MENUE) {
                Menue.click = true;// нажатие ЛКМ в меню
            }
        }



    }

    public void mouseReleased(MouseEvent e){
        if (e.getButton() == MouseEvent.BUTTON1) {

            if (Panel.state == Panel.STATES.MENUE) {
                Menue.click = false;// отпуск ЛКМ в меню
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {// метод переноса мышкой

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Panel.mouseX = e.getX();// получить координату х при перемещении мышки
        Panel.mouseY = e.getY();// получить координату у при перемещении мышки
    }



}
