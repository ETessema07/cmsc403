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
    static String winner;
    static boolean endRace = false;

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

    public void buttons(){
        rand = new Random();

        start.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                go =true;
                endRace=false;
                racer1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        rand = new Random();
                        while(go){
                            try {
                                int random = rand.nextInt(11);
                                car1+=random;
                                haveWinner();
                                if(!endRace) {
                                    repaint();
                                }
                                Thread.sleep(50);
                            }catch (InterruptedException l){

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
                                int random = rand.nextInt(11);
                                car2+=random;
                                Thread.sleep(50);
                            }catch (InterruptedException l){

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
                                int random = rand.nextInt(11);
                                car3+=random;
                                Thread.sleep(50);
                            }catch (InterruptedException l){

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

                go = false;
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car1=20;
                car2=20;
                car3=20;
                go = false;
                repaint();

            }
        });
    }



    public static void main(String [] strings){
        f = new JFrame();
        f.setResizable(false);
        f.setContentPane(new RaceTrack());

        f.add(p);

        f.setSize(500, 200);
        f.setTitle("Race Track");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);



    }

     public synchronized void haveWinner(){
        if (car1 >= 420 || car2 >= 420 || car3 >= 420) {
            if (car1 >= 420 && car1> car2 && car1>car3) {
                winner = "car1";
                System.out.println(winner+"has won");
            }
            else if (car2 >= 420 && car2> car1 && car2>car3) {
                winner = "car2";
                System.out.println(winner+"has won");
            }
            else if(car3 >= 420 && car3> car2 && car3>car1) {
                winner = "car3";
                System.out.println(winner+"has won");
            }
            JOptionPane.showMessageDialog(null,"the winner is:  "+ winner);
            go=false;
            endRace=true;
//            car1 = 20;
//            car2 = 20;
//            car3 = 20;
//            repaint();


        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            car = ImageIO.read(new File("sportive-car.png"));

        }catch (IOException e){
            System.out.println("wrong path for the car image, check the path in paintComponent()!");
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



    }



}
