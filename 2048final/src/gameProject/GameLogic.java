package gameProject;

import javax.swing.*;
import java.awt.*;


public class GameLogic {

    public static Audio a_enem = new Audio("sound/sound.wav", 0.8);

    private int arr[][] = new int [7][6];
    private int mainFlag;
    private int flag3;
    private int count;
    private String score;
    // стаич прем - кавиши перемещения
    public static boolean keyOne;
    public static boolean keyTwo;
    public static boolean keyThree;
    public static boolean keyFour;
    public static boolean keyFive;
    public static boolean keySix;
    public static boolean esc;

    public Color color1;// цвет

    //картинки плиток
    Image img1 = new ImageIcon("image/one.png").getImage();
    Image img2 = new ImageIcon("image/two.png").getImage();
    Image img3 = new ImageIcon("image/three.png").getImage();
    Image img4 = new ImageIcon("image/four.png").getImage();
    Image img5 =  new ImageIcon("image/five.png").getImage();
    Image img6 = new ImageIcon("image/six.png").getImage();


    // Constructor
    public GameLogic(){
        // нач знач клавиш
       keyOne = false;
        keyTwo = false;
        keyThree = false;
        keyFour = false;
        keyFive = false;
        keySix = false;
        esc = false;
        score = "";
        color1 = Color.blue;
        flag3=1;
        mainFlag = 0;
        count =0;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = 0;
            }
        }

    }


    void swipePizza(int ms[][], int k)  //алгоритм передвижения куска от главной пиццы к выбранной
    {
        int ind;
      for (int i=0;i<6;i++) {
          if (ms[0][i] == 1 && ms[k][i]!=1) {
            ms[k][i]=1;

          }
          else if(ms[0][i] == 1 && ms[k][i]==1 && k!=0){
              mainFlag=1;
          }
      }

    }
    void newPiece (int ms[][]){               //алгоритм появления новых кусков в главной пицце
        int fg = 0;
        int rand;
        for (int i=0;i<6; i++){
            ms[0][i]=0;
        }
                rand = (int) (Math.random() * 6);
       ms[0][rand]=1;
    }

    // обновления
    public void update(){
        int key = 0;
        int ind=0;
        if (mainFlag==0) {
            if (flag3 == 1) {
                newPiece(arr);

                for (int i = 0; i < 6; i++) {
                    if (arr[0][i] == 1) {
                        ind = i;
                    }
                }
                mainFlag = 1;
                for (int i = 1; i < 7; i++) {
                    if (arr[i][ind] == 0) {
                        mainFlag = 0;
                    }
                }
                flag3 = 0;
            }
                if (keyOne) {
                    a_enem.sound();
                    a_enem.setVolume();
                    key = 1;
                    flag3 = 1;
                    keyOne = false;
                } else if (keyTwo) {
                    a_enem.sound();
                    a_enem.setVolume();
                    key = 2;
                    flag3 = 1;
                    keyTwo = false;
                } else if (keyThree) {
                    a_enem.sound();
                    a_enem.setVolume();
                    key = 3;
                    flag3 = 1;
                    keyThree = false;
                } else if (keyFour) {
                    a_enem.sound();
                    a_enem.setVolume();
                    key = 4;
                    flag3 = 1;
                    keyFour = false;
                } else if (keyFive) {
                    a_enem.sound();
                    a_enem.setVolume();
                    key = 5;
                    flag3 = 1;
                    keyFive = false;
                } else if (keySix) {
                    a_enem.sound();
                    a_enem.setVolume();
                    key = 6;
                    flag3 = 1;
                    keySix = false;
                }
            swipePizza(arr, key);
            int ff = 0;
            for (int i = 0; i < 6; i++) {
                if (arr[key][i] == 0) {
                    ff = 1;
                }
            }
            if (ff == 0) {
                for (int i = 0; i < 6; i++) {
                    arr[key][i] = 0;
                }
            }
        }
    }

    // отрисовка клеток
    public void draw(Graphics2D g){
        for (int i =0; i<7; i++){
            int k = i*130;
            for (int j = 0; j<6; j++){
               if (arr[i][j] == 1 && j == 0){
                    g.drawImage(img1,(int)k+90,(int)187,null); // здесь рисуем картинку
                }
             if (arr[i][j] == 1 && j==1){
                    g.drawImage(img2,(int)k+89,(int)215,null); // здесь рисуем картинку
                }
                if (arr[i][j] == 1 && j==2){
                    g.drawImage(img3,(int)k+90,(int)246,null); // здесь рисуем картинку
               }
                if (arr[i][j] == 1 && j==3){
                    g.drawImage(img4,(int)k+42,(int)246,null); // здесь рисуем картинку
                }
               if (arr[i][j] == 1 && j==4){
                    g.drawImage(img5,(int)k+34,(int)215,null); // здесь рисуем картинку
                }
               if (arr[i][j] == 1 && j==5){
                    g.drawImage(img6,(int)k+43,(int)187,null); // здесь рисуем картинку
                }

            }
        }
       // g.fillRect(35,0,700,100);
        Font font = new Font("Arial", Font.ITALIC, 120);//Создём объект класса фонт (передаем в конструктор параметры)
        g.setColor(color1);//задаем цвет объекту Соlor
        g.setFont(font);//устанвливаем наш шрифт
        g.drawString(score, (int) 80, (int) 90);// рисуем строчку в центре панели
        if (mainFlag == 1) {
            String mes1 = "game over";
            String mes2 = "press esc";
            g.drawString(mes1, (int) 45, (int) 415);// рисуем строчку в центре панели
            g.drawString(mes2, (int) 60, (int) 515);// рисуем строчку в центре панели
        }
        if (esc) {
            mainFlag=0;
            Image img = new ImageIcon("image/background.png").getImage();//загрузка картинки
            g.drawImage(img, (int) 0, (int) 0, null);
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 6; j++) {
                    arr[i][j] = 0;
                }
            }
            arr[0][1]=1;
            esc = false;
        }

    }
}
