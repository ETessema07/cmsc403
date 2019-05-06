import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class RaceTrack extends JPanel{
    static BufferedImage car;
    static JPanel p;
    static JButton start;
    static JButton pause;
    static JButton reset;
    static JFrame f;
    static int car1 = 20;
    static int car2 = 20;
    static int car3 = 20;
    static Thread racer1;
    static Thread racer2;
    static Thread racer3;
    static boolean go=true;
    static Random rand;

    public RaceTrack(){
        p = new JPanel();
        p.setLayout(new FlowLayout());
        start=new JButton("Start");
        pause=new JButton("Pause");
        reset=new JButton("Reset");
        buttons();
        p.add(start);
        p.add(pause);
        p.add(reset);
    }

    public static void buttons(){
        rand = new Random();
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                go =true;
                racer1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        rand = new Random();
                        while(go){
                            try {
                                int random = rand.nextInt(11)+1;
                                car1+=random;
                                Thread.sleep(1000);
                            }catch (InterruptedException l){
                                return;
                            }
                        }
                    }
                });
                racer1.start();

                racer2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        rand = new Random();
                        while(go){
                            try {
                                int random = rand.nextInt(11)+1;
                                car2+=random;
                                Thread.sleep(1000);
                            }catch (InterruptedException l){
                                return;
                            }
                        }
                    }
                });
                racer2.start();

                racer3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        rand = new Random();
                        while(go){
                            try {
                                int random = rand.nextInt(11)+1;
                                car3+=random;
                                Thread.sleep(1000);
                            }catch (InterruptedException l){
                                return;
                            }
                        }
                    }
                });
                racer3.start();

            }
        });
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Im pausing");
                go = false;
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Im resetting");
                car1=20;
                car2=20;
                car3=20;
                go = false;
            }
        });
    }



    public static void main(String [] strings){

        RaceTrack r = new RaceTrack();
        f = new JFrame();
        f.setContentPane(r);

        f.add(p);

        f.setSize(500, 200);
        f.setTitle("Race Track");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.repaint();
        f.setVisible(true);


    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            car = ImageIO.read(new File("sportive-car.png"));

        }catch (IOException e){
            System.out.println("wrong path for the car image, check the path in paintComponent() !");
        }

        g.setColor(Color.GRAY);

        g.drawRect(53,50,400,10);
        g.drawRect(53,100,400,10);
        g.drawRect(53,150,400,10);
        g.fillRect(53,50,400,10);
        g.fillRect(53,100,400,10);
        g.fillRect(53,150,400,10);
        g.drawImage(car, car1, 39, this);
        g.drawImage(car,car2,89, this);
        g.drawImage(car,car3,139, this);
        repaint();
    }


//    @Override
//    public synchronized void run() {
//        start.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                    System.out.println("Im starting");
//                    d += 10;
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException a) {
//
//                    }
//
//            }
//        });
//    }
}
