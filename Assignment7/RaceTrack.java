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
    static BufferedImage carImage;
    static JPanel buttonsPanel;
    static JButton start;
    static JButton pause;
    static JButton reset;
    static JFrame frame;
    static int car1 = 20;
    static int car2 = 20;
    static int car3 = 20;
    static Thread racer1;
    static Thread racer2;
    static Thread racer3;
    static boolean go=true;
    static Random rand;
    static String winnerName;
    static boolean endRace = false;

    public RaceTrack(){
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        start=new JButton("Start");
        pause=new JButton("Pause");
        reset=new JButton("Reset");
        buttonListerners();
        buttonsPanel.add(start);
        buttonsPanel.add(pause);
        buttonsPanel.add(reset);
    }

    public void buttonListerners(){
        rand = new Random();

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!endRace){
                        racer1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                rand = new Random();
                                go = true;
                                while (go) {
                                    try {
                                        int random = rand.nextInt(11);
                                        car1 += random;
                                        haveWinner();
                                        if (!endRace) {
                                            repaint();
                                        }
                                        Thread.sleep(50);
                                    } catch (InterruptedException l) {

                                    }
                                }
                            }
                        });
                    racer1.start();

                    racer2 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            rand = new Random();
                            while (go) {
                                try {
                                    int random = rand.nextInt(11);
                                    car2 += random;
                                    Thread.sleep(50);
                                } catch (InterruptedException l) {

                                }
                            }
                        }
                    });
                    racer2.start();

                    racer3 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            rand = new Random();
                            while (go) {
                                try {
                                    int random = rand.nextInt(11);
                                    car3 += random;
                                    Thread.sleep(50);
                                } catch (InterruptedException l) {

                                }
                            }
                        }
                    });
                    racer3.start();


                }
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
                endRace=false;
                repaint();

            }
        });
    }



    public static void main(String [] strings){
        frame = new JFrame();
        frame.setResizable(false);
        frame.setContentPane(new RaceTrack());

        frame.add(buttonsPanel);

        frame.setSize(500, 200);
        frame.setTitle("Race Track");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }

     public synchronized void haveWinner(){

        if (car1 >= 425 || car2 >= 425 || car3 >= 425) {
            if (car1 >= 425 && car1> car2 && car1>car3) {
                winnerName = "car1";
            }
            else if (car2 >= 425 && car2> car1 && car2>car3) {
                winnerName = "car2";
            }
            else if(car3 >= 425 && car3> car2 && car3>car1) {
                winnerName = "car3";
            }
            JOptionPane.showMessageDialog(null,"the winner is:  "+ winnerName);
            go = false;
            endRace=true;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            carImage = ImageIO.read(new File("sportive-car.png"));

        }catch (IOException e){
            System.out.println("\n\n Wrong path for the car image, check the path in paintComponent()!");
            System.exit(0);
        }

        g.setColor(Color.GRAY);

        g.drawRect(53,50,400,10);
        g.drawRect(53,100,400,10);
        g.drawRect(53,150,400,10);
        g.fillRect(53,50,400,10);
        g.fillRect(53,100,400,10);
        g.fillRect(53,150,400,10);
        g.drawImage(carImage, car1, 39, this);
        g.drawImage(carImage,car2,89, this);
        g.drawImage(carImage,car3,139, this);



    }



}
