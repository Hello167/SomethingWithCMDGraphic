import java.util.ArrayList;

public class Main {
    public static Window main = new Window(120,30); // Создаем окно

    public static void main(String[] args) {
        main.windowOut();
    }
}

//                                    |                         |
// -----------------------------------V How that work down here V-------------------------------------------------------------
//

class Window{
    int WIN_HEIGHT, WIN_WIDTH, WIN_RATIO, WIN_LENGTH;                 // Объявление переменных: высоты, ширины, соотношения сторон и кол-во всех пикселей в окне
    ArrayList<Pixel> pixels = new ArrayList<>();
    char[] buf = new char[WIN_LENGTH];

    Window(int win_width, int win_height){
        this.WIN_WIDTH  = win_width;
        this.WIN_HEIGHT = win_height;

        WIN_RATIO  = win_width  / win_height;                         // Отношение сторон (В одной строке 40 символов)
        WIN_LENGTH = win_width  * win_height;                          // Всего  символов на экране
    }

    class Pixel{
        char name;                                                    // Какой это символ
        int index;
        int x = xCoord();
        int y = yCoord();


        Pixel(char Name){
            this.name = Name;
        }

        char show(){
            return this.name;                                         // Показываем каким символом является пиксель
        }

        void showInfo(){
            System.out.println("\n" + "index: " + index + ", x: " + xCoord() + ", y: " + yCoord());
        }

        int xCoord(){
            return this.index % WIN_RATIO;
        }

        int yCoord(){
            double thing = (double) this.index / (double)WIN_RATIO;
            return (int)Math.ceil(thing);
        }

    }



    void clear(){
        for(int i = 0; WIN_LENGTH>i; i++){
            pixels.add(new Pixel('@'));
            pixels.get(i).index = i;
        }
    }

    void windowOut(){
            while (true){
                clear();

                for(Pixel pixel: pixels){
                    System.out.print(pixel.show());
                }

            }
    }
}

