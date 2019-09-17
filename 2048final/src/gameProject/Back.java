package gameProject;
/**
 Задний фон игровой панели
 */
import javax.swing.*;
import java.awt.*;

public class Back {


    Image img = new ImageIcon("image/background.png").getImage();//загрузка картинки



    public void draw(Graphics2D g) {  //прорисовка в Graphics2D
        Color bacColor = new Color(0, 0, 0);//созд обьект клсса цвет
        g.setColor(bacColor);// передаём цвет граф объекту

        if (Panel.state.equals(Panel.STATES.MENUE)) g.fillRect(0, 0, Panel.WIDTH, Panel.HEIGHT);//рисуем прямоугольную область
        if (Panel.state.equals(Panel.STATES.PLAY)) {
            g.drawImage(img, (int) 0, (int) 0, null);//отрисовываем элемент в координатах
        }

    }


}
